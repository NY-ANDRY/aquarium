import { useFishContext } from "./FishContext";
import { formatDateFr } from "../../lib/utils";
import { useState } from "react";
import FishDailyAliment from "./FishDailyAliment";
import FishDailyNutrientTotal from "./FishDailyNutrientTotal";

const FishDailyFeed = ({ }) => {
    const { fdfs } = useFishContext();
    const [selectedFdfAliment, setSelectedFdfAliment] = useState("");

    const handleSelectAliment = (fdf) => {
        setSelectedFdfAliment(fdf.id_fdf);
        document.getElementById('fishDailyAlimentModal').showModal();
    }

    const [selectedFdfNutrientTotal, setSelectedFdfNutrientTotal] = useState("");
    const handleSelectNutrient = (fdf) => {
        setSelectedFdfNutrientTotal(fdf.id_fdf);
        document.getElementById('fishDailyNutrimentTotalModal').showModal();
    }

    return (

        <div className="w-full flex flex-col gap-8">
            <div className="overflow-x-auto">
                <table className="table">
                    <thead>
                        <tr>
                            <th>Date</th>
                            <th>increase</th>
                            <th>weight</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {fdfs?.map((history, i) => (
                            <tr key={history}>
                                <td>{formatDateFr(history.date)}</td>
                                <td>{history.increase}</td>
                                <td>{history.weight}</td>
                                <td>
                                    <div className="flex gap-2 justify-end">
                                        <button onClick={() => { handleSelectAliment(history) }} className="btn btn-xs">aliment</button>
                                        <button onClick={() => { handleSelectNutrient(history) }} className="btn btn-xs">nutriment</button>
                                    </div>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>

            <dialog id="fishDailyAlimentModal" className="modal">
                <div className="modal-box p-1 w-96">
                    <h3 className="font-bold text-lg"></h3>
                    <FishDailyAliment id_fdf={selectedFdfAliment} />
                </div>
                <form method="dialog" className="modal-backdrop">
                    <button>close</button>
                </form>
            </dialog>


            <dialog id="fishDailyNutrimentTotalModal" className="modal">
                <div className="modal-box p-1 w-96">
                    <h3 className="font-bold text-lg"></h3>
                    <FishDailyNutrientTotal id_fdf={selectedFdfNutrientTotal} />
                </div>
                <form method="dialog" className="modal-backdrop">
                    <button>close</button>
                </form>
            </dialog>
        </div>

    );
};

export default FishDailyFeed;
