package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Coin;
import entity.Entity;
import entity.Player;
import entity.ShootingEnemy;
import key.TileManager;
import objects.SuperObject;

public class GamePanel extends JPanel implements Runnable {
//ustawienia obrazu
	final static int orginalTileSize = 16;
	final static int scale = 3;

	public static int tileSize = orginalTileSize * scale;
	public final int maxScreenCol = 16;
	public final int MaxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screeenHeight = tileSize * MaxScreenRow;

	// ustawienia swiata
	public final int maxWorldCol = 28;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

// fps
	int FPS = 60;
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	public UI ui = new UI(this);
	public Thread gameThread;
	public ColisionDetector cDetector = new ColisionDetector(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this, keyH);
	public ArrayList<Entity> entities;
	public SuperObject obj[] = new SuperObject[20];

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screeenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		createEntities();

	}

	public void setupGame() {
		aSetter.seyObejct();
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		while (gameThread != null) {

			update();

			repaint();

			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);

				nextDrawTime += drawInterval;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void update() {
		player.update();
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			entity.update();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		// tile
		tileM.draw(g2);
		// player
		player.draw(g2);
		// enteties
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			entity.draw(g2);
		}
		// objects
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		// interfejs uzytkownika
		ui.draw(g2);
		g2.dispose();

	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void createEntities() {
		entities = new ArrayList<>();
		entities.add(new Coin(this, 6, 2));
		entities.add(new Coin(this, 2, 7));
		entities.add(new Coin(this, 7, 6));
		entities.add(new ShootingEnemy(this, 17, 5));
		entities.add(new ShootingEnemy(this, 17, 11));
		entities.add(new ShootingEnemy(this, 22, 21));
		entities.add(new ShootingEnemy(this, 22, 28));
		entities.add(new ShootingEnemy(this, 4, 32));
	}
}
