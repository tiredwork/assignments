public class Game extends Product {
    private String genre;
    private String ageRating;

    // Constructor
    public Game(String name, String platform, double price, int quantity, String releaseDate,
                String genre, String ageRating) {
        super(name, platform, price, quantity, releaseDate);
        this.genre = genre;
        this.ageRating = ageRating;
    }

    // Getters and setters
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAgeRating() {
        return ageRating;
    }
    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    // Implemented abstract method
    @Override
    public String getType() {
        return "Game";
    }
    @Override
    public String toString() {
        return "Game: " + getName() + " (" + getPlatform() + ") " + getGenre() + ", €" +
                String.format("%.2f", getPrice()) + ", " + getReleaseDate() + ", " +
                getQuantity() + " in stock, rated " + getAgeRating();
    }
}