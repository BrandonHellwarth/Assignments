import React from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const ProductList = (props) => {
    return (
        <div>
            {props.products.map( (product, i) =>
                <div>
                    <Link to={`/products/${product._id}`}>{product.title}</Link>
                    <p key={i}>{product.price}, {product.description}</p>
                </div>
            )}
        </div>
    )
}
export default ProductList;