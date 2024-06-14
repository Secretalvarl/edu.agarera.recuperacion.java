package utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {
/*
 * Metodo para crear el nombre del fichero log
 */
	public static String crearNombreFichero()
	{
		
		
		
		LocalDate fechaDate = LocalDate.now();
		
		DateTimeFormatter formatoDateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		
		String fechaCombertida = fechaDate.format(formatoDateTimeFormatter);
		
		String nombreFichero = "log-".concat(fechaCombertida).concat(".txt");
		
		return nombreFichero;
		
	}
}
