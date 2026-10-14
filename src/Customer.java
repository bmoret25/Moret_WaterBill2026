import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Customer {


    final int TIER2_CUTOFF = 13000;
    final double GALLONS = 1000.0;

    private String name;
    private int gallonsUsed;
    private int customerType; //1=single family and 2 = double family
    protected double bill;

    //CONSTRUCTORS

    //If create another constructor of same name, then I HAVE to make this default constructor
    public Customer() {
        System.out.println("this is a customer");
    }

    //This = overloading Customer() method bc 2 dif calls of it, but are allowed to do it bc we either use dif params or dif return types
    public Customer(String name, int gallonsUsed, int customerType) {
        System.out.println("THIS IS A CUSTOMER");

        //use setters here
        setName(name);
        setGallonsUsed(gallonsUsed);
        setCustomerType(customerType);
    }

    //if we put the parameters in a dif order that will work too


    //GETTER - allow for classes to get info
    public int getGallonsUsed() {
        return gallonsUsed;
    }

    public String getName() {
        return name;
    }

    public int getCustomerType() {
        return customerType;
    }

    public double getBill() {
        return bill;
    }



    // Setter - allows us to set a value
    public void setGallonsUsed(int gallonsUsed) {
        if (gallonsUsed < 0) {
            System.out.println("Gallons must be positive");
        } else {
            this.gallonsUsed = gallonsUsed;
        }
    }

    public void setName(String name) {
        if (name.equals("") || name == null) {                          // have to use .equals()   NOT == when dealing with  refrence types (strs)
            System.out.println("Must have a name");
        } else {
            this.name = name;
        }
    }

    public void setCustomerType(int customerType) {
        if (customerType != 1 || customerType != 2) {
            System.out.println("Invalid customer Type");
        } else {
            this.customerType = customerType;
        }
    }

    public void customerInput() {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            System.out.print("Enter Customer Name: ");
            setName(bufferedReader.readLine());
            System.out.print("Enter Customer Type (1: SingleFamily, 2: Duplex): ");
            setCustomerType(Integer.parseInt(bufferedReader.readLine()));
            System.out.print("Enter gallons used: ");
            setGallonsUsed(Integer.parseInt(bufferedReader.readLine()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void calculateBill();
    //bc it's abstract we write it like this, and now all kids MUST implement this method on their own

    //NEED abstract class to have abstract method

    public void printBill() {
        System.out.println("The bill is " + bill);
    }
}