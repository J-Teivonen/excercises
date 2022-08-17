
public class Player {
	
	private String loyalty = "";
	private int vassals = 0;
	private boolean redHeir = false;
	private boolean whiteHeir = false;
	private int playerscore = 0;
	private boolean regent = false;
	
	public String getLoyalty() {
		return loyalty;
	}
	public void setLoyalty(String loyalty) {
		this.loyalty = loyalty;
	}
	public int getVassals() {
		return vassals;
	}
	public void setVassals(int vassals) {
		this.vassals = vassals;
	}
	public boolean isRedHeir() {
		return redHeir;
	}
	public void setRedHeir(boolean redHeir) {
		this.redHeir = redHeir;
	}
	public boolean isWhiteHeir() {
		return whiteHeir;
	}
	public void setWhiteHeir(boolean whiteHeir) {
		this.whiteHeir = whiteHeir;
	}
	public int getPlayerscore() {
		return playerscore;
	}
	public void setPlayerscore(int playerscore) {
		this.playerscore = playerscore;
	}
	public boolean isRegent() {
		return regent;
	}
	public void setRegent(boolean regent) {
		this.regent = regent;
	}
}
