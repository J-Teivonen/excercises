import java.util.Scanner;

public class nlukujen_summa_ja_määrä {
	
	public static void main(String[] args) {
		Scanner merkkilukija = new Scanner(System.in);
		int sum = 0;
		System.out.println("Syötä haluttu lukujen määrä: ");
		int n = merkkilukija.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Syötä " + i + ". luku: ");
			sum = sum + merkkilukija.nextInt();
		}
		System.out.println("Lukuja: " + n + "\n" + "Lukujen summa: " + sum + "\n");
	}
}