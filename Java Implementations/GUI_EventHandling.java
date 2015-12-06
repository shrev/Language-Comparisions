import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;


public class GUI_EventHandling {
	
	JFrame frame;
	JPanel panel1,panel2,panel3,panel4,panel5;
	JLabel l1,l2,title,l3;
	mouse mouseEvent;

	JTextField tf;
	JButton button;
	tfhandler tfevent;
	btnhandler btnevent;
	
	
	public GUI_EventHandling()
	{
		frame=new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setSize(800, 400);
		
		panel1=new JPanel(new GridLayout(1,1,20,0));
		panel2=new JPanel(new BorderLayout());
		panel3=new JPanel(new GridLayout(4,1,20,20));
		panel4=new JPanel(new FlowLayout(FlowLayout.CENTER,1,0));
		panel5=new JPanel(new GridLayout(1,1,20,20));
		
		
		Border border=BorderFactory.createLineBorder(Color.BLACK , 1);
		
		
		
		tf=new JTextField();
		
		l1=new JLabel("");
		l2=new JLabel("");
		l3=new JLabel("");
		title=new JLabel("GUI AND EVENT HANDLING");
		mouseEvent=new mouse();
		btnevent=new btnhandler();
		tfevent=new tfhandler();
		
		button =new JButton("CLEAR");
		button.addActionListener(btnevent);
		
		
		panel1.setBorder(border);
		panel3.setBorder(border);
		panel4.setBorder(border);
		panel5.setBorder(border);
		
		
		
		
		tf.addKeyListener(tfevent);
		
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		l1.setSize(1000,200);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		
		l3.setFont(new Font("Times New Roman",Font.BOLD,16));
		
		
		title.setFont(new Font("Times New Roman",Font.BOLD,22));
		
		
		panel3.add(l3);
		panel3.add(button);
		panel3.add(tf);
		panel3.add(l2);
		
		panel4.add(title);
		panel5.add(panel3);
		
		panel2.setBorder(BorderFactory.createTitledBorder("MOVE MOUSE OVER PANEL"));
		panel2.add(l1,BorderLayout.CENTER);
		panel2.addMouseListener(mouseEvent);
		
		panel1.add(panel2);
		frame.add(panel4,BorderLayout.NORTH);
		frame.add(panel5,BorderLayout.SOUTH);
		frame.add(panel1,BorderLayout.CENTER);
		
		
		frame.setVisible(true);
		
	}
	
	class btnhandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			tf.setText("");
			l3.setText("");
		}
		
	}
	
	class mouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			l1.setText("This is a MouseEvent that has been handled by a MouseEntered Event Handler");
			
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			l1.setText("");
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
	class tfhandler implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			l2.setText("You are typing...");
		   
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			 l2.setText("");
			 l3.setText(tf.getText());
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		   	l2.setText("You are typing...");
			
		}
	
	}
	
	public static void main(String args[])
	{
		GUI_EventHandling gui=new GUI_EventHandling();
	}

}
