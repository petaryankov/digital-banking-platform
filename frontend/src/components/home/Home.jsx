import { Link } from "react-router";

export default function Home() {
  return (
    <div className="min-h-screen bg-gray-900 text-white flex flex-col">

      {/* Header */}
      <header className="flex justify-between items-center px-8 py-6 border-b border-gray-800">
        <h1 className="text-xl font-bold">
          Digital Banking Platform
        </h1>

        <div className="space-x-4">
          <Link
            to="/login"
            className="text-sm font-semibold text-indigo-400 hover:text-indigo-300"
          >
            Login
          </Link>

          <Link
            to="/register"
            className="text-sm font-semibold text-indigo-400 hover:text-indigo-300"
          >
            Register
          </Link>
        </div>
      </header>

      {/* Hero section */}
      <main className="flex flex-1 items-center justify-center text-center px-6">
        <div>
          <h2 className="text-4xl font-bold mb-6">
            Secure. Modern. Digital Banking.
          </h2>

          <p className="text-gray-400 mb-8">
            Manage your accounts, transfer funds, and monitor transactions securely.
          </p>

          <Link
            to="/login"
            className="bg-indigo-500 hover:bg-indigo-400 px-6 py-3 rounded-md font-semibold"
          >
            Get Started
          </Link>
        </div>
      </main>

    </div>
  );
}
