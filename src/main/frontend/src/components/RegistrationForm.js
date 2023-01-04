import '../styles/RegistrationForm.css';
import {useEffect, useRef, useState} from "react";
import axios from "axios";

function RegistrationForm() {


    const USER_REGEX = /^[A-z][A-z0-9-_]{3,23}$/;
    const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;
    const REGISTER_URL = "api/v1/registration";

    const userRef = useRef();
    const errRef = useRef();

    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");

    const [username, setUsername] = useState("");
    const [validName, setValidName] = useState(false);
    const [userFocus, setUserFocus] = useState(false);

    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [validPwd, setValidPwd] = useState(false);
    const [pwdFocus, setPwdFocus] = useState(false);
    const [matchPwd, setMatchPwd] = useState('');

    const [validMatch, setValidMatch] = useState(false);
    const [matchFocus, setMatchFocus] = useState(false);

    const [openRegister, setOpenRegister] = useState(false);
    const [isSubmitted, setIsSubmitted] = useState(false);
    const [errMsg, setErrMsg] = useState('');

    useEffect(() => {
        userRef.current.focus();
    }, [])

    useEffect(() => {
        setValidName(USER_REGEX.test(username));
    }, [username])

    useEffect(() => {
        setValidPwd(PWD_REGEX.test(password));
        setValidMatch(password === matchPwd);
    }, [password, matchPwd])

    useEffect(() => {
        setErrMsg('');
    }, [username, password, matchPwd])

    // const handleInputChange = (e) => {
    //     const {id, value} = e.target;
    //     if (id === "firstName") {
    //         setFirstName(value);
    //     }
    //     if (id === "lastName") {
    //         setLastName(value);
    //     }
    //     if (id === "username") {
    //         setUsername(value);
    //     }
    //     if (id === "email") {
    //         setEmail(value);
    //     }
    //     if (id === "password") {
    //         setPassword(value);
    //     }
    //     if (id === "confirmPassword") {
    //         setConfirmPassword(value);
    //     }
    //
    // }

    const handleSubmit = async (e) => {
        e.preventDefault();
        // if button enabled with JS hack
        const v1 = USER_REGEX.test(username);
        const v2 = PWD_REGEX.test(password);
        if (!v1 || !v2) {
            setErrMsg("Invalid Entry");
            return;
        }
        try {
            const response = await axios.post(REGISTER_URL,
                JSON.stringify({
                    firstName,
                    lastName,
                    username,
                    email,
                    password }),
                {
                    headers: { 'Content-Type': 'application/json' },
                    withCredentials: true
                }
            );
            console.log(response?.data);
            console.log(response?.accessToken);
            console.log(JSON.stringify(response))
            setIsSubmitted(true);
            //clear state and controlled inputs
            //need value attrib on inputs for this
            setFirstName('');
            setLastName('');
            setEmail('');
            setUsername('');
            setPassword('');
            setConfirmPassword('');

        } catch (err) {
            if (!err?.response) {
                setErrMsg('No Server Response');
            } else if (err.response?.status === 409) {
                setErrMsg('Username Taken');
            } else {
                setErrMsg('Registration Failed')
            }
            errRef.current.focus();
        }
    }

    const renderForm = (
        <form className="formBody">
            <form onSubmit={handleSubmit}>
                <div className="form-body">
                    <p className="p1">Registration Form</p>
                    <div className="username">
                        <label className="form__label" for="firstName">First Name </label>
                        <input
                            type="text"
                            id="firstName"
                            ref={userRef}
                            autoComplete="off"
                            onChange={(e) => setFirstName(e.target.value)}
                            value={firstName}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUserFocus(true)}
                            onBlur={() => setUserFocus(false)}
                        />
                    </div>
                    <div className="lastname">
                        <label className="form__label" for="lastName">Last Name </label>
                        <input
                            type="text"
                            id="lastName"
                            ref={userRef}
                            autoComplete="off"
                            onChange={(e) => setLastName(e.target.value)}
                            value={lastName}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUserFocus(true)}
                            onBlur={() => setUserFocus(false)}
                        />
                    </div>
                    <div className="username">
                        <label className="form__label" for="username">Username</label>
                        <input
                            type="text"
                            id="username"
                            ref={userRef}
                            autoComplete="off"
                            onChange={(e) => setUsername(e.target.value)}
                            value={username}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                            onFocus={() => setUserFocus(true)}
                            onBlur={() => setUserFocus(false)}
                        />
                    </div>
                    <div className="email">
                        <label className="form__label" for="email">Email </label>
                        <input
                            type="text"
                            id="email"
                            ref={userRef}
                            autoComplete="off"
                            onChange={(e) => setEmail(e.target.value)}
                            value={email}
                            required
                            aria-invalid={validName ? "false" : "true"}
                            aria-describedby="uidnote"
                        />
                    </div>
                    <div className="password">
                        <label className="form__label" for="password">Password </label>
                        <input
                            type="password"
                            id="password"
                            onChange={(e) => setPassword(e.target.value)}
                            value={password}
                            required
                            aria-invalid={validPwd ? "false" : "true"}
                            aria-describedby="pwdnote"
                            onFocus={() => setPwdFocus(true)}
                            onBlur={() => setPwdFocus(false)}
                        />
                    </div>
                    <div className="confirm-password">
                        <label className="form__label" for="confirmPassword">Confirm Password </label>
                        <input
                            type="password"
                            id="confirm_pwd"
                            onChange={(e) => setMatchPwd(e.target.value)}
                            value={matchPwd}
                            required
                            aria-invalid={validMatch ? "false" : "true"}
                            aria-describedby="confirmnote"
                            onFocus={() => setMatchFocus(true)}
                            onBlur={() => setMatchFocus(false)}
                        />
                    </div>
                </div>
                <div class="footer">
                    <button disabled={!validName || !validPwd || !validMatch ? true : false} onClick={(event) => {
                        handleSubmit(event);
                        setOpenRegister(!openRegister);
                    }} type="submit" className="btn">Register
                    </button>
                    {openRegister && (
                        <p className="thankyou">Thank you for registering</p>
                    )}
                </div>
            </form>
        </form>
    )

    return (
        <div className="form">
            <div className="form--input">
                {isSubmitted ? <div>User is successfully registered</div> : renderForm}
            </div>
        </div>
    )
}

export default RegistrationForm;
