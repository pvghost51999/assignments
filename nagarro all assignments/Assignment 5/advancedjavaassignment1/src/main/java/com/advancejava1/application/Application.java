package com.advancejava1.application;

import com.advancejava1.searchdata.SearchData;

public class Application {
	public static void main(String[] args) {

		SearchData sd = new SearchData();
		Thread th = new Thread(sd);
		th.start();
	}

}
