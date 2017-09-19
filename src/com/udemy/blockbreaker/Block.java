package com.udemy.blockbreaker;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

public class Block extends Rectangle {
	Image pic;
	Block(int a, int b, int h, int w, String s) {
		x = a; 
		y = b; 
		height = h;
		width = w;
		pic = Toolkit.getDefaultToolkit().getImage(s);
	}
	
	public void draw(Graphics g, Component c) {
		g.drawImage(pic, x, y, height, width, c);
	}
}
