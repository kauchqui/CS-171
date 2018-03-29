//Quintin Kauchick; qkauchi
//I worked on the homework assignment alone, using only this semester's course materials.

import java.util.Scanner;
import java.util.*;
class Hmwk6_qkauchi {

	
	
public static void main(String args[]){
	Hashtable ht = new Hashtable();
	users tempFriends = new users(null,null,null);
	users tempFriends2 = new users(null,null,null);

	UserProfile socialMedia = new UserProfile();
	int choiceentry = -1;
	Scanner scanchoice = new Scanner(System.in);
	do {
	 System.out.println("Welcome to MyFriendsSpace!!! \n\nSelect from the following menu:\n\"1. Add/update user\",\n\"2. Search user\",\n\"3. Add friend for user\",\n\"4. Remove friend for user\",\n\"5. Find shortest path between 2 users\",\n\"0. Exit MyFriendsSpace\" ");
	 choiceentry = scanchoice.nextInt();
	 switch (choiceentry)
	 {
	case 1:
	System.out.println("Press 1 to add a new user. Press 2 update.");
	Scanner newUser = new Scanner(System.in);
	int userAdd = newUser.nextInt();
	
	if(userAdd == 1){
		System.out.println("What is the name of the new user?");
		Scanner newUse = new Scanner(System.in);
		String userAdded = newUse.nextLine();
	if(ht.containsKey(userAdd) )
	{	
		System.out.println("That user is already in the social network.");
	
	}
	else
	{
			
			System.out.println("Thanks for joining the network, " +userAdded+ ". What is your age?");
			String a = newUse.nextLine();
			System.out.println("What is your location?");
			String loc = newUse.nextLine();
			users temp = new users(userAdded, a, loc);
			socialMedia.put(userAdded, a, temp);
			temp = socialMedia.user(userAdded);
			ht.put(userAdded, temp);
			
	}
	}
	if(userAdd == 2){
		System.out.println("Whose profile is going to be changed?");
		Scanner changeUse = new Scanner(System.in);
		String newInfo = changeUse.nextLine();
		if(ht.containsKey(newInfo) )
		{	
			System.out.println("What do you want to change "+ newInfo+"'s age to?");
			String a = changeUse.nextLine();
			
			tempFriends = socialMedia.user(newInfo);
			tempFriends.usersChangeAge(a);
		}
	}
		break;
	
	 
	 case 2:
	 System.out.println("Whose info do you want?");
	 Scanner userFind = new Scanner(System.in);
	 String foundUser = userFind.nextLine();
	 if(!ht.containsKey(foundUser) )
		{	
			System.out.println("That user does not exist");
			
		}
	 else
	 {
	 users temp = new users(null,null,null);
	 temp = socialMedia.user(foundUser);
	 System.out.println("Name: "+temp.getName()+"\nLocation: "+temp.getLoc()+"\nAge: "+temp.getAge()+"\nTheir friend list is:");
	 temp.printLink();
	 }
	 break;
	 case 3:
	 System.out.println("What is your name?");
	 Scanner friendFind = new Scanner(System.in);
	 String foundFriend = friendFind.nextLine();
	 System.out.println("Who do you want to add?");
	 Scanner addedFind = new Scanner(System.in);
	 String addedFriend = addedFind.nextLine();
	 if(!ht.containsKey(foundFriend) ||!ht.containsKey(addedFriend))
		{	
			System.out.println("One of those users does not exist!");
			
		}
	 else
	 {
	
	 
	 tempFriends = socialMedia.user(foundFriend);
	 tempFriends2 = socialMedia.user(addedFriend);
	 tempFriends.usersAdd(tempFriends2);
	 tempFriends2.usersAdd(tempFriends);
	 System.out.println(tempFriends.getName()+" added " + tempFriends2.getName());
	 System.out.println("This is "+tempFriends.getName()+ "'s friend list");
	 tempFriends.printLink();
	 }
	 break;
	 case 4:
	 System.out.println("What is your name?");
	 Scanner exFind = new Scanner(System.in);
	 String removeFriend = exFind.nextLine();
	 System.out.println("Who do you want to remove?");
	 Scanner secFind = new Scanner(System.in);
	 String deletedFriend = secFind.nextLine();
	 if(!ht.containsKey(removeFriend) ||!ht.containsKey(deletedFriend))
		{	
			System.out.println("One of those users does not exist!");
			
		}
	 else
	 {
	 
	 tempFriends = socialMedia.user(removeFriend);
	 tempFriends2 = socialMedia.user(deletedFriend);
	 tempFriends.usersRemove(tempFriends2);
	 tempFriends2.usersRemove(tempFriends);
	 System.out.println(removeFriend+" & "+ deletedFriend +" are no longer friends.");
	 System.out.println(removeFriend+"'s friend list is now:");
	 tempFriends.printLink();
	 
	 
	 }
	 break;
	 case 5:
	System.out.println("Input the first user.");
	Scanner pathFriend = new Scanner(System.in);
	 String key1 = pathFriend.nextLine();
	 System.out.println("input the second user");
	 Scanner secPath = new Scanner(System.in);
	 String key2= secPath.nextLine(); 
	 socialMedia.shortest(key1, key2);
	 
	 break;
	 default:
	 System.out.println("Choice must be a value between 0 and 5.");
	 }
	} while (choiceentry != 0); System.out.println("Bye, bye!");


}
}