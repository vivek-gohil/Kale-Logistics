package com.kalelogistics.main.domain;

public class TomatoDecorator extends PizzaDecorator {

	public TomatoDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Tomato";
	}

	@Override
	public int getCost() {
		return pizza.getCost() + 20;
	}

}
