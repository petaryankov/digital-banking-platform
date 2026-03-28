import { useContext } from "react";
import { AuthContext } from "../../contexts/AuthContext";
import { Navigate, Outlet } from "react-router";

export default function AdminGuard () {
    const { accessToken, role } = useContext(AuthContext);

    // if not authenticated, redirect to login
    if (!accessToken) {
        return <Navigate to="/login" replace />;
    }

    // if authenticated but not admin, redirect to dashboard
    if (role !== "ADMIN") {
        return <Navigate to="/dashboard" replace />;
    }

    // if authenticated and admin, render the protected component
    return <Outlet />;
}