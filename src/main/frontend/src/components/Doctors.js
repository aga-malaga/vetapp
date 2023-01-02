import React, {useEffect, useState} from "react";
import "../styles/Doctors.css";
import axios from "axios";
import {FormControl, InputLabel, MenuItem, Select, SelectChangeEvent} from "@mui/material";
import {ListGroup, ListGroupItem} from "react-bootstrap";

export default Doctors;

function Doctors({id}) {
    const [openVisitType, setVisitType] = useState(true);

    const [doctors, setDoctors] = useState([]);

    const DOCTOR_API_BASE_URL = 'api/v1/doctor/';

    useEffect(() => {
            getDoctors()
        }, []
    )

    const getDoctors = () => {
        axios.get(DOCTOR_API_BASE_URL).then((response) => {
            setDoctors(response.data)
            console.log(response.data);
        });
    };

    const handleChange = (event: SelectChangeEvent) => {
        setDoctors(event.target.value || "");
    };


    return (
        <div>
            {doctors.map(doctor => {
                return (
                    <ListGroup>
                        <ListGroupItem className="doctorsList" key={doctor.id} action onClick={() => {
                            setVisitType(!openVisitType)}}>
                            {doctor.name + " " + doctor.surname}
                        </ListGroupItem>
                    </ListGroup>
                )
            })}
        </div>

        // <div>
        //     <FormControl fullWidth>
        //         <InputLabel id="select-doctor">Doctor</InputLabel>
        //         <Select
        //             labelId="demo-simple-select-label"
        //             id="demo-simple-select"
        //             value={doctors}
        //             onChange={handleChange}
        //         >
        //             {openVisitType && doctors.map(doctor => {
        //                 return (
        //                     <MenuItem value={doctor.id}>
        //                         {doctor.name + ' ' + doctor.surname}
        //                     </MenuItem>
        //                 )
        //             })}
        //         </Select>
        //     </FormControl>
        // </div>
    )
}
