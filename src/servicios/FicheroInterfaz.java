package servicios;

public interface FicheroInterfaz {

	/*
	 * Metodo para crear y escribit en el fichero log
	 */
	public void crearFicheroLog(String msg);
	
	/*
	 * Metodo para extraer los datos de un fichero
	 */
	public void cargaInicial();
	/*
	 * Metodo para escribir en fichero
	 */
	public void escribirFicheroDatos();
}
