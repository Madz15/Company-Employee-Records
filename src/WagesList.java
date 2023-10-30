/** imported the Arraylist class from the java.util package
 */

import java.util.ArrayList;

/** Collection class to hold a list of Wages objects */

public class WagesList
{
    /** the ArrayList class to store a collection of Wages in the wList attribute
     * the public constant value MAX to record the maximum number of Wages that we can record */

    //attributes
    private ArrayList<Wages> wList;
    public final int MAX;

    /** Constructor initialises the empty Wages list and sets the maximum list size
     * @param maxIn: The maximum number of Wages in the list */

    public WagesList (int maxIn)
    {
        wList = new ArrayList<>();
        MAX = maxIn;
    }

    /** Checks if the Wages list is full
     * @return returns true if the list is full and false otherwise */

    public boolean isFull()
    {
        //the wList will be full when its size is equal to the value of our constant MAX
        return wList.size() == MAX;
    }

    /** Gets the total number of Wages
     * @return returns the total number of Wages currently in the list */

    public int getTotal ()
    {
        return wList.size();
    }

    /** Adds a new wage to the end of the list
     * @param wIn: the wage to add
     * @return returns true if the object was added successfully and false otherwise */

    public boolean addWages (Wages wIn)
    {
        if (!isFull()) // ok to add Wages
        {
            wList.add(wIn);
            return true;
        }
        else
        {
            return false; // Wages not added to a full list
        }
    }

    /** Reads the Wages at the give position in the list
     * @param positionIn: the logical position of the Wages in the list
     * @return returns the Wages at the given logical position in the list or null if no Wages at that logical position */

    public Wages getWages (int positionIn)
    {
        // check for invalid logical position

        if (positionIn < 1 || positionIn > getTotal())
        {
            // no object found at given position
            return null;
        }
        else
        {
            // take one off logical position to get Arraylist position
            return wList.get(positionIn - 1);
        }
    }
    /** Calculates the total Wages made by the employer
     * @return returns the total value of Wages recorded */

    public double calculateTotalReceived ()
    {
        // initialise totalReceived
        double totalReceived = 0;
        //loop through all Wages
        for (Wages w: wList)
        {
            // add current Wages to running total
            totalReceived = totalReceived + w.getAmount();
        }
        return totalReceived;
    }

    @Override
    public String toString()
    {
        return wList.toString();
    }
}
