// An array of objects to store quiz questions, answers and images
const myQuestions = [
    {
        question: "What is the name of this bridge?",
        answers: {
            a: "London Bridge",
            b: "Tower Bridge",
            c: "Westminster Bridge",
            d: "Hungerford Bridge"
        },
        correctAnswer: "b",
        imgURL: "https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Tower_Bridge_from_Shad_Thames.jpg/1200px-Tower_Bridge_from_Shad_Thames.jpg"
    },
    {
        question: "What is the name of this monument?",
        answers: {
            a: "Eiffel Tower",
            b: "Taj Mahal",
            c: "Big Ben",
            d: "Statue of Liberty"
        },
        correctAnswer: "d",
        imgURL: "https://redaroundtheworld.com/wp-content/uploads/2018/03/DSCN3508.jpg"
    },
    {
        question: "What is the name of this monument?",
        answers: {
            a: "Peterhof Palace",
            b: "Winter Palace",
            c: "St. Basil's Cathedral",
            d: "Kremlin"
        },
        correctAnswer: "c",
        imgURL: "http://1.bp.blogspot.com/-eLOk0Lwosgc/UsmTezBfdoI/AAAAAAAARIs/bNiIzmPb1CE/s0/St.+Basil%E2%80%99s+Cathedral+(2).jpg=s0?imgmax=0"
    },
    {
        question: "What is the name of this location?",
        answers: {
            a: "Chiang Mai",
            b: "Golden Chedi",
            c: "Wat Pho",
            d: "Wat Mangkon Kamalawat"
        },
        correctAnswer: "a",
        imgURL: "https://bing.com/th?id=OSGI.7F8CC835A16FC91423130CE6364B2A0E"
    }
];

function showQuestion(question) {

    // Get the element where we will display the question
    const element = document.getElementById("quiz");

    // Create an HTML string to hold the question content
    let output = "";

    // Add the question text
    output += `<h2 class="ui center aligned attached header">${question.question}</h2>`;

    // Add the image using imgURL property
    output += `<div class="ui segment"><img src='${question.imgURL}' class='ui centered image'>`;

    // Add a list of possible answers using Semantic UI radio buttons
    output += `<form class="ui form"><div class="grouped fields">${Object.entries(question.answers).map(([letter, answer]) => `<div class="field"><div class="ui radio checkbox"><input type="radio" name="answer" value="${letter}" id="${letter}"><label for="${letter}">${letter.toUpperCase()}. ${answer}</label></div></div>`).join('')}</form>`;

    // Display the HTML string on the element
    element.innerHTML = output;

    // Initialize Semantic UI radio buttons 
    $('.ui.radio.checkbox').checkbox();
}
// A function to check the user's answer and keep track of score
function checkAnswer(question) {

    // Get all radio buttons with name 'answer'
    var radios = document.getElementsByName("answer");

    // Loop through each radio button and check if it is checked
    for (var i = 0; i < radios.length; i++) {
        if (radios[i].checked) {
            // Get the value of the checked radio button
            var answer = radios[i].value;

            // Compare it with the correct answer of the question
            if (answer === question.correctAnswer) {
                // If they match, increment score by one
                score++;
            }
        }
    }
}

// A function to show feedback and display results
function showResults() {

    var element = document.getElementById("results");
    var output = "";

    if (score === myQuestions.length) {
        output = `<h2>Congratulations! You aced this quiz!</h2>`;
    } else if (score > 0) {
        output = `<h2>Good job! You got ${score} out of ${myQuestions.length} questions right.</h2>`;
    } else {
        output = `<h2>Sorry, you didn't get any questions right. Better luck next time!</h2>`;
    }

    element.innerHTML = output;
    $(element).show();
}

// A variable to store current question index
var currentQuestion = 0;

// A variable to store current score
var score = 0;

// Show first question when page loads 
showQuestion(myQuestions[currentQuestion]);

// Get submit button element 
var submitButton = document.getElementById("submit");

// Add click event listener to submit button 
submitButton.addEventListener("click", function () {

    // Check user's answer for current question 
    checkAnswer(myQuestions[currentQuestion]);

    // Increment current question index by one 
    currentQuestion++;

    // Check if there are more questions left 
    if (currentQuestion < myQuestions.length) {
        // If yes, show next question 
        showQuestion(myQuestions[currentQuestion]);
    } else {
        // If no, hide quiz and submit button elements using Semantic UI hide method 
        $("#quiz").hide();
        $(submitButton).hide();

        // Show results 
        showResults();
    }
});