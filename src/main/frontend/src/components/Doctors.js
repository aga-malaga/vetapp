import {useEffect, useState} from "react";
import "../styles/Doctors.css";

export const Doctors = () => {

    const [appState, setAppState] = useState({ doctors: []});

    useEffect( () => {
        const url = "api/doctor";
        fetch(url)
            .then(data => data.json())
            .then( response => setAppState({doctors: response}));
    })

    return (
        <>
            {appState.doctors.map( doctor => {
               return (
                   <div key={doctor.id}>
                       <button className='button-52'>
                       Name: {doctor.name}
                       Surname: {doctor.surname}
                       Medical Specialty: {doctor.medicalSpecialty}
                       </button>
                   </div>
               )
            })}


        </>


    )
}