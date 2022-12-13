import '../styles/home.css';
import React, {useState} from 'react';
import {Col, Container, Image, Row} from "react-bootstrap";
import displayCalendar from "./DisplayCalendar";
import DisplayCalendar from "./DisplayCalendar";


export default function Home() {

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
                    <button onClick={handleClick} className="button-56">Book appointment</button>
                    {isShown && (
                        <div>
                            <DisplayCalendar/>
                        </div>
                    )}
                    <button className="button-56">Log in</button>
                </div>
            </Col>
            <Col lg={4}><Image src="/img3.jpg" alt="dog paws" className="img-fluid"/></Col>
        </Row>
    </Container>
    )
}
