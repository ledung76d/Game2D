package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed,enterPressed,shotKeyPressed;
	//DEBUG
	boolean checkDrawTime = false;
	
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		
		//TILE STATE
		if(gp.gameState == gp.titleState) {
			titleState(code);
		}
		//PLAY STATE
		else if(gp.gameState == gp.playState) {
			playState(code);
		}
		//PAUSE STATE
		else if(code == KeyEvent.VK_P) {
			pauseState(code);
		}
		//DIALOGUE STATE
		else if(gp.gameState == gp.dialogueState) {
			dialogueState(code);
		}
		//Character state
		else if(gp.gameState == gp.characterState) {
			characterState(code);
		}
		
		
		
	}
	public void titleState(int code) {
		if(gp.ui.titleScreenState == 0) {

			if(code == KeyEvent.VK_W ) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			if(code == KeyEvent.VK_S  ) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			if(code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
					//gp.gameState = gp.playState;
					gp.ui.titleScreenState = 1;
					//gp.playMusic(0);
				}
				if(gp.ui.commandNum == 1) {
					
				}
				if(gp.ui.commandNum == 2) {
					System.exit(0);
				}
			}
		
		}
		else if(gp.ui.titleScreenState == 1) {

			if(code == KeyEvent.VK_W ) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 3;
				}
			}
			if(code == KeyEvent.VK_S  ) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 3) {
					gp.ui.commandNum = 0;
				}
			}
			if(code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
					//gp.gameState = gp.playState;
					System.out.println("do some fighter specific stuff");
					gp.gameState = gp.playState;
				}
				if(gp.ui.commandNum == 1) {
					System.out.println("do some fighter specific stuff");
					gp.gameState = gp.playState;
				}
				if(gp.ui.commandNum == 2) {
					gp.gameState = gp.playState;
				}
				if(gp.ui.commandNum == 3) {
					gp.gameState = gp.titleState;
					gp.ui.titleScreenState = 0;
					gp.ui.commandNum = 0;
				}
			}
		
		}	
		
	}
	public void playState(int code) {
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN ) {
			downPressed =true;
		}
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		if(code == KeyEvent.VK_C) {
			gp.gameState = gp.characterState;
		}
		
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
		if(code == KeyEvent.VK_P) {
			gp.gameState = gp.pauseState;
		}
		if(code == KeyEvent.VK_F) {
			shotKeyPressed = true;
		}
		
		
		//DEBUG
		if(code == KeyEvent.VK_T) {
			if(checkDrawTime == false) {
				checkDrawTime = true;
			}else if(checkDrawTime == true) {
				checkDrawTime = false;
			}
		}
	}
	public void pauseState(int code) {
		if(gp.gameState == gp.pauseState) {
			gp.gameState = gp.playState;
		}
	}
	public void dialogueState(int code) {
		if(code == KeyEvent.VK_ENTER) {
			gp.gameState = gp.playState;
		}
	}
	
	public void characterState(int code) {
		if(code == KeyEvent.VK_C) {
			gp.gameState = gp.playState;
		}
		if(code == KeyEvent.VK_W) {
			if(gp.ui.slotRow !=0) {
				gp.ui.slotRow--;
				gp.playSE(9);	
			}
		}
		if(code == KeyEvent.VK_A) {
			if(gp.ui.slotCol!=0) {
				gp.ui.slotCol--;
				gp.playSE(9);	
			}
		}
		if(code == KeyEvent.VK_S) {
			if(gp.ui.slotRow != 3) {
				gp.ui.slotRow++;
				gp.playSE(9);	
			}
		}
		if(code == KeyEvent.VK_D) {
			if(gp.ui.slotCol != 4) {
				gp.ui.slotCol++;
				gp.playSE(9);
			}
		}
		if(code == KeyEvent.VK_ENTER) {
			gp.player.selectItem();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
		if(code == KeyEvent.VK_F) {
			shotKeyPressed = false;
		}

	}

	
}
