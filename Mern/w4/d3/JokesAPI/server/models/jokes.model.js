const mongoose = require('mongoose');
const JokeSchema = new mongoose.Schema({
    name: { type: String },
    description: { type: String }
}, { timestamps: true });
module.exports.Joke = mongoose.model('Joke', JokeSchema);