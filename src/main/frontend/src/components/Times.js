import React, {useEffect, useState} from 'react'
import axios from "axios";

function Times(props) {

    const [slots, setSlots] = useState([]);
    const [event, setEvent] = useState(null)
    const [info, setInfo] = useState(false)

    const SLOTS_API_BASE_URL = 'api/doctor/schedule';

    useEffect(() => {
            getSlots()
        }, []
    )

    const getSlots = () => {
        axios.get(SLOTS_API_BASE_URL).then((response) => {
            setSlots(response.data)
            console.log(response.data);
        });
    };
    const parseDate = ((date) => {
        return new Date(date).toLocaleTimeString('pl');
    })

    function displayInfo(e) {
        setInfo(true);
        setEvent(e.target.innerText);
    }

    return (

        <div className="times">
            {slots.map(slot => {
                return (
                    <div>
                        <button onClick={(e)=> displayInfo(e)}> {parseDate(slot.start)} </button>
                    </div>
                )
            })}
            <div>
                {info ? `Your appointment is set to ${event} ${props.date.toDateString()}` : null}
            </div>
        </div>
    )
}

export default Times;