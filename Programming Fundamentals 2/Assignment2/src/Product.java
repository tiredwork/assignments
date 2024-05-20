public abstract class Product implements Sellable {
    private String platform;
    private String name;
    private double price;
    private int quantity;
    private String releaseDate;

    public Product(String name, String platform, double price, int quantity, String releaseDate) {
        this.name = name;
        this.platform = platform;
        this.price = price;
        this.quantity = quantity;
        this.releaseDate = releaseDate;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public String getPlatform() {
        return platform;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    // Implemented abstract method
    public abstract String getType();

    @Override
    public String toString() {
        return name + " (" + quantity + ") - $" + price;
    }
}
