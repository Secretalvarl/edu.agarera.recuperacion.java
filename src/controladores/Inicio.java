package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.PropietarioDto;
import dtos.VehiculoDto;
import servicios.FicheroImplementacion;
import servicios.FicheroInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.OperativaImplementacion;
import servicios.OperativaInterfaz;

public class Inicio {
	/*
	 * ruta global del fichero log
	 */
	public static final String RUTACOMPLETALOG = "C:\\Users\\Profesor\\eclipse-workspace-recuperacion-java\\edu.agarera.recuperacion.java\\Log\\".concat(utilidades.Util.crearNombreFichero());
	/*
	 * ruta global del fichero de datos
	 */
	public static final String RUTACOMPLETAFICHERODATOS = "C:\\Users\\Profesor\\eclipse-workspace-recuperacion-java\\edu.agarera.recuperacion.java\\vehiculosYpropietarios\\".concat("vehiculosYpropietarios.txt");
	/*
	 * Lista de vehiculos global 
	 */
	public static List<VehiculoDto> listaVehiculosDtos = new ArrayList<VehiculoDto>();
	/*^
	 * lista de propietarios gloabal
	 */
	public static List<PropietarioDto> listaPropietario = new ArrayList<PropietarioDto>();
	
			public static void main(String[] args) {
		
				Scanner sc = new Scanner(System.in);
				
				FicheroInterfaz fi = new FicheroImplementacion();
				fi.cargaInicial();
				
				MenuInterfaz mi = new MenuImplementacion();
				OperativaInterfaz oi = new OperativaImplementacion();
				
				int opcionSeleccionada;
				boolean cerrarMenu = false;
				
				do {
					try {
						opcionSeleccionada = mi.menuPrincipal(sc);
						
						switch (opcionSeleccionada) {
						case 0:
							fi.crearFicheroLog("Cerrar aplicación");
							fi.escribirFicheroDatos();
							cerrarMenu = true;
						break;
						case 1:
							fi.crearFicheroLog("Venta de vehículo");
							for (VehiculoDto vDto : listaVehiculosDtos) {
								
								for (PropietarioDto pDto : listaPropietario) {
									
									System.out.println(vDto.ToString("[VEH]").concat(pDto.ToString("[PRO]")));
								}
								
								
								
							}
							oi.ventaVehiculo(sc);
							
							break;
						default:
							System.out.println("Opcin seleccionada no valida");
							break;
				
						}
					}catch (Exception e) {
						
						fi.crearFicheroLog(e.toString());
					}
					
					
				}while(!cerrarMenu);

	}

}
