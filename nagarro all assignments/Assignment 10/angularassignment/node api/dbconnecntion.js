const mysql =require('mysql');
const dbconnection=mysql.createConnection({
    host:"localhost",
    user:"root",
    password:"Password@123",
    database:"scorecard"
});

dbconnection.connect((err)=>{

    if(err)
    {
        console.warn("error"+err.message);
    }
    else
    {
        console.warn("connected");
    }

});  

module.exports=dbconnection;