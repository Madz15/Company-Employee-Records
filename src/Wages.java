//class used to store details of employee Wages

public class Wages
{
    private String month;
    private double amount;

    //constructor initialises the Wages month and the Wages paid
    //@param wagesIn: month of Wages
    //@param amountIn: amount of Wages

    public Wages(String monthIn, double amountIn)
    {
        month = monthIn;
        amount = amountIn;
    }

    //Reads the month for which Wages was received
    //@return Returns the month for which Wages was received

    public String getMonth()
    {
        return month;
    }

    //Reads the amount received
    //@return Returns the amount received


    public double getAmount()
    {
        return amount;
    }

    //overridden the toString method
    // @Override tag to provide a convenient way of printing a Wages
    @Override
    public String toString()
    {
        return "(" + month + " ," + amount + ")"; // a convenient way of displaying attributes
    }
}
