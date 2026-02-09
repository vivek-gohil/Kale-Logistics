package com.kalelogistics.main.domain;

public class PlainPizza implements Pizza {

	@Override
	public String getDescription() {
		return "Plain pizza";
	}

	@Override
	public int getCost() {
		return 100;
	}

}
