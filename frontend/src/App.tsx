import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import Navbar from './components/Navbar.tsx';
import About from './pages/About.tsx';
import Home from './pages/Home.tsx'; // Import Home component
import Contacts from './pages/Contacts.tsx';
import RegisterAccount from './pages/RegisterAccount.tsx';
import Login from './pages/Login.tsx';
import Checkout_page from './pages/Checkout_page.tsx';
import RemoveItem from './pages/RemoveItem.tsx';
import Payment_page from './pages/Payment_page.tsx';
import Confirmation_page from './pages/Confirmation_page.tsx';
import logout from './pages/logout.tsx';
import TrackOrder from './pages/TrackOrder.tsx';
import Driver_home from './pages/Driver_home.tsx';
import Admin_home from './pages/Admin_home.tsx';


const App: React.FC = () => {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route index element={<Home />} /> 
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/Contacts" element={<Contacts />} />
        <Route path="/RegisterAccount" element={<RegisterAccount />} />
        <Route path="/Login" element={<Login />} />
        <Route path="/Confirmation_page" element={<Confirmation_page />} />
        <Route path="/Checkout_page" element={<Checkout_page />} />
        <Route path="/RemoveItem" element={<RemoveItem />} />
        <Route path="/Payment_page" element={<Payment_page />} />
        <Route path="/logout" element={<logout />} />
        <Route path="/TrackOrder" element={< TrackOrder/>} />
        <Route path="/Driver_home" element={< Driver_home />} />
        <Route path="/Admin_home" element={< Admin_home />} />
      </Routes>
    </Router>
  );
};

export default App;