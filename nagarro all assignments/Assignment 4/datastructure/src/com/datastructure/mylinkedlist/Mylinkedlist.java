package com.datastructure.mylinkedlist;

import java.util.Iterator;

public class Mylinkedlist<Type extends Comparable<? super Type>> implements Iterable<Type> {

	public Node<Type> head;

	public class Node<E> {

		E data;
		Node<E> next;

// can we make constructor of a generic type ?
		public Node(E data) {
			this.data = data;
			this.next = null;
		}

	}
// adding values add the end of the linked list

	public void add(Type data) {
		Node<Type> value = new Node<Type>(data);

		if (head == null) {
			head = value;
			return;
		}
		Node<Type> last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = value;

	}

// printing the linked list
	public void print() {
		Node<Type> last = head;
		while (last != null) {

			System.out.print(last.data + " ");
			last = last.next;
		}
		System.out.println();

	}

// calculating the length of an linked list 

	public Integer size() {
		Node<Type> last = head;
		int count = 0;
		while (last != null) {
			last = last.next;
			count += 1;
		}
		return count;
	}

// insert method at some specific position

	public void insert(Type val, int pos) {
		Node<Type> last = head;
		Node<Type> valInsrt = new Node<Type>(val);
		int count = 0;
		if (pos == 0) {
			valInsrt.next = head;
			head = valInsrt;
			return;
		}

// to check whether the inserting point is in the range of linked list or not
		try {

			while (count != pos - 1) {
				last = last.next;
				count += 1;
			}
			valInsrt.next = last.next;
			last.next = valInsrt;
		} catch (NullPointerException e) {
			System.out.println("Index out of range");
		}
	}

// delete at a specific position  method 

	public void delete(int del) {
		Node<Type> last = head;
		int count = 0;
		if (del == 0) {
			head = head.next;
			return;
		}
// Adding try catch if the delete index is out of range
		try {
			while (count != del - 1) {
				last = last.next;
				count += 1;
			}
			last.next = last.next.next;

		} catch (NullPointerException e) {
			System.out.println("Index out of range");
		}

	}

// delete at the end 

	public void delete() {
		Node<Type> last = head;
		while (last.next.next != null) {
			last = last.next;
//			System.out.println(last.data);
		}
		last.next = null;

	}
// reverse a linked list 

// just to sort the linked list
	public boolean compareTwoValues(Type value1, Type value2) {

		return value1.compareTo(value2) < 0;
	}

	////////////// Sorting function////////////////////

	public Node<Type> findMid(Node<Type> head) {
		Node<Type> slow = head;
		Node<Type> fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	@SuppressWarnings("unchecked")
	public Node<Type> merge(Node<Type> left, Node<Type> right) {
		@SuppressWarnings("rawtypes")
		Node<Type> merged = new Node(-1);
		Node<Type> temp = merged;
		while (left != null && right != null) {
			if (compareTwoValues(left.data, right.data)) {
				temp.next = left;
				left = left.next;
				temp = temp.next;
			} else {
				temp.next = right;
				right = right.next;
				temp = temp.next;
			}
		}
		if (left != null)
			temp.next = left;
		if (right != null)
			temp.next = right;
		return merged.next;
	}

	public Node<Type> Sort(Node<Type> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<Type> mid = findMid(head);
		Node<Type> nextToMid = mid.next;
		mid.next = null;
		Node<Type> left = Sort(head);
		Node<Type> right = Sort(nextToMid);
		Node<Type> merged = merge(left, right);

		this.head = merged;
		return this.head;
	}
	/////////////////// Sorting function End////////////////

	public void reverse(Node<Type> head) {
		Node<Type> last = null;
		Node<Type> current = head;
		Node<Type> prev = null;
		while (current != null) {
			last = current.next;
			current.next = prev;
			prev = current;
			current = last;

		}
		this.head = prev;

	}

// find the center of a linked list
	public void center() {
		Node<Type> slow = head;
		Node<Type> fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println(slow.data);

	}

// Iterable forced a method which is necessary to be override

	@Override
	public Iterator<Type> iterator() {

		return new MyIterator();

	}
//creating an iterator 

	public class MyIterator implements Iterator<Type> {

		Node<Type> current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Type next() {

			Type data = current.data;
			current = current.next;
			return data;

		}

	}

}
