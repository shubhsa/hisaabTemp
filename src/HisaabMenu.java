package hisaab;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuFrame extends JFrame implements ActionListener
{
 private static final long serialVersionUID = 1L;
 
 JButton newRec,oldRec,myRec;  //declaring two global references of JButtons for adding new or accessing old records.
 JLabel title,uname;     //declaring two global references of JLabels for displaying welcome message and the username of the logged person.
 JLabel spiral,topDesign,bottomDesign;  //Declaring three global JLabel references for top,bottom and side spiral design. 
 
 
 MenuFrame()
 { 
  super("Hisaab");                                 //setting title of the frame as "Hisaab"
  setSize(780,600);                                  //setting size of the Menu frame as 800*600
  setLocation(140,40);                               //setting the location of the frame at coordinates (140,40)
 // setResizable(false);                               //setting window as not resizeable
  setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/hisaab.png"))); //setting the application icon
  setResizable(false); 
  
  title=new JLabel("Welcome to Hisaab");              //adding welcome message on title JLabel
  title.setFont(new Font("Georgia",Font.BOLD,40));    //setting the font as Georgia with bold attribute and font size 40 
  title.setForeground(Color.DARK_GRAY);               //setting the foreground color as Dark Gray
  title.setHorizontalAlignment(JLabel.CENTER);        //Aligning Label to center
  
  uname=new JLabel("Mr."+LoginFrame.userName);        //adding user-name on uname JLabel with String userName declared as static at loginFrame
  uname.setFont(new Font("Georgia",Font.BOLD,40));    //setting the font as Georgia with bold attribute and font size 40 
  uname.setForeground(Color.darkGray);                //setting the foreground color as Dark Gray
  uname.setHorizontalAlignment(JLabel.CENTER);        //Aligning Label to center
  
  newRec=new JButton("Naya Hisaab");                   //adding newRec button with Label "Naya Hisaab meaning new record"
  newRec.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/newRec.png")))); //adding ImageIcon to the Label newRec
  newRec.setFont(new Font("georgia",Font.PLAIN,20));   //setting the font as Georgia with bold attribute and font size 20
  newRec.setBackground(new Color(128, 0, 64));         //adding custom background to the button newRec
  newRec.setForeground(Color.white);                   //adding white foreground to the button newRec
  newRec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));   //setting HAND Cursor for newRec button
  newRec.setFocusable(false);                          //setting button as not focusable
  
  oldRec=new JButton("Poorana Hisaab");                 //adding newRec button with Label "Naya Hisaab meaning new record"
  oldRec.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/oldRec.png"))));  //adding ImageIcon to the Label oldRec
  oldRec.setFont(new Font("georgia",Font.PLAIN,20));    //setting the font as Georgia with bold attribute and font size 20
  oldRec.setBackground(new Color(128, 0, 64));          //adding custom background to the button oldRec
  oldRec.setForeground(Color.WHITE);                    //adding white foreground to the button oldRec
  oldRec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  //setting HAND Cursor for oldRec button
  oldRec.setFocusable(false);                          //setting button as not focusable
  
  myRec=new JButton("Mera Hisaab");                   //adding newRec button with Label "Naya Hisaab meaning new record"
  myRec.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/wallet.png"))));   //adding ImageIcon to the Label newRec
  myRec.setFont(new Font("georgia",Font.PLAIN,20));   //setting the font as Georgia with bold attribute and font size 20
  myRec.setBackground(new Color(128, 0, 64));         //adding custom background to the button newRec
  myRec.setForeground(Color.white);                   //adding white foreground to the button newRec
  myRec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));   //setting HAND Cursor for newRec button
  myRec.setFocusable(false);     //setting button as not focusable
  
  //adding design elements using JLabels
  
  spiral=new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/spiral.png"))));
  topDesign=new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/topp.png"))));
  bottomDesign=new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/bottom.png"))));

  /**
   *We will be creating total 7 JPanels.
   */
  
  MenuPanel main=new MenuPanel(0,0,0,0);           //Main panel
  main.setLayout(new BorderLayout(0,0));
  
   MenuPanel m=new MenuPanel(0,0,0,0);            //Sub-MainPanel where we will be adding buttons and Labels.
   m.setLayout(new BorderLayout(0,0));
   
    MenuPanel m1=new MenuPanel(30,0,0,0);          //Panel for welcome message and buttons
    m1.setLayout(new GridLayout(3,1,0,0));
   
     MenuPanel m11=new MenuPanel(0,0,0,0);        //Panel for welcome message and user-name labels
     m11.setLayout(new GridLayout(2,1,0,0));
    
     MenuPanel m12=new MenuPanel(40,60,20,60);   //panels for the two buttons i.e newRec and oldRec 
     m12.setLayout(new GridLayout(1,2,70,0));
     
     MenuPanel m15=new MenuPanel(20,250,40,250);   //panels for the two buttons i.e newRec and oldRec 
     m15.setLayout(new GridLayout(1,1,0,0));
   
     MenuPanel m13=new MenuPanel(0,0,0,0);        //Panel to add Top design at NORTH
     m13.setLayout(new GridLayout(1,1,0,0));
   
     MenuPanel m14=new MenuPanel(0,20,0,0);       //panel to add bottom design to SOUTH
     m14.setLayout(new GridLayout(1,1,0,0)); 
    
   MenuPanel m2=new MenuPanel(0,0,0,0);           //panel to add Spiral on the WEST
   m2.setLayout(new GridLayout(1,1,0,0));
   
   
   m11.add(title);
   m11.add(uname);
   
   m12.add(newRec);
   m12.add(oldRec);
   
   m15.add(myRec);
   
   m13.add(topDesign);
   m14.add(bottomDesign);
   
   m1.add(m11);
   m1.add(m12);
   m1.add(m15);
  
   m.add(m13,BorderLayout.NORTH);
   m.add(m1,BorderLayout.CENTER);
   m.add(m14,BorderLayout.SOUTH);
 

   m2.add(spiral);
   
   main.add(m);
   main.add(m2,BorderLayout.WEST);
   add(main);
   
   //registering for events
   newRec.addActionListener(this);
   oldRec.addActionListener(this);
 }


 @Override
 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource()==newRec)
  {
   newRecFrame nrf=new newRecFrame();
   nrf.setVisible(true);
  }
  else
  if(e.getSource()==oldRec)
  {
   HisaabFrame hf=new HisaabFrame();
   hf.setVisible(true);
   dispose();
  }
 }
}

class MenuPanel extends JPanel
{
 int top,left,bottom,right;                           //variables for insets
 
 MenuPanel(int top,int left,int bottom,int right)
 {
  this.top=top;
  this.left=left;
  this.bottom=bottom;
  this.right=right;
 }
 
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  //setBackground(new Color(235,235,234));
  setBackground(Color.ORANGE);
 }
 
 public Insets getInsets()
 {
  return new Insets(top,left,bottom,right);
 }
}

public class HisaabMenu
{
 public static void main(String arg[])
 {
  MenuFrame mf=new MenuFrame();                    //creating a frame object
  mf.setVisible(true);                             //making the frame visible on the screen
 }
}