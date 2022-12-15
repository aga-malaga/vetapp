import '../styles/RegistrationForm.css';
import {useState} from "react";

export default RegistrationForm;

function RegistrationForm() {

    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const handleInputChange = (e) => {
        const {id , value} = e.target;
        if(id === "firstName"){
            setFirstName(value);
        }
        if(id === "lastName"){
            setLastName(value);
        }
        if(id === "email"){
            setEmail(value);
        }
        if(id === "password"){
            setPassword(value);
        }
        if(id === "confirmPassword"){
            setConfirmPassword(value);
        }

    }

    const handleSubmit  = (event) => {
        console.log(firstName,lastName,email,password,confirmPassword);
        event.preventDefault();
        event.stopPropagation();

        const newUser = {
            firstName: firstName,
            lastName: lastName,
            email: email,
            password: password
        }
        const url = "api/registration";
        fetch(url, {
        method: "POST",
            headers: {
            'Content-Type': "application/json"
            },
            body: JSON.stringify(newUser)
        }).then(
            data => console.log(data)
        )

    }

    return (
        <div className="formBody">
            <div className="form">
                <div className="form-body">
                    <p className="p1">Registration Form</p>
                    <div className="username">
                        <label className="form__label" for="firstName">First Name </label>
                        <input
                            type="text"
                            className="form__input"
                            id="firstName"
                            value={firstName}
                            onChange={
                            (e) => handleInputChange(e)}  placeholder="First Name"/>
                    </div>
                    <div className="lastname">
                        <label className="form__label" for="lastName">Last Name </label>
                        <input
                            type="text"
                            className="form__input"
                            id="lastName"
                            value={lastName}
                            onChange={
                            (e) => handleInputChange(e)} placeholder="LastName"/>
                    </div>
                    <div className="email">
                        <label className="form__label" for="email">Email </label>
                        <input
                            type="email"
                            className="form__input"
                            id="email"
                            value={email}
                            onChange={
                            (e) => handleInputChange(e)} placeholder="Email"/>
                    </div>
                    <div className="password">
                        <label className="form__label" for="password">Password </label>
                        <input
                            type="password"
                            className="form__input"
                            id="password"
                            value={password}
                            onChange={
                            (e) => handleInputChange(e)} placeholder="Password"/>
                    </div>
                    <div className="confirm-password">
                        <label className="form__label" for="confirmPassword">Confirm Password </label>
                        <input
                            type="password"
                            className="form__input"
                            id="confirmPassword"
                            value={confirmPassword}
                            onChange={
                                   (e) => handleInputChange(e)} placeholder="Confirm Password"/>
                    </div>
                </div>
                <div class="footer">
                    <button onClick={(event) => handleSubmit()} type="submit" className="btn">Register</button>
                </div>
            </div>
        </div>
    )
}
