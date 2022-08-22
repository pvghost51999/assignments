let names = document.querySelector("#fname")
let mail = document.querySelector("#email")
let web = document.querySelector("#web")
let image = document.querySelector("#image")
let clik = document.querySelector("#reg")
let clear = document.querySelector("#clr")
let inpt = document.querySelectorAll(".inpt")
let check = document.querySelectorAll(".check")
let checkbox=document.querySelectorAll(".checkbox");
let radio=document.querySelectorAll(".radio");

// *********************enrolled button click***********************

clik.addEventListener('click', () => {
    // *****************regular expression for mail***************
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    let c = 0;
    if (!(mail.value.match(mailformat))) {
        mail.style.borderColor = "red";
        c = 1;

    }
    else
        mail.style.borderColor = null;
// *****************regular expression for Name***************
    var letters = /^[a-zA-Z ]*$/;;
    if (!(names.value.match(letters))) {
        names.style.borderColor = "red";
        c = 1;

    }
    else
        names.style.borderColor = null;

    // *****************regular expression for Weblink***************
    var expression =
        /[-a-zA-Z0-9@:%_\+.~#?&//=]{2,256}\.[a-z]{2,4}\b(\/[-a-zA-Z0-9@:%_\+.~#?&//=]*)?/gi;
    if (!(web.value.match(expression))) {
        web.style.borderColor = "red";
        c = 1;
    }

    else
        web.style.borderColor = null;

    // *****************regular expression for ImageLink***************
    var imageLink = /^http[^\?]*.(jpg|jpeg|gif|png|tiff|bmp)(\?(.*))?$/gmi;
    if (!(image.value.match(imageLink))) {
        image.style.borderColor = "red";
        c = 1;
    }
    else
        image.style.borderColor = null;

    if (c === 1) {
        alert("Please fill the red Boxes properly");
        c = 0
    }

    else {
        if(!(radio[0].checked) && !(radio[1].checked))
        {
            alert("Please Select your Gender")
        }
        else
        insert();

    }


})
// **************value function will retrieve the value of text field and store it into contain object*******
function values() {
    
    var contain = {}
    var store="";
    for(let i=0;i<3;i++)
    {
        if(checkbox[i].checked)
        store+=checkbox[i].value+","
    }
    store = store.slice(0, -1);
    contain["name"] = names.value;
    contain["gender"] = document.querySelector('input[name="genderm"]:checked').value
    contain["mail"] = mail.value;
    contain["web"] = web.value;
    contain["image"] = image.value;
    contain["skills"]=store
    return contain;

}

// ***************************insert the values into table through insert function*******************
function insert() {
    var array = []

    
    var data = values();
    var table = document.getElementById("storeList").getElementsByTagName('tbody')[0];

    var newRow = table.insertRow(table.length);
    cell1 = newRow.insertCell(0);

    cell1.innerHTML = data.name + "<br>" + data.gender + "<br>" + data.mail + "<br>" + "<a href=" + data.web + ">" + data.web + "</a>" + "<br>" + data.image + "<br>"+data.skills;
    var img = document.createElement('img');
    if(data.gender=="Male")
        img.src = "images.jpg";
    else
    img.src="girl.jpg"

    img.style = "height:100%;width:100%"
    cell2 = newRow.insertCell(1);
    cell2.style = "width:25%;"
    cell2.innerHTML = "";
    cell2.appendChild(img);
    // alert("Enrolled Successfully")
    var x=document.querySelector(".had");
    x.style.fontSize = 2 + "em";
    x.innerHTML="Enrolled Successfully"
    x.style.color="green";
    setTimeout("function1()", 500);
    

}
function function1()
{
    var x=document.querySelector(".had");
    
    x.style.fontSize = 1.5 + "em";
    x.innerHTML="Enrolled Students"
    x.style.color="black";
}

// ****************************************clear funtion*********************************
clear.addEventListener('click', () => {
    inpt.forEach(clr => clr.value = '');
    inpt.forEach(clr => clr.style.borderColor = null);
    check.forEach(ch => ch.checked = false)

})


