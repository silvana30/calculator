package pt.assign1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynom {
	public List<Monom> terms;

	public Polynom() {
		super();
		terms = new ArrayList<Monom>();

	}

	public Polynom(String input) {

		terms = new ArrayList<Monom>();
		Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
		Matcher m = p.matcher(input);

		while (m.find()) {
			Monom monom = new Monom();
			String coeff = m.group(1);
			String power = m.group(2);
			monom.coeff = Double.parseDouble(coeff);
			monom.power = Integer.parseInt(power);
			addTerm(monom);
		}

	}

	public void addTerm(Monom t) {

		boolean ok = false;
		for (Monom n : terms) {
			if (n.power == t.power) {
				n.coeff += t.coeff;
				ok = true;
				break;
			}

		}
		if (ok == false) {
			terms.add(t);

		}

	}

	public Polynom copy() {
		Polynom p = new Polynom();
		for (Monom n : terms) {
			p.addTerm(new Monom(n.coeff, n.power));
		}
		return p;
	}

	@Override
	public String toString() {
		String polyS = "";
		if (terms.isEmpty()) {
			return ("err");
		} else
			for (Monom m : terms) {

				polyS = polyS + m.toString();
			}
		return polyS;
	}

	public int getDegree() {
		// TODO Auto-generated method stub

		int max = 0;
		for (Monom n : terms) {
			if (n.power > max) {
				max = n.power;
			}
		}
		return max;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((terms == null) ? 0 : terms.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polynom other = (Polynom) obj;
		if (terms == null) {
			if (other.terms != null)
				return false;
		} else if (!terms.equals(other.terms))
			return false;
		return true;
	}

}
