import { Outlet } from "react-router-dom";
import Header from "./Header";

const Layout = ({ children }) => {
  return (
    <div data-theme="light" className="min-h-screen min-w-screen flex flex-col font-figtree text-neutral-800 items-center">
      <div className="flex items-center justify-center w-275">
        <Header />
      </div>

      <main className="flex-1 relative overflow-hidden px-0 flex flex-col items-center w-275">
        {children ?? <Outlet />}
      </main>
    </div>
  );
};

export default Layout;
