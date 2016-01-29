package dni;
import java.util.regex.*;
public class Dni{
	private String dni  = null;
	private Boolean numeroSano = false;
	private Boolean letraSana 	= false;
	// Composición (agregación) "Has - a" / "Tiene - un"
	private TablaAsignacion tabla = new TablaAsignacion();
	private Pattern PrimerasLetrasNIE = Pattern.compile("[XYZ]");
	

	/* Constructores */
	
	public Dni(String dni) {
		this.dni = dni;
	}
	
	/* Encapsulacion */
	
	public void setDni(String cadena){
		this.dni = cadena;
	}

	public String getDni(){
		return this.dni;
	}

	private void setNumeroSano(Boolean valor){
		this.numeroSano = valor;
	}
	
	public Pattern getPrimerasLetrasNIE() {
		return PrimerasLetrasNIE;
	}

	public void setPrimerasLetrasNIE(Pattern primerasLetrasNIE) {
		PrimerasLetrasNIE = primerasLetrasNIE;
	}
	public Boolean getNumeroSano(){
		return this.numeroSano;
	}
	
	private void setLetraSana(Boolean valor){
		this.letraSana = valor;
	}

	public Boolean getLetraSana(){
		return this.letraSana;
	}
	
	/*
	 * Lógica 
	 */

	/* Interfaz Pública */
	public Boolean checkID(){
		return checkCIF() || checkNIE();
	}
	public Boolean checkCIF(){
		return checkDni() && checkLetra(getParteNumericaDni());
	}
	
	public Boolean checkDni(){
		setNumeroSano( checkLongitud() && stringEsNumero( getParteNumericaDni() ) );
		return getNumeroSano();
	}
	public Boolean checkNIE(){
		setNumeroSano( checkLongitud() && stringEsNumero( getParteNumericaNie() ) );
		return checkPrimeraLetraNIE() && checkLongitud() && stringEsNumero(getParteNumericaNie())&& checkLetra(getParteNumericaNie());
	}
	
	public Boolean checkLetra(String parteNumerica){
		if (getNumeroSano() ) {
			setLetraSana ( Character.isUpperCase(getParteAlfabeticaDni()) && checkLetraValida(parteNumerica) );
			return getLetraSana();
		}
		else {
			return false;
		}
	}
					
	public Character obtenerLetra(String parteNumerica){
		// calcularLetra no puede ejecutarse si antes no se cumplen las condiciones previas en checkDni
		// y checkletra
		if ( getNumeroSano() ){
			return this.tabla.calcularLetra( parteNumerica );
		}
		else // EXCEPCION: aun no sabemos implementarlas - este código no es admisible
			return getParteAlfabeticaDni();
	}


	public Boolean checkLongitud() {
		return getDni().length() == 9;
	}
	
	public Boolean stringEsNumero(String cadena){
		for( int i=0; i < cadena.length(); i++ ){
			if ( ! Character.isDigit(cadena.charAt(i)) ){
				return false;
			}
			else;
		}
		return true;
	}
	public Boolean checkPrimeraLetraNIE(){
		Boolean sano = false;
		System.out.println(dni.substring(0, 1));
		if (getPrimerasLetrasNIE().matcher(dni.substring(0, 1).toUpperCase()).matches()){
			sano = true;
		}
		return sano;		
	}
		
	public String getParteNumericaDni() {
		return (String) dni.substring(0, dni.length() - 1);
	}
	public String getParteNumericaNie(){
		int valorLetra = 0;
		if (dni.substring(0, 1).toUpperCase().equals("X")){
			valorLetra = 0;
		}
		else if (dni.substring(0, 1).toUpperCase().equals("Y")){
			valorLetra = 1;
		}
		else if (dni.substring(0, 1).toUpperCase().equals("Z")){
			valorLetra = 2;
		}
		return valorLetra + dni.substring(1,dni.length() - 1);
	}
	
	public Character getParteAlfabeticaDni() {
		return dni.charAt(dni.length() - 1);
	}
	
	public Boolean checkLetraValida(String parteNumerica) {
		if ( getNumeroSano() ) {
			return getParteAlfabeticaDni() == obtenerLetra(parteNumerica);
		}
		else
			return false;
	}

}
