package dtos;

import java.time.LocalDateTime;

public class PropietarioDto {

	int id;
	String dni;
	LocalDateTime fchCompra;
    String matricula; 
    boolean esHistorico = false;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public LocalDateTime getFchCompra() {
		return fchCompra;
	}
	public void setFchCompra(LocalDateTime fchCompra) {
		this.fchCompra = fchCompra;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public boolean isEsHistorico() {
		return esHistorico;
	}
	public void setEsHistorico(boolean esHistorico) {
		this.esHistorico = esHistorico;
	}
	

	public PropietarioDto() {
		
	}
	
    public String ToString(String c) {
		
		String mostrar = c.concat(dni);
		
		return mostrar;
	}
}
