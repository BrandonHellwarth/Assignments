const express = require('express');
const app = express();
require('./server/config/mongoose.config');
app.use(express.urlencoded({ extended: true }));
app.use(express.json());
require('./server/routes/jokes.routes')(app);
const port = 8000;
    
app.listen(port, () => console.log(`Listening on port: ${port}`) );