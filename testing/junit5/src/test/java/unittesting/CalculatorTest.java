package unittesting;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@Nested
	class AddTest {
		@Test
		@DisplayName("Testing add method +")
		void testAddPositive() {
			assertEquals(5, calculator.add(2, 3), "Should add two numbers");

		}

		@Test
		@DisplayName("Testing add method -")
		void testAddNegative() {
			assertEquals(-5, calculator.add(-2, -3), "Should add two numbers");

		}

		@DisplayName("Repeated Test")
		@RepeatedTest(5)
		void testAddMultipleTimes() {

		}
	}

	@Test
	void testDivide_throwsArithmeticException() {
		assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "divide by 0 throws exception");
	}

	@Test
	@DisplayName("AssertAll With multiply")
	void testMultiply() {
		assertAll(() -> assertEquals(3, calculator.multiply(3, 1)), () -> assertEquals(0, calculator.multiply(3, 0)),
				() -> assertEquals(6, calculator.multiply(2, 3)));
	}

	@Test
	@Disabled
	void testDisable() {
		fail("Test skipping test");
	}

	@Test
	@EnabledOnOs(OS.LINUX)
	void testEnableOnOS() {
		assertTrue(true);
	}

	@Test
	@EnabledOnJre(JRE.JAVA_8)
	void testEnableOnJre() {
		assertTrue(true);
	}

	@Test
	@Disabled
	@EnabledIf(value = "test")
	void testEnableOnIf() {
		assertEquals("test", "test");
	}

	@Test
	void testIterableEqual() {
		List<Integer> array1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> array2 = Arrays.asList(1, 2, 3, 4, 5);
		assertArrayEquals(array1.toArray(), array2.toArray());

		assertIterableEquals(array1, array2);
	}
}
