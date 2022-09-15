package zelda_mini_clone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable, KeyListener{

	public static int WIDTH = 1600, HEIGHT = 896;
	public static int SCALE = 5;
	public static Player player;
	public World world;
	public List<Enemy> enemys = new ArrayList<Enemy>();
	
	public Main() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		new Spritesheet();
		player = new Player(32, 32);
		world = new World();
		enemys.add(new Enemy(1535, 32));
		enemys.add(new Enemy(1535, 32*2));
		enemys.add(new Enemy(1535, 32*3));
		enemys.add(new Enemy(1535, 32*4));
		enemys.add(new Enemy(1535, 32*5));
		enemys.add(new Enemy(1535, 32*6));
		enemys.add(new Enemy(1535, 32*7));
	}
	
	public void tick() {
		
		player.tick();
		
		for(int i = 0; i < enemys.size(); i++) {
			enemys.get(i).tick();
		}
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(0, 135, 13));
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		for(int i = 0; i < enemys.size(); i++) {
			enemys.get(i).render(g);
		}
		
		player.render(g);
		
		world.render(g);
		
		bs.show();
	}
	
	public static void main(String[] args) {
		
		Main game = new Main();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setTitle("Mini Zelda");
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		new Thread(game).start();

	}
	
	@Override
	public void run() {
		
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.down = true;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		//Tiro
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			player.shoot = true;
		}
		
		// Movimentação
		if(e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player.up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			player.down = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
