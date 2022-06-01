package com.revature.ola;

import java.util.Scanner;
import java.sql.*;
public class reserv  {
   
    public static void main(String[] args) throws SQLException
    {
        book bb = new book();
        Boolean flag2 = true;
        do
        {
            System.out.println("press 1 to Login as Admin");
            System.out.println("press 2 to Check your Bookings ");
            System.out.println("press 3 to choose EXIT");

            Scanner sc2 = new Scanner(System.in);
            int j = sc2.nextInt();
           
            switch(j)
            {
            case 1: bb.adm();
                flag2 = false;
                break;
            case 2: bb.CheckYourBookings();
                flag2 = false;
                System.exit(0);
                break;
            case 3:
                System.exit(0);
            default : System.out.println("wrong choice u have entered");
                System.out.println("Please Enter the Correct One");
                break;
            }

        }while(flag2);


        Boolean flag = true;
        do{
            String s = "y";
           

            while (s.equals("y")) {
                System.out.println("*********** MAIN MENU *************");
                System.out.println("press 1 to choose ola");
                System.out.println("press 2 to choose uber");
                System.out.println("press 3 to choose rapido");
                System.out.println("press 4 to choose EXIT");

                Scanner sc = new Scanner(System.in);
                int i = sc.nextInt();

               

                switch (i)
                {
                case 1: bb.ola();
                    break;
                case 2: bb.uber();
                    break;
                case 3: bb.rapido();
                    break;
                case 4: System.exit(0);
                default : System.out.println("Wrong Choice");
                    break;
                }
                System.out.println("want to continue press y/n");
                s = sc.next();

            }

            flag = false;
           
        }
        while(flag);

    }

}