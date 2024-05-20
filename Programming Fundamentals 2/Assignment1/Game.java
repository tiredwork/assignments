public class Game {
    // Instance Variables
    private String name;
    private String platform;
    private double price;
    private String availability;

    // Constructor method
    public Game(String name, String platform, double price, String availability) throws IllegalArgumentException {
        this.name = name;
        this.platform = platform;
        this.price = price;
        this.availability = availability;
    }

    // Getters and Setters and toString methods

    //Getters
    public String getName() {
        return name;
    }

    public String getPlatform() {
        return platform;
    }

    public double getPrice() {
        return price;
    }

    public String getAvailability() {
        return availability;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    // toString
    public String toString() {
        return "Game details | " +
        "Game Title: " + name +
        " | Platform: " + platform +
        " | Price: " + price +
        " | Availability: " + availability + "\n";
    }
}