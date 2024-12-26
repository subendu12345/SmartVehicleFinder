document.addEventListener("DOMContentLoaded", function () {
    console.log("*******************************************>>>>>>>>");
    const input = document.getElementById("searchable-input");

    let debounceTimeout;

    fetch(`/public/get-default-vehicles`).then((res) => {
        console.log("res " + JSON.stringify(res));
        res.json().then((jsondata) => {
            rendarResponse(jsondata);
        }).catch(err => {
            console.log("Error: " + err);
        });
    });

    // Debounce function
    function debounce(func, delay) {
        return function (...args) {
            clearTimeout(debounceTimeout);
            debounceTimeout = setTimeout(() => func.apply(this, args), delay);
        };
    }

    if (input) {
        // Add debounce to input event
        input.addEventListener("input", debounce(getVehicles, 1000));
    }

    function getVehicles() {
        let searchValue = input.value.trim();
        if (searchValue.length > 3) {
            fetch(`/public/get-vehicles?pincode=${searchValue}`).then((res) => {
                console.log("res " + JSON.stringify(res));
                res.json().then((jsondata) => {
                    rendarResponse(jsondata);
                });
            });
        }
    }

    /**
     * 
     * <div class="card" style="width: 18rem;">
      <div class="card-body">
        <h5 class="card-title">Card title</h5>
        <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
        <a href="#" class="card-link">Card link</a>
        <a href="#" class="card-link">Another link</a>
      </div>
    </div>
     */
    function rendarResponse(data) {
        console.log("data " + JSON.stringify(data));
        const vehicleCardsContainer = document.getElementById('vehicle-cards');
        vehicleCardsContainer.innerHTML = "";
        data.forEach((element) => {
            console.log("element " + JSON.stringify(element));

            // Creating the structure const
            const card = document.createElement('div');
            card.style.paddingBottom = '2%';
            card.classList.add('col');

            card.innerHTML = `
                        <div class="card h-100">
                            <i class="bi bi-car-front"></i>
                            <div class="card-body">
                                <h5 class="card-title">${element.vehicle.name}</h5>
                                <p class="card-text"><b>Brand:</b> ${element.vehicle.brand}</p>
                                <p class="card-text"><b>Model:</b> ${element.vehicle.model}</p>
                                <p class="card-text"><b>Owner:</b> ${element.busOwner}</p>
                                <p class="card-text"><b>Pincode:</b> ${element.vehicle.pincode}</p>
                                <p class="card-text"><b>Phone:</b> ${element.ownerPhone}</p>
                            </div>
                        </div>
                    `;
            // Append the card to the container
            vehicleCardsContainer.appendChild(card);
        });
    }

});
