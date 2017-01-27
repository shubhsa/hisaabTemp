package hisaab;

public class people
{
 String name,mno,date,ddate;//remarks
 int num;
 double amt;
 
 public people(int num,String name,double amt,String date,String ddate,String mno)
 {
  this.num=num;
  this.name=name;
  this.amt=amt;
  this.date=date;
  this.mno=mno;
  
  if(ddate==null)
   this.ddate="N/A";
  else
   this.ddate=ddate;
 }
 
 public String toString()
 {
  return String.format(" %-5d%-30s   Rs.%-14.0f %-17s %-17s %-15s",num,name,amt,date,ddate,mno);
 }
}