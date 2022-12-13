import React from 'react';
import Times from './Times.js'

function Time(props) {

    const compareTime = () => {
        let day = props.showTime.formatDate('YYYY-MM-dd');
        let date = new Date(props.date).toLocaleDateString();
        if (day === date) {
            console.log(props.date)
        }
    }

    let time = props.showTime;
    return (
        <div>
            {time = () => {
               return  time.formatDate('YYYY-MM-dd');
            }}
            {console.log(time)}
            {props.showTime ? <Times date={props.date}/> : null}
        </div>
    )
}

export default Time;