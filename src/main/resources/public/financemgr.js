let baseURL = "http://localhost:8080/financemgr";

var user = JSON.parse(sessionStorage.getItem("user"));
function runsetup(){
    console.log(user);
}

async function createTable(){
    document.getElementById('view').style.display='none';
    console.log("create table has been called");
    //get user ID 
    let user_id = user.user_id;
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
