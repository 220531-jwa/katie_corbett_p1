let baseURL = "http://localhost:8080/financemgr";


async function createTable(){
    document.getElementById('view').style.display='none';
    console.log("create table has been called");
    //send user ID + GET request
    let res = await fetch(
        `${baseURL}/fmrequests`, 
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

async function changeStatus(){
    console.log("Change status button pressed");
    let rid = document.getElementById('rid').value;
    let uid = document.getElementById('uid').value;
    let num = document.getElementById('num').value;

    let request = {
        status: num
    }
    console.log(request);

    let requestJson = JSON.stringify(request);
    console.log(requestJson);

    let res = await fetch(
        `${baseURL}/fmrequests/${uid}/${rid}`, 
        {
            method: 'PUT',
            header: {'Content-Type': 'application/JSON'},
            body: requestJson
        }
    );

    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        document.getElementById('changeConfirm').innerHTML = "change committed successfully";
    })
    .catch((error) => {
        console.log(error);
        document.getElementById('changeConfirm').innerHTML = "change not committed";
    });
}

async function updateReimburseAmt(){
    console.log("Change amount button pressed");
    let rid = document.getElementById('rid').value;
    let uid = document.getElementById('uid').value;
    let amt = document.getElementById('amt').value;

    let request = {
        reimburseamt: amt
    }
    console.log(request);

    let requestJson = JSON.stringify(request);
    console.log(requestJson);

    let res = await fetch(
        `${baseURL}/fmrequests/${uid}/${rid}/reimburse`, 
        {
            method: 'PUT',
            header: {'Content-Type': 'application/JSON'},
            body: requestJson
        }
    );

    let resJson = await res.json()
    .then((resp) => {
        console.log(resp);
        document.getElementById('changeConfirm').innerHTML = "change committed successfully";
    })
    .catch((error) => {
        console.log(error);
        document.getElementById('changeConfirm').innerHTML = "change not committed";
    });
}
