import { Link } from "react-router-dom";
import { useAquariumContext } from "./AquariumContext";

const AquariumFish = ({ }) => {
    const { fish } = useAquariumContext();

    return (
        <flex className="flex flex-col gap-4 list bg-base-100">
            <div className="flex font-poppins-m text-xl">Poisson</div>
            <div className="flex gap-2">
                {fish?.map((fish, i) => (
                    <Link to={`/fish/${fish?.id}`} key={fish.id}>
                        <div class="card w-48 bg-base-100 card-xs shadow-sm">
                            <div class="card-body flex-row justify-between items-center">
                                <h2 class="card-title capitalize">{fish?.name}</h2>
                                <div className="flex items-center gap-4 text-sm text-neutral-500">
                                    {fish.speciesName}
                                </div>
                            </div>
                        </div>
                    </Link>
                ))}
            </div>

        </flex>)
}

export default AquariumFish;