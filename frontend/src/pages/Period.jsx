import { useParams } from "react-router-dom";
import PeriodState from "../components/period/PeriodState";
import PeriodProfit from "../components/period/PeriodProfit";
import PeriodAquarium from "../components/period/PeriodAquarium";
import { PeriodProvider } from "../components/period/PeriodContext";

const Period = ({ }) => {
    const { id } = useParams();
    return (
        <PeriodProvider idPeriod={id}>
            <div className="w-full flex flex-col gap-4 py-4">
                <div className="flex w-full flex-col gap-2">
                    <PeriodState />
                </div>
                <div className="flex w-full flex-col gap-2">
                <PeriodProfit />
            </div>
            <div className="flex w-full flex-col gap-2">
                <PeriodAquarium />
            </div>
        </div>
        </PeriodProvider>
    );
};

export default Period;