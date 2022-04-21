package main;

import entity.Entity;

public class CollisionChecker {
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		int entityLeftWorldX = (int)entity.worldX +entity.solidArea.x;
		int entityRightWorldX = (int)entity.worldX +entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = (int)entity.worldY +entity.solidArea.y;
		int entityBottomWorldY = (int)entity.worldY +entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol  = entityRightWorldX/gp.tileSize;
		int entityTopRow  = entityTopWorldY/gp.tileSize;
		int entityBottomRow  = entityBottomWorldY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case "up":
		
			entityTopRow = (entityTopWorldY  - (int)entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				entity.collisionOn = true;
			} 
			
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY  + (int)entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				entity.collisionOn = true;
			} 
			
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX  - (int)entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				entity.collisionOn = true;
			} 
			
			break;
		case "right":
			entityRightCol = (entityRightWorldX  + (int)entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision ==true) {
				entity.collisionOn = true;
			} 
			
			
			break;
		}
		
	}
}
