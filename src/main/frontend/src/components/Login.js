import {useEffect, useRef, useState} from "react";
import '../styles/Login.css'

const Login = () => {

    const userRef = useRef();
    const errRef = useRef();

    const [user, setUser] = useState('');
    const [pwd, setPwd] = useState('');
    const [errMsg, setErrMsg] = useState('');
    const [success, setSuccess] = useState(false);

    useEffect(() => {
        userRef.current.focus();
    }, [])

    useEffect(() => {
        setErrMsg('');
    }, [user, pwd])

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(user, pwd);
        setUser('');
        setPwd('');
        setSuccess(true);
    }

    return (
        <>
            {success ? (
                <p1 className="form__label">You are logged in!</p1>
            ) : (
                <section>
                    <p ref={errRef} className={errMsg ? "errmsg" : "offscreen"} aria-live="assertive">{errMsg}</p>
                    <form className="form" onSubmit={handleSubmit}>
                        <div className="form-body">
                            <label className="form__label" htmlFor="username">Username:</label>
                            <input type="text"
                                   className="form__input"
                                   id="username"
                                   ref={userRef}
                                   autoComplete="off"
                                   onChange={(e) => setUser(e.target.value)}
                                   value={user}
                                   required
                            />
                            <label className="form__label" htmlFor="password">Password:</label>
                            <input type="password"
                                   className="form__input"
                                   id="password"
                                   onChange={(e) => setPwd(e.target.value)}
                                   value={pwd}
                                   required
                            />
                            <div className="footer">
                                <button className="btn">Log In</button>
                            </div>
                        </div>
                    </form>
                </section>
            )}
        </>
    )
};
export default Login