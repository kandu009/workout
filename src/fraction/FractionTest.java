package fraction;

/**
 * 
 * @author rkandur
 * TestCases for the Fraction Class
 */
public class FractionTest {

	public static void main(String[] args) {
		try {
			runTestCases();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void assertEquals(Object v1, Object v2) throws Exception {
		if(!v1.equals(v2)) {
			throw new Exception("Assert Exception: Values [" + v1 + "] [" + v2 +"]");
		}
		System.out.println("Assert success for Values [" + v1 + "] [" + v2 +"]");
	}
	
	private static void runTestCases() throws Exception {
		
		runDisplayTests();
		runEqualsTests();
		
		runLessThanTests();
		runGreaterThanTests();
		
		runAdditionTests();
		runSubtractTests();
		
		runMultiplyTests();
		runDivideTests();
		
	}

	private static void runDisplayTests() {
		
		Fraction f1 = Fraction.ZERO_FRACTION;
		f1.display();
		
		Fraction f2 = new Fraction(2, 3);
		f2.display();
		
		Fraction f3 = new Fraction(Integer.MAX_VALUE, 3);
		f3.display();
		
		Fraction f4 = new Fraction(8, Integer.MAX_VALUE);
		f4.display();
		
		Fraction f5 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
		f5.display();
		
		Fraction f6 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
		f6.display();
		
	}

	private static void runEqualsTests() throws Exception {
		
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(4, 3);
		assertEquals(false, f1.equals(f2));
		
		Fraction f3 = new Fraction(2, 3);
		Fraction f4 = new Fraction(2, 3);
		assertEquals(true, f3.equals(f4));
		
		Fraction f5 = new Fraction(2, 3);
		Fraction f6 = new Fraction(4, 6);
		assertEquals(true, f5.equals(f6));
		
		Fraction f7 = new Fraction(-2, 3);
		Fraction f8 = new Fraction(4, 3);
		assertEquals(false, f7.equals(f8));
		
		Fraction f9 = new Fraction(2, 3);
		Fraction f10 = new Fraction(-4, 3);
		assertEquals(false, f9.equals(f10));
		
		Fraction f11 = new Fraction(-2, 3);
		Fraction f12 = new Fraction(-4, 6);
		assertEquals(true, f11.equals(f12));
		
		Fraction f13 = Fraction.ZERO_FRACTION;
		Fraction f14 = Fraction.ZERO_FRACTION;
		assertEquals(true, f14.equals(f13));
		
		Fraction f15 = new Fraction(-2, 3);
		Fraction f16 = Fraction.ZERO_FRACTION;
		assertEquals(false, f15.equals(f16));
		
		Fraction f17 = Fraction.ZERO_FRACTION;
		Fraction f18 = new Fraction(-3, 7);
		assertEquals(false, f18.equals(f17));
		
		Fraction f19 = new Fraction(Integer.MAX_VALUE, 3);
		Fraction f20 = new Fraction(8, Integer.MAX_VALUE);
		assertEquals(false, f19.equals(f20));
	
		Fraction f21 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
		Fraction f22 = new Fraction(8, Integer.MAX_VALUE);
		assertEquals(false, f21.equals(f22));
	
		Fraction f23 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
		Fraction f24 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
		assertEquals(false, f23.equals(f24));
	
		Fraction f25 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
		Fraction f26 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
		assertEquals(true, f25.equals(f26));
		
	}

	private static void runGreaterThanTests() throws Exception {
		
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(4, 3);
		assertEquals(false, f1.greaterThan(f2));
		
		Fraction f3 = new Fraction(2, 3);
		Fraction f4 = new Fraction(2, 3);
		assertEquals(false, f3.greaterThan(f4));
		
		Fraction f5 = new Fraction(2, 3);
		Fraction f6 = new Fraction(4, 6);
		assertEquals(false, f6.greaterThan(f5));
		
		Fraction f7 = new Fraction(-2, 3);
		Fraction f8 = new Fraction(4, 3);
		assertEquals(true, f8.greaterThan(f7));
		
		Fraction f9 = new Fraction(2, 3);
		Fraction f10 = new Fraction(-4, 3);
		assertEquals(true, f9.greaterThan(f10));
		
		Fraction f11 = new Fraction(-2, 3);
		Fraction f12 = new Fraction(-4, 6);
		assertEquals(false, f11.greaterThan(f12));
		
		Fraction f13 = new Fraction(-2, 3);
		Fraction f14 = new Fraction(-3, 7);
		assertEquals(true, f14.greaterThan(f13));
		
		Fraction f15 = new Fraction(-2, 3);
		Fraction f16 = Fraction.ZERO_FRACTION;
		assertEquals(false, f15.greaterThan(f16));
		
		Fraction f17 = Fraction.ZERO_FRACTION;
		Fraction f18 = new Fraction(-3, 7);
		assertEquals(false, f18.greaterThan(f17));
		
		Fraction f19 = Fraction.ZERO_FRACTION;
		Fraction f20 = new Fraction(3, 7);
		assertEquals(false, f19.greaterThan(f20));
		
		Fraction f21 = new Fraction(3, 7);
		Fraction f22 = Fraction.ZERO_FRACTION;
		assertEquals(false, f22.greaterThan(f21));
		
		Fraction f23 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
		Fraction f24 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
		assertEquals(false, f23.greaterThan(f24));
	
		Fraction f25 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
		Fraction f26 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
		assertEquals(false, f25.greaterThan(f26));
		
		Fraction f27 = new Fraction(Integer.MAX_VALUE, 3);
		Fraction f28 = new Fraction(8, Integer.MAX_VALUE);
		assertEquals(true, f27.greaterThan(f28));
	
		Fraction f29 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
		Fraction f30 = new Fraction(8, Integer.MAX_VALUE);
		assertEquals(true, f29.greaterThan(f30));
		
	}

	private static void runLessThanTests() throws Exception {
		
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(4, 3);
		assertEquals(true, f1.lessThan(f2));
		
		Fraction f3 = new Fraction(2, 3);
		Fraction f4 = new Fraction(2, 3);
		assertEquals(false, f3.lessThan(f4));
		
		Fraction f5 = new Fraction(2, 3);
		Fraction f6 = new Fraction(4, 6);
		assertEquals(false, f6.lessThan(f5));
		
		Fraction f7 = new Fraction(-2, 3);
		Fraction f8 = new Fraction(4, 3);
		assertEquals(false, f8.lessThan(f7));
		
		Fraction f9 = new Fraction(2, 3);
		Fraction f10 = new Fraction(-4, 3);
		assertEquals(false, f9.lessThan(f10));
		
		Fraction f11 = new Fraction(-2, 3);
		Fraction f12 = new Fraction(-4, 6);
		assertEquals(false, f11.lessThan(f12));
		
		Fraction f13 = new Fraction(-2, 3);
		Fraction f14 = new Fraction(-3, 7);
		assertEquals(false, f14.lessThan(f13));
		
		Fraction f15 = new Fraction(-2, 3);
		Fraction f16 = Fraction.ZERO_FRACTION;
		assertEquals(true, f15.lessThan(f16));
		
		Fraction f17 = Fraction.ZERO_FRACTION;
		Fraction f18 = new Fraction(-3, 7);
		assertEquals(true, f18.lessThan(f17));
		
		Fraction f19 = Fraction.ZERO_FRACTION;
		Fraction f20 = new Fraction(3, 7);
		assertEquals(true, f19.lessThan(f20));
		
		Fraction f21 = new Fraction(3, 7);
		Fraction f22 = Fraction.ZERO_FRACTION;
		assertEquals(true, f22.lessThan(f21));
		
		Fraction f23 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
		Fraction f24 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
		assertEquals(true, f23.lessThan(f24));
	
		Fraction f25 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
		Fraction f26 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
		assertEquals(false, f25.lessThan(f26));
		
		Fraction f27 = new Fraction(Integer.MAX_VALUE, 3);
		Fraction f28 = new Fraction(8, Integer.MAX_VALUE);
		assertEquals(false, f27.lessThan(f28));
	
		Fraction f29 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
		Fraction f30 = new Fraction(8, Integer.MAX_VALUE);
		assertEquals(false, f29.lessThan(f30));
		
	}

	private static void runDivideTests() throws Exception {

		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(4, 3);
		Fraction r1 = f1.divide(f2);
		assertEquals(1, r1.getNumerator());
		assertEquals(2, r1.getDenominator());
		
		Fraction f3 = new Fraction(2, 3);
		Fraction f4 = new Fraction(2, 3);
		Fraction r2 = f3.divide(f4);
		assertEquals(1, r2.getNumerator());
		assertEquals(1, r2.getDenominator());
		
		Fraction f5 = new Fraction(-2, 3);
		Fraction f6 = new Fraction(4, 3);
		Fraction r3 = f5.divide(f6);
		assertEquals(-1, r3.getNumerator());
		assertEquals(2, r3.getDenominator());
		
		Fraction f7 = new Fraction(2, 3);
		Fraction f8 = new Fraction(-4, 3);
		Fraction r4 = f7.divide(f8);
		assertEquals(-1, r4.getNumerator());
		assertEquals(2, r4.getDenominator());
		
		Fraction f9 = new Fraction(-2, 3);
		Fraction f10 = new Fraction(-4, 6);
		Fraction r5 = f9.divide(f10);
		assertEquals(1, r5.getNumerator());
		assertEquals(1, r5.getDenominator());
		
		try {
			// Divide by a Zero Fraction Exception
			Fraction f11 = new Fraction(2, 3);
			Fraction f12 = Fraction.ZERO_FRACTION;
			Fraction r6 = f11.divide(f12);
			assertEquals(2, r6.getNumerator());
			assertEquals(3, r6.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Fraction f13 = Fraction.ZERO_FRACTION;
		Fraction f14 = new Fraction(2, 3);
		Fraction r7 = f13.divide(f14);
		assertEquals(0, r7.getNumerator());
		assertEquals(1, r7.getDenominator());
		
		try {
			// When there is no Greatest Common Divisor (GCD) among numerator
			// and Denominator, then if there is an overflow in the values which
			// computing the new fraction, we should just let it throw an
			// exception as we cannot reduce the fraction anyway
			
			Fraction f15 = new Fraction(Integer.MAX_VALUE, 3);
			Fraction f16 = new Fraction(8, Integer.MAX_VALUE);
			Fraction r8 = f15.divide(f16);
			System.out.println(r8.getNumerator());
			System.out.println(r8.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			// When there is no Greatest Common Divisor (GCD) among numerator
			// and Denominator, then if there is an overflow in the values which
			// computing the new fraction, we should just let it throw an
			// exception as we cannot reduce the fraction anyway

			Fraction f17 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
			Fraction f18 = new Fraction(8, Integer.MAX_VALUE);
			Fraction r9 = f17.divide(f18);
			System.out.println(r9.getNumerator());
			System.out.println(r9.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			// When we are trying to divide a fraction which has a INT_MIN in
			// the numerator, the inverted value will lead to Integer Overflow
			// error as negation of INT_MIN is greater than INT_MAX

			Fraction f19 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
			Fraction f20 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction r10 = f19.divide(f20);
			System.out.println(r10.getNumerator());
			System.out.println(r10.getNumerator());
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
		try {
			// When we are trying to divide a fraction which has a INT_MIN in
			// the numerator, the inverted value will lead to Integer Overflow
			// error as negation of INT_MIN is greater than INT_MAX
			
			Fraction f21 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction f22 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction r11 = f21.divide(f22);
			System.out.println(r11.getNumerator());
			System.out.println(r11.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void runMultiplyTests() throws Exception {
		
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(4, 3);
		Fraction r1 = f1.multiply(f2);
		assertEquals(8, r1.getNumerator());
		assertEquals(9, r1.getDenominator());
		
		Fraction f3 = new Fraction(-2, 3);
		Fraction f4 = new Fraction(2, 3);
		Fraction r2 = f3.multiply(f4);
		assertEquals(-4, r2.getNumerator());
		assertEquals(9, r2.getDenominator());
		
		Fraction f5 = new Fraction(2, 3);
		Fraction f6 = new Fraction(-4, 3);
		Fraction r3 = f5.multiply(f6);
		assertEquals(-8, r3.getNumerator());
		assertEquals(9, r3.getDenominator());
		
		Fraction f7 = new Fraction(-2, 3);
		Fraction f8 = new Fraction(-4, 3);
		Fraction r4 = f7.multiply(f8);
		assertEquals(8, r4.getNumerator());
		assertEquals(9, r4.getDenominator());
		
		Fraction f9 = new Fraction(2, 3);
		Fraction f10 = Fraction.ZERO_FRACTION;
		Fraction r5 = f9.multiply(f10);
		assertEquals(0, r5.getNumerator());
		assertEquals(1, r5.getDenominator());
		
		Fraction f11 = Fraction.ZERO_FRACTION;
		Fraction f12 = new Fraction(2, 3);
		Fraction r6 = f11.multiply(f12);
		assertEquals(0, r6.getNumerator());
		assertEquals(1, r6.getDenominator());
		
		Fraction f13 = new Fraction(Integer.MAX_VALUE, 3);
		Fraction f14 = new Fraction(8, Integer.MAX_VALUE);
		Fraction r7 = f13.multiply(f14);
		assertEquals(8, r7.getNumerator());
		assertEquals(3, r7.getDenominator());
		
		Fraction f15 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
		Fraction f16 = new Fraction(8, Integer.MAX_VALUE);
		Fraction r8 = f15.multiply(f16);
		assertEquals(1, r8.getNumerator());
		assertEquals(-268435456, r8.getDenominator());
		
		try {
			// When there is no Greatest Common Divisor (GCD) among numerator
			// and Denominator, then if there is an overflow in the values which
			// computing the new fraction, we should just let it throw an
			// exception as we cannot reduce the fraction anyway
			
			Fraction f17 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
			Fraction f18 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction r9 = f17.multiply(f18);
			System.out.println(r9.getNumerator());
			System.out.println(r9.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			// When there is no Greatest Common Divisor (GCD) among numerator
			// and Denominator, then if there is an overflow in the values which
			// computing the new fraction, we should just let it throw an
			// exception as we cannot reduce the fraction anyway
			
			Fraction f19 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction f20 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction r10 = f19.multiply(f20);
			System.out.println(r10.getNumerator());
			System.out.println(r10.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void runSubtractTests() throws Exception {
		
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(4, 3);
		Fraction r1 = f1.subtract(f2);
		assertEquals(-2, r1.getNumerator());
		assertEquals(3, r1.getDenominator());
		
		Fraction f3 = new Fraction(-2, 3);
		Fraction f4 = new Fraction(2, 3);
		Fraction r2 = f3.subtract(f4);
		assertEquals(-4, r2.getNumerator());
		assertEquals(3, r2.getDenominator());
		
		Fraction f5 = new Fraction(2, 3);
		Fraction f6 = new Fraction(-4, 3);
		Fraction r3 = f5.subtract(f6);
		assertEquals(2, r3.getNumerator());
		assertEquals(1, r3.getDenominator());
		
		Fraction f7 = new Fraction(-2, 3);
		Fraction f8 = new Fraction(-4, 3);
		Fraction r4 = f7.subtract(f8);
		assertEquals(2, r4.getNumerator());
		assertEquals(3, r4.getDenominator());
		
		Fraction f9 = new Fraction(2, 3);
		Fraction f10 = new Fraction(2, 3);
		Fraction r5 = f9.subtract(f10);
		assertEquals(0, r5.getNumerator());
		assertEquals(1, r5.getDenominator());
		
		Fraction f11 = new Fraction(2, 3);
		Fraction f12 = Fraction.ZERO_FRACTION;
		Fraction r6 = f11.subtract(f12);
		assertEquals(2, r6.getNumerator());
		assertEquals(3, r6.getDenominator());
		
		Fraction f13 = Fraction.ZERO_FRACTION;
		Fraction f14 = new Fraction(2, 3);
		Fraction r7 = f13.subtract(f14);
		assertEquals(-2, r7.getNumerator());
		assertEquals(3, r7.getDenominator());
		
		try {
			// When there is no Greatest Common Divisor (GCD) among numerator
			// and Denominator, then if there is an overflow in the values which
			// computing the new fraction, we should just let it throw an
			// exception as we cannot reduce the fraction anyway
			
			Fraction f15 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
			Fraction f16 = new Fraction(8, Integer.MAX_VALUE);
			Fraction r8 = f15.subtract(f16);
			assertEquals(1, r8.getNumerator());
			assertEquals(-268435456, r8.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			// When there is no Greatest Common Divisor (GCD) among numerator
			// and Denominator, then if there is an overflow in the values which
			// computing the new fraction, we should just let it throw an
			// exception as we cannot reduce the fraction anyway
			
			Fraction f17 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
			Fraction f18 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction r9 = f17.subtract(f18);
			System.out.println(r9.getNumerator());
			System.out.println(r9.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Fraction f19 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction f20 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction r10 = f19.subtract(f20);
			System.out.println(r10.getNumerator());
			System.out.println(r10.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Fraction f21 = new Fraction(Integer.MAX_VALUE, 3);
			Fraction f22 = new Fraction(8, Integer.MAX_VALUE);
			Fraction r11 = f21.subtract(f22);
			assertEquals(8, r11.getNumerator());
			assertEquals(3, r11.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void runAdditionTests() throws Exception {
		
		Fraction f1 = new Fraction(2, 3);
		Fraction f2 = new Fraction(4, 3);
		Fraction r1 = f1.add(f2);
		assertEquals(2, r1.getNumerator());
		assertEquals(1, r1.getDenominator());
		
		Fraction f3 = new Fraction(-2, 3);
		Fraction f4 = new Fraction(2, 3);
		Fraction r2 = f3.add(f4);
		assertEquals(0, r2.getNumerator());
		assertEquals(1, r2.getDenominator());
		
		Fraction f5 = new Fraction(2, 3);
		Fraction f6 = new Fraction(-4, 3);
		Fraction r3 = f5.add(f6);
		assertEquals(-2, r3.getNumerator());
		assertEquals(3, r3.getDenominator());
		
		Fraction f7 = new Fraction(-2, 3);
		Fraction f8 = new Fraction(-4, 3);
		Fraction r4 = f7.add(f8);
		assertEquals(-2, r4.getNumerator());
		assertEquals(1, r4.getDenominator());
		
		Fraction f9 = new Fraction(2, 3);
		Fraction f10 = Fraction.ZERO_FRACTION;
		Fraction r5 = f9.add(f10);
		assertEquals(2, r5.getNumerator());
		assertEquals(3, r5.getDenominator());
		
		Fraction f11 = Fraction.ZERO_FRACTION;
		Fraction f12 = new Fraction(2, 3);
		Fraction r6 = f11.add(f12);
		assertEquals(2, r6.getNumerator());
		assertEquals(3, r6.getDenominator());
		
		try {
			// When there is no Greatest Common Divisor (GCD) among numerator
			// and Denominator, then if there is an overflow in the values which
			// computing the new fraction, we should just let it throw an
			// exception as we cannot reduce the fraction anyway
			
			Fraction f13 = new Fraction(Integer.MAX_VALUE, 3);
			Fraction f14 = new Fraction(8, Integer.MAX_VALUE);
			Fraction r7 = f13.add(f14);
			assertEquals(8, r7.getNumerator());
			assertEquals(3, r7.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			// When there is no Greatest Common Divisor (GCD) among numerator
			// and Denominator, then if there is an overflow in the values which
			// computing the new fraction, we should just let it throw an
			// exception as we cannot reduce the fraction anyway
			
			Fraction f15 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
			Fraction f16 = new Fraction(8, Integer.MAX_VALUE);
			Fraction r8 = f15.add(f16);
			assertEquals(1, r8.getNumerator());
			assertEquals(-268435456, r8.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			// When there is no Greatest Common Divisor (GCD) among numerator
			// and Denominator, then if there is an overflow in the values which
			// computing the new fraction, we should just let it throw an
			// exception as we cannot reduce the fraction anyway
			
			Fraction f17 = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
			Fraction f18 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction r9 = f17.add(f18);
			System.out.println(r9.getNumerator());
			System.out.println(r9.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Fraction f19 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction f20 = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Fraction r10 = f19.add(f20);
			System.out.println(r10.getNumerator());
			System.out.println(r10.getDenominator());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
