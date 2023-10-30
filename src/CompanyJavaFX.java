
import java.text.NumberFormat;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;

/**GUI for the Company application */
public class CompanyJavaFX extends Application
{
    // the attributes
    private EmployeeList list;
    private int empId;

    // WIDTH and HEIGHT of GUI stored as constants
    private final int WIDTH = 1200;
    private final int HEIGHT = 650;
    // visual components
    private Label headingLabel = new Label("Company Application");
    private Label empIdLabel1 = new Label("Employee");
    private TextField empIdField1 =  new TextField();
    private Label nameLabel = new Label("Name");
    private TextField nameField =  new TextField();
    private Label addressLabel = new Label("Address");
    private TextField addressField =  new TextField();
    private Label emailLabel = new Label("E-mail Address");
    private TextField emailField =  new TextField();
    private Button addButton = new Button("Add Employee");
    private Button displayButton =  new  Button("Display Employee");
    private Button removeButton  = new Button("Remove Employee");
    private Button saveAndQuitButton  = new Button("Save and Quit");
    private TextArea displayArea1  = new TextArea();
    private Label empIdLabel2 = new Label("Employee");
    private TextField empIdField2  = new TextField();
    private Label monthLabel = new Label("Month");
    private TextField monthField  = new TextField();
    private Label amountLabel = new Label("Amount");
    private TextField amountField =  new TextField();
    private Button wagesButton  = new Button("Add Wages");
    private Button listButton  = new Button("List Wages");
    private TextArea displayArea2 =  new TextArea();
   


    @Override
    /** Initialises the screen
     *  @param stage:   The scene's stage
     */
    public void start(Stage stage)
    {
        empId = getempId(); // call private method
        // initialise employee list
        list  = new EmployeeList(empId);
        EmployeeFileHandler.readRecords(list);

        // create four HBoxes
        HBox empIdDetails = new HBox (10);
        HBox employeeButtons = new HBox(10);
        HBox wagesDetails = new HBox(10);
        HBox wagesButtons = new HBox(10);
        // add components to HBoxes
        empIdDetails.getChildren().addAll(empIdLabel1, empIdField1, nameLabel, nameField, addressLabel, addressField, emailLabel, emailField);
        employeeButtons.getChildren().addAll(addButton, displayButton, removeButton, saveAndQuitButton);
        wagesDetails.getChildren().addAll(empIdLabel2, empIdField2, monthLabel, monthField,
                amountLabel, amountField);
        wagesButtons.getChildren().addAll(wagesButton, listButton);
        // create VBox
        VBox root = new VBox(10);
        // add all components to VBox
        root.getChildren().addAll(	headingLabel, empIdDetails, employeeButtons, displayArea1,
                wagesDetails, wagesButtons, displayArea2);
        // create the scene
        Scene scene = new Scene(root, Color.LIGHTPINK);

        // set font of heading
        Font font = new Font("Calibri", 40);
        headingLabel.setFont(font);

        // set alignment of HBoxes
        empIdDetails.setAlignment(Pos.CENTER);
        employeeButtons.setAlignment(Pos.CENTER);
        wagesDetails.setAlignment(Pos.CENTER);
        wagesButtons.setAlignment(Pos.CENTER);
        // set alignment of VBox
        root.setAlignment(Pos.CENTER);

        // set minimum and maximum width of components
        empIdField1.setMaxWidth(50);
        empIdField2.setMaxWidth(50);

        empIdDetails.setMinWidth(WIDTH);
        empIdDetails.setMaxWidth(WIDTH);

        employeeButtons.setMinWidth(WIDTH);
        employeeButtons.setMaxWidth(WIDTH);

        wagesDetails.setMinWidth(WIDTH);
        wagesDetails.setMaxWidth(WIDTH);

        wagesButtons.setMinWidth(WIDTH);
        wagesButtons.setMaxWidth(WIDTH);

        root.setMinSize(WIDTH, HEIGHT);
        root.setMaxSize(WIDTH, HEIGHT);

        displayArea1.setMaxSize(WIDTH - 80, HEIGHT/5);
        displayArea2.setMaxSize(WIDTH - 80, HEIGHT/5);

        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);

        // customise the visual components

        // customise the VBox border and background
        BorderStroke style = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                new CornerRadii(0), new BorderWidths(2) );
        root.setBorder(new Border (style));
        root.setBackground(Background.EMPTY);

        // customise buttons
        addButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,
                new CornerRadii(10), Insets.EMPTY)));
        displayButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW,
                new CornerRadii(10), Insets.EMPTY)));
        removeButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW,
                new CornerRadii(10), Insets.EMPTY)));
        saveAndQuitButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW,
                new CornerRadii(10), Insets.EMPTY)));
        wagesButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW,
                new CornerRadii(10), Insets.EMPTY)));
        listButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW,
                new CornerRadii(10), Insets.EMPTY)));

        // call private methods for button event handlers
        addButton.setOnAction(e -> addHandler());
        displayButton.setOnAction(e -> displayHandler() );
        removeButton.setOnAction( e -> removeHandler());
        wagesButton.setOnAction( e -> paymentHandler());
        listButton.setOnAction( e -> listHandler());
        saveAndQuitButton.setOnAction( e -> saveAndQuitHandler());

        // configure the stage and make the stage visible
        stage.setScene(scene);
        stage.setTitle("Company Applicaton");
        stage.setResizable(false); // see discussion below
        stage.show();

    }

    /**
     * Method to request number of employee ID in the company
     * @return employee ID
     */
    private int getempId()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Employee ID");
        dialog.setTitle("Employee ID Information Request");

        String response = dialog.showAndWait().get();
        return Integer.parseInt(response);    }

    // event handler methods

    private void addHandler()
    {
        String empIdEntered =  empIdField1.getText();
        String nameEntered =  nameField.getText();
        String addressEntered = addressField.getText();
        String emailEntered = emailField.getText();
        // check for errors
        if(empIdEntered.length()== 0 || nameEntered.length()== 0)
        {
            displayArea1.setText ("Employee ID and name must be entered");
        }
        else if(Integer.parseInt(empIdEntered)< 1 || Integer.parseInt(empIdEntered)>empId)
        {
            displayArea1.setText ("There are only "  + empId  + " employee");
        }
        else if(list.search(Integer.parseInt(empIdEntered)) !=  null)
        {
            displayArea1.setText("Employee ID " +  Integer.parseInt(empIdEntered)  + " is occupied");
        }
        else  // ok to add a Tenant
        {
            Employee e =  new Employee(nameEntered,Integer.parseInt(empIdEntered),addressEntered,emailEntered);
            list.addEmployee(e);
            
            empIdField1.setText("");
            nameField.setText("");
            addressField.setText("");
                    emailField.setText("");
            displayArea1.setText("New employee in employee ID " 	+  empIdEntered +  " successfully added");
        }
    }

    public void displayHandler()
    {
        int i;
        if(list.isEmpty()) // no employee  to display
        {
            displayArea1.setText("All employee ID are empty");
        }
        else // display employee
        {
            displayArea1.setText("Employee ID" +  "\t" +  "Name" +  "\n");
            for(i = 1; i <=  list.getTotal(); i++ )
            {
                displayArea1.appendText(list.getEmployee(i).getempId()
                        + "\t\t"
                        + list.getEmployee(i).getName() + "\n");
            }
        }
    }

    private void removeHandler()
    {
        String empIdEntered =  empIdField1.getText();
        // check for errors
        if(empIdEntered.length()== 0)
        {
            displayArea1.setText("Employee ID must be entered");
        }
        else if(Integer.parseInt(empIdEntered) < 1 || Integer.parseInt(empIdEntered)>empId)
        {
            displayArea1.setText("Invalid employee ID");
        }
        else if(list.search(Integer.parseInt(empIdEntered))== null)
        {
            displayArea1.setText("Employee ID " +  empIdEntered +  " is empty");
        }
        else // ok to remove Employee
        {
            list.removeEmployee(Integer.parseInt(empIdEntered));
            displayArea1.setText("Employee removed " +  Integer.parseInt(empIdEntered));
        }
    }

    private void paymentHandler()
    {
        String empIdEntered = empIdField2.getText();
        String monthEntered = monthField.getText();
        String amountEntered = amountField.getText();
        // check for errors
        if(empIdEntered.length()== 0 || monthEntered.length()== 0 || amountEntered.length()== 0)
        {
            displayArea2.setText("Employee ID, month and amount must all be entered");
        }
        else if(Integer.parseInt(empIdEntered) < 1 || Integer.parseInt(empIdEntered)>empId)
        {
            displayArea2.setText("Invalid employee ID");
        }
        else if(list.search(Integer.parseInt(empIdEntered)) == null)
        {
            displayArea2.setText("Employee ID " +  empIdEntered +  " is empty");
        }
        else // ok to process payment
        {
            Wages p =  new Wages(monthEntered,Double.parseDouble(amountEntered));
            list.search(Integer.parseInt(empIdEntered)).makeWages(p);
            displayArea2.setText("Wages recorded");
        }
    }

    private void listHandler()
    {
        int i;
        String empIdEntered =  empIdField2.getText();
        // check for errors
        if(empIdEntered.length()== 0)
        {
            displayArea2.setText("Employee ID must be entered");
        }
        else if(Integer.parseInt(empIdEntered) < 1 || Integer.parseInt(empIdEntered) > empId)
        {
            displayArea2.setText("Invalid employee ID");
        }
        else if(list.search(Integer.parseInt(empIdEntered)) == null)
        {
            displayArea2.setText("Employee ID " + Integer.parseInt(empIdEntered) + " is empty");
        }
        else // ok to list payments
        {
            Employee t =  list.search(Integer.parseInt(empIdEntered));
            WagesList p  = t.getWages();
            if(t.getWages().getTotal() == 0)
            {
                displayArea2.setText("No wages receive for this employee");
            }
            else
            {
                /* The NumberFormat class is similar to the DecimalFormat class that we used
 					  previously.
                   The getCurrencyInstance method of this class reads the system values to find out 				     which country we are in, then uses the correct currency symbol */
                NumberFormat nf =  NumberFormat.getCurrencyInstance();
                String s;
                displayArea2.setText("Month" +  "\t\t" +  "Amount" +  "\n");
                for(i =  1; i <=  p.getTotal(); i++  )
                {
                    s =  nf.format(p.getWages(i).getAmount());
                    displayArea2.appendText("" + p.getWages(i).getMonth() +  "\t\t\t" + s + "\n");
                }
                displayArea2.appendText("\n" + "Total received so far :   " +
                        nf.format(p.calculateTotalReceived()));
                monthField.setText("");
                amountField.setText("");
            }
        }
    }

    private void saveAndQuitHandler()
    {
        EmployeeFileHandler.saveRecords(empId,list);
        Platform.exit();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}

