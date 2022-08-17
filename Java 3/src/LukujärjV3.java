import java.util.Scanner;

public class LukujärjV3 {
		public static void main(String[] args) {
			Scanner klukija = new Scanner(System.in);
			int[] Luvut;
			Luvut = new int[3];
			Luvut[0] = klukija.nextInt();
			Luvut[1] = klukija.nextInt();
			Luvut[2] = klukija.nextInt();
			int väli = 0;
			int i = 0;
			while (!(Luvut[0] >= Luvut[1] & Luvut[1] >= Luvut[2])) {
				if (Luvut[0] <= Luvut[1]) {
					väli = Luvut[1];
					Luvut[1] = Luvut[0];
					Luvut[0] = väli;
				}
				if (Luvut[1] <= Luvut[2]) {
					väli = Luvut[2];
					Luvut[2] = Luvut[1];
					Luvut[1] = väli;
				}
			}
			
			System.out.println("Luvut järjestyksessä:" + Luvut[2] + "," + Luvut[1] + "," + Luvut[0]);
			
		}
}


