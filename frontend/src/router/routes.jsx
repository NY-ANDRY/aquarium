import Periods from '../pages/Periods';
import Period from '../pages/Period';
import Aquarium from '../pages/Aquarium';
import NotFound from '../pages/NotFound';
import Fish from '../pages/Fish';

const routes = [
  {
    path: "/",
    component: Periods,
    title: "Accueil",
  },
  {
    path: "/home",
    component: Periods,
    title: "Accueil",
  },
  {
    path: "/periods/:id",
    component: Period,
    title: "Accueil",
  },
  {
    path: "/aquariums/:id",
    component: Aquarium,
    title: "Aquarium",
  },
  {
    path: "/fish/:id",
    component: Fish,
    title: "Fish",
  },
  {
    path: "*",
    component: NotFound,
    title: "Not Found",
  },
];

export default routes;