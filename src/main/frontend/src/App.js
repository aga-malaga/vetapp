import React, {Component} from 'react';
import Navbar from './components/Navbar';
import Home from "./components/Home"
import DisplayCalendar from "./components/DisplayCalendar";

class App extends Component {

  render() {
    return (
        <div>
            <Navbar />
            <Home />
           <DisplayCalendar />
        </div>
    );
  }
}

export default App;
