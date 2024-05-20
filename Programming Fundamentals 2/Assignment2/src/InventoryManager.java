import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
/**

 The InventoryManager class manages the inventory of products using an ArrayList of Product objects.

 It provides methods to add and remove products, search products by name, get the number of products,
 get a specific product, and load and save the inventory to and from an XML file using XStream.
 */
public class InventoryManager
{
    private static ArrayList<Product> InvManager= new ArrayList<Product>();

    public InventoryManager() {
    }

    //Add the object m (could be Nurse / Doctor / MedicalProfessional object)
    //passed in as parameter to the MedicalProfessional mp1 ArrayList
    public void addProduct(Product p)
    {
        InvManager.add(p);
    }

    public static void removeProduct(int index)
    {
        if(index >= 0 && index < InvManager.size())
        {
            InvManager.remove(index);
        }
    }

    public int numberOfProducts()
    {
        return InvManager.size();
    }

    public String listOfProducts() {
        String list = "";
        int i = 0;
        for (Product p : InvManager) {
            list += i + ":" + p + "\n";
            i++;
        }
        return list;
    }

    // Method to get the number of products in the inventory
    public int getNumProducts() {
        return InvManager.size();
    }

    //Searches the arraylist for a name that is equal to the name passed in as a parameter.
    public static String searchProductByName(String nameIn)
    {
        String searchResults="";
        for(Product p: InvManager)
        {
            if(p.getName().equals(nameIn))
            {
                searchResults = searchResults + p.toString() + "\n";
            }
        }
        return searchResults;
    }

    public Product getProduct(int index)
    {
        return InvManager.get(index);
    }

    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("products.xml"));
        InvManager = (ArrayList<Product>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("products.xml"));
        out.writeObject(InvManager);
        out.close();
    }
}

