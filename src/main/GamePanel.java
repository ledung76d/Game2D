package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTINGS
	final int originalTileSize = 16;
	final int scale =3;
	
	public  int tileSize = originalTileSize * scale;
	public  int maxScreenCol = 16;
	public  int maxScreenRow = 12;
	public  int screenWidth = tileSize * maxScreenCol;
	public  int screenHeight = tileSize*maxScreenRow;
	//WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize*maxWorldCol;
	public final int worldHeight = tileSize*maxWorldRow;
	
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	
	public Player player = new Player(this,keyH);
	
	
	//Set player default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	//Zoom camera
	public void zoomInOut(int i) {
		int oldWorldWidth =  tileSize * maxWorldCol;
		tileSize +=i;
		
		int newWorldWidth = tileSize * maxWorldCol;
		
		
		player.speed = (double)newWorldWidth/600;
		double multiplier =(double)newWorldWidth/oldWorldWidth;
		
		System.out.println("tileSize: " + tileSize);
		System.out.println("worldWidth: " + newWorldWidth);
		System.out.println("player worldX: " + player.worldX);
		
		double newPlayerWorldX = player.worldX*multiplier;
		double newPlayerWorldY = player.worldY*multiplier;
		
		player.worldX = newPlayerWorldX;
		player.worldY = newPlayerWorldY;
		
	}
	
	public void startGameThread() 
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime)/ drawInterval;
			timer +=(currentTime - lastTime);
			
			lastTime = currentTime;
			
			if(delta >= 1) {

				update();
				repaint();
				delta--;
				drawCount++;
			
			}		
			if(timer >= 1000000000) {
				//System.out.println("FPS:"+drawCount);
				drawCount = 0;
				timer=0;
			}
			
		}
	}
	
	
	public void update() {
		player.update();
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D)g;
		
		tileM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}
	
	
}
