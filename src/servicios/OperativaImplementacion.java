package servicios;

import java.time.LocalDateTime;
import java.util.Scanner;

import controladores.Inicio;
import dtos.PropietarioDto;
import dtos.VehiculoDto;

public class OperativaImplementacion implements OperativaInterfaz {
	
	Scanner sc = new Scanner(System.in);

	public static int calcularIdVehiculo() {

		int id;

		if (Inicio.listaVehiculosDtos.size() <= 0) {

			id = 100;
		} else {

			id = 100 - Inicio.listaPropietario.size();
		}

		return id;

	}

	public static int calcularIdPropietarios() {

		int id;

		if (Inicio.listaPropietario.size() <= 0) {

			id = 100;
		} else {

			id = 100 - Inicio.listaPropietario.size();
		}

		return id;

	}
	
	public void ventaVehiculo(Scanner sc) {
		
		boolean ceerarMatricula = false;
		String matriculaDada;
		
		do {
			
			System.out.println("Escriba la matricula del coche");
			matriculaDada = sc.next();
			
			for (VehiculoDto vDto : Inicio.listaVehiculosDtos) {
				
				if (matriculaDada.equals(vDto.getMatricula())) {
					
					ceerarMatricula = true;
				}else {
					
					System.out.println("Matricula no encontrada");
				}
			}
			
			
			
		}while(!ceerarMatricula);
		
		for (VehiculoDto vDto : Inicio.listaVehiculosDtos) {
			
			if (matriculaDada.equals(vDto.getMatricula())) {
				
				System.out.println("Escriba el dni del nuevo propietario");
				String dniDado = sc.next();
				
				for (PropietarioDto propietarioDto : Inicio.listaPropietario) {
					
					propietarioDto.setDni(dniDado);
					
					propietarioDto.setId(calcularIdPropietarios());
					
					LocalDateTime fechaDateTime = LocalDateTime.now();
					
					propietarioDto.setFchCompra(fechaDateTime);
					
					Inicio.listaPropietario.add(propietarioDto);
				}
				
				
			}
		
		
		
		
	  }
  } 
}

