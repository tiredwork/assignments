import java.util.*;

public class GameStoreSystem
{
    private GameStore gameStore1 = new GameStore();
    public GameStoreSystem() {
        try{
            gameStore1.loadGame();
            gameStore1.loadPreOrders();
            gameStore1.loadCustomers();
        }
        catch (Exception e)
        { 
            System.out.println("Error reading from file: " + e);
        }
    }

    public static void main(String[] args)
    {
        GameStoreSystem gs1 = new GameStoreSystem();
        gs1.run();
    }

    public int mainMenu()
    {
        System.out.println("Game Store Management System (GSMS) v1.3");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println();
        System.out.println("Games");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println("    1. Add a Game to the system ");
        System.out.println("    2. List all Games ");
        System.out.println("    3. Remove a Game from the system ");
        System.out.println("    4. Search for a Game by name ");
        System.out.println("    5. Number of Games in the System ");
        System.out.println("    6. Update Game Details");
        System.out.println();
        System.out.println();
        System.out.println("Pre-Orders");
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("    7. Add a Pre-Order to the system ");
        System.out.println("    8. List all Pre-Orders ");
        System.out.println("    9. Remove a Pre-Order from the system ");
        System.out.println("    10. Search for a pre-order by customer name ");
        System.out.println("    11. Number of pre-orders in the System ");
        System.out.println("    12. Update pre-order details ");
        System.out.println();
        System.out.println();
        System.out.println("Customers");
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("    13. Add a customer to the system ");
        System.out.println("    14. List all customers ");
        System.out.println("    15. Remove a customer from the system ");
        System.out.println("    16. Search for a customer by name ");
        System.out.println("    17. Number of customers in the System ");
        System.out.println("    18. Update customer details ");
        System.out.println();
        System.out.println();
        System.out.println("Additional Methods");
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("    19. Filter games by availability ");
        System.out.println("    20. Filter customers by registration day ");
        System.out.println("    21. Filter customers by birth day ");
        System.out.println("    22. Filter Pre-Orders by release day ");
        System.out.println("    23. Filter Pre-Orders by order status ");
        System.out.println();
        System.out.println();
        System.out.println("    0. Quit");
        System.out.println();
        System.out.println("Enter choice [0-18]: ");

        // get choice
        int choice = EasyScanner.nextInt();
        System.out.println("--------------------------");
        return choice;

    }

    public int getValidOption() 
    {
        int option = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                option = mainMenu();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Your selection can only be a number from 1 to 18, and 0 if you wish to exit!");
            }
        }
        return option;
    }

    public void run()
    {
        int option = getValidOption();
        while(option !=0)
        {
            switch (option) {
                    //Games
                case 1 -> createGame();                                                                                     //1. Add a Game to the system 
                case 2 -> System.out.println(gameStore1.listOfGames());                                                     //2. List all Games 
                case 3 -> deleteGame();                                                                                     //3. Remove a Game from the system 
                case 4 -> listOfGamesByName();                                                                              //4. Search for a Game by name 
                case 5 -> System.out.println("There are " + gameStore1.numberOfGames() + " games in the inventory");        //5. Number of Games in the System 
                case 6 -> updateGameDetails();                                                                              //6. Update Game Details
                    //Pre-Orders
                case 7 -> createPreOrder();                                                                                 //7. Add a Pre-Order to the system  
                case 8 -> System.out.println(gameStore1.listOfpreOrders());                                                 //8. List all Pre-Orders  
                case 9 -> deletePreOrder();                                                                                 //9. Remove a Pre-Order from the system 
                case 10 -> listOfPreOrdersByName();                                                                         //10. Search for a pre-order by customer name 
                case 11 -> System.out.println("There are " + gameStore1.numberOfpreOrders() + " pre-orders in the system"); //11. Number of pre-orders in the System 
                case 12 -> updatePreOrderDetails();                                                                         //12. Update pre-order details 
                    //Customers
                case 13 -> createCustomer();                                                                                //13. Add a customer to the system 
                case 14 -> System.out.println(gameStore1.listOfCustomers());                                                //14. List all customers 
                case 15 -> deleteCustomer();                                                                                //15. Remove a customer from the system 
                case 16 -> listOfCustomersByName();                                                                         //16. Search for a customer by name 
                case 17 -> System.out.println("There are " + gameStore1.numberOfCustomers() + " customers in the system");  //17. Number of customers in the System  
                case 18 -> updateCustomerDetails();                                                                         //18. Update customer details
                    //Addtional methods
                case 19 -> filterAvailability();                                                                            //19. Filter games by availability
                case 20 -> filterRegDay();                                                                                  //20. Filter customers by registration day
                case 21 -> filterBirthDay();                                                                                //21. Filter customers by birth day
                case 22 -> filterReleaseDay();                                                                              //22. Filter Pre-Orders by release day
                case 23 -> filterOrderStatus();                                                                             //23. Filter Pre-Orders by order status
                default -> System.out.println("Invalid option selected");
            }
            System.out.println();
            option = getValidOption();
            try{

                gameStore1.saveGame();
                gameStore1.savePreOrders();
                gameStore1.saveCustomers();
            }
            catch (Exception e){
                System.out.println("Error writing to file: " + e);
            }
        }
    }

    public void createGame()
    {
        //Declare 5 String Variables
        String name;
        String platform;
        double price = -1; //has to have a value for the while lo
        String availability;

        //Input and assign values for 5 variables
        System.out.print("Enter the name of the title: ");
        name = EasyScanner.nextString();

        System.out.print("Enter the platform the title is playable on (Xbox Series X/S, PlayStation 5, Nintendo Switch, ect..): ");
        platform = EasyScanner.nextString();

        while (price < 0) {
            System.out.print("Enter the price for the title: ");
            price = EasyScanner.nextDouble();
            if (price < 0) {
                System.out.println("Price must be greater than or equal to 0");
            }
        }

        System.out.print("Enter the availability status of the title (In stock, low on stock, out of stock): ");
        availability = EasyScanner.nextString();

        //Use these 4 values, stored in the variables, to create and construct nurse1 object
        Game game1 = new Game(name,platform,price,availability);
        gameStore1.addGame(game1);
        System.out.println("\n --------------------------");

    }

    public void createPreOrder()
    {
        String game;
        String customer;
        double price;
        int day=0;
        int month=0;
        int year=0;
        String orderStatus;
        double payment;

        //Input and assign values for 8 variables
        System.out.print("Enter the pre-order title: ");
        game = EasyScanner.nextString();

        System.out.print("Enter the customer's name: ");
        customer = EasyScanner.nextString();

        System.out.print("Enter the price for the title: ");
        price = EasyScanner.nextDouble();

        while (day < 1 && day > 31) {
            System.out.print("Enter the title's release day: ");
            day = EasyScanner.nextInt();
            if (day < 1 || day > 31) {
                System.out.println("Day must be between 1 and 31");
            }
        }
        while (month < 1 && month > 12) {
            System.out.print("Enter the title's release month: ");
            month = EasyScanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Month must be between 1 and 12");
            }
        }
        while (year < 1900 && year > 2099) {
            System.out.print("Enter the title's release year: ");
            year = EasyScanner.nextInt();
            if (year < 1900 || year > 2099) {
                System.out.println("Year must be between 1900 and 2099");
            }
        }

        System.out.print("Enter the order's current status (pending, fulfilled, cancelled): ");
        orderStatus = EasyScanner.nextString();

        System.out.println("Enter the current amount paid towards the pre-order: ");
        payment = EasyScanner.nextDouble();

        //Use these 5 values, stored in the variables, to create and construct nurse1 object
        PreOrders preOrders1 = new PreOrders(game, customer, price, day, month, year, orderStatus, payment);
        gameStore1.addpreOrders(preOrders1);
        System.out.println("\n --------------------------");
    }

    public void createCustomer()
    {
        //Declare 5 String Variables
        String name;
        String email;
        String phoneNo;
        String address;
        int regDay=0;
        int regMonth=0;
        int regYear=0;
        int birthDay=0;
        int birthMonth=0;
        int birthYear=0;

        //Input and assign values for 5 variables
        System.out.print("Enter the customer's name: ");
        name =  EasyScanner.nextString();

        System.out.print("Enter the customer's email address: ");
        email = EasyScanner.nextString();
        if (!isValidEmail(email)) {
            System.out.println("Email is invalid.");
        }

        System.out.print("Enter the customer's phone number: ");
        phoneNo = EasyScanner.nextString();

        System.out.print("Enter the customer's address: ");
        address = EasyScanner.nextString();

        while (regDay < 1 || regDay > 31) {
            System.out.print("Enter the day of registration: ");
            regDay = EasyScanner.nextInt();
            if (regDay < 1 || regDay > 31) {
                System.out.println("Day must be between 1 and 31");
            }
        }
        while (regMonth < 1 || regMonth > 12) {
            System.out.print("Enter the month of registration: ");
            regMonth = EasyScanner.nextInt();
            if (regMonth < 1 || regMonth > 12) {
                System.out.println("Month must be between 1 and 12");
            }
        }
        while (regYear < 1900 && regYear > 2099) {
            System.out.print("Enter the year of registration: ");
            regYear = EasyScanner.nextInt();
            if (regYear < 1900 || regYear > 2099) {
                System.out.println("Year must be between 1900 and 2099");
            }
        }
        while (birthDay < 1 && birthDay > 31) {
            System.out.print("Enter the birthday of customer: ");
            birthDay = EasyScanner.nextInt();
            if (birthDay < 1 || birthDay > 31) {
                System.out.println("Day must be between 1 and 31");
            }
        }
        while (birthMonth < 1 && birthMonth > 12) {
            System.out.print("Enter the birthmonth of customer: ");
            birthMonth = EasyScanner.nextInt();
            if (birthMonth < 1 || birthMonth > 12) {
                System.out.println("Month must be between 1 and 12");
            }
        }
        while (birthYear < 1900 && birthYear > 2099) {
            System.out.print("Enter the birthyear of customer: ");
            birthYear = EasyScanner.nextInt();
            if (birthYear < 1900 || birthYear > 2099) {
                System.out.println("Year must be between 1900 and 2099");
            }
        }

        //Use these 5 values, stored in the variables, to create and construct nurse1 object
        Customer customer1 = new Customer(name,email,phoneNo,address,regDay,regMonth,regYear,birthDay,birthMonth,birthYear);
        gameStore1.addCustomer(customer1);
        System.out.println("\n --------------------------");
    }

    public void deleteGame()
    {

        System.out.println("Game Store Management System (GSMS) v1.3: " + "\n" + gameStore1.listOfGames());
        System.out.println("--------------------------");
        System.out.println("Enter the ID of the game you wish to remove from the system:  ");
        int index = EasyScanner.nextInt();
        gameStore1.removeGame(index);
        System.out.println("Game Removed from System");
    }

    public void deletePreOrder()
    {

        System.out.println("Game Store Management System (GSMS) v1.3: " + "\n" + gameStore1.listOfpreOrders());
        System.out.println("--------------------------");
        System.out.println("Enter the ID of the Pre-Order you wish to remove from the system:  ");
        int index = EasyScanner.nextInt();
        gameStore1.removepreOrders(index);
        System.out.println("Pre-Order Removed from System");
    }

    public void deleteCustomer()
    {

        System.out.println("Game Store Management System (GSMS) v1.3: " + "\n" + gameStore1.listOfCustomers());
        System.out.println("--------------------------");
        System.out.println("Enter the ID of the customer you wish to remove from the system:  ");
        int index = EasyScanner.nextInt();
        gameStore1.removeCustomer(index);
        System.out.println("Customer Removed from System");
    }

    public void listOfGamesByName()
    {

        System.out.println("Enter Game Name: ");
        String gameName = EasyScanner.nextString();
        System.out.println(gameStore1.searchGameByName(gameName));

    }

    public void listOfPreOrdersByName()
    {

        System.out.println("Enter Pre-Order Name: ");
        String preOrderName = EasyScanner.nextString();
        System.out.println(gameStore1.searchpreOrdersByName(preOrderName));

    }

    public void listOfCustomersByName()
    {

        System.out.println("Enter Customer Name: ");
        String customerName = EasyScanner.nextString();
        System.out.println(gameStore1.searchCustomerByName(customerName));

    }

    public void updateGameDetails()
    {
        System.out.println("Game Store Management System (GSMS) v1.3: " + "\n" + gameStore1.listOfGames());
        System.out.println("Please enter the ID of the game you wish to update: ");
        int index = EasyScanner.nextInt();

        Game game = gameStore1.getGames(index);

        //Input and assign values for 5 variables
        System.out.println("Which of the following do you wish to edit:");
        System.out.println("1. Game name");
        System.out.println("2. Game platform");
        System.out.println("3. Game price");
        System.out.println("4. Game's availability");
        System.out.println("0. Exit");
        int option = EasyScanner.nextInt();
        while(option!=0)
        {
            switch(option)
            {
                case 1:
                    System.out.print("Enter the name of the title: ");
                    String gameName = EasyScanner.nextString();
                    game.setName(gameName);
                    break;
                case 2:
                    System.out.print("Enter the platform the title is playable on (Xbox Series X/S, PlayStation 5, Nintendo Switch, ect..): ");
                    String gamePlatform = EasyScanner.nextString();
                    game.setPlatform(gamePlatform);
                    break;
                case 3:
                    System.out.print("Enter the price for the title: ");
                    double gamePrice = EasyScanner.nextDouble();
                    game.setPrice(gamePrice);
                    break;
                case 4:
                    System.out.print("Enter the availability status of the title (In stock, low on stock, out of stock): ");
                    String gameAvailability = EasyScanner.nextString();
                    game.setAvailability(gameAvailability);
                    break;
                default:
                    System.out.println("Invalid Option");

            }
            System.out.println("Which of the following do you wish to edit:");
            System.out.println("1. Game name");
            System.out.println("2. Game platform");
            System.out.println("3. Game price");
            System.out.println("4. Game's availability");
            System.out.println("0. Exit");
            option = EasyScanner.nextInt();

        }
        System.out.println("Updated Details:");
        System.out.println(game);
    }

    public void updatePreOrderDetails()
    {
        System.out.println("Game Store Management System (GSMS) v1.3: " + "\n" + gameStore1.listOfpreOrders());

        System.out.println("Please enter the ID of the Pre-Order you wish to update: ");
        int index = EasyScanner.nextInt();

        PreOrders preOrder = gameStore1.getPreOrders(index);

        //Input and assign values for 5 variables
        System.out.println("Which of the following do you wish to edit:");
        System.out.println("1. Pre-Order game title");
        System.out.println("2. Pre-Order customer name");
        System.out.println("3. Pre-Order price");
        System.out.println("4. Pre-Order release date");
        System.out.println("5. Pre-Order order status");
        System.out.println("6. Pre-Order payment fufilled");
        System.out.println("0. Exit");
        int option = EasyScanner.nextInt();
        while(option!=0)
        {
            switch(option)
            {
                case 1:
                    System.out.print("Enter the pre-order title: ");
                    String preOrderGame = EasyScanner.nextString();
                    preOrder.setGame(preOrderGame);
                    break;
                case 2:
                    System.out.print("Enter the customer's name: ");
                    String preOrderCustomer = EasyScanner.nextString();
                    preOrder.setCustomer(preOrderCustomer);
                    break;
                case 3:
                    System.out.print("Enter the price for the title: ");
                    double preOrderPrice = EasyScanner.nextDouble();
                    preOrder.setPayment(preOrderPrice);
                    break;
                case 4:
                    int preOrderDay;
                    int preOrderMonth;
                    int preOrderYear; //Have to declare the varibles outside of the loop
                    do {
                        System.out.print("Enter the title's release day: ");
                        preOrderDay = EasyScanner.nextInt();
                        if (preOrderDay >= 1 && preOrderDay <= 31) {
                            preOrder.setReleaseDay(preOrderDay);
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } while (preOrderDay < 1 || preOrderDay > 31);
                    do {
                        System.out.print("Enter the title's release month: ");
                        preOrderMonth = EasyScanner.nextInt();
                        if (preOrderMonth >= 1 && preOrderMonth <= 12) {
                            preOrder.setReleaseMonth(preOrderMonth);
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } while (preOrderMonth < 1 || preOrderMonth > 12);
                    do {
                        System.out.print("Enter the title's release year: ");
                        preOrderYear = EasyScanner.nextInt();
                        if (preOrderYear >= 2010 && preOrderYear <= 2099) {
                            preOrder.setReleaseYear(preOrderYear);
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } while (preOrderYear < 2010 || preOrderYear > 2099);
                    break;
                case 5:
                    System.out.print("Enter the order's current status (pending, fulfilled, cancelled): ");
                    String preOrderStatus = EasyScanner.nextString();
                    preOrder.setOrderStatus(preOrderStatus);
                    break;
                case 6:
                    System.out.print("Enter the current amount paid towards the pre-order: ");
                    double preOrderPayment = EasyScanner.nextDouble();
                    preOrder.setPayment(preOrderPayment);
                    break;
                default:
                    System.out.println("Invalid Option");

            }
            System.out.println("Which of the following do you wish to edit:");
            System.out.println("1. Pre-Order game title");
            System.out.println("2. Pre-Order customer name");
            System.out.println("3. Pre-Order price");
            System.out.println("4. Pre-Order release date");
            System.out.println("5. Pre-Order order status");
            System.out.println("6. Pre-Order payment fufilled");
            System.out.println("0. Exit");
            option = EasyScanner.nextInt();

        }
        System.out.println("Updated Details:");
        System.out.println(preOrder);
    }

    public void updateCustomerDetails()
    {
        System.out.println("Game Store Management System (GSMS) v1.3: " + "\n" + gameStore1.listOfCustomers());

        System.out.println("Please enter the ID of the customer you wish to Update: ");
        int index = EasyScanner.nextInt();

        Customer customer = gameStore1.getCustomer(index);

        //Input and assign values for 5 variables
        System.out.println("Which of the following do you wish to edit:");
        System.out.println("1. Customer's name");
        System.out.println("2. Customer's email");
        System.out.println("3. Customer's phone number");
        System.out.println("4. Customer's address");
        System.out.println("5. Customer's registration date");
        System.out.println("6. Customer's date of birth");
        System.out.println("0. Exit");
        int option = EasyScanner.nextInt();
        while(option!=0)
        {
            switch(option)
            {
                case 1:
                    System.out.print("Enter the customer's name: ");
                    String customerName = EasyScanner.nextString();
                    customer.setName(customerName);
                    break;
                case 2:
                    String customerEmail;
                    boolean isValid; //Have to declare the varibles outside of the loop
                    do {
                        System.out.print("Enter the customer's email address: ");
                        customerEmail = EasyScanner.nextString();
                        isValid = isValidEmail(customerEmail);
                        if (!isValid) {
                            System.out.println(customerEmail + " is not a valid email. Please try again.");
                        }
                    } while (!isValid);
                    customer.setEmail(customerEmail);
                    break;
                case 3:
                    System.out.print("Enter the customer's phone number: ");
                    String customerPhoneNo = EasyScanner.nextString();
                    customer.setPhoneNo(customerPhoneNo);
                    break;
                case 4:
                    System.out.print("Enter the customer's address: ");
                    String customerAddress = EasyScanner.nextString();
                    customer.setAddress(customerAddress);
                    break;
                case 5:
                    int customerRegDay;
                    int customerRegMonth;
                    int customerRegYear;
                    do {
                        System.out.print("Enter the day of registration: ");
                        customerRegDay = EasyScanner.nextInt();
                        if (customerRegDay >= 1 && customerRegDay <= 31) {
                            customer.setRegDay(customerRegDay);
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } while (customerRegDay < 1 || customerRegDay > 31);
                    do {
                        System.out.print("Enter the month of registration: ");
                        customerRegMonth = EasyScanner.nextInt();
                        if (customerRegMonth >= 1 && customerRegMonth <= 12) {
                            customer.setRegMonth(customerRegMonth);
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } while (customerRegMonth < 1 || customerRegMonth > 12);
                    do {
                        System.out.print("Enter the year of registration: ");
                        customerRegYear = EasyScanner.nextInt();
                        if (customerRegYear >= 1900 && customerRegYear <= 2099) {
                            customer.setRegYear(customerRegYear);
                        } else {
                            System.out.println("Invalid input.");
                        }
                    } while (customerRegYear < 1900 || customerRegYear > 2099);
                    break;
                case 6:
                    System.out.print("Enter the birthday of customer: ");
                    int customerBirthDay = EasyScanner.nextInt();
                    customer.setBirthDay(customerBirthDay);
                    System.out.print("Enter the birthmonth of customer: ");
                    int customerBirthMonth = EasyScanner.nextInt();
                    customer.setBirthMonth(customerBirthMonth);
                    System.out.print("Enter the birthyear of customer: ");
                    int customerBirthYear = EasyScanner.nextInt();
                    customer.setBirthYear(customerBirthYear);
                    break;
                default:
                    System.out.println("Invalid Option");

            }
            System.out.println("Which of the following do you wish to edit:");
            System.out.println("1. Customer's name");
            System.out.println("2. Customer's email");
            System.out.println("3. Customer's phone number");
            System.out.println("4. Customer's address");
            System.out.println("5. Customer's registration date");
            System.out.println("6. Customer's date of birth");
            System.out.println("0. Exit");
            option = EasyScanner.nextInt();
        }
        System.out.println("Updated Details:");
        System.out.println(customer);
    }

    //Email validation - https://www.chegg.com/homework-help/questions-and-answers/error-coding-preventing-running-program-fix-doesn-t-print-email-either-valid-invalid-impor-q41401375 
    public static boolean isValidEmail(String email) {
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');
        while (atIndex > 0 && dotIndex > atIndex + 1 && dotIndex < email.length() - 1) {
            return true;
        }
        return false;
    }

    //Additional methods
    public void filterAvailability()
    {

        System.out.println("Enter the availability you would like to filter (In stock, low on stock, out of stock): ");
        String availQuery = EasyScanner.nextString();
        System.out.println(gameStore1.filterAvailability(availQuery));

    }

    public void filterRegDay()
    {

        System.out.println("Enter the registration date you would like to filter: ");
        int regDay = EasyScanner.nextInt();
        System.out.println(gameStore1.filterRegDay(regDay));

    }

    public void filterBirthDay()
    {

        System.out.println("Enter the birth date you would like to filter: ");
        int birthDay = EasyScanner.nextInt();
        System.out.println(gameStore1.filterBirthDay(birthDay));

    }

    public void filterReleaseDay()
    {

        System.out.println("Enter the release date you would like to filter: ");
        int releaseDay = EasyScanner.nextInt();
        System.out.println(gameStore1.filterReleaseDay(releaseDay));

    }

    public void filterOrderStatus()
    {

        System.out.println("Enter the order's current status (Pending, Fulfilled, Cancelled): ");
        String orderStatus = EasyScanner.nextString();
        System.out.println(gameStore1.filterOrderStatus(orderStatus));

    }
}