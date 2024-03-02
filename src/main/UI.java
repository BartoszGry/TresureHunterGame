package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI {
	GamePanel gp;
	Font arial_40, arial_80b;
	public String message = "";
	public boolean messageOn = false;
	int messageCounter = 0;
	public boolean gameFinished = false;
	public boolean gameOver = false;
	public double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");

	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 30);
		arial_80b = new Font("Arial", Font.BOLD, 80);
	}

	public void draw(Graphics2D g2) {

		if (gameFinished == true) {
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			String text;
			int textLenght;
			int x;
			int y;
			if (gameOver == true) {
				g2.setFont(arial_80b);
				g2.setColor(Color.red);
				text = "You died";
				textLenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

				x = gp.screenWidth / 2 - textLenght + 120;
				y = gp.screeenHeight / 2 - 48;
				g2.drawString(text, x, y);
				gp.gameThread = null;

			} else {
				text = "Your time is:" + dFormat.format(playTime);
				textLenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

				x = gp.screenWidth / 2 - textLenght;
				y = gp.screeenHeight / 2 - 48;
				g2.drawString(text, x, y);

				g2.setFont(arial_80b);
				g2.setColor(Color.yellow);
				text = "Congratulations";

				x = gp.screenWidth / 2 - textLenght - 15;
				y = gp.screeenHeight / 2 + 48;
				g2.drawString(text, x, y);

				gp.gameThread = null;

			}
		} else {
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			g2.drawString("blue=" + gp.player.haveKey[0] + "red=" + gp.player.haveKey[1] + "pink="
					+ gp.player.haveKey[2] + "green=" + gp.player.haveKey[3] + "gold=" + gp.player.haveKey[4], 20, 40);

			// time
			playTime += (double) 1 / 60;
			g2.drawString("Time:" + dFormat.format(playTime), GamePanel.tileSize * 11, 40);

			// mesagge
			if (messageOn == true)
				g2.drawString(message, 20, 80);
			;
			messageCounter++;
			if (messageCounter > 120) {
				messageCounter = 0;
				messageOn = false;
			}

		}
	}

	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}

}
