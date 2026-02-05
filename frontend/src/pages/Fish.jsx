import { useParams } from "react-router-dom";
import { FishProvider } from "../components/fish/FishContext";
import FishState from "../components/fish/FishState";

const Fish = ({ }) => {
    const { id } = useParams();
    return (
        <FishProvider idFish={id}>
            <div className="w-full flex flex-col gap-4 py-4">
                <FishState />
            </div>
        </FishProvider>
    );
};

export default Fish;