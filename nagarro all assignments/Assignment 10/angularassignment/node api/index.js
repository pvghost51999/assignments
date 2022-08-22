

const express=require('express');
const jwt = require('jsonwebtoken');
const cors = require('cors');
const app =express();
app.use(express.json());
const con=require("./dbconnecntion"); 

app.use(cors());
const routes=require('./router/router');
// app.use(cors());
app.use('/',routes);
app.listen(4500);
