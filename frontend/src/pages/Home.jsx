import { Link } from "react-router-dom";
import { useFetch } from "../hooks/useFetch";
import { useMutation } from "../hooks/useMutation";

const Home = () => {
const { data, loading, error } = useFetch("https://jsonplaceholder.typicode.com/posts");
  const { mutate, loading: mutLoading } = useMutation("https://jsonplaceholder.typicode.com/posts");

  const handleAdd = async () => {
    try {
      const newPost = await mutate({ title: "Nouveau post", body: "Contenu ici" });
      console.log("Post ajouté :", newPost);
    } catch (err) {
      console.log("Erreur mutation :", err);
    }
  };

  if (loading) return <p>Chargement...</p>;
  if (error) return <p>Erreur : {error.message}</p>;

  return (
    <div>
      <button onClick={handleAdd} disabled={mutLoading}>
        Ajouter un post
      </button>
      <ul>
        {data?.map(post => (
          <li key={post.id}>{post.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default Home;