import React from 'react';
import { Link } from 'react-router-dom';
import DeleteButton from './DeleteButton';

const AuthorList = (props) => {
    return (
        <div>
            {props.authors.map((author, idx) => {
                return (
                    <div key={idx}>
                        <p>{author.name}</p>
                        <Link to={`/authors/${author._id}/edit`}>
                            Edit
                        </Link> 
                        |
                        <DeleteButton authorId={author._id} successCallback={()=>props.removeFromDom(author._id)}/>
                    </div>
                )
            })}
        </div>
    );
}
export default AuthorList;