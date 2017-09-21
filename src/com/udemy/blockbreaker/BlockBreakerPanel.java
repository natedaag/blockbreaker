package com.udemy.blockbreaker;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BlockBreakerPanel extends JPanel implements KeyListener {
	
	ArrayList<Block> blocks = new ArrayList<>();
	ArrayList<Block> ball = new ArrayList<>(); 
	Block paddle;
	Thread thread;
	Animate animate;
	int size = 25;
	BlockBreakerPanel() {
		paddle = new Block(175, 480, 90, 10, "paddle.png");
		for(int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 0, 60, 25, "blue.png"));
		}
		for(int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 25, 60, 25, "red.png"));
		}
		for(int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 50, 60, 25, "yellow.png"));
		}
		for(int i = 0; i < 8; i++) {
			blocks.add(new Block((i * 60 + 2), 75, 60, 25, "green.png"));
		}
		ball.add(new Block(237, 437, 25, 25, "ball.png"));
		addKeyListener(this);
		setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Block b : blocks) 
			b.draw(g,  this);
		for (Block b : ball) 
			b.draw(g,  this);
		paddle.draw(g,  this);
	}
		
	public void update() {
/* ball goes straight up from paddle - doesn't break any blocks.
 * changed from video x's and y's are reversed.  not sure why. */
		for (Block ba : ball) {
			ba.y += ba.dy;
			if(ba.y > (getWidth() - size) && ba.dy > 0 || ba.y < 0) 
				ba.y *= -1;
			if(ba.x < 0 || ba.intersects(paddle)); 
				ba.dx *= -1;
			ba.x += ba.dx;
/* with following code, ball should change direction as it hits block 
 * as it is, it destroys blocks it touches, but doesn't stop, or change
 * direction.  as before it goes to top and hovers erratically. 9.06 of 9.16*/
			for(Block b : blocks) {
				if(ba.intersects(b) && !b.destroyed){
				b.destroyed = true;
				ba.dx *= -1;
				}
			}
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			animate = new Animate(this);
			thread = new Thread(animate);
			thread.start();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x > 0){
			paddle.x -= 15;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddle.x < (getWidth() - paddle.height)){
			paddle.x += 15;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
