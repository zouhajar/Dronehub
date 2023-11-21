function displayFormValues() {
    // Get query string values
    var queryString = window.location.search;
    var urlParams = new URLSearchParams(queryString);

    // Set values to HTML elements
    document.getElementById("nom").textContent = urlParams.get("nom");
    document.getElementById("email").textContent = urlParams.get("email");
    document.getElementById("telephone").textContent = urlParams.get("telephone");
}

// Call function to display form values
displayFormValues();