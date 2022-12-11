import React, {Component} from 'react';
import Navbar from './components/Navbar';
import Home from "./components/Home"
import DisplayCalendar from "./components/DisplayCalendar";
import Times from "./components/Times";

class App extends Component {

  render() {
    return (
        <div>
            <Navbar />
            <Home />
           <DisplayCalendar />
           <Times />
        </div>
    );
  }
}

export default App;
