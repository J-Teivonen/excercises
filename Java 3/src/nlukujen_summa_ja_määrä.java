import java.util.Scanner;

public class nlukujen_summa_ja_m��r� {
	
	public static void main(String[] args) {
		Scanner merkkilukija = new Scanner(System.in);
		int sum = 0;
		System.out.println("Sy�t� haluttu lukujen m��r�: ");
		int n = merkkilukija.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Sy�t� " + i + ". luku: ");
			sum = sum + merkkilukija.nextInt();
		}
		System.out.println("Lukuja: " + n + "\n" + "Lukujen summa: " + sum + "\n");
	}
}