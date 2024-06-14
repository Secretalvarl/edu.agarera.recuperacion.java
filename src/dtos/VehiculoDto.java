package dtos;

import java.time.LocalDateTime;

public class VehiculoDto {

	int id;
	String matricula;
	LocalDateTime fchMatriculacion;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public LocalDateTime getFchMatriculacion() {
		return fchMatriculacion;
	}
	public void setFchMatriculacion(LocalDateTime fchMatriculacion) {
		this.fchMatriculacion = fchMatriculacion;
	}
	
	public VehiculoDto() {
		
	}
	
	public VehiculoDto(int id, String matricula, LocalDateTime fchMatriculacion) {
		
		this.id = id;
		this.matricula = matricula;
		this.fchMatriculacion = fchMatriculacion;
	}
	
	public String ToString(String a) {
		
		String mostrar = a.concat(matricula);
		
		return mostrar;
	}
}
