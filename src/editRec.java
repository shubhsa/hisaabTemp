package hisaab;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class editRecFrame extends JDialog implements ActionListener
{
 JRadioButton owe,lend;
 JLabel title,name,amt,hType,date,ddate,mno,email,address,remarks;
 JTextField tName, tAmt, tDate, tDdate, tMno, tEmail, tRemarks, tAddress;
 JButton submit,clear,close;
 int n;
 
 void setN(int selected)
 {
  this.n=selected;
 }
 
 editRecFrame()
 {
  super(new HisaabFrame(),"View Hisaab",true);
  setSize(400,500);
  setLocation(450,50);
  
  editRecPanel main=new editRecPanel(0,10,10,10);
  main.setLayout(new GridLayout(11,1,0,0));
   
   editRecPanel p1=new editRecPanel(0,10,0,10);
   p1.setLayout(new GridLayout(1,1,0,0));
   
   editRecPanel p2=new editRecPanel(10,10,0,10);
   p2.setLayout(new GridLayout(1,2,0,10));
   
   editRecPanel p3=new editRecPanel(10,10,0,10);
   p3.setLayout(new GridLayout(1,2,0,10));
   
   editRecPanel p4=new editRecPanel(10,10,0,0);
   p4.setLayout(new GridLayout(1,2,0,0));
    
    editRecPanel p41=new editRecPanel(10,10,0,0);
    p41.setLayout(new GridLayout(1,2,0,0));
    
   editRecPanel p5=new editRecPanel(10,10,0,10);
   p5.setLayout(new GridLayout(1,2,0,10));
   
   editRecPanel p6=new editRecPanel(10,10,0,10);
   p6.setLayout(new GridLayout(1,2,0,10));
   
   editRecPanel p7=new editRecPanel(10,10,0,10);
   p7.setLayout(new GridLayout(1,2,0,0));
   
   editRecPanel p8=new editRecPanel(10,10,0,10);
   p8.setLayout(new GridLayout(1,2,0,0));
   
   editRecPanel p9=new editRecPanel(10,10,0,10);
   p9.setLayout(new GridLayout(1,2,0,0));
   
   editRecPanel p10=new editRecPanel(10,10,0,10);
   p10.setLayout(new GridLayout(1,2,0,0));
   
   editRecPanel p11=new editRecPanel(10,10,0,10);
   p11.setLayout(new GridLayout(1,3,10,10));
   
   
  submit=new JButton("Submit");
  submit.setBackground(new Color(255, 102, 102));
  getRootPane().setDefaultButton(submit); 
  
  clear=new JButton("Clear");
  clear.setBackground(new Color(255, 204, 255));

  close=new JButton("Close");
  close.setBackground(Color.red);
   
  
  title=new JLabel("Edit Hisaab");
  title.setFont(new Font("Georgia",Font.BOLD,20));
  title.setForeground(Color.black);
  title.setHorizontalAlignment(JLabel.CENTER);
  
  name=new JLabel("Name");
  name.setFont(new Font("Georgia",Font.PLAIN,18));
  name.setForeground(Color.black);
  
  tName=new JTextField();
  tName.setFont(new Font("aerial",Font.PLAIN,16));
  
  amt=new JLabel("Amount");
  amt.setFont(new Font("Georgia",Font.PLAIN,18));
  amt.setForeground(Color.black);
  
  tAmt=new JTextField();
  tAmt.setFont(new Font("aerial",Font.PLAIN,16));
  
  hType=new JLabel("Hisaab Type");
  hType.setFont(new Font("Georgia",Font.PLAIN,18));
  hType.setForeground(Color.black);
  
  date=new JLabel("Date");
  date.setFont(new Font("Georgia",Font.PLAIN,18));
  date.setForeground(Color.black);
  
  tDate=new JTextField();
  tDate.setFont(new Font("aerial",Font.PLAIN,16));
  
  ddate=new JLabel("Due Date");
  ddate.setFont(new Font("Georgia",Font.PLAIN,18));
  ddate.setForeground(Color.black);
  
  tDdate=new JTextField();
  tDdate.setFont(new Font("aerial",Font.PLAIN,16));
  
  mno=new JLabel("Mob No.");
  mno.setFont(new Font("Georgia",Font.PLAIN,18));
  mno.setForeground(Color.black);
  
  tMno=new JTextField();
  tMno.setFont(new Font("aerial",Font.PLAIN,16));
  
  email=new JLabel("Email");
  email.setFont(new Font("Georgia",Font.PLAIN,18));
  email.setForeground(Color.black);
  
  tEmail=new JTextField();
  tEmail.setFont(new Font("aerial",Font.PLAIN,16));
  
  remarks = new JLabel("Remarks");
  remarks.setFont(new Font("Georgia", Font.PLAIN, 18));
  remarks.setForeground(Color.black);

  tRemarks = new JTextField();
  tRemarks.setFont(new Font("Georgia", Font.PLAIN, 14));
  tRemarks.setForeground(Color.black);
  tRemarks.setAutoscrolls(true);

  address = new JLabel("Address");
  address.setFont(new Font("Georgia", Font.PLAIN, 18));
  address.setForeground(Color.black);

  tAddress = new JTextField();
  tAddress.setFont(new Font("Georgia", Font.PLAIN, 14));
  tAddress.setForeground(Color.black);
  
  
  ButtonGroup rad=new ButtonGroup();
  
  owe=new JRadioButton("Liya");
  owe.setFont(new Font("Georgia",Font.PLAIN,14));
  owe.setBackground(Color.orange);
  
  lend=new JRadioButton("Diya");
  lend.setFont(new Font("Georgia",Font.PLAIN,14));
  lend.setBackground(Color.orange);
  lend.setSelected(true);
  
  rad.add(owe);
  rad.add(lend);
  
  p1.add(title);
  
  p2.add(name);
  p2.add(tName);
  
  p3.add(amt);
  p3.add(tAmt);
 
  p4.add(hType);
  p4.add(p41);
   p41.add(lend);
   p41.add(owe);
  
  p5.add(date);
  p5.add(tDate);
  
  p6.add(ddate);
  p6.add(tDdate);
  
  p7.add(mno);
  p7.add(tMno);
  
  p8.add(email);
  p8.add(tEmail);
  
  p9.add(address);
  p9.add(tAddress);
  
  p10.add(remarks);
  p10.add(tRemarks);
  
  p11.add(submit);
  p11.add(clear);
  p11.add(close);
  

  main.add(p1);
  main.add(p2);
  main.add(p3);
  main.add(p4);
  main.add(p5);
  main.add(p6);
  main.add(p7);
  main.add(p8);
  main.add(p9);
  main.add(p10);
  main.add(p11);
  add(main);
  
  
  submit.addActionListener(this);
  clear.addActionListener(this);
  close.addActionListener(this);
 }
 
 
 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==submit)
  {
   if (!tName.getText().equals("") && !tAmt.getText().equals("") && !LoginFrame.userName.equals(null))
   {
    try
    {
     if (owe.isSelected())
     {
      Connect.updPRec.setString(1, tName.getText());
      Connect.updPRec.setString(2, tAmt.getText());
      Connect.updPRec.setString(3, tDate.getText());
      Connect.updPRec.setString(4, tDdate.getText());
      Connect.updPRec.setString(5, tMno.getText());
      Connect.updPRec.setString(6, tRemarks.getText());
      Connect.updPRec.setString(7, tEmail.getText());
      Connect.updPRec.setString(8, tAddress.getText());
      Connect.updPRec.setInt(9,n);
      Connect.updPRec.setString(10, LoginFrame.userName);

      int n = Connect.updPRec.executeUpdate();
      if(n!=0)
      {
       JOptionPane.showMessageDialog(new HisaabFrame(),"Updated Successfully!!","Success!!",JOptionPane.INFORMATION_MESSAGE);
      }
      else
      {
       JOptionPane.showMessageDialog(new HisaabFrame(),"Cannot add this record...","Failed",JOptionPane.ERROR_MESSAGE);
      }
     }
     else
     {
      Connect.updMRec.setString(1, tName.getText());
      Connect.updMRec.setString(2, tAmt.getText());
      Connect.updMRec.setString(3, tDate.getText());
      Connect.updMRec.setString(4, tDdate.getText());
      Connect.updMRec.setString(5, tMno.getText());
      Connect.updMRec.setString(6, tRemarks.getText());
      Connect.updMRec.setString(7, tEmail.getText());
      Connect.updMRec.setString(8, tAddress.getText());
      Connect.updMRec.setInt(9,n);
      Connect.updMRec.setString(10, LoginFrame.userName);

      int n=Connect.updMRec.executeUpdate();
      
      if(n!=0)
      {
       JOptionPane.showMessageDialog(new HisaabFrame(),"Added Successfully!!","Success!!",JOptionPane.INFORMATION_MESSAGE);
      }
      else
      {
       JOptionPane.showMessageDialog(new HisaabFrame(),"Cannot add this record...","Failed",JOptionPane.ERROR_MESSAGE);
      }
     }
    }
    catch (SQLException e)
    {
     // TODO Auto-generated catch block
     System.out.print("SQL Alert[insert into me]-" + e.getMessage());
    }
   }
   else
   {
    JOptionPane.showMessageDialog(new HisaabFrame(),"Name or Amount cannot be empty","Error!",JOptionPane.ERROR_MESSAGE);
   } 
  }
  else
  if(ae.getSource()==clear)
  {
   tName.setText("");
   tAmt.setText("");
   tMno.setText("");
   tDate.setText("");
   tDdate.setText("");
   tEmail.setText("");
   tRemarks.setText("");
   tAddress.setText("");
   tName.requestFocus();
  }
  else
  if(ae.getSource()==close)
  {
   dispose();
  }
 }
}


class editRecPanel extends JPanel
{
 int top, left, bottom, right;

 editRecPanel(int top, int left, int bottom, int right)
 {
  this.top = top;
  this.left = left;
  this.bottom = bottom;
  this.right = right;
 }

 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  setBackground(Color.ORANGE);
 }

 public Insets getInsets()
 {
  return new Insets(top, left, bottom, right);
 }
}


public class editRec
{

 public editRec()
 {
  // TODO Auto-generated constructor stub
 }

 public static void main(String[] args)
 {
  editRecFrame erf=new editRecFrame();
  erf.setVisible(true);

 }

}
