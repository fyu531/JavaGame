package cuc.gameObjects;

import javax.swing.*;
import java.awt.*;


public class GLabel extends JLabel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Color backgroundColor; // 背景颜色
    private Color borderColor;     // 边框颜色
    private int borderWidth; // 边框宽度

    // 构造函数，可以添加自定义的初始化逻辑
    public GLabel(String text,Color borderColor, int borderWidth) {
        super(text);
//        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        // 设置其他自定义属性，比如字体、大小等
//        setOpaque(true); // 设置为不透明，以便可以绘制背景
    }

    // 重写paintComponent方法以添加自定义的绘制逻辑
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 首先调用父类的绘制方法，以确保文本等被正确绘制

        // 绘制背景
        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        // 绘制边框
        if (borderColor != null) {
            g.setColor(borderColor);
            // 绘制加粗的边框，通过绘制一个更大的内部矩形来实现
            g.drawRect(borderWidth /2, borderWidth /2, getWidth() - borderWidth*2, getHeight() - borderWidth*2);
        }
    }
}