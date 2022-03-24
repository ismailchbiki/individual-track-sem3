import ListKiteLessonsComponent from "./components/ListKiteLessonsComponent";
import HeaderComponent from "./components/HeaderComponent";
import FooterComponent from "./components/FooterComponent";

function App() {
  return (
    <div>
      <HeaderComponent />
      <div className="container">
        <ListKiteLessonsComponent />
      </div>
      <FooterComponent />
    </div>
  );
}

export default App;
