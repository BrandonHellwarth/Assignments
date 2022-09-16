import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useParams, useNavigate, Link } from "react-router-dom";
import AuthorForm from '../components/AuthorForm';

const Edit = (props) => {
    const redirect = useNavigate();
    const { id } = useParams();
    const [author, setAuthor] = useState();
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:8000/api/authors/' + id)
            .then(res => {
                setAuthor(res.data);
                setLoaded(true);
            })
    }, []);

    const updateAuthor = author => {
        axios.put('http://localhost:8000/api/authors/' + id, author)
            .then(res => console.log(res))
            .catch(err => console.error(err));
        redirect("/authors");
    }

    return (
        <div>
            {loaded && 
                <div>
                    <h1>Update Author</h1>
                    <Link to={"/authors"}>Home</Link>
                    <AuthorForm onSubmitProp={updateAuthor} initialName={author.title}/>
                </div>
            }
        </div>
    )
}

export default Edit;