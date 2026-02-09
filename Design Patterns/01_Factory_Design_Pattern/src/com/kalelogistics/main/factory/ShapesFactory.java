package com.kalelogistics.main.factory;

import com.kalelogistics.main.domain.Circle;
import com.kalelogistics.main.domain.Rectangle;
import com.kalelogistics.main.domain.Shapes;
import com.kalelogistics.main.domain.Triangle;

public class ShapesFactory {
	public static Shapes getShape(int choice) {
		switch (choice) {
		case 1:
			return new Circle();
		case 2:
			return new Rectangle();
		case 3:
			return new Triangle();
		default:
			return null;
		}
	}
}
