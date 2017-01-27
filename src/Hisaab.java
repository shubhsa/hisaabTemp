package hisaab;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class HisaabFrame extends JFrame implements ActionListener, ListSelectionListener, MouseListener,KeyListener
{
 JLabel hello, msg, appTitle, sno, name, amount, date, remarks, picLabel, dDate, mNo,tDate;
 Icon pic, edt, del,ad;
 JList lst;
 JScrollPane jsp;
 JTextField tdet[];
 JButton add,edit,delete,back,print;
 Vector<people> vct;
 String tagMessage;
 MenuBar mb;
 double tot;

 HisaabFrame()
 {
  super("Hisaab");
  //setSize(900, 600);
  setSize(1000, 600);
  setLocation(140, 40);
  setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/hisaab.png")));

  // setResizable(false);
   getAmt();
   
   SimpleDateFormat sdf=new SimpleDateFormat();
  
   appTitle = new JLabel("Welcome To Hisaab");
   appTitle.setFont(new Font("Times new Roman", Font.BOLD, 40));
   appTitle.setForeground(new Color(20, 102, 120));
   appTitle.setHorizontalAlignment(JLabel.CENTER);
   appTitle.setToolTipText("Click here for Menu");
   UIManager.put("ToolTip.background",Color.magenta);

   hello = new JLabel("Hello , Mr." + LoginFrame.userName);
   hello.setFont(new Font("Times new Roman", Font.PLAIN, 26));
   hello.setForeground(new Color(100, 0, 0));
   hello.setHorizontalAlignment(JLabel.CENTER);
   
   tDate = new JLabel(sdf.format((new java.util.Date().getTime())));
   tDate.setFont(new Font("Times new Roman", Font.PLAIN, 20));
   tDate.setForeground(new Color(100, 0, 0));
   tDate.setHorizontalAlignment(JLabel.CENTER);

   msg = new JLabel(tagMessage);
   msg.setFont(new Font("Georgia", Font.PLAIN, 18));
   msg.setForeground(Color.black);
   msg.setHorizontalAlignment(JLabel.CENTER);

   sno = new JLabel("S.No");
   sno.setFont(new Font("Georgia", Font.BOLD, 12));
   sno.setForeground(Color.black);

   name = new JLabel("Name");
   name.setFont(new Font("Georgia", Font.BOLD, 12));
   name.setForeground(Color.black);

   amount = new JLabel("Amount");
   amount.setFont(new Font("Georgia", Font.BOLD, 12));
   amount.setForeground(Color.black);

   remarks = new JLabel("Remarks");
   remarks.setFont(new Font("Georgia", Font.BOLD, 12));
   remarks.setForeground(Color.black);

   date = new JLabel("Date");
   date.setFont(new Font("Georgia", Font.BOLD, 12));
   date.setForeground(Color.black);

   dDate = new JLabel("Due Date");
   dDate.setFont(new Font("Georgia", Font.BOLD, 12));
   dDate.setForeground(Color.black);

   mNo = new JLabel("Mob. No.");
   mNo.setFont(new Font("Georgia", Font.BOLD, 12));
   mNo.setForeground(Color.black);
   
   back = new JButton("Add New Hisaab");
   ad = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/add.png")));
   back.setIcon(ad);
   
   add = new JButton("Add New Hisaab");
   ad = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/add.png")));
   add.setIcon(ad);
   add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

   edit = new JButton("Edit");
   edt = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/edit.png")));
   edit.setIcon(edt);
   edit.setEnabled(false);
   edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

   delete = new JButton("Delete");
   del = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/del.png")));
   delete.setIcon(del);
   delete.setEnabled(false);
   delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
   
   print = new JButton("Print Hisaab");
   print.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/print.png"))));
   print.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

   HisaabPanel p = new HisaabPanel(10, 10, 10, 10);
   p.setLayout(new BorderLayout(10, 10));
   p.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

    HisaabPanel p1 = new HisaabPanel(0, 0, 0, 10);
    p1.setLayout(new BorderLayout(10, 10));

    HisaabPanel p11 = new HisaabPanel(0,0, 0, 10);
    p11.setLayout(new BorderLayout( 0, 0));

   HisaabPanel p12 = new HisaabPanel(0, 0, 0, 0);
   p12.setLayout(new GridLayout(4, 1, 0, 0));

   HisaabPanel p2 = new HisaabPanel(0, 10, 0, 10);
   p2.setLayout(new BorderLayout(0, 0));

   HisaabPanel p21 = new HisaabPanel(0, 10, 0, 10);
   p21.setLayout(new BorderLayout(10, 0));

   HisaabPanel p22 = new HisaabPanel(0, 20, 0, 0);
   p22.setLayout(new GridLayout(1, 1, 60, 0)); 
  
   HisaabPanel p23 = new HisaabPanel(5, 0, 0, 0);
   p23.setLayout(new GridLayout(1, 4, 10, 0));

   HisaabPanel p24 = new HisaabPanel(0, 15, 0, 10);
   p24.setLayout(new BorderLayout(0, 0));
   
   HisaabPanel p25 = new HisaabPanel(0,0, 0, 100);  //layout for adding date etc
   p25.setLayout(new GridLayout(1, 4,90,0)); 
  
   try
   {
    vct = new Vector<people>();
    Connect.selp.setString(1,LoginFrame.userName);
    ResultSet rs = Connect.selp.executeQuery();

    while(rs.next())
    {
     vct.add(new people(rs.getInt(1), rs.getString(3), rs.getDouble(4), rs.getString(5),rs.getString(6),rs.getString(7)));
    }
   }
   catch (SQLException e)
   {
    e.getMessage();
   }
   
   lst = new JList();
   lst.setFont(new Font("lucida console", Font.PLAIN, 14));
   lst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   lst.setListData(vct);
   lst.setSelectionBackground(Color.red);
  
   if(vct.isEmpty())
   {
    print.setEnabled(false);
   }
   else
   {
    print.setEnabled(true);
   }
 
   jsp = new JScrollPane(lst);
   jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

   p.add(p1, BorderLayout.NORTH);
   p.add(p2, BorderLayout.CENTER);

   p1.add(p11, BorderLayout.WEST);
   p1.add(p12, BorderLayout.CENTER);
 
   p2.add(p24, BorderLayout.NORTH);//
   p2.add(p21, BorderLayout.CENTER);

   p21.add(jsp, BorderLayout.CENTER);
   p21.add(p23,BorderLayout.SOUTH);

  //p11.add(back,BorderLayout.SOUTH);     ///lets see what we can do abt it
 
   p12.add(appTitle);
   p12.add(hello);
   p12.add(tDate);
   p12.add(msg);

//  p22.add(sno);
   p22.add(name);
   
   p25.add(amount);
   p25.add(date);
   p25.add(dDate);
   p25.add(mNo);
 //  p22.add(remarks);

   p24.add(sno,BorderLayout.WEST);
  // p24.add(p23, BorderLayout.EAST);
   p24.add(p22, BorderLayout.CENTER);
   p24.add(p25,BorderLayout.EAST);
  
   p23.add(add);
   p23.add(edit);
   p23.add(delete);
   p23.add(print);
  
   add(p);

  //event registrations
  delete.addActionListener(this);
  add.addActionListener(this);
  edit.addActionListener(this);
  print.addActionListener(this);
  appTitle.addMouseListener(this);
  lst.addListSelectionListener(this);
  lst.addMouseListener(this);
  lst.addKeyListener(this);
  addWindowListener(new HisaabAdapter(this));
 }
 
 void fetchRecs()
 {
  try
  {
   vct = new Vector<people>();
   ResultSet rs = Connect.selp.executeQuery();

   while (rs.next())
   {
    vct.add(new people(rs.getInt(1), rs.getString(3), rs.getDouble(4), rs.getString(5),rs.getString(6),rs.getString(7)));//,rs.getString(8)
   }
   lst.setListData(vct);
  }
  catch (SQLException e)
  {
   e.getMessage();
  }
  notifyCheck();
 }
 
 void edit(int selected)
 {
  editRecFrame erf=new editRecFrame();
  erf.setN(selected);
  
  try
  {
   Connect.showRec.setInt(1,selected);
   ResultSet rs=Connect.showRec.executeQuery();
   
   rs.next();
   
   erf.tName.setText(rs.getString(3));
   erf.tAmt.setText(rs.getString(4));
   erf.tDate.setText(rs.getString(5));
   erf.tDdate.setText(rs.getString(6));
   erf.tMno.setText(rs.getString(7));
   erf.tRemarks.setText(rs.getString(8));
   erf.tEmail.setText(rs.getString(9));
   erf.tAddress.setText(rs.getString(10));
  }
  catch (SQLException e)
  {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  erf.setVisible(true);
 }
 
 void notifyCheck()
 {
  try
  {
   ResultSet rs=Connect.chkDate.executeQuery();
   
   while(rs.next())
   {
    if(rs.getDate(1)==null)
     continue;
    
    if(rs.getString(1).equals(new java.sql.Date(new java.util.Date().getTime()).toString()))
    {
     Connect.dateRec.setString(1,rs.getString(1));
     ResultSet rst=Connect.dateRec.executeQuery();
     while(rst.next())
     {
      System.out.printf(" %-5d%-30s   Rs.%-14.0f %-17s %-17s %-15s",rst.getInt(1), rst.getString(3), rst.getDouble(4), rst.getString(5),rst.getString(6),rst.getString(7));
     }
    }
   }
  }
  catch (SQLException e)
  {
   e.printStackTrace();
  }
 }
 
 String getAmt()
 {
  try
  {
   Connect.getTot.setString(1,LoginFrame.userName);
   ResultSet rs=Connect.getTot.executeQuery();
   rs.next();
   tot=rs.getDouble(1);
   
   if(tot==0)
    tagMessage="No one owes you anything , are you that poor?";
   else
    tagMessage="These all morons owe you a sum of : Rs. " + String.format("%1.0f",tot);
   
   }
   catch (SQLException e)
   {
    e.printStackTrace();
   }
  return tagMessage;
 }
 
 void delete(int selected)
 {
  try
  {
   Connect.del.setInt(1,selected);
   Connect.del.executeUpdate();
   
   ResultSet rs=Connect.getMax.executeQuery();
   rs.next();
   int max=rs.getInt(1);
   max=max+1;
   System.out.println(max);
   Connect.setNum.setInt(1,max);
   Connect.setNum.setInt(2, selected);
   Connect.setNum.executeUpdate();
   
   rs=Connect.st.executeQuery("SELECT count(*) FROM (SELECT 1 FROM people LIMIT 1) as cnt");
   rs.next();
   if(rs.getInt(1)==0)
   {
    System.out.println("in");
    Connect.st.executeUpdate("truncate people");
   }
   vct.remove(lst.getSelectedValue());
   lst.setListData(vct);
   msg.setText(getAmt());
  }
  catch (SQLException e)
  {
   e.getMessage();
  }
 }

 public void actionPerformed(ActionEvent ae)
 {
  if (ae.getSource() == print)
  {
   new CreateExlFile();
  }
  else
  if (ae.getSource() == add)
  {
   newRecFrame nrf=new newRecFrame();
   nrf.setVisible(true);
   vct.removeAll(vct);
   fetchRecs();
   msg.setText(getAmt());
  }
  else
  if (ae.getSource() == edit)
  {
   String s = lst.getSelectedValue().toString();
   int n=Integer.parseInt(s.substring(0,4).trim());
   edit(n);
  }
  else
  if (ae.getSource()==delete)
  {
   int opt=JOptionPane.showConfirmDialog(this, "Do you really want to delete this record?","Confirm Delete!!",JOptionPane.CANCEL_OPTION,JOptionPane.OK_OPTION);
   if(opt==2)
   {
    return;
   }
   else
   if(opt==0)
   {
    String s = lst.getSelectedValue().toString();
    int n=Integer.parseInt(s.substring(0, 3).trim());
    delete(n);
   }
  }
 }

 @Override
 public void valueChanged(ListSelectionEvent lse)
 {  
  if(!lst.isSelectionEmpty())
  {
   edit.setEnabled(true);
   delete.setEnabled(true);
  }
  else
  {
   edit.setEnabled(false);
   delete.setEnabled(false);
  }
 }

 public void mouseClicked(MouseEvent me)
 {
  if(me.getSource()==lst&&!lst.isSelectionEmpty())
  {
   if(me.getClickCount()==2)
   {
    String s = lst.getSelectedValue().toString();
    int n=Integer.parseInt(s.substring(0,4).trim());
    edit(n);
   }
  }
  if(me.getSource()==appTitle)
  {
   MenuFrame m=new MenuFrame();
   m.setVisible(true);
   dispose();
  }
 }

 @Override
 public void mouseEntered(MouseEvent e)
 {
  if(e.getSource()==lst&&!lst.isSelectionEmpty())
  {
   setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  }
 }
 public void mouseExited(MouseEvent e)
 {
  if(e.getSource()==lst)
  {
   setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
  }
 }
 public void mousePressed(MouseEvent e){}
 public void mouseReleased(MouseEvent e){}

 @Override
 public void keyPressed(KeyEvent ke)
 {
  if((ke.getKeyCode() == KeyEvent.VK_F) && ((ke.getModifiers() & KeyEvent.CTRL_MASK) != 0))
  {
   int i=0,j=0;
 //  Vector<people> svtc=new Vector(); 
   
   lst.clearSelection();
   lst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

   String s=JOptionPane.showInputDialog(this,"Enter Name to search : ","Search",JOptionPane.QUESTION_MESSAGE);
   
   if(s==null)return;
   
   String arg[]=new String[vct.size()];
   
   for(people p : vct)
   {
    arg[i]=p.toString();
    if(arg[i].contains(s))
    {
     j++;
    }
    i++;
   }
   int arr[]=new int[j];
   
   
   for(j=0,i=0;j<arg.length;j++)
   {
    if(arg[j].contains(s))
    {
     arr[i++]=j;
    }
   }
  /* 
   for(i=0;i<arr.length;i++)
   {
    svtc.add(vct.get(arr[i]));
   }
   */
   lst.setSelectedIndices(arr);
   //lst.setListData(svtc);
   lst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   //new searchFrame().setVisible(true);
  }
 }
 public void keyReleased(KeyEvent arg0){}

 @Override
 public void keyTyped(KeyEvent ke)
 {
  if(ke.getKeyChar()==127 &&!lst.isSelectionEmpty())
  {
   int opt=JOptionPane.showConfirmDialog(this, "Do you really want to delete this record?","Confirm Delete!!",JOptionPane.CANCEL_OPTION,JOptionPane.OK_OPTION);
   if(opt==2)
   {
    return;
   }
   else
   if(opt==0)
   {
    String s = lst.getSelectedValue().toString();
    int n=Integer.parseInt(s.substring(0, 3).trim());
    System.out.println(n);
    delete(n);
   }
  }
  if(ke.getKeyChar()==10)
  {
   String s = lst.getSelectedValue().toString();
   int n=Integer.parseInt(s.substring(0,4).trim());
   edit(n);
  }
 }
}

class HisaabAdapter extends WindowAdapter
{
 HisaabFrame hf;

 public HisaabAdapter(HisaabFrame hf)
 {
  this.hf = hf;
 }

 public void windowClosing(WindowEvent we)
 {
  hf.dispose();
  LoginFrame f = new LoginFrame();
  f.setVisible(true);
 // System.exit(0);
 }
}

class HisaabPanel extends JPanel
{
 int top, left, bottom, right;

 HisaabPanel(int top, int left, int bottom, int right)
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

public class Hisaab
{
 public static void main(String[] args)
 {
  new Connect();
  HisaabFrame hf = new HisaabFrame();
  hf.setVisible(true);
  hf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 }
}