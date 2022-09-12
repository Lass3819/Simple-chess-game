package skak;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class Window extends JPanel implements MouseListener {
	public Board board;
	//JFrame window = new JFrame("Chess");
	JPanel hej = new JPanel();
	int[] xConv = new int[8];
	int[] yConv = new int[8];
	
	Window(Board board){
		
		
		
		this.board = board;
		
		
		JPanel yourPanel = new JPanel();
		System.out.println(xConv[0]);
		yourPanel.setLocation(50,505);
		yourPanel.setSize(50,50);
		yourPanel.setOpaque(true);
		yourPanel.setBackground(Color.green);
		yourPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("hejhej");
			}
		});
		add(yourPanel);
		
		
		
		
	}
	
		
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int[] xConv = {(int)Math.round(getWidth()/22.9),(int)Math.round(getWidth()/6.1),(int)Math.round(getWidth()/3.5),(int)Math.round(getWidth()/2.5),(int)Math.round(getWidth()/1.9),(int)Math.round(getWidth()-getWidth()/2.8),(int)Math.round(getWidth()-getWidth()/4.25),(int)Math.round(getWidth()-getWidth()/8.6)};
		
		int[] yConv = {getHeight()/40,(int)Math.round(getHeight()/7),(int)Math.round(getHeight()/3.85),(int)Math.round(getHeight()/2.65),(int)Math.round(getHeight()/2.02),(int)Math.round(getHeight()/1.63),(int)Math.round(getHeight()/1.36),(int)Math.round(getHeight()/1.175)};
		
		
		
		
		ImageIcon chessBoard = new ImageIcon("Images//chessBoard2.png");
		
		ImageIcon blackPawn = new ImageIcon("Images//Pieces//blackPawn.png");
		ImageIcon blackKnight = new ImageIcon("Images//Pieces//blackKnight.png");
		ImageIcon blackQueen = new ImageIcon("Images//Pieces//blackQueen.png");
		ImageIcon blackRook = new ImageIcon("Images//Pieces//blackRook.png");
		ImageIcon blackBishop = new ImageIcon("Images//Pieces//blackBishop.png");
		ImageIcon blackKing = new ImageIcon("Images//Pieces//blackKing.png");
		
		ImageIcon whiteRook = new ImageIcon("Images//Pieces//whiteRook.png");
		ImageIcon whiteQueen = new ImageIcon("Images//Pieces//whiteQueen.png");
		ImageIcon whitePawn = new ImageIcon("Images//Pieces//whitePawn.png");
		ImageIcon whiteKnight = new ImageIcon("Images//Pieces//whiteKnight.png");
		ImageIcon whiteKing = new ImageIcon("Images//Pieces//whiteKing.png");
		ImageIcon whiteBishop = new ImageIcon("Images//Pieces//whiteBishop.png");
		
		ImageIcon[] blackPieces = {blackPawn, blackKnight, blackBishop, blackRook, blackQueen, blackKing};
		ImageIcon[] whitePieces = {whitePawn, whiteKnight, whiteBishop, whiteRook, whiteQueen, whiteKing};
		
		
			
		
		g.drawImage(chessBoard.getImage(),0,0,getWidth(),getHeight(),this);
		
		for ( int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.getSquare(i, j).getPiece()!= null) {
					ImageIcon[] colorToUse = new ImageIcon[8];
					if (board.getSquare(i, j).getPiece().isWhite()) {
						colorToUse = whitePieces;
					}else {colorToUse = blackPieces;}
					switch(board.getSquare(i, j).getPiece().name) {
					case "K":
						g.drawImage(colorToUse[5].getImage(),xConv[j],yConv[i],getWidth()/10,getHeight()/10,this);
						break;
					case "Q":
						g.drawImage(colorToUse[4].getImage(),xConv[j],yConv[i],getWidth()/10,getHeight()/10,this);
						break;
					case "R":
						g.drawImage(colorToUse[3].getImage(),xConv[j],yConv[i],getWidth()/10,getHeight()/10,this);
						break;
					case "B":
						g.drawImage(colorToUse[2].getImage(),xConv[j],yConv[i],getWidth()/10,getHeight()/10,this);
						break;
					case "N":
						g.drawImage(colorToUse[1].getImage(),xConv[j],yConv[i],getWidth()/10,getHeight()/10,this);
						break;
					case "P":
						g.drawImage(colorToUse[0].getImage(),xConv[j],yConv[i],getWidth()/10,getHeight()/10,this);
						break;
						
					
					}
					
					
					
					
				}
				
				
		
			}
		}
		
		
		
	}




	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("hej");
		
	}




	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("hej");
		
	}




	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("hej");
		
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("hej");
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("hej");
		
	}
	
	
    
	

	
}
