import java.util.Scanner;

public class Lukuj�rjV3 {
		public static void main(String[] args) {
			Scanner klukija = new Scanner(System.in);
			int[] Luvut;
			Luvut = new int[3];
			Luvut[0] = klukija.nextInt();
			Luvut[1] = klukija.nextInt();
			Luvut[2] = klukija.nextInt();
			int v�li = 0;
			int i = 0;
			while (!(Luvut[0] >= Luvut[1] & Luvut[1] >= Luvut[2])) {
				if (Luvut[0] <= Luvut[1]) {
					v�li = Luvut[1];
					Luvut[1] = Luvut[0];
					Luvut[0] = v�li;
				}
				if (Luvut[1] <= Luvut[2]) {
					v�li = Luvut[2];
					Luvut[2] = Luvut[1];
					Luvut[1] = v�li;
				}
			}
			
			System.out.println("Luvut j�rjestyksess�:" + Luvut[2] + "," + Luvut[1] + "," + Luvut[0]);
			
		}
}


