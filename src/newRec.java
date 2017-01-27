package hisaab;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;

class newRecFrame extends JDialog implements ActionListener,FocusListener
{
 JRadioButton owe, lend;
 JLabel title, name, amt, hType, date, ddate, mno, email, address, remarks;
 JTextField tName, tAmt, tDate, tDdate, tMno, tEmail, tRemarks, tAddress;
 JButton submit, clear, close;
 
 SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");

 newRecFrame()
 {
  super(new HisaabFrame(), "New Hisaab", true);
  setSize(400, 500);
  setLocation(450, 50);
  setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(".//img//hisaab.png")));

  newRecPanel main = new newRecPanel(0, 10, 10, 10);
  main.setLayout(new GridLayout(11, 1, 0, 0));

  newRecPanel p1 = new newRecPanel(0, 10, 0, 10);
  p1.setLayout(new GridLayout(1, 1, 0, 0));

  newRecPanel p2 = new newRecPanel(10, 10, 0, 10);
  p2.setLayout(new GridLayout(1, 2, 0, 10));

  newRecPanel p3 = new newRecPanel(10, 10, 0, 10);
  p3.setLayout(new GridLayout(1, 2, 0, 10));

  newRecPanel p4 = new newRecPanel(10, 10, 0, 0);
  p4.setLayout(new GridLayout(1, 2, 0, 0));

  newRecPanel p41 = new newRecPanel(10, 10, 0, 0);
  p41.setLayout(new GridLayout(1, 2, 0, 0));

  newRecPanel p5 = new newRecPanel(10, 10, 0, 10);
  p5.setLayout(new GridLayout(1, 2, 0, 10));

  newRecPanel p6 = new newRecPanel(10, 10, 0, 10);
  p6.setLayout(new GridLayout(1, 2, 0, 10));

  newRecPanel p7 = new newRecPanel(10, 10, 0, 10);
  p7.setLayout(new GridLayout(1, 2, 0, 0));

  newRecPanel p8 = new newRecPanel(10, 10, 0, 10);
  p8.setLayout(new GridLayout(1, 2, 0, 0));

  newRecPanel p9 = new newRecPanel(10, 10, 0, 10);
  p9.setLayout(new GridLayout(1, 2, 0, 0));

  newRecPanel p10 = new newRecPanel(10, 10, 0, 10);
  p10.setLayout(new GridLayout(1, 2, 0, 0));

  newRecPanel p11 = new newRecPanel(10, 10, 0, 10);
  p11.setLayout(new GridLayout(1, 3, 10, 10));

  submit = new JButton("Submit");
  submit.setBackground(new Color(255, 102, 102));
  getRootPane().setDefaultButton(submit);

  clear = new JButton("Clear");
  clear.setBackground(new Color(255, 204, 255));

  close = new JButton("Close");
  close.setBackground(Color.red);

  title = new JLabel("Add New Hisaab");
  title.setFont(new Font("Georgia", Font.BOLD, 20));
  title.setForeground(Color.black);
  title.setHorizontalAlignment(JLabel.CENTER);

  name = new JLabel("Name");
  name.setFont(new Font("Georgia", Font.PLAIN, 18));
  name.setForeground(Color.black);

  tName = new JTextField();
  tName.setFont(new Font("aerial", Font.PLAIN, 16));

  amt = new JLabel("Amount");
  amt.setFont(new Font("Georgia", Font.PLAIN, 18));
  amt.setForeground(Color.black);

  tAmt = new JTextField();
  tAmt.setFont(new Font("aerial", Font.PLAIN, 16));

  hType = new JLabel("Hisaab Type");
  hType.setFont(new Font("Georgia", Font.PLAIN, 18));
  hType.setForeground(Color.black);

  date = new JLabel("Date");
  date.setFont(new Font("Georgia", Font.PLAIN, 18));
  date.setForeground(Color.black);

  tDate = new JTextField();
  tDate.setFont(new Font("aerial", Font.PLAIN, 16));
  tDate.setText(new java.sql.Date(new java.util.Date().getTime())+"");
  tDate.setForeground(Color.lightGray);

  ddate = new JLabel("Due Date");
  ddate.setFont(new Font("Georgia", Font.PLAIN, 18));
  ddate.setForeground(Color.black);

  tDdate = new JTextField();
  tDdate.setFont(new Font("aerial", Font.PLAIN, 16));
  tDdate.setForeground(Color.black);

  mno = new JLabel("Mob No.");
  mno.setFont(new Font("Georgia", Font.PLAIN, 18));
  mno.setForeground(Color.black);

  tMno = new JTextField();
  tMno.setFont(new Font("aerial", Font.PLAIN, 16));
  tMno.setText("optional");
  tMno.setForeground(Color.lightGray);

  email = new JLabel("Email");
  email.setFont(new Font("Georgia", Font.PLAIN, 18));
  email.setForeground(Color.black);

  tEmail = new JTextField();
  tEmail.setFont(new Font("aerial", Font.PLAIN, 16));
  tEmail.setForeground(Color.lightGray);
  tEmail.setText("optional");

  remarks = new JLabel("Remarks");
  remarks.setFont(new Font("Georgia", Font.PLAIN, 18));
  remarks.setForeground(Color.black);

  tRemarks = new JTextField();
  tRemarks.setFont(new Font("Georgia", Font.PLAIN, 14));
  tRemarks.setForeground(Color.lightGray);
  tRemarks.setText("optional");

  address = new JLabel("Address");
  address.setFont(new Font("Georgia", Font.PLAIN, 18));
  address.setForeground(Color.black);

  tAddress = new JTextField();
  tAddress.setFont(new Font("Georgia", Font.PLAIN, 14));
  tAddress.setForeground(Color.black);
  tAddress.setForeground(Color.lightGray);
  tAddress.setText("optional");

  ButtonGroup rad = new ButtonGroup();

  owe = new JRadioButton("Diya");
  owe.setFont(new Font("Georgia", Font.PLAIN, 14));
  owe.setBackground(Color.orange);
  owe.setSelected(true);

  lend = new JRadioButton("Liya");
  lend.setFont(new Font("Georgia", Font.PLAIN, 14));
  lend.setBackground(Color.orange);

  rad.add(owe);
  rad.add(lend);

  p1.add(title);

  p2.add(name);
  p2.add(tName);

  p3.add(amt);
  p3.add(tAmt);

  p4.add(hType);
  p4.add(p41);
  p41.add(owe);
  p41.add(lend);

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
  
  //event registrations

  submit.addActionListener(this);
  clear.addActionListener(this);
  close.addActionListener(this);
  
  tEmail.addFocusListener(this);
  tAddress.addFocusListener(this);
  tRemarks.addFocusListener(this);
  tMno.addFocusListener(this);
  tDate.addFocusListener(this);
 }

 public void actionPerformed(ActionEvent ae)
 {
  if (ae.getSource() == submit)
  {
   if (!tName.getText().equals("") && !tAmt.getText().equals("") && !LoginFrame.userName.equals(null))
   {
    try
    {
     setNullTexts();
     if (owe.isSelected())
     {
      Connect.insP.setString(1, LoginFrame.userName);
      Connect.insP.setString(2, tName.getText());
      Connect.insP.setString(3, tAmt.getText());
      Connect.insP.setString(6, (tMno.getText()!="")?tMno.getText():"0");
      Connect.insP.setString(7, tRemarks.getText());
      Connect.insP.setString(8, tEmail.getText());
      Connect.insP.setString(9, tAddress.getText());
      
      if(tDate.getText().equals(""))
      {
       tDate.setText(new java.sql.Date(new java.util.Date().getTime())+"");
      }
      Connect.insP.setString(4, tDate.getText());
      
      if(tDdate.getText().equals(""))
      {
       Connect.insP.setNull(5,java.sql.Types.DATE);
      }
      else
      {
       Connect.insP.setString(5, tDdate.getText());
      }

      int n = Connect.insP.executeUpdate();
      tDdate.setText("");
      if(n!=0)
      {
       JOptionPane.showMessageDialog(new HisaabFrame(),"Added Successfully!!","Success!!",JOptionPane.INFORMATION_MESSAGE);
      }
      else
      {
       JOptionPane.showMessageDialog(new HisaabFrame(),"Cannot add this record...","Failed",JOptionPane.ERROR_MESSAGE);
      }
     }
     else
     {
      Connect.insM.setString(1, LoginFrame.userName);
      Connect.insM.setString(2, tName.getText());
      Connect.insM.setString(3, tAmt.getText());
      Connect.insM.setString(6, tMno.getText());
      Connect.insM.setString(7, tRemarks.getText());
      Connect.insM.setString(8, tEmail.getText());
      Connect.insM.setString(9, tAddress.getText());
      
      if(tDate.getText().equals(""))
      {
       tDate.setText(new java.sql.Date(new java.util.Date().getTime())+"");
      }
      Connect.insM.setString(4, tDate.getText());
      
      if(tDdate.getText().equals(""))
      {
       Connect.insM.setNull(5,java.sql.Types.DATE);
      }
      else
      {
       Connect.insM.setString(5, tDdate.getText());
      }

      int n=Connect.insM.executeUpdate();
      
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
    /*
    catch (ParseException e)
    {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
    */
   }
   else
   {
    JOptionPane.showMessageDialog(new HisaabFrame(),"Name or Amount cannot be empty","Error!",JOptionPane.ERROR_MESSAGE);
   }
   setTextsBack();
  }
  else if (ae.getSource() == clear)
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
  else if (ae.getSource() == close)
  {
   dispose();
  }
 }

 @Override
 public void focusGained(FocusEvent e)
 {
  if(e.getSource()==tAddress)
  {
   tAddress.setText("");
   tAddress.setForeground(Color.black);
  }
  if(e.getSource()==tMno)
  {
   tMno.setText("");
   tMno.setForeground(Color.black);
  }
  if(e.getSource()==tRemarks)
  {
   tRemarks.setText("");
   tRemarks.setForeground(Color.black);
  }
  if(e.getSource()==tEmail)
  {
   tEmail.setText("");
   tEmail.setForeground(Color.black);
  }
  if(e.getSource()==tDate)
  {
   tDate.setForeground(Color.black);
  }
 }

 @Override
 public void focusLost(FocusEvent e)
 {
  if(e.getSource()==tAddress&& tAddress.getText().equals(""))
  {
   tAddress.setText("optional");
   tAddress.setForeground(Color.lightGray);
  }
  if(e.getSource()==tMno&&tMno.getText().equals(""))
  {
   tMno.setText("optional");
   tMno.setForeground(Color.lightGray);
  }
  if(e.getSource()==tRemarks&&tRemarks.getText().equals(""))
  {
   tRemarks.setText("optional");
   tRemarks.setForeground(Color.lightGray);
  }
  if(e.getSource()==tEmail&&tEmail.getText().equals(""))
  {
   tEmail.setText("optional");
   tEmail.setForeground(Color.lightGray);
  }
 }
 void setNullTexts()
 {
  if(tAddress.getText().equals("optional"))
  {
   tAddress.setText("");
  }
  if(tRemarks.getText().equals("optional"))
  {
   tRemarks.setText("");
  }
  if(tEmail.getText().equals("optional"))
  {
   tEmail.setText("");
  }
  if(tMno.getText().equals("optional"))
  {
   tMno.setText("");
  }
 }
 
 void setTextsBack()
 {
  if(tAddress.getText().equals(""))
  {
   tAddress.setText("optional");
  }
  if(tRemarks.getText().equals(""))
  {
   tRemarks.setText("optional");
  }
  if(tEmail.getText().equals(""))
  {
   tEmail.setText("optional");
  }
  if(tMno.getText().equals(""))
  {
   tMno.setText("optional");
  }
 }
}

class newRecPanel extends JPanel
{
 int top, left, bottom, right;

 newRecPanel(int top, int left, int bottom, int right)
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
  // setBackground(new Color(254,250,240));
 }

 public Insets getInsets()
 {
  return new Insets(top, left, bottom, right);
 }
}

public class newRec
{
 public static void main(String[] args)
 {
  newRecFrame nhf = new newRecFrame();
  nhf.setVisible(true);
 }
}
