package zelda_mini_clone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {
	
	
	public static List<Blocks> blocks = new ArrayList<Blocks>();
	
	public World() {
		for(int xx = 0; xx < 15*4; xx++) {
			blocks.add(new Blocks(xx*32, 0));
		}
		for(int xx = 0; xx < 15*4; xx++) {
			blocks.add(new Blocks(xx*32, 896 - 32));
		}
		for(int yy = 0; yy < 15*4; yy++) {
			blocks.add(new Blocks(0, yy*32));
		}
		for(int yy = 0; yy < 15*4; yy++) {
			blocks.add(new Blocks(1600 - 32, yy*32));
		}
		
		for(int xx = 5; xx < 23; xx++) {
			blocks.add(new Blocks(32*15,32*xx));
		}
		for(int yy = 5; yy < 16; yy++) {
			blocks.add(new Blocks(32*yy, 32*10));
		}
		for(int yy = 15; yy < 26; yy++) {
			blocks.add(new Blocks(32*yy, 32*20));
		}
		
	}
	
	public static boolean isFree(int x, int y) {
		for(int i = 0; i < blocks.size(); i++) {
			Blocks currentBlock = blocks.get(i);
			if(currentBlock.intersects(new Rectangle(x, y, 32, 32))) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
	public void render(Graphics g) {
		
		for(int i = 0; i < blocks.size(); i++)
			blocks.get(i).render(g);
		
	}

}
