
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import Polynomial.Polynomial;

class OperationTest {

	@org.junit.jupiter.api.Test
	void testAdd() {

		HashMap<Integer, Double> pol1 = new HashMap<Integer, Double>();
		pol1.put(2, 2.0);
		pol1.put(1, 1.5);
		pol1.put(0, 3.6);
		HashMap<Integer, Double> pol2 = new HashMap<Integer, Double>();
		pol2.put(2, 2.0);
		pol2.put(1, 2.5);
		pol2.put(0, 3.4);
		HashMap<Integer, Double> pol3 = new HashMap<Integer, Double>();
		pol3.put(2, 4.0);
		pol3.put(1, 4.0);
		pol3.put(0, 7.0);
		Polynomial polinom1 = new Polynomial(pol1);
		Polynomial polinom2 = new Polynomial(pol2);

		assertEquals(polinom1.addPolynomials(polinom2), pol3);
	}

	@org.junit.jupiter.api.Test
	void testSub() {

		HashMap<Integer, Double> pol1 = new HashMap<Integer, Double>();
		pol1.put(2, 3.0);
		pol1.put(1, 1.5);
		pol1.put(0, 3.6);
		HashMap<Integer, Double> pol2 = new HashMap<Integer, Double>();
		pol2.put(2, 2.0);
		pol2.put(1, 2.5);
		pol2.put(0, 3.1);
		HashMap<Integer, Double> pol3 = new HashMap<Integer, Double>();
		pol3.put(2, 1.0);
		pol3.put(1, -1.0);
		pol3.put(0, 0.5);
		Polynomial polinom1 = new Polynomial(pol1);
		Polynomial polinom2 = new Polynomial(pol2);

		assertEquals(polinom1.subPolynomials(polinom2), pol3);
	}

	@org.junit.jupiter.api.Test
	void testMul() {

		HashMap<Integer, Double> pol1 = new HashMap<Integer, Double>();
		pol1.put(2, 3.0);
		pol1.put(1, 2.0);
		pol1.put(0, 3.6);
		HashMap<Integer, Double> pol2 = new HashMap<Integer, Double>();
		pol2.put(2, 2.0);
		pol2.put(1, 2.5);
		pol2.put(0, 3.0);
		HashMap<Integer, Double> pol3 = new HashMap<Integer, Double>();
		pol3.put(4, 6.0);
		pol3.put(3, 11.5);
		pol3.put(2, 21.2);
		pol3.put(1, 15.0);
		pol3.put(0, 10.8);
		Polynomial polinom1 = new Polynomial(pol1);
		Polynomial polinom2 = new Polynomial(pol2);

		assertEquals(polinom1.multiplyPolynomials(polinom2), pol3);
	}

	@org.junit.jupiter.api.Test
	void testDiv() {

		HashMap<Integer, Double> pol1 = new HashMap<Integer, Double>();
		pol1.put(2, 3.0);
		pol1.put(1, 2.0);
		pol1.put(0, 3.6);
		HashMap<Integer, Double> pol2 = new HashMap<Integer, Double>();
		pol2.put(2, 2.0);
		pol2.put(1, 2.5);
		pol2.put(0, 3.0);
		HashMap<Integer, Double> pol3 = new HashMap<Integer, Double>();

		pol3.put(0, 1.5);
		Polynomial polinom1 = new Polynomial(pol1);
		Polynomial polinom2 = new Polynomial(pol2);

		assertEquals(polinom1.dividePolynomials(polinom2), pol3);
	}

	@org.junit.jupiter.api.Test
	void testIntegrare() {

		HashMap<Integer, Double> pol1 = new HashMap<Integer, Double>();
		pol1.put(3, 3.0);
		pol1.put(1, 2.0);
		pol1.put(0, 3.6);

		HashMap<Integer, Double> pol3 = new HashMap<Integer, Double>();

		pol3.put(1, 3.6);
		pol3.put(2, 1.0);
		pol3.put(4, 0.75);
		Polynomial polinom1 = new Polynomial(pol1);

		assertEquals(polinom1.IntegralPolynomials(), pol3);
	}

	@org.junit.jupiter.api.Test
	void testDerivare() {

		HashMap<Integer, Double> pol1 = new HashMap<Integer, Double>();
		pol1.put(3, 2.0);
		pol1.put(1, 2.0);
		pol1.put(0, 3.6);

		HashMap<Integer, Double> pol3 = new HashMap<Integer, Double>();

		pol3.put(0, 2.0);
		pol3.put(2, 6.0);

		Polynomial polinom1 = new Polynomial(pol1);

		assertEquals(polinom1.derivativePolynomials(), pol3);
	}

	@org.junit.jupiter.api.Test
	void testToString() {

		HashMap<Integer, Double> pol1 = new HashMap<Integer, Double>();
		pol1.put(3, 2.0);
		pol1.put(1, 1.7);
		pol1.put(0, -3.6);
		Polynomial polinom1 = new Polynomial(pol1);
		String str = "";
		str = polinom1.toString();
		assertEquals("-3.6+1.7x+2.0x^3", str);

	}

}