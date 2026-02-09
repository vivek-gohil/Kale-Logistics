package com.kalelogistics.main.domain;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
	private List<Observer> observers = new ArrayList<Observer>();

	public void subscribe(Observer observer) {
		observers.add(observer);
	}

	public void noftifySubscrobers(String message) {
		for (Observer observer : observers) {
			observer.update(message);
		}
	}
}
