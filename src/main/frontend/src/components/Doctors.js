import {useEffect, useState} from "react";
import "../styles/Doctors.css";
import {Dropdown} from "react-bootstrap";

export default Doctors;

function Doctors() {

    const [doctors, setDoctors] = useState({doctors: []});

    const DOCTOR_API_BASE_URL = 'api/doctor/';

    useEffect(() => {
        fetch(DOCTOR_API_BASE_URL)
            .then(data => data.json())
            .then(response => setDoctors({doctors: response}));
    }, []);


    return (
        <Dropdown>
            <Dropdown.Toggle variant="success" id="dropdown-basic">
                Dropdown Button
            </Dropdown.Toggle>
            <Dropdown.Menu>
            {doctors.doctors.map(doctor => (
                            <Dropdown.Item key={doctor.id}>{doctor.name} {doctor.surname}</Dropdown.Item>
                    ))}
            </Dropdown.Menu>
        </Dropdown>
    )
};