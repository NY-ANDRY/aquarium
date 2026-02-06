import { useFetch } from "../../hooks/useHttpRequest";
import { API_URL } from "../../lib/const";
import { unit } from "../../lib/const";

const FishDailyNutrientTotal = ({ id_fdf }) => {

    const { data: fdnTotal, loading: loadingFdas, error: errorFdas, refetch: refetchFdas } = useFetch(`${API_URL}/fdfs/${id_fdf}/nutrients`);

    return (

        <ul class="list bg-base-100 pb-2">

            <li class="p-4 pb-2 text-xs opacity-60 tracking-wide">nutrients</li>

            {fdnTotal?.map((fdnT, i) => (
                <li class="flex flex-col px-4 gap-2 mt-2 mb-2">
                    <div className="capitalize flex w-full h-full items-center gap-2 font-poppins-m">
                        <span>
                            {fdnT.nutrient}:
                        </span>
                        <span>
                            {fdnT.qtt}
                        </span>
                    </div>
                    <div className="pl-8 capitalize flex w-full h-full items-center gap-2 whitespace-nowrap">
                        today: {fdnT.cur}
                    </div>
                    <div className="pl-8 capitalize flex w-full h-full items-center gap-2 whitespace-nowrap">
                        before today: {fdnT.rest}
                    </div>
                    <div className="pl-8 capitalize flex w-full h-full items-center gap-2 whitespace-nowrap">
                        race need: {fdnT.raceNeed}
                    </div>
                    <div className="pl-8 flex w-full h-full items-center gap-2 whitespace-nowrap">
                        {fdnT.qtt} / {fdnT.raceNeed} = {fdnT.subNb} fois
                    </div>
                    <div className="pl-8 capitalize flex w-full h-full items-center gap-2 whitespace-nowrap">
                        {fdnT.subNb} * {fdnT.subWeight} =
                        <span className="font-poppins-b text-lg">{fdnT.weightInc}{unit}</span>
                    </div>
                </li>
            ))}

        </ul>

    );
};

export default FishDailyNutrientTotal;
