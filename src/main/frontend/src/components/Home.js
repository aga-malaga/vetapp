import '../styles/home.css';
import React from 'react';

class Home extends React.Component {

    render() {
        return (
            <div>
                <div className="container">
                </div>
                <div className="container">
                    <div className="head">
                        <h1>Welcome to our clinic</h1>
                        <p1>Book your next appointment with your pet at your favourite vet.</p1>
                    </div>
                    <img className="app-img" alt="dog paws" src="/img3.jpg"/>
                </div>
            </div>
        )
    }
}
export default Home;