package hisaab;

//Find jar from here "http://poi.apache.org/download.html"
import  java.io.*;
import java.sql.*;

import javax.swing.*;

import  org.apache.poi.hssf.usermodel.*;

public class CreateExlFile{
       JFileChooser jfc;
      CreateExlFile() {
      try {
          jfc=new JFileChooser(new File("E:/"));
          jfc.setDialogTitle("Save file as");
          
          int opt=jfc.showSaveDialog(new HisaabFrame());
          
          if(opt==JFileChooser.CANCEL_OPTION)
            return;
          
          File f=jfc.getSelectedFile();
      //    String filename = "E:/NewExcelFile.xls" ;
          HSSFWorkbook workbook = new HSSFWorkbook();
          HSSFSheet sheet = workbook.createSheet("FirstSheet");  

          HSSFRow rowhead = sheet.createRow((short)0);
          rowhead.createCell(0).setCellValue("No.");
          rowhead.createCell(1).setCellValue("Name");
          rowhead.createCell(2).setCellValue("Amount");
          rowhead.createCell(3).setCellValue("Date");
          rowhead.createCell(4).setCellValue("Due Date");
          rowhead.createCell(5).setCellValue("Mob No.");
          rowhead.createCell(6).setCellValue("Email");
          rowhead.createCell(7).setCellValue("Remarks");
          rowhead.createCell(8).setCellValue("Address");
          
          Connect.selp.setString(1,LoginFrame.userName);
          ResultSet rs=Connect.selp.executeQuery();
          
          for(int i=1;rs.next();i++)
          {
           HSSFRow row = sheet.createRow((short)i);
           row.createCell(0).setCellValue(i);
           row.createCell(1).setCellValue(rs.getString(3));
           row.createCell(2).setCellValue(rs.getString(4));
           row.createCell(3).setCellValue(rs.getString(5));
           row.createCell(4).setCellValue(rs.getString(6));
           row.createCell(5).setCellValue(rs.getString(7));
           row.createCell(6).setCellValue(rs.getString(9));
           row.createCell(7).setCellValue(rs.getString(8));
           row.createCell(8).setCellValue(rs.getString(10));
          }

          


          FileOutputStream fileOut = new FileOutputStream(f+".xls");
          workbook.write(fileOut);
          fileOut.close();
          System.out.println("Your excel file has been generated!");
          workbook.close();
     
      } 
      catch(SQLException e) 
      {
       System.out.println("SQL ALERT excel - "+e.getMessage());
      }
      catch(IOException e) 
      {
       System.out.println("Creating excel - "+e.getMessage());
      }
  }
}