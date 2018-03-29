
public class BST<Key extends Comparable <Key>, Value> {
	private Node root;	
	
	
	private class Node{
	private Value value;
	private Key key;
	private Node left, right;
	
	
		public Node(Key key, Value value){
			this.key = key;
			this.value = value;
		}
			public void put(Key key, Value v){
				if(key == null){
					System.out.println("No such key.");
				}
				else{
					root = addNode(root, key, value);
				}
				
			}
			public Node addNode(Node root, Key key, Value value)
			{
			int cmp = key.compareTo(root.key);
			
			if(root == null){
				Node newNode = new Node(key, value);
				root = newNode;
			}
			if(cmp < 0){
				//root.left is required. Look up why this is the case in a BST.
				root.left = addNode(root.left, key, value);
			}
			if(cmp > 0 ){
				root.right = addNode(root.right, key, value);
			}
			else
			{
				root.value = value;
			}
				
				
				
				
				
				
				
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