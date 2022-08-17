
import java.util.Scanner;

public class ankka_ui_lammella_nmerkki2 {
		public static void main(String[] args) {
			String ankka = "Ankka ui lammella";
			Scanner nlukija = new Scanner(System.in);
			int merkki = 0;
			boolean testi = false;
			do {
				System.out.println("Monennetko kirjaimet haluat tulostettuna? (MJ: 'Ankka ui lammella')");
				merkki = nlukija.nextInt();
				if (merkki > 16 | merkki < 0) {
					System.out.println("Virhe: Annettu luku merkkijonon ulkopuolella.");
				} else {
					testi = true;
				}
			} while (testi == false);
			String nmerkit = "";
			for (int i = 0; i < ankka.length()-1; i = (i+merkki)) {
				nmerkit = nmerkit + ankka.charAt(i);
			}	
			System.out.println(nmerkit);

	}
}