const con=require('../dbconnecntion'); 
const funct = require('./loginController')
//get single data
module.exports.single=(req,res)=>{

    // check = funct.verifyToken(req.token);
    // console.log(check.status, "creating status status");

    // if (check.status) 
    // {
    let getId=req.params.id;
    let qr=`select RNO ,NAME ,DATE_FORMAT(DOB,'%Y-%M-%D') as DOB ,MARKS from results where RNO=${getId}`;
    con.query(qr,(err,result)=>{
        if(err)
        {
            console.log("erro"+err.errno);
        }
        console.log(result);
        res.send(result);

}) 
// }
// else
// {
//     res.send({

//         status: false,
//         msg: "invalid token"
//     });
// }
    

}