
public class Scoring {
	
	public static Faction[] FactionScore(Player[] tablestatus) {
		Faction[] factions = new Faction[3];
		factions[0] = new Faction();
		factions[0].setLoyalty("Red Lineage");
		factions[1] = new Faction();
		factions[1].setLoyalty("White Lineage");
		factions[2] = new Faction();
		factions[2].setLoyalty("Black Knight");
		
		//red
		for (Player rp : tablestatus) {
			if (rp.getLoyalty().matches("Red Lineage")) {
				rp.setPlayerscore(rp.getVassals());
				if (rp.isRedHeir()) {
					rp.setPlayerscore(rp.getPlayerscore() + 10);
					factions[0].setOwnHeir(true);
				}
				if (rp.isRegent()) {
					rp.setPlayerscore(rp.getPlayerscore() + 5);
					factions[0].setRegent(true);
					System.out.println("R");
				}
				factions[0].setPointstotal(factions[0].getPointstotal() + rp.getPlayerscore());
			}
		}
		
		//white
		for (Player wp : tablestatus) {
			if (wp.getLoyalty().matches("White Lineage")) {
				if (tablestatus.length != 6) {
					wp.setPlayerscore(wp.getVassals());
				} else {
					wp.setPlayerscore(wp.getVassals()/2); // SECRET PLAYER COUNT MOD
				}
				if (wp.isWhiteHeir()) {
					wp.setPlayerscore(wp.getPlayerscore() + 10);
					factions[1].setOwnHeir(true);
				}
				if (wp.isRegent()) {
					wp.setPlayerscore(wp.getPlayerscore() + 5);
					factions[1].setRegent(true);
					System.out.println("W");
				}
				factions[1].setPointstotal(factions[1].getPointstotal() + wp.getPlayerscore());	
			}
		}
		
		//black knight
		for (Player bk : tablestatus) {
			int heirs_in_discard = 2;
			if (bk.getLoyalty().matches("Black Knight")) { 
				if (tablestatus.length < 7) {
					bk.setPlayerscore(bk.getVassals()*2); //BLACK KNIGHT POITNS MOD
				} else {
					bk.setPlayerscore(bk.getVassals()*3);
				}
				for (Player heirPos : tablestatus) {
					if (heirPos.isWhiteHeir() == true) {
						heirs_in_discard--;
					}
					if (heirPos.isRedHeir() == true) {
						heirs_in_discard--;
					}
				}
				bk.setPlayerscore(bk.getPlayerscore() + (10 * heirs_in_discard));
				if (bk.isRegent()) {
					bk.setPlayerscore(bk.getPlayerscore() + 10);
					factions[2].setRegent(true);
				}
				factions[2].setPointstotal(factions[2].getPointstotal() + bk.getPlayerscore());
			}
		}
		
		int winnerscore = Math.max(factions[0].getPointstotal(), Math.max(factions[1].getPointstotal(), factions[2].getPointstotal()));
		int tiecheck = 0;
		for (Faction f : factions) {
			if (winnerscore == f.getPointstotal()) {
				tiecheck++;
			}
		}
			
		if (tiecheck > 1) {
			System.out.println("!!!  TIE   !!!");
			if (factions[0].getPointstotal() == winnerscore && factions[0].isOwnHeir() == true) {
				if (factions[1].getPointstotal() == winnerscore && factions[1].isOwnHeir() == true) {
					for (Faction fa : factions) {
						if (fa.isRegent()) {
							fa.setWinner(true);
							return factions;
						}
					}
				} else {
					factions[0].setWinner(true);
					return factions;
				}
			} else if (factions[1].getPointstotal() == winnerscore && factions[1].isOwnHeir() == true) {
				factions[1].setWinner(true);
				return factions;
			} else {
				for (Faction fa : factions) {
					if (fa.isRegent() && fa.getPointstotal() == winnerscore) {
						fa.setWinner(true);
						return factions;
					}
					if (fa.isRegent() && fa.getPointstotal() != winnerscore) {
						factions[2].setWinner(true);
						return factions;
					}
				}
			}
		} else {
			for (Faction win : factions) {
				if (winnerscore == win.getPointstotal()) {
					win.setWinner(true);
				}
			}
		}
		return factions;
		
	}
	
	
	public static boolean RedHeirOwnership(Player[] tablestatus) {
		for (Player rh : tablestatus) {
			if (rh.getLoyalty().equals("Red Lineage")) {
				if (rh.isRedHeir()) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean WhiteHeirOwnership(Player[] tablestatus) {
		for (Player wh : tablestatus) {
			if (wh.getLoyalty().equals("White Lineage")) {
				if (wh.isWhiteHeir()) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean RegentTitle(Player[] tablestatus, String Faction) {
		for (Player reg : tablestatus) {
			if (reg.getLoyalty().equals(Faction)) {
				if (reg.isRegent()) {
					return true;
				}
			}
		}
		return false;
	}
	
}
