import {useEffect, useState} from "react";
import axios from "axios";

function LogIn() {

    const [log, setLog] = useState([]);

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




}