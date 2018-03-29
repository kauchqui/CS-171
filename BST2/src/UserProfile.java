import java.util.ArrayDeque;
import java.util.ArrayList;




public class UserProfile {
	private Node[] nodes;
	public Node rootNode;
	public UserProfile() {
		//random array size. only 6 required but made it big regardless.
		nodes = new Node[41];
	}
	
	
	
	public int getHash(String key) {
		
		if(key == null) {
			return 0;
		}
		//throws an outofbounds exception here if not truncated at 4 sometimes 5. 
		String newKey = key.substring(0, Math.min(key.length(), 4));

		int hash = newKey.hashCode();
		
		hash = hash % 41;
		
		return hash;
	}
	
	
	public void put(String key, String value, users user) {
		
		int kashKey = getHash(key);
		//creating a new node
		final Node newNode = new Node(key, value, user, null);
		
		if(nodes[kashKey] == null) {
			
			nodes[kashKey] = newNode;
		} else {
			//creates node 
			Node root = nodes[kashKey];
			
			
				addBST(root, newNode);
			} 
		}
		
	private void addBST(Node root, final Node newNode) {
		//adds to root node if no tree yet
		if(root == null) {
			root = newNode;
			this.rootNode = newNode;
			return;
			
		}
		
		Node thisNode = root;
		Node previousNode = root;
		//searches for the node place in tree. 
		while(true) {
			
			previousNode = thisNode;
			
			if(newNode.key.compareTo(thisNode.key) == 0) {
				
				// if key values are same then just overwrite the value in same node as duplicate keys are not allowed in this map
				//this isn't possible thanks to our HT in main that doesn't allow us to put in duplicate keys
				thisNode.value = newNode.value;
				return;
				
			} else if(newNode.key.compareTo(thisNode.key) < 0) {
				thisNode = thisNode.left;
				//if it finds a null node put the newnode there
				if(thisNode == null) {
					previousNode.left = newNode;
					return;
				}
			} else {
				
				thisNode = thisNode.right;
				//if it finds a null node put the newnode there
				if(thisNode == null) {
					previousNode.right = newNode;
					return;
				}
			} 
		}
		
	}

public users user(String key) {
		
		Node node = nodes[getHash(key)];
		
		if(node != null) {
			return getUserInfo(node, key);
		}
		
		return null;
	}
private users getUserInfo(Node root, String key) {
		
		if(key == null) {
			return null;
		}
		
		while(root != null) {
			if(key.equals(root.key)) {
				return root.user;
			} else if(key.compareTo(root.key) < 0) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		
		return null;	
	}
	private static class Node {
		
		public String key;
		private String value;
		private Node left;
		private Node right;
		private users user;
		
		Node parent;
		//redundant?
		public Node(String key, String value, users user) 
		{
			this.key = key;
			this.value = value;
			this.user = user;
		
		}
		public Node(String key, String value, users user, Node p)
		{
			this.key = key;
			this.value = value;
			this.user = user;
			parent = p;
		}
		
	}
	
	public int shortest(String key1, String key2){
		ArrayDeque<String> finalList = new ArrayDeque<String>();
		ArrayList<users> searched = new ArrayList<users>();
		ArrayDeque<users> queue = new ArrayDeque<users>();
		
		queue.add(user(key1));
		searched.add(user(key1));
		int count = 0;

		while(!queue.isEmpty()){
			
		users thisUser = queue.remove();
			if (thisUser.name.equals(user(key2).name)){
			
		users x;
				for(x = thisUser; x.parent != null; x = x.parent)
				{
			
					finalList.add(x.getName());
					count++;
				} 
				finalList.push(x.getName());
				System.out.print("The path we used to connect the users was: ");
				System.out.println(finalList.remove()+ "\nto");
					while(!finalList.isEmpty()){
							//changed from pop to remove	
						System.out.println(finalList.removeLast());
						if(!finalList.isEmpty()){
							System.out.println(" to ");
						}
					}
					return count;
			} else {
				boolean exists = false;
					for(int i = 0; i < thisUser.friendList.size(); i++){
						exists = false;
							for (int a = 0; a < searched.size(); a++){
								if(thisUser.friendList.get(i).equals(searched.get(a))){
									exists = true;
								}
							}
							if(!exists){
		
								searched.add(new users(thisUser.friendList.get(i), thisUser));
								queue.add(new users(thisUser.friendList.get(i), thisUser));
							}
					}
			}
		}
		return -1;
	}
/*
     while(queuefinalList.isEmpty() == false){
     	Position pos = queuefinalList.removeLast();
     	if(pos.i == maze.length-1 && pos.j == maze[0].length-1){
     		for(int row =0; row <maze.length; row++){
     			for(int col =0; col<maze[0].length; col++){
     			if(maze[row][col] != '1'){
     				maze[row][col] = '0';
     			}
     			}
     		}
     		maze[0][0] = 'X';
     		maze[pos.i][pos.j] = 'X';
     		Position finPath[] = new Position[maze[0].length*maze[0].length];
     		finPath[0] = pos;
     		int inc = 0;
     		pos = pos.parent;
     		
     		while(pos != null) {
     			maze[pos.i][pos.j] = 'X';
     			finPath[inc] = pos;
     			pos = pos.parent;
     			inc++;
     			
     		}
     		return finPath;
     	} else {
     		maze[pos.i][pos.j] = 'X';
     		if(pos.i+1< maze[0].length && maze[pos.i+1][pos.j] == '0') {
     			Position addPos = new Position(pos.i+1, pos.j, '0', pos);
     		 	queuefinalList.addFirst(addPos);
			}
			if(pos.j+1<maze.length && maze[pos.i][pos.j+1] == '0'){
				Position addPos = new Position(pos.i,pos.j+1,'0',pos);
				queuefinalList.addFirst(addPos);
			}
			if(pos.j-1>-1 && maze[pos.i][pos.j-1] == '0') {
				Position addPos = new Position(pos.i,pos.j-1,'0',pos);
				queuefinalList.addFirst(addPos);
			}
			if(pos.i-1>-1 && maze[pos.i-1][pos.j] == '0'){
				Position addPos = new Position(pos.i-1,pos.j,'0',pos);
				queuefinalList.addFirst(addPos);
			}
     	}
     }
     throw new NullPointerException("No path available!");
		
}
*/
}
