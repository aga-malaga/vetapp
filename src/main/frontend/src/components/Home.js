import '../styles/home.css';
import React, {useState} from 'react';
import {Col, Container, Image, ListGroup, ListGroupItem, Row} from "react-bootstrap";
import displayCalendar from "./DisplayCalendar";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faCalendar, faList, faUserDoctor} from "@fortawesome/free-solid-svg-icons";
import Calendar from "react-calendar";
import RegistrationForm from "./RegistrationForm";
import Doctors from "./Doctors";


export default function Home() {

    const [value, onChange] = useState(new Date());
    const [openDate, setOpenDate] = useState(false);
    const [openVisitType, setVisitType] = useState(false);
    const [openDoctors, setOpenDoctors] = useState(false);

    const visitTypes = ["Skin and ear infections", 'Eye issues', "Diarrhea and vomiting", "Urinary problems",
    "Preventative wellness", "Toxin ingestion", "Other"];


    const [isShown, setIsShown] = useState(false);
    const handleClick = event => {
        setIsShown(current => !current);
        displayCalendar();
    }
    const handleClick2 = event => {
        setIsShown(current => !current);
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
                        <a href="/api/client">
                        <button className="button-56" >Log in</button>
                        </a>
                    </div>
                </Col>
                <Col><Image src="/img3.jpg" alt="dog paws" className="img-fluid"/></Col>
            </Row>
            {/*<Row>*/}
            <div className="searchContainer">
                <Col>
                    <div className="headerSearch">
                        <FontAwesomeIcon icon={faUserDoctor}/>
                        <span onClick={() => setOpenDoctors(!openDoctors)} className="headerSearchText">
                            Choose your doctor
                        </span>
                        {openDoctors && (
                            <Doctors/>
                        )}
                    </div>
                </Col>
                <Col>
                    <div className="headerSearch">
                        <FontAwesomeIcon icon={faCalendar}/>
                        <span onClick={() => setOpenDate(!openDate)} className="headerSearchText"> Date</span>
                        {openDate && (<Calendar
                            onChange={onChange}
                            value={value}
                            className="date"
                        />)}
                    </div>
                </Col>
                <Col>
                    <div className="headerSearch">
                        <FontAwesomeIcon icon={faList}/>
                        <span onClick={() => setVisitType(!openVisitType)} className="headerSearchText">
                            Type of visit
                        </span>
                        {openVisitType && (visitTypes.map(visit => {
                            return (
                                <ListGroup>
                                    <ListGroupItem className="visitList" key={visit} action onClick={() => setVisitType(!openVisitType)}>
                                        {visit}
                                    </ListGroupItem>
                                </ListGroup>
                            )
                        }))}
                    </div>
                </Col>
                <Col>
                    <div className="headerSearch">
                        <button className="headerBtn"> Search</button>
                    </div>
                </Col>
            </div>
        </Container>
    )
}
