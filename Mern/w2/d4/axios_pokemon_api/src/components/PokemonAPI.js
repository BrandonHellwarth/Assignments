import React, {useEffect, useState} from 'react';
import axios from 'axios';

const PokemonAPI = props =>{
    const [pokemon, setPokemon] = useState([]);
    const [clicked, setClicked] = useState(false);

    useEffect(() => {
        axios.get('https://pokeapi.co/api/v2/pokemon?offset=0&limit=10000')
            .then(response => setPokemon(response.data.results))
    }, []);
    return(
        <div>
            <button onClick={ () => setClicked(true) }>Fetch Pokemon</button>
            {
                clicked === true &&
                pokemon.map((poke, i) => {
                    return <li key={i}>{ poke.name }</li>
                })
            }
        </div>
    );
}

export default PokemonAPI;