import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import DeleteButton from './DeleteButton';

const ProductList = (props) => {
    return (
        <div>
            {props.products.map((product, idx) => {
                return (
                    <p key={idx}>
                        <Link to={`/products/${product._id}`}>{product.title}</Link>
                        |
                        <Link to={`/products/${product._id}/edit`}>
                            Edit
                        </Link> 
                        |
                        <DeleteButton productId={product._id} successCallback={()=>props.removeFromDom(product._id)}/>
                    </p>
                )
            })}
        </div>
    );
}
export default ProductList;