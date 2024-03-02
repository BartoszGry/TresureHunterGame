package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.GamePanel;

public abstract class Entity {

	public int worldx, worldy;
	public int speed;

	public BufferedImage up1, up2, down1, down2, coin, bullet, sEnemy;
	public String direction;

	public int spriteCounter = 0;
	public int spriteNum = 1;

	public Rectangle colisionArea;
	public int colisionAreaDeafultX, colisionAreaDeafultY;

	public boolean colisionOn = false;

	public abstract void update();

	public abstract void draw(Graphics2D g2);

	public void playerOver(GamePanel gamePanel) {
		ArrayList<Entity> entitiesToRemove = new ArrayList<>();
		for (int i = 0; i < gamePanel.getEntities().size(); i++) {
			Entity entity = gamePanel.getEntities().get(i);
			if (entity != this) {
				if (worldx + GamePanel.tileSize > entity.worldx && worldx < entity.worldx + GamePanel.tileSize
						&& worldy + GamePanel.tileSize > entity.worldy && worldy < entity.worldy + GamePanel.tileSize) {
					if (entity instanceof Coin) {
						entitiesToRemove.add(entity);
						gamePanel.player.haveCoins++;
					} else if (entity instanceof Bullet || entity instanceof ShootingEnemy) {
						gamePanel.ui.gameFinished = true;
						gamePanel.ui.gameOver = true;
					}
				}
			}
		}
		gamePanel.getEntities().removeAll(entitiesToRemove);
	}
}
