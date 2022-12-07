import React, {Component} from 'react';
import Navbar from './components/Navbar';
import ScheduleDisplay from "./components/ScheduleDisplay";
import Home from "./components/Home"

class App extends Component {

  render() {
    return (
        <div>
            <Navbar />
            <Home />
            <ScheduleDisplay />
        </div>
    );
  }
}

export default App;
