import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import './HomeCss.css';
import 'bootstrap/dist/css/bootstrap.min.css';

const Admin_home: React.FC = () => {
  const [accounts, setAccounts] = useState<any[]>([]);
  const [shops, setShops] = useState<any[]>([]);
  const [items, setItems] = useState<any[]>([]);
  const [newShop, setNewShop] = useState({ name: "" });
  const [newItem, setNewItem] = useState({ name: "", price: "", shopId: "" });

  useEffect(() => {
    // Fetch all accounts
    fetch("http://localhost:8080/getAllAccounts")
      .then(res => res.json())
      .then(setAccounts);

    // Fetch all shops
    fetch("http://localhost:8080/getAllShops")
      .then(res => res.json())
      .then(setShops);

    // Fetch all items
    fetch("http://localhost:8080/getAllItems")
      .then(res => res.json())
      .then(setItems);
  }, []);

  // Edit account handler (example: update role)
  const handleAccountEdit = async (id: string, updatedData: any) => {
    await fetch(`http://localhost:8080/updateAccount/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(updatedData),
    });
    // Refresh accounts
    const updatedAccounts = await fetch("http://localhost:8080/getAllAccounts").then(res => res.json());
    setAccounts(updatedAccounts);
  };

  // Add new shop
  const handleAddShop = async (e: React.FormEvent) => {
    e.preventDefault();
    await fetch("http://localhost:8080/addStore", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newShop),
    });
    setNewShop({ name: "" });
    const updatedShops = await fetch("http://localhost:8080/getAllShops").then(res => res.json());
    setShops(updatedShops);
  };

  // Add new item
  const handleAddItem = async (e: React.FormEvent) => {
    e.preventDefault();
    await fetch("http://localhost:8080/addItem", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newItem),
    });
    setNewItem({ name: "", price: "", shopId: "" });
    const updatedItems = await fetch("http://localhost:8080/getAllItems").then(res => res.json());
    setItems(updatedItems);
  };

  return (
    <div className="home-container">
      <h1 className="display-4 mb-4">Admin Menu</h1>
      <div className="container mt-4">

        {/* Edit Accounts */}
        <h3>Edit Accounts</h3>
        <table className="table table-bordered table-sm">
          <thead>
            <tr>
              <th>Username</th>
              <th>Role</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {accounts.map((acc, idx) => (
              <tr key={idx}>
                <td>{acc.username}</td>
                <td>
                  <input
                    type="text"
                    value={acc.role}
                    onChange={e => {
                      const updated = [...accounts];
                      updated[idx].role = e.target.value;
                      setAccounts(updated);
                    }}
                  />
                </td>
                <td>
                  <button
                    className="btn btn-primary btn-sm"
                    onClick={() => handleAccountEdit(acc.id, { role: acc.role })}
                  >
                    Save
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>

        {/* Add Shop */}
        <h3>Add New Shop</h3>
        <form onSubmit={handleAddShop} className="mb-4">
          <input
            type="text"
            placeholder="Shop Name"
            value={newShop.name}
            onChange={e => setNewShop({ name: e.target.value })}
            required
            className="form-control d-inline w-auto me-2"
          />
          <button type="submit" className="btn btn-success btn-sm">Add Shop</button>
        </form>

        {/* Add Item */}
        <h3>Add New Item</h3>
        <form onSubmit={handleAddItem}>
          <input
            type="text"
            placeholder="Item Name"
            value={newItem.name}
            onChange={e => setNewItem({ ...newItem, name: e.target.value })}
            required
            className="form-control d-inline w-auto me-2"
          />
          <input
            type="number"
            placeholder="Price"
            value={newItem.price}
            onChange={e => setNewItem({ ...newItem, price: e.target.value })}
            required
            className="form-control d-inline w-auto me-2"
            min="0"
          />
          <label htmlFor="shop-select" className="me-2">Shop:</label>
          <select
            id="shop-select"
            value={newItem.shopId}
            onChange={e => setNewItem({ ...newItem, shopId: e.target.value })}
            required
            className="form-select d-inline w-auto me-2"
          >
            <option value="">Select Shop</option>
            {shops.map((shop, idx) => (
              <option key={idx} value={shop.id}>{shop.name}</option>
            ))}
          </select>
          <button type="submit" className="btn btn-success btn-sm">Add Item</button>
        </form>
      </div>
    </div>
  );
};

export default Admin_home;