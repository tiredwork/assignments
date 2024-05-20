// Assignment 2
// Dion Kennedy - 20101554
// Advent calendar

// Setting up imports
import javax.swing.*;
import processing.sound.*;
SoundFile file;
PImage photo;

// Declaring varibles
int d = day();
int m = month();
int squareSize = 120;
boolean soundOn = false;
ArrayList<snow> snowflakes = new ArrayList(); // sets the snow in an array list to make it easier to manage


void setup() {
  size(1000, 1000);
  photo = loadImage("bg.png");
  image(photo, 0, 0);
  consoleOutput();
  
  // Shows a message on startup
  if (m == 12 && d <= 25) { // Does a check using the system date to see if it is December 1st-25th
    JOptionPane.showMessageDialog(null,
      "Welcome to this Christmas Advent Calendar", "Advent Calendar",
      JOptionPane.INFORMATION_MESSAGE);
    calendarDates();
  } else { // The program will close if it is not December 1st-25th
    JOptionPane.showMessageDialog(null,
      "Sorry, Chrismas is now over, please try again next year!", "Advent Calendar",
      JOptionPane.INFORMATION_MESSAGE);
    exit();
  }
  
  // Controls how much snow is going to be added
  for (int iter = 0; iter < 250; iter++) {
    snowflakes.add(new snow());
  }
  
  // Loads a song and plays it in the background
  file = new SoundFile(this, "christmas.mp3");
  file.play();
  soundOn = true;
  
}      


void draw() {
  image(photo, 0, 0);
  // Prints Merry Christmas and inttructions to the screen
  fill(0);
  textSize(100);
  text("Merry\nChristmas", 250,350);
  textSize(50);
  text("Click on the mouse to pause the music\nand press on the keyboard to play it.",100,900);
  // This calls the render function in the snow class to render the particles to the screen
  for (snow thisSnow : snowflakes) {
    thisSnow.render();
  }
}

// This is a list of all the prizes you get from the calandar every day in December until the 25th 
void calendarDates() {
  String[] prizes = new String[26];
  prizes[0] = "null"; //This will never be used as the day function will never return 0
  prizes[1] = "a pair of socks.";
  prizes[2] = "a jumper.";
  prizes[3] = "a free hot chocolate.";
  prizes[4] = "a copy of Elf on DVD.";
  prizes[5] = "a tree ornament.";
  prizes[6] = "a Mariah Carey CD.";
  prizes[7] = "a candy cane.";
  prizes[8] = "a carton of Eggnog.";
  prizes[9] = "a tin of gingerbread men.";
  prizes[10] = "a toy snowman.";
  prizes[11] = "a pair of comfy slippers.";
  prizes[12] = "a 1-year Netflix subscription gift card.";
  prizes[13] = "a snowglobe.";
  prizes[14] = "a chocolate bar.";
  prizes[15] = "the new Pokémon game.";
  prizes[16] = "a can of deodrant or perfume.";
  prizes[17] = "a cute Christmas hat.";
  prizes[18] = "a small Nerf gun.";
  prizes[19] = "a Christmas door wreath.";
  prizes[20] = "a plushie of Santa.";
  prizes[21] = "a yule log.";
  prizes[22] = "a Christmas candle holder.";
  prizes[23] = "a bottle of sherry.";
  prizes[24] = "a Christmas cake.";
  prizes[25] = "a brand new Nintendo Switch, merry Christmas!";
  JOptionPane.showMessageDialog(null,
    "Today is day " + d + " of Christmas\nYour gift today is " + prizes[d], "Advent Calendar",
    JOptionPane.INFORMATION_MESSAGE);
}

void consoleOutput() {
  int i = 1;
  // Here's the while loop :D
 while (i < 2) {
 System.out.println("Merry Christmas!"); //Prints Merry Christmas to the console once
 i++; 
 }
 System.out.println("The month is " + m + " and the day is " + d); // Debugging the day and month values
}

class snow {
  // declares the varibles needed
  float xPos, yPos, xSpeed, ySpeed, size;

  // constructs the snow particles with parameters
  snow() {
    xPos = random(width);
    yPos = random(height);
    xSpeed = random(-10/2, 20/2);
    ySpeed = random(1, 5/2);
    size = random(5, 20);
  }

  // resets the pootions of the snow particles around the screen so that we don't need to keep drawing new ones
  void render() {
    xPos += xSpeed;
    yPos += ySpeed;
    if (yPos > height) {
      yPos = 0;
    }
    if (xPos > width) {
      xPos = 0;
    }
    if (xPos < 0) {
      xPos = 0;
    }
    fill(255);
    ellipse(xPos, yPos, size, size);
  }
}

// Music manipulation using the keybaord and the mouse
void mouseClicked() {
 file.stop();
 soundOn = false;
}

void keyPressed() {
   if (keyPressed == true && soundOn == false) {
    file.play();
    soundOn = true;
  }
}
