package basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {

	private Node<Item> first; //first element
	private int n;  //number
	
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	public Bag(){
		n = 0;
		first = null;
	}
	
	public boolean isEmpty(){
		return first== null;
	}
	
	
	public int size(){
		return n;
	}
	
	
	public void add(Item item){
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.next = oldfirst;
		first.item = item;
		n++;
	}
	@Override
	public Iterator<Item> iterator() {
		
		return new ListIterator<Item>(first);
	}

	
	private class ListIterator<Item> implements Iterator<Item>{

		private Node<Item> current;
		public ListIterator(Node<Item> first){
			current = first;
		}
		@Override
		public boolean hasNext() {
			
			return current!=null;
		}

		@Override
		public Item next() {
			if(!hasNext()){throw new NoSuchElementException();}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	public static void main(String[] args){
		
		Bag<String> bag = new Bag<String>();
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			bag.add(item);
		}
		StdOut.println("size of bag = " + bag.size());
		for(String s : bag){
			StdOut.println(s);
		}
	}
	
}
