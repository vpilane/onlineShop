import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

const Navbar = () => {
    const navigate = useNavigate();
    // Example: check if user is logged in by checking localStorage (adjust as needed)
    const isLoggedIn = !!localStorage.getItem("loggedInUser");

    const handleLogout = () => {
        localStorage.removeItem("loggedInUser");
        navigate("/login");
    };

    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
            <div className="container">
                <Link className="navbar-brand" to="/home">Modern Tech & Partners Online Stores</Link>
                <div className="collapse navbar-collapse">
                    <ul className="navbar-nav ms-auto">
                        <li className="nav-item">
                            <Link className="nav-link" to="/home">Home</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/about">About</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/contacts">Contacts</Link>
                        </li>
                        {/* Dropdown menu */}
                        <li className="nav-item dropdown">
                            <a
                                className="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-bs-toggle="dropdown"
                                aria-expanded="false"
                            >
                                Login
                            </a>
                            <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li>
                                    <a className="dropdown-item" href="/login">Login</a>
                                </li>
                                <li>
                                    <a className="dropdown-item" href="/RegisterAccount">Sign-up</a>
                                </li>
                                <li>
                                    <a className="dropdown-item" href="/TrackOrder">Tracking goods</a>
                                </li>
                            </ul>
                        </li>
                        
                        {isLoggedIn && (
                            <li className="nav-item">
                                <button className="nav-link btn btn-link text-white" style={{textDecoration: "none"}} onClick={handleLogout}>
                                    Logout
                                </button>
                            </li>
                        )}
                    </ul>
                </div>
            </div>
        </nav>
    );
}

export default Navbar;