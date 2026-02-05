import { useFishContext } from "./FishContext";
import { useLazyFetch } from "../../hooks/useHttpRequest";
import { useEffect, useState } from "react";
import { API_URL } from "../../lib/const";

const FishState = ({ }) => {
    const { fish, idFish } = useFishContext();
    const {
        data,
        loading,
        error,
        fetchData
    } = useLazyFetch(`${API_URL}/fish/${idFish}`);

    const [selectedDate, setSelectedDate] = useState("");

    const handleSelect = async () => {
        if (!selectedDate) return;

        await fetchData({ date: selectedDate });
    };

    useEffect(() => {
        handleSelect();
    }, [selectedDate])

    return (

        <div className="w-full flex flex-col gap-8">

            <div className="stats shadow w-120">
                <div className="stat">
                    <div class="stat-title text-xl">{fish?.name}</div>
                    <div class="stat-value">{fish?.weight}</div>
                </div>
            </div>

            <div className="flex items-center gap-2">
                <input
                    type="date"
                    className="input input-sm w-120"
                    value={selectedDate}
                    onChange={(e) => setSelectedDate(e.target.value)}
                />
                {/* <button
                    className="btn btn-sm btn-neutral"
                    onClick={handleSelect}
                    disabled={loading}
                >
                    get
                </button> */}
            </div>

            <div className="stats shadow w-120">
                <div className="stat">
                    <div className="stat-title text-xl">{data?.name}</div>
                    <div className="stat-value">{data?.weight}</div>
                    <div className="stat-desc">{selectedDate}</div>
                </div>
            </div>
        </div>

    );
};

export default FishState;
