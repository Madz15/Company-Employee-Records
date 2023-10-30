public class WagesTester
{
    public static void main(String[] args)
    {
        Wages w1 = new Wages ("January", 1500); //create object to test

        System.out.println(w1); //this will call the toString method in our Wages class

        //or the code to interrogate object data
        //System.out.println("Month: "+ w1.getMonth());
        //System.out.println("Amount: " + w1.getAmount());

    }
}

