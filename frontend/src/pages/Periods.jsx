import { useFetch } from "../hooks/useHttpRequest";
import { API_URL } from "../lib/const";
import PeriodLink from "../components/period/PeriodLink";

const Home = () => {
  const { data: periods, loading, error } = useFetch(`${API_URL}/periods`);

  if (loading) return <p>Chargement...</p>;
  if (error) return <p>Erreur : {error.message}</p>;

  return (
    <div className="flex flex-col gap-4">
      <div className="flex uppercase font-poppins-m pt-4 text-xl">Periodes</div>
      <div className="flex gap-4 py-0">
        {periods?.map((period, i) => (
          <PeriodLink key={period.id} period={period} />
        ))}
      </div>
    </div>
  );
};

export default Home;