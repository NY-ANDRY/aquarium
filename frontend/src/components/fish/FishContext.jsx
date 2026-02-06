import { createContext, useContext, useCallback } from "react";
import { useFetch } from "../../hooks/useHttpRequest";
import { API_URL } from "../../lib/const";

const FishContext = createContext();

export const FishProvider = ({ children, idFish }) => {
    const { data: fish, loading: loadingFish, error: errorFish, refetch: refetchFish } = useFetch(`${API_URL}/fish/${idFish}`);
    const { data: fdfs, loading: loadingFdfs, error: errorFdfs, refetch: refetchFdfs } = useFetch(`${API_URL}/fish/${idFish}/dailyFeeds`);

    const reloadAll = useCallback(() => {
        refetchFish();
    }, [refetchFish]);

    const value = {
        idFish,
        fish,
        loadingFish,
        errorFish,
        refetchFish,
        fdfs,
        loadingFdfs,
        errorFdfs,
        refetchFdfs,
        reloadAll
    };

    return (
        <FishContext.Provider value={value}>
            {children}
        </FishContext.Provider>
    );
};

export const useFishContext = () => {
    const context = useContext(FishContext);
    if (!context) {
        throw new Error("useFishContext must be used within a PeriodProvider");
    }
    return context;
};
