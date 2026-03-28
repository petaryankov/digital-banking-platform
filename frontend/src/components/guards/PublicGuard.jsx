import { useContext } from "react";
import { Navigate, Outlet } from "react-router";
import { AuthContext } from "../../contexts/AuthContext";

export default function PublicGuard() {

    const {accessToken, role} = useContext(AuthContext)

    // if authenticated, redirect to dashboard or admin page based on role
    if (accessToken) {
        if (role === "ADMIN") {
            return <Navigate to="/admin" replace />;
        } else {
            return <Navigate to="/dashboard" replace />;
        }
    }

    // if not authenticated, render the public component
    return <Outlet />;
        
}