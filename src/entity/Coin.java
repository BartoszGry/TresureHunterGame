package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Coin extends Entity {

	GamePanel gp;

	public Coin(GamePanel gp, int x, int y) {
		this.worldx = x * GamePanel.tileSize;
		this.worldy = y * GamePanel.tileSize;

		this.gp = gp;
		getPlayerImage();
	}

	public void getPlayerImage() {
		try {

			coin = ImageIO.read(getClass().getResourceAsStream("/coin/coin.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

	}

	public void draw(Graphics2D g2) {
		BufferedImage image;
		image = coin;
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
