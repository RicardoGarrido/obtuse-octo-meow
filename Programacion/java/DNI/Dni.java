package dni;
import java.util.regex.*;
public class Dni{
	private String dni  = null;
	private Boolean numeroSano = false;
	private Boolean letraSana 	= false;
	// Composición (agregación) "Has - a" / "Tiene - un"
	private TablaAsignacion tabla = new TablaAsignacion();
	private Pattern PrimerasLetrasNIE = Pattern.compile("[XYZ]");
	private Pattern UltimasLetrasProhibidasNIE = Pattern.compile("[^IÑOU]");
	

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

	public Pattern getUltimasLetrasProhibidasNIE() {
		return UltimasLetrasProhibidasNIE;
	}

	public void setUltimasLetrasProhibidasNIE(Pattern ultimasLetrasProhibidasNIE) {
		UltimasLetrasProhibidasNIE = ultimasLetrasProhibidasNIE;
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
		return checkDni() && checkLetra();
	}
	
	public Boolean checkDni(){
		setNumeroSano( checkLongitud() && stringEsNumero( getParteNumericaDni() ) );
		return getNumeroSano();
	}
	public Boolean checkNIE(){
		return checkPrimeraLetraNIE() && checkUltimaLetraNIE() && checkLongitud() && stringEsNumero(getParteNumericaNie());
	}
	
	public Boolean checkLetra(){
		if (getNumeroSano() ) {
			setLetraSana ( Character.isUpperCase(getParteAlfabeticaDni()) && checkLetraValida() );
			return getLetraSana();
		}
		else {
			return false;
		}
	}
					
	public Character obtenerLetra(){
		// calcularLetra no puede ejecutarse si antes no se cumplen las condiciones previas en checkDni
		// y checkletra
		if ( getNumeroSano() ){
			return this.tabla.calcularLetra( getParteNumericaDni() );
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
	public Boolean checkUltimaLetraNIE(){
		Boolean sano = false;
		if (getUltimasLetrasProhibidasNIE().matcher(dni.substring(getDni().length()-1,getDni().length()).toUpperCase()).matches()){
			sano = true;
		}
		return sano;		
	}
		
	public String getParteNumericaDni() {
		return (String) dni.substring(0, dni.length() - 1);
	}
	public String getParteNumericaNie(){
		return (String) dni.substring(1,dni.length() - 1);
	}
	
	public Character getParteAlfabeticaDni() {
		return dni.charAt(dni.length() - 1);
	}
	
	public Boolean checkLetraValida() {
		if ( getNumeroSano() ) {
			return getParteAlfabeticaDni() == obtenerLetra();
		}
		else
			return false;
	}

}
