import { createContext, useContext, useCallback } from "react";
import { useFetch } from "../../hooks/useHttpRequest";
import { API_URL } from "../../lib/const";

const PeriodContext = createContext();

export const PeriodProvider = ({ children, idPeriod }) => {
    const { data: period, loading: loadingPeriod, error: errorPeriod, refetch: refetchPeriod } = useFetch(`${API_URL}/periods/${idPeriod}`);
    const { data: summary, loading: loadingSummary, error: errorSummary, refetch: refetchSummary } = useFetch(`${API_URL}/periods/${idPeriod}/summary`);
    const { data: aquariums, loading: loadingAquariums, error: errorAquariums, refetch: refetchAquariums } = useFetch(`${API_URL}/periods/${idPeriod}/aquariums`);

    const reloadAll = useCallback(() => {
        refetchPeriod();
        refetchSummary();
        refetchAquariums();
    }, [refetchPeriod, refetchSummary, refetchAquariums]);

    const value = {
        idPeriod,
        period,
        loadingPeriod,
        errorPeriod,
        summary,
        loadingSummary,
        errorSummary,
        aquariums,
        loadingAquariums,
        errorAquariums,
        reloadAll
    };

    return (
        <PeriodContext.Provider value={value}>
            {children}
        </PeriodContext.Provider>
    );
};

export const usePeriodContext = () => {
    const context = useContext(PeriodContext);
    if (!context) {
        throw new Error("usePeriodContext must be used within a PeriodProvider");
    }
    return context;
};
