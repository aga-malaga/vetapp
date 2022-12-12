import React, {useState} from 'react';
import DisplayCalendar from "./components/DisplayCalendar";
import displayCalendar from "./components/DisplayCalendar";
import './styles/App.css';
import RegisterForm from "./components/RegisterForm";
import {Doctors} from "./components/Doctors";
import {AddUser} from "./components/AddUser";

export default function App() {

    const [isShown, setIsShown] = useState(false);
    const handleClick = event => {
        setIsShown(current => !current);
        displayCalendar();
    }

    return (
        <div className='app-container'>
            <div className="container">
                <button onClick={handleClick} className="button-56">Book appointment</button>
                {isShown && (
                    <div>
                        <DisplayCalendar/>
                    </div>
                )}
            </div>
            <Doctors/>
            <AddUser/>
        </div>
    );
}


