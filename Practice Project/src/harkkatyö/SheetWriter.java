package harkkatyö;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SheetWriter {
	public static String[] dummyline = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom\t", "Charisma"};
	public static String[] dummyrace = {"Hill Dwarf", "High Elf", "Halfling, Lightfoot", "Human", "Dragonborn", "Forest Gnome", "Half-Elf", "Half-Orc", "Tiefling", "Mountain Dwarf", "Wood Elf", "Dark Elf", "Halfling, Stout", "Rock Gnome"};
	public static String[] dummyclass = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
	public static void main(int[] FinalSet, int Race, int Class) { 	//Partly from w3schools
		String SaveName = "";
		boolean ok = false;
		while (ok == false) {
			Scanner Naming = new Scanner(System.in);
			System.out.println("Enter character name. (Used to name the file)");
			SaveName = Naming.nextLine();
		    try { 
		        File Obj = new File(SaveName + ".txt");  //Add path here if you want to print to specific locale
		        if (Obj.createNewFile()) { 
		          System.out.println("File created: " + Obj.getName());
		          ok = true;
		        } else { 
		          System.out.println("File already exists."); 
		        } 
		      } catch (IOException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace(); 
		      }
		}
	    try { 
	        FileWriter Writer = new FileWriter(SaveName + ".txt");
	        Writer.write(SaveName + ", " + dummyrace[Race] + " " + dummyclass[Class] +"\r\nLevel " + FinalSet[6]);
	        Writer.write("\r\n\r\nProficiency: " + "\t+" + FinalSet[7]);
	        Writer.write("\r\nArmor Class: " + "\t" + FinalSet[8] + "  (Without Armor)");
	        Writer.write("\r\nHit Points Maximum: " + "\t" + FinalSet[9]);
	        Writer.write("\r\n\r\nAbilities \t\t Modifier \r\n");
			for (int z = 0; z < 6; z++) {	
				Writer.write("\r\n" + dummyline[z] + "\t" + FinalSet[z]);
				if (((FinalSet[z] - 10) / 2) < 0) {
					Writer.write("\t(" + ((FinalSet[z] - 11) / 2) + ")");
				}else {
					Writer.write("\t(+" + ((FinalSet[z] - 10) / 2 + ")"));
				}
			}
			if (FinalSet[10] != 0) {
				Writer.write("\r\n\r\nSpell Attack Modifier: " + "\t+" + FinalSet[10]);
				Writer.write("\r\nSpell Save DC: " + "\t\t" + FinalSet[11]);
			}
	        Writer.close();
	        System.out.println("Successfully wrote to the file.");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	
		}

}
