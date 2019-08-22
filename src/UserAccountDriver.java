import java.util.ArrayList;
import java.util.Scanner;		// The Scanner class is imported so I can have input.
import java.util.Collections;	// The collections class is imported so I can sort the names.

// This is the driver class, this is where the program is essentially executed in the main method in the
// driver class.
public class UserAccountDriver 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		// I'm making an array list called allFacebookUsers is is an array list of objects
		// from the FacebookUser class.
		// I then create three facebook person objects, and add them to
		// the allFacebookUsers array list.
		// I then get the index for each facebook person object and call for my setPasswordHint method
		// so I can set the password hint for each facebook person.
		ArrayList<FacebookUser> allFacebookUsers = new ArrayList<FacebookUser>();
		FacebookUser facebookPerson1 = new FacebookUser("Isaac", "Xbox360");
		FacebookUser facebookPerson2 = new FacebookUser("Seth" , "Xbox1");
		FacebookUser facebookPerson3 = new FacebookUser("Josiah", "PlayStation4");
		
		allFacebookUsers.add(facebookPerson1);
		allFacebookUsers.get(0).setPasswordHint("Box X");
		allFacebookUsers.add(facebookPerson2);
		allFacebookUsers.get(1).setPasswordHint("Upgraded Box X");
		allFacebookUsers.add(facebookPerson3);
		allFacebookUsers.get(2).setPasswordHint("4th Gen Best Sony console");
		
		System.out.println("Current Accounts:");
		System.out.println("----------------");
		
		// This is a new array list that is assigned to the sortFriendsList method,
		// which has my allFacebookUsers array list as an argument.
		// I then simply print out this friends list in sorted order using my toString method.
		ArrayList<FacebookUser> sortedFriendsList = sortFriendsList(allFacebookUsers);
		
		System.out.println(sortedFriendsList.toString());
		System.out.println();
		
		System.out.print("Please enter the name of one of the current accounts.");
		String name = input.next();
		System.out.println();
		
		// There's three cases or three methods for each account.
		if (name.equalsIgnoreCase("Isaac"))
			caseForIsaac(name,allFacebookUsers);
		else if (name.equalsIgnoreCase("Seth"))
			caseForSeth(name,allFacebookUsers);
			
		else if (name.equalsIgnoreCase("Josiah"))
			caseForJosiah(name,allFacebookUsers);
		else
			System.out.println("Error! a correct username has to be selected.");
			 
				
		
			
	}
	
	// Essentially what this method does is it create an array list copy of my original
	// friends array list and then I'm using the Collections class to call the sort method
	// so I can sort this array list and return it.
	public static ArrayList <FacebookUser> sortFriendsList(ArrayList<FacebookUser> list)
	{
		ArrayList<FacebookUser> replicaOfFriendsList = new ArrayList<FacebookUser>(list);

	    Collections.sort(replicaOfFriendsList);
	       
	    return replicaOfFriendsList;
	}
	
	// Break down for case "Isaac" - "Josiah": basically what the three following methods do is
	// each one picks a different person to friend. For Isaac it's Seth, I assign isaac to the index
	// of the allFacebookUsers array list, and I do the same with seth, and then I friend Seth.
	// I then create an array list, for the case of isaac it's isaacsFriend, and I assign that to the
	// isaac object and call for the getFriends method. Once I've done this, I can use the
	// isaacsFriends array list to call for the toString method where it'll print out who Isaac's friends are.
	// Then I allow for some user input, I ask if they want to defriend a person. If they do,
	// then I call for the deFriend method, defriend Seth for the case of Isaac, and show that Isaac now has
	// no friends. If the user doesn't want to defriend anyone then the program asks if the user wants 
	// to view their password hint. If they want to see it, then that's where I call for the abstract getPasswordHelp method
	// and show what the hint is I made near the beginning of the driver for each account.
	// If they don't care to see the password hint then the program is terminated.
	// All three case methods work this way accept each person has someone different added or defriended.
	// For Isaac it's controlled so Isaac will always friend Seth, Josiah will always friend Isaac, Seth will always friend Josiah.
	// If the user choose the defriend option then those people are simply removed.
	public static void caseForIsaac(String name,ArrayList<FacebookUser> allFacebookUsers )
	{
		Scanner input = new Scanner(System.in);
		
		if(name.equalsIgnoreCase("Isaac"))
		{
			
			System.out.println("I will now add Seth to your friend's list.");
				
			FacebookUser isaac = allFacebookUsers.get(0);
			FacebookUser seth = allFacebookUsers.get(1);
			isaac.friend(seth);
				
			ArrayList<FacebookUser> isaacsFriends = isaac.getFriends();
				
			System.out.println("Isaac's friends are:");
			System.out.println("-------------------");
			System.out.println(isaacsFriends.toString());
			System.out.print("Do you wish to defriend this person? (T) or (F)");
			String defriendOption = input.next();
				
			while(defriendOption.equalsIgnoreCase(defriendOption)  != defriendOption.equalsIgnoreCase("T") != defriendOption.equalsIgnoreCase("F"))
			{
				System.out.print("Error! please select (T) or (F)");
				defriendOption = input.next();
				System.out.println();
			}
			
			if (defriendOption.equalsIgnoreCase("T"))
			{
				isaac.defriend(seth);
				isaacsFriends = isaac.getFriends();
				System.out.println("Isaac's friends are now:");
				System.out.println("-------------------");
				System.out.println(isaacsFriends.toString());
				System.out.println();
				System.out.println("Do you wish to view your password hint for this account?");
				System.out.print("Enter (T) or (F)");
				String passwordHintOption = input.next();
				
				while (passwordHintOption.equalsIgnoreCase(passwordHintOption) != passwordHintOption.equalsIgnoreCase("T") != passwordHintOption.equalsIgnoreCase("F"))
				{
					System.out.print("Error! please select (T) or (F): ");
					passwordHintOption = input.next();
					System.out.println();
				}
				if (passwordHintOption.equalsIgnoreCase("T"))
				{
					isaac.getPasswordHelp();
					System.out.println("Program terminated...");
					System.exit(0);
				}
				else if(passwordHintOption.equalsIgnoreCase("F"))
					System.out.println("Program terminated...");
				
			}
			else if (defriendOption.equalsIgnoreCase("F"))
			{
				System.out.println("Do you wish to view your password hint for this account?");
				System.out.print("Enter (T) or (F): ");
				String passwordHintOption = input.next();
					
				while (passwordHintOption.equalsIgnoreCase(passwordHintOption) != passwordHintOption.equalsIgnoreCase("T") != passwordHintOption.equalsIgnoreCase("F"))
				{
					System.out.print("Error! please select (T) or (F) :");
					passwordHintOption = input.next();
					System.out.println();
				}
				if (passwordHintOption.equalsIgnoreCase("T"))
				{
					isaac.getPasswordHelp();
					System.out.println("Program terminated...");
				}
				else if (passwordHintOption.equalsIgnoreCase("F"))
				{
					System.out.println("Program terminated...");
					System.exit(0);
				}
			}	
		}
	}
	
	public static void caseForSeth(String name,ArrayList<FacebookUser> allFacebookUsers )
	{
		Scanner input = new Scanner (System.in);
		
		if (name.equalsIgnoreCase("Seth"))
		{
			
			System.out.println("I will now add Josiah to your friend's list.");
					
			FacebookUser seth = allFacebookUsers.get(1);
			FacebookUser josiah = allFacebookUsers.get(2);
			seth.friend(josiah);
					
			ArrayList<FacebookUser> sethsFriends = seth.getFriends();
					
			System.out.println("Seth's friends are:");
			System.out.println("-------------------");
			System.out.println(sethsFriends.toString());
			System.out.print("Do you wish to defriend this person? (T) or (F)");
			String defriendOption = input.next();
					
			while(defriendOption.equalsIgnoreCase(defriendOption)  != defriendOption.equalsIgnoreCase("T") != defriendOption.equalsIgnoreCase("F"))
			{
				System.out.print("Error! please select (T) or (F)");
				defriendOption = input.next();
				System.out.println();
			}
			
			if (defriendOption.equalsIgnoreCase("T"))
			{
				seth.defriend(josiah);
				sethsFriends = seth.getFriends();
				System.out.println("Seth's friends are now:");
				System.out.println("-------------------");
				System.out.println(sethsFriends.toString());
				System.out.println();
				System.out.println("Do you wish to view your password hint for this account?");
				System.out.print("Enter (T) or (F)");
				String passwordHintOption = input.next();
				
				while (passwordHintOption.equalsIgnoreCase(passwordHintOption) != passwordHintOption.equalsIgnoreCase("T") != passwordHintOption.equalsIgnoreCase("F"))
				{
					System.out.print("Error! please select (T) or (F): ");
					passwordHintOption = input.next();
					System.out.println();
				}
				if (passwordHintOption.equalsIgnoreCase("T"))
				{
					seth.getPasswordHelp();
					System.out.println("Program terminated...");
					System.exit(0);
				}
				else if(passwordHintOption.equalsIgnoreCase("F"))
					System.out.println("Program terminated...");
				
			}
			else if (defriendOption.equalsIgnoreCase("F"))
			{
				System.out.println("Do you wish to view your password hint for this account?");
				System.out.print("Enter (T) or (F): ");
				String passwordHintOption = input.next();
					
				while (passwordHintOption.equalsIgnoreCase(passwordHintOption) != passwordHintOption.equalsIgnoreCase("T") != passwordHintOption.equalsIgnoreCase("F"))
				{
					System.out.print("Error! please select (T) or (F) :");
					passwordHintOption = input.next();
					System.out.println();
				}
				if (passwordHintOption.equalsIgnoreCase("T"))
				{
					seth.getPasswordHelp();
					System.out.println("Program terminated...");
				}
				else if (passwordHintOption.equalsIgnoreCase("F"))
				{
					System.out.println("Program terminated...");
					System.exit(0);
				}
				
			}
		}	
	}
		
	public static void caseForJosiah(String name,ArrayList<FacebookUser> allFacebookUsers )
	{
		Scanner input = new Scanner(System.in);
		
		if (name.equalsIgnoreCase("Josiah"))
		{
			System.out.println("I will now add Isaac to your friend's list.");
					
			FacebookUser josiah = allFacebookUsers.get(2);
			FacebookUser isaac = allFacebookUsers.get(0);
			josiah.friend(isaac);
					
			ArrayList<FacebookUser> josiahsFriends = josiah.getFriends();
					
			System.out.println("Josiah's friends are:");
			System.out.println("-------------------");
			System.out.println(josiahsFriends.toString());
			System.out.print("Do you wish to defriend this person? (T) or (F): ");
			String defriendOption = input.next();
			
			
			while(defriendOption.equalsIgnoreCase(defriendOption)  != defriendOption.equalsIgnoreCase("T") != defriendOption.equalsIgnoreCase("F"))
			{
				System.out.print("Error! please select (T) or (F)");
				defriendOption = input.next();
				System.out.println();
			}
			
			if (defriendOption.equalsIgnoreCase("T"))
			{
				josiah.defriend(isaac);
				josiahsFriends = isaac.getFriends();
				System.out.println("Josiah's friends are now:");
				System.out.println("-------------------");
				System.out.println(josiahsFriends.toString());
				System.out.println();
				System.out.println("Do you wish to view your password hint for this account?");
				System.out.print("Enter (T) or (F)");
				String passwordHintOption = input.next();
				
				while (passwordHintOption.equalsIgnoreCase(passwordHintOption) != passwordHintOption.equalsIgnoreCase("T") != passwordHintOption.equalsIgnoreCase("F"))
				{
					System.out.print("Error! please select (T) or (F): ");
					passwordHintOption = input.next();
					System.out.println();
				}
				if (passwordHintOption.equalsIgnoreCase("T"))
				{
					josiah.getPasswordHelp();
					System.out.println("Program terminated...");
					System.exit(0);
				}
				else if(passwordHintOption.equalsIgnoreCase("F"))
					System.out.println("Program terminated...");
				
			}
			else if (defriendOption.equalsIgnoreCase("F"))
			{
				System.out.println("Do you wish to view your password hint for this account?");
				System.out.print("Enter (T) or (F): ");
				String passwordHintOption = input.next();
					
				while (passwordHintOption.equalsIgnoreCase(passwordHintOption) != passwordHintOption.equalsIgnoreCase("T") != passwordHintOption.equalsIgnoreCase("F"))
				{
					System.out.print("Error! please select (T) or (F) :");
					passwordHintOption = input.next();
					System.out.println();
				}
				if (passwordHintOption.equalsIgnoreCase("T"))
				{
					josiah.getPasswordHelp();
					System.out.println("Program terminated...");
				}
				else if (passwordHintOption.equalsIgnoreCase("F"))
				{
					System.out.println("Program terminated...");
					System.exit(0);
				}
			}
		}		
	}	
}
	
	
	

	

