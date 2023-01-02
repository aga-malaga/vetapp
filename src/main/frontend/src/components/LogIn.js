import {useEffect, useState} from "react";
import axios from "axios";

function Login() {

    const [log, setLog] = useState([]);

    const DOCTOR_API_BASE_URL = '/login';

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