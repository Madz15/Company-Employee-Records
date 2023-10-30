import java.util.ArrayList;
import java.util.List;

public class WagesListTester
{
    public static void main(String[] args) {
        char choice;
        int size;
       WagesList list; // declare WagesList object to test

        //get size of list
         System.out.print("Size of list? ");

        size = EasyScanner.nextInt(); // EasyScanner used to simplify keyboard input
        list = new WagesList(size); // create object to test


        //menu
        do {
            // display options
            System.out.println();
            System.out.println("[1] ADD");
            System.out.println("[2] DISPLAY");
            System.out.println("[3] IS FULL");
            System.out.println("[4] GET Wages");
            System.out.println("[5] GET TOTAL");
            System.out.println("[6] CALCULATE TOTAL RECEIVED");
            System.out.println("[7] QUIT");
            System.out.println();
            System.out.print(" Enter a choice [1-7]: ");
            // get choice
            choice = EasyScanner.nextChar();
            System.out.println();
            // process choice
            switch (choice)
            {
                case '1': option1(list); break;
                case '2': option2(list); break;
                case '3': option3(list); break;
                case '4': option4(list); break;
                case '5': option5(list); break;
                case '6': option6(list); break;
                case '7': System.out.println("TESTING COMPLETE"); break;
                default:
                    System.out.print("1-7 only");
            }
        } while (choice != '7');
    }

    // ADD
        static void option1(WagesList listIn)
        {
            // prompt for Wages details
            System.out.print("Enter Month: ");
            String month = EasyScanner.nextString();
            System.out.print("Enter Amount: ");
            double amount = EasyScanner.nextDouble();

            // create new Wages object from input
            Wages w = new Wages(month, amount);

            // attempt to add Wages to list
            boolean ok = listIn.addWages(w); // value of false sent back if unable to add
            if (!ok) // check if item was not added
            {
                System.out.println("ERROR: list full");
            }
        }
        // DISPLAY
        static void option2(WagesList listIn)
        {
            System.out.println("ITEMS ENTERED");

           // String wages = EasyScanner.nextString();

            System.out.println(listIn); // calls toString method of WagesList

           // WagesList list = listIn.getWages();

           //  if (list != null)
           // { System.out.println();
        }

        // IS FULL
        static void option3(WagesList listIn)
        {
            if (listIn.isFull()) {
                System.out.println(("list is full"));
            } else {
                System.out.println("list is NOT full");
            }
        }
        //GET Wages
        static void option4(WagesList listIn)
        {
            // prompt for and receive Wages number
            System.out.print(" Enter Wages number to retrieve: ");
            int num = EasyScanner.nextInt();
            // retrieve Wages object form list
            Wages w = listIn.getWages(num); // returns null if invalid position
            if (w != null) // check if Wages retrieved
            {
                System.out.println(w); // calls toString method of Wages
            } else {
                System.out.println("INVALID Wages NUMBER"); // invalid position error
            }
        }
        // GET TOTAL
        static void option5(WagesList listIn)
        {
            System.out.print("TOTAL NUMBER OF Wages ENTERED: ");
            System.out.println(listIn.getTotal());
        }
        //GET TOTAL RECEIVED
        static void option6(WagesList listIn)
        {
            System.out.print("TOTAL OF Wages RECEIVED: ");
            System.out.println(listIn.calculateTotalReceived());
        }
    }


