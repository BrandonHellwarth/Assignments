import React, { useState } from 'react';

const PersonCard = props => {
    const [state, setState] = useState({
        age: props.age
    });
    const incrementAge = () => { 
        console.log("working");
        setState({age : parseInt(state.age) + 1});
    }
    return(
        <div>
            <h1>{props.firstName}, 
            {props.lastName}</h1>
            <p>Age: {state.age}</p>
            <p>Hair Color: {props.hairColor}</p>
            <button onClick={ incrementAge }>Birthday Button for {props.firstName} {props.lastName}</button>
        </div>
    );
}

export default PersonCard;