package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, 
			boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
					.isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argsForExponentMethod")
	void assertThatBaseNumRaisedToExponentCorrectly(int base, int exponent, int expected, 
			boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.returnNumRaisedToExponent(base, exponent)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.returnNumRaisedToExponent(base, exponent))
					.isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	static Stream<Arguments> argsForAddPositive() {
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(-1, -1, -2, true),
				arguments(0, 0, 0, true),
				arguments(-1, 4, 3, true),
				arguments(0, 4, 4, true),
				arguments(-1, 0, -1, true)
				);
	}
	
	static Stream<Arguments> argsForExponentMethod() {
		return Stream.of(
				arguments(4, 4, 256, false),
				arguments(9, 5, 59049, false),
				arguments(1, 0, 1, false),
				arguments(2, -1, 1/2, true),
				arguments(0, 0, 1, false)
				);
	}

}
