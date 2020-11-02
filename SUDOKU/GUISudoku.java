import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import RELOJ.Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.BevelBorder;



public class GUISudoku extends JFrame{
	
	private int dificultad;
	private Juego juego;
	private JPanel paneliconos;
	private String ruta;
	protected JButton[][] tablero;
	private int [][] matriz;
	private int auxf, auxc;
	private JButton reiniciar, jugar,resolver,verificar;
	private JPanel panelbotones;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISudoku frame = new GUISudoku();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public GUISudoku() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 422);
		getContentPane().setLayout(null);

		
		paneliconos = new JPanel();
		paneliconos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		paneliconos.setBounds(10, 11, 396, 353);
		getContentPane().add(paneliconos);
		paneliconos.setLayout(new GridLayout(9, 0, 0, 0));

		paneliconos.setVisible(false);
		//juego= new Juego();
		//iniciarJuego();
		tablero = new JButton[9][9];
		matriz = new int [9][9];
		JPanel paneldificultad = new JPanel();
		paneldificultad.setBackground(Color.PINK);
		paneldificultad.setBounds(416, 85, 255, 47);
		getContentPane().add(paneldificultad);
		paneldificultad.setLayout(null);
		
		
		JPanel panelbotones = new JPanel();
		panelbotones.setBackground(Color.PINK);
		panelbotones.setBounds(416, 167, 252, 104);
		getContentPane().add(panelbotones);
		panelbotones.setLayout(null);
		panelbotones.setVisible(false);
		JButton op2 = new JButton("OP 2");
		JButton op1 = new JButton("OP 1 ");
		JButton op3 = new JButton("0P 3");

		JButton btnNewButton = new JButton("JUGAR");
		btnNewButton.setBounds(10, 10, 89, 23);
		panelbotones.add(btnNewButton);
		
		op1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		op1.setBounds(10, 11, 74, 23);
		paneldificultad.add(op1);
		
		op2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		op2.setBounds(94, 11, 74, 23);
		paneldificultad.add(op2);
		
		btnNewButton.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Bienvenidos al SUDOKU...");
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		lblNewLabel.setBounds(416, 11, 255, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1-Seleccione una OPCION para comenzar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_1.setBounds(416, 46, 255, 14);
		getContentPane().add(lblNewLabel_1);
		
		op3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		op3.setBounds(178, 11, 67, 23);
		paneldificultad.add(op3);
		JButton verificar = new JButton("VERIFICAR");
		verificar.setBounds(125, 11, 117, 23);
		panelbotones.add(verificar);
		verificar.setEnabled(false);
		verificar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		
		
		JButton resolver = new JButton("RESOLVER");
		resolver.setEnabled(false);
		resolver.setBounds(-2, 70, 117, 23);
		panelbotones.add(resolver);
		resolver.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		
		JButton reiniciar = new JButton("REINICIAR");
		reiniciar.setBounds(125, 70, 117, 23);
		panelbotones.add(reiniciar);
		reiniciar.setEnabled(false);
		
		
		op1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				juego = new Juego("Sudoku1.txt");
				if (juego.getCorrecto()==false) {
					JOptionPane.showMessageDialog(null,"El archivo no tiene una solucion correcta","ERROR!!!", JOptionPane.ERROR_MESSAGE);
				}
				op1.setEnabled(false);
				op2.setEnabled(false);
				op3.setEnabled(false);
				panelbotones.setVisible(true); 
				
			}
		});
		
		
		op2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego = new Juego("Sudoku2.txt");
				
				if (juego.getCorrecto()==false) {
					JOptionPane.showMessageDialog(null,"El archivo no tiene una solucion correcta","ERROR!!!", JOptionPane.ERROR_MESSAGE);
				}
				op1.setEnabled(false);
				op2.setEnabled(false);
				op3.setEnabled(false);
				panelbotones.setVisible(true);
			
			}
		});
		
		
		op3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego = new Juego("Sudoku3.txt");
				if (juego.getCorrecto()==false) {
					JOptionPane.showMessageDialog(null,"El archivo no tiene una solucion correcta","ERROR!!!", JOptionPane.ERROR_MESSAGE);
				}
				
				op1.setEnabled(false);
				op2.setEnabled(false);
				op3.setEnabled(false);
				panelbotones.setVisible(true);
			}
		});
		
		
		verificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean termino;
				boolean cumple;
				
				
							
							
							
							
							
							
							
							
							
			
				
				termino = juego.llena();
				int cant=juego.getControl();
				
				if (termino) {
					cumple=juego.chequearMatriz();
					if (cumple) JOptionPane.showMessageDialog(null,"JUEGO FINALIZADO,HA GANADO!!!! =) ","FELICITACIONES!!!!",JOptionPane.INFORMATION_MESSAGE);
					else JOptionPane.showMessageDialog(null,"Tiene errores en su RESOLUCION"
							+ "  intente Nuevamente...  ","VUELVA A INTENTARLO", JOptionPane.ERROR_MESSAGE);

				}
				else { 
					JOptionPane.showMessageDialog(null,"NO SE HA COMPLETADO EL JUEGO","VUELVA A INTENTARLO", JOptionPane.ERROR_MESSAGE);}
				
				
			
			
			
			}
		});
		
		
		
		resolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Celda[][] cel= juego.resolver();
				for (int i=0;i<9;i++) {
					for (int j=0;j<9;j++) {
						
						JButton boton = new JButton();
						boton.setIcon(cel[i][j].getEntidadGrafica().getGrafico());
						paneliconos.add(boton);
						
					}} 
			}
		});
		
		
		
		reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int op=JOptionPane.showConfirmDialog(null, "QUIERE REINICIAR EL JUEGO?","REINICIAR ",JOptionPane.YES_NO_OPTION);
				if (op ==0 ) 
					{

					op1.setEnabled(true);
					op2.setEnabled(true);
					op3.setEnabled(true);
					estadoInicial();}
					}
		});
		reiniciar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 iniciarJuego();
			Ventana reloj = new Ventana();
			reloj.setVisible(true);
			reloj.setLocation(600, 450);
			
				paneliconos.setVisible(true);
				btnNewButton.setEnabled(false);
				reiniciar.setEnabled(true);
				resolver.setEnabled(true);
				verificar.setEnabled(true);

			}
			
		});
		
		
		
			
		
	}
	
	
		
	
	protected void iniciarJuego() {
		
		for (int i=0 ; i <juego.getCantFilas(); i++) {
			for( int j=0; j<juego.getCantFilas(); j++) {
				Celda c = juego.getCelda(i,j);
				ImageIcon grafico = c.getEntidadGrafica().getGrafico();
				
				JButton boton = new JButton();
				boton.setBackground(Color.WHITE);
				
				
				
				tablero[i][j]=boton;
				paneliconos.add(boton);
				paneliconos.setEnabled(false);
				matriz=juego.getMatriz();
				
						
				
				if (juego.getCelda(i, j).getValor()!=null)
					boton.setEnabled(false);
				
				boton.addComponentListener(new ComponentAdapter() {
					@Override
					public void componentResized(ComponentEvent e) {
						reDimensionar(boton, grafico);
						boton.setIcon(grafico);
						
						
						}
				});
		
					boton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						juego.accionar(c);
						boton.enable();
						reDimensionar(boton,grafico);
				       if (juego.comprobar()==false)
				       { boton.setBackground(Color.red);
				       boton.setBorderPainted(true);}
				       else {
				    	   boton.setBorderPainted(true);
				       }
						
						
					}
				});
			}
		}
	}
	
		
	public JButton[][] botones(){
		return tablero;
	}
	
	
	private void estadoInicial() {
		paneliconos.setVisible(true);
		jugar.setEnabled(true);
		reiniciar.setEnabled(false);
		resolver.setEnabled(false);
		verificar.setEnabled(false);
		paneliconos.setVisible(false);
		panelbotones.setVisible(false);
		
	}
	private void reDimensionar(JButton boton, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {  
			Image newimg = image.getScaledInstance(boton.getWidth(), boton.getHeight(),  java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			boton.repaint();
		}
	}
}