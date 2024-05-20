public class Customer {
    // Instance Varibles
    private String name;
    private String email;
    private String phoneNo;
    private String address;
    private int regDay;
    private int regMonth;
    private int regYear;
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    // Constructor method
    public Customer(String name, String email, String phoneNo, String address, int regDay, int regMonth, int regYear, int brithDay, int birthMonth, int birthYear) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
        this.regDay = regDay;
        this.regMonth = regMonth;
        this.regYear = regYear;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;

    }

    // Getters and Setters and toString methods

    //Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public int getRegDay() {
        return regDay;
    }
    public int getRegMonth() {
        return regMonth;
    }
    public int getRegYear() {
        return regYear;
    }
    public int getBirthDay() {
        return birthDay;
    }
    public int getBirthMonth() {
        return birthMonth;
    }
    public int getBirthYear() {
        return birthYear;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setRegDay(int regDay)
    {
        this.regDay = regDay;
    }
    public void setRegMonth(int regMonth)
    {
        this.regMonth = regMonth;
    }
    public void setRegYear(int regYear)
    {
        this.regYear = regYear;
    }
    public void setBirthDay(int birthDay)
    {
        this.birthDay = birthDay;
    }
    public void setBirthMonth(int birthMonth)
    {
        this.birthMonth = birthMonth;
    }
    public void setBirthYear(int birthYear)
    {
        this.birthYear = birthYear;
    }

    // toString
    public String toString()
    {
        return "Customer details | " +
                " | Customer's name: " + name +
                " | Email: " + email +
                " | Phone number: " + phoneNo +
                " | Address: " + address +
                " | Registration date: " + regDay + "/" + regMonth + "/" + regYear +
                " | Birthday: " + birthDay + "/" + birthMonth + "/" + birthYear;
    }
}