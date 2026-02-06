import { useFetch } from "../../hooks/useHttpRequest";
import { API_URL } from "../../lib/const";
import { unit } from "../../lib/const";

const FishDailyNutrient = ({ fdns }) => {

    return (
        <>
            {fdns?.map((fdn, i) => (
                <li class="flex flex-col px-4 gap-2 mt-2 mb-4">
                    <div className="capitalize flex w-full h-full items-center gap-2 font-poppins-m">
                        <span>
                            {fdn.nutrient}
                        </span>
                        <span>
                            {fdn.qtt}{unit}
                        </span>
                    </div>
                </li>
            ))}
        </>
    );
};

export default FishDailyNutrient;
