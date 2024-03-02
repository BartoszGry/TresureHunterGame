package objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class ObjKey extends SuperObject {

	BufferedImage blue, red, green, pink, gold;
	public int keyNumer;

	public ObjKey(int i) {

		this.keyNumer = i;

		getKeyImage();

	}

	public void getKeyImage() {
		try {
			blue = ImageIO.read(getClass().getResourceAsStream("/keys/blue.png"));
			red = ImageIO.read(getClass().getResourceAsStream("/keys/red.png"));
			pink = ImageIO.read(getClass().getResourceAsStream("/keys/pink.png"));
			green = ImageIO.read(getClass().getResourceAsStream("/keys/green.png"));
			gold = ImageIO.read(getClass().getResourceAsStream("/keys/gold.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2, GamePanel gp) {
		BufferedImage image = null;
		if (keyNumer == 1) {
			image = blue;
		}
		if (keyNumer == 2) {
			image = red;
		}
		if (keyNumer == 3) {
			image = pink;
		}
		if (keyNumer == 4) {
			image = green;
		}
		if (keyNumer == 5) {
			image = gold;
		}

		int screenX = worldX - gp.player.worldx + gp.player.screenX;
		int screenY = worldY - gp.player.worldy + gp.player.screenY;

		if (worldX + GamePanel.tileSize > gp.player.worldx - gp.player.screenX
				&& worldX - GamePanel.tileSize < gp.player.worldx + gp.player.screenX
				&& worldY + GamePanel.tileSize > gp.player.worldy - gp.player.screenY
				&& worldY - GamePanel.tileSize < gp.player.worldy + gp.player.screenY) {
			g2.drawImage(image, screenX, screenY, GamePanel.tileSize, GamePanel.tileSize, null);
		}
	}

}
