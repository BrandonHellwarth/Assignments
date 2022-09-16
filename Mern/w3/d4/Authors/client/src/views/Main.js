import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import AuthorList from '../components/AuthorList'

const Main = (props) => {
    const [authors, setAuthors] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(()=>{
        axios.get('http://localhost:8000/api/authors')
            .then(res=>{
                setAuthors(res.data);
                setLoaded(true);
            })
            .catch(err => console.error(err));
    }, []);

    const removeFromDom = authorId => {
        setAuthors(authors.filter(author => author._id != authorId));
    }

    return (
        <div>
            <h1>Favorite Authors</h1>
            <Link to={"/authors/create"}>Add an Author</Link>
            {loaded && <AuthorList authors={authors} removeFromDom={removeFromDom}/>}
        </div>
    )
}

export default Main;