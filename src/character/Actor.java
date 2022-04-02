package character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Actor {
	
	public int x, y, actorSize;
	public int jumpHeight = 50;
	public int health = 100;
	
	
	public Actor(int x, int y, int actorSize, int health) {
		this.x = x;
		this.y = y;
		this.actorSize = actorSize;
		this.health = health;
	}
	
	public void Jump(JPanel game) {
		//this.y -= jumpHeight;
		//game.repaint();
		Timer timer = new Timer(450, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				y += jumpHeight;
				game.repaint();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	public BufferedImage getImage() {
		BufferedImage image = null;
		try {
			 image = ImageIO.read(new File("image\\Actor.png"));
			 return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
	
	
}
