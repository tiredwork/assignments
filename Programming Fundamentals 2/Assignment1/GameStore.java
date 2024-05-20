import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.thoughtworks.xstream.security.AnyTypePermission;
public class GameStore
{
    //1. Variables
    private ArrayList<Customer> customerList= new ArrayList<Customer>();
    private ArrayList<Game> gameList= new ArrayList<Game>();
    private ArrayList<PreOrders> preOrderList = new ArrayList<PreOrders>();

    //2. Constructor – Default Constructor - no parameters, no instructions
    public GameStore()
    {
    }

    //3. Methods
    //-------------Customer methods---------------
    //Method to add a Customer Object to the customerList ArrayList
    public void addCustomer(Customer customer1)
    {
        customerList.add(customer1);
    }

    //Method to remove a Customer Object from the customerList ArrayList
    public void removeCustomer(int index)
    {
        customerList.remove(index);
    }

    //Method to return the number of elements in customerList ArrayList
    public int numberOfCustomers()
    {
        return customerList.size();
    }

    //Method to create and return a String with all details of all Customer objects in the nurseList ArrayList    
    public String listOfCustomers()
    {
        String allCustomers="";    //Declare a string allCustomers
        int index = 0;
        for(Customer n: customerList)
        {
            allCustomers = allCustomers + "Index " + index + ":   "+  n  + "\n";
            // OR allCustomers = allCustomers + "Index " + index + ":   "+  n.toString()  + "\n";     
            index++;
        }

        return allCustomers;
    }

    public String searchCustomerByName(String nameIn)
    {
        String searchResults="";
        for(Customer n: customerList)
        {
            if(n.getName().equals(nameIn))
            {
                searchResults = searchResults + n.toString() + "\n";
            }
        }
        return searchResults;
    }

    public Customer getCustomer(int index)
    {
        return customerList.get(index);
    }
    //------------- Game Methods -----------------
    //Method to add a Game Object to the gameList ArrayList
    public void addGame(Game game1)
    {
        gameList.add(game1);
    }

    //Method to remove a Docor Object from the gameList ArrayList
    public void removeGame(int index)
    {
        gameList.remove(index);
    }

    //Method to return the number of elements in gameList ArrayList
    public int numberOfGames()
    {
        return gameList.size();
    }

    //Method to create and return a String with all details of all Games objects in the nurseList ArrayList    
    public String listOfGames()
    {
        String allGames="";    //Declare a string allGames
        int index = 0;
        for(Game n: gameList)
        {
            allGames = allGames + "Index " + index + ":   "+  n  + "\n";
            // OR allGames = allGames + "Index " + index + ":   "+  n.toString()  + "\n";     
            index++;
        }

        return allGames;
    }

    public String searchGameByName(String nameIn)
    {
        String searchResults="";
        for(Game n: gameList)
        {
            if(n.getName().equals(nameIn))
            {
                searchResults = searchResults + n.toString() + "\n";
            }
        }
        return searchResults;
    }

    public Game getGames(int index)
    {
        return gameList.get(index);
    }

    //---------------- preOrders Methods ---------------------
    //Method to add a preOrders Object to the preOrderList ArrayList
    public void addpreOrders(PreOrders preOrder1)
    {
        preOrderList.add(preOrder1);
    }

    //Method to remove a preOrders Object from the preOrderList ArrayList
    public void removepreOrders(int index)
    {
        preOrderList.remove(index);
    }

    //Method to return the number of elements in preOrderList ArrayList
    public int numberOfpreOrders()
    {
        return preOrderList.size();
    }

    //Method to create and return a String with all details of all preOrders objects in the GameList ArrayList
    public String listOfpreOrders()
    {
        String allpreOrders="";    //Declare a string allpreOrders
        int index = 0;
        for(PreOrders n: preOrderList)
        {
            allpreOrders = allpreOrders + "Index " + index + ":   "+  n  + "\n";
            // OR allpreOrders = allpreOrders + "Index " + index + ":   "+  n.toString()  + "\n";
            index++;
        }

        return allpreOrders;
    }

    public String searchpreOrdersByName(String nameIn)
    {
        String searchResults="";
        for(PreOrders n: preOrderList)
        {
            if(n.getGame().equals(nameIn))
            {
                searchResults = searchResults + n.toString() + "\n";
            }
        }
        return searchResults;
    }

    public PreOrders getPreOrders(int index)
    {
        return preOrderList.get(index);
    }

    // Game - additional methods
    public String filterAvailability(String availQuery) {
        String availResults = "";
        for (Game game : gameList) {
            if (game.getAvailability() == availQuery) 
            {
                availResults = availResults + game.toString() + "\n";
            }
        }
        return availResults;
    }

    //Customer - additional methods
    public String filterRegDay(int regDay) {
        String regDayResults = "";
        for (Customer customer : customerList) {
            if(customer.getRegDay() == regDay)
            {
                regDayResults = regDayResults + customer.toString() + "\n";
            }
        }
        return regDayResults;
    }

    public String filterBirthDay(int birthDay) {
        String birthDayResults = "";
        for (Customer customer : customerList) {
            if(customer.getBirthDay() == birthDay)
            {
                birthDayResults = birthDayResults + customer.toString() + "\n";
            }
        }
        return birthDayResults;
    }

    //Pre-Order - additional methods
    public String filterReleaseDay(int ReleaseDay) {
        String releaseDayResults = "";
        for (PreOrders preOrder : preOrderList) {
            if(preOrder.getReleaseDay() == ReleaseDay)
            {
                releaseDayResults = releaseDayResults + preOrder.toString() + "\n";
            }
        }
        return releaseDayResults;
    }

    public String filterOrderStatus(String orderStatus) {
        String orderStatusResults = "";
        for (PreOrders preOrder : preOrderList) {
            if(preOrder.getOrderStatus().equals(orderStatus))
            {
                orderStatusResults = orderStatusResults + preOrder.toString() + "\n";
            }
        }
        return orderStatusResults;
    }

    // XStream save and load
    @SuppressWarnings("unchecked")
    public void loadGame() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("games.xml"));
        gameList = (ArrayList<Game>) is.readObject();
        is.close();
    }

    public void saveGame() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("games.xml"));
        out.writeObject(gameList);
        out.close();    
    }
    // Pre-orders
    @SuppressWarnings("unchecked")
    public void loadPreOrders() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("preOrders.xml"));
        preOrderList = (ArrayList<PreOrders>) is.readObject();
        is.close();
    }

    public void savePreOrders() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("preOrders.xml"));
        out.writeObject(preOrderList);
        out.close();    
    }
    // Customers
    @SuppressWarnings("unchecked")
    public void loadCustomers() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("customers.xml"));
        customerList = (ArrayList<Customer>) is.readObject();
        is.close();
    }

    public void saveCustomers() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("customers.xml"));
        out.writeObject(customerList);
        out.close();    
    }
}   
