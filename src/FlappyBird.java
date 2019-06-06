import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird extends JFrame implements ActionListener 
{
	Circle ball;
	Tubes tube1, tube2, tube3, tube4, tube5, tube6, tube7, tube8;
	ArrayList<Tubes> tubeList1;
	ArrayList<Tubes> tubeList2;
	int random1, random2, random3, random4;
	int v;
	int a = 1;
	int y;
	Timer t1;
	Boolean game;

	public FlappyBird()
	{
		setTitle("Flappy Bird");
		setBounds(100, 100, 300, 300);
		setLayout(null);
		
		ball = new Circle(20,20);
		
		
		
		random1 = (int) (Math.random() * 50) + 50;
		random2 = (int) (Math.random() * 50) + 50;
		random3 = (int) (Math.random() * 50) + 50;
		random4 = (int) (Math.random() * 50) + 50;
		
		tube1 = new Tubes(40,0, 27, (int) (Math.random() * 50) + 50);
		tube2 = new Tubes(120,0, 20, (int) (Math.random() * 50) + 40);
		tube3 = new Tubes(200,0, 30, (int) (Math.random() * 50) + 60);
		tube4 = new Tubes(280, 0, 25, (int) (Math.random() * 50) + 30);
		tube5 = new Tubes(40,280 - tube1.getY() - random1, 27, tube1.getY() + random1);
		tube6 = new Tubes(120,280 - tube2.getY() - random2, 20, tube2.getY() + random2);
		tube7 = new Tubes(200,280 - tube3.getY() - random3, 30, tube3.getY() + random3);
		tube8 = new Tubes(280, 280 - tube4.getY() - random4, 25, tube4.getY() + random4);
		
		
		tubeList1 = new ArrayList<Tubes>();
		tubeList2 = new ArrayList<Tubes>();
		tubeList1.add(tube1);
		tubeList1.add(tube2);
		tubeList1.add(tube3);
		tubeList1.add(tube4);
		tubeList2.add(tube5);
		tubeList2.add(tube6);
		tubeList2.add(tube7);
		tubeList2.add(tube8);
		
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
								ball.setDY(-30);
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
		game = true;
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

			for(int i=0; i < tubeList1.size(); i++)
			{
				
				if(tubeList1.get(i).getX() <= 0)
				{
					tubeList1.get(i).setLocation(280, 0);
					
				}
				if(ball.getY() <= tubeList1.get(i).getY())
				{
					game = false;
					System.out.println("cheese");
				}
			}
			
			if(tube5.getX() <= 0)
			{
				tube5.setLocation(280, 280 - tube1.getY() - random1);
			}
			if(tube6.getX() <= 0)
			{
				tube6.setLocation(280, 280 - tube2.getY() - random2);
			}
			if(tube7.getX() <= 0)
			{
				tube7.setLocation(280, 280 - tube3.getY() - random3);
			}
			if(tube8.getX() <= 0)
			{
				tube8.setLocation(280, 280 - tube4.getY() - random4);
			}
			
			for(int i=0; i < tubeList2.size(); i++)
			{
				if(ball.getY() >= tubeList2.get(i).getY())
				{
					game = false;
					System.out.println("cheese2");
				}
			}
			
		}
		
		
	 }
	
	
	public static void main(String[] args) 
	{
		new FlappyBird();
		
	}	
}