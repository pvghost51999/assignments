package com.datastructure.input;

import java.util.Scanner;

public class MainInput {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//////// LinkedList/////////////
//		Mylinkedlist<String> ll = new Mylinkedlist<String>();
//		int n = sc.nextInt();
//		for (int i = 0; i < n; i++) {
//			ll.add(sc.next());
//		}
//		ll.insert(5, 6);
//		ll.print();
//		ll.delete(5);
//		ll.reverse(ll.head);
//		ll.center();
//		ll.delete();
//		ll.Sort(ll.head);
//		ll.print();
//		ll.size();
//		System.out.println(ll.size());
//
//		Mylinkedlist<String>.MyIterator itr = ll.new MyIterator();
//		while (itr.hasNext()) {
//			String val = itr.next();
//			System.out.print(val + " ");
//		}
//

		///////////// stack/////////////
//		MyStack<Integer> stac = new MyStack<Integer>();
//		int n = sc.nextInt();
//		for (int i = 0; i < n; i++) {
//			stac.push(sc.nextInt());
//		}

//		while (stac.isEmplty()) {
//			System.out.println(stac.peek());
//			stac.pop();
//		}
//		stac.Sort(stac.head);
//		stac.traverse();
//		stac.traverse();
//		stac.peek();
//		System.out.println(stac.pop());
//
//		if (stac.contains(356)) {
//			System.out.println("True");
//		} else {
//			System.out.println("Not present");

//		MyStack<Integer>.Myiterator itr = ll.new Myiterator();
//		while (itr.hasNext()) {
//			Integer val = itr.next();
//			System.out.println(val);
//
//		}

		///////////// Queue/////////////
//		MyQueue<Integer> que = new MyQueue<Integer>();
//		int n = sc.nextInt();
//		for (int i = 0; i < n; i++) {
//			que.enqueue(sc.nextInt());
//		}
//		que.traverse();
//		que.Sort(que.head);
//		que.traverse();

		//////// Priority queue/////////
//		MyPriorityQueue<String> val = new MyPriorityQueue<String>();
//		int n = sc.nextInt();
//		
//		for (int i = 0; i < n; i++) {
//			val.Equeue(sc.next());
//		}

//		val.reverse();
//		val.print();
//		for (int i = 0; i < n; i++) {
//			System.out.println(val.Dequeue());
//		}
//		System.out.println(val.contains("e"));

//		MyPriorityQueue.MyIterator itr = ll.new MyIterator();
//		while (itr.hasNext()) {
//			int tem = itr.next();
//			System.out.println(tem);
//		}

//		val.print();

		///////////////////// HashTable//////////////////

//		MyHashTable<Integer, String> hash = new MyHashTable<Integer, String>();
//		int value = sc.nextInt();
//		for (int i = 0; i < value; i++) {
//
//			hash.insert(sc.nextInt(), sc.next());
//
//		}
//
//		hash.print();
//
//		MyHashTable<Integer, String>.MyIterator itr = hash.new MyIterator();
//		while (itr.hasNext()) {
//			String val = itr.next();
//			System.out.print(val + " ");
//		}
//
		sc.close();

	}

}
