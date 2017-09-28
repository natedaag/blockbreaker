package com.udemy.blockbreaker;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

public class Block extends Rectangle {
	Image pic;
	int dx = 3;
	int dy = -3;
	Rectangle left;
	Rectangle right;
	boolean destroyed = false;
	boolean powerUp = false;
	Block(int a, int b, int h, int w, String s) {
		x = a; 
		y = b; 
		width = w;
		height = h;
		left = new Rectangle(a - 1, b, 1, h);
		right = new Rectangle(a + w + 1, b, 1, h);
		pic = Toolkit.getDefaultToolkit().getImage(s);
	}
	
	public void draw(Graphics g, Component c) {
		if (!destroyed){
			g.drawImage(pic, x, y, height, width, c);
		}	
	}
}
