import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Scanner;
public class Evil_corp_app {
	@SuppressWarnings("deprecation")
	public static void main(String [] args){
		ArrayList<Evil_Corp> list_of_accounts = new ArrayList<Evil_Corp>();
		
		Evil_Corp evil = new Evil_Corp();//object of Evil corp class
		Scanner key = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance();//for formatting balance is USD
		GregorianCalendar date_of_transaction = new GregorianCalendar();//for transaction dates
		SimpleDateFormat sdf = new SimpleDateFormat(" MM/dd/yyyy ");//for formatting dates
		set_date d = new set_date ();// for converting entered date into values for Year, Month, and day.
		
		
		//Information entered by the user.
		int account_number = 0, balance, check;//account number, remaining balance, and payment each transaction
		String name;
		String entered_date = "";
		
		
		
		
		
		
		System.out.println("Welcome to Evil Corp Savings and Loan\nPlease create the user account(s)");
		
		Loop1:
		while(true){
			
			System.out.println("Enter an account # or -1 to stop entering accounts");
			account_number = key.nextInt();
			
			if(account_number == -1){break Loop1;}
			
			
			evil.setAccount_number(account_number);
			System.out.println("Enter the name for acct # " + account_number + " : ");
			name = key.next();
			key.nextLine();
			evil.setName(name);
			
			System.out.println("Enter the balance for acct # " + account_number + " : ");
			balance = key.nextInt();
			evil.setBalance(balance);
			list_of_accounts.add(evil);
			
		}
		
		account_number = 0;
		String transaction_type = " ";
		int index;
		
		Loop2:
		while(true){
			System.out.println("Enter a transaction type (Check, Debit card, Deposit or Withdrawal) or -1 to finish :");
			transaction_type = key.next();
			key.nextLine();
			
			
			switch (transaction_type){
			
			case "c"://c letter for checking.
				System.out.println("Enter the account # : ");
				account_number = key.nextInt();
				
				//Looping to search for account number if available
				for(int i = 0; i < list_of_accounts.size(); i++){
					if(list_of_accounts.get(i).getAccount_number() == account_number)
					{
	
						System.out.println("Enter the amount of the check: ");
						check = key.nextInt();
						
						balance = list_of_accounts.get(i).getBalance() - check;
						list_of_accounts.get(i).setBalance(balance);
						
						//if the balance becomes negative, it starts charging $35 fees each transaction.
						if(balance < 0){
							list_of_accounts.get(i).setBalance(balance - 35);
							balance = list_of_accounts.get(i).getBalance();
						}
						
						
						System.out.println("Enter the date of the check: ");
						entered_date = key.next();
						key.nextLine();
						
						//Converting date into integers of Year, Month, Day and set them into the Gregorian Calendar
						d.setDate(entered_date);
						
						date_of_transaction = new GregorianCalendar(d.getYear(),d.getMonth(), d.getDay());
						
						list_of_accounts.get(i).store_info(balance,check,date_of_transaction);
						list_of_accounts.get(i).store_sorted_list(list_of_accounts.get(i).get_info());
						
						
						//Key = checks + balances, value = dates of transactions,
						
						
						System.out.printf("%-20s%-10s%-10s\n", "Transaction date", "Check", "Balance");
						System.out.printf("%-20s%-10s%-10s\n", "------------------", "------", "---------");
						
						for(String KEY:list_of_accounts.get(i).get_info().keySet()){
							System.out.println(sdf.format(list_of_accounts.get(i).get_info().get(KEY).getTime()) + "\t\t" + KEY);
						}
					}

					else{System.out.println("The entered account number is not available in our data base.");}
				
				}
				break;
			case "-1":break Loop2;
			default: System.out.println("Invalid option. Try again.");
			}
		}
	}
}
		
		

