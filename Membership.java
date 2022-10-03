package Assesment;
import java.util.*;

class Regular
{
	int membership_fee,enrollment_fee = 0;
	int golf_service = 20000;
	public double CalculateBill(int no_of_months)
	{
		int total_cost = no_of_months * golf_service;
		return (total_cost + membership_fee + enrollment_fee);
	}
}

class Gold extends Regular
{
	int membership_fee = 90000;
	int enrollment_fee = 10000;
	int golf_service = 10000;
	@Override
	public double CalculateBill(int no_of_months)
	{
		if(no_of_months<6) {
			return (membership_fee + enrollment_fee);
		}
		else {
			int total_golf_cost = no_of_months * golf_service;
			int total_cost = total_golf_cost + membership_fee + enrollment_fee;
			return total_cost;
		}
	}
}

class Silver extends Regular
{
	int membership_fee = 15000;
	int enrollment_fee = 5000;
	int golf_service = 20000;
	@Override
	public double CalculateBill(int no_of_months)
	{
		if(no_of_months<6) {
			return (membership_fee + enrollment_fee);
		}
		else {
			int total_golf_cost = no_of_months * golf_service;
			int total_cost = total_golf_cost + membership_fee + enrollment_fee;
			return total_cost;
		}
	}
}



public class Membership {
	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		System.out.println("Choose you plan - regular,gold,silver");
		String plan = ob.next();
		System.out.println("For how many months you have taken membership");
		int months = ob.nextInt();
		
		if(plan.equals("regular")) {
			Regular r = new Regular();
			double amount = r.CalculateBill(months);
			System.out.println(amount);
			
		}
		else if(plan.equals("gold")) {
			Gold g = new Gold();
			double amount = g.CalculateBill(months);
			System.out.println(amount);
		}
		else if(plan.equals("silver")) {
			Silver s = new Silver();
			double amount = s.CalculateBill(months);
			System.out.println(amount);
		}
	}
}
