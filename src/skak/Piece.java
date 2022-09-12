package skak;

abstract class  Piece {
	
	private boolean Alive = true;
	private boolean White;
	protected boolean castleAllowed;
	protected String name;
	
	public Piece(boolean _white) {
		White = _white;
	}
	
	public boolean isAlive() {
		return Alive;
	}
	
	public boolean isWhite() {
		return White;
	}
	
	public void kill() {
		Alive = false;
	}
	public String getName() {
		return name;
	}
	public abstract boolean legalMove(Board board, Move move);
	
	
}

class King extends Piece {
	
	boolean castleMoveAllowed = true;
	
	public King(boolean _white) {
		super(_white);
		this.name = "K";
	}
		
	
	public  boolean legalMove(Board board, Move move) {
		if (castleMoveAllowed && move.endSquare.getY() == 6) {
			if (board.getSquare(move.startSquare.getX(),5).getPiece()== null && board.getSquare(move.startSquare.getX(),6).getPiece()==null && board.getSquare(move.startSquare.getX(),7).getPiece()!=null) {
				if ( board.getSquare(move.startSquare.getX(),7).getPiece().getName() == "R") {
					board.getSquare(move.startSquare.getX(),5).setPiece(board.getSquare(move.startSquare.getX(),7).getPiece());
					board.getSquare(move.startSquare.getX(),7).setEmpty();
					
					castleMoveAllowed = false;	
					return true;
				}
				
				
			}
		}
		
		if (castleMoveAllowed && move.endSquare.getY() == 2) {
			if (board.getSquare(move.startSquare.getX(),3).getPiece()== null && board.getSquare(move.startSquare.getX(),2).getPiece()==null && board.getSquare(move.startSquare.getX(),1).getPiece()==null && board.getSquare(move.startSquare.getX(),0).getPiece()!=null) {
				if ( board.getSquare(move.startSquare.getX(),0).getPiece().getName() == "R") {
						
					board.getSquare(move.startSquare.getX(),3).setPiece(board.getSquare(move.startSquare.getX(),0).getPiece());
					board.getSquare(move.startSquare.getX(),0).setEmpty();
					
					castleMoveAllowed = false;	
					return true;
				}
				
				
			}
		}
		
		
		if (Math.abs(move.startSquare.getX()-move.endSquare.getX())>1 || Math.abs(move.startSquare.getY()-move.endSquare.getY())>1) {
			
			return false;
		}
		
		
		
		castleMoveAllowed = false;
		return true;
	}
	
	
}
class Queen extends Piece{
	public Queen(boolean _white) {
		super(_white);
		this.name = "Q";
	}
	
	public  boolean legalMove(Board board, Move move) {
		int a = move.endSquare.getX()-move.startSquare.getX();
		int b = move.endSquare.getY()-move.startSquare.getY();
		int signA = (int)Math.signum(a);
		int signB = (int)Math.signum(b);
		
		if (Math.abs(a)==Math.abs(b)) {
			for ( int i = 1; i<Math.abs(a); i++) {
				if (board.getSquare(move.startSquare.getX()+signA*i,move.startSquare.getY()+signB*i).getPiece()!=null) {
					return false;
				}
				
					
				}
			return true;
		}
		if (a == 0) {
			for ( int i = 1; i<Math.abs(b); i++) {
				if (board.getSquare(move.startSquare.getX(),move.startSquare.getY()+signB*i).getPiece()!=null) {
					return false;
				}
			}
			
			return true;
		}
		if (b == 0) {
			for ( int i = 1; i<Math.abs(a); i++) {
				if (board.getSquare(move.startSquare.getX()+signA*i,move.startSquare.getY()).getPiece()!=null) {
					return false;
				}
			}
			
			return true;
		}
		
		
		
		return false;
	}
}

class Pawn extends Piece{
	public Pawn(boolean _white) {
		super(_white);
		this.name = "P";
		
	}
	
	public  boolean legalMove(Board board, Move move) {
		if (Math.abs(move.startSquare.getY()-move.endSquare.getY())>0 && move.endSquare.getPiece()==null) {
			
			return false;
		}
		if (super.isWhite() == true) {
			if (move.startSquare.getX()-move.endSquare.getX()<0) {
				return false;
			}
			if (move.startSquare.getX()==6) {
				if (Math.abs(move.startSquare.getX()-move.endSquare.getX())>2) {
					
					return false;
				
				}
				if ( board.getSquare(5,move.startSquare.getY()).getPiece() !=null) {
					
					return false;
				}
			}else {if (Math.abs(move.startSquare.getX()-move.endSquare.getX())>1) {
				return false;}}
			
		}else {
			if (move.startSquare.getX()-move.endSquare.getX()>0) {
				return false;
			}
			if (move.startSquare.getX()==1) {
				if (Math.abs(move.startSquare.getX()-move.endSquare.getX())>2) {
					return false;
				}
				if ( board.getSquare(2,move.startSquare.getY()).getPiece() !=null) {
					return false;}
			}else {if (Math.abs(move.startSquare.getX()-move.endSquare.getX())>1) {
				return false;}}
		}
		if (move.startSquare.getY()==move.endSquare.getY()&& move.endSquare.getPiece()!=null) {
			return false;
		}
		if (move.startSquare.getX()==move.endSquare.getX())
		{
			return false;
		}
		if (super.isWhite() && move.endSquare.getX()==0) {
			
			move.startSquare.setPiece(new Queen(true));
		}
		if (super.isWhite() == false && move.endSquare.getX()==7) {
			
			move.startSquare.setPiece(new Queen(false));
		}
		
		return true;
	}
}

class Knight extends Piece{
	public Knight(boolean _white) {
		super(_white);
		this.name = "N";
	}
	
	public  boolean legalMove(Board board, Move move) {
		if (Math.abs(move.startSquare.getX()-move.endSquare.getX())==2 && Math.abs(move.startSquare.getY()-move.endSquare.getY())==1) {
			return true;
		}else if( Math.abs(move.startSquare.getX()-move.endSquare.getX())==1 && Math.abs(move.startSquare.getY()-move.endSquare.getY())==2) {
			return true;
		}
		
		return false;
	}
}

class Bishop extends Piece{
	public Bishop(boolean _white) {
		super(_white);
		this.name = "B";
	}
	public  boolean legalMove(Board board, Move move) {
		int a = move.endSquare.getX()-move.startSquare.getX();
		int b = move.endSquare.getY()-move.startSquare.getY();
		int signA = (int)Math.signum(a);
		int signB = (int)Math.signum(b);
		
		if (Math.abs(a)==Math.abs(b)) {
			for ( int i = 1; i<Math.abs(a); i++) {
				if (board.getSquare(move.startSquare.getX()+signA*i,move.startSquare.getY()+signB*i).getPiece()!=null) {
					return false;
				}
				
					
				}
			return true;
		}
		
		
		
		
		
		return false;
	}
}

class Rook extends Piece{
	
	public Rook(boolean _white) {
		super(_white);
		this.name = "R";
		
	}
	
	
	
	public  boolean legalMove(Board board, Move move) {
		int a = move.endSquare.getX() - move.startSquare.getX();
		int b =  move.endSquare.getY() - move.startSquare.getY();
		int signA = (int)Math.signum(a);
		int signB = (int)Math.signum(b);
		
		if (a == 0) {
			for ( int i = 1; i<Math.abs(b); i++) {
				if (board.getSquare(move.startSquare.getX(),move.startSquare.getY()+signB*i).getPiece()!=null) {
					return false;
				}
			}
			castleAllowed = false;
			return true;
		}
		if (b == 0) {
			for ( int i = 1; i<Math.abs(a); i++) {
				if (board.getSquare(move.startSquare.getX()+signA*i,move.startSquare.getY()).getPiece()!=null) {
					return false;
				}
			}
			castleAllowed = false;
			return true;
		}
		
		
		return false;
	}
	
}

	

