import {useState} from "react";

export const AddUser = () => {

    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    return (
        <form>
            <label>
                First name:
                <input type="text" name="firstname"/>
            </label>
            <label>
                Last name:
                <input type="text" name="lastname"/>
            </label>
            <label>
                Email:
                <input type="text" name="email"/>
            </label>
            <label>
                Password:
                <input type="text" name="password"/>
            </label>
            <input type="submit" value="Submit"/>
        </form>
    )
}