const { Joke } = require('../models/jokes.model');

module.exports.getAllJokes = (request, response) => {
    Joke.find({})
        .then(jokes => response.json(jokes))
        .catch(err => response.json(err))
}

module.exports.getJoke = (request, response) => {
    Joke.findOne({_id:request.params.id})
        .then(joke => response.json(joke))
        .catch(err => response.json(err))
}

module.exports.createJoke = (request, response) => {
    const { name, description } = request.body;
    Joke.create({
        name,
        description
    })
        .then(joke => response.json(joke))
        .catch(err => response.json(err));
}

module.exports.updateJoke = (request, response) => {
    Joke.findOneAndUpdate({_id: request.params.id}, request.body, {new:true})
        .then(updatedJoke => response.json(updatedJoke))
        .catch(err => response.json(err))
}

module.exports.deleteJoke = (request, response) => {
    Joke.deleteOne({ _id: request.params.id})
        .then(deleteConfirmation => response.json(deleteConfirmation))
        .catch(err => response.json(err))
}