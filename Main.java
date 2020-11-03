import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JPanel topPanel;
  JPanel buttonPanel;

  JTextField display;
  String displayText;

  JButton[] numberButtons;
  JButton enter;
  JButton clear;

  Font biggerFont;

  int astericksAmount;

  int[] astericksArray;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initialize the main panel with a border layout
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    // initialize the button panel with grid layout
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4, 3));

    //initialize the top panel with defualt layout (flow)
    topPanel = new JPanel();

    //initialize bigger Font
    biggerFont = new Font("arial", Font.PLAIN, 24);
    //create the display
    display = new JTextField("CLOSE");
    //set a preferred size
    display.setPreferredSize(new Dimension(800, 100));
    //add to top
    topPanel.add(display);
    //creates bigger font for display
    display.setFont(biggerFont);

    //creating the number buttons
    numberButtons = new JButton[10];
    for(int i = 0; i < numberButtons.length; i++){
      numberButtons[i] = new JButton("" + i);
      //set the action command
      numberButtons[i].setActionCommand("" + i);
      //add action ActionListener
      numberButtons[i].addActionListener(this);
    }

    //initialize the array to store input
    astericksArray = new int[4];

    //create enter button
    enter = new JButton("Enter");
    enter.addActionListener(this);
    enter.setActionCommand("enter");

    //create clear button
    clear = new JButton("CLEAR");
    clear.addActionListener(this);
    clear.setActionCommand("clear");

    //initialize amount of astericks Variable
    astericksAmount = 0;

    //add buttons to grid
    buttonPanel.add(numberButtons[1]);
    buttonPanel.add(numberButtons[2]);
    buttonPanel.add(numberButtons[3]);

    buttonPanel.add(numberButtons[4]);
    buttonPanel.add(numberButtons[5]);
    buttonPanel.add(numberButtons[6]);

    buttonPanel.add(numberButtons[7]);
    buttonPanel.add(numberButtons[8]);
    buttonPanel.add(numberButtons[9]);

    buttonPanel.add(clear);
    buttonPanel.add(numberButtons[0]);
    buttonPanel.add(enter);

    //assemble the panels
    mainPanel.add(topPanel, BorderLayout.PAGE_START);
    mainPanel.add(buttonPanel, BorderLayout.CENTER);

    //add the main panel to the frame
    frame.add(mainPanel);
 
    

  }

  //method that can reset astericks counter
  public void mainAstericksCount(){
    astericksAmount = 0;
   }



  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //gets rid of text when user types
    displayText = display.getText();
    if(astericksAmount == 0){
      display.setText("");
    }
    

    //checks if code entered is correct
    if(command.equals("enter") && astericksArray[0] == 1 && astericksArray[1] == 2 && astericksArray[2] == 3 && astericksArray[3] == 4){
      display.setText("OPEN");
      mainAstericksCount();
    }else if(command.equals("enter")){
      display.setText("WRONG PIN");
      mainAstericksCount();
    }

    //detects the number the user entered, saves it, and displays an astericks
    if(command.equals("1")){
      displayText = display.getText();
      display.setText(displayText + "*");
      astericksArray[astericksAmount] = 1;
      astericksAmount = astericksAmount + 1;
    }else if(command.equals("2")){
      displayText = display.getText();
      display.setText(displayText + "*");
      astericksArray[astericksAmount] = 2;
      astericksAmount = astericksAmount + 1;
    }else if(command.equals("3")){
      displayText = display.getText();
      display.setText(displayText + "*");
      astericksArray[astericksAmount] = 3;
      astericksAmount = astericksAmount + 1;
    }else if(command.equals("4")){
      displayText = display.getText();
      display.setText(displayText + "*");
      astericksArray[astericksAmount] = 4;
      astericksAmount = astericksAmount + 1;
    }else if(command.equals("5")){
      displayText = display.getText();
      display.setText(displayText + "*");
      astericksArray[astericksAmount] = 5;
      astericksAmount = astericksAmount + 1;
    }else if(command.equals("6")){
      displayText = display.getText();
      display.setText(displayText + "*");
      astericksArray[astericksAmount] = 6;astericksAmount = astericksAmount + 1;
    }else if(command.equals("7")){
      displayText = display.getText();
      display.setText(displayText + "*");
      astericksArray[astericksAmount] = 7;
      astericksAmount = astericksAmount + 1;
    }else if(command.equals("8")){
      displayText = display.getText();
      display.setText(displayText + "*");
      astericksArray[astericksAmount] = 8;
      astericksAmount = astericksAmount + 1;
    }else if(command.equals("9")){
      displayText = display.getText();
      display.setText(displayText + "*");
      astericksArray[astericksAmount] = 9;
      astericksAmount = astericksAmount + 1;
    }else if(command.equals("0")){
      displayText = display.getText();
      display.setText(displayText + "*");
      astericksArray[astericksAmount] = 0;
      astericksAmount = astericksAmount + 1;
    }

    //clears all data
    if(command.equals("clear")){
      run();
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
