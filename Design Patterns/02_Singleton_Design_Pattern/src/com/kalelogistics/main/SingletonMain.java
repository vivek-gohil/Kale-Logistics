package com.kalelogistics.main;

import com.kalelogistics.main.domain.Singleton;

public class SingletonMain {
	public static void main(String[] args) {
		//Only object can be created and shared with multiple references 
		Singleton singletonObject1 = Singleton.getInstance();
		Singleton singletonObject2 = Singleton.getInstance();
		Singleton singletonObject3 = Singleton.getInstance();

		System.out.println(singletonObject1.hashCode());
		System.out.println(singletonObject2.hashCode()); // same hashcode
		System.out.println(singletonObject3.hashCode());
		
		System.out.println(singletonObject1.equals(singletonObject2));

	}
}
