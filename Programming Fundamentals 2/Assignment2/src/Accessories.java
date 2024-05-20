/**
 The Accessories class represents a type of product that extends the Product class with additional fields and methods
 */
public class Accessories extends Product {
    private String AccessoryType;
    /**
     Constructs a new Accessories object with the specified parameters.
     @param name The name of the accessory.
     @param platform The platform the accessory is compatible with.
     @param price The price of the accessory.
     @param quantity The quantity of the accessory available in inventory.
     @param releaseDate The release date of the accessory.
     @param AccessoryType The type of accessory (e.g. controller, headset, etc.).
     */
    public Accessories(String name, String platform, double price, int quantity, String releaseDate,
                       String AccessoryType) {
        super(name, platform, price, quantity, releaseDate);
        this.AccessoryType = AccessoryType;
    }
    /**

     Gets the type of accessory.
     @return The type of accessory.
     */
    // Getters and setters
    public String getAccessoryType() {
        return AccessoryType;
    }
    /**

     Sets the type of accessory.
     @param AccessoryType The type of accessory (e.g. controller, headset, etc.).
     */
    public void setAccessoryType(String AccessoryType) {
        this.AccessoryType = AccessoryType;
    }
    /**

     Gets the type of product.
     @return The type of product.
     */
    // Implemented abstract method
    @Override
    public String getType() {
        return "Accessories";
    }
    /**

     Returns a string representation of the Accessories object.
     @return A string representation of the Accessories object.
     */
    @Override
    public String toString() {
        return "Product type: " + getType() + "|" +
                "Name: " + getName() + "|" +
                "Platform: " + getPlatform() + "|" +
                "Price: " + getPrice() + "|" +
                "Quantity: " + getQuantity() + "|" +
                "Release Date: " + getReleaseDate() + "|" +
                "Accessory Type: " + getAccessoryType();
    }
}

