package ejercicio;

import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<Character> Letras = new TreeSet<Character> (); 
		String texto="dabale arroz a la zorra el abad";
		for (int n=0; n<texto.length (); n++){ 
			char letraDeTexto = texto.charAt (n);
			Character letraNueva= new Character(letraDeTexto);
			Letras.add(letraNueva);
			 }
		for (Character letra: Letras) {
			System.out.println(letra);
		
	}
	}

}
