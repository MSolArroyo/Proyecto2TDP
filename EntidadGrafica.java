

import javax.swing.ImageIcon;

public class EntidadGrafica {
	private ImageIcon grafico; //guarda la imagen
	private String[] imagenes; //arreglo de strings
	
	public EntidadGrafica() {
		this.grafico = new ImageIcon();
		this.imagenes = new String[]{"/img/0.jpg", "/img/1.jpg","/img/2.jpg","/img/3.jpg","/img/4.jpg","/img/5.jpg","/img/6.jpg","/img/7.jpg","/img/8.jpg"};
	}
	
	public void actualizar(int indice) {
		if (indice < this.imagenes.length) {
			ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(this.imagenes[indice]));
			this.grafico.setImage(imageIcon.getImage());
		}
	}
	
	public ImageIcon getGrafico() {
		return this.grafico;
	}
	
	public void setGrafico(ImageIcon grafico) {
		this.grafico = grafico;
	}
	
	public String[] getImagenes() {
		return this.imagenes;
	}
	
	public void setImagenes(String[] imagenes) {
		this.imagenes = imagenes;
	}
	
}