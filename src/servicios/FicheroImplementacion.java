package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controladores.Inicio;
import dtos.PropietarioDto;
import dtos.VehiculoDto;

public class FicheroImplementacion implements FicheroInterfaz {

	public void crearFicheroLog(String msg) {

		FileWriter fw = null;

		try {

			fw = new FileWriter(Inicio.RUTACOMPLETALOG, true);

			fw.write(msg.concat("\n"));

			fw.close();

		} catch (Exception e) {

			System.err.println("Error-007, siga usando la aplicacion con normalidad".concat(e.toString()));
		}
	}

	public void cargaInicial() {

		try {

			FileReader fr = new FileReader(Inicio.RUTACOMPLETAFICHERODATOS);
			BufferedReader bf = new BufferedReader(fr);

			String lineas;

			while ((lineas = bf.readLine()) != null) {

				String[] campos = lineas.split(":");

				VehiculoDto vd = new VehiculoDto();
				PropietarioDto pd = new PropietarioDto();

				vd.setMatricula(campos[0]);
				pd.setMatricula(campos[0]);

				String fecha = campos[1];

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDateTime fechaCombertiDate = LocalDateTime.parse(fecha, formatter);

				vd.setFchMatriculacion(fechaCombertiDate);

				pd.setDni(campos[2]);

				String fechaCompra = campos[1];

				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDateTime fechaCompraCombertida = LocalDateTime.parse(fechaCompra, formato);
				
				pd.setFchCompra(fechaCompraCombertida);
				
				pd.setId(OperativaImplementacion.calcularIdPropietarios());
				vd.setId(OperativaImplementacion.calcularIdVehiculo());
			
				
				Inicio.listaPropietario.add(pd);
				Inicio.listaVehiculosDtos.add(vd);

			}
			bf.close();

		} catch (Exception e) {

			System.err.println("Error-006, siga usando la aplicacion con normalidad".concat(e.toString()));
		}

	}
	public void escribirFicheroDatos() {

		FileWriter fw = null;

		try {

			fw = new FileWriter(Inicio.RUTACOMPLETAFICHERODATOS, true);

			for (VehiculoDto vDto : Inicio.listaVehiculosDtos) {
				
				for(PropietarioDto pDto : Inicio.listaPropietario) {
					
					fw.write(vDto.getMatricula().concat(":").concat(vDto.getFchMatriculacion().toString()).concat(":").concat(pDto.getDni().concat(pDto.getFchCompra().toString())));
				}
			}

			fw.close();

		} catch (Exception e) {

			System.err.println("Error-008, siga usando la aplicacion con normalidad".concat(e.toString()));
		}
	}

}
