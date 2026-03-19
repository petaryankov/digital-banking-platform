import { useNavigate } from "react-router";
import { useContext, useEffect } from "react";
import userApi from "../../api/userApi";
import { tokenService } from "../../services/tokenService";
import { AuthContext } from "../../contexts/AuthContext";

export default function Dashboard() {

  const navigate = useNavigate();

  // check authentication on component mount
  useEffect(() => {
    if (!tokenService.getAccessToken()) {
      navigate("/login", { replace: true });
    }
  }, [navigate]);

  const auth = useContext(AuthContext); 

  const handleDeleteAccount = async () => {

    const confirmDelete = window.confirm(
      "Are you sure you want to delete your account? This action cannot be undone."
    );

    if (!confirmDelete) {
      return
    };

    try {

      // call backend API to delete user
      await userApi.deleteUser();

      // remove tokens from storage
      tokenService.clearTokens();

      // update context
      auth.userLogoutHandler();

      // redirect to home page after account deletion
      navigate("/", { replace: true });

    } catch (err) {

      console.error("Error deleting account:", err);
      alert("Failed to delete account. Please try again.");
    }
  };



  return (
    <div className="min-h-screen bg-gray-900 text-white">

      {/* Content */}
      <main className="p-8">
        <h2 className="text-2xl font-bold mb-4">
          Welcome to your Digital Banking Dashboard
        </h2>

        <div className="grid grid-cols-1 md:grid-cols-3 gap-6 mt-6">

          <div className="bg-gray-800 p-6 rounded-lg">
            <h3 className="text-lg font-semibold mb-2">Account Balance</h3>
            <p className="text-gray-400">$0.00</p>
          </div>

          <div className="bg-gray-800 p-6 rounded-lg">
            <h3 className="text-lg font-semibold mb-2">Recent Transactions</h3>
            <p className="text-gray-400">No transactions yet</p>
          </div>

          <div className="bg-gray-800 p-6 rounded-lg">
            <h3 className="text-lg font-semibold mb-2">Quick Actions</h3>
            <p className="text-gray-400">Transfer, Pay Bills, Deposit</p>
          </div>

        </div>
      </main>

      <button
        onClick={handleDeleteAccount}
        className="fixed bottom-6 right-6 bg-red-600 hover:bg-red-500 text-white font-medium px-1.5 py-1.5 text-sm rounded-md shadow-md transition"
      >
        Delete Account
      </button>

    </div>
  );
}
