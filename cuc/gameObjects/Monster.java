package cuc.gameObjects;

//import java.util.Random;




import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
//import java.util.Random;

import cuc.GameWorld;
import cuc.states.ActorState;
//import cuc.states.MoveState;
//import cuc.states.StopState;
import cuc.utils.AmmoPara;
import cuc.utils.Point2D;



public class Monster extends Actor{
	Avatar avatar;    //货郎需要知道阿凡达在哪里
	Monster monster;
	public int range;
	public int number=0;
	public int count1=0;
	public Monster(GameWorld game, Point2D pos, Point2D size, int life, AmmoPara ammoPara) {
		super(game, pos, size, life, ammoPara);
		// TODO Auto-generated constructor stub
		
		avatar = gameWorld.getAvatar();   //向游戏世界获取阿凡达对象
		this.life=life;
		range = 300;       //设置反应距离
		}
		//重写状态更新函数，添加货郎独特的行为逻辑
	    public void update(){
	    	
	    	//检查阿凡达是否靠近自己
	    	if(Point2D.distance(this.pos, avatar.pos) <= range ){ 
	    		count1++;
	    		if(count1%25==0 &&avatar.life>=0) {
	    		shoot1(avatar.getPos());
	    		}
	    		if(this.curState.name != "stop"){   
	    			//为了面朝阿凡达，首先需要知道阿凡达的大致方向，
	    			//则利用Point2D的公开方法getCloestDirection计算
	    			int deirection = -Point2D.getCloestDirection(curState.animation.animPara.row,new Point2D(avatar.pos.x-pos.x,avatar.pos.y-pos.y));
//	    			curState.setCurDirection(deirection);  //面朝阿凡达
//	    			switchState("stop");   //转向静止状态
	    			
	    			if(life<=90) {	
	    				if(deirection==0)
	           			curState.setCurDirection(2);  //面朝阿凡达
	    				else if(deirection==1)
		           		curState.setCurDirection(3);  //面朝阿凡达
	    				if(deirection==2)
		           		curState.setCurDirection(0);  //面朝阿凡达
	    				if(deirection==3)
		           		curState.setCurDirection(1);  //面朝阿凡达
	        		}
	    		}    		
	    	}
	    	
	    	//转发给当前状态进行更新
	    	curState.update();    	
	    }   
	    /*
		 * 重写这个状态到期后的回调函数
		 * 让游戏角色负责决定下一个状态（而不是由状态自己决定）
		 */
		public void onStateFinish(ActorState state){		
			//当货郎的静止状态结束后，随机选择一个方向，让货郎转入行走状态
			
			if(state.name == "stop"){
//				 生成一个在[0, animRow)范围内的随机整数
//				Random random = new Random();				
//				int randomNumber = random.nextInt(animRow);
				//转向随机的新方向
				number+=5;
				if(number%4==0) {
				this.curState.setCurDirection(0);	
				this.switchState("move");
				}
				if(number%4==1) {
					this.curState.setCurDirection(1);	
					this.switchState("move");
					}
				if(number%4==2) {
					this.curState.setCurDirection(2);	
					this.switchState("move");
				}
				if(number%4==3) {
					this.curState.setCurDirection(3);	
					this.switchState("move");
				}
			}
			else if(state.name == "move" )	{   //如果结束的状态是行走状态，则转向静止状态			
				this.switchState("stop");
			}
			
		}
	
		public void keyPressed1(int key) {
			if( key == KeyEvent.VK_8 ){
				shoot1(avatar.getPos()); 
			}
		}
		public void mouseReleased1(MouseEvent e1) {
//			if( e1.isMetaDown() ){  //检测鼠标右键单击			
//				shoot1(new Point2D(e1.getX()+200,e1.getY()+200));  //朝着鼠标点击的位置开火
//				
//			}
		}	
}
