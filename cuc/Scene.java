package cuc;

//import java.awt.Graphics;
//
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;

import javax.swing.ImageIcon;

//import cuc.gameObjects.Avatar;
//import cuc.gameObjects.GameObject;
//import cuc.gameObjects.Monster;
//import cuc.gameObjects.Tree;
//import cuc.gameObjects.Vender;
//import cuc.states.MoveState;
//import cuc.states.StopState;
//import cuc.utils.AmmoPara;
//import cuc.utils.AnimPara;
//import cuc.utils.Animation2D;
//import cuc.utils.Point2D;
//import cuc.utils.SoundPara;

public class Scene extends GameWorld{

	public Scene(GameStarter game) {
		super(game);
		// TODO Auto-generated constructor stub
		initScene();
	}
	void initScene() {

		// 初始化场景1的背景图和前景图
		bImage = new ImageIcon(getClass().getClassLoader().getResource("images/huodong_1.jpg")).getImage();
		fImage = new ImageIcon(getClass().getClassLoader().getResource("images/huodong_1_2.png")).getImage();

//		initAllParas(); // 初始化所有的资源参数对象
//		initAllGameObjects(); // 初始化所有的游戏对象

	}
}
	


