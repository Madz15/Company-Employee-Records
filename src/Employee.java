
/** Class used to record the details of employee */
public class Employee {

    private String name;
    private int empId;
   // private int ni;
    private String address;
    private String email;
   // private String dept;
    private WagesList Wages;
    public static final int MAX = 12;

    /**
     * constructor initialises the name, empId, ni, address, email and department of the employee
     * sets the Wages made to the empty list
     *
     * @param nameIn:    name of employee
     * @param empIdIn:   employee id number
     * @param addressIn: address of employee
     * @param emailIn:   email of employee
     */


    //@param Wages: employee wages

    public Employee (String nameIn, int empIdIn,  String addressIn,
                     String emailIn )
    {
        name = nameIn;
        empId = empIdIn;
        address = addressIn;
        email = emailIn;
        Wages = new WagesList(MAX);



    }



    /** Records a Wages for the employee
     *  @param wagesIn: Wages received by employee
     */
    public void makeWages(Wages wagesIn)
    {
        Wages.addWages (wagesIn); // call WagesList method
    }

    /** Reads the name of the employee
     *  @return Returns the name of the employee
     */
    public String getName()
    {
        return name;
    }

    /** Reads the employee identification of the employee
     *  @return Returns the empId of the employee
     */
    public int getempId()
    {
        return empId;
    }

    /** Reads the national insurance of the employee
     *  @return Returns the ni of the employee
     */


    /** Reads the address of the employee
     *  @return Returns the address of the employee
     */
    public String getaddress()
    {
        return address;
    }

    /** Reads the email address of the employee
     *  @return Returns the email of the employee
     */
    public String getemail()
    {
        return email;
    }

    /** Reads the department of the employee
     *  @return Returns the dept of the employee
     */


    /** Reads the Wages of the employee
     *  @return Returns the Wages to the employee
     */
    public WagesList getWages()
    {
        return Wages;
    }

    @Override
    public String toString()
    {
        return name+", "+ empId +","+ address + "," + email+","+Wages;
    }
}
