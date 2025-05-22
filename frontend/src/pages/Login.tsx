import React, { useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";

const Login: React.FC = () => {
  const [form, setForm] = useState({ username: "", password: "" });
  const navigate = useNavigate();
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Handle login logic here
    //alert(`Username: ${form.username}\nPassword: ${form.password}`);

    fetch("http://localhost:8080/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(form),
    })
      .then(async (response) => {
        if (response.ok) {
          const data = await response.json(); // Expect backend to return { role: "Client" } or similar
          alert("Login successful!");
          localStorage.setItem("loggedInUser", form.username);
          localStorage.setItem("account", data.role); // Save role from backend
          setForm({ username: "", password: "" });

          if (data.role === "Client") {
            navigate("/Home");
          } else if (data.role === "Administrator") {
            navigate("/Admin_home");
          } else if (data.role === "Driver") {
            navigate("/Driver_home");
          }
        } else {
          alert("Login failed.");
        }
      })
      .catch((error) => {
        alert("An error occurred.");
      });
  };
  return (
    <form
      className="container mt-5 p-4 border rounded shadow bg-light login-form"
      onSubmit={handleSubmit}
    >
      <h3 className="mb-4 text-center">Login</h3>
      <div className="mb-3">
        <label htmlFor="username" className="form-label">
          Username
        </label>
        <input
          type="text"
          className="form-control"
          id="username"
          name="username"
          placeholder="Enter username"
          required
          value={form.username}
          onChange={handleChange}
        />
      </div>
      <div className="mb-3">
        <label htmlFor="password" className="form-label">
          Password
        </label>
        <input
          type="password"
          className="form-control"
          id="password"
          name="password"
          placeholder="Enter password"
          required
          value={form.password}
          onChange={handleChange}
        />
      </div>
      <button type="submit" className="btn btn-primary w-100">
        Login
      </button>
    </form>
  );
};

export default Login;