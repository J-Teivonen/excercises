
public class Faction {
	
	private String loyalty = "";
	private boolean ownHeir = false;
	private boolean regent = false;
	private int pointstotal = 0;
	private boolean winner = false;

	public String getLoyalty() {
		return loyalty;
	}
	public void setLoyalty(String loyalty) {
		this.loyalty = loyalty;
	}
	public boolean isOwnHeir() {
		return ownHeir;
	}
	public void setOwnHeir(boolean ownHeir) {
		this.ownHeir = ownHeir;
	}
	public boolean isRegent() {
		return regent;
	}
	public void setRegent(boolean regent) {
		this.regent = regent;
	}
	public int getPointstotal() {
		return pointstotal;
	}
	public void setPointstotal(int pointstotal) {
		this.pointstotal = pointstotal;
	}
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
}
