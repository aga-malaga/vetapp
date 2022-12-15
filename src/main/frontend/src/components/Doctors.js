import React, {useEffect, useState} from "react";
import "../styles/Doctors.css";
import {ListGroup, ListGroupItem} from "react-bootstrap";
import axios from "axios";

export default Doctors;

function Doctors({id}) {
    const [openVisitType, setVisitType] = useState(false);

    const [doctors, setDoctors] = useState([]);

    const DOCTOR_API_BASE_URL = 'api/doctor/';

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


    return (
        <div>
            {doctors.map(doctor => {
                return (
                    <ListGroup>
                        <ListGroupItem className="doctorsList" key={doctor.id} action onClick={() =>
                            setVisitType(!openVisitType)}>
                            {doctor.name + doctor.surname}
                        </ListGroupItem>
                    </ListGroup>
                )
            })}
        </div>
    )
}
