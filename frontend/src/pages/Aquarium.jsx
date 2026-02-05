import { useParams } from "react-router-dom";
import { AquariumProvider } from "../components/aquarium/AquariumContext";
import AquariumState from "../components/aquarium/AquariumState";
import AquariumFish from "../components/aquarium/AquariumFish";

const Aquarium = ({ }) => {
    const { id } = useParams();
    return (
        <AquariumProvider idAquarium={id}>
            <div className="w-full flex flex-col gap-4 py-4">
                <AquariumState />

                <div className="flex w-full flex-col gap-2">
                    <AquariumFish />
                </div>
            </div>
        </AquariumProvider>
    );
};

export default Aquarium;