import java.util.Queue;
public class Node{
	int x; 
	Node left;
	Node right;
	Node parent;
	public Node(Node p, int v){
		parent = p;
		x = v;
	}
	public static void addNode(Node n, int v){
		if(v <n.x){
			if(n.left == null){
				n.left = new Node(n, v);
			}
			else{
				addNode(n.left, v);
			}
		}
	}
	
}
