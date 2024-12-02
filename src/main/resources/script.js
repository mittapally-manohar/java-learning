const colorButton = document.getElementById("colorButton");
const numberInput = document.getElementById("numberInput");
const errorMessage = document.getElementById("errorMessage");
let currentColoredBox = null;

colorButton.addEventListener("click", () => {
    const number = parseInt(numberInput.value);

    // Reset error message
    errorMessage.textContent = "";

    if (number < 1 || number > 9 || isNaN(number)) {
        errorMessage.textContent = "Please input a number between 1-9";
        return;
    }

    // Reset the previous colored box to white
    if (currentColoredBox) {
        currentColoredBox.style.backgroundColor = "white";
    }

    // Color the new box
    const box = document.getElementById("box" + number);
    if (box) {
        box.style.backgroundColor = "green";
        currentColoredBox = box;
    }
});
