
import java.io.*;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.io.EOFException;

class EmployeeFileHandler
{
    public static void saveRecords(int empIdIn, EmployeeList listIn)
    {

        try
        {
            FileOutputStream EmployeeFile = new FileOutputStream("Employee.txt");
            DataOutputStream employeeWriter = new DataOutputStream(EmployeeFile);
            employeeWriter.writeInt(listIn.getTotal());
            for(int i=1; i <= empIdIn; i++)
            {
                if(listIn.getEmployee(i) != null)
                {
                    employeeWriter.writeInt(listIn.getEmployee(i).getempId());
                    employeeWriter.writeUTF(listIn.getEmployee(i).getName());
                    employeeWriter.writeInt(listIn.getEmployee(i).getWages().getTotal());
                    for(int j = 1; j<= listIn.getEmployee(i).getWages().getTotal(); j++)
                    {
                        employeeWriter.writeUTF(listIn.getEmployee(i).getWages().getWages(j).getMonth());
                        employeeWriter.writeDouble(listIn.getEmployee(i).getWages().getWages(j).getAmount());
                    }
                }
            }
            employeeWriter.flush();
            employeeWriter.close();
        }
        catch(IOException ioe)
        {
            System.out.println("Error writing file");
        }

    }

    public static void readRecords(EmployeeList listIn)
    {

        try
        {
            FileInputStream employeeFile = new FileInputStream("Employee.txt");
            DataInputStream employeeReader = new DataInputStream(employeeFile);

            int tempempId = 0;
            String tempName = new String("");
            String tempMonth = new String("");
            double tempAmount = 0 ;
            Employee tempEmployee = null;
            Wages tempWages =  null;
            int tot = 0;
            int totpay = 0;

            tot = employeeReader.readInt();
            for(int j = 1; j<=tot; j++)
            {
                tempempId = employeeReader.readInt();
                tempName = employeeReader.readUTF();
              //  tempEmployee = new Employee(tempempId, tempName);
                totpay = employeeReader.readInt();
                for(int k = 1; k <= totpay; k++)
                {
                    tempMonth = employeeReader.readUTF();;
                    tempAmount = employeeReader.readDouble();
                    tempWages = new Wages(tempMonth, tempAmount);
                    tempEmployee.makeWages(tempWages);
                }
                listIn.addEmployee(tempEmployee);

            }
            employeeReader.close();
        }

        catch(IOException ioe)
        {
            System.out.println("No records found");
        }

    }
}
