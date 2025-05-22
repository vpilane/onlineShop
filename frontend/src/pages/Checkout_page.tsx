import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import './HomeCss.css';
import 'bootstrap/dist/css/bootstrap.min.css';

const Checkout_page: React.FC = () => {
  const rawProducts = JSON.parse(localStorage.getItem("cartItems") || "[]");
  const products = rawProducts.map((item: string) => {
    const [name, price, img] = item.split("|");
    return { name, price, img };
  });

  const navigate = useNavigate();
  const [quantities, setQuantities] = useState<number[]>(products.map(() => 1));
  const [name, setName] = useState("");
  const [checkedItems, setCheckedItems] = useState<boolean[]>(products.map(() => false));

  useEffect(() => {
    console.log("useEffect called");
  }, [name]);

  const handleQuantityChange = (idx: number, newValue: number) => {
    setQuantities((prev) =>
      prev.map((q, i) => (i === idx ? newValue : q))
    );
  };

  // Calculate grand total
  const grandTotal = products.reduce(
    (sum, product, idx) => sum + Number(product.price) * quantities[idx],
    0
  );

  // Update checkbox in your map:
  const handleCheckboxChange = (idx: number, checked: boolean) => {
    const updated = [...checkedItems];
    updated[idx] = checked;
    setCheckedItems(updated);
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Store only the grand total for payment
    localStorage.setItem("grandTotal", grandTotal.toFixed(2));
    navigate("/Payment_page");
  };

  const handleRemove = (e: React.FormEvent) => {
    e.preventDefault();
    // Keep only unchecked items
    const remainingItems = products
      .map(p => `${p.name}|${p.price}|${p.img}`)
      .filter((_, idx) => !checkedItems[idx]);
    localStorage.setItem("cartItems", JSON.stringify(remainingItems));
    setCheckedItems(remainingItems.map(() => false)); // reset checked state
    window.location.reload(); // reload to update the list
  };

  const handleCheckout = (e: React.FormEvent) => {
    e.preventDefault();
    // Proceed with all items in cart
    alert("Proceeding to checkout!");
    // navigate("/YourCheckoutPage"); // or your checkout logic
  };

  return (
    <div className="home-container">
      <h1 className="display-4 mb-4">Welcome<br />{name}</h1>

      {/* Product Form */}
      <form onSubmit={handleSubmit} className="card p-4 shadow-sm">
        <input type="hidden" id="username" name="username" value={name} />
        <div className="row row-cols-1 row-cols-md-3 g-4">
          {products.map((product, idx) => {
            const total = Number(product.price) * quantities[idx];
            return (
              <div className="col" key={idx}>
                <div className="card h-100 text-center">
                  <label className="p-3">
                    <input
                      type="checkbox"
                      name="items"
                      value={`${product.name}|${product.price}|${product.img}`}
                      className="form-check-input mb-2"
                      checked={checkedItems[idx]}
                      onChange={(e) => handleCheckboxChange(idx, e.target.checked)}
                    />
                    <img
                      src={product.img}
                      alt={product.name}
                      className="img-fluid mb-2 product-img"
                    />
                    <div className="fw-bold">{product.name}</div>
                    <div className="price text-success">R{product.price}</div>
                    <input
                      type="number"
                      min={1}
                      value={quantities[idx]}
                      onChange={(e) => handleQuantityChange(idx, Number(e.target.value))}
                      className="form-control mt-2"
                    />
                    <div className="mt-2">
                      <span className="fw-bold">Total: </span>
                      <span className="text-primary">R{total.toFixed(2)}</span>
                    </div>
                  </label>
                </div>
              </div>
            );
          })}
        </div>
        {/* Grand Total Label */}
        <div className="text-end mt-4 me-2">
          <h5>
            Grand Total: <span className="text-success">R{grandTotal.toFixed(2)}</span>
          </h5>
        </div>
        <div className="text-center mt-4">
          <input type="submit" value="Check Out" className="btn btn-success px-4 me-3" />
          
        </div>
      </form>
    </div>
  );
};

export default Checkout_page;
