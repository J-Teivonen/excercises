import java.util.Scanner;

public class ala_yl‰_jaolliset2 {

	public static void main(String[] args) {
		Scanner rajalukija = new Scanner (System.in);
		System.out.println("Syˆt‰ lukuv‰lin minimi pituus:");
		int l = rajalukija.nextInt();
		System.out.println("Syˆt‰ lukuv‰lin alaraja:");
		int ala = rajalukija.nextInt();
		boolean stp = false;
		do {
			System.out.println("Syˆt‰ lukuv‰lin yl‰raja:");
			int yl‰ = rajalukija.nextInt();
			if (yl‰ >= ala + l) {
				stp = true;
			} else {
				System.out.println("Yl‰raja pienimmill‰‰n " + (ala+l));
			}
		} while (stp == false);
		System.out.println("Lukuv‰lin kahdella jaolliset luvut:");
		for (int i = ala; i <= ala+l; i++) {
			if (i%2 == 0) {
				System.out.println(i);
			}

		}
	}

}
