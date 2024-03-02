package objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {

	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle colisionArea = new Rectangle(0, 0, 48, 48);
	public int colisionAreaDeafultX = 0;
	public int colisionAreaDeafultY = 0;

	public void draw(Graphics2D g2, GamePanel gp) {

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
