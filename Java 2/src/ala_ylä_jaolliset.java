import java.util.Scanner;

public class ala_yl�_jaolliset {

	public static void main(String[] args) {
		Scanner rajalukija = new Scanner (System.in);
		System.out.println("Sy�t� lukuv�lin alaraja:");
		int ala = rajalukija.nextInt();
		System.out.println("Sy�t� lukuv�lin yl�raja:");
		int yl� = rajalukija.nextInt();
		System.out.println("Lukuv�lin kahdella jaolliset luvut:");
		for (int i = ala; i <= yl�; i++) {
			if (i%2 == 0) {
				System.out.println(i);
			}

		}
	}

}
