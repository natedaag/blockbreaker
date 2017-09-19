package com.udemy.blockbreaker;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BlockBreakerPanel extends JPanel {
	
	ArrayList<Block> blocks = new ArrayList<>();	
	
	BlockBreakerPanel() {
		for(int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 0, 25, 60, "blue.png"));
		}
		for(int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 25, 25, 60, "red.png"));
		}
		for(int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 50, 25, 60, "yellow.png"));
		}
		for(int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 75, 25, 60, "green.png"));
		}
	}
	
	public void paintComponent(Graphics g) {
		for (Block b : blocks) {
			b.draw(g,  this);
		}
	}
}
