import { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import adminApi from "../../api/adminApi";
import { tokenService } from "../../services/tokenService";

export default function AdminDashboard() {

    // state for users
    const [users, setUsers] = useState([]);

    const navigate = useNavigate();

    // load users on mount
    useEffect(() => {

        // if no token, redirect to login
        if (!tokenService) {
            navigate("/login");
            return;
        }

        // fetch all users from API
        const loadUsers = async () => {
            try {
                const response = await adminApi.getAllUsers();

                // set users in state
                setUsers(response.data);

            } catch (err) {
                console.error("Error fetching users:", err);
            }
        };

        loadUsers();

    }, [navigate]);


    // activate user
    const handleActivate = async (id) => {
        try {
            await adminApi.activateUser(id);

            // refresh user list after activation
            setUsers(prev => 
                prev.map(user => 
                    user.id === id ? { ...user, active: true } : user));

        } catch (err) {
            console.error("Error activating user:", err);
        }
    };

    // deactivate user
    const handleDeactivate = async (id) => {
        try {
            await adminApi.deactivateUser(id);

            // refresh user list after deactivation
            setUsers(prev => 
                prev.map(user => 
                    user.id === id ? { ...user, active: false } : user));
        } catch (err) {
            console.error("Error deactivating user:", err);
        }
    };

    return (
        <div className="min-h-screen bg-gray-900 text-white p-8">

            <h1 className="text-2xl font-bold mb-6">
                Admin Dashboard
            </h1>

            {/* Users Table */}
            <div className="overflow-x-auto">
                <table className="w-full bg-gray-800 rounded-lg">

                    <thead>
                        <tr className="text-left border-b border-gray-700">
                            <th className="p-4">ID</th>
                            <th className="p-4">Email</th>
                            <th className="p-4">Full Name</th>
                            <th className="p-4">Role</th>
                            <th className="p-4">Active</th>
                            <th className="p-4">Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                        {users.map(user => (
                            <tr key={user.id} className="border-b border-gray-700">

                                <td className="p-4">{user.id}</td>
                                <td className="p-4">{user.email}</td>
                                <td className="p-4">{user.fullName}</td>
                                <td className="p-4">{user.role}</td>

                                <td className="p-4">
                                    {user.active ? (
                                        <span className="text-green-400">Active</span>
                                    ) : (
                                        <span className="text-red-400">Inactive</span>
                                    )}
                                </td>

                                <td className="p-4 space-x-2">

                                    {/* Activate */}
                                    {!user.active && (
                                        <button
                                            onClick={() => handleActivate(user.id)}
                                            className="bg-green-600 px-3 py-1 rounded hover:bg-green-700"
                                        >
                                            Activate
                                        </button>
                                    )}

                                    {/* Deactivate */}
                                    {user.active && (
                                        <button
                                            onClick={() => handleDeactivate(user.id)}
                                            className="bg-red-600 px-3 py-1 rounded hover:bg-red-700"
                                        >
                                            Deactivate
                                        </button>
                                    )}

                                </td>

                            </tr>
                        ))}
                    </tbody>

                </table>
            </div>

        </div>
    );
}