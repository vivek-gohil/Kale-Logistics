package com.kalelogistics.main;

import com.kalelogistics.main.domain.Publisher;
import com.kalelogistics.main.domain.Subscriber;

public class ObserverMain {
	public static void main(String[] args) {
		// Creating publisher
		Publisher publisher = new Publisher();

		// Creating multiple subscriber
		Subscriber subscriber1 = new Subscriber("Vivek");
		Subscriber subscriber2 = new Subscriber("Atharva");

		// subscribers will subscribe publisher
		publisher.subscribe(subscriber1);
		publisher.subscribe(subscriber2);

		publisher.noftifySubscrobers("New vedio is updated!!");

	}
}
