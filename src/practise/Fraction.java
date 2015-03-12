package practise;

import java.math.BigInteger;

public class Fraction {

	private int m_numerator;
	private int m_denomenator;
	
	public static final Fraction ZERO_FRACTION = new Fraction(0, 1);
	
	public Fraction(int numerator, int denomenator) throws ArithmeticException {
		if(0 == denomenator) {
			throw new ArithmeticException("Attempt to Divide by Zero !!!");
		}
		setNumerator(numerator);
		setDenomenator(denomenator);
	}

	public int getNumerator() {
		return m_numerator;
	}

	public void setNumerator(int m_numerator) {
		this.m_numerator = m_numerator;
	}

	public int getDenominator() {
		return m_denomenator;
	}

	public void setDenomenator(int m_denomenator) {
		this.m_denomenator = m_denomenator;
	}

	public Fraction add(Fraction f) {
		return additionSubtractionUtil(f, true);
	}
	
	public Fraction subtract(Fraction f) {
		return additionSubtractionUtil(f, false);
	}
	
	public Fraction multiply(Fraction f) {

		if (f == null) {
            throw new IllegalArgumentException("Multiplying with a null is not permitted !!!");
        }
        if(this.getNumerator() == 0 || f.getNumerator() == 0) {
            return ZERO_FRACTION;
        }

        // this is to make sure that the values will not overflow unless they are supposed to
        int gcd1 = greatestCommonDivisor(this.getNumerator(), f.getDenominator());
        int gcd2 = greatestCommonDivisor(f.getNumerator(), this.getDenominator());
        
        return getReducedFraction
            (multiplyAndCheckOverflow(this.getNumerator()/gcd1, f.getNumerator()/gcd2),
             multiplyAndCheckOverflow(this.getDenominator()/gcd2, f.getDenominator()/gcd1));
	}
	
	private Fraction getReducedFraction(int numerator, int denominator) {
		
		if (denominator == 0) {
            throw new ArithmeticException("Fraction cannot have a Zero denomenator !!!");
        }
        if (numerator==0) {
            return ZERO_FRACTION;
        }
        
        int gcd = greatestCommonDivisor(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        return new Fraction(numerator, denominator);
	}
	
	public Fraction divide(Fraction f) {
		if (f == null) {
            throw new IllegalArgumentException("Division by a Null Fraction is not permitted !!!");
        }
        if (f.getNumerator() == 0) {
            throw new ArithmeticException("Divide By Zero Fraction Exception !!!");
        }
        return multiply(f.invert());
	}
	
	public boolean equals(Fraction f) {
		
		if(f == null) {
			throw new IllegalArgumentException("Equals comparison cannot be done on a Null Fraction !!!");
		}
		
		return compareTo(f) == 0 ? true : false;
	}
	
	public boolean greaterThan(Fraction f) {
		
		if(f == null) {
			throw new IllegalArgumentException("Greater than comparison cannot be done on a Null Fraction !!!");
		}
		
		return compareTo(f) == 1 ? true : false;
	}
	
	public boolean lessThan(Fraction f) {
		
		if(f == null) {
			throw new IllegalArgumentException("Less Than comparison cannot be done on a Null Fraction !!!");
		}
		
		return compareTo(f) == -1 ? true : false;
	}

	private Fraction invert() {
		if (this.getNumerator() == 0) {
            throw new ArithmeticException("Cannot invert a Zero Fraction !!!");
        }
        if (this.getNumerator() == Integer.MIN_VALUE) {
            throw new ArithmeticException("Negation Overflow error !!!");
        }
        if (this.getNumerator() < 0) {
            return new Fraction(-this.getDenominator(), -this.getNumerator());
        } else {
            return new Fraction(this.getDenominator(), this.getNumerator());
        }
	}

	private int compareTo(Fraction f) {
		
		if (this == f) {
            return 0;
        }
        if (this.getNumerator() == f.getNumerator() && 
        		this.getDenominator() == f.getDenominator()) {
            return 0;
        }

        long v1 = (long) this.getNumerator() * (long) f.getDenominator();
        long v2 = (long) f.getNumerator() * (long) this.getDenominator();
        
        if (v1 == v2) {
            return 0;
        } else if (v1 < v2) {
            return -1;
        } else {
            return 1;
        }
	}
	
	private Fraction negate() {
		
		if (this.getNumerator() == Integer.MIN_VALUE) {
            throw new ArithmeticException("Integer Minimum Negation Overflow !!!");
        }
        return new Fraction(-this.getNumerator(), this.getDenominator());
    }

	private Fraction additionSubtractionUtil(Fraction f, boolean isAddition) {
		
		if (null == f) {
            throw new IllegalArgumentException("Cannot add/subtract a Fraction !!!");
        }
		if (0 == f.getNumerator()) {
            return this;
        } 		
		if (this.getNumerator() == 0) {
            return isAddition ? f : f.negate();
        }
            
        int gcd1 = greatestCommonDivisor(this.getDenominator(), f.getDenominator());
        if (1 == gcd1) {
        	// If no possible gcd, we just multiply and throw an exception in case of overflow
        	int v1 = multiplyAndCheckOverflow(this.getNumerator(), f.getDenominator());
            int v2 = multiplyAndCheckOverflow(f.getNumerator(), this.getDenominator());
            return new Fraction(
            			isAddition ? addAndCheckOverflow(v1, v2) : subtractAndCheckOverflow(v1, v2), 
            			multiplyAndCheckOverflow(this.getDenominator(), f.getDenominator())
            		);
        }

        // Keep this in mind to follow the next sequence of actions 
        // (a/b)+(c/d) = (a*d+b*c)/(b*d) = [((a*d+b*c)/gcd1)/gcd2]/[b*d/gcd1*gcd2]
        
        // normalizing the value in numerator using gcd1
        BigInteger v1 = BigInteger.valueOf(this.getNumerator()).multiply(BigInteger.valueOf(f.getDenominator()/gcd1));
        BigInteger v2 = BigInteger.valueOf(f.getNumerator()).multiply(BigInteger.valueOf(this.getDenominator()/gcd1));
        BigInteger num1 = isAddition ? v1.add(v2) : v1.subtract(v2);
        
        // further normalizing the numerator using next possible gcd
        int num1Mod = num1.mod(BigInteger.valueOf(gcd1)).intValue();
        int gcd2 = (num1Mod==0) ? gcd1 : greatestCommonDivisor(num1Mod, gcd1);

        // result is equal to (num1/gcd2) / (first.denomenator/gcd1)(second.denomenator/gcd2)
        BigInteger res = num1.divide(BigInteger.valueOf(gcd2));
        if (res.bitLength() > 31) {
            throw new ArithmeticException("Multiplication Overflow error !!!");
        }
        
		return new Fraction(res.intValue(), multiplyAndCheckOverflow(
				this.getDenominator() / gcd1, f.getDenominator() / gcd2));
        
	}

	private int subtractAndCheckOverflow(int v1, int v2) {
		long sub = v1-v2;
        if (sub < Integer.MIN_VALUE ||
            sub > Integer.MAX_VALUE) {
            throw new ArithmeticException("Integer Subtraction Overflow !!!");
        }
        return (int)sub;
	}

	private int addAndCheckOverflow(int v1, int v2) {
		long add = v1+v2;
        if (add < Integer.MIN_VALUE ||
            add > Integer.MAX_VALUE) {
            throw new ArithmeticException("Integer Addition Overflow !!!");
        }
        return (int)add;
	}

	private int multiplyAndCheckOverflow(int v1, int v2) throws ArithmeticException {
		long mul = v1*v2;
		if(mul < Integer.MIN_VALUE || mul > Integer.MAX_VALUE) {
			throw new ArithmeticException("Integer Multiplication Overflow  for { " + v1 + " } { " + v2 + " }");
		}
		return (int)mul;
	}

	private int greatestCommonDivisor(int v1, int v2) {

		BigInteger a = new BigInteger(new StringBuffer().append(v1).toString());
		BigInteger b = new BigInteger(new StringBuffer().append(v2).toString());
		BigInteger c = a.gcd(b);
		
		if (c.bitLength() > 31) {
            throw new ArithmeticException("Overflow during GCD computation !!!");
        }
		return c.intValue();
		
	}
	
}
