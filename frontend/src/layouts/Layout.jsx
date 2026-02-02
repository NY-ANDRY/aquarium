import { Outlet } from "react-router-dom";
import Header from "./Header";

const Layout = ({ children }) => {
  return (
    <div className="min-h-screen flex flex-col font-figtree text-neutral-800">
      <Header />

      <main className="flex-1 relative overflow-hidden px-6">
        {children ?? <Outlet />}
      </main>
    </div>
  );
};

export default Layout;
