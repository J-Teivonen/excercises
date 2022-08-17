import java.util.Scanner;

public class F_C_muunnin {

	public static void main(String[] args) {
		Scanner astelukija = new Scanner(System.in);
		System.out.println("Anna asteikko, johon haluat muuntaa (c/f):");
		char cf = astelukija.next(".").charAt(0);
		if (cf == 'c') {
			System.out.println("Syötä Fahrenheit lukema, jonka haluat muuntaa: ");
			float muunnos = astelukija.nextFloat();
			System.out.println(muunnos + "°F = " + ((muunnos-32)/1.8) + "°C");
		}
		if (cf == 'f') {
			System.out.println("Syötä Celsius lukema, jonka haluat muuntaa: ");
			float muunnos = astelukija.nextFloat();
			System.out.println(muunnos + "°C = " + (muunnos*1.8 + 32) + "°F");
		} 

	}

}
