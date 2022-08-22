package com.datastructure.queue;

import java.util.Iterator;

public class MyQueue<Type extends Comparable<? super Type>> implements Iterable<Type> {

	public Node<Type> head;

	public class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public boolean isEmplty() {
		if (head == null) {
			return false;
		}
		return true;
	}

	public void enqueue(Type data) {
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

// to remove the first value on the top
	public Type dequeue() {
		if (isEmplty()) {
			Type value = head.data;
			head = head.next;
			return value;
		}
		System.out.println("Stack is empty");
		return null;

	}

	// peek operation to look to the first value on the stack
	public Type peek() {
		if (isEmplty()) {
			Type value = head.data;
			return value;
		}
		System.out.println("Stack is empty");
		return null;
	}

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

	// contains will check whether the element is present or not
	public boolean contains(Type data) {
		Node<Type> current = head;
		while (current != null) {
			Type check = current.data;
			if (check.equals(data)) {
				return true;

			}
			current = current.next;
		}
		return false;
	}

	// use to traverse the stack
	public void traverse() {
		Node<Type> last = head;
		while (last != null) {

			System.out.print(last.data + " ");
			last = last.next;
		}
		System.out.println();

	}

	// will determine the length of an Stack
	public Integer size() {
		Node<Type> last = head;
		int count = 0;
		while (last != null) {
			last = last.next;
			count += 1;
		}
		return count;
	}

	// will reverse the stack;
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
	// will find the center of Stack

	public void center() {
		Node<Type> slow = head;
		Node<Type> fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println(slow.data);

	}

	@Override
	public Iterator<Type> iterator() {

		return new MyIterator();
	}

// It is an iterator which will move to next and check the next value
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
