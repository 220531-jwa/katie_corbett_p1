let baseURL = "http://localhost:8080/employee";

var user = JSON.parse(sessionStorage.getItem("user"));
function runsetup(){
    console.log(user);
}

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
    document.getElementById('view').style.display='none';
    console.log("create table has been called");
    //get user ID 
    let user_id = user.user_id;
    //send user ID + GET request
    let res = await fetch(
        `${baseURL}/requests/${user_id}`, 
        {
            method : 'GET', 
            header: {'Content-Type': 'application/json'}
        }
    );

    let resJson = await res.json()
        .then((resp) => { 
            console.log(resp);
             //display results in table
            var location = document.getElementById('requestsTable');
            let tableHeaders = ["Request ID", "User ID", "First Name", "Last Name", "Date", "Time",
            "Type of Training", "Description", "Cost", "Justification", "Type of Grade", "Status",
            "Proof", "Reimbursement Amount"];
            var table = document.createElement('table');
            table.border="1";
            var row_count = resp.length;
            console.log(row_count);
            var row = table.insertRow(-1);
            for(var i = 0; i < tableHeaders.length; i++){
                var headerCell = document.createElement('th');
                headerCell.innerHTML = tableHeaders[i];
                row.appendChild(headerCell);
            }
            for(var i = 0; i < row_count; i++){
                var row = table.insertRow(-1);
                let rowArray = Object.values(resp[i]);
                console.log(rowArray);
                for(var j = 0; j < tableHeaders.length; j++){
                    var cell = row.insertCell(-1);
                    cell.innerHTML = rowArray[j];
                }
            }
            location.appendChild(table);
        })
        .catch((error) => {
            console.log(error);
        });
}

async function submitChanges(){
    console.log("submit changes button pressed");
    let rid = document.getElementById('rid').value;
    let uid = document.getElementById('uid').value;
    let grade = document.getElementById('grade').value;

    let request = {
        proof: grade
    }
    console.log(request);

    let requestJson = JSON.stringify(request);
    console.log(requestJson);

    let res = await fetch(
        `${baseURL}/requests/${uid}/${rid}`, 
        {
            method: 'PUT',
            header: {'Content-Type': 'application/JSON'},
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