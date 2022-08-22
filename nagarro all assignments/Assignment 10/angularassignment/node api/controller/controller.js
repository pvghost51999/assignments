const con = require('../dbconnecntion');
const jwt = require('jsonwebtoken');

const funct = require('./loginController')

module.exports.read = (req, res) => {
    //verify token
    // check = funct.verifyToken(req.token);
    // console.log(check.status, "reading status");
    // if (check.status) {
        var qr = "select RNO,NAME,DATE(DOB) as date,MARKS from results";
        var qr = "select RNO,NAME, DATE_FORMAT(DOB,'%Y-%M-%D') as DOB, MARKS from results";

        con.query(qr, (err, result) => {
            if (err) {
                console.log("erro" + err.errno);
            }
            console.log(result);
            res.send(result);
        })
    }
    // else {
    //     res.send({

    //         status: false,
    //         msg: "invalid token"
    //     });
    // }


module.exports.create = (req, res) => {

    let rno = req.body.RNO;
    let name = req.body.NAME;
    let dob = req.body.DOB;
    let marks = req.body.MARKS;
    console.log("hello", rno, name, dob);
    let qr = `insert into results(RNO,NAME,DOB,MARKS) 
    values('${rno}','${name}','${dob}','${marks}')`;
    console.log(rno, name, dob, marks);
    //verify token
    // check = funct.verifyToken(req.token);
    // console.log(check.status, "creating status status");

    // if (check.status) 
    // {
        con.query(qr, (err, result) => {
            if (err) {
                console.log("erro" + err.message);
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

module.exports.delete = (req, res) => {

    let getId = req.params.id;
    let qr = `DELETE from results where RNO=${getId}`;
    //verify token
    // check = funct.verifyToken(req.token);
    // console.log(check.status, "creating status status");

    // if (check.status) 
    // {
    con.query(qr, (err, result) => {
        if (err) {
            console.log("erro" + err.errno);
        }
        console.log(result);
        res.send(result)

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


module.exports.edit = (req, res) => {


    let getId = req.params.id;
    let name = req.body.NAME;
    let dob = req.body.DOB;
    let marks = req.body.MARKS;


    let qr = `update results 
    set NAME='${name}',DOB='${dob}',MARKS='${marks}'
    where RNO='${getId}'`;
    console.log(name, dob, marks);

    //verify token
    // check = funct.verifyToken(req.token);
    // console.log(check.status, "creating status status");

    // if (check.status) 
    // {
    con.query(qr, (err, result) => {
        if (err) {
            console.log("erro" + err.message);
        }
        else {
            console.log(result);
            res.send(result);
        }

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


