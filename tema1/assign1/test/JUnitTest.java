package pt.assign1.test;

import org.junit.Test;

import org.junit.*;

import pt.assign1.logic.Operation;
import pt.assign1.model.Monom;
import pt.assign1.model.Polynom;

public class JUnitTest {

	private final Operation calculator = new Operation();

	public JUnitTest() {
		System.out.println("Testing...");
	}

	@Test
	public void add() throws Exception {
		// x^2 + x -1

		Monom term11 = new Monom(1, 2);
		Monom term12 = new Monom(1, 1);
		Monom term13 = new Monom(-1, 0);

		Polynom p1 = new Polynom();
		p1.addTerm(term11);
		p1.addTerm(term12);
		p1.addTerm(term13);

		// -6x + x^2 + 8

		Monom term21 = new Monom(-6, 1);
		Monom term22 = new Monom(1, 2);
		Monom term23 = new Monom(8, 0);

		Polynom p2 = new Polynom();
		p2.addTerm(term21);
		p2.addTerm(term22);
		p2.addTerm(term23);

		Polynom actual = Operation.addPoly(p1, p2);

		// 2x^2 -5x +7
		Monom expectedTerm1 = new Monom(2, 2);
		Monom expectedTerm2 = new Monom(-5, 1);
		Monom expectedTerm3 = new Monom(7, 0);

		Polynom expected = new Polynom();
		expected.addTerm(expectedTerm1);
		expected.addTerm(expectedTerm2);
		expected.addTerm(expectedTerm3);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void substract() throws Exception {
		// x^2 + x -1

		Monom term11 = new Monom(1, 2);
		Monom term12 = new Monom(1, 1);
		Monom term13 = new Monom(-1, 0);

		Polynom p1 = new Polynom();
		p1.addTerm(term11);
		p1.addTerm(term12);
		p1.addTerm(term13);

		// -6x + x^2 + 8

		Monom term21 = new Monom(-6, 1);
		Monom term22 = new Monom(1, 2);
		Monom term23 = new Monom(8, 0);

		Polynom p2 = new Polynom();
		p2.addTerm(term21);
		p2.addTerm(term22);
		p2.addTerm(term23);

		Polynom actual = Operation.subPoly(p1, p2);

		// 0 +7x -9
		Monom expectedTerm1 = new Monom(0, 2);
		Monom expectedTerm2 = new Monom(7, 1);
		Monom expectedTerm3 = new Monom(-9, 0);

		Polynom expected = new Polynom();
		expected.addTerm(expectedTerm1);
		expected.addTerm(expectedTerm2);
		expected.addTerm(expectedTerm3);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void multiply() throws Exception {
		// x^2 + x -1

		Monom term11 = new Monom(1, 2);
		Monom term12 = new Monom(1, 1);
		Monom term13 = new Monom(-1, 0);

		Polynom p1 = new Polynom();
		p1.addTerm(term11);
		p1.addTerm(term12);
		p1.addTerm(term13);

		// -6x + x^2 + 8

		Monom term21 = new Monom(-6, 1);
		Monom term22 = new Monom(1, 2);
		Monom term23 = new Monom(8, 0);

		Polynom p2 = new Polynom();
		p2.addTerm(term21);
		p2.addTerm(term22);
		p2.addTerm(term23);

		Polynom actual = Operation.multiplyPoly(p1, p2);

		// -6x^3 +x^4 +8x^2 -6x^2 +x^3 +8x +6x -x^2 -8=-5x^3 +x^4 +x^2 +14x -8
		Monom expectedTerm1 = new Monom(-5, 3);
		Monom expectedTerm2 = new Monom(1, 4);
		Monom expectedTerm3 = new Monom(1, 2);
		Monom expectedTerm4 = new Monom(14, 1);
		Monom expectedTerm5 = new Monom(-8, 0);

		Polynom expected = new Polynom();
		expected.addTerm(expectedTerm1);
		expected.addTerm(expectedTerm2);
		expected.addTerm(expectedTerm3);
		expected.addTerm(expectedTerm4);
		expected.addTerm(expectedTerm5);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void integrate() throws Exception {
		// 12x^3+ 3x^2 + x

		Monom term11 = new Monom(12, 3);
		Monom term12 = new Monom(3, 2);
		Monom term13 = new Monom(1, 1);

		Polynom p1 = new Polynom();
		p1.addTerm(term11);
		p1.addTerm(term12);
		p1.addTerm(term13);

		Polynom actual = Operation.integratePoly(p1);

		// 3x^4 +x^3 +0.5x^2
		Monom expectedTerm1 = new Monom(3, 4);
		Monom expectedTerm2 = new Monom(1, 3);
		Monom expectedTerm3 = new Monom(0.5, 2);

		Polynom expected = new Polynom();
		expected.addTerm(expectedTerm1);
		expected.addTerm(expectedTerm2);
		expected.addTerm(expectedTerm3);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void derive() throws Exception {
		// x^3 + 4x^2 -x

		Monom term11 = new Monom(1, 3);
		Monom term12 = new Monom(4, 2);
		Monom term13 = new Monom(-1, 1);

		Polynom p1 = new Polynom();
		p1.addTerm(term11);
		p1.addTerm(term12);
		p1.addTerm(term13);

		Polynom actual = Operation.derivePoly(p1);

		// 3x^2+ 8x -1
		Monom expectedTerm1 = new Monom(3, 2);
		Monom expectedTerm2 = new Monom(8, 1);
		Monom expectedTerm3 = new Monom(-1, 0);

		Polynom expected = new Polynom();
		expected.addTerm(expectedTerm1);
		expected.addTerm(expectedTerm2);
		expected.addTerm(expectedTerm3);

		Assert.assertEquals(expected, actual);
	}

}
