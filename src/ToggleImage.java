import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ToggleImage extends JPanel implements KeyListener{
	
	private MovingImage firstaid;
	private MovingImage water;
	private MovingImage current;
	private boolean iswitched;
	
	public ToggleImage()
	{
		super(null);
		setFocusable(true);
		
		iswitched = false;
		firstaid = new MovingImage ("FirstAid.jpg", 100, 100, 200, 260);
		water = new MovingImage("Water.png", 100, 100, 200, 260);
		addKeyListener(this);  
		run();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		firstaid.draw(g, this);
		water.draw(g, this);
	}
	
	public void run()
	{
		if (iswitched)
		{

		}
		else
		{

		}
	}
	
	public void keyTyped(KeyEvent e) {
		// not useful
	}

	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{	
			iswitched = true;
			
			firstaid.setVisible(false);    // set it to be visible, while the other is invisible
			water.setVisible(true);
			
			try
			{
				Thread.sleep(10);
			}
			catch(Exception ex){}
			
			repaint();
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			iswitched = false;    
			
			water.setVisible(false);        // set it to be visible, while the other is invisible
			firstaid.setVisible(true);
			
			try
			{
				Thread.sleep(10);
			}
			catch(Exception ex){}
			
			repaint();
		}
	}
	
	public static void main(String[] args)
	{
		ToggleImage p = new ToggleImage();
		JFrame jf = new JFrame("test");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(1280, 800);
		jf.setLocation(0, 0);
		jf.setVisible(true);
		jf.add(p);
	}
}
