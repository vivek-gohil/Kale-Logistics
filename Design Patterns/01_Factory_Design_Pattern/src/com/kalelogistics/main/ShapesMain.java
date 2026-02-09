package com.kalelogistics.main;

import java.util.Scanner;

import com.kalelogistics.main.domain.Shapes;
import com.kalelogistics.main.factory.ShapesFactory;

public class ShapesMain {
	public static void main(String[] args) {
		Shapes shapes = null;
		Scanner scanner = new Scanner(System.in);

		System.out.println("1. Draw Circle");
		System.out.println("2. Draw Ractangle");
		System.out.println("3. Draw Triangle");
		System.out.println("Enter your choice");
		int choice = scanner.nextInt();

		shapes = ShapesFactory.getShape(choice);

		if (shapes != null) {
			shapes.draw();
		}
		scanner.close();
	}
}
