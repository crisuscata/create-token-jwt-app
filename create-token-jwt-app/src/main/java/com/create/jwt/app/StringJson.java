package com.create.jwt.app;

public class StringJson {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\": \"").append("44719257").append("\"");
		sb.append("}");
		
		
		StringBuilder multiple = new StringBuilder();
		multiple.append("{");
		multiple.append("\"id\": \"").append("44719257").append("\"").append(",");
		multiple.append("\"codigo\": \"").append("44719257").append("\"").append(",");
		multiple.append("\"tipoPersona\": \"").append("44719257").append("\"").append(",");
		multiple.append("\"razonSocial\": \"").append("44719257").append("\"");
		multiple.append("}");
		
		
		StringBuilder constantes = new StringBuilder();
		constantes.append("{");
		constantes. append("\"").append("id").append("\"").append(": \"").append("44719257").append("\"").append(",");
		constantes. append("\"").append("codigo").append("\"").append(": \"").append("44719257").append("\"").append(",");
		constantes. append("\"").append("tipoPersona").append("\"").append(": \"").append("44719257").append("\"").append(",");
		constantes. append("\"").append("razonSocial").append("\"").append(": \"").append("44719257").append("\"").append(",");
		constantes. append("\"").append("nombre1").append("\"").append(": \"").append("44719257").append("\"").append(",");
		constantes. append("\"").append("apellidoPaterno").append("\"").append(": \"").append("44719257").append("\"").append(",");
		constantes. append("\"").append("apellidoMaterno").append("\"").append(": \"").append("44719257").append("\"").append(",");
		constantes. append("\"").append("numeroDocumento").append("\"").append(": \"").append("44719257").append("\"");
		constantes.append("}");
		
		System.out.println(constantes.toString());

	}
	/*
	 String sJson = 
				 "{" 
				   + "\"id\": \""+participante.getId()+"\"," 
				   + "\"codigo\" : \""+participante.getCodigo()+"\"," 
				   + "\"tipoPersona\" : \""+participante.getTipoPersona()+"\"," 
				   + "\"razonSocial\" : \""+participante.getRazonSocial()+"\"," 
				   + "\"nombre1\" : \""+participante.getNombre1()+"\"," 
				   + "\"apellidoPaterno\" : \""+participante.getApellidoPaterno()+"\"," 
				   + "\"apellidoMaterno\" : \""+participante.getApellidoMaterno()+"\"," 
				   + "\"numeroDocumento\" : \""+participante.getNumeroDocumento()+"\""
				   + "}" 
				;
	 * */
}
