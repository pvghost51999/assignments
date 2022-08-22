package com.datastructure.hashtable;

import java.util.Iterator;

public class MyHashTable<K, V> implements Iterable<V> {

	Node<K, V> head;

	public class Node<Key, Val> {
		Key key;
		Val value;
		Node<Key, Val> next;

		public Node(Key key, Val value) {
			this.key = key;
			this.value = value;
			next = null;
		}

	}

// to check whether the key exists or not
	public boolean contains(K key) {
		Node<K, V> temp = head;
		while (temp != null) {
			if (temp.key.equals(key))
				return true;
			temp = temp.next;
		}
		return false;

	}

	// to insert a key into the hash table
	public void insert(K key, V value) {
		Node<K, V> store = new Node<K, V>(key, value);
//		
		if (head == null) {
			head = store;
			return;
		}

		Node<K, V> temp = head;

		while (temp.next != null) {
			if (temp.key.equals(store.key)) {
				temp.value = value;
				return;
			}

			temp = temp.next;
		}
		if (head.key.equals(key)) {
			temp.value = value;
			return;
		}
		temp.next = store;
//		System.out.println();
	}

// to print the value 
	public void print() {
		Node<K, V> temp = head;
		System.out.print("{");
		while (temp.next != null) {

			System.out.print(temp.key + "=" + temp.value + ", ");
			temp = temp.next;
		}
		System.out.print(temp.key + "=" + temp.value + "}");
		System.out.println();
	}

// to get a value by key
	public V get(K key) {
		Node<K, V> temp = head;
		while (temp != null) {
			if (temp.key.equals(key)) {
				return temp.value;
			}
			temp = temp.next;

		}
		System.out.println("No key exists");
		return null;
	}

// length of hashtable
	public Integer size() {
		int count = 0;
		Node<K, V> temp = head;
		while (temp != null) {
			count += 1;
			temp = temp.next;
		}
		return count;
	}

	// to delete a key
	public void delete(K key) {
		if (head.key.equals(key)) {
			head = head.next;
			return;
		}
		System.out.println(key);
		if (contains(key)) {
			Node<K, V> temp = head;
			while (!temp.next.key.equals(key)) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		} else {
			System.out.println("Key is not present");
		}
	}

	@Override
	public Iterator<V> iterator() {
		return new MyIterator();
	}

	public class MyIterator implements Iterator<V> {

		Node<K, V> current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public V next() {
			V value = current.value;
			current = current.next;
			return value;
		}

	}

}
