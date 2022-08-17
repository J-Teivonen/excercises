import java.util.Random;

public class Allocation {
	
	public static Player[] TableSet(int player_count) {

		//loyalty and player generation
		Player[] players = new Player[player_count];
		
		for (int i = 0; i < player_count; i++) {
			players[i] = new Player();
			if (i == 0) {
				players[i].setLoyalty("Black Knight");
			}
			if (i % 2 == 0 && i != 0) {
				players[i].setLoyalty("Red Lineage");
			}
			else if (i != 0) {
				players[i].setLoyalty("White Lineage");
			}
		}
		
		//vassal position
		int playershuffle;
		int vassalnum = 21;
		Random randgen = new Random();
		
		for (int v = 0; v < vassalnum; v++) {
			playershuffle = randgen.nextInt(player_count);
			players[playershuffle].setVassals(players[playershuffle].getVassals() + 1);
		}
		
		//heir position
		int redHeirPos = randgen.nextInt(player_count + 1);
		int whiteHeirPos = randgen.nextInt(player_count + 1);
		
		if (redHeirPos < player_count) {
			players[redHeirPos].setRedHeir(true);
		}
		if (whiteHeirPos < player_count) {
			players[whiteHeirPos].setWhiteHeir(true);
		}
		
		//regent
		playershuffle = randgen.nextInt(player_count);
		players[playershuffle].setRegent(true);
		
		return players;
	}
}
