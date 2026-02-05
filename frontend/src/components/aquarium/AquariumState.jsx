import { useAquariumContext } from "./AquariumContext";

const AquariumState = ({ }) => {
    const { aquarium } = useAquariumContext();

    return (

        <div className="flex items-center justify-between">
            <div className="flex items-center font-poppins-b uppercase text-xl">
                <div>{aquarium?.name}</div>
            </div>
            <div className="flex"></div>
            <div className="flex items-center justify-between gap-2 w-28">
                <div className="flex text-sm text-neutral-400">
                    nb poisson:
                </div>
                <div className="flex text-xl font-poppins-m">
                    {aquarium?.nb_poisson}
                </div>
            </div>
        </div>

    );
};

export default AquariumState;
