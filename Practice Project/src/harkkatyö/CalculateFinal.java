package harkkatyö;
import java.util.Scanner;
import java.util.Random;

public class CalculateFinal {
	
	public static String[] dummyline = {"Str", "Dex", "Con", "Int", "Wis", "Cha"};
	//HitPoint Modifiers, Class
	public static int[] HitDice = {12, 8, 8, 8, 10, 8, 10, 10, 8, 6, 8, 6}; //Barbarian0, Bard1, Cleric2, Druid3, Fighter4, Monk5, Paladin6, Ranger7, Rogue8, Sorcerer9, Warlock10, Wizard11
	public static int[] Pref = {0, 5, 4, 4, 0, 1, 5, 1, 1, 5, 5, 3}; //Straight value index
	public static int[] SecPref = {2, 1, 2, 2, 2, 4, 0, 4, 3, 2, 2, 1}; //Straight value index
			
	//Caster Mod
	public static int[] Caster = {1, 2, 3, 6, 7, 9, 10, 11};
			
	//Ability Score Improvement Chart & Standard = Proficiency Chart
	public static String[] Standard = {"4", "8", "12", "16", "19"}; //Also for Proficiency, only when MORE --> increase
	public static String[] Fighter = {"4", "6", "8", "12", "14", "16", "19"}; //ClassID = 4
	public static String[] Rogue = {"4", "8", "10", "12", "16", "19"}; //ClassID = 8
			
	//Modifier Values
	public static int[] HillDwarf = {0,0,2,0,1,0}; //Hill Dwarf RACEID 0
	public static int[] HighElf = {0,2,0,1,0,0}; //High Elf RACEID 1
	public static int[] HalflingLightfoot = {0,2,0,0,0,1}; //Lightfoot RACEID 2
	public static int[] Human = {1,1,1,1,1,1}; //Normal, Alt check in point allocation RACEID 3, 14
	public static int[] Dragonborn = {2,0,0,0,0,1}; //RACEID 4
	public static int[] ForestGnome = {0,1,0,2,0,0, 0,0,1,2,0,0}; //Forest Gnome RACEID 5
	public static int[] HalfElf = {0,0,0,0,0,2}; //+2 points freely allocated, same check as Alt human RACEID 6, 14
	public static int[] HalfOrc = {2,0,1,0,0,0}; //RACEID 7
	public static int[] Tiefling = {0,0,0,1,0,2}; //RACEID 8
	public static int[] MountainDwarf = {2,0,2,0,0,0}; //Mountain Dwarf RACEID 9
	public static int[] WoodElf = {0,2,0,0,1,0}; //Wood Elf RACEID 10
	public static int[] DarkElf = {0,2,0,0,0,1}; //Dark Elf RACEID 11
	public static int[] HalflingStout = {0,2,1,0,0,0}; //Stout RACEID 12
	public static int[] RockGnome = {0,0,1,2,0,0}; //Rock Gnome RACEID 13
	public static int[][] RaceList = {HillDwarf, HighElf, HalflingLightfoot, Human, Dragonborn, ForestGnome, HalfElf, HalfOrc, Tiefling, MountainDwarf, WoodElf, DarkElf, HalflingStout, RockGnome};
			
			
	public static int[] main(int[] Values, int Race, int Class) {
		
		Scanner Allocator = new Scanner(System.in);
		
		//Race modifiers
		if (Race != 14) {
			for (int i = 0; i < Values.length; i++) {
				Values[i] = Values[i] + RaceList[Race][i];
			}
		}
		if (Race == 14 | Race == 6) {
			for (int j = 0; j <= 2; j++) {
				for (int z = 0; z < 6; z++) {	
					System.out.print(dummyline[z] + Values[z] + "\t" );
				}
				System.out.println("Choose a value to raise by one.");
				String ForbidChoice = "";
				String Choice = Allocator.nextLine();
				for (int k = 0; k < dummyline.length;) {
					if (Choice.equals(dummyline[k])) {
						if (Race == 6 & Choice.equals("Cha"))  {
							System.out.println("Value increased by default. Please choose another value.");
						} else if (Choice.equals(ForbidChoice)) {
							System.out.println("Value already increased. Please choose another value.");
						} else {
							Values[k]++;
							ForbidChoice = Choice;
							k++;
						}
					} else {
						System.out.println("Please type the desired Ability exactly. (Str, Dex, Con, Int, Wis, Cha)");
					}
				}
			}
		}
		
		//Ability Improvement boundaries
		int Level = 1;
		int AbilityImprovement = 0;
		System.out.println("Choose the level of the character.");
		Level = Integer.parseInt(Allocator.nextLine());
		if (Class != 4 | Class != 8) {
			for (int i = 0; i < Standard.length; i++) {
				if (Level >= Integer.parseInt(Standard[i])) {
					AbilityImprovement = AbilityImprovement + 2;
				}
			}
		}
		if (Class == 4) {
			for (int i = 0; i < Fighter.length; i++) {
				if (Level >= Integer.parseInt(Fighter[i])) {
					AbilityImprovement = AbilityImprovement + 2;
				}
			}
		}
		if (Class == 8) {
			for (int i = 0; i < Rogue.length; i++) {
				if (Level >= Integer.parseInt(Rogue[i])) {
					AbilityImprovement = AbilityImprovement + 2;
				}
			}
		}
		
		
		//Ability Improvement Manual Set
		if (AbilityImprovement > 0) {
			for (int j = 0; j <= AbilityImprovement;) {
				for (int z = 0; z < 6; z++) {	
					System.out.print(dummyline[z] + " " + Values[z] + "\t" );
				}
				System.out.println("Choose a value to raise by one. Points left: " + (AbilityImprovement - j));
				String Choice = Allocator.nextLine();
				for (int k = 0; k < dummyline.length; k++) {
					if (Choice.equals(dummyline[k])) {
						Values[k]++;
						j++;
						System.out.println(Choice + " increased!\n");
						break;
					} else if (k == dummyline.length-1 && !Choice.equals(dummyline[k])) {
						System.out.println("Type the appropriate Ability Score abbreviation.\n");
					}
				}
			}
		}
		//Proficiency
		int Prof = 2;
		for (int i = 0; i < Standard.length; i++) {
			if (Level > Integer.parseInt(Standard[i])) {
				Prof++;
			}
		}
		
		
		
		//AC, HitPoints, Spell Mods
		int AC = 10; //+Dex Mod
		int HitPoints = HitDice[Class] + ((Values[2] - 10) / 2);
		int SpellAttackMod = 0; //Might not be used
		int SpellSave = 0; //Might not be used
		
		boolean ok = false;
		System.out.println("Roll HitPoints? If you answer 'No', default value of " + ((HitDice[Class] /2) + 1) + " will be used. (y/n)");
		String Choice = Allocator.nextLine();
		while (ok == false) {
			if (Choice.equals("yes") | Choice.equals("y") | Choice.equals("Yes") ) {
				Random generator = new Random();
				for (int h = 1; h < Level; h++) {
					HitPoints = HitPoints + (generator.nextInt(HitDice[Class]) +1) + ((Values[2] - 10) / 2);
				}
				ok = true;
				System.out.println("HitPoint Max (Based on Hit Dice & Con): " + HitPoints);
			} else if (Choice.equals("no") | Choice.equals("n") | Choice.equals("No")) {
				for (int h = 1; h < Level; h++) {
					HitPoints = HitPoints + ((HitDice[Class] / 2) + 1) + ((Values[2] - 10) / 2);
				ok = true;
				System.out.println("HitPoint Max (Based on Hit Dice & Con): " + HitPoints);
				}
			}
		}
		System.out.println("Press Enter to continue");
		Allocator.nextLine();
		AC = AC + ((Values[1] - 10) / 2);
		System.out.println("Armor Class (Based on Dex): " + AC);
		System.out.println("Press Enter to continue");
		Allocator.nextLine();
		for (int i = 0; i < Caster.length; i++) {
			if (Class == Caster[i]) {
				SpellAttackMod = 8 + Prof + ((Pref[Class] - 10) / 2);
				SpellSave = Prof + ((Pref[Class] - 10) / 2);
				System.out.println("Spell Attack Modifier: " + SpellAttackMod + "\t" + "Spell Save DC: " + SpellSave);
			}
		}
		int[] CompleteSet = new int[12];
		for (int j = 0; j < Values.length; j++) {
			CompleteSet[j] = Values[j];
		}
		CompleteSet[6] = Level;
		CompleteSet[7] = Prof;
		CompleteSet[8] = AC;
		CompleteSet[9] = HitPoints;
		CompleteSet[10] = SpellAttackMod;
		CompleteSet[11] = SpellSave;
			
		return CompleteSet;
	}
	
	
	
	
	
//AUTOMATIC SYTEM FOR QUICK BUILD
	
	public static int[] auto(int[] Values, int Race, int Class) {
		
		//Race modifiers
		if (Race != 14) {
			for (int i = 0; i < Values.length; i++) {
				Values[i] = Values[i] + RaceList[Race][i];
			}
		}
		if (Race == 14 | Race == 6) {
			Random generator = new Random();
				if (Race == 6)  {
					int inc1 = 0;
					int inc2 = 0;
					while (inc1 == inc2) {
						inc1 = generator.nextInt(5);
						inc2 = generator.nextInt(5);
					}
					Values[inc1]++;
					Values[inc2]++;
					
				} else {
					int inc1 = 0;
					int inc2 = 0;
					while (inc1 == inc2) {
						inc1 = generator.nextInt(6);
						inc2 = generator.nextInt(6);
					}
					Values[inc1]++;
					Values[inc2]++;
			}
		}

		
		//Ability Improvement boundaries
		Scanner Allocator = new Scanner(System.in);
		int Level = 1;
		int AbilityImprovement = 0;
		System.out.println("Choose the level of the character.");
		Level = Integer.parseInt(Allocator.nextLine());
		if (Class != 4 | Class != 8) {
			for (int i = 0; i < Standard.length; i++) {
				if (Level >= Integer.parseInt(Standard[i])) {
					AbilityImprovement = AbilityImprovement + 2;
				}
			}
		}
		if (Class == 4) {
			for (int i = 0; i < Fighter.length; i++) {
				if (Level >= Integer.parseInt(Fighter[i])) {
					AbilityImprovement = AbilityImprovement + 2;
				}
			}
		}
		if (Class == 8) {
			for (int i = 0; i < Rogue.length; i++) {
				if (Level >= Integer.parseInt(Rogue[i])) {
					AbilityImprovement = AbilityImprovement + 2;
				}
			}
		}
		
		
		//Ability Improvement Manual Set
		if (AbilityImprovement > 0) {
			Random generator = new Random();
			for (int j = 0; j <= AbilityImprovement; j++) {
				int inp = generator.nextInt(6);
				Values[inp]++;
			}
		}
		//Proficiency
		int Prof = 2;
		for (int i = 0; i < Standard.length; i++) {
			if (Level > Integer.parseInt(Standard[i])) {
				Prof++;
			}
		}
		
		
		
		//AC, HitPoints, Spell Mods
		int AC = 10; //+Dex Mod
		int HitPoints = HitDice[Class] + ((Values[2] - 10) / 2);
		int SpellAttackMod = 0; //Might not be used
		int SpellSave = 0; //Might not be used
				Random generator = new Random();
				for (int h = 1; h < Level; h++) {
					HitPoints = HitPoints + (generator.nextInt(HitDice[Class]) +1) + ((Values[2] - 10) / 2);
				}
		AC = AC + ((Values[1] - 10) / 2);
		for (int i = 0; i < Caster.length; i++) {
			if (Class == Caster[i]) {
				SpellAttackMod = Prof + ((Values[Pref[Class]] - 10) / 2);
				SpellSave = 8 + Prof + ((Values[Pref[Class]] - 10) / 2);
			}
		}
		int[] CompleteSet = new int[12];
		for (int j = 0; j < Values.length; j++) {
			CompleteSet[j] = Values[j];
		}
		CompleteSet[6] = Level;
		CompleteSet[7] = Prof;
		CompleteSet[8] = AC;
		CompleteSet[9] = HitPoints;
		CompleteSet[10] = SpellAttackMod;
		CompleteSet[11] = SpellSave;
			
		return CompleteSet;
	}

}


