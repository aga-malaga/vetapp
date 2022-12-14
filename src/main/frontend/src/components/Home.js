import '../styles/home.css';
import React, {useState} from 'react';
import {Col, Container, Image, ListGroup, ListGroupItem, Row} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faCalendar, faList, faUserDoctor} from "@fortawesome/free-solid-svg-icons";
import Calendar from "react-calendar";
import RegistrationForm from "./RegistrationForm";
import Doctors from "./Doctors";
import 'react-calendar/dist/Calendar.css';
import '../styles/Calendar.css';
import Login from "./Login";
import Registration from "./Registration";

export default function Home() {


    const [value, onChange] = useState(new Date());
    const [openDate, setOpenDate] = useState(false);
    const [openVisitType, setVisitType] = useState(false);
    const [openDoctors, setOpenDoctors] = useState(false);

    const visitTypes = ["Skin and ear infections", 'Eye issues', "Diarrhea and vomiting", "Urinary problems",
        "Preventative wellness", "Toxin ingestion", "Other"];


    const [isShown, setIsShown] = useState(false);
    const [isLoginShown, setIsLoginShown] = useState(false);

    const handleClick = event => {
        setIsShown(current => !current);
    }

    const handleLoginClick = event => {
        setIsLoginShown(current => !current);
    }

    return (
        <Container>
            <Row>
                <Col className="heading" lg={8}>
                    <h1>Welcome to our clinic</h1>
                    <p>Book your next appointment with your pet at your favourite vet.</p>
                    <div className="action">
                        <button onClick={handleClick} className="button-56">Register</button>
                        {isShown && (
                            <div>
                                <RegistrationForm/>
                            </div>
                        )}
                            <button onClick={handleLoginClick} className="button-56">Log in</button>{
                        isLoginShown && (
                            <div>
                            <Login/>
                            </div>
                        )}
                    </div>
                </Col>
                <Col><Image src="/img3.jpg" alt="dog paws" className="img-fluid"/></Col>
            </Row>
            {/*<Row>*/}
            <div className="searchContainer">
                <Col lg={3} sm={12}>
                    <div className="headerSearch">
                        <FontAwesomeIcon icon={faUserDoctor}/>
                        <span onClick={() => setOpenDoctors(!openDoctors)}
                              className="headerSearchText"> {Doctors} </span>
                        {/*{openDoctors && (<Doctors*/}
                        {/*    onChange={onChange}*/}
                        {/*    value={value}*/}
                        {/*    className="date"*/}
                        {/*/>)}*/}
                    </div>
                </Col>
                <Col lg={3} sm={12}>
                    <div className="headerSearch">
                        <FontAwesomeIcon icon={faCalendar}/>
                        <span onClick={() => setOpenDate(!openDate)} className="headerSearchText"> Date </span>
                        {openDate && (<Calendar
                            onChange={onChange}
                            value={value}
                            className="date"
                        />)}
                    </div>
                </Col>
                <Col lg={3} sm={12}>
                    <div className="headerSearch">
                        <FontAwesomeIcon icon={faList}/>
                        <span onClick={() => setVisitType(!openVisitType)} className="headerSearchText">
                            Type of visit
                        </span>
                        {openVisitType && (visitTypes.map(visit => {
                            return (
                                <ListGroup>
                                    <ListGroupItem className="visitList" key={visit} action
                                                   onClick={() => setVisitType(!openVisitType)}>
                                        {visit}
                                    </ListGroupItem>
                                </ListGroup>
                            )
                        }))}
                    </div>
                </Col>
                <Col lg={3} sm={12}>
                    <div className="headerSearch">
                        <button className="headerBtn"> Search</button>
                    </div>
                </Col>
            </div>
        </Container>
    )
}
