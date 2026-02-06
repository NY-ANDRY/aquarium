import { formatDateFr } from "../../lib/utils";
import { Link } from "react-router-dom";

const Period = ({ period }) => {

    return (
        <Link to={`/periods/${period.id}`}>
            <div className="card w-96 bg-base-100 card-xs shadow-sm">
                <div className="card-body">
                    <h2 className="card-title">{period?.name}</h2>
                    <div className="flex items-center gap-4">
                        <div className="flex">
                            {period?.begin && formatDateFr(period.begin)}
                        </div>

                        {period.end &&
                            <>
                                <div className="flex">-</div>
                                <div className="flex">
                                    {period?.begin && formatDateFr(period.end)}
                                </div>
                            </>
                        }
                    </div>

                </div>
            </div>
        </Link>
    )
}

export default Period;          