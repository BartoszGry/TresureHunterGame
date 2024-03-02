package main;

import entity.Entity;

public class ColisionDetector {

	GamePanel gp;

	public ColisionDetector(GamePanel gp) {
		this.gp = gp;
	}

	public void checkTile(Entity entityp) {
		if (entityp != null) {
			int entityLeftX = entityp.worldx + entityp.colisionArea.x;
			int entityRightX = entityp.worldx + entityp.colisionArea.x + entityp.colisionArea.width;
			int entityTopY = entityp.worldy + entityp.colisionArea.y;
			int entityBottomY = entityp.worldy + entityp.colisionArea.y + entityp.colisionArea.width;

			int entityLeftCol = entityLeftX / GamePanel.tileSize;
			int entityRightCol = entityRightX / GamePanel.tileSize;
			int entityTopRow = entityTopY / GamePanel.tileSize;
			int entityBottomRow = entityBottomY / GamePanel.tileSize;

			int tileNum1, tileNum2;

			switch (entityp.direction) {
			case "up":
				entityTopRow = (entityTopY - entityp.speed) / GamePanel.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				if (gp.tileM.tile[tileNum1].collison == true || gp.tileM.tile[tileNum2].collison == true) {
					entityp.colisionOn = true;
				}
				break;
			case "down":
				entityBottomRow = (entityBottomY + entityp.speed) / GamePanel.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
				if (gp.tileM.tile[tileNum1].collison == true || gp.tileM.tile[tileNum2].collison == true) {
					entityp.colisionOn = true;
				}
				break;

			case "left":
				entityLeftCol = (entityLeftX - entityp.speed) / GamePanel.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				if (gp.tileM.tile[tileNum1].collison == true || gp.tileM.tile[tileNum2].collison == true) {
					entityp.colisionOn = true;
				}
				break;

			case "right":
				entityRightCol = (entityRightX + entityp.speed) / GamePanel.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
				if (gp.tileM.tile[tileNum1].collison == true || gp.tileM.tile[tileNum2].collison == true) {
					entityp.colisionOn = true;
				}
				break;

			}
		}
	}

	public int checkObject(Entity entity, boolean player) {

		int index = 999;
		for (int i = 0; i < gp.obj.length; i++) {
			if (gp.obj[i] != null) {
				entity.colisionArea.x = entity.worldx + entity.colisionArea.x;
				entity.colisionArea.y = entity.worldy + entity.colisionArea.y;
				gp.obj[i].colisionArea.x = gp.obj[i].worldX + gp.obj[i].colisionArea.x;
				gp.obj[i].colisionArea.y = gp.obj[i].worldY + gp.obj[i].colisionArea.y;

				switch (entity.direction) {
				case "up":
					entity.colisionArea.y -= entity.speed;
					if (entity.colisionArea.intersects(gp.obj[i].colisionArea)) {
						if (gp.obj[i].collision == true) {
							entity.colisionOn = true;
						}
						if (player == true) {
							index = i;
						}

					}
					break;
				case "down":
					entity.colisionArea.y += entity.speed;
					if (entity.colisionArea.intersects(gp.obj[i].colisionArea)) {
						if (gp.obj[i].collision == true) {
							entity.colisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "left":
					entity.colisionArea.x -= entity.speed;
					if (entity.colisionArea.intersects(gp.obj[i].colisionArea)) {
						if (gp.obj[i].collision == true) {
							entity.colisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "right":
					entity.colisionArea.x += entity.speed;
					if (entity.colisionArea.intersects(gp.obj[i].colisionArea)) {
						if (gp.obj[i].collision == true) {
							entity.colisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				}

				entity.colisionArea.x = entity.colisionAreaDeafultX;
				entity.colisionArea.y = entity.colisionAreaDeafultY;
				gp.obj[i].colisionArea.x = gp.obj[i].colisionAreaDeafultX;
				gp.obj[i].colisionArea.y = gp.obj[i].colisionAreaDeafultY;

			}
		}

		return index;
	}
}
