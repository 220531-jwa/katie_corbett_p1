let baseURL = "http://localhost:8080/employee";

async function submitRequest(){
    console.log("submit button pressed");
    let uid = document.getElementById('uid').value;
    let fname = document.getElementById('fname').value;
    let lname = document.getElementById('lname').value;
    let date = document.getElementById('date').value;
    let time = document.getElementById('time').value;
    let type = document.getElementById('training').value;
    let desc = document.getElementById('desc').value;
    let cost = document.getElementById('cost').value;
    let justify = document.getElementById('justify').value;
    let gradetype = document.getElementById('grade').value;

    let request = {
        user_id: uid,
        employee_first_name: fname,
        employee_last_name: lname,
        request_date: date,
        request_time: time,
        trainingType: type,
        description: desc,
        request_cost: cost,
        request_justification: justify,
        gradeType: gradetype
    }

    console.log(request);

    let requestJson = JSON.stringify(request);
    console.log(requestJson);

    let res = await fetch(
        `${baseURL}/submit`,
        {
            method : 'POST',
            header : {'Content-Type': 'application/json'},
            body: requestJson
        }
    );

    let resJson = await res.json()
        .then((resp) => {
            console.log(resp);
            window.location.assign("requestSubmit.html");
        })
        .catch((error) => {
            console.log(error);
            window.location.assign("requestNotSubmit.html");
        });
}

function resubmitRequest(){
    window.location.assign("submit.html");
}
function backToHp(){
    window.location.assign("employee.html");
}

async function createTable(){
    let location = document.getElementById("requestTable");
    
}