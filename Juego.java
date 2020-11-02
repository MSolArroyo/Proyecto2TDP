
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.time.Duration;
import java.time.LocalTime;


public class Juego {
	private Celda [][] tablero;  
	protected static int cantFilas=9,  cantColumnas=9;
	private int [][] matriz;
	protected LinkedHashMap<String, Integer> errores; 
	private boolean estalleno,correcto;
	private int celdasactivas;
	private int dificultad;
	private LocalTime tiempo;
	private Duration duracion;
	private String rut;
	
	
	public Juego(String ruta)
	{	//dificultad=dif;
		rut=ruta;
		
		tiempo= LocalTime.now();

		celdasactivas=0;
		
				estalleno=false;
				
				errores = new LinkedHashMap<String, Integer>();
				
				correcto=true;
				
		tablero = new Celda[this.cantFilas][this.cantFilas]; 
		matriz = new int[9][9];

			try {
			BufferedReader br = new BufferedReader(new FileReader(rut));
			String linea = br.readLine();
			int fila = 0; //PARA RECORRER LAS FILAS DE LA MATRIZ
			while(linea != null) {
				String[] enteros = linea.split(" ");
				for (int i = 0; i < enteros.length; i++)
					matriz[fila][i] = Integer.parseInt(enteros[i]);
 
				fila++; //INCREMENTAMOS LA FILA PARA LA PROXIMA LÍNEA DE ENTEROS
				linea = br.readLine(); 
			}
			br.close(); 
			
			//MOSTRAMOS EL ARCHIVO LEIDO
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					System.out.print(matriz[i][j] + " ");
				System.out.println();
			}
			
						
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra archivo");
			e.printStackTrace();
			correcto=false;
		} catch (NumberFormatException e) {
			System.out.println("No se pudo convertir a entero");
			correcto=false;
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error accediendo al archivo.");
			e.printStackTrace();correcto=false;
		}
	
	
			correcto=estadoInicial();
			
			if (correcto) {
				
				ponerImagenes();
				
					
			}
	
	}
		
		
		
		
		public void ponerImagenes() {
			int dif=0;
			for (int i =0; i<cantFilas; i++) { 
				for (int j =0; j<cantFilas; j++) {
							
					tablero[i][j] = new Celda();
					Random rand = new Random();
					int value = rand.nextInt(2); //ME DA 0 O 1
					//De acuerdo a value decidir si asignar un valor o no
										
					if ((value == 0)){
						tablero[i][j].setValor(matriz[i][j]-1);	
					   celdasactivas++;	
					   System.out.print(celdasactivas+ " celdas");
						System.out.println();
												
						}
					
					
					
				}		
			}
		}
		
		
		
		public Celda[][] resolver() {
			
			Celda [][] cel= new Celda[9][9];
			for (int i=0;i<9;i++) {
				for (int j=0;j<9;j++) {
					
					 cel[i][j]=tablero[i][j];
					
					
				}
			}
			return cel;
		
			
			
			}
		
		
		public Duration getDuration() {
			LocalTime stop= LocalTime.now();
			Duration d= Duration.between(tiempo,stop);
			
			return d;
		}
	
	public boolean getCorrecto() {
		return correcto;
	}
	
	public boolean esCorrecto() {
		return correcto;
	}
	
	public int getControl() {
		return celdasactivas;
	}
	public void setControl(int numero) {
		if(numero == 0) //Estaba en 0, por lo que es la primera vez que se activa.
			celdasactivas++;
		else if(numero == 1) //Estaba en 9, por lo que al adoptar 0, se desactiva la celda.
			{celdasactivas--;
			celdasactivas++;} //Caso contrario (el else faltante), la celda ya había sido activada con anterioridad.
	
		}
	
	public void accionar(Celda c) {
		
		
		c.actualizar();
	}
	
	public Celda getCelda(int i, int j) {
		return this.tablero[i][j];
	}
	
	public int getCantFilas() {
		return this.cantFilas;
	}
	
	public int getCantColumnas()
	{
		return this.cantColumnas;
	}
	
	
	
	public boolean estadoInicial() {
		boolean toReturn = true;
		for(int i=0, j=0; i<cantFilas && j<cantColumnas && toReturn; i++, j++) 
			toReturn = chequearFila(i, matriz) && chequearColumna(j, matriz) && chequearPanel(i, matriz);
		return toReturn;
	}
	
	
	public boolean chequearPanel(int nroPanel, int matriz[][]) {
		boolean toReturn;
		String[] arregloControl = new String[(cantFilas+cantColumnas)/2];
		int f, c;
		if(nroPanel%3==0) {
			f = nroPanel;
			c = 0;
		}
		else if(nroPanel%3==1) {
			f = nroPanel-1;
			c = 3;
		}
		else {
			f = nroPanel-2;
			c = 6;
		}
		int valor;		
		for(int i=f; i<f+3; i++)
			for(int j=c; j<c+3; j++) {
				valor = matriz[i][j];
				if(valor!=0) {
					toReturn = arregloControl[valor-1] == null;
					if(!toReturn) {
						errores.put(i+","+j, valor);
						errores.put(arregloControl[valor-1], valor);
					}
					arregloControl[valor-1] = i+","+j;
				}
			}		
		return errores.isEmpty();
	}
	
	
	
	
	public boolean chequearFila(int fila, int matriz[][]) {
		boolean toReturn;
		String[] arregloControl = new String[cantColumnas];
		int valor;
		for(int c=0; c<cantColumnas; c++) {
			valor = matriz[fila][c];
				if(valor!=0) {
				toReturn = arregloControl[valor-1] == null;
				if(!toReturn) {
					errores.put(fila+","+c, valor);
					errores.put(arregloControl[valor-1], valor);
				}
				arregloControl[valor-1] = fila+","+c;
			}
		}	
		return errores.isEmpty();
	}
	
	
	
	public boolean chequearColumna(int columna, int matriz[][]) {
		boolean toReturn;
		String[] arregloControl = new String[cantFilas];
		int valor;
		for(int f=0; f<cantFilas; f++) {
			valor = matriz[f][columna];
			if(valor!=0) {
				toReturn = arregloControl[valor-1] == null;
				if(!toReturn) {
					errores.put(f+","+columna, valor);
					errores.put(arregloControl[valor-1], valor);
				}	
				arregloControl[valor-1] = f+","+columna;
			}
		}	
		return errores.isEmpty();
	}

	
	
	
	public boolean comprobar() {
		return errores.isEmpty();
	}
	
	
	public boolean llena() {
		return (celdasactivas>=81);
	}
	
	
	
	
	
	
	public void setErrores(String indice) {
 		int[][] matrizAux = new int[cantFilas][cantColumnas];
 		String[] erroresBorrar;
 		int pos = 0;
 		for(int f=0; f<cantFilas; f++)
 			for(int c=0; c<cantColumnas; c++)
 				matrizAux[f][c] = tablero[f][c].getValor();
 		for(int i=0, j=0; i<cantFilas && j<cantColumnas; i++, j++){
			chequearFila(i, matrizAux);
			chequearColumna(j, matrizAux);
			chequearPanel(i, matrizAux);
 		}	
 		
 		erroresBorrar = new String[errores.size()]; 
 		for(String clave : errores.keySet())
	 		if(!repetido(clave, matrizAux))
	 			erroresBorrar[pos++] = clave;
 		for(int i=0; i<erroresBorrar.length && erroresBorrar[i]!=null; i++)
	 			errores.remove(erroresBorrar[i]);
 	}
 	
 	
 	public String[] getErrores() {
		String[] toReturn;
		toReturn = errores.size()==0 ? null : new String[errores.size()];
		int pos = 0;
		for(String indice : errores.keySet())
			toReturn[pos++] = indice;
		return toReturn;
	}
 	
 	protected boolean repetido(String indice, int[][] m) {
 		String[] coordenadas = indice.split(",");
 		int fila = Integer.parseInt(coordenadas[0]);
 		int columna = Integer.parseInt(coordenadas[1]);
 		boolean toReturn = false;
 		int valor = m[fila][columna];
 		for(int f=0; f<cantFilas && !toReturn && valor!=0; f++) 
			if(f!=fila)
				toReturn = tablero[f][columna].getValor() == valor ? true : false;
		for(int c=0; c<cantColumnas && !toReturn && valor!=0; c++) 
			if(c!=columna) 
				toReturn = tablero[fila][c].getValor() == valor ? true : false;
		toReturn = !toReturn ? repetidoPanel(fila, columna, m) : toReturn;
		return toReturn;
 	}
 	
 	
 	protected boolean repetidoPanel(int fila, int columna, int[][] m) {
 		boolean toReturn = false;
 		int f = fila - fila%3; 
		int c = columna - columna%3; 
		int valor = m[fila][columna];
		for(int i=f; i<f+3 && !toReturn && valor!=0; i++)
			for(int j=c; j<c+3 && !toReturn; j++)
				if(i!=fila && j!=columna)
					toReturn = m[i][j]==valor ? true : toReturn;
		return toReturn;
 	}	
	
	
 	public void rendirse() {
 		for(int i=0; i<cantFilas; i++)
 			for(int j=0; j<cantColumnas; j++)
 				tablero[i][j].setValor(matriz[i][j]);
 	}
	
	public int getDificultad() {
		return dificultad;
	}
	


public boolean esCorrectoo() {
	boolean es=true;
	int[][] matrizAux = new int[9][9];
	int[][] matrizAux2 = new int[9][9];

	for (int i=0;i<9;i++) {
		for (int j=0;j<9;j++) {
			
			matrizAux[i][j]= tablero[i][j].getValor();
			matrizAux2[i][j]=matriz[i][j];
			
		}
	}
	
	int i=0;int j=0;
	
	while ((i<9)&&es) {
		while ((j<9)&&es)
		{
			if (matrizAux[i][j]!=matrizAux2[i][j])
				es=false;
			else {
				j++;
			}
		}
		j=0;
		i++;
	}
	
	return es;
}


public boolean chequearMatriz() {
	int i=0; int j;
	boolean si=true;
	while((i<9)&&(si)) {
		j=0;
		while((j<9)&&si) {
			if ((matriz[i][j]-1)!=(tablero[i][j].getValor()))
				{si=false;}

			else j++;

		}
	}
	
	return si;
}


public int[][] getMatriz() {
	return matriz;
}




public String  ruta() {
	return rut;
}




public int [][] filaerror(){
	int [] []aux = new int[9][9] ;
	for (int i=0;i<9;i++) {
		for (int j=0;j<9;j++) {
			
			int valor = tablero[i][j].getValor();
			if ((tablero[i][j]!=null)&& (valor!=matriz[i][j]))
				aux[i][j]=1;
			else aux[i][j]=0;
			
		}
	}
	return aux;
	
}

public String [] columnaerror() {
	String [] aux = new String[9] ;
return aux;
}

public String [] cuadranteerror() {
	String [] aux = new String[9] ;
return aux;
}


public Celda [][] getTablero() {
	return tablero;
}



}
