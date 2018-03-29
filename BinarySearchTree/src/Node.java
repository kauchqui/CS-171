
public class Node{
public int data;
public String key;
Node left;
Node right;
Node root;
	public Node(){

	}
	public void put(String key, int v){
		root = addNode(root, v, key);
	}
	public Node addNode(Node n, int v, String key)
	{
		if(n == null){
			Node x = new Node();
			x.data = v;
			x.key = key;
			return x;
		}
		else if(n.data > v){
			n.left = addNode(root.left, v, key);
		}
		else if(n.data < v){
			n.right = addNode(root.right, v, key);
		}
		return n;
	}
	public String get(int val)
	{
		Node x = getName(root, val);
		String z = x.key;
		return z;
	}
	public Node getName(Node root, int val){
		if(root.data == val){
			return root;
		}
		else if(root.data > val){
			root.left = getName(root.left, val);
		}
		else if(root.data< val){
			root.right = getName(root.right, val);
		}
		return root;
	}
}
