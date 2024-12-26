document.addEventListener("DOMContentLoaded", function () {
    let loggedInUserId = document.getElementById("loggedInUserId");
    let closeModalBtn = document.getElementById("vehicleCloseModal");
    let userVehicleList = [];
    if (loggedInUserId) {
        loggedInUserId = loggedInUserId.value;
        fetch(`/user/get-vehicles?userId=${loggedInUserId}`).then((res) => {
            res.json().then((jsondata) => {
                rendarResponse(jsondata);
            }).catch(err => {
                console.log("Error: " + err);
            });
        });

    }

    function rendarResponse(data) {
        console.log("data " + JSON.stringify(data));
        userVehicleList = data;
        const tableBody = document.getElementById('ownerCarListTableBody');
        console.log("data " + JSON.stringify(data));
        let count = 1;
        data.forEach(element => {
            let row = document.createElement('tr');
            row.innerHTML = `<td>${count}</td>
                            <td>${element.name}</td>
                            <td>${element.vehicle_number}</td>
                            <td>${element.brand}</td>
                            <td>${element.model}</td>
                            <td>
                                <button class="btn btn-warning btn-sm update-btn">Update</button>
                                <button class="btn btn-danger btn-sm delete-btn">Delete</button>
                            </td>`;

            tableBody.appendChild(row);

            // Add event listeners for update and delete buttons
            const deleteBtn = row.querySelector('.delete-btn');
            const updateBtn = row.querySelector('.update-btn');

            deleteBtn.addEventListener('click', () => {
                console.log("Delete button clicked");
            });

            updateBtn.addEventListener('click', () => {
                // Access the row associated with the clicked button
                const row = updateBtn.parentElement.parentElement;

                // Find the index of the row
                const rows = Array.from(tableBody.children); // Convert table rows (HTMLCollection) to an array
                const rowIndex = rows.indexOf(row); // Get the index of the clicked row

                console.log(`Row index: ${rowIndex}`);
                updateVehicle(rowIndex);

                // Example: Use rowIndex to display row-specific data
                // const currentVehicleNumber = row.children[1].textContent;
                // const currentVehicleModel = row.children[2].textContent;

                // console.log(`Vehicle Number: ${currentVehicleNumber}`);
                // console.log(`Vehicle Model: ${currentVehicleModel}`);

            });

            count++;

        });
    }

    function updateVehicle(index) {
        console.log("Update method index " + index);
        const modalElement = document.getElementById('exampleModal');

        // Create an instance of the Bootstrap modal
        const modalInstance = new bootstrap.Modal(modalElement);

        // Show the modal
        modalInstance.show();
        console.log("Update method userVehicleList " + JSON.stringify(userVehicleList[index]));
    }

});