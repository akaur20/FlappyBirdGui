import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class Tubes extends JComponent
{
	Rectangle rectangle;
	int dx, dy;
	
	public Tubes(int x, int y, int z, int a)
	{
		this.setLocation(x, y);
		this.setSize(50, 800);
		rectangle = new Rectangle(0,0,z,a);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.blue);
		g2.fill(rectangle);
	}
	
	public void setDX(int x)
	{
		dx = x;
	}

	public void setDY(int y)
	{
		dy = y;
	}
	
	public int getDy()
	{
		return dy;
	}
	
	public int getDx()
	{
		return dx;
	}
	
	public void update() 
	{
		setLocation(getX() + dx, getY() + dy);
	}
}
