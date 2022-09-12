package skak;

public class Player {
	public boolean isWhite;
	public Player(boolean white) {
		this.isWhite = white;
	}
	public boolean isWhiteside() {
		return isWhite;
	}
}
