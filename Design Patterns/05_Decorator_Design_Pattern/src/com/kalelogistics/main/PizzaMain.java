package com.kalelogistics.main;

import com.kalelogistics.main.domain.PaneerDecorator;
import com.kalelogistics.main.domain.Pizza;
import com.kalelogistics.main.domain.PlainPizza;
import com.kalelogistics.main.domain.TomatoDecorator;

public class PizzaMain {
	public static void main(String[] args) {
		Pizza pizza = new PlainPizza();
		System.out.println(pizza.getDescription() + " = Rs: " + pizza.getCost());

		System.out.println("Adding Tomato toppings");
		pizza = new TomatoDecorator(pizza);

//		System.out.println("Adding Corn toppings");
//		pizza = new CornDecorator(pizza);

		System.out.println("Adding Panner toppings");
		pizza = new PaneerDecorator(pizza);

		System.out.println("After adding toppings");
		System.out.println(pizza.getDescription() + " = Rs: " + pizza.getCost());

	}
}
