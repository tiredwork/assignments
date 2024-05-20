/**
  Solitare cards by Dion Kennedy
  Assignment 1
  
  This program was based off the work of Daniel Shiffman
  https://processing.org/examples/forceswithvectors.html
**/

// Adding the photo class handling
PImage photo;
// Adding the card function to the canvas
Mover[] movers = new Mover[10];

void setup() { //Setting up the canvas, calling the reset function so it's loaded, and making a photo varible to add the image.
  size(600, 600);
  reset();
  photo = loadImage("SolitareCard.png");
  background(0);
  
  // Setting up varibles
  int d = day();
  int m = month();
  int y = year();
  int h = hour();
  int min = minute();
  int sec = second();
    
  // Printing the current date and time to the console
  println("Today is " + d + "/" + m + "/" + y + " " + h + ":" + min + ":" + sec);
}

void draw() {
  for (Mover mover : movers) {
    // Gravity is scaled by mass here!
    PVector gravity = new PVector(0.07, 0.2*mover.mass);
    // Apply gravity
    mover.applyForce(gravity);

    // Update and display
    mover.update();
    mover.display();
    mover.checkEdges();
  }
// Text at the top of the screen with instructions for the player
  fill(200);
  stroke(1);
  textSize(20);
  text("Click mouse to spawn a new card", 115, 30);
  text("Drag the mouse to move the card around", 115, 55);
}

void mouseDragged() {
  reset();
}

void mousePressed() {
  reset();
}

// Spawns a new card wherever the mouse is on the screen
void reset() {
  for (int i = 0; i < movers.length; i++) {
    movers[i] = new Mover(mouseY-30, mouseX-30,100);
  }
}
