import java.util.LinkedList;
public class users {
public String name;
public String age;
public String location;
public users parent;
LinkedList<users> friendList = new LinkedList<users>();

	users(String name, String age, String loc)
	{
		this.name = name;
		this.age = age;
		this.location = loc;
		
	}
	users(users users1, users users2)
	{
		name = users1.name;
		friendList = users1.friendList;
		parent = users2;
		
	}
	public void usersAdd(users user)
	{
		friendList.add(user);
	}
	public String getLoc(){
		return this.location;
	}
	public String getAge(){
		return this.age;
	}
	public String getName(){
		return this.name;
	}
	public void printLink()
	{
		LinkedList<users> tempList = new LinkedList<users>();
		while(!friendList.isEmpty())
		{
			users temp = friendList.removeFirst();
			System.out.println(temp.name);
			tempList.add(temp);
		}
		friendList = tempList;
	}
	public void usersRemove(users deletedFriend)
	{
		int x = friendList.indexOf(deletedFriend);
		friendList.remove(x);
	
	
	}
	public void usersChangeAge(String a){
		this.age = a;
	}
	
}
