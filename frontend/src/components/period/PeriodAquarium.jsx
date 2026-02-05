import { Link } from "react-router-dom";
import { usePeriodContext } from "./PeriodContext";

const PeriodAquarium = ({ }) => {
    const { aquariums, loadingAquariums: loading, errorAquariums: error, idPeriod } = usePeriodContext();

    // if (loading) return <p>Chargement...</p>;
    // if (error) return <p>Erreur : {error.message}</p>;

    return (
        <ul className="list bg-base-100 rounded-box shadow-md">

            <li className="p-4 pb-2 text-xs opacity-60 tracking-wide">Aquariums</li>
            {aquariums?.map((aquarium, i) => (
                <Link to={`/aquariums/${aquarium?.id}`} key={aquarium.id}>
                    <li className="list-row">
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
                    </li>
                </Link>
            ))}

        </ul>)
}

export default PeriodAquarium;