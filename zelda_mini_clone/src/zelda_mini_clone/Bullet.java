package zelda_mini_clone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Rectangle {
	
	public int speed = 8;
	
	public int dirs = 1;
	
	public int dirh = 1;
	
	public int frames = 0;
	
	public Bullet(int x, int y, int dir) {
		super(x+16, y+16, 8, 8);
		this.dirs = dir;
		
	}
	
	public void tick() {
		x+=speed*dirs;
		frames++;
		if(frames == 200) {
			Player.bullets.remove(this);
			return;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, width, height);
	}
		
}
