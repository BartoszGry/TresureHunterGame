package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;

	public final int screenX;
	public final int screenY;
	public int haveCoins = 0;
	public int[] haveKey = new int[5];

	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		screenX = gp.screenWidth / 2 - (GamePanel.tileSize / 2);
		screenY = gp.screeenHeight / 2 - (GamePanel.tileSize / 2);

		colisionArea = new Rectangle(8, 16, GamePanel.tileSize - 16, GamePanel.tileSize - 16);
		colisionAreaDeafultX = 8;
		colisionAreaDeafultY = 16;

		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {
		worldx = 14 * GamePanel.tileSize;
		worldy = 43 * GamePanel.tileSize;
		speed = 6;
		direction = "down";
	}

	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/tyl-frame0.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/tyl-frame1.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/przod-frame0.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/przod-frame1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if (keyH.downPressed == true || keyH.upPressed == true || keyH.leftPressed == true
				|| keyH.rightPressed == true) {

			if (keyH.upPressed == true) {

				direction = "up";
			} else if (keyH.downPressed == true) {

				direction = "down";
			} else if (keyH.rightPressed == true) {

				direction = "right";
			} else if (keyH.leftPressed == true) {

				direction = "left";
			}
			// kolizja
			colisionOn = false;
			gp.cDetector.checkTile(this);

			// klolizja z obiektami
			int objIndex = gp.cDetector.checkObject(this, true);
			pickUpObj(objIndex);

			// koniec gry
			if (haveCoins == 3) {
				gp.ui.gameFinished = true;
			}

			if (colisionOn == false) {
				switch (direction) {
				case "up":
					worldy -= speed;
					break;
				case "down":
					worldy += speed;
					break;
				case "left":
					worldx -= speed;
					break;
				case "right":
					worldx += speed;
					break;
				}
			}

			spriteCounter++;
			if (spriteCounter > 15) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
		playerOver(gp);
	}

	public void pickUpObj(int i) {

		if (i != 999) {
			if (i < 5) {
				gp.obj[i] = null;
				haveKey[i] = 1;
				gp.ui.showMessage("You got a key");
			}
			if (i > 4) {
				if (haveKey[0] == 1) {
					gp.obj[11] = null;
					gp.obj[12] = null;
					gp.ui.showMessage("Dors opened");
				}

				if (haveKey[1] == 1) {
					gp.obj[5] = null;
					gp.obj[6] = null;
					gp.ui.showMessage("Dors opened");
				}

				if (haveKey[2] == 1) {
					gp.obj[13] = null;
					gp.obj[14] = null;
					gp.ui.showMessage("Dors opened");
				}

				if (haveKey[3] == 1) {
					gp.obj[9] = null;
					gp.obj[10] = null;
					gp.ui.showMessage("Dors opened");
				}

				if (haveKey[4] == 1) {
					gp.obj[7] = null;
					gp.obj[8] = null;
					gp.ui.showMessage("Dors opened");
				}

			}

		}
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}

			break;
		case "left":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}

			break;

		case "right":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}

			break;

		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}

}
