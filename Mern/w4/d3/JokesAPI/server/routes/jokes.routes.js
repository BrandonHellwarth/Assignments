const JokeController = require('../controllers/jokes.controller');
module.exports = function(app){
    app.post('/api/jokes/create', JokeController.createJoke);
    app.get('/api/jokes', JokeController.getAllJokes);
    app.get('/api/jokes/:id', JokeController.getJoke);
    app.put('/api/jokes/:id', JokeController.updateJoke);
    app.delete('/api/jokes/:id', JokeController.deleteJoke);
}