package dni;

import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dni ricardo= new Dni("43228543C");
		System.out.println(ricardo.checkDni());
		Dni churruflato = new Dni("x4324777j");
		Dni falsisimo = new Dni("x43247dfh77j");
		System.out.println(churruflato.getParteNumericaNie());
		Pattern UltimasLetrasProhibidasNIE = Pattern.compile("[^IÑOU]");
		System.out.println(UltimasLetrasProhibidasNIE.matcher("z").matches());
		System.out.println(churruflato.checkPrimeraLetraNIE());
		System.out.println(churruflato.checkUltimaLetraNIE());
		System.out.println(churruflato.checkID());
		System.out.println(ricardo.checkID());
		System.out.println(falsisimo.checkID());
		
	}

}
