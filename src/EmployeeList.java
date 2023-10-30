
import java.util.ArrayList;

/** Collection class to hold a list of employee */

public class EmployeeList
{
    private ArrayList<Employee> eList;
    public final int MAX;

    /** Constructor initialises the empty employee list and sets the maximum list size
     *  @param   maxIn The maximum number of employee in the list
     */
    public EmployeeList(int maxIn)
    {
        eList = new ArrayList<>();
        MAX = maxIn;
    }

    /** Adds a new Employee to the list
     *  @param  eIn The employee to add
     *  @return Returns true if the employee was added successfully and false otherwise
     */
    public boolean addEmployee(Employee eIn)
    {
        if(!isFull())
        {
            eList.add(eIn);
            return true;
        }
        else
        {
            return false;
        }
    }

    /** Removes the employee in the given employee id
     *  @param empIdIn The employee id to of the employee to remove
     *  @return Returns true if the employee is removed successfully or false otherwise
     */
    public boolean removeEmployee(int empIdIn)
    {
        Employee findE = search(empIdIn); // call search method
        if (findE != null) // check employee is found at given employee ID number
        {
            eList.remove(findE); // remove given employee
            return true;
        }
        else
        {
            return false; // no employee in given ID
        }
    }

    /** Searches for the employee in the given employee id
     *  @param empIdIn The employee id number to search for
     *  @return Returns the employee in the given id number or null if no employee in the given id
     */
    public Employee search(int empIdIn)
    {
        for(Employee currentEmployee: eList)
        {
            // find employee with given id number
            if(currentEmployee.getempId() == empIdIn)
            {
                return currentEmployee;
            }
        }
        return null; // no employee found with given id number
    }

    /** Reads the employee at the given position in the list
     *  @param     positionIn The logical position of the employee in the list
     *  @return     Returns the eployee at the given logical position in the list
     *              or null if no employee at that logical position
     */
    public Employee getEmployee(int positionIn)
    {
        if (positionIn<1 || positionIn>getTotal()) // check for valid position
        {
            return null; // no object found at given position
        }
        else
        {
            // remove one frm logical position to get ArrayList position
            return eList.get(positionIn -1);
        }
    }


    /** Reports on whether or not the list is empty
     *  @return Returns true if the list is empty and false otherwise
     */
    public boolean isEmpty()
    {
        return eList.isEmpty();
    }

    /** Reports on whether or not the list is full
     *  @return Returns true if the list is full and false otherwise
     */
    public boolean isFull()
    {
        return eList.size()== MAX;
    }

    /** Gets the total number of employee
     *  @return Returns the total number of employee currently in the list
     */
    public int getTotal()
    {
        return eList.size();
    }

    @Override
    public String toString()
    {
        return eList.toString();
    }
}

