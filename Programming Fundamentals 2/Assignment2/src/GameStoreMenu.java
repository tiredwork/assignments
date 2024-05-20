/**

 The GameStoreMenu class represents the menu system for a game store inventory management system.

 It allows the user to add, remove, update, and search for products in the inventory.
 */

public class GameStoreMenu {
    private InventoryManager GameStore1 = new InventoryManager();

    public GameStoreMenu()
    {
        try {
            GameStore1.load();
            System.out.println("Inventory loaded successfully.");
        } catch (Exception e) {
            System.out.println("Error reading from file: " + e);
        }
    }

    public static void main(String[] args)
    {
        GameStoreMenu gs1 = new GameStoreMenu();
        gs1.run();
    }

    public int mainMenu() {

        System.out.println("\nGame Store Menu");
        System.out.println("\n________________________");
        System.out.println();
        System.out.println("\t1. Add a Product to Inventory");
        System.out.println("\t2. List all Products in Inventory");
        System.out.println("\t3. Remove a Product from Inventory");
        System.out.println("\t4. Search for a Product by Name");
        System.out.println("\t5. Print Product Quantity");
        System.out.println("\t6. Update Product Quantity");
        System.out.println("\t7. Buy a Product");
        System.out.println();
        System.out.println("\t0. Quit");
        System.out.println();
        System.out.print("Enter choice [0-7]: ");

        // get choice
        int choice = EasyScanner.nextInt();
        System.out.println("\n________________________");
        return choice;
    }

    public void run() {
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    System.out.println(GameStore1.listOfProducts());
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    findProduct();
                    break;
                case 5:
                    printProductQuantity();
                    break;
                case 6:
                    updateQuantity();
                    break;
                case 7:
                    buyProduct();
                    break;
                default:
                    System.out.println("Invalid option selected");
            }
            System.out.println();
            option = mainMenu();
            try {
                GameStore1.save();
                System.out.println("Inventory saved successfully.");
            } catch (Exception e) {
                System.out.println("Error writing to file: " + e);
            }
        }
    }


    public void createProduct() {
        int choice;
        System.out.println("\n________________________");
        System.out.println("What kind of product do you want to add?");
        System.out.println("\t1. Game");
        System.out.println("\t2. Accessory");
        System.out.println("\t3. Game Console");
        System.out.println();
        System.out.print("Enter choice [1-3]: ");
        choice = EasyScanner.nextInt();

        // get details from user
        System.out.println("Enter the new product details.");
        System.out.print("Name: ");
        String name = EasyScanner.nextString();
        System.out.print("Platform: ");
        String platform = EasyScanner.nextString();
        System.out.print("Price: ");
        double price = EasyScanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = EasyScanner.nextInt();
        System.out.print("Release Date: ");
        String releaseDate = EasyScanner.nextString();

        // 1 for Game or 2 for Accessory
        if (choice == 1) {
            String genre, ageRating;
            System.out.print("Enter Game Genre: ");
            genre = EasyScanner.nextString();
            System.out.print("Enter Game Age Rating: ");
            ageRating = EasyScanner.nextString();
            System.out.println("\n________________________");

            // Build a Game object
            Game game = new Game(name, platform, price, quantity, releaseDate, genre, ageRating);

            // Add Game object to ArrayList
            GameStore1.addProduct(game);
            System.out.println("Game added successfully.");
        } else if (choice == 2)
        {

            String accessoryType;
            System.out.print("Enter Accessory type: ");
            accessoryType = EasyScanner.nextString();
            System.out.println("\n ______________________");

            //Build a doctor object d1
            Accessories acc1 = new Accessories(name, platform, price, quantity, releaseDate, accessoryType);

            //Add doctor object d1 to arraylist
            GameStore1.addProduct(acc1);

        } else if (choice == 3)
        {

        String storageSize;
        System.out.print("Enter Game Console's storage size: ");
        storageSize = EasyScanner.nextString();
        System.out.println("\n ______________________");

        //Build a doctor object d1
        GameConsole gam1 = new GameConsole(name, platform, price, quantity, releaseDate, storageSize);

        //Add doctor object d1 to arraylist
        GameStore1.addProduct(gam1);
        }
    }

    public void deleteProduct()
    {

        System.out.println("Game Store Inventory: " + "\n" + GameStore1.listOfProducts());
        System.out.println("______________________________");
        System.out.println("Enter the item number of the product you wish to remove from the inventory:  ");
        int index = EasyScanner.nextInt();
        InventoryManager.removeProduct(index);
        System.out.println("Item successfully removed from the system");
    }
    public void findProduct()
    {

        System.out.println("Enter the name of the product: ");
        String name = EasyScanner.nextString();
        System.out.println(InventoryManager.searchProductByName(name));

    }
    public void printProductQuantity()
    {
        System.out.println("Game Store Inventory: " + "\n" + GameStore1.listOfProducts());
        System.out.println("______________________________");
        System.out.println("Enter the item you want to lookup the quantity for: ");
        int index = EasyScanner.nextInt();
        int quantity = GameStore1.getProduct(index).getQuantity();
        System.out.println("Number of items: " + quantity);
    }
    public void buyProduct() {
        boolean buying = true;
        double totalCost = 0;

        while (buying) {
            System.out.println("Enter the name of the product you want to buy:");
            String buyName = EasyScanner.nextString();
            System.out.println("Enter the class type of the product you want to buy (Game, Accessory or GameConsole):");
            String buyClass = EasyScanner.nextString();

            // Find the product with the given name and class type
            Product productToBuy = null;
            for (int i = 0; i < GameStore1.getNumProducts(); i++) {
                Product currentProduct = GameStore1.getProduct(i);
                if (currentProduct.getName().equals(buyName) && currentProduct.getClass().getSimpleName().equals(buyClass)) {
                    productToBuy = currentProduct;
                    break;
                }
            }

            if (productToBuy == null) {
                System.out.println("Product not found.");
                continue;
            }

            if (productToBuy.getQuantity() == 0) {
                System.out.println("Sorry, the product is out of stock.");
                continue;
            }

            double price = productToBuy.getPrice();
            System.out.println("Price: $" + price);
            System.out.println("Enter the quantity you want to buy:");
            int quantityToBuy = EasyScanner.nextInt();

            if (quantityToBuy > productToBuy.getQuantity()) {
                System.out.println("Sorry, there are not enough items in stock.");
                continue;
            }

            double totalPrice = price * quantityToBuy * 1.1;
            totalCost = totalPrice + totalCost;
            System.out.println("Total price (including tax): €" + totalPrice);
            System.out.println("Add another product to cart? (Y/N):");
            String confirm = EasyScanner.nextString();

            if (confirm.equalsIgnoreCase("N")) {
                buying = false;
            }

            productToBuy.setQuantity(productToBuy.getQuantity() - quantityToBuy);
        }

        System.out.println("Total cost (including tax): €" + totalCost);
        System.out.println("Purchase successful.");
    }

    public void updateQuantity() {
        System.out.println("Game Store Inventory: " + "\n" + GameStore1.listOfProducts());
        System.out.println("______________________________");
        System.out.println("Enter the index of the product you want to update: ");
        int index = EasyScanner.nextInt();
        Product product = GameStore1.getProduct(index);
        System.out.println("Enter the new quantity for " + product.getName() + ":");
        int newQuantity = EasyScanner.nextInt();
        product.setQuantity(newQuantity);
        System.out.println(product.getName() + " quantity has been updated to " + newQuantity);
    }

}