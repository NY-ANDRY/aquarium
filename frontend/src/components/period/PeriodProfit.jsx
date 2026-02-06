import { usePeriodContext } from "./PeriodContext";
import { useLazyFetch } from "../../hooks/useHttpRequest";
import { API_URL } from "../../lib/const";
import { useEffect, useState } from "react";
import { DayPicker } from "react-day-picker";
import { datePicktoDate } from "../../lib/utils";

const PeriodProfit = ({ }) => {
    const { idPeriod, period, summary, loadingSummary: loading, errorSummary: error } = usePeriodContext();

    const { data: dataSimul, loading: loadSimul, error: errorSimul, fetchData } = useLazyFetch(`${API_URL}/periods/${idPeriod}/summary`);

    const [date, setDate] = useState("");

    const handleSimul = async () => {
        if (!date) return;
        await fetchData({
            date: datePicktoDate(date)
        });
    };

    useEffect(() => {
        handleSimul();
    }, [date])

    return (
        <div className="flex flex-col">
            <div className="w-full stats stats-vertical lg:stats-horizontal shadow">
                <div className="stat">
                    <div className="stat-title text-sm">benefit</div>
                    <div className="stat-value">{summary?.benefit}</div>
                </div>

                <div className="stat">
                    <div className="stat-title text-sm">income</div>
                    <div className="stat-value">{summary?.income}</div>
                </div>

                <div className="stat">
                    <div className="stat-title text-sm">expense</div>
                    <div className="stat-value">{summary?.expense}</div>
                </div>
            </div>
            {period?.end && (
                <div className="flex items-center gap-2 pt-4">
                    <button popoverTarget="rdp-popover" className="input input-border input-sm w-66" style={{ anchorName: "--rdp" }}>
                        {date ? date.toLocaleDateString() : "Pick a date"}
                    </button>
                    <div popover="auto" id="rdp-popover" className="dropdown" style={{ positionAnchor: "--rdp" }}>
                        <DayPicker className="react-day-picker" mode="single" selected={date} onSelect={setDate} />
                    </div>
                </div>
            )}
            {
                dataSimul &&
                <>
                    <div className="w-full stats stats-vertical lg:stats-horizontal shadow">
                        <div className="stat">
                            <div className="stat-title text-sm">benefit</div>
                            <div className="stat-value">{dataSimul?.benefit}</div>
                        </div>

                        <div className="stat">
                            <div className="stat-title text-sm">income</div>
                            <div className="stat-value">{dataSimul?.income}</div>
                        </div>

                        <div className="stat">
                            <div className="stat-title text-sm">expense</div>
                            <div className="stat-value">{dataSimul?.expense}</div>
                        </div>
                    </div>
                </>
            }
        </div>
    )
}

export default PeriodProfit;