// import React, {useEffect, useState} from "react";
// import axios from "axios";
//
// function ScheduleDisplay() {
//     const [slots, setSlots] = useState([]);
//
//     const SLOTS_API_BASE_URL = 'api/doctor/schedule';
//
//     useEffect(() => {
//             getSlots()
//         }, []
//     )
//
//     const getSlots = () => {
//         axios.get(SLOTS_API_BASE_URL).then((response) => {
//             setSlots(response.data)
//             console.log(response.data);
//         });
//     };
//     const parseDate = ((date) => {
//         return new Date(date).toLocaleTimeString('pl');
//     })
//
//     return (
//         <div className="container">
//             <table>
//                 <thead>
//                 <tr>
//                     <th>Start</th>
//                     <th>End</th>
//                     <th>Doctor</th>
//                     <th></th>
//                     <th>Booked</th>
//                 </tr>
//
//                 </thead>
//                 <tbody>
//                 {
//                     slots.map(
//                         slot =>
//                             <tr key={slot.id}>
//                                 <td> {parseDate(slot.start)}</td>
//                                 <td> {parseDate(slot.end)}</td>
//                                 <td> {slot.doctor.name}</td>
//                                 <td> {slot.doctor.surname}</td>
//                                 <button>Book</button>
//                             </tr>
//                     )
//                 }
//
//                 </tbody>
//
//
//             </table>
//
//         </div>
//     )
// }
//
// // class ScheduleDisplay extends Component {
// //     state = {
// //         slots: []
// //     }
// //
// //     componentDidMount() {
// //         axios.get(`api/doctor/schedule`)
// //             .then(res => {
// //                 const slots = res.data;
// //                 this.setState({ slots });
// //             })
// //     }
// //
// //     render() {
// //         let tb_data = this.state.slots.map((slot) =>{
// //             return (
// //                 <tr key={slot.id}>
// //                     <td>{slot.id}</td>
// //                     <td>{slot.start}</td>
// //                     <td>{slot.doctor.name}</td>
// //                     <td>{slot.doctor.surname}</td>
// //                     <td>
// //                         <button>Book</button>
// //                     </td>
// //                 </tr>
// //             )
// //         })
// //         return (
// //             <div className="container">
// //                 <table className="table table-striped">
// //                     <thead>
// //                     <tr>
// //                         <th>Id</th>
// //                         <th>Time</th>
// //                         <th>Name</th>
// //                         <th>Surname</th>
// //                         <th>Book</th>
// //                     </tr>
// //                     </thead>
// //                     <tbody>
// //                     {tb_data}
// //                     </tbody>
// //                 </table>
// //             </div>
// //         )
// //     }
// // }
//
// export default ScheduleDisplay;