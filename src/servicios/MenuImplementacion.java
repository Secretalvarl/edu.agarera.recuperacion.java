package servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz{

	Scanner sc = new Scanner(System.in);
	@Override
	public int menuPrincipal(Scanner sc) {
		
		int opcion;
		
		System.out.println("-----------------------");
		System.out.println("|0. Cerrar aplicación |");
		System.out.println("|1. Venta de vehículo |");
		System.out.println("-----------------------");
		
		opcion = sc.nextInt();
		
		return opcion;
	}

}
