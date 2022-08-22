const con=require('../dbconnecntion'); 
const jwt = require('jsonwebtoken');


module.exports.login=(req,res)=>{

    let email =req.body.email;
    let pass=req.body.password;
    let qr=`select * from teacher where email='${email}' and password='${pass}' `;
 
    con.query(qr,(err,result)=>
    {
     if(err)
     {
         console.log(err.message);
     }
     else if(result.length>0)
     {
         let data={
             email:this.email,
             pass:this.pass
         }

         const token = jwt.sign({data}, 'secretkey');
         res.send({
            status: true,
            token:token,
             msg: "invalid email id", 

         });
       
 
         console.log("token",token);
         // let message="no data found !!";
         // res.send(message){}
     }
     else
     {
         res.send({
             status: false,
             msg: "no data found !!",
           });
       
     }
 
    })
 }


 module.exports.verifyToken=function verifyToken(token)
 {

    return jwt.verify(token,'secretkey',(err,res)=>{
            
        if(err)
        {
            let a={status:false}
            return a;
        }

        else
        {

            let b={status:true}
            return b;
        }


    });
 }


