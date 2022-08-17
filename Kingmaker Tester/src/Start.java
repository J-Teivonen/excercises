import java.util.*;

public class Start {

	public static void main(String[] args) {
		Scanner perim = new Scanner(System.in);
		System.out.println("Number of players(int):");
		int player_count = perim.nextInt();
		System.out.println("Number of tests(int):");
		int testnum = perim.nextInt();
		
		int bk_wins = 0;
		int rl_wins = 0;
		int wl_wins = 0;
		
		for (int t = 0; t < testnum; t++) {
			Player[] tablestatus = Allocation.TableSet(player_count);
			Faction[] factionscores = Scoring.FactionScore(tablestatus);
			System.out.println("Red Lineage: " + factionscores[0].getPointstotal() + "\t White Lineage: " + factionscores[1].getPointstotal() + 
					" \t Black Knight: " + factionscores[2].getPointstotal());
		
			for (Faction win : factionscores) {
				if (win.isWinner()) {
					System.out.println(win.getLoyalty() + " wins the game!\n");
					if (win.getLoyalty().equals("Red Lineage")) {
						rl_wins++;
					}
					else if (win.getLoyalty().equals("White Lineage")) {
						wl_wins++;
					}
					else if (win.getLoyalty().equals("Black Knight")) {
						bk_wins++;
					} else {
						for (Faction wtf : factionscores) {
							if (wtf.isRegent()) {
								System.out.println(wtf.getLoyalty());
							}
						}
					}
					
				}
			}
		
			
		}
		System.out.println("\n\nTest results: \nRed wins:\t" + rl_wins + "\nWhite wins:\t" + wl_wins + "\nBlack Knight wins:\t" + bk_wins + 
				"\n\nWin percentages: RL " + Double.valueOf(rl_wins)/testnum*100 + " WL " + Double.valueOf(wl_wins)/testnum*100 + " BK " + Double.valueOf(bk_wins)/testnum*100);
		
		perim.close();
	}

}
