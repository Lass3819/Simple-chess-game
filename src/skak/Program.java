package skak;

import java.awt.Color;

import javax.swing.JFrame;

public class Program {
	public static void main(String[] args) {
		app();	
	}
	
	
	
	public static void app() {
		Board board = new Board();
	
		Game game = new Game(board);
		
		
		
	
		
		DrawChessBoard chess = new DrawChessBoard(board, 700,700, game);
		
		chess.drawWindow();
		
		
		
		
		
		
	
		
		
	}
	
	
	
	
	public static void printBoard(Board board) {
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				if (board.getSquare(j,i).getPiece() != null) {
					System.out.print(board.getSquare(j,i).getPiece().getName() + " ");	
				}else {System.out.print("x" + " ");}
			}
			System.out.println();
		}
	
		





	}
	
	
	
	
	
	

}


