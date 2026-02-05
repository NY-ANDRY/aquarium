import { useState } from "react";
import { useMutation } from "../../hooks/useHttpRequest";
import { API_URL } from "../../lib/const";
import { usePeriodContext } from "./PeriodContext";

const PeriodState = ({ }) => {
    const { idPeriod, period, loadingPeriod, errorPeriod, reloadAll } = usePeriodContext();
    const {
        mutate: mutateState,
        loading: loadingMutation,
        error: errorMutation
    } = useMutation(`${API_URL}/periods/${idPeriod}/end`);

    

    const [endDate, setEndDate] = useState("");

    const handleEnd = async () => {
        if (!endDate) return;

        await mutateState({
            id: idPeriod,
            end: endDate
        });

        reloadAll();
    };

    // if (loading) return <p>Chargement...</p>;
    // if (error) return <p>Erreur : {error.message}</p>;

    return (
        <div className="w-full flex flex-row-reverse pb-4 gap-2">
            {period?.end && (
                <div className="badge badge-success">
                    <svg
                        className="size-[1em]"
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 24 24"
                    >
                        <g fill="currentColor">
                            <circle cx="12" cy="12" r="10" fill="none" stroke="currentColor" strokeWidth="2" />
                            <polyline points="7 13 10 16 17 8" fill="none" stroke="currentColor" strokeWidth="2" />
                        </g>
                    </svg>
                    Closed
                </div>
            )}

            {!period?.end && (
                <div className="flex items-center gap-2">
                    <input
                        type="date"
                        className="input input-sm w-48"
                        value={endDate}
                        onChange={(e) => setEndDate(e.target.value)}
                    />
                    <button
                        className="btn btn-sm btn-neutral"
                        onClick={handleEnd}
                        disabled={loadingMutation}
                    >
                        end
                    </button>
                </div>
            )}

            {errorMutation && (
                <p className="text-error text-sm mt-2">
                    {errorMutation.message}
                </p>
            )}
        </div>
    );
};

export default PeriodState;
