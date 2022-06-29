let baseURL = "http://localhost:8080";

async function login(){
    console.log("login button pressed");

    let uname = document.getElementById('uname').value;
    let pass = document.getElementById('pword').value;

    let user = {
        username: uname,
        pword: pass
    }

    console.log(user);
    
    let userJson = JSON.stringify(user);
    console.log(userJson);

    let res = await fetch(
        `${baseURL}/login`,
        {
            method : 'POST',
            header : {'Content-Type': 'application/json'},
            body: userJson
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            if(resp.usertype == 1){
                window.location.assign("employee.html");
            } 
            else if(resp.usertype == 2){
                window.location.assign("financemgr.html");
            }
            
        })
        .catch((error) => {
            console.log(error);
        });
}