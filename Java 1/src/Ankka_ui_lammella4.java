
public class Ankka_ui_lammella4 {
	public static void main(String[] countdown) {
		String A = "Ankka ui lammella";
		for (int i=0; i < A.length(); i++) {
			if (A.charAt(i) == ('A'|'a'|'E'|'e'|'I'|'i'|'O'|'o'|'U'|'u'|'Y'|'y')) {
				System.out.print(A.charAt(i));
			}
		}
	}
}
