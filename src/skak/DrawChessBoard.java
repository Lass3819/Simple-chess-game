package skak;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.Format;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawChessBoard extends JPanel implements MouseListener{
	public Board board;
	public int xDim;
	public int yDim;
	public int clickCount;
	public MouseEvent storeMouseEvent;
	public Game game;
	
	
	
	public void paintComponent(Graphics g) {
		g.fillRect(50,50,600,600);
		for (int i = 50; i<=600; i+=150) {
			for(int j = 50; j  <=600; j+=150) {
				g.clearRect(i, j, 75, 75);
			}
		}
		
		for (int i = 125; i<=600; i+=150) {
			for(int j = 125; j  <=600; j+=150) {
				g.clearRect(i, j, 75, 75);
			}
		}
		
		
		
		int[] xConv = {53,128,203,278,353,428,503,578};
		
		int[] yConv = {53,128,203,278,353,428,503,578};
		
		
		
		
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
		
		
			
		
		//g.drawImage(chessBoard.getImage(),0,0,getWidth(),getHeight(),this);
		
		for ( int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board.getSquare(i, j).getPiece()!= null) {
					ImageIcon[] colorToUse = new ImageIcon[8];
					if (board.getSquare(i, j).getPiece().isWhite()) {
						colorToUse = whitePieces;
					}else {colorToUse = blackPieces;}
					switch(board.getSquare(i, j).getPiece().name) {
					case "K":
						g.drawImage(colorToUse[5].getImage(),xConv[j],yConv[i],70,70,this);
						break;
					case "Q":
						g.drawImage(colorToUse[4].getImage(),xConv[j],yConv[i],70,70,this);
						break;
					case "R":
						g.drawImage(colorToUse[3].getImage(),xConv[j],yConv[i],70,70,this);
						break;
					case "B":
						g.drawImage(colorToUse[2].getImage(),xConv[j],yConv[i],70,70,this);
						break;
					case "N":
						g.drawImage(colorToUse[1].getImage(),xConv[j],yConv[i],70,70,this);
						break;
					case "P":
						g.drawImage(colorToUse[0].getImage(),xConv[j],yConv[i],70,70,this);
						break;
						
					
					}
					
					
					
					
				}
				
				
		
			}
		}
		
	
		
	}
	

	JFrame jf = new JFrame();
	public DrawChessBoard(Board board, int xDim, int yDim,Game game) {
		this.board = board;
		this.xDim = xDim;
		this.yDim = yDim;
		this.game = game;
		
		
		
		
		
	}
	public void drawWindow() {
		JFrame jf = new JFrame();
		jf.setSize(xDim,yDim);
		jf.setTitle("Chess");
		jf.setLocation(-1000,300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel yourPanel = new JPanel();
		
		yourPanel.setLocation(50,50);
		yourPanel.setSize(600,600);
		yourPanel.setOpaque(false);
		yourPanel.setBackground(Color.green);
		yourPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				
				clickCount++;
				if (clickCount % 2 ==1) {
					storeMouseEvent = e;
				}else {
					game.playerMove(translate(storeMouseEvent)[1],translate(storeMouseEvent)[0],translate(e)[1],translate(e)[0]);
					int[] event = {translate(storeMouseEvent)[0],translate(storeMouseEvent)[1],translate(e)[0],translate(e)[1]};
					System.out.println(String.format("(%s,%s)->(%s,%s)",event[1],event[0],event[3],event[2]));
					repaint();
					
					
					
					
					
					
				}
				
			
				
				
				
				
			}				
			
		});
		jf.add(yourPanel);
		
		jf.add(this);
		jf.setVisible(true);
	}
	

	public int[] translate(MouseEvent e) {
		int[] result = new int[2];
		for (int i = 0; i < 8; i++) {
			if (i*75 <= e.getX() && e.getX()<(i+1)*75)
				for (int j = 0; j < 8; j++){
					if (j*75 <= e.getY() && e.getY()<(j+1)*75) {
						result[0] = i;
						result[1] = j;
						//System.out.println(String.format("%s,%d",i,j));
						
						
					}
				}
			
			
			
			 
			}

		
		return result;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("hejhej");
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("hejhej");
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("hejhej");
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("hejhej");
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
