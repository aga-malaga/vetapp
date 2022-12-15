import React from 'react';
import './styles/App.css';
import Navbar from "./components/Navbar";
import Home from "./components/Home";
import RegistrationForm from "./components/RegistrationForm";
import Times from "./components/Times";
import Doctors from "./components/Doctors";


export default function App() {


    return (
        <div>
            <Navbar/>
            <Home/>
            {/*<Doctors/>*/}
        </div>
    );
}


