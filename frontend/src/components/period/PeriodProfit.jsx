import { usePeriodContext } from "./PeriodContext";
import { useLazyFetch } from "../../hooks/useHttpRequest";
import { API_URL } from "../../lib/const";
import { useEffect, useState } from "react";

const PeriodProfit = ({ }) => {
    const { idPeriod, period, summary, loadingSummary: loading, errorSummary: error } = usePeriodContext();

    const { data: dataSimul, loading: loadSimul, error: errorSimul, fetchData } = useLazyFetch(`${API_URL}/periods/${idPeriod}/summary`);

    const [simulDate, setSimulDate] = useState("");

    const handleSimul = async () => {
        if (!simulDate) return;

        await fetchData({
            date: simulDate
        });
    };

    useEffect(() => {
        handleSimul();
    }, [simulDate])

    // if (loading) return <p>Chargement...</p>;
    // if (error) return <p>Erreur : {error.message}</p>;

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
                <div className="flex items-center justify-end gap-2 pt-4">
                    <input
                        type="date"
                        className="input input-sm w-48"
                        value={simulDate}
                        onChange={(e) => setSimulDate(e.target.value)}
                    />
                    {/* <button
                    className="btn btn-sm btn-neutral"
                    onClick={handleSimul}
                    disabled={loadSimul}
                    >
                    test
                    </button> */}
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