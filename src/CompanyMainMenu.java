
import java.lang.String;
import java.lang.NullPointerException;
import java.text.NumberFormat;
import java.util.Scanner;

/**GUI for the Company Records application
 */

public class CompanyMainMenu
{

    public static void main(String[] args)
    {

        int empId;
        EmployeeList list;

        System.out.print("Enter Employee ID: ");
        empId = EasyScanner.nextInt(); // call private method
        System.out.print(empId);
        // initialise Employee list
        list  = new EmployeeList(empId);

        EmployeeFileHandler.readRecords(list);

        char choice;
        do
        {
            System.out.println();
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Remove Employee");
            System.out.println("4. Wages");
            System.out.println("5. List Wages");
            System.out.println("6. Save and Quit");
            System.out.println();
            System.out.print("Enter choice (1-6): ");
            choice = EasyScanner.nextChar();
            System.out.println();

            switch(choice)
            {
                case '1': addHandler(empId,list);
                    break;
                case '2': displayHandler(list);
                    break;
                case '3': removeHandler(empId,list);
                    break;
                case '4': paymentHandler(empId,list);
                    break;
                case '5': listHandler(empId,list);
                    break;
                case '6': saveAndQuitHandler(empId,list);
                    break;
                default: System.out.println("Enter 1-6 only");

            }
        }while(choice!= '6');


    }


    /**
     * Method to request number of company empId from the user
     * @return number of empId
     */


    static void addHandler(int empIdIn, EmployeeList listIn)
    {

        System.out.println("Enter employee ID: ");
        int empIdEntered = EasyScanner.nextInt();

        System.out.println("Enter name: ");
        String nameEntered = EasyScanner.nextString();

        System.out.println("Enter address: ");
        String addressEntered = EasyScanner.nextString();

        System.out.println("Enter email address: ");
        String emailaddressEntered = EasyScanner.nextString();


       if(empIdEntered < 1 || empIdEntered > empIdIn)
        {
            System.out.println ("There are only "  + empIdIn  + " empId");
        }
        else if(listIn.search(empIdEntered) !=  null)
        {
            System.out.println("Employee ID "  + empIdEntered  + " is taken");
        }
        else  // ok to add Employee
        {
            Employee e =  new Employee (nameEntered,empIdEntered,addressEntered,emailaddressEntered);
           listIn.addEmployee(e);
            System.out.println("NEW EMPLOYEE ID: "+ "\t"+ empIdEntered +"\t"+ "NAME:" + "\t"+ nameEntered + "\t"+ " SUCCESSFULLY ADDED!");
        }
    }

    static void displayHandler(EmployeeList listIn)
    {
        int i;
        if(listIn.isEmpty()) // no empId to display
        {
            System.out.println("Employee ID are empty");
        }
        else // display empId
        {

            System.out.println("Employee ID"  + "\t" + "\t" +  "Name" + "\t" + "\t" + "address" + "\t" + "\t" + "Email Address" + "\n" );
            for(i = 1; i <=  listIn.getTotal(); i++ )
            {
                System.out.println(listIn.getEmployee(i).getempId()
                        + "\t\t"
                        + listIn.getEmployee(i).getName()
                        +"\t\t"
                        + listIn.getEmployee(i).getaddress()
                        + "\t\t"
                        + listIn.getEmployee(i).getemail());

            }
        }
    }

    static void removeHandler(int empIdIn, EmployeeList listIn)
    {
        System.out.println("Enter employee ID number: ");
        int empIdEntered = EasyScanner.nextInt();
        // check for errors
        if(empIdEntered < 1 || empIdEntered>empIdIn)
        {
            System.out.println("Invalid employee ID ");
        }
        else if(listIn.search(empIdEntered)== null)
        {
            System.out.println("employee ID number " +  empIdEntered +  " is empty");
        }
        else // ok to remove Employee
        {
            listIn.removeEmployee(empIdEntered);
            System.out.println("Employee removed from employee ID " +  empIdEntered);
        }
    }

    static void paymentHandler(int empIdIn, EmployeeList listIn)
    {
        System.out.println("Enter employee ID : ");
        int empIdEntered = EasyScanner.nextInt();

        System.out.println("Enter month: ");
        String monthEntered = EasyScanner.nextString();


        Scanner sc = new Scanner(System.in);
        double basicS, grossS, netS;
        double bonus, holidayP, overT, tips;
        double deductions, tax, ni;
        double total;
        //User enter basic salary
        System.out.println("Enter the employee basic salary: ");
        // the basic salary will store in
        basicS = sc.nextDouble();

        //User enter bonus
        System.out.println("Enter the employee bonus");
        // the bonus will store in
        bonus = sc.nextDouble();

        //User enter holiday pay
        System.out.println("Enter the employee holiday pay");
        // the holiday pay will store in
        holidayP = sc.nextDouble();

        //User enter overtime pay
        System.out.println("Enter the employee overtime");
        //the overtime pay will store in
        overT = sc.nextDouble();

        //User enter tips payment
        System.out.println("Enter the employee tips");
        // the tips will store in
        tips = sc.nextDouble();

        // to get the gross salary you need to add the bonus + holiday pay + over time + tips
        grossS = basicS + bonus + holidayP + overT + tips;

        System.out.println("The Gross Salary for this month is: " + grossS);
        System.out.println();

        //User enter tax
        System.out.println("Enter the employee tax");
        // the tax will store in
        tax = sc.nextDouble();

        //User enter NI
        System.out.println("Enter the employee National Insurance contribution");
        // the ni contribution will store in
        ni = sc.nextDouble();


        deductions = tax + ni;
        System.out.println("Total deduction for this month is: " + deductions);
        System.out.println();

        netS = grossS - deductions;
        System.out.println("Your Net Salary for this month is " + netS);
        System.out.println();


               // check for errors

       if(empIdEntered < 1 || empIdEntered>empIdIn)
       {
           System.out.println("Invalid employee ID number");
        }
        else if(listIn.search(empIdEntered) == null)
        {
            System.out.println("employee ID number " +  empIdEntered +  " is empty");
        }
        else // ok to process Wages
       {
           Wages wages =  new Wages(monthEntered,netS);

           listIn.search(empIdEntered).makeWages(wages);
           System.out.println("Wages recorded");
        }
    }

    static void listHandler(int empIdIn, EmployeeList listIn)
    {
        int i;
        System.out.println("Enter employee ID : ");
        int empIdEntered = EasyScanner.nextInt();
        // check for errors
        if(empIdEntered < 1 || empIdEntered > empIdIn)
        {
            System.out.println("Invalid employee ID ");
        }
        else if(listIn.search(empIdEntered) == null)
        {
            System.out.println("employee ID  " + empIdEntered + " is empty");
        }
        else // ok to list Wages
        {
            Employee e =  listIn.search(empIdEntered);
            WagesList w  = e.getWages();
            if(e.getWages().getTotal() == 0)
            {
                System.out.println("No Wages found for this Employee");
            }
            else
            {
                // The NumberFormat class is similar to the DecimalFormat class that we previously.
                //   The getCurrencyInstance method of this class reads the system values to find out
                //  which country we are in, then uses the correct currency symbol
                NumberFormat nf =  NumberFormat.getCurrencyInstance();
                String s;
                System.out.println("Month" +  "\t\t" +  "Amount" +  "\n");
                for(i =  1; i <=  w.getTotal(); i++  )
                {
                    s =  nf.format(w.getWages(i).getAmount());
                    System.out.println("" + w.getWages(i).getMonth() +  "\t\t\t" + s);
                }
                System.out.println("\n" + "Total reeived so far :   " + 	nf.format(w.calculateTotalReceived()));
            }
        }
    }

    static void saveAndQuitHandler(int empIdIn, EmployeeList listIn)
    {
        EmployeeFileHandler.saveRecords(empIdIn,listIn);
    }


}



