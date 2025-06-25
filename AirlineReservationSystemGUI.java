/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoop;

//Raghad Bawazeer  2214038
//Nadine Alsahafi  2211460
// RN Airlines 

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;



public class Passenger extends JFrame{
    //create global variables
    private String PassengerName=null;
    private String FlightClass=null;
    private String DateAndTime=null;
    private String Airline= null;
    private final String From=("JEDDAH");
    private String TO=null;
    private double Total=0;
    
    private JRadioButton  maleRB, femaleRB;
    private JLabel label1,label2, label3, label4,label5,label6;
    private JButton nextp;
    private JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel7;
    private ImageIcon image1;
    private JTextField text1,text2,text3;
    private ButtonGroup g1;

public  Passenger(){
    //Create First frame for passenger informations
    
    setTitle("RN AIRLINES");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800,450);
    setLayout(new GridLayout(1,2));
    setLocationRelativeTo(null);

   image1= new ImageIcon("Rn AirLines.jpg");
   label1= new JLabel(image1);
   panel7=new JPanel();
   panel7.add(label1);

   label2=new JLabel("BEFOR BOOKING A FLIGHT ENTER YOUR INFORMATION ");
   panel1=new JPanel();
    panel1.add(label2);
   label2.setFont(new Font("Arial",Font.PLAIN,14));
  
  label3=new JLabel("ENTER YOUR NAME: ");
  text1=new JTextField(20);
  panel2=new JPanel();
  panel2.add(label3);
  panel2.add(text1);
     
    label6=new JLabel("CHOOSE YOUR GENDER ");
    maleRB =new JRadioButton("MALE");
    femaleRB=new JRadioButton("FEMALE");
    g1=new ButtonGroup();
    g1.add(maleRB);
    g1.add(femaleRB);
    
    panel3=new JPanel();
    panel3.add(label6);
    panel3.add(maleRB);
    panel3.add(femaleRB);
  
    label4=new JLabel("ENTER YOUR AGE ( ALLOW BETWEEN 10 To 80 ) :  ");
    text2=new JTextField(10);
    panel4=new JPanel();
    panel4.add(label4);
    panel4.add(text2);
     
    label5=new JLabel("ENTER YOUR PHONE NUMBER ( 10 DIGHTS ONLY ) : ");
    text3=new JTextField(10);
    panel5=new JPanel();
    panel5.add(label5);
    panel5.add(text3);
    
     nextp=new JButton("NEXT");
   
   panel6=new JPanel(new GridLayout(6,1));
   panel6.add(panel1);
   panel6.add(panel2);
    panel6.add(panel3);
    panel6.add(panel4);
    panel6.add(panel5);
    panel6.add(nextp);
        
        add(panel7);
        add(panel6);
        
      nextp.addActionListener(new Action());
      
         setVisible(true);
       }

       private class Action implements ActionListener{
        public void actionPerformed(ActionEvent e) {
          
       PassengerName=text1.getText();
                try {
                    // Validate the text fields and radio buttons
                    validateFields();
                    // If all fields are valid, proceed to the next frame
                    AirLinesMenu Frame2 = new AirLinesMenu();
                     dispose();//close the past frame
                } catch (Exception ex) {
                    // Display an error message using JOptionPane
                    JOptionPane.showMessageDialog(null,ex.getMessage());  }    }
        
            private void validateFields() throws Exception {
                
            String field1 = text1.getText().replaceAll("\\s+", "");
            String field2 = text2.getText();
            String field3 = text3.getText();
     
        // Check if any field is empty or if no radio button is selected
         if (field1.isEmpty() || field2.isEmpty()||field3.isEmpty()||!maleRB.isSelected() && !femaleRB.isSelected()) {
            throw new Exception("One or more fields are empty or no option is selected.");
             
        }
         int age = Integer.parseInt(field2);
         
          if((!field1.matches("[a-zA-Z]+")&&(age <10|| age > 80) && field3.length()!=10)|| 
                  (!field1.matches("[a-zA-Z]+")&& (age <10|| age > 80))||
                   ((age <10|| age > 80 )&& field3.length()!=10)||
                  (!field1.matches("[a-zA-Z]+")&&field3.length()!=10)){
         throw new Exception("INVALID INPUTS!, ENTER VALID INPUT");
   }
      
  if(!field1.matches("[a-zA-Z]+")){
             throw new Exception("Invalid input!, enter only letters");
         }
  
   else if (age <10|| age > 80) {
        throw new Exception("Invalid age. Age must be between 10 and 80.");
    }
   
   else if (field3.length()!=10) {
        throw new Exception("Invalid phone number. Phone number must be 10 digits.");
    }
               
}}
       
       
//////////////////////////////////////////////////////////////////////////////////////////////////
  
       
public class AirLinesMenu extends JFrame {
 
    private  JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem SkyItem,FlyItem;
    private ImageIcon image1;
    private JLabel label1;
    
    public AirLinesMenu() {
        //Create Second frame to choose from the menu
        
        setTitle("Airlines Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 500);
        setLocationRelativeTo(null);
         setLayout(new BorderLayout());
        // Create a menu bar
       menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create a menu
        menu = new JMenu("AirLines  Menu");
        menuBar.add(menu);

        // Create menu items
       SkyItem= new JMenuItem("Sky Airline(to Khobar)");
        menu.add(SkyItem);

       FlyItem = new JMenuItem("Fly AirLine(to Riyadh)");
        menu.add(FlyItem);
   image1= new ImageIcon("R1.jpeg");
   label1= new JLabel(image1);
   
     
        // Add ActionListener to the first menu item
        SkyItem.addActionListener(new Action());
        FlyItem.addActionListener(new Action());
        
        add(label1);

        // Display the menu 
        setVisible(true);
    }
  
     
   private class Action implements ActionListener{
   @Override
   public void actionPerformed(ActionEvent e) {
       
     if(e.getSource()==SkyItem){
        try {
             SkyFlight frame3= new SkyFlight();
             Airline="SKY AIRLINE ";
             dispose();//close the past frame
         } 
         catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
         }
          } 
     
     
       if(e.getSource()==FlyItem){
         try {
             FlyFlight frame3= new FlyFlight();
              Airline="FLY AIRLINE ";
             dispose();//close the past frame
         } 
         catch (Exception ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
         }
          }
   }
   }
}
////////////////////////////////////////////////////////////////////////////////////////////////////


public class SkyFlight  extends JFrame{
    private JLabel label1,label2,label3,label4;
    private JButton nextp;
    private JPanel panel1,panel2,panel3,panel4;
    private JList CList;
    private JTextField text1,text2;
    private JRadioButton  RB1, RB2,RB3;
  private String[] arr;
    private ButtonGroup g1;

    
   public SkyFlight() throws Exception{
     //Create the third frame if the passenger choose Sky Airline
    
      setTitle("SKY AIRLINE");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(450,600);
    setLayout(new FlowLayout());
    setLocationRelativeTo(null);
  
 
   //List for flight classes
   label1=new JLabel("CHOOSE THE FLIGHT CLASS: "); 
   label1.setFont(new Font("Arial",Font.PLAIN,20));
    
   String[] list={"First calss","busniss calss","Econmy calss"};
   CList= new JList(list);
   CList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

   
   panel1=new JPanel();
   panel1.add(label1);
   panel1.add(CList);
   
   label2=new JLabel("FROM: ");
    label2.setFont(new Font("Arial",Font.PLAIN,20));
   text1=new JTextField("JEDDAH");
   text1.setSize(20, 20);
   text1.setEditable(false);
   
    panel2=new JPanel();
   panel2.add(label2);
   panel2.add(text1);
   
   label3=new JLabel("TO: ");
     label3.setFont(new Font("Arial",Font.PLAIN,20));
   text2=new JTextField("KHOBAR");
    text2.setSize(20, 20);
   text2.setEditable(false);
   
    panel3=new JPanel();
   panel3.add(label3);
   panel3.add(text2);
   
   label4=new JLabel("CHOOSE THE DATE AND TIME : ");
    label4.setFont(new Font("Arial",Font.PLAIN,20));
    
    //read date and time from file
    arr = new String[3];
   File file=new File("Skytimes.txt");
   Scanner scan=new Scanner(file);
   while(scan.hasNext()){
     for(int i=0;i<3;i++){
         arr[i]=scan.nextLine();
     }  
   }
   scan.close();//close the file
       
   //initialize the radio buttons
      RB1=new JRadioButton(arr[0]);
      RB2=new JRadioButton(arr[1]);
      RB3=new JRadioButton(arr[2]);
     g1= new ButtonGroup();
     g1.add(RB1);  
     g1.add(RB2);  
     g1.add(RB3);
    
    nextp=new JButton("NEXT");
     
    panel4=new JPanel(new GridLayout(8,1));
     
 panel4.add(panel1);
 panel4.add(panel2);
 panel4.add(panel3);
 
 panel4.add(label4);
 panel4.add(RB1);
 panel4.add(RB2);
 panel4.add(RB3);
 panel4.add(nextp);
 
    add(panel4);
   nextp.addActionListener(new Action());
       
        setVisible(true);
   }
   
     private class Action implements ActionListener{
   @Override
   public void actionPerformed(ActionEvent e) {
      FlightClass=(String) CList.getSelectedValue();
      TO="KHOBAR";
          if(RB1.isSelected()){
        DateAndTime=RB1.getActionCommand();
    }
          else  if(RB2.isSelected()){
        DateAndTime=RB2.getActionCommand();
    }
          else if (RB3.isSelected()){
        DateAndTime=RB3.getActionCommand();
    }
          
    if(FlightClass=="First calss"){
        Total=5000;
    }
     if(FlightClass=="busniss calss"){
        Total=3500;
    } if(FlightClass=="Econmy calss"){
        Total=1500;
    }
        try {
      validateListAndRadio();
             
         receipt farme4= new receipt();
         dispose();
         }  catch (Exception ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
       }
   
     }
      
    private void validateListAndRadio() throws Exception {
         

        // Check if radio button or any item from the list are not selcted
         if (!RB1.isSelected() && !RB2.isSelected()&& !RB3.isSelected()||CList.getSelectedValue()==null) {
            throw new Exception("Please select a flight class and a date and time. ");
             
        }
    
}
}}//end sky class

//////////////////////////////////////////////////////////////////////////////////////////////////

public class FlyFlight  extends JFrame {
  
    private JLabel label1,label2,label3,label4;
    private JButton nextp;
    private JPanel panel1,panel2,panel3,panel4;
    private JList CList;
    private JTextField text1,text2;
    private JRadioButton  RB1, RB2,RB3;
    private String[] arr;
    private ButtonGroup g1;
  
   public FlyFlight() throws Exception{
      //Create the third frame if the passenger choose Fly Airline
    
    setTitle("FLY AIRLINE");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(450,600);
    setLayout(new FlowLayout());
    setLocationRelativeTo(null);
  
     //List for flight classes
   label1=new JLabel("CHOOSE THE FLIGHT CLASS: "); 
    label1.setFont(new Font("Arial",Font.PLAIN,20));
    
   String[]list={"First calss","busniss calss","Econmy calss"};
   CList= new JList(list);
   CList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

   
    panel1=new JPanel();
   panel1.add(label1);
   panel1.add(CList);
   
   label2=new JLabel("FROM: ");
   label2.setFont(new Font("Arial",Font.PLAIN,20));
   text1=new JTextField("JEDDAH");
   text1.setSize(20, 20);
   text1.setEditable(false);
   
    panel2=new JPanel();
   panel2.add(label2);
   panel2.add(text1);
   
   label3=new JLabel("TO: ");
     label3.setFont(new Font("Arial",Font.PLAIN,20));
   text2=new JTextField("RIYADH");
    text2.setSize(20, 20);
   text2.setEditable(false);
   
    panel3=new JPanel();
   panel3.add(label3);
   panel3.add(text2);
   
   label4=new JLabel("CHOOSE THE DATE AND TIME : ");
    label4.setFont(new Font("Arial",Font.PLAIN,20));
    
   //read date and time from file 
   arr = new String[3];
   File file=new File("Flytimes.txt");
   Scanner scan=new Scanner(file);
   while(scan.hasNext()){
     for(int i=0;i<3;i++){
         arr[i]=scan.nextLine();
     }  
   }
   scan.close();// close the file
       
   
    //initialize the radio buttons
      RB1=new JRadioButton(arr[0]);
      RB2=new JRadioButton(arr[1]);
      RB3=new JRadioButton(arr[2]);
    g1= new ButtonGroup();
    g1.add(RB1); 
    g1.add(RB2);  
    g1.add(RB3);
    
     
     nextp=new JButton("NEXT");
     
     panel4=new JPanel(new GridLayout(8,1));
      
      
 panel4.add(panel1);
 panel4.add(panel2);
 panel4.add(panel3);
 
 panel4.add(label4);
 panel4.add(RB1);
 panel4.add(RB2);
 panel4.add(RB3);
 panel4.add(nextp);
 
 add(panel4);
 
 nextp.addActionListener(new Action());
        setVisible(true);
   }
   
   private class Action implements ActionListener{
 
   public void actionPerformed(ActionEvent e) {
       TO="RIYADH";
          FlightClass=(String) CList.getSelectedValue();
    
          if(RB1.isSelected()){
        DateAndTime=RB1.getActionCommand();
    }
          else  if(RB2.isSelected()){
        DateAndTime=RB2.getActionCommand();
    }
          else if (RB3.isSelected()){
        DateAndTime=RB3.getActionCommand();
    }
          
    if(FlightClass=="First calss"){
        Total=5000;
    }
     if(FlightClass=="busniss calss"){
        Total=3500;
    } if(FlightClass=="Econmy calss"){
        Total=1500;
    }
        try {
      validateListAndRadio();
             
         receipt farme4= new receipt();
         dispose();
         
         }  catch (Exception ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
       }
   
     }
      
    private void validateListAndRadio() throws Exception {
         
       // Check if radio button or any item from the list are not selcted
         if (!RB1.isSelected() && !RB2.isSelected()&& !RB3.isSelected()||CList.getSelectedValue()==null) {
            throw new Exception("Please select a flight class and a date and time. ");
             
        }
    
}
}
   }//end fly class
  
  
//////////////////////////////////////////////////////////////////////////////////

public class receipt extends JFrame {
private JLabel label1,label2,label3,label4,label5,label6,label7,label8;
private ImageIcon image2;
private JPanel panel1,panel2;

public receipt() throws IOException{
    //Create the last frame for receipt
      setSize(800,450);
      setTitle("RECEIPT");
     setLayout(new GridLayout(1,2));
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
   image2= new ImageIcon("R2.jpeg");
   label8= new JLabel(image2);
   panel1=new JPanel();
   panel1.add(label8);
   
   label1=new JLabel("THE NAME OF PASSENGER: "+PassengerName);
   label1.setFont(new Font("Arial",Font.PLAIN,16));
   
   label2=new JLabel("AIRlINE: "+Airline);
   label2.setFont(new Font("Arial",Font.PLAIN,16));
  
    label3=new JLabel("FROM: "+From);
    label3.setFont(new Font("Arial",Font.PLAIN,16));
    
     label4=new JLabel("TO: "+TO);
    label4.setFont(new Font("Arial",Font.PLAIN,16));
    
     label5=new JLabel("DATE AND TIME: "+ DateAndTime);
    label5.setFont(new Font("Arial",Font.PLAIN,16));
  
   label6=new JLabel("THE CLASS FLIGHT: "+FlightClass);
   label6.setFont(new Font("Arial",Font.PLAIN,16));
   
    label7=new JLabel("The Total is: "+Total);
    label7.setFont(new Font("Arial",Font.PLAIN,16));
  
 panel2=new JPanel(new GridLayout(7,1));
 panel2.add(label1);
 panel2.add(label2);
 panel2.add(label3);
 panel2.add(label4);
 panel2.add(label5);
 panel2.add(label6);
 panel2.add(label7);
  add(panel1);
  add(panel2);
    
 //write receipt in file
  FileWriter file =new FileWriter("RECEIPT.txt");
  PrintWriter pw=new PrintWriter(file);
  pw.println(label1.getText());
  pw.println(label2.getText());
  pw.println(label3.getText()); 
  pw.println(label4.getText()); 
  pw.println(label5.getText());
  pw.println(label6.getText());
  pw.println(label7.getText());
  pw.close();
   
  setVisible(true);
    
}   }




   public static void main(String[] args) {
        
     Passenger frame1= new Passenger();
      

    
}
}
      


