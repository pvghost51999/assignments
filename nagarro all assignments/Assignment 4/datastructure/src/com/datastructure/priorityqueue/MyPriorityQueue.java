package com.datastructure.priorityqueue;

import java.util.ArrayList;
import java.util.Iterator;

public class MyPriorityQueue<Type extends Comparable<? super Type>> implements Iterable<Type> {

	ArrayList<Type> pqueue = new ArrayList<Type>();

	// swap function to swap values in an Arraylist
	public ArrayList<Type> swap(ArrayList<Type> l, Integer i, Integer j) {
		Type temp = l.get(i);
		l.set(i, l.get(j));
		l.set(j, temp);
		return l;
	}

	// to Compare generic types
	public boolean compareTwoValues(Type value1, Type value2) {

		return value1.compareTo(value2) < 0;
	}

// will add according to max heap and binary tree
	public void Equeue(Type data) {

		int i = pqueue.size();
		if (i == 0) {
			pqueue.add(data);
			return;
		}
		pqueue.add(data);
		while (i > 0) {
			if (compareTwoValues(pqueue.get(i / 2), pqueue.get(i))) {
				pqueue = swap(pqueue, i, i / 2);

			} else {
				break;
			}
			i = i / 2;
		}
	}

// will remove the highest priority
	public Type Dequeue() {
		int n = pqueue.size();
		if (pqueue.isEmpty()) {
			System.out.println("Priority Queue is empty");
			return null;
		}
		if (n == 1) {
			pqueue.remove(0);
			return null;
		}
		pqueue = swap(pqueue, 0, n - 1);
		Type stored = pqueue.get(n - 1);
		pqueue.remove(n - 1);
		if (pqueue.size() == 0)
			return stored;
		if (compareTwoValues(pqueue.get(0), stored))
			upheapify(pqueue, pqueue.size(), 0);
		else {
			downheapify(0);
		}
		return stored;

	}

	// this downheapify method is used to convert list into max heap
	private void downheapify(int pi) {
		int n = pqueue.size();
		int mini = pi;

		int l = 2 * pi + 1;
		if (l < n && compareTwoValues(pqueue.get(l), pqueue.get(mini)))
			mini = l;
		int r = 2 * pi + 2;
		if (r < n && compareTwoValues(pqueue.get(r), pqueue.get(mini)))
			mini = r;

		if (mini != pi) {
			pqueue = swap(pqueue, pi, mini);
			downheapify(mini);
		}
	}

	// this upheapify method is used to convert list into min heap
	private void upheapify(ArrayList<Type> pqueue, int n, int pi) {
		int mini = pi;

		int l = 2 * pi + 1;
		if (l < n && compareTwoValues(pqueue.get(mini), pqueue.get(l)))
			mini = l;
		int r = 2 * pi + 2;
		if (r < n && compareTwoValues(pqueue.get(mini), pqueue.get(r)))
			mini = r;

		if (mini != pi) {
			pqueue = swap(pqueue, pi, mini);
			upheapify(pqueue, n, mini);
		}

	}

// will give the highest priority value
	public Type peek() {
		if (pqueue.size() == 0) {
			System.out.println("Priority queue is Empty");
			return null;
		}
		return pqueue.get(0);
	}

// will print the priority queue
	public void print() {
		System.out.println(pqueue);
	}

// will print the size of priority queue
	public Integer size() {
		return pqueue.size();
	}

// will give the center element
	public Type center() {
		return pqueue.get(pqueue.size() / 2);
	}

// it will reverse to min heap 
	public void reverse() {
		int n = pqueue.size();
		for (int i = n / 2; i >= 0; i--) {
			upheapify(pqueue, n, i);
		}
	}

// to check whether the element is present or not
	public boolean contains(Type data) {
		for (int i = 0; i < pqueue.size(); i++) {
			if (compareTwoValues(pqueue.get(i), data)) {
				return true;
			}

		}
		return false;

	}

	@Override
	public Iterator<Type> iterator() {

		return new MyIterator();
	}

	public class MyIterator implements Iterator<Type> {
		int count = 0;

		@Override
		public boolean hasNext() {

			return count < pqueue.size();
		}

		@Override
		public Type next() {
			Type temp = pqueue.get(count);
			count += 1;
			return temp;
		}

	}

}
