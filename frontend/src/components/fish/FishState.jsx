import { useFishContext } from "./FishContext";
import { useLazyFetch } from "../../hooks/useHttpRequest";
import { useEffect, useState } from "react";
import { API_URL } from "../../lib/const";
import { DayPicker } from "react-day-picker";
import { datePicktoDate } from "../../lib/utils";

const FishState = ({ }) => {
    const { fish, idFish } = useFishContext();
    const {
        data,
        loading,
        error,
        fetchData
    } = useLazyFetch(`${API_URL}/fish/${idFish}`);

    const [date, setDate] = useState("");

    const handleSelect = async () => {
        if (!date) return;

        await fetchData({
            date: datePicktoDate(date)
        });
    };

    useEffect(() => {
        handleSelect();
    }, [date])

    return (

        <div className="w-full flex justify-between gap-8">

            <div className="stats shadow w-120">
                <div className="stat">
                    <div className="stat-title text-lg">{fish?.name}</div>
                    <div className="stat-value">{fish?.weight}</div>
                </div>
            </div>

            <div className="flex flex-col">


                <div className="stats shadow w-120">
                    <div className="stat flex items-center justify-between">
                        <div className="flex flex-col">
                            <div className="stat-title text-lg">{data?.name}</div>
                            <div className="stat-value">{data?.weight}</div>
                        </div>

                        <div className="flex flex-col h-full py-1">
                            <button popoverTarget="rdp-popover" className="input input-border input-sm w-48" style={{ anchorName: "--rdp" }}>
                                {date ? date.toLocaleDateString() : "Pick a date"}
                            </button>
                            <div popover="auto" id="rdp-popover" className="dropdown" style={{ positionAnchor: "--rdp" }}>
                                <DayPicker className="react-day-picker" mode="single" selected={date} onSelect={setDate} />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    );
};

export default FishState;
