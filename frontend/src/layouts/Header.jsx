import Button from "../components/ui/Button";

const Header = ({ }) => {
    return (
        <header className="h-14 flex items-center justify-between px-6">
            <h1 className="font-poppins-b text-2xl text-neutral-900">AQUARIUM</h1>
            <div className="flex 0">
                <Button className="">NEW PERIOD</Button>
            </div>
        </header>
    );
};

export default Header;
