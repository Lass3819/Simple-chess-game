package skak;



public class Board {
	public Spot[][] squares = new Spot[8][8];
	public Board() {
		setBoard();
	}
	
	public Spot getSquare(int x, int y) {
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			System.out.println("Index out of bounds");
			return null;
		}
		
		
		return squares[x][y];
	}
	
	
	public void setBoard() {
		//setup black pieces
		squares[0][0] = new Spot(0,0, new Rook(false));
		squares[0][7] = new Spot(0,7, new Rook(false));
		squares[0][1] = new Spot(0,1,new Knight(false));
		squares[0][6] = new Spot(0,6,new Knight(false));
		squares[0][2] = new Spot(0,2,new Bishop(false));
		squares[0][5] = new Spot(0,5,new Bishop(false));
		squares[0][3] = new Spot(0,3,new Queen(false));
		squares[0][4] = new Spot(0,4,new King(false));
		for (int i = 0; i<8; i++) {
			squares[1][i] = new Spot(1,i,new Pawn(false));
		}
		//setup white pieces
		
		squares[7][0] = new Spot(7,0, new Rook(true));
		squares[7][7] = new Spot(7,7, new Rook(true));
		squares[7][1] = new Spot(7,1,new Knight(true));
		squares[7][6] = new Spot(7,6,new Knight(true));
		squares[7][2] = new Spot(7,2,new Bishop(true));
		squares[7][5] = new Spot(7,5,new Bishop(true));
		squares[7][3] = new Spot(7,3,new Queen(true));
		squares[7][4] = new Spot(7,4,new King(true));
		for (int i = 0; i < 8; i++) {
			squares[6][i] = new Spot(6,i,new Pawn(true));
		}
		
		//setup empty spaces
		
		for (int i = 0; i < 8; i++) {
			for (int j = 2; j < 6; j++) {
				squares[j][i] = new Spot(j,i,null);
			}
		}
		
		
	}

}
