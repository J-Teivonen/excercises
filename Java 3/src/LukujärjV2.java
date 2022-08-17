import java.util.Scanner;

public class LukujärjV2 {
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
				i = 0;
				for (i = 0; 0 < 1; i++) {
					väli = 0;
					if (Luvut[i] <= Luvut[(i+1)]) {
						väli = Luvut[(i+1)];
						Luvut[(i+1)] = Luvut[i];
						Luvut[i] = väli;
					}
				}
			}
			
			System.out.println("Luvut järjestyksessä:" + Luvut[2] + "," + Luvut[1] + "," + Luvut[0]);
			
		}
}


