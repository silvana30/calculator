package pt.assign1.model;

public class Monom {

	public double coeff; // coef se poate modifica
	public int power;

	public Monom(double coeff, int power) {
		super();
		this.coeff = coeff;
		this.power = power;
	}

	public Monom() {
		super();
	}

	@Override
	public String toString() {

		if (coeff == 0)
			return ("" + 0 + "");
		if (power == 0) {
			if (coeff > 0)
				return (String.format(" + %.2f", coeff));
			else
				return (String.format(" %.2f", coeff));
		}

		if (power == 1) {
			if (coeff == 1)
				return " + " + "X" + " ";
			else if (coeff > 0)
				return (String.format(" + %.2fX", coeff));
			else
				return (String.format(" %.2fX", coeff));
		} else {
			if (coeff == 1)
				return " + " + "X^" + power + " ";
			else if (coeff > 0)
				return (String.format(" + %.2fX^%d", coeff, power));
			else
				return (String.format("%.2fX^%d", coeff, power));
		}
	}

	public Monom divideMonom(Monom monom, Monom monom2) {
		// TODO Auto-generated method stub

		monom.coeff /= monom2.coeff;
		monom.power -= monom2.power;
		return monom;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coeff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + power;
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
		Monom other = (Monom) obj;
		if (Double.doubleToLongBits(coeff) != Double.doubleToLongBits(other.coeff))
			return false;
		if (power != other.power)
			return false;
		return true;
	}
}
