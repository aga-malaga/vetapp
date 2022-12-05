import React from 'react';
import ReactDOM from 'react-dom';

class Schedule extends React.Component {

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
            <div className="Schedule">
                <h2>Schedule</h2>
                {timeslots.map(timeslot =>
                    <div key={timeslot.id}>
                        {timeslot.start}
                    </div>
                )}
            </div>
        );
    }
}

ReactDOM.render(
    <Schedule/>,
    document.getElementById("root")
)