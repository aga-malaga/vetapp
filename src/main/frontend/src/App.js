import React, {Component} from 'react';
import Navbar from './components/Navbar';
import './styles/App.css';
class App extends Component {

  state = {
      timeslots: []
  };

  async componentDidMount() {
      const response = await fetch('/api/doctor/schedule');
      const body = await response.json();
      this.setState({timeslots: body});
  }
  render() {

      const {timeslots} = this.state;
    return (
        <div>
            <Navbar />
            <div className="container">
            </div>
        <div className="container">
            <div className="head">
            <h1>Welcome to our clinic</h1>
            <p1>Book your next appointment with your pet at your favourite vet.</p1>
            </div>
            <img className="app-img" alt="dog paws" src="/img3.jpg" />
        </div>
        <div className="schedule">
                  <h2>Schedule</h2>
                  {timeslots.map(timeslot =>
                      <div key={timeslot.id}>
                          {timeslot.start}
                      </div>
                  )}
        </div>
        </div>
    );
  }
}

export default App;
