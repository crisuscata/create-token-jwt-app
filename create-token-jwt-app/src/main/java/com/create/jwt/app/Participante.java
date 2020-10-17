package com.create.jwt.app;

import java.util.Date;

public class Participante {

	private String id;
    private String codigo;
    private String tipoPersona;
    private String razonSocial;
    private String codigoSectorEconomico;
    private String nombre1;
    private String nombre2;
    private String nombre3;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    
    
    public Participante() {
    	this.setId("49257");
		this.setCodigo("44719257");
		this.setTipoPersona("MAN");
		this.setRazonSocial("AV LA MOLINA");
		this.setCodigoSectorEconomico("");
		this.setNombre1("NOMBRE 1");
		this.setNombre2("NOMBRE 2");
		this.setNombre3("NOMBRE 3");
		this.setApellidoPaterno("APELLIDO PATERNO1");
		this.setApellidoMaterno("APELLIDO MATERNO2");
		this.setFechaNacimiento(new Date());
		this.setTipoDocumento("DNE");
		this.setNumeroDocumento("47788988");
		this.setTipoFirma("MNO");
	}
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCodigoSectorEconomico() {
		return codigoSectorEconomico;
	}
	public void setCodigoSectorEconomico(String codigoSectorEconomico) {
		this.codigoSectorEconomico = codigoSectorEconomico;
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getNombre3() {
		return nombre3;
	}
	public void setNombre3(String nombre3) {
		this.nombre3 = nombre3;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getTipoFirma() {
		return tipoFirma;
	}
	public void setTipoFirma(String tipoFirma) {
		this.tipoFirma = tipoFirma;
	}
	private String tipoDocumento;
    private String numeroDocumento;
    private String tipoFirma;
	
}
