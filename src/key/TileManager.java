package key;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];

	public TileManager(GamePanel gp) {
		this.gp = gp;
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		tile = new Tile[10];
		getTileImage();
		loadMap("/maps/mapa.txt");
	}

	public void getTileImage() {

		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[0].collison = true;

			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/woda.png"));
			tile[2].collison = true;

			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[3].collison = true;

			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ziemia.png"));

			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/piasek.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadMap(String nazwaMapy) {

		try {
			InputStream is = getClass().getResourceAsStream(nazwaMapy);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			int col = 0;
			int row = 0;
			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();
				while (col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {

		}

	}

	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;

		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			int tileNum = mapTileNum[worldCol][worldRow];

			int worldX = worldCol * GamePanel.tileSize;
			int worldY = worldRow * GamePanel.tileSize;
			int screenX = worldX - gp.player.worldx + gp.player.screenX;
			int screenY = worldY - gp.player.worldy + gp.player.screenY;

			if (worldX + GamePanel.tileSize > gp.player.worldx - gp.player.screenX
					&& worldX - GamePanel.tileSize < gp.player.worldx + gp.player.screenX
					&& worldY + GamePanel.tileSize > gp.player.worldy - gp.player.screenY
					&& worldY - GamePanel.tileSize < gp.player.worldy + gp.player.screenY) {
				g2.drawImage(tile[tileNum].image, screenX, screenY, GamePanel.tileSize, GamePanel.tileSize, null);
			}
			worldCol++;

			if (worldCol == gp.maxWorldCol) {
				worldCol = 0;

				worldRow++;

			}
		}

	}

}