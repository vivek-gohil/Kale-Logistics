package com.kalelogistics.main.domain;

public class PaneerDecorator extends PizzaDecorator {

	public PaneerDecorator(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Paneer";
	}

	@Override
	public int getCost() {
		return pizza.getCost() + 40;
	}

}
