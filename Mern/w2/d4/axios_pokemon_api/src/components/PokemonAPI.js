import React, {useEffect, useState} from 'react';

const PokemonAPI = props =>{
    const [pokemon, setPokemon] = useState([]);
    const [clicked, setClicked] = useState(false);

    useEffect(() => {
        fetch('https://pokeapi.co/api/v2/pokemon?offset=0&limit=10000')
            .then(response => response.json())
            .then(response => setPokemon(response.results))
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