import React, {useState} from 'react';
import Calendar from 'react-calendar';
import Time from './Time.js';
import 'react-calendar/dist/Calendar.css';
import '../styles/Calendar.css';

function DisplayCalendar() {
    const [date, setDate] = useState(new Date());
    const [showTime, setShowTime] = useState(false)

    let today = new Date();
    let fullToday = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();

    return (
        <div className='calendar-container'>
            <div>
                <Calendar activeStartDate={new Date()} onChange={setDate} value={date}
                          onClickDay={() => setShowTime(true)}/>
            </div>

            <Time showTime={showTime} date={date}/>

        </div>
    );
}

export default DisplayCalendar;