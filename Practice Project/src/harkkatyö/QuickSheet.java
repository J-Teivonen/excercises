package harkkatyö;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


public class QuickSheet {
	public static int[] order = {0, 1, 2, 3, 4, 5};
	public static String[] dummyline = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom\t", "Charisma"};
	public static String[] dummyrace = {"Hill Dwarf", "High Elf", "Halfling, Lightfoot", "Human", "Dragonborn", "Forest Gnome", "Half-Elf", "Half-Orc", "Tiefling", "Mountain Dwarf", "Wood Elf", "Dark Elf", "Halfling, Stout", "Rock Gnome"};
	public static String[] dummyclass = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
	public static void main(String[] args) {
		Scanner TempInput = new Scanner(System.in);
		System.out.println("THIS PROGRAM IS INTENDED FOR NUMBER CREATION ONLY  \nRemember to check the appropriate rules for classes and races from the Player's Handbook. \n\n(Press Enter to continue)");
		TempInput.nextLine();
		
//Init Values
		int[] ValuePool = new int [6];
		boolean Save = false;
		
//Result Checker

		int[] RaceClass = new int[2];
		int[] FinalValues = new int[6];
		int RaceID = 0;
		int ClassID = 0;
		while (Save == false) {
			boolean ok = false;
			while (ok == false) {
				RaceClass = QuickSheet.RaceClassChoice(TempInput);
				RaceID = RaceClass[0];
				ClassID = RaceClass[1];
				System.out.println("Generating stats for " + dummyrace[RaceID] + " " + dummyclass[ClassID] +". \nOK? (y/n);");
				boolean ok1 = false;
				while (ok1 == false) {
					String Continue = TempInput.nextLine();
					System.out.println(Continue);
					if (Continue.equals("yes") | Continue.equals("y") | Continue == "Yes") {
						ok = true;
						ok1 = true;
					} else if  (Continue.equals("no") | Continue.equals("n") | Continue.equals("No")) {
						System.out.println("Rechoose Race/Class.");
						ok1 = true;
						Continue = "asdfg";
					}
				}
			}
			
	//Init Pool, allocation type choice.
			int Choice = 7;
			while (0 > Choice | Choice > 4) {;
				try {
					System.out.println("Type [1] to roll the value pool. \nType [2] to use a Default value pool. \nType [3] For quick generation. \n \n(Type [0] to close the program.)");
					Choice = Integer.parseInt(TempInput.nextLine());
				}
				catch(Exception e) {
					System.out.println("Input a valid number, or type [0] to close the program.");
				}
			}
		
	//DefaultScore System
			if (Choice == 2) {
				int[] defaultpool = {15, 14, 13, 12, 10, 8};
				ValuePool = defaultpool.clone();
			}
	//RandomPoint System
			if (Choice == 1 | Choice == 3) {
				for (int i = 0;  i < 6; i++){
					int[] subrnd = new int [4];
					for (int j = 0;  j < 4; j++){
						Random generator = new Random();
						subrnd[j] = generator.nextInt(6) + 1;
					}
					Arrays.sort(subrnd);
					System.out.println(Arrays.toString(subrnd));
					int totalrnd = subrnd[1]+subrnd[2]+subrnd[3];
					ValuePool[i] = totalrnd;
				}
				System.out.println(Arrays.toString(ValuePool));
			}
			if (Choice != 3) {
				boolean ok2 = false;
				while (ok2 == false) {
					FinalValues = QuickSheet.Allocation(ValuePool);
					System.out.println("Final Values: ");
					for (int z = 0; z < 6; z++) {	
						System.out.println(dummyline[z] + "\t" + FinalValues[z]);
					}
					System.out.println("OK? (y/n/back)");
					String Continue = TempInput.nextLine();
					if ((Continue.equals("yes") | Continue.equals("y")) == true) {
						ok2 = true;
					} else if  ((Continue.equals("no") | Continue.equals("n")) == true) {
						System.out.println("Rechoose values.");
					} else if ((Continue.equals("back") | Continue.equals("b")) == true) {
						ok2 = true;
						ok = false;
					}
				}
			}
			if (Choice == 3) {
				FinalValues = QuickSheet.AutoAllocator(ValuePool);
			}
			//Final Calculations
			int[] CompleteSet = new int[12];
			boolean ok3 = false;
			while (ok3 == false) {
				if (Choice != 3) {
					CompleteSet = CalculateFinal.main(FinalValues, RaceID, ClassID);
				}
				if (Choice == 3) {
					CompleteSet = CalculateFinal.auto(FinalValues, RaceID, ClassID);
				}
				System.out.println(dummyrace[RaceID] + " " + dummyclass[ClassID] +", Level " + CompleteSet[6]);
				System.out.println("Proficiency: " + "\t" + CompleteSet[7]);
				System.out.println("Armor Class: " + "\t" + CompleteSet[8]);
				System.out.println("Hit Points Maximum: " + "\t" + CompleteSet[9]);
				System.out.println("Final Values: ");
				for (int z = 0; z < 6; z++) {	
					System.out.println(dummyline[z] + "\t" + CompleteSet[z]);
				}
				if (CompleteSet[10] != 0) {
					System.out.println("Spell Attack Modifier: " + "\t" + CompleteSet[10]);
					System.out.println("Spell Save DC: " + "\t" + CompleteSet[11]);
				}
				System.out.println("Save? (y/n)");
				String Continue = TempInput.nextLine();
				if (Continue.equals("yes") | Continue.equals("y") | Continue.equals("yes")) {
					SheetWriter.main(CompleteSet, RaceID, ClassID);
					System.out.println("Creation completed!");
					ok3 = true;
				} else if  (Continue.equals("no") | Continue.equals("n") | Continue.equals("No")) {
					boolean ok4 = false;
					while (ok4 == false) {
						System.out.println("Discard or reset level?");
						String Scrap = TempInput.nextLine();
						if (Scrap.equals("Reset") | Scrap.equals("r") | Scrap.equals("reset")) {
							ok4 = true;
						} else if  (Scrap.equals("Discard") | Scrap.equals("d") | Scrap.equals("discard")) {
							System.out.println("Item discarded.");
							ok4 = true;
							ok3 = true;
						}
					}
				}
			}
			System.out.println("Exit? (y/n)");
			String Continue = TempInput.nextLine();
			boolean ok5 = false;
			while (ok5 == false) {
				if (Continue.equals("yes") | Continue.equals("y") | Continue.equals("Yes")) {
					Save = true;
					ok5 = true;
				} else if  (Continue.equals("no") | Continue.equals("n") | Continue.equals("No")) {
					ok5 = true;
				}
			}

			
		}
		
		
	}
	
	
	public static int[] RaceClassChoice(Scanner TempInput) {//Race&Class choice
		//Class preferred ability score index
		int[] Pref = {0, 5, 4, 4, 0, 1, 5, 1, 1, 5, 5, 3}; //Straight value index
		int[] SecPref = {2, 1, 2, 2, 2, 4, 0, 4, 3, 2, 2, 1}; //Straight value index

		boolean Continue = false;
		int RaceID = 0;
		int ClassID = 0;
		while (Continue == false) {
			try {
				System.out.println("Choose a race. \n  [1] Dwarf \n  [2] Elf \n  [3] Halfling \n  [4] Human \n  [5] Dragonborn \n  [6] Gnome \n  [7] Half-Elf \n  [8] Half-Orc \n  [9] Tiefling");
				RaceID = Integer.parseInt(TempInput.nextLine());
				if (RaceID == 1) {
					System.out.println("Choose a subrace. \n[1] Hill Dwarf \n[10] Mountain Dwarf");
					RaceID = Integer.parseInt(TempInput.nextLine());
				}
				if (RaceID == 2) {
					System.out.println("Choose a subrace. \n[2] High Elf \n[11] Wood Elf \n[12] Dark Elf");
					RaceID = Integer.parseInt(TempInput.nextLine());
				}
				if (RaceID == 3) {
					System.out.println("Choose a subrace. \n[3] Lightfoot \n[13] Stout");
					RaceID = Integer.parseInt(TempInput.nextLine());
				}
				if (RaceID == 4) {
					System.out.println("Choose either: \n[4] Balanced \n[15] Choose a feat from Player's Handbook page 165");
					RaceID = Integer.parseInt(TempInput.nextLine());
				}
				if (RaceID == 6) {
					System.out.println("Choose a subrace. \n[6] Forest Gnome \n[14] Rock Gnome");
					RaceID = Integer.parseInt(TempInput.nextLine());
				}
			
				System.out.println("Choose a class. \n  [1] Barbarian \n  [2] Bard \n  [3] Cleric \n  [4] Druid \n  [5] Fighter \n  [6] Monk \n  [7] Paladin \n  [8] Ranger \n  [9] Rogue  \n  [10] Sorcerer \n  [11] Warlock \n  [12] Wizard");
				ClassID = Integer.parseInt(TempInput.nextLine());
			} catch(Exception e) {
				System.out.println("!! Invalid input. Please choose an applicable number. !!");	
			}
			//Set preferred ability values
			for (int i = 0; i < order.length; i++) {
				if (Pref[ClassID-1] == order[i]) {
					int temp = order[0];
					order[0] = Pref[ClassID-1];
					order[i] = temp;	
				}
				if (SecPref[ClassID-1] == order[i]) {
					int temp = order[1];
					order[1] = SecPref[ClassID-1];
					order[i] = temp;	
				}
			}
			if (RaceID != 0 & ClassID != 0) {
				ClassID--; //Shift to index
				RaceID--; 
				Continue = true;
			}
		}
		int[] RaceClass = {RaceID, ClassID};
		return RaceClass;
		}		
	
	
	public static int[] Allocation(int[] GeneratedValues) { //Point allocator method
		Scanner Allocator = new Scanner(System.in);
		int[] tempvalues = GeneratedValues.clone();
		int[] AllocatedValues = new int[6];
		boolean ok = false;
		for (int z = 0; z < 6; z++) {
			int valuechoice;
			Arrays.sort(tempvalues);
			System.out.println("Value pool:");
			for (int x = 0; x < tempvalues.length; x++) {
				if (tempvalues[x] != 0) {
					System.out.print(tempvalues[x] + "\t");
				}
			}
			System.out.println("\nChoose a value for " + dummyline[order[z]]+":");
			if (z < 2) {
				System.out.println("(Preferred ability, high value suggested)");
			}
			
			valuechoice = 0;
			//choice
			ok = false;
			do {
				try {
				valuechoice = Integer.parseInt(Allocator.nextLine());
				} catch (Exception e) {
					System.out.println("Not a value pool number.");
					continue;
				}
				for (int i = 0; i < tempvalues.length; i++) {
					if (tempvalues[i] == valuechoice && valuechoice != 0) {
						tempvalues[i] = 0;
						ok = true;
						AllocatedValues[order[z]] = valuechoice;
						break;
					}
				}
			} while (ok == false);
		}
		return AllocatedValues;
	}
	
	
	public static int[] AutoAllocator(int[] GeneratedValues) { //Point allocator method
		Scanner Allocator = new Scanner(System.in);
		int[] tempvalues = GeneratedValues.clone();
		int[] AllocatedValues = new int[6];
		Arrays.sort(tempvalues);
		AllocatedValues[order[0]] = tempvalues[5];
		tempvalues[5] = 0;
		AllocatedValues[order[1]] = tempvalues[4];
		tempvalues[4] = 0;
		for (int x = 0; x < 4; x++) {
			Random gen = new Random();
			for (int q = 0; q < 6; q++) {
				if (AllocatedValues[q] == 0) {
					while (AllocatedValues[q] == 0) {
						int randindex = gen.nextInt(4);
						if (tempvalues[randindex] !=0) {
							AllocatedValues[q] = tempvalues[randindex];
							tempvalues[randindex] = 0;
						}
					}
				}
					
			}
				
		}
		return AllocatedValues;
	}
	
			
}