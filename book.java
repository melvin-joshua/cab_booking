package com.revature.ola;

import java.util.Scanner;
import java.sql.*;
public class book
{
    public Connection getconn()
    {
        Connection con = null;
        try
        {
            String url= "jdbc:mysql://localhost:3306/revature";
            String usernm="root";
            String pass="Melvin@123";
            con = DriverManager.getConnection(url,usernm,pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }


    Scanner sc1 = new Scanner(System.in);

    public void adm() throws SQLException
    {
        System.out.println("You have Choosen the 1st Option ");
       

        boolean flag = true;
        do
        {

           System.out.println("Enter Username");
           String username = sc1.next();

           System.out.println("Enter password");
           String password = sc1.next();

           Connection con =getconn();
           Statement stmt= con.createStatement();
           ResultSet rs=stmt.executeQuery("select username,password from adm");




           if (rs.next()) {

               if (rs.getString(1).equals(username) && rs.getString(2).equals(password))
               {
                 System.out.println("*********Your Authentication Was Successfull********");
                 flag = false;
             }

             else  
             {
                 System.out.println("######  Access Denied | Access Denied ######");
                 System.out.println("%%%%%%%%% Please Enter Correct Details %%%%%%%%%%%");
             }
         }

     }
     while(flag);
 }



 public void CheckYourBookings() throws SQLException
 {
    boolean flag1 =true;

    System.out.println("**********ThankYou For Choosing the 2nd Option************");
    do
    {
        System.out.println("Enter Username");
        String username = sc1.next();

        System.out.println("Enter password");
        String password = sc1.next();

        Connection con =getconn();
        Statement stmt= con.createStatement();
        ResultSet rs=stmt.executeQuery("select username,password from usr");




        if (rs.next()) {

           if (rs.getString(1).equals(username) && rs.getString(2).equals(password))
           {
             System.out.println("*********Your Authentication Was Successfull********");
             flag1 = false;
            }

         else  
         {
             System.out.println("######  Access Denied | Access Denied ######");
             System.out.println("%%%%%%%%% Please Enter Correct Details %%%%%%%%%%%");
         }
     }
 }while(flag1);        


 do
 {
   System.out.println("press 1 if your the ola passenger");
   System.out.println("press 2 if your the uber passenger");
   System.out.println("press 3 if your the rapido passenger");
   System.out.println("press 4 to EXIT");


   int v = sc1.nextInt();


   Connection con = getconn();
   Statement stmt = con.createStatement();

   switch(v)
   {
   case 1:
    System.out.println("---Enter Your Aadharid---");
    int aa = sc1.nextInt();
    ResultSet rs1 = stmt.executeQuery("select * from ola where aadharid="+aa);
    while(rs1.next())
    {
      System.out.println(rs1.getString(1)+":"+rs1.getString(2)+":"+rs1.getString(3)+":"+rs1.getString(4));

  }flag1= false;
  break;
case 2:
   System.out.println("---Enter Your Aadharid---");
   int aa1 = sc1.nextInt();
   ResultSet rs2 = stmt.executeQuery("select * from uber where aadharid="+aa1);
   while(rs2.next())
   {
      System.out.println(rs2.getString(1)+":"+rs2.getString(2)+":"+rs2.getString(3)+":"+rs2.getString(4));

  }flag1= false;
  break;
case 3:
   System.out.println("---Enter Your Aadharid---");
   int aa2 = sc1.nextInt();
   ResultSet rs3 = stmt.executeQuery("select * from rapido where aadharid="+aa2);
   while(rs3.next())
   {
      System.out.println(rs3.getString(1)+":"+rs3.getString(2)+":"+rs3.getString(3)+":"+rs3.getString(4));

  }
  flag1= false;
  break;
case 4:
    System.exit(0);
default : System.out.println("You Have Entered the Wromg Number");
   System.out.println("@@@@@@@@ Please Choose Under the OPtions.ThankYou @@@@@@@@@@@");
   break;

}


}while(flag1);
}



public void ola() throws SQLException
{
   
    System.out.println("******THANKS FOR CHOOSING OLA********");
    Connection con = getconn();
    String s1 = "insert into ola(name,aadharid,source,destination) values(?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(s1);

    System.out.println("Enter ur Name:");
    String name =sc1.next();
    System.out.println("Enter ur AadharID:");
    int id =sc1.nextInt();
    System.out.println("Enter ur Source:");
    String soc = sc1.next   ();
    System.out.println("Enter ur Destination");
    String des = sc1.next();  

    stmt.setString(1,name);
    stmt.setInt(2,id);
    stmt.setString(3,soc);
    stmt.setString(4,des);
    int a = stmt.executeUpdate();  
    System.out.println("************* SUCCESSFULLY BOOKED **************");
}


public void uber() throws SQLException
{
    System.out.println("******THAKS FOR CHOOSING UBER********");
    Connection con = getconn();
    String s1 = "insert into uber(name,aadharid,source,destination) values(?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(s1);

    System.out.println("Enter ur Name:");
    String name =sc1.next();
    System.out.println("Enter ur AadharID:");
    int id =sc1.nextInt();
    System.out.println("Enter ur Source:");
    String soc2 = sc1.next();
    System.out.println("enter ur destination");
    String des = sc1.next();


    stmt.setString(1,name);
    stmt.setInt(2,id);
    stmt.setString(3,soc2);
    stmt.setString(4,des);
    int b = stmt.executeUpdate();
    System.out.println("************ SUCCESSFULLY BOOKED **************");
}


public void rapido() throws SQLException
{
    System.out.println("******THANKS FOR CHOOSING RAPIDO********");
    Connection con = getconn();
    String s1 = "insert into rapido(name,aadharid,source,destination) values(?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(s1);

    System.out.println("Enter ur Name:");
    String name =sc1.next();
    System.out.println("Enter ur AadharID:");
    int id =sc1.nextInt();
    System.out.println("Enter ur Source:");
    String soc1 = sc1.next();
    System.out.println("Enter ur Destination");
    String des = sc1.next();

    stmt.setString(1,name);
    stmt.setInt(2,id);
    stmt.setString(3,soc1);
    stmt.setString(4,des);
    int c = stmt.executeUpdate();
    System.out.println("***************** SUCCESSFULLY BOOKED *****************");
}
}
