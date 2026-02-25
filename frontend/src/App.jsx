import { Routes, Route } from 'react-router';
import Dashboard from './components/dashboard/Dashboard';
import Login from './components/users/login/Login';
import Register from './components/register/Register';
import Home from './components/home/Home';
import './App.css';

function App() {


  return (
    <>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/register" element={<Register />} />
      </Routes>
    </>
  )
}

export default App;
