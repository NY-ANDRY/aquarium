import { createContext, useContext, useCallback } from "react";
import { useFetch } from "../../hooks/useHttpRequest";
import { API_URL } from "../../lib/const";

const AquariumContext = createContext();

export const AquariumProvider = ({ children, idAquarium }) => {
    const { data: aquarium, loading: loadingAquarium, error: errorAquarium, refetch: refetchAquarium } = useFetch(`${API_URL}/aquariums/${idAquarium}`);
    const { data: fish, loading: loadingFish, error: errorFish, refetch: refetchFish } = useFetch(`${API_URL}/aquariums/${idAquarium}/fish`);

    const reloadAll = useCallback(() => {
        refetchAquarium();
    }, [refetchAquarium]);

    const value = {
        idAquarium,
        aquarium,
        loadingAquarium,
        errorAquarium,
        fish, loadingFish, errorFish, refetchFish,
        reloadAll
    };

    return (
        <AquariumContext.Provider value={value}>
            {children}
        </AquariumContext.Provider>
    );
};

export const useAquariumContext = () => {
    const context = useContext(AquariumContext);
    if (!context) {
        throw new Error("usePeriodContext must be used within a PeriodProvider");
    }
    return context;
};
