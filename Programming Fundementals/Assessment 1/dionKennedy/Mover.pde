/**
  Solitare cards by Dion Kennedy
  Assignment 1
  
  This program was based off the work of Daniel Shiffman
  https://processing.org/examples/forceswithvectors.html
 */

class Mover {

  // position, velocity, and acceleration 
  PVector position;
  PVector velocity;
  PVector acceleration;

  // Mass is tied to size
  float mass;
  
  //I set the mass to be consistent here so it's not random 
  Mover(int m, int x, int y) {
    mass = 10;
    position = new PVector(mouseX, mouseY);
    velocity = new PVector(0, 0);
    acceleration = new PVector(0, 0);
  }

  // Newton's 2nd law: F = M * A
  // or A = F / M
  void applyForce(PVector force) {
    // Divide by mass 
    PVector f = PVector.div(force, mass);
    // Accumulate all forces in acceleration
    acceleration.add(f);
  }

  void update() {
    // Velocity changes according to acceleration
    velocity.add(acceleration);
    // position changes by velocity
    position.add(velocity);
    // We must clear acceleration each frame
    acceleration.mult(0);
  }

  // Draw Mover
  void display() {
    // The playing card
    image(photo,position.x, position.y, mass*10, mass*10);
  }

  // Bounce off bottom of window
  void checkEdges() {
    if (position.y > 500) { //This checks it against the top of the card so the position is off by 100 to account for it hitting the bottom of the screen.
      velocity.y *= -0.8;  // A little dampening when hitting the bottom
      position.y = 500; 
    }
  }
}
