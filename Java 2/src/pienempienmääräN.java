import java.util.Scanner;

public class pienempienm��r�N {
	public static void main(String[] args) {
		Scanner nlukija = new Scanner (System.in);
		System.out.println("Sy�t� yl�raja N:");
		int n = nlukija.nextInt();
		int i = 2;
		int total = 0;
		int sum = 0;
		System.out.println("Lukujonon vastaavat numerot:");
		do {
			System.out.println(i);
			i = i * 2;
			total++;
			sum = sum + i;
			} while (i < n);
		System.out.println("Lukujen m��r�: " + total + "\t" + "Lukujen summa: " + sum);

		}
}
