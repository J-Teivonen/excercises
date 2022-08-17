import java.util.Scanner;

public class LukujärjestysKolme {

	public static void main(String[] args) {
		Scanner klukija = new Scanner(System.in);
		int a = klukija.nextInt();
		int b = klukija.nextInt();
		int c = klukija.nextInt();
		int suurin = 0;
		int pienin = 0;
		int keski = 0;
		for (char i = 'a'; i < 'c'; i++) {
			int j = i;
			if (j >= a & j >= b & j >= c ) {
				suurin = j;
				} else if (j <= a & j <= b & j <= c){
					pienin = j;
				} else {
					keski = j;
				}
			}
		System.out.println(pienin + " " + keski + " " + suurin);
		}
	}


