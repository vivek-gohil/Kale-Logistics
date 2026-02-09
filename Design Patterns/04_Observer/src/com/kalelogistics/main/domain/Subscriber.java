package com.kalelogistics.main.domain;

public class Subscriber implements Observer {
	public String name;

	public Subscriber(String name) {
		super();
		this.name = name;
	}

	public void update(String message) {
		System.out.println(name + " received :: " + message);
	}
}
