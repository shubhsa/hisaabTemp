package hisaab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;

class LoginFrame extends JFrame implements ActionListener
{
 private static final long serialVersionUID = 1L;

 JLabel title, name, pass;
 JTextField uname;
 JPasswordField upass;
 JButton submit, clear, signup, close;
 static String userName;
 static int logcnt;

 byte[] skey = new byte[1000];
 String skeyString;
 static byte[] raw;
 byte[] ebyte, dbyte, ibyte;
 String encrypted;

 LoginFrame()
 {
  setTitle("Login");
  setSize(400, 250);
  setLocation(400, 200);
  setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(".//img//hisaab.png")));

  title = new JLabel("Welcome To Hisaab");
  title.setFont(new Font("georgia", Font.PLAIN, 26));
  title.setForeground(Color.white);
  title.setHorizontalAlignment(JLabel.CENTER);

  name = new JLabel("Username  :");
  name.setFont(new Font("lucida console", Font.PLAIN, 18));
  name.setForeground(Color.white);

  uname = new JTextField();
  uname.setFont(new Font("lucida console", Font.PLAIN, 18));

  pass = new JLabel("Passsword :");
  pass.setFont(new Font("lucida console", Font.PLAIN, 18));
  pass.setForeground(Color.white);

  upass = new JPasswordField();
  upass.setFont(new Font("lucida console", Font.PLAIN, 18));

  submit = new JButton("Submit");
  submit.setBackground(new Color(255, 102, 102));

  clear = new JButton("Clear");
  clear.setBackground(new Color(255, 204, 255));

  signup = new JButton("SignUp");
  signup.setBackground(new Color(0, 204, 0));

  close = new JButton("Close");
  close.setBackground(Color.red);

  // Main Panel p
  LoginPanel p = new LoginPanel(10, 10, 10, 10);
  p.setLayout(new GridLayout(4, 2, 10, 10));
  // main panel p ends

  LoginPanel p1 = new LoginPanel(10, 1, 1, 1);
  p1.setLayout(new BorderLayout(10, 10));

  LoginPanel p2 = new LoginPanel(10, 1, 1, 1);
  p2.setLayout(new BorderLayout(10, 10));

  LoginPanel p3 = new LoginPanel(10, 10, 1, 1);
  p3.setLayout(new GridLayout(1, 4, 10, 10));

  getRootPane().setDefaultButton(submit);

  p1.add(name, BorderLayout.WEST);
  p1.add(uname, BorderLayout.CENTER);

  p2.add(pass, BorderLayout.WEST);
  p2.add(upass, BorderLayout.CENTER);

  p3.add(submit);
  p3.add(clear);
  p3.add(signup);
  p3.add(close);

  p.add(title);
  p.add(p1);
  p.add(p2);
  p.add(p3);
  add(p);

  submit.addActionListener(this);
  clear.addActionListener(this);
  close.addActionListener(this);
  signup.addActionListener(this);
 }

 @SuppressWarnings("deprecation")
 public void actionPerformed(ActionEvent ae)
 {
  if (ae.getSource() == submit)
  {
   logcnt++;
   if (logcnt == 5)
   {
    JOptionPane.showMessageDialog(this, "Too Many Wrong Attempts , Hisaab is Exiting");
    System.exit(1);
   }
   try
   {
    boolean ok = false;
    ResultSet rs = Connect.selLog.executeQuery();
    while (rs.next())
    {
     try
     {
      ibyte = new String(upass.getPassword()).getBytes();
      ebyte = encrypt(rs.getString(3).getBytes(), ibyte);
      encrypted = new String(ebyte);
     }
     catch (BadPaddingException e)
     {
      System.out.println("Wrong key");
     }
     if (uname.getText().equals(rs.getString(1)) && encrypted.equals(rs.getString(2)))
     {
      ok = true;
      userName = uname.getText();
      userName = userName.substring(0, 1).toUpperCase() + userName.substring(1);
      break;
     }
    }
    if (ok)
    {
     dispose();
     // HisaabFrame hf=new HisaabFrame();
     // hf.setVisible(true);
     MenuFrame mf = new MenuFrame();
     mf.setVisible(true);
    }
    else
    {
     JOptionPane.showMessageDialog(this, "Invalid login-id or password");
     uname.requestFocus();
    }
   }
   catch (SQLException e)
   {
    System.err.print("SQL ALERT[login] - " + e.getMessage());
   }
   catch (Exception e)
   {
    // TODO Auto-generated catch block
    e.printStackTrace();
    System.out.println(e.getMessage());
   }
  }
  else if (ae.getSource() == clear)
  {
   uname.setText("");
   upass.setText("");
   uname.requestFocus();
  }
  else if (ae.getSource() == signup)
  {
   generateSymmetricKey();
   try
   {
    if (uname.getText().equals("") && upass.getText().equals(""))
    {
     JOptionPane.showMessageDialog(this, "Username or password cant be empty");
    }
    else
    {
     Connect.addUser.setString(1, uname.getText());

     ibyte = new String(upass.getPassword()).getBytes();
     ebyte = encrypt(raw, ibyte);

     Connect.addUser.setString(2, new String(ebyte));
     Connect.addUser.setString(3,new String(raw));
     Connect.addUser.executeUpdate();
     JOptionPane.showMessageDialog(this, "Account Created Successfully!!");
    }
   }
   catch (SQLException e)
   {
    System.err.println("SQL ALERT[SIGN-UP]" + e.getMessage());
   }
   catch (Exception e)
   {
    // TODO Auto-generated catch block
    e.printStackTrace();
    System.out.println(e.getMessage());
   }
  }

  if (ae.getSource() == close)
   System.exit(1);
 }

 void generateSymmetricKey()
 {
  try
  {
   Random r = new Random();
   int num = r.nextInt(10000);
   String knum = String.valueOf(num);
   byte[] knumb = knum.getBytes();
   skey = getRawKey(knumb);
   skeyString = new String(skey);
  }
  catch (Exception e)
  {
   e.printStackTrace();
   System.out.println(e.getMessage());
  }
 }

 private static byte[] getRawKey(byte[] seed) throws Exception
 {
  KeyGenerator kgen = KeyGenerator.getInstance("DES");
  SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
  sr.setSeed(seed);
  kgen.init(56, sr);
  SecretKey skey = kgen.generateKey();
  raw = skey.getEncoded();
  return raw;
 }

 private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception
 {
  SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
  Cipher cipher = Cipher.getInstance("DES");
  cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
  byte[] encrypted = cipher.doFinal(clear);
  return encrypted;
 }
}

class LoginPanel extends JPanel
{
 private static final long serialVersionUID = 1L;

 int top, left, bottom, right;

 LoginPanel(int top, int left, int bottom, int right)
 {
  this.top = top;
  this.left = left;
  this.bottom = bottom;
  this.right = right;
 }

 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
  setBackground(new Color(100, 20, 22));
 }

 public Insets getInsets()
 {
  return new Insets(top, left, bottom, right);
 }
}

public class Login
{
 public static void main(String[] args)
 {
  // TODO Auto-generated method stub
  new Connect();
  LoginFrame lf = new LoginFrame();
  lf.setVisible(true);
  lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}