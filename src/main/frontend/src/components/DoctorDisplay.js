import {useEffect, useState} from "react";
import axios from "axios";

function DoctorDisplay() {

    const [doctors, setDoctors] = useState([]);
    const [event, setEvent] = useState(null)
    const [info, setInfo] = useState(false)

    const SLOTS_API_BASE_URL = 'api/doctor';

    useEffect(() => {
            getSlots()
        }, []
    )

    const getSlots = () => {
        axios.get(SLOTS_API_BASE_URL).then((response) => {
            setDoctors(response.data)
            console.log(response.data);
        });
    };
    //
    // return (
    //
    // )

}