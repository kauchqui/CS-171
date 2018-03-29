import java.util.*;


public class BST{
	

private static class Node {
		
		private String person1;
		private Node left;
		private Node right;
		Node parent;
		
		public Node(String person1, Node left, Node right) 
		{
			this.person1 = person1;
			this.left = left;
			this.right = right;
		
		}
		public Node(String person1, Node left, Node right, Node p) 
		{
			this.person1 = person1;
			this.left = left;
			this.right = right;
			parent = p;
		
		}
		
	}
	public static Node [] queueSearch(UserProfile x, String person1, String person2, Node root) throws NullPointerException{
		ArrayDeque <Node> queueList = new ArrayDeque<Node>();
		Node first = root;
        queueList.addFirst(first);

     while(queueList.isEmpty() == false){
     	Position pos = queueList.removeLast();
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
     		 	queueList.addFirst(addPos);
			}
			if(pos.j+1<maze.length && maze[pos.i][pos.j+1] == '0'){
				Position addPos = new Position(pos.i,pos.j+1,'0',pos);
				queueList.addFirst(addPos);
			}
			if(pos.j-1>-1 && maze[pos.i][pos.j-1] == '0') {
				Position addPos = new Position(pos.i,pos.j-1,'0',pos);
				queueList.addFirst(addPos);
			}
			if(pos.i-1>-1 && maze[pos.i-1][pos.j] == '0'){
				Position addPos = new Position(pos.i-1,pos.j,'0',pos);
				queueList.addFirst(addPos);
			}
     	}
     }
     throw new NullPointerException("No path available!");
		
}
}