package dni;

import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dni ricardo= new Dni("43228543C");
		System.out.println(ricardo.checkDni());
		Dni churruflato = new Dni("X0000023T");
		Dni arturo = new Dni("43226690F");
		System.out.println(churruflato.getParteNumericaNie());
		Pattern UltimasLetrasProhibidasNIE = Pattern.compile("[^IÑOU]");
		System.out.println(UltimasLetrasProhibidasNIE.matcher("z").matches());
		System.out.println(churruflato.checkPrimeraLetraNIE());
		System.out.println(churruflato.checkID());
		System.out.println(ricardo.checkID());
		System.out.println("el dni 43226690F es : " + arturo.checkID().toString());
		System.out.println("el nif X0000023T es : " + churruflato.checkID().toString());
		
		
	}

}
