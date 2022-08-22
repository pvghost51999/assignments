package com.advancejava2.application;

import com.advancejava2.searchdata.SearchData;

public class Application {
	public static void main(String[] args) {

		SearchData sd = new SearchData();
		Thread th = new Thread(sd);
		th.start();
	}

}
