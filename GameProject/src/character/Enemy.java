package character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Enemy {
	
	int x, y, width, height, speed;
	private int xStart;
	
	public Enemy(int x, int y, int width, int height, int speed, JPanel game) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.xStart = x;
		move(game);
	}
	
	public void move(JPanel game) {
		Timer timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				x -= speed;
				game.repaint();
				if (x < 0) {
					x = xStart;
				}
			}
		});
		timer.start();
	}
	
	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			 image = ImageIO.read(new File("image\\Enemy.png"));
			 return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
}
