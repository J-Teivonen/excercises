import java.util.Scanner;

public class merkkijonovertailu {

	public static void main(String[] args) {
		Scanner jonolukija = new Scanner(System.in);
		System.out.println("Sy�t� ensimm�inen merkkijono: ");
		String jono1 = jonolukija.nextLine();
		System.out.println("Sy�t� toinen merkkijono: ");
		String jono2 = jonolukija.nextLine();
		int j = 0;
		if (jono1.length() > jono2.length()) {
			j = jono2.length();
		} else {
			j = jono1.length();
		}
		for (int i = 0; i < j; i++) {
			if (jono1.charAt(i) == jono2.charAt(i)) {
				System.out.println("Indeksi " + i + ":  " + "'" + jono1.charAt(i) + "'");
			}
		}
	}

}
