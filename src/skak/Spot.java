package skak;

class Spot {
	private Piece thisPiece;
	private int x;
	private int y;

	
	public Spot(int x, int y, Piece thisPiece) {
		this.x = x;
		this.y = y;
		this.thisPiece = thisPiece;
		
	}
	
	public Piece getPiece() {
		return thisPiece;
	}
	
	public void setPiece(Piece p) {
		thisPiece = p;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	

	public boolean checkEmpty() {
		if (thisPiece == null) {
			return true;
		}
		
		return false;
	}
	
	public void setEmpty() {
		thisPiece = null;
	}

	
	
}




