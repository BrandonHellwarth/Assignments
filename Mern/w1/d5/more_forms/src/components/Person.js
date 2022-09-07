import React, { useRef, useState } from 'react';

const Person = props => {
    const [firstName, setFirstName] = useState("");
    const [firstNameError, setFirstNameError] = useState("");
    const [lastName, setLastName] = useState("");
    const [lastNameError, setLastNameError] = useState("");
    const [email, setEmail] = useState("");
    const [emailError, setEmailError] = useState("");
    const [password, setPassword] = useState("");
    const [passwordError, setPasswordError] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [confirmPasswordError, setConfirmPasswordError] = useState("");
    const pw = useRef();

//use === for comparisons

    const handleFirstName = (e) => {
        setFirstName(e.target.value);
        if(e.target.value.length === 0){
            setFirstNameError("");
        }
        else if(e.target.value.length < 2){
            setFirstNameError("First name must be at least 2 characters.")
        }
        else{
            setFirstNameError("");
        }
    }

    const handleLastName = (e) => {
        setLastName(e.target.value);
        if(e.target.value.length == 0){
            setLastNameError("");
        }
        else if(e.target.value.length < 2){
            setLastNameError("Last name must be at least 2 characters.")
        }
        else{
            setLastNameError("");
        }
    }

    const handleEmail = (e) => {
        setEmail(e.target.value);
        if(e.target.value.length == 0){
            setEmailError("");
        }
        else if(e.target.value.length < 5){
            setEmailError("Email must be at least 5 characters.")
        }
        else{
            setEmailError("");
        }
    }

    const handlePassword = (e) => {
        setPassword(e.target.value);
        if(e.target.value.length == 0){
            setPasswordError("");
        }
        else if(e.target.value.length < 8){
            setPasswordError("Password must be at least 8 characters.")
        }
        else{
            setPasswordError("");
        }
    }

    const handleConfirmPassword = (e) => {
        setConfirmPassword(e.target.value);
        if(e.target.value.length == 0){
            setConfirmPasswordError("");
        }
        else if(e.target.value.length < 8){
            setConfirmPasswordError("Password must be at least 8 characters.")
        }
        else{
            setConfirmPasswordError("");
        }
        if(e.target.value != pw.current.value){
            setConfirmPasswordError("Passwords must match");
        }
    }


//there can only be on parent tag in a components return statement, so everything must be wrapped inside the first tag.
    return(
        <form>
            <div>
                <label>First Name: </label>
                <input type="text" onChange={ handleFirstName }/>
                {//if left side is true return right, if falsey returns left
                    firstNameError.length > 0 &&
                    <p>{ firstNameError }</p> 
                }
                {
                    firstNameError &&
                    <p>{ firstNameError }</p> 
                }
            </div>
            <div>
                <label>Last Name: </label>
                <input type="text" onChange={ handleLastName }></input>
                {
                    lastNameError ?
                    <p>{ lastNameError }</p> :
                    ''
                }
            </div>
            <div>
                <label>Email: </label>
                <input type="text" onChange={ handleEmail }></input>
                {
                    emailError ?
                    <p>{ emailError }</p> :
                    ''
                }
            </div>
            <div>
                <label>Password: </label>
                <input type="text" onChange={ handlePassword } ref={ pw }></input>
                {
                    passwordError ?
                    <p>{ passwordError }</p> :
                    ''
                }
            </div>
            <div>
                <label>Confirm Password: </label>
                <input type="text" onChange={ handleConfirmPassword }></input>
                {
                    confirmPasswordError ?
                    <p>{ confirmPasswordError }</p> :
                    ''
                }
            </div>
            <input type="submit" value="Create Person"></input>
            <div>
                <p>Your Form Data</p>
                <p>First Name: {firstName}</p>
                <p>Last Name: {lastName}</p>
                <p>Email: {email}</p>
                <p>Password: {password}</p>
                <p>Confirm Password: {confirmPassword}</p>
            </div>
        </form>
    );
}

export default Person;