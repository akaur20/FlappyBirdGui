import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.geom.Ellipse2D;



import javax.swing.JComponent;



public class Circle extends JComponent

{
	private Ellipse2D.Double ball;
	private int dx = 0, dy = 0;
	private int x, y;
	
	public Circle(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.setSize(11,11);
		this.setLocation(x, y);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		ball = new Ellipse2D.Double(0, 0, 10, 10);
		g2.fill(ball);
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