package pt.assign1.logic;

import pt.assign1.model.*;

public class Operation {

	public static Polynom addPoly(Polynom p1, Polynom p2) {

		Polynom p1Copy;
		p1Copy = p1.copy();
		Polynom p2Copy;
		p2Copy = p2.copy();
		for (Monom m : p2Copy.terms) {
			p1Copy.addTerm(m);
		}

		return p1Copy;
	}

	public static Polynom subPoly(Polynom p1, Polynom p2) {

		Polynom p1Copy;
		p1Copy = p1.copy();
		Polynom p2Copy;
		p2Copy = p2.copy();
		for (Monom m : p2Copy.terms) {
			m.coeff = (-1) * m.coeff;
			p1Copy.addTerm(m);
		}

		return p1Copy;
	}

	public static Polynom multiplyPoly(Polynom p1, Polynom p2) {

		Polynom p1Copy;
		p1Copy = p1.copy();
		Polynom p2Copy;
		p2Copy = p2.copy();
		Polynom res = new Polynom();

		for (Monom m : p1Copy.terms) {
			for (Monom m2 : p2Copy.terms) {

				double c = m.coeff * m2.coeff;
				int pow = m.power + m2.power;
				Monom mon = new Monom(c, pow);
				res.addTerm(mon);

			}

		}

		return res;
	}

	public static Polynom dividePoly(Polynom p1, Polynom p2) {

		Polynom p1Copy;
		p1Copy = p1.copy();
		Polynom p2Copy;
		p2Copy = p2.copy();

		// Polynom dividend = p1.copy();
		// Polynom divisor = p2.copy();
		Polynom quotient = new Polynom();
		Polynom remainder = new Polynom();
		// Polynom rez= new Polynom();

		Polynom auxP;
		Monom auxM = new Monom();
		// int i = 0;

		if (p1.toString().equals(p2.toString())) {
			quotient.addTerm(new Monom(1, 0));
			remainder.addTerm(new Monom(0, 0));
		} else {
			while (!p1Copy.terms.isEmpty() && !p2Copy.terms.isEmpty() && p1Copy.getDegree() >= p2Copy.getDegree()) {
				// auxM = Monom.divideMonom(p1Copy.terms.get(i),
				// p2Copy.terms.get(0));
				auxM = new Monom(p1Copy.terms.get(0).coeff / p2Copy.terms.get(0).coeff,
						p1Copy.terms.get(0).power - p2Copy.terms.get(0).power);

				quotient.addTerm(auxM);
				auxP = new Polynom();
				auxP.addTerm(auxM);
				auxP = Operation.multiplyPoly(p2Copy, auxP);
				p1Copy = Operation.subPoly(p1Copy, auxP);
				// i+=1;

			}

			remainder = p1Copy.copy();
		}
		// Operation.addPoly(rez, quotient);
		// Operation.addPoly(rez, remainder);
		// rez.add(quotient);
		// rez.add(remainder);

		return quotient;
	}

	public static Polynom derivePoly(Polynom p1) {

		Polynom p1Copy;
		p1Copy = p1.copy();

		for (Monom m : p1Copy.terms) {
			m.coeff *= m.power;
			m.power -= 1;
		}

		return p1Copy;
	}

	public static Polynom integratePoly(Polynom p1) {

		Polynom p1Copy;
		p1Copy = p1.copy();

		for (Monom m : p1Copy.terms) {
			m.power += 1;
			m.coeff /= m.power;
		}

		return p1Copy;
	}

}
