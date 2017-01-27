package hisaab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect
{
 static PreparedStatement selp,insP,insM,del,selLog,addUser,getTot,getMax,setNum,showRec,updPRec,updMRec,chkDate,dateRec;
 static Statement st;
 public Connect()
 {
  try
  {
   Class.forName("com.mysql.jdbc.Driver");
   
   Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hisaab","root","786420");
  
   st=cn.createStatement();
   st.executeUpdate("create database if not exists hisaab");
 
 //  cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"hisaab","root","786420");
   
 //  st.execute("use hisaab");
  // st.execute("create table if not exists people(num INT NOT NULL AUTO_INCREMENT ,uname VARCHAR(45),name VARCHAR(45),amt INT,date DATE,ddate DATETIME,mno INT NULL ,remarks LONGTEXT,img VARCHAR(45),PRIMARY KEY (num))");
   //st.execute("Create table if not exists login(num int not null auto_increment,uname varchar(20),upass varchar(20),primary key(num))");
   
   selp=cn.prepareStatement("select * from people where uname=?");
   insP=cn.prepareStatement("insert into people(uname,name,amt,date,ddate,mno,remarks,email,address)values(?,?,?,?,?,?,?,?,?)");
   insM=cn.prepareStatement("insert into me(uname,name,amt,date,ddate,mno,remarks,email,address)values(?,?,?,?,?,?,?,?,?)");
   del=cn.prepareStatement("delete from people where num=?");
   selLog=cn.prepareStatement("select * from login");
   addUser=cn.prepareStatement("insert into login values(?,?,?)");
   getTot=cn.prepareStatement("select sum(amt) from people where uname=?");
   getMax=cn.prepareStatement("select max(num) from people");
   setNum=cn.prepareStatement("update people set num=num-1 where num<? and num>?");
   showRec=cn.prepareStatement("select * from people where num=?");
   updPRec=cn.prepareStatement("UPDATE people SET name=?,amt=?,date=?,ddate=?,mno=?,remarks=?,email=?,address=? WHERE num=? and uname=?");
   updMRec=cn.prepareStatement("UPDATE people SET name=?,amt=?,date=?,ddate=?,mno=?,remarks=?,email=?,address=? WHERE num=? and uname=?");
   chkDate=cn.prepareStatement("select ddate from people");
   dateRec=cn.prepareStatement("select * from people where ddate=?");
  }
  catch(SQLException e)
  {
   System.err.println("SQL Alert[1]"+e.getMessage()); 
  }
  catch(ClassNotFoundException e)
  {
   System.err.println("Driver not found - "+e.getMessage());
  }
 }
}
