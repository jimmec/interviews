package solutions.Recursion;

/**
 * Computes the total number of choices to form n cents,
 * using an infinite supply of quarters, dimes, nickels and pennies.
 * @author jimmy
 *
 */
public class combosOfNcents {
	public static long numberOfChoices(int n) {
		long total = 0;
		if (n >= 1) {
			// there's always one way, give it all in pennies
			total += 1;
		}
		if (n >= 5) {
			int m = n;
			total += 1;
			while (m >= 5) {
				m -= 5;
				total += numberOfChoices(m);
			}
		}
		if (n >= 10) {
			int m = n;
			total += 1;
			while (m >= 10) {
				m -= 10;
				total += numberOfChoices(m);
			}
		}
		if (n >= 25) {
			int m = n;
			total += 1;
			while (m >= 25) {
				m -= 25;
				total += numberOfChoices(m);
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		System.out.println(numberOfChoices(10));
	}
}
