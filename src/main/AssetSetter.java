package main;

import java.io.IOException;

import javax.imageio.ImageIO;

import objects.ObjDors;
import objects.ObjKey;

public class AssetSetter {

	GamePanel gp;

	public AssetSetter(GamePanel gp) {
		this.gp = gp;

	}

	public void seyObejct() {
		gp.obj[0] = new ObjKey(1);

		gp.obj[0].worldX = 23 * GamePanel.tileSize;
		gp.obj[0].worldY = 2 * GamePanel.tileSize;

		gp.obj[1] = new ObjKey(2);

		gp.obj[1].worldX = 2 * GamePanel.tileSize;
		gp.obj[1].worldY = 26 * GamePanel.tileSize;

		gp.obj[2] = new ObjKey(3);

		gp.obj[2].worldX = 11 * GamePanel.tileSize;
		gp.obj[2].worldY = 44 * GamePanel.tileSize;

		gp.obj[3] = new ObjKey(4);

		gp.obj[3].worldX = 3 * GamePanel.tileSize;
		gp.obj[3].worldY = 16 * GamePanel.tileSize;

		gp.obj[4] = new ObjKey(5);

		gp.obj[4].worldX = 20 * GamePanel.tileSize;
		gp.obj[4].worldY = 47 * GamePanel.tileSize;

		gp.obj[5] = new ObjDors();
		try {
			gp.obj[5].image = ImageIO.read(getClass().getResourceAsStream("/dors/redLeft.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		gp.obj[5].worldX = 7 * GamePanel.tileSize;
		gp.obj[5].worldY = 40 * GamePanel.tileSize;

		gp.obj[6] = new ObjDors();
		try {
			gp.obj[6].image = ImageIO.read(getClass().getResourceAsStream("/dors/redRight.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		gp.obj[6].worldX = 8 * GamePanel.tileSize;
		gp.obj[6].worldY = 40 * GamePanel.tileSize;

		gp.obj[7] = new ObjDors();
		try {
			gp.obj[7].image = ImageIO.read(getClass().getResourceAsStream("/dors/goldRight.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		gp.obj[7].worldX = 21 * GamePanel.tileSize;
		gp.obj[7].worldY = 40 * GamePanel.tileSize;

		gp.obj[8] = new ObjDors();
		try {
			gp.obj[8].image = ImageIO.read(getClass().getResourceAsStream("/dors/goldLeft.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		gp.obj[8].worldX = 20 * GamePanel.tileSize;
		gp.obj[8].worldY = 40 * GamePanel.tileSize;

		gp.obj[9] = new ObjDors();
		try {
			gp.obj[9].image = ImageIO.read(getClass().getResourceAsStream("/dors/greenLeft.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		gp.obj[9].worldX = 21 * GamePanel.tileSize;
		gp.obj[9].worldY = 16 * GamePanel.tileSize;

		gp.obj[10] = new ObjDors();
		try {
			gp.obj[10].image = ImageIO.read(getClass().getResourceAsStream("/dors/greenRight.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		gp.obj[10].worldX = 22 * GamePanel.tileSize;
		gp.obj[10].worldY = 16 * GamePanel.tileSize;

		gp.obj[11] = new ObjDors();
		try {
			gp.obj[11].image = ImageIO.read(getClass().getResourceAsStream("/dors/blueLeft.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		gp.obj[11].worldX = 6 * GamePanel.tileSize;
		gp.obj[11].worldY = 12 * GamePanel.tileSize;

		gp.obj[12] = new ObjDors();
		try {
			gp.obj[12].image = ImageIO.read(getClass().getResourceAsStream("/dors/blueRight.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		gp.obj[12].worldX = 7 * GamePanel.tileSize;
		gp.obj[12].worldY = 12 * GamePanel.tileSize;

		gp.obj[13] = new ObjDors();
		try {
			gp.obj[13].image = ImageIO.read(getClass().getResourceAsStream("/dors/pinkLeft.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		gp.obj[13].worldX = 4 * GamePanel.tileSize;
		gp.obj[13].worldY = 22 * GamePanel.tileSize;

		gp.obj[14] = new ObjDors();
		try {
			gp.obj[14].image = ImageIO.read(getClass().getResourceAsStream("/dors/pinkRight.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		gp.obj[14].worldX = 5 * GamePanel.tileSize;
		gp.obj[14].worldY = 22 * GamePanel.tileSize;

	}

}
