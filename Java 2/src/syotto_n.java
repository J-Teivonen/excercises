import java.util.Scanner;

public class syotto_n {
	public static void main(String[] syotto) {
		Scanner s = new Scanner(System.in);
		System.out.println("Sy�t� merkkijono: ");
		String syote = s.nextLine();
		System.out.println("Monesko kirjain tulostetaan?(Kokonaisluku)");
		int kirjain = s.nextInt();
		System.out.println('"'+syote+'"' + "\t" + kirjain + ".kirjain:" + syote.charAt(kirjain-1));
	}
}
