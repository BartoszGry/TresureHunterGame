package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Bullet extends Entity {

	GamePanel gp;
	private boolean right;

	public Bullet(GamePanel gp, int x, int y, boolean right) {
		this.worldx = x;
		this.worldy = y;

		if (right == true) {
			direction = "right";
		} else {
			direction = "left";
		}

		this.gp = gp;
		this.right = right;
		colisionOn = false;
		colisionArea = new Rectangle(0, 0, GamePanel.tileSize, GamePanel.tileSize);
		getPlayerImage();
	}

	public void getPlayerImage() {
		try {
			coin = ImageIO.read(getClass().getResourceAsStream("/bullet/bullet.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

		gp.cDetector.checkTile(this);
		if (colisionOn == true) {

			gp.getEntities().remove(this);
		}

		if (right) {
			worldx += 1;
		} else {
			worldx -= 1;
		}
	}

	@Override
	public void draw(Graphics2D g2) {
		BufferedImage image;
		image = coin;
		int screenX = worldx - gp.player.worldx + gp.player.screenX;
		int screenY = worldy - gp.player.worldy + gp.player.screenY;

		if (worldx + GamePanel.tileSize > gp.player.worldx - gp.player.screenX
				&& worldx - GamePanel.tileSize < gp.player.worldx + gp.player.screenX
				&& worldy + GamePanel.tileSize > gp.player.worldy - gp.player.screenY
				&& worldy - GamePanel.tileSize < gp.player.worldy + gp.player.screenY) {

			if (right) {
				g2.drawImage(image, screenX + GamePanel.tileSize, screenY, -GamePanel.tileSize, GamePanel.tileSize,
						null);

			} else {
				g2.drawImage(image, screenX, screenY, GamePanel.tileSize, GamePanel.tileSize, null);
			}
		}

	}

}
