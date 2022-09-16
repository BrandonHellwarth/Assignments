const express = require('express');
const cors = require('cors');
const app = express();
require('./server/config/mongoose.config');
app.use(cors())
app.use(express.urlencoded({ extended: true }));
app.use(express.json());//need this so the server can accept raw json
require('./server/routes/author.routes')(app);
const port = 8000;
    
app.listen(port, () => console.log(`Listening on port: ${port}`) );