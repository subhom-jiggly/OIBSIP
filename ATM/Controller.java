import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;
public class Controller
{
    static int iter=-1;
    static int slnum[]=new int[100];
    static String Status[]=new String[100];
    static int amt[]=new int[100];
    static int bal[]=new int[100];
    static int balance=50;
    public static void deposit(int n)
    {
        
        Controller.iter++;
        int sum=Controller.balance+n;
        Controller.balance=sum;
        Controller.slnum[Controller.iter]=Controller.iter+1;
        Controller.Status[Controller.iter]="Deposit";
        Controller.amt[Controller.iter]=n;
        Controller.bal[Controller.iter]=Controller.balance;
        System.out.println("Amount Deposited Successfully!");

    }
    public static void withdraw(int n)
    {
        Controller.iter++;
        int sum=Controller.balance-n;
        Controller.balance=sum;
        Controller.slnum[Controller.iter]=Controller.iter+1;
        Controller.Status[Controller.iter]="Withdraw";
        Controller.amt[Controller.iter]=n;
        Controller.bal[Controller.iter]=Controller.balance;
        System.out.println("Amount Withdrawn Successfully!");
    }
    public static void transfer(int n)
    {
        Scanner scin=new Scanner(System.in);
        System.out.print("Enter account number of receiver: ");
        String accnum=scin.next();
        Controller.iter++;
        int sum=Controller.balance-n;
        Controller.balance=sum;
        Controller.slnum[Controller.iter]=Controller.iter+1;
        Controller.Status[Controller.iter]="Transfer("+accnum+")";
        Controller.amt[Controller.iter]=n;
        Controller.bal[Controller.iter]=Controller.balance;
        System.out.println("Amount Transferred Successfully!");
    }
    public static void history(int p)
    {
        System.out.println("\n-------------------");
        for(int i=0;i<=p;i++)
        {
            System.out.println(Controller.slnum[i]+" "+Controller.Status[i]+" "+Controller.amt[i]+" "+Controller.bal[i]);
        }
        System.out.println("\n-------------------");
    }
    public static void main(String args[])
    {
        Scanner scin=new Scanner(System.in);
        int k=0;
        System.out.println("Username: admin, Password: 1234");
        String uname=scin.next();
        String pass=scin.next();
        if(uname.equals("admin") && pass.equals("1234"))
        {
            do
            {
                System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Transaction History\n5.Exit");
                k=scin.nextInt();
                switch(k)
                {
                    case 1: System.out.print("Enter Deposit amount: ");
                            int a=scin.nextInt();
                            Controller.deposit(a);
                            break;
                    case 2:  System.out.print("Enter Withdrawal amount: ");
                             int b=scin.nextInt();
                             Controller.withdraw(b);
                             break;
                    case 3: System.out.print("Enter Transfer amount: ");
                            int c=scin.nextInt();
                            Controller.transfer(c);
                            break;
                    case 4: Controller.history(Controller.iter);
                            break;      
                } 
            }while(k!=5);
        }
        else
              System.out.print("Cannot access");
    }
}