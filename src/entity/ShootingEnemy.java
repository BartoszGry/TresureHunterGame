package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ShootingEnemy extends Entity {

	private final int framesPerShoot = 200;
	private int frame;
	GamePanel gp;

	public ShootingEnemy(GamePanel gp, int x, int y) {
		this.gp = gp;
		this.worldx = x * GamePanel.tileSize;
		this.worldy = y * GamePanel.tileSize;
		getPlayerImage();
		frame = 0;

	}

	public void getPlayerImage() {
		try {

			sEnemy = ImageIO.read(getClass().getResourceAsStream("/enemies/shootingEnemy.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

		frame += 1;
		if (frame > framesPerShoot) {
			shootTwoBullets();
			frame = 0;
		}

	}

	private void shootTwoBullets() {
		gp.getEntities().add(new Bullet(gp, worldx, worldy, true));
		gp.getEntities().add(new Bullet(gp, worldx, worldy, false));
	}

	@Override
	public void draw(Graphics2D g2) {
		BufferedImage image;
		image = sEnemy;
		int screenX = worldx - gp.player.worldx + gp.player.screenX;
		int screenY = worldy - gp.player.worldy + gp.player.screenY;

		if (worldx + GamePanel.tileSize > gp.player.worldx - gp.player.screenX
				&& worldx - GamePanel.tileSize < gp.player.worldx + gp.player.screenX
				&& worldy + GamePanel.tileSize > gp.player.worldy - gp.player.screenY
				&& worldy - GamePanel.tileSize < gp.player.worldy + gp.player.screenY) {
			g2.drawImage(image, screenX, screenY, GamePanel.tileSize, GamePanel.tileSize, null);
		}

	}

}
