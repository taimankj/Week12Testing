package com.promineotech;

import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive");
		}
	}

	public int returnNumRaisedToExponent(int base, int exponent) {
		int num = base;

		if (exponent == 0) {
			return 1;
		} else if (exponent > 0) {
			while (exponent > 1) {
				num *= base;
				exponent--;
			}
			
			return num;
		} else {
			throw new IllegalArgumentException("Second argument must be greater than or equal to 0");
		}
	}
	
	public int randomNumberSquared() {
		int num = getRandomInt();
		return num * num;
	}

	@VisibleForTesting
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

}
