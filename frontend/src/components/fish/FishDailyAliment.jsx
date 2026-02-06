import { useFetch } from "../../hooks/useHttpRequest";
import { API_URL } from "../../lib/const";
import FishDailyNutrient from "./FishDailyNutrient";
import { unit } from "../../lib/const";

const FishDailyAliment = ({ id_fdf }) => {

    const { data: fdas, loading: loadingFdas, error: errorFdas, refetch: refetchFdas } = useFetch(`${API_URL}/fdfs/${id_fdf}/aliments`);

    return (

        <ul class="list bg-base-100 pb-2">

            <li class="p-4 pb-2 text-xs opacity-60 tracking-wide">aliments</li>

            {fdas?.map((fda, i) => (
                <li class="flex flex-col px-4 gap-2 mt-2 mb-2">
                    <div className="capitalize flex w-full h-full items-center gap-2 font-poppins-m">
                        <span>
                            {fda.aliment}
                        </span>
                        <span>
                            {fda.qtt}{unit}
                        </span>
                    </div>
                    <div class="list-col-wrap text-xs px-4">
                        <FishDailyNutrient fdns={fda.fdns} />
                    </div>
                </li>
            ))}

        </ul>

    );
};

export default FishDailyAliment;
