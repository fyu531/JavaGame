package cuc;

import java.awt.Button;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics;  
import java.awt.event.MouseEvent;  
  
public class MainMenu extends GameWorld {  
    private Rectangle startButton;
    private Rectangle exitButton;
  
    public MainMenu(GameStarter game) {  
        super(game);  
        initMainMenu();
    }  
  
    private void initMainMenu() {
    	int buttonWidth=200;
    	int buttonHeight=50;
    	int startX=game.getWidth()/2-buttonWidth/2;
    	int startY=400;
    	
    	startButton=new Rectangle(startX,startY+100,buttonWidth,buttonHeight);
    	
    	 // 初始化exitButton  
        int exitX = startX; // 或者您可以根据需要设置不同的位置  
        int exitY = startY + buttonHeight + 200; // 在开始游戏按钮下方  
        exitButton = new Rectangle(exitX, exitY, buttonWidth, buttonHeight);
    }
    
    @Override
    public void render(Graphics g) {
//    	g.setColor(Color.LIGHT_GRAY);
    	g.setColor(Color.darkGray);
    	g.fillRect(0, 0, game.getWidth(), game.getHeight());
    	
    	g.setColor(Color.BLACK);
    	g.setFont(new Font("宋体",Font.BOLD,26));
    	g.drawString("请点击", game.getWidth()/2-50, 300);
    	
    	g.setColor(Color.WHITE);
    	g.fillRoundRect(startButton.x, startButton.y, startButton.width, startButton.height,0,0);
    	g.fillRoundRect(exitButton.x, exitButton.y, exitButton.width, exitButton.height,0,0);
   
    	g.setColor(Color.BLACK);
    	g.drawString("开始游戏", startButton.x+37, startButton.y+30);
    	g.drawString("结束游戏", exitButton.x+37, exitButton.y+30);
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    	int mouseX=e.getX();
    	int mouseY=e.getY();
    	
    	if(startButton.contains(mouseX,mouseY)) {
    		game.switchToGameWorld();
    	}
    	else if (exitButton.contains(mouseX,mouseY))
    	{
    		System.exit(0);
    	}
    }
}