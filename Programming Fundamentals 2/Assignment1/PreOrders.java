public class PreOrders
{
    // Instance Variables
    private String game;
    private String customer;
    private double price;
    private int day;
    private int month;
    private int year;
    private String orderStatus;
    private double payment;

    // Constructor method
    public PreOrders(String game, String customer, double price, int day, int month, int year, String orderStatus, double payment)
    {
        this.game=game;
        this.customer=customer;
        this.price=price;
        this.day=day;
        this.month=month;
        this.year=year;
        this.orderStatus=orderStatus;
        this.payment=payment;
    }

    // Getters and Setters and toString methods

    //Getters
    public String getGame()
    {
        return game;
    }

    public String getCustomer()
    {
        return customer;
    }

    public double getPrice()
    {
        return price;
    }

    public int getReleaseDay()
    {
        return day;
    }
    
    public int getReleaseMonth()
    {
        return month;
    }

    
    public int getReleaseYear()
    {
        return year;
    }


    public String getOrderStatus()
    {
        return orderStatus;
    }

    public double getPayment()
    {
        return payment;
    }
    // Setters
    public void setGame(String game)
    {
        this.game = game;
    }

    public void setCustomer(String customer)
    {
        this.customer = customer;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setReleaseDay(int releaseDay)
    {
        this.day = day;
    }

    public void setReleaseMonth(int releaseMonth)
    {
        this.month = month;
    }

    public void setReleaseYear(int releaseYear)
    {
        this.year = year;
    }

    public void setOrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public void setPayment(double payment)
    {
        this.payment = payment;
    }

    // toString
    public String toString()
    {
        return "Pre-order details | " +
                "Pre-order title: " + game +
                " | Customer name: " + customer +
                " | Price of title: " + price +
                " | Title release date: " +day+"/"+month+"/"+year+
                " | Pre-order status: " + orderStatus +
                " | Payment provided: " + payment + "\n";
    }
}