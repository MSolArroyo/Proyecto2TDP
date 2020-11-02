import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class Cronometro extends JFrame {

	private JPanel contentPane;
	private ImageIcon Img0,Img1,Img2,Img3, Img4,Img5,Img6,Img7,Img8,Img9,Img10;
	private JLabel im0,im1,im2,im3,im4,im5,im6,im7,im8,im9,im10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cronometro frame = new Cronometro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cronometro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelnumeros = new JPanel();
		panelnumeros.setBorder(new CompoundBorder());
		panelnumeros.setBounds(10, 11, 555, 212);
		contentPane.add(panelnumeros);
		panelnumeros.setLayout(new GridLayout(0, 8, 0, 0));
		panelnumeros.setVisible(true);
		
		 Img0 = new ImageIcon(("/RELOJ/0.png")); 
		 Img1 = new ImageIcon(("/RELOJ/1.png")); 
		 Img2 = new ImageIcon(("/RELOJ/2.png")); 
		 Img3 = new ImageIcon(("/RELOJ/3.png")); 
		 Img4 = new ImageIcon(("/RELOJ/4.png")); 
		 Img5 = new ImageIcon(("/RELOJ/5.png")); 
		 Img6 = new ImageIcon(("/RELOJ/6.png")); 
		 Img7 = new ImageIcon(("/RELOJ/7.png"));
		 Img8 = new ImageIcon(("/RELOJ/8.png")); 
		 Img9 = new ImageIcon(("/RELOJ/9.png")); 
		 Img10 = new ImageIcon(("/RELOJ/10.png")); 
		 im0 = new JLabel();
		 im1 = new JLabel();
		 im2 = new JLabel();
		 im3 = new JLabel();
		 im4 = new JLabel();
		 im5 = new JLabel();
		 im6 = new JLabel();
		 im7 = new JLabel();
		 im8 = new JLabel();
		 im9 = new JLabel();
		 im10 = new JLabel();

		im0.setIcon(Img0);
		im1.setIcon(Img0);
		im2.setIcon(Img10);
		im3.setIcon(Img0);
		im4.setIcon(Img0);
		im5.setIcon(Img10);
		im6.setIcon(Img0);
		im7.setIcon(Img0);
		im1.setVisible(true);
		im2.setVisible(true);
		im3.setVisible(true);
		im4.setVisible(true);
		im5.setVisible(true);
		im6.setVisible(true);
		im7.setVisible(true);
		
		panelnumeros.add(im0);	
		panelnumeros.add(im1);	
		panelnumeros.add(im2);	
		panelnumeros.add(im3);	
		panelnumeros.add(im4);	
		panelnumeros.add(im5);	
		panelnumeros.add(im6);	
		panelnumeros.add(im7);
		
		
	}

}
