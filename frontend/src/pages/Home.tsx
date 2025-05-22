import React, { useState, useEffect } from 'react';
import { Link, Navigate, useNavigate } from 'react-router-dom';
import './HomeCss.css';
import 'bootstrap/dist/css/bootstrap.min.css';

const products = [
  { name: "Rice 2kg", price: "34.99", img: "rice.jpeg" },
  { name: "Omo 2kg", price: "54.99", img: "omo.webp" },
  { name: "Tomato Sauce 750ml", price: "32.99", img: "tomatoS.webp" },
  { name: "Mayonnaise 750ml", price: "37.99", img: "mayonnaise.webp" },
  { name: "Maize Meal 2.5kg", price: "44.99", img: "maize.jpeg" },
  { name: "Lux 175g", price: "18.99", img: "lux.webp" },
  { name: "Koo beans 400g", price: "12.49", img: "koo.jpeg" },
];

const Home: React.FC = () => {
  const [name, setName] = useState("");
  const [selectedItems, setSelectedItems] = useState<string[]>([]);
  const navigate = useNavigate();

  useEffect(() => {
    console.log("useEffect called");
  }, [name]);

  const handleCheckboxChange = (value: string, checked: boolean) => {
    setSelectedItems((prev) =>
      checked ? [...prev, value] : prev.filter((item) => item !== value)
    );
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    localStorage.setItem("cartItems", JSON.stringify(selectedItems));
    console.log(localStorage.getItem("cartItems"));
    alert("Selected items have been saved to local storage!");
    navigate("/Checkout_page");
    // Optionally, you can submit the form to the server here if needed
  };

  return (
    <div className="home-container">
      <h1 className="display-4 mb-4">Welcome<br />{name}</h1>

      {/* Product Form */}
      <form onSubmit={handleSubmit} className="card p-4 shadow-sm">
        <input type="hidden" id="username" name="username" value={name} />
        <div className="row row-cols-1 row-cols-md-3 g-4">
          {products.map((product, idx) => {
            const value = `${product.name}|${product.price}|${product.img}`;
            const isSelected = selectedItems.includes(value);
            return (
              <div className="col" key={idx}>
                <div
                  className={`card h-100 text-center ${isSelected ? "bg-success text-white border-success" : ""}`}
                  style={{ cursor: "pointer" }}
                  onClick={() =>
                    handleCheckboxChange(
                      value,
                      !isSelected
                    )
                  }
                >
                  {/* Hidden checkbox for accessibility, but not visible */}
                  <input
                    type="checkbox"
                    name="items"
                    value={value}
                    checked={isSelected}
                    readOnly
                    style={{ display: "none" }}
                    tabIndex={-1}
                    aria-hidden="true"
                  />
                  <img
                    src={product.img}
                    alt={product.name}
                    className="img-fluid mb-2 product-img"
                  />
                  <div className="fw-bold">{product.name}</div>
                  <div className="price">{isSelected ? <span className="text-white">R{product.price}</span> : <span className="text-success">R{product.price}</span>}</div>
                </div>
              </div>
            );
          })}
        </div>
        <div className="text-center mt-4">
          <input type="submit" value="Add to Cart" className="btn btn-success px-4" />
        </div>
      </form>
    </div>
  );
};

export default Home;