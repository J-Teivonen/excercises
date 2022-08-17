import java.util.Scanner;

public class ala_ylä_jaolliset {

	public static void main(String[] args) {
		Scanner rajalukija = new Scanner (System.in);
		System.out.println("Syötä lukuvälin alaraja:");
		int ala = rajalukija.nextInt();
		System.out.println("Syötä lukuvälin yläraja:");
		int ylä = rajalukija.nextInt();
		System.out.println("Lukuvälin kahdella jaolliset luvut:");
		for (int i = ala; i <= ylä; i++) {
			if (i%2 == 0) {
				System.out.println(i);
			}

		}
	}

}
