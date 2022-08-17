import java.util.Scanner;

public class ankka_ui_lammella_nmerkki {

	public static void main(String[] args) {
		String ankka = "Ankka ui lammella";
		Scanner nlukija = new Scanner(System.in);
		System.out.println("Monennetko kirjaimet haluat tulostettuna? (MJ: 'Ankka ui lammella')");
		int merkki = nlukija.nextInt();
		if (merkki > 16 | merkki < 0) {
			System.out.println("Virhe: Annettu luku merkkijonon ulkopuolella.");
		} else {
			String nmerkit = "";
			for (int i = 0; i < ankka.length()-1; i = i+merkki) {
				nmerkit = nmerkit + ankka.charAt(i);
			}
			System.out.println(nmerkit);
		}
			
	}

}
