import java.util.Scanner;

public class nluvut_99 {
	
	public static void main(String[] args) {
		Scanner merkkilukija = new Scanner(System.in);
		int sum = 0;
		int nr = 0;
		boolean stop = false;
		int luku = 0;
		do {
			System.out.println("Sy�t� luku 99 lopettaaksesi TAI lis�� muu luku:");
			luku = merkkilukija.nextInt();
			if (luku == 99) {
				stop = true;
			} else {
			sum = sum + luku;
			nr++;
			}
		} while (stop == false);
		System.out.println("Lukuja: " + nr + "\n" + "Lukujen summa: " + sum);
	}
}