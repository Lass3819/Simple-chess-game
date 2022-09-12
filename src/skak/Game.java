package skak;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public Board board;

	public List<Move> moveHistory = new ArrayList<>();
	public int moveNumber = 0;
	
	public Game(Board board) {
		//reset variables board and moveHistory.
		this.board = board;
		board.setBoard();
	
		
		
		
	}
	public void playerMove(int startX, int startY, int endX, int endY) {
		Spot startSquare = board.getSquare(startX, startY);
		Spot endSquare = board.getSquare(endX, endY);
		Move move = new Move(startSquare,endSquare);
		moveHistory.add(move);
		makeMove(board, move);
		
	}
	
	public void makeMove(Board board, Move move) {
				
		if (move.startSquare == move.endSquare) {
			System.out.println("You cannot move a piece to the same square it already is on.");
			return;
		}
		
		if (move.startSquare.getPiece()!= null && move.endSquare.getPiece()!= null) {
			if (move.startSquare.getPiece().isWhite() == move.endSquare.getPiece().isWhite()) {
				System.out.println("You cannot move to a square already occupied by your own piece.");
				return;
			}
		}
		
		
		
		if (move.startSquare.getPiece()!= null) {
			if (move.startSquare.getPiece().isWhite() && moveNumber%2 == 0) {
				if (move.startSquare.getPiece().legalMove(board, move)) {
					move.endSquare.setPiece(move.startSquare.getPiece());
					move.startSquare.setEmpty();
					moveNumber+=1;
					System.out.println("Making move");
					
				}else {
				System.out.println("Illegal move");
				
				}
			}else if(!move.startSquare.getPiece().isWhite() && moveNumber%2 == 1) {
				if (move.startSquare.getPiece().legalMove(board, move)) {
					move.endSquare.setPiece(move.startSquare.getPiece());
					move.startSquare.setEmpty();
					moveNumber+=1;
					System.out.println("Making move");
					
				}else {
				System.out.println("Illegal move");
				
				}
				
			}
			
			
			
			
			
			
		}
		
		
		
	}
	
	
	
}
