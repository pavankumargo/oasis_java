import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
	
	private static String userid="42137456";
	private static String userpin="1234";
	private static int balance = 10000;
	private static List<String>history=new ArrayList<>();
	private static void show_transaction_history() {
		for(String x:history) {
			System.out.println(x);
		}
		System.out.println();
	}
	private static void withdraw(int x) {
		if(balance<x) {
			System.out.println("Insufficient balance");
			System.out.println();
			return;
		}
		balance-=x;
		history.add(0,"Withdrawed the amount of"+String.valueOf(x));
		System.out.println("Sucessfully withdrawed the amount "+x);
		System.out.println();
	}
	private static void deposit(int x) {
		balance+=x;
		history.add(0,"Deposited the amount of"+String.valueOf(x));
		System.out.println("Sucessfully deposited the amount "+x);
		System.out.println();
	}
	
	private static void transfer(int x) {
		if(balance<x) {
			System.out.println("Insufficient balance");
			System.out.println();
			return;
		}
		balance-=x;
		history.add(0,"Transferred the amount of"+String.valueOf(x));
		System.out.println("Sucessfully transferred the amount "+x);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter user id");
			String id=sc.nextLine();
			System.out.println("Enter pin");
			String pin=sc.nextLine();
			if(userid.equals(id) && userpin.equals(pin)) {
				while(true) {
					System.out.println("your balance is"+balance);
					System.out.println("1.Transaction history");
					System.out.println("2.Withdraw");
					System.out.println("3.Deposit");
					System.out.println("4.Transfer");
					System.out.println("5.Quit");
					System.out.println();
					int choice=sc.nextInt();
					System.out.println();
					if(choice==1) {
						show_transaction_history();
					}else if(choice==2) {
						System.out.println("Enter the amount to be withdrawn");
						int a=sc.nextInt();
						withdraw(a);
					}else if(choice==3) {
						System.out.println("Enter the amount to be deposited");
						int a=sc.nextInt();
						deposit(a);
					}else if(choice==4) {
						System.out.println("Enter the amount to be transferred");
						int a=sc.nextInt();
						transfer(a);
					}else if(choice==5) {
						sc.close();
						return;
					}else {
						System.out.println("enter a valid operation number");
					}
				}
			}
			else {
				System.out.println("Invalid credentials");
			}
		}
	}

}
