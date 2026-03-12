package cuc;  
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.event.MouseEvent;  

public class Startup extends GameWorld{  
    private Image startupImage;  
    private boolean animationFinished;  
  
    public Startup(GameStarter game) {  
        super(game);  
        initStartupAnimation();
        animationFinished=false;
        JOptionPane.showMessageDialog(null, "202312033018计科傅泉智");
    }  
  
    private void initStartupAnimation() {
    	startupImage=new ImageIcon(getClass().getClassLoader().getResource("images/unknown(18).gif")).getImage();
    } 
  
    @Override
    public void render(Graphics g) {
    	g.drawImage(startupImage, 0, 0, 1500, 1140, null);
    }
    
  
    @Override  
    public void mouseReleased(MouseEvent e) { 
    	if(e.isMetaDown())
    	animationFinished=true;
    }  
    
    @Override
    public void update() {
    	if(animationFinished) {
    		game.switchToMainMenu();
    	}
    }
    
}