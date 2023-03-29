// get input field, dropdown menu, and convert button
const tempInput = document.getElementById("temp-input");
const tempUnit = document.getElementById("temp-unit");
const outputUnit = document.getElementById("output-unit");
const convertBtn = document.getElementById("convert-btn");
const result = document.getElementById("result");

// calculate temperature based on input and unit
function calculateTemp() {
    // get input value and validate it
    const temp = parseFloat(tempInput.value);
    if (isNaN(temp)) {
        console.log("Invalid input");
        result.innerText = "Invalid input";
        return;
    }

    // get input and output unit
    const inputUnit = tempUnit.value;
    const output = outputUnit.value;

    // perform temperature conversion
    let convertedTemp;
    if (inputUnit === "celsius") {
        if (output === "fahrenheit") {
            convertedTemp = (temp * 9 / 5) + 32;
        } else if (output === "kelvin") {
            convertedTemp = temp + 273.15;
        } else {
            convertedTemp = temp;
        }
    } else if (inputUnit === "fahrenheit") {
        if (output === "celsius") {
            convertedTemp = (temp - 32) * 5 / 9;
        } else if (output === "kelvin") {
            convertedTemp = (temp - 32) * 5 / 9 + 273.15;
        } else {
            convertedTemp = temp;
        }
    } else if (inputUnit === "kelvin") {
        if (output === "celsius") {
            convertedTemp = temp - 273.15;
        } else if (output === "fahrenheit") {
            convertedTemp = (temp - 273.15) * 9 / 5 + 32;
        } else {
            convertedTemp = temp;
        }
    }

    // display result
    result.innerText = `${convertedTemp.toFixed(2)} ${output.toUpperCase()}`;
}

// add event listener to convert button
convertBtn.addEventListener("click", calculateTemp);
