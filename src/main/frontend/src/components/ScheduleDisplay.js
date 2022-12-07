import {Component} from "react";
import axios from "axios";

class ScheduleDisplay extends Component {
    state = {
        slots: []
    }

    componentDidMount() {
        axios.get(`api/doctor/schedule`)
            .then(res => {
                const slots = res.data;
                this.setState({ slots });
            })
    }

    render() {
        let tb_data = this.state.slots.map((slot) =>{
            return (
                <tr key={slot.id}>
                    <td>{slot.id}</td>
                    <td>{slot.start}</td>
                    <td>{slot.doctor.name}</td>
                    <td>{slot.doctor.surname}</td>
                    <td>
                        <button>Book</button>
                    </td>
                </tr>
            )
        })
        return (
            <div className="container">
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Time</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Book</th>
                    </tr>
                    </thead>
                    <tbody>
                    {tb_data}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default ScheduleDisplay;