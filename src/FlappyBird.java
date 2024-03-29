import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class FlappyBird extends JFrame implements ActionListener 
{
	Circle ball;
	Tubes tube1, tube2, tube3, tube4, tube5, tube6, tube7, tube8;
	int random1, random2, random3, random4;
	int v;
	int a = 1;
	int y;
	Timer t1;
	int pane;
	int counter = 0;
	boolean game = true;

	public FlappyBird()
	{
		setTitle("Flappy Bird");
		setBounds(100, 100, 300, 300);
		setLayout(null);
		
		ball = new Circle(20,100);
		
		random1 = (int) (Math.random() * 60) + 50;
		random2 = (int) (Math.random() * 60) + 50;
		random3 = (int) (Math.random() * 60) + 50;
		random4 = (int) (Math.random() * 60) + 50;
		
		tube1 = new Tubes(40,0, 30, random1);
		tube2 = new Tubes(120,0, 30, random2);
		tube3 = new Tubes(200,0, 30, random3);
		tube4 = new Tubes(280, 0, 30, random4);
		tube5 = new Tubes(40,280 - tube1.getY() - random1, 30, tube1.getY() + random1);
		tube6 = new Tubes(120,280 - tube2.getY() - random2, 30, tube2.getY() + random2);
		tube7 = new Tubes(200,280 - tube3.getY() - random3, 30, tube3.getY() + random3);
		tube8 = new Tubes(280, 280 - tube4.getY() - random4, 30, tube4.getY() + random4);
		
		
		
		
		addKeyListener(new KeyListener()
				{
					public void keyPressed(KeyEvent e) 
					{	
						if(e.getKeyCode() == e.VK_UP)
						{
							
							if(ball.getY() <= 10)
							{
								ball.setDY(0);
							}
							else
							{
								ball.setDY(-20);
							}
							
						}
												
					}
					public void keyReleased(KeyEvent e)
					{
						if(e.getKeyCode() == e.VK_UP)
						{
							ball.setDY(0);
						}
						
					}
					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				
				});
		add(ball);
		add(tube1);
		add(tube2);
		add(tube3);
		add(tube4);
		add(tube5);
		add(tube6);
		add(tube7);
		add(tube8);
		
		t1 = new Timer(40, this);
		t1.start();
		
		setFocusable(true);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		if(game)
		{
			ball.setDY(ball.getDy() + a);
			ball.update();
			
			tube1.setDX(-3);tube1.update();
			tube2.setDX(-3);tube2.update();
			tube3.setDX(-3);tube3.update();	
			tube4.setDX(-3);tube4.update();
			tube5.setDX(-3);tube5.update();
			tube6.setDX(-3);tube6.update();
			tube7.setDX(-3);tube7.update();	
			tube8.setDX(-3);tube8.update();
			
			
			repaint();
				
			if(tube1.getX() <= 0)
			{
				counter ++;
				tube1.setLocation(320, 0);
				random1 = (int) (Math.random() * 60) + 50;
				tube1.rectangle.setSize(30, tube1.getY() + random1);
			}
			if(ball.getY() <= tube1.getY() + random1 && tube1.getX() > 20 - tube1.getWidth() && tube1.getX() < 20)
			{
				game = false;
				pane = JOptionPane.showConfirmDialog(null, "You got past " + counter + 
						" sets of tubes. Would you like to play again?", null, JOptionPane.YES_NO_OPTION );
				if(pane == JOptionPane.YES_OPTION)
				{
					remove(ball);remove(tube1);remove(tube2);remove(tube3);remove(tube4);
					remove(tube5);remove(tube6);remove(tube7);remove(tube8);
					
					ball = new Circle(20,100);
					
					random1 = (int) (Math.random() * 60) + 50;
					random2 = (int) (Math.random() * 60) + 50;
					random3 = (int) (Math.random() * 60) + 50;
					random4 = (int) (Math.random() * 60) + 50;
					
					tube1 = new Tubes(40,0, 30, random1);
					tube2 = new Tubes(120,0, 30, random2);
					tube3 = new Tubes(200,0, 30, random3);
					tube4 = new Tubes(280, 0, 30, random4);
					tube5 = new Tubes(40,280 - tube1.getY() - random1, 30, tube1.getY() + random1);
					tube6 = new Tubes(120,280 - tube2.getY() - random2, 30, tube2.getY() + random2);
					tube7 = new Tubes(200,280 - tube3.getY() - random3, 30, tube3.getY() + random3);
					tube8 = new Tubes(280, 280 - tube4.getY() - random4, 30, tube4.getY() + random4);
					
					add(ball);add(tube1);add(tube2);add(tube3);add(tube4);
					add(tube5);add(tube6);add(tube7);add(tube8);
					counter = 0;
					game = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Thanks for Playing");
				}
			}
			
			if(tube2.getX() <= 0)
			{
				counter ++;
				tube2.setLocation(320, 0);
				random2 = (int) (Math.random() * 60) + 50;
				tube2.rectangle.setSize(30, tube2.getY() + random2);
				
			}
			if(ball.getY() <= tube2.getY() + random2 && tube2.getX() > 20 - tube2.getWidth() && tube2.getX() < 20)
			{
				game = false;
				pane = JOptionPane.showConfirmDialog(null, "You got past " + counter + 
						" sets of tubes. Would you like to play again?", null, JOptionPane.YES_NO_OPTION );
				if(pane == JOptionPane.YES_OPTION)
				{
					remove(ball);remove(tube1);remove(tube2);remove(tube3);remove(tube4);
					remove(tube5);remove(tube6);remove(tube7);remove(tube8);
					
					ball = new Circle(20,100);
					
					random1 = (int) (Math.random() * 60) + 50;
					random2 = (int) (Math.random() * 60) + 50;
					random3 = (int) (Math.random() * 60) + 50;
					random4 = (int) (Math.random() * 60) + 50;
					
					tube1 = new Tubes(40,0, 30, random1);
					tube2 = new Tubes(120,0, 30, random2);
					tube3 = new Tubes(200,0, 30, random3);
					tube4 = new Tubes(280, 0, 30, random4);
					tube5 = new Tubes(40,280 - tube1.getY() - random1, 30, tube1.getY() + random1);
					tube6 = new Tubes(120,280 - tube2.getY() - random2, 30, tube2.getY() + random2);
					tube7 = new Tubes(200,280 - tube3.getY() - random3, 30, tube3.getY() + random3);
					tube8 = new Tubes(280, 280 - tube4.getY() - random4, 30, tube4.getY() + random4);
					
					add(ball);add(tube1);add(tube2);add(tube3);add(tube4);
					add(tube5);add(tube6);add(tube7);add(tube8);
					counter = 0;
					game = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Thanks for Playing");
				}
			}
			
			if(tube3.getX() <= 0)
			{
				counter ++;
				tube3.setLocation(320, 0);
				random3 = (int) (Math.random() * 60) + 50;
				tube3.rectangle.setSize(30, tube3.getY() + random3);
			}
			if(ball.getY() <= tube3.getY() + random3 && tube3.getX() > 20 - tube3.getWidth() && tube3.getX() < 20)
			{
				game = false;
				pane = JOptionPane.showConfirmDialog(null, "You got past " + counter + 
						" sets of tubes. Would you like to play again?", null, JOptionPane.YES_NO_OPTION );
				if(pane == JOptionPane.YES_OPTION)
				{
					remove(ball);remove(tube1);remove(tube2);remove(tube3);remove(tube4);
					remove(tube5);remove(tube6);remove(tube7);remove(tube8);
					
					ball = new Circle(20,100);
					
					random1 = (int) (Math.random() * 60) + 50;
					random2 = (int) (Math.random() * 60) + 50;
					random3 = (int) (Math.random() * 60) + 50;
					random4 = (int) (Math.random() * 60) + 50;
					
					tube1 = new Tubes(40,0, 30, random1);
					tube2 = new Tubes(120,0, 30, random2);
					tube3 = new Tubes(200,0, 30, random3);
					tube4 = new Tubes(280, 0, 30, random4);
					tube5 = new Tubes(40,280 - tube1.getY() - random1, 30, tube1.getY() + random1);
					tube6 = new Tubes(120,280 - tube2.getY() - random2, 30, tube2.getY() + random2);
					tube7 = new Tubes(200,280 - tube3.getY() - random3, 30, tube3.getY() + random3);
					tube8 = new Tubes(280, 280 - tube4.getY() - random4, 30, tube4.getY() + random4);
					
					add(ball);add(tube1);add(tube2);add(tube3);add(tube4);
					add(tube5);add(tube6);add(tube7);add(tube8);
					counter = 0;
					game = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Thanks for Playing");
				}
			}
			
			if(tube4.getX() <= 0)
			{
				counter ++;
				tube4.setLocation(320, 0);
				random4 = (int) (Math.random() * 60) + 50;
				tube4.rectangle.setSize(30, tube4.getY() + random4);
			}
			if(ball.getY() <= tube4.getY() + random4 && tube4.getX() > 20 - tube4.getWidth() && tube4.getX() < 20)
			{
				game = false;
				pane = JOptionPane.showConfirmDialog(null, "You got past " + counter + 
						" sets of tubes. Would you like to play again?", null, JOptionPane.YES_NO_OPTION );
				if(pane == JOptionPane.YES_OPTION)
				{
					remove(ball);remove(tube1);remove(tube2);remove(tube3);remove(tube4);
					remove(tube5);remove(tube6);remove(tube7);remove(tube8);
					
					ball = new Circle(20,100);
					
					random1 = (int) (Math.random() * 60) + 50;
					random2 = (int) (Math.random() * 60) + 50;
					random3 = (int) (Math.random() * 60) + 50;
					random4 = (int) (Math.random() * 60) + 50;
					
					tube1 = new Tubes(40,0, 30, random1);
					tube2 = new Tubes(120,0, 30, random2);
					tube3 = new Tubes(200,0, 30, random3);
					tube4 = new Tubes(280, 0, 30, random4);
					tube5 = new Tubes(40,280 - tube1.getY() - random1, 30, tube1.getY() + random1);
					tube6 = new Tubes(120,280 - tube2.getY() - random2, 30, tube2.getY() + random2);
					tube7 = new Tubes(200,280 - tube3.getY() - random3, 30, tube3.getY() + random3);
					tube8 = new Tubes(280, 280 - tube4.getY() - random4, 30, tube4.getY() + random4);
					
					add(ball);add(tube1);add(tube2);add(tube3);add(tube4);
					add(tube5);add(tube6);add(tube7);add(tube8);
					counter = 0;
					game = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Thanks for Playing");
				}
			}
			
			
			if(tube5.getX() <= 0)
			{
				tube5.setLocation(320, 280 - tube1.getY() - random1);
				tube5.rectangle.setSize(30, tube1.getY() + random1);
			}
			if(tube6.getX() <= 0)
			{
				tube6.setLocation(320, 280 - tube2.getY() - random2);
				tube6.rectangle.setSize(30, tube2.getY() + random2);
			}
			if(tube7.getX() <= 0)
			{
				tube7.setLocation(320, 280 - tube3.getY() - random3);
				tube7.rectangle.setSize(30, tube3.getY() + random3);
			}
			if(tube8.getX() <= 0)
			{
				tube8.setLocation(320, 280 - tube4.getY() - random4);
				tube8.rectangle.setSize(30, tube4.getY() + random4);
			}
			
			
			if(ball.getY() >= tube5.getY() && tube5.getX() > 20 - tube5.getWidth() && tube5.getX() < 20)
			{
				game = false;
				pane = JOptionPane.showConfirmDialog(null, "You got past " + counter + 
						" sets of tubes. Would you like to play again?", null, JOptionPane.YES_NO_OPTION );
				if(pane == JOptionPane.YES_OPTION)
				{
					remove(ball);remove(tube1);remove(tube2);remove(tube3);remove(tube4);
					remove(tube5);remove(tube6);remove(tube7);remove(tube8);
					
					ball = new Circle(20,100);
					
					random1 = (int) (Math.random() * 60) + 50;
					random2 = (int) (Math.random() * 60) + 50;
					random3 = (int) (Math.random() * 60) + 50;
					random4 = (int) (Math.random() * 60) + 50;
					
					tube1 = new Tubes(40,0, 30, random1);
					tube2 = new Tubes(120,0, 30, random2);
					tube3 = new Tubes(200,0, 30, random3);
					tube4 = new Tubes(280, 0, 30, random4);
					tube5 = new Tubes(40,280 - tube1.getY() - random1, 30, tube1.getY() + random1);
					tube6 = new Tubes(120,280 - tube2.getY() - random2, 30, tube2.getY() + random2);
					tube7 = new Tubes(200,280 - tube3.getY() - random3, 30, tube3.getY() + random3);
					tube8 = new Tubes(280, 280 - tube4.getY() - random4, 30, tube4.getY() + random4);

					add(ball);add(tube1);add(tube2);add(tube3);add(tube4);
					add(tube5);add(tube6);add(tube7);add(tube8);
					counter = 0;
					game = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Thanks for Playing");
				}
			}
			
			if(ball.getY() >= tube6.getY() && tube6.getX() > 20 - tube6.getWidth() && tube6.getX() < 20)
			{
				game = false;
				pane = JOptionPane.showConfirmDialog(null, "You got past " + counter + 
						" sets of tubes. Would you like to play again?", null, JOptionPane.YES_NO_OPTION );
				if(pane == JOptionPane.YES_OPTION)
				{
					remove(ball);remove(tube1);remove(tube2);remove(tube3);remove(tube4);
					remove(tube5);remove(tube6);remove(tube7);remove(tube8);
					
					ball = new Circle(20,100);
					
					random1 = (int) (Math.random() * 60) + 50;
					random2 = (int) (Math.random() * 60) + 50;
					random3 = (int) (Math.random() * 60) + 50;
					random4 = (int) (Math.random() * 60) + 50;
					
					tube1 = new Tubes(40,0, 30, random1);
					tube2 = new Tubes(120,0, 30, random2);
					tube3 = new Tubes(200,0, 30, random3);
					tube4 = new Tubes(280, 0, 30, random4);
					tube5 = new Tubes(40,280 - tube1.getY() - random1, 30, tube1.getY() + random1);
					tube6 = new Tubes(120,280 - tube2.getY() - random2, 30, tube2.getY() + random2);
					tube7 = new Tubes(200,280 - tube3.getY() - random3, 30, tube3.getY() + random3);
					tube8 = new Tubes(280, 280 - tube4.getY() - random4, 30, tube4.getY() + random4);
					
					add(ball);add(tube1);add(tube2);add(tube3);add(tube4);
					add(tube5);add(tube6);add(tube7);add(tube8);
					counter = 0;
					game = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Thanks for Playing");
				}
			}
			
			if(ball.getY() >= tube7.getY() && tube7.getX() > 20 - tube7.getWidth() && tube7.getX() < 20)
			{
				game = false;
				pane = JOptionPane.showConfirmDialog(null, "You got past " + counter + 
						" sets of tubes. Would you like to play again?", null, JOptionPane.YES_NO_OPTION );
				if(pane == JOptionPane.YES_OPTION)
				{
					remove(ball);remove(tube1);remove(tube2);remove(tube3);remove(tube4);
					remove(tube5);remove(tube6);remove(tube7);remove(tube8);
					
					ball = new Circle(20,100);
					
					random1 = (int) (Math.random() * 60) + 50;
					random2 = (int) (Math.random() * 60) + 50;
					random3 = (int) (Math.random() * 60) + 50;
					random4 = (int) (Math.random() * 60) + 50;
					
					tube1 = new Tubes(40,0, 30, random1);
					tube2 = new Tubes(120,0, 30, random2);
					tube3 = new Tubes(200,0, 30, random3);
					tube4 = new Tubes(280, 0, 30, random4);
					tube5 = new Tubes(40,280 - tube1.getY() - random1, 30, tube1.getY() + random1);
					tube6 = new Tubes(120,280 - tube2.getY() - random2, 30, tube2.getY() + random2);
					tube7 = new Tubes(200,280 - tube3.getY() - random3, 30, tube3.getY() + random3);
					tube8 = new Tubes(280, 280 - tube4.getY() - random4, 30, tube4.getY() + random4);
					
					add(ball);add(tube1);add(tube2);add(tube3);add(tube4);
					add(tube5);add(tube6);add(tube7);add(tube8);
					counter = 0;
					game = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Thanks for Playing");
				}
			}
			
			if(ball.getY() >= tube8.getY() && tube8.getX() > 20 - tube8.getWidth() && tube8.getX() < 20)
			{
				game = false;
				pane = JOptionPane.showConfirmDialog(null, "You got past " + counter + 
						" sets of tubes. Would you like to play again?", null, JOptionPane.YES_NO_OPTION );
				if(pane == JOptionPane.YES_OPTION)
				{
					remove(ball);remove(tube1);remove(tube2);remove(tube3);remove(tube4);
					remove(tube5);remove(tube6);remove(tube7);remove(tube8);
					
					ball = new Circle(20,100);
					
					random1 = (int) (Math.random() * 60) + 50;
					random2 = (int) (Math.random() * 60) + 50;
					random3 = (int) (Math.random() * 60) + 50;
					random4 = (int) (Math.random() * 60) + 50;
					
					tube1 = new Tubes(40,0, 30, random1);
					tube2 = new Tubes(120,0, 30, random2);
					tube3 = new Tubes(200,0, 30, random3);
					tube4 = new Tubes(280, 0, 30, random4);
					tube5 = new Tubes(40,280 - tube1.getY() - random1, 30, tube1.getY() + random1);
					tube6 = new Tubes(120,280 - tube2.getY() - random2, 30, tube2.getY() + random2);
					tube7 = new Tubes(200,280 - tube3.getY() - random3, 30, tube3.getY() + random3);
					tube8 = new Tubes(280, 280 - tube4.getY() - random4, 30, tube4.getY() + random4);
					
					add(ball);add(tube1);add(tube2);add(tube3);add(tube4);
					add(tube5);add(tube6);add(tube7);add(tube8);
					counter = 0;
					game = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Thanks for Playing");
				}
				
			}
			
		}
		
		
	 }
	
	
	public static void main(String[] args) 
	{
		new FlappyBird();
		
	}	
}