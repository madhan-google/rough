import java.io.*;
import java.util.*;
class AutoComplete{
	class Node{
		ArrayList<String> list;
		boolean isEnd;
		Node[] childs;
		Node(){
			this.list = new ArrayList<String>();
			this.isEnd = false;
			this.childs = new Node[26];
		}
	}
	Node root;
	AutoComplete(){
		root = new Node();
	}
	public void insert(String s){
		Node node = root;
		for(char ch : chararr(s)){
			if( node.childs[ch-'a'] == null )
				node.childs[ch-'a'] = new Node();
			node = node.childs[ch-'a'];
			node.list.add(s);
		}
		node.isEnd = true;
	}
	public void find(String s){
		Node node = root;
		for(char ch : chararr(s)){
			if( node.childs[ch-'a'] == null )
				return;
			node = node.childs[ch-'a'];
		}
		System.out.println(node.list);
	}
	static final Scanner sn = new Scanner(System.in);
	static final Random rn = new Random();
	public static void main(String[] args) {
		AutoComplete a = new AutoComplete();
		String s = sn.next();
		while( !"end".equals(s) ){
			a.insert(s);
			s = sn.next();
		}
		System.out.println("find : ");
		s = "";
		while( !"end".equals(s) ){
			s = sn.next();
			a.find(s);
		}
	}
	static void fill(int[] ar, int n){
		Arrays.fill(ar, n);
	}
	static char[] chararr(String s){
		return s.toCharArray();
	}
}