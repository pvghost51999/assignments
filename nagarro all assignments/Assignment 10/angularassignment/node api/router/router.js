const express=require('express');
// app.use(express.json());
const router=express.Router();

const controller=require('../controller/controller')
const loginController=require('../controller/loginController')
const singleData=require('../controller/studentController');
router.get('/details',requiredToken,controller.read);
router.post('/details',requiredToken,controller.create);
router.delete('/details/:id',requiredToken,controller.delete);
router.put('/details/:id',requiredToken,controller.edit);
router.post('/login',requiredToken,loginController.login);
router.get('/details/:id',requiredToken,singleData.single);


function requiredToken(req,res,next)
{

let headers=req.headers["token"];
console.log(headers,"token in router");

if(typeof headers!==undefined && headers!=="")
{
    req.token=headers;
    next();
}

else
{
    res.send({

        status:false,
        msg:"token required"
    })
}


}
module.exports=router;   
