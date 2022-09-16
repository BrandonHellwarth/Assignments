import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import AuthorForm from '../components/AuthorForm';

const Create = (props) => {
    const redirect = useNavigate();

    const createAuthor = author => {
        console.log(author);
        axios.post('http://localhost:8000/api/authors/create', author)
            .then(res => console.log(res))
            .catch(err => console.error(err))
            redirect("/authors");
    }

    return (
        <div>
            <h1>Favorite Authors</h1>
            <Link to={"/authors"}>Home</Link>
            <AuthorForm onSubmitProp={createAuthor} initialName=""/>
        </div>
    );
}

export default Create;