package MyLibrary;

import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;


public class MyArreglo extends Applet implements ActionListener{
	
	public static void printStrings(Graphics g,String[] arreglo,int x,int y) {
		
		for(int o = 0; o < arreglo.length;o++) {
			
			g.drawString(arreglo[o],x,y + 15 * o);
			
		}
		
	}
	
	public static void printInts(Graphics g,int x,int y,int[] arreglo) {
		
		for(int o = 0; o < arreglo.length;o++) {
			
			g.drawString("" + arreglo[o],x,y + 15 * o);
			
		}
		
	}
	
	public static void printIntsHorizontal(Graphics g,int x,int y,int[] arreglo) {
		
		int xInicial = x;
		int yInicial = y;
		int oInicial = 0;
		
		for(int o = 0; o < arreglo.length;o++) {
			
			g.drawString("" + arreglo[o],xInicial + 25 * oInicial,yInicial);
			oInicial++;
			
			if(xInicial + 25 * oInicial  == 1000) {
				
				xInicial = x;
				yInicial += 20;
				oInicial = 0;
				
			}
			
		}
		
	}
	
	public static void fillStrings(String[] arreglo, String elemento) {
		
		for(int i = 0; i < arreglo.length;i++) {
			
			arreglo[i] = elemento;
			
		}
		
	}
	
	public static void fillInts(int[] arreglo, int elemento,int range) {
		
		for(int i = 0; i < range;i++) {
			
			arreglo[i] = elemento;
			
		}
		
	}
	
	public static void fillInts(int[] arreglo, int elemento) {
		
		for(int i = 0; i < arreglo.length;i++) {
			
			arreglo[i] = elemento;
			
		}
		
	}
	
	public static void fillInts(int[] arreglo) {
		
		for(int i = 0; i < arreglo.length;i++) {
			
			arreglo[i] = i + 1;
			
		}

	}
	
	public static void fillIntsRange(int[] arreglo) {
		
		for(int i = 0; i < arreglo.length;i++) {
			
			arreglo[i] = i;
			
		}

	}
	
	public static void fillIntsRandom(int[] arreglo,int range) {
		
		for(int i = 0; i < arreglo.length;i++) {
			
			arreglo[i] = (int)(Math.random() * range) + 1;
			
		}

	}
	
	public static int biggestInt(int[] arreglo) {
		
		int mayor = arreglo[0];
		
		for(int i = 0; i < arreglo.length;i++) {
			
			if(arreglo[i] > mayor) {
				
				mayor = arreglo[i];
				
			}
			
		}
		
		return mayor;
		
	}
	
	public static int smallestInt(int[] arreglo) {
		
		int mayor = arreglo[0];
		
		for(int i = 0; i < arreglo.length;i++) {
			
			if(arreglo[i] < mayor) {
				
				mayor = arreglo[i];
				
			}
			
		}
		
		return mayor;
		
	}
		
	public void setTextFields(TextField[] textField,int width) {
		
		for(int i = 0;i < textField.length;i++) {
			
			textField[i] = new TextField(width);
			textField[i].addActionListener(this);
			add(textField[i]);
			
		}
		
	}
	
	public void setButtons(Button[] buttons,String[] buttonNames) {
		
		for(int i = 0;i < buttons.length;i++) {
			
			buttons[i] = new Button(buttonNames[i]);
			buttons[i].addActionListener(this);
			add(buttons[i]);
			
		}
		
	}
	
	public static int addInts(int[] data) {
		
		int total = 0;
		
		for(int i = 0; i < data.length; i++) {
			
			total += data[i];
			
		}
		
		return total;
		
	}
		
	public static int[] escalarValores(int[] datos, int mayor, int yAltura) {
		
		int[] escalados = new int[datos.length];
		
			for(int i = 0; i < datos.length; i++) {
				
				escalados[i] = (datos[i] * yAltura) / mayor;
				
			}
		
		return escalados;
		
	}
	
	public static int[] escalarValores(int[] datos, int yAltura) {
		
		int mayor = biggestInt(datos);
		
		int[] escalados = new int[datos.length];
		
			for(int i = 0; i < datos.length; i++) {
				
				escalados[i] = (datos[i] * yAltura) / mayor;
				
			}
		
		return escalados;
		
	}
	
	public static int mediaInts(int[] array) {
		
		int media = addInts(array) / array.length;
		return media;
		
	}
	
	public void setScrollbars() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
