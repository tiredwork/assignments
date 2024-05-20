
public class GameConsole extends Product {
    private String storageSize;

    // Constructor
    public GameConsole(String name, String platform, double price, int quantity, String releaseDate,
                       String storageSize) {
        super(name, platform, price, quantity, releaseDate);
        this.storageSize = storageSize;
    }

    // Getters and setters
    public String getStorageSize() {
        return storageSize;
    }
    public void setStorageSize(String storageSize) {
        this.storageSize = storageSize;
    }

    // Implemented abstract method
    @Override
    public String getType() {
        return "GameConsole";
    }

    @Override
    public String toString() {
        return "GameConsole | " +
                "Name=" + getName() + '|' +
                " Platform ='" + getPlatform() + '|' +
                " Price =" + getPrice() + '|' +
                " Quantity =" + getQuantity() + '|' +
                " Release Date ='" + getClass() + '|' +
                " Storage Size =" + storageSize;
    }
}
