import { useFetch } from "../hooks/useFetch";
import { API_URL } from "../lib/const";
import Period from "../components/periods/Period";

const Home = () => {
  const { data, loading, error } = useFetch(`${API_URL}/periods`);

  if (loading) return <p>Chargement...</p>;
  if (error) return <p>Erreur : {error.message}</p>;

  return (
    <div>
      {data?.map((period, i) => (
        <Period key={period.id}>{i}</Period>
      ))}
    </div>
  );
};

export default Home;