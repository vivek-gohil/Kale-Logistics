package com.kalelogistics.main.domain;

public class CornDecorator extends PizzaDecorator {

	public CornDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Corn";
	}

	@Override
	public int getCost() {
		return pizza.getCost() + 30;
	}

}
