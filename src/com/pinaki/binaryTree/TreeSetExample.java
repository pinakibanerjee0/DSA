package com.pinaki.binaryTree;

//Java program to demonstrate TreeSet
import java.util.Iterator;
import java.util.TreeSet;

class TreeSetExample {

	public static void main(String[] args) {

		// Creating an empty TreeSet
		TreeSet<Integer> s = new TreeSet<Integer>();

		// Elements are added using add() method
		s.add(10);
		s.add(5);
		s.add(2);
		s.add(15);

		// Removing 5 from TreeSet
		s.remove(5);

		// Elements are added using add() method
		s.add(10);
		s.add(5);
		s.add(2);
		s.add(15);

		// Prints the largest value lower than 5
		// Here it is 2
		System.out.println(s.lower(5));

		// Prints the smallest higher value than 5
		// Between 10 and 15 smallest is 10
		System.out.println(s.higher(5));

		// Value <= 5
		System.out.println(s.floor(5));

		// Value >= 5
		System.out.println(s.ceiling(5));

		// foreach way of traversal
		for (Integer x : s)
			System.out.print(x + " ");
		// Creating an empty TreeSet
		TreeSet<String> t = new TreeSet<String>();
		/// Elements are added using add() method
		t.add("gfg");
		t.add("courses");
		t.add("ide");

		// Displaying the TreeSet
		// in sorted order
		System.out.println(s);

		// Checking whether "ide" is present
		// or not
		System.out.println(s.contains("ide"));

		// Iterator to traverse the TreeSet
		Iterator<Integer> i = s.iterator();
		while (i.hasNext())
			System.out.println(i.next());
	}
}
