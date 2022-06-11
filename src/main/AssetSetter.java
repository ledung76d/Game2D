package main;

import entity.NPC_Oldman;
import monster.MON_GreenSlime;
import object.OBJ_Axe;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {		
		int i =0;
		gp.obj[i] = new OBJ_Key(gp);
		gp.obj[i].worldX = gp.tileSize*25;
		gp.obj[i].worldY = gp.tileSize*23;
		i++;
		gp.obj[i] = new OBJ_Key(gp);
		gp.obj[i].worldX = gp.tileSize*25;
		gp.obj[i].worldY = gp.tileSize*19;
		i++;
		gp.obj[i] = new OBJ_Axe(gp);
		gp.obj[i].worldX = gp.tileSize*33;
		gp.obj[i].worldY = gp.tileSize*21;
		i++;
		gp.obj[i] = new OBJ_Shield_Blue(gp);
		gp.obj[i].worldX = gp.tileSize*34;
		gp.obj[i].worldY = gp.tileSize*21;
		i++;
		gp.obj[i] = new OBJ_Potion_Red(gp);
		gp.obj[i].worldX = gp.tileSize*22;
		gp.obj[i].worldY = gp.tileSize*34;
		i++;
		
		
	}
	public void setNPC() {
		gp.npc[0] = new NPC_Oldman(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
		

		
	}
	public void setMonster() {
		int i = 0;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize*27;
		gp.monster[i].worldY = gp.tileSize*21;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize*23;
		gp.monster[i].worldY = gp.tileSize*36;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize*23;
		gp.monster[i].worldY = gp.tileSize*42;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize*23;
		gp.monster[i].worldY = gp.tileSize*37;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize*34;
		gp.monster[i].worldY = gp.tileSize*42;
		i++;
		gp.monster[i] = new MON_GreenSlime(gp);
		gp.monster[i].worldX = gp.tileSize*38;
		gp.monster[i].worldY = gp.tileSize*42;
		
		

		
		
		
	}
	
}
