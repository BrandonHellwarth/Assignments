import React, { useState } from 'react'

export default props => {
    const { initialName, onSubmitProp } = props
    const [name, setName] = useState(initialName); 
    
    const onSubmitHandler = e => {
        e.preventDefault();
        onSubmitProp({ name });
    }
    return (
        <form onSubmit={onSubmitHandler}>
            <p>
                <label>Name</label><br/>
                <input type="text" onChange={(e)=>setName(e.target.value)} value={name}/>
            </p>
            <input type="submit"/>
        </form>
    )
}