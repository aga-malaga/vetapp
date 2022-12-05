import React from 'react';
import ReactDOM from "react-dom";

class Home extends React.Component {

    render() {
        return (
            <div className="col-sm-7">
                <h1>Welcome to our clinic</h1>
                <p1>Book your next appointment with your pet at your favourite vet.</p1>
                <img alt='dog paws' src=/img3.jpg />
            </div>
        )
    }
}
ReactDOM.render(
    <Home/>,
    document.getElementById("root")
)