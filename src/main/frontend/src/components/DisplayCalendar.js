import React, {useState} from 'react';
import Calendar from 'react-calendar';
import Time from './Time.js';
import 'react-calendar/dist/Calendar.css';
import '../styles/Calendar.css';

function DisplayCalendar() {
    const [date, setDate] = useState(new Date());
    const [showTime, setShowTime] = useState(false)

    return (
        <div className='calendar-container'>
            <h1 className='header'>React Calendar</h1>
            <div>
                <Calendar onChange={setDate} value={date} onClickDay={() => setShowTime(true)}/>
            </div>

    {date.length > 0 ? (
        <p>
            <span>Start:</span>
            {date[0].toDateString()}
            &nbsp;
            &nbsp;
            <span>End:</span>{date[1].toDateString()}
        </p>
    ) : (
        <p>
            <span>Default selected date:</span>{date.toDateString()}
        </p>
    )
    }
    <Time showTime={showTime} date={date}/>

</div>
    );
}

export default DisplayCalendar;