package com.create.jwt.app;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

//import javax.crypto.SecretKey;

public class CrearToken {

	public static void main(String[] args) {
		//String token = "eyJraWQiOiJjb21wYW55S2V5UlNBMDAyIiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJERU1PIENvbXBhbnkgSldUIFJTQSIsImlzcyI6InVzZXJkZW1vIn0.T4liqNLcgNE9IMQ1qyeiR3Qt_DSMa_gwoBBYatzvGUDFYym-79Z4quZ1UQFe66BVxTIT8xlcfHr7aKAva9fREG2DwJGJgZlYf-vn-a0gYmb1g8t7JNb6HQCeef89z7Ns9NQHxz3YfUJtOqYq8Rb2u94mnD5bO6jHdJTRpf_9-Ht3Wo8k4NOo47lbe61Wo7gIE85JGcvZReMTAGyY600E2gqiQfyym8KTHqSS7V94HiEB4F8IBRTgLpRHimVU1fWXZqUMn3pv4Drr_dG9iAVROhIHXkKuE9mfke7jc_aD7-rZz2AcBQYK2PykBCpVhMmFxWIJkoXFzv12A5TF6ax12Q";
		
		//String jws = readJWSWithBase64();
		
		//String jws = readJws();
		String jws = createToken();
		
		System.out.println("Token: " + jws);
		
		System.out.println(validateToken(jws));
	}
	
	private static String generarToken() {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();
		
		return jws;
	}
	
	private static String createToken() {
		//Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		//System.out.println(" key: " + key);
		//SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(signPrivate()));
		String secretString = "123456789123456789123456789123456789123456789";
		SecretKey key = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
		
		Map<String,Object> header = new HashMap<String, Object>();;
		header.put("kid", "myKeyId");
		
		Claims claims = Jwts.claims();
		claims.setIssuer("metoo");
		claims.setSubject("Bob");
		claims.setExpiration(new Date()); //ES IMPORTANTE LA EXPIRACION, YA QUE SI LA TOMARIA EN LA VALIDACION validateToken
		
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"id\": ").append("a");
		
		Participante participante = new Participante();
		
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
		
		claims.setAudience(sJson);
		
		
		String jws = Jwts.builder() // (1)
						 .setHeader(header)
						 .setClaims(claims)     // (2) 
			    		 .signWith(key)          // (3)
			    		 .compact();             // (4)
		return jws;
	}
	
	private static String signPrivate() {
		StringBuilder sb = new StringBuilder();
		sb.append("-----BEGIN PRIVATE KEY-----");
		sb.append("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCZisQxETKR4E5m2mi6iseDxbq0F+fej9tHmbMJANVMTnXLnjt2YlcftrXTxP74MTuKN8+oADVmuDOx6mpzySnUNSFUxUNCR3ff63K47dHBRgU2Ige0YccvSPq2N0OkoRdtPL5x4ZEcI9x+cU8sDPGgJHCMH8K5uGtSNmhcfj7SA3yyQwaV7d2Xjvy+D7kxldaO5rsx2tPMWxxfkm8QbKOSJZKPIRbD4v0eOwtALsUAau56voP9JUx2m42dD0Mns45m2cDAI0uJfynJiyR06b7xLdTtL1Cr+0RysccIpVRXVzMGnLwZLOLiVct1An7vMrm48VmJqYjlDc3haYVlW1JtAgMBAAECggEAKli+UXYXx2ng1bcpKUG7UxmGq8LoHVb5uF6opTQIn/oHvPfQGI94zfNbZKOxWoxhinZoHEKqd8EX6NrpLzPtCGz622FocnA5nJVYV66nqjGAoHR0QYiyIdVz6CuHyXDwgB0/vTLkDanKV0ky98g+H9fM/qiH0ScO2mbNE61x8AO7eEtRIdywUmJp/JzsD/YeE4h1pG/1Yb7fNf1ivNyQh1BGt19nXSUsJx/Y9VsabINTZGBvJVINFfzqhxFUw2HINw7EMgDIONklvXHY1saPLb88iop2TDNETod+cOAn+E3Nm9Z7fBgIwitG0xa08LZmR7H1XFdaFbhWVvg710P/9QKBgQD95Zr1YlzyA9BY8s5fjX70lE7NnFmwo73R0BJzB2+ZXbOcQ4EPPmnDaDG9mC4wlOgsxNfrnFDxPWEIcU4sex+LS2CLYB5SzP09zjZXdbi/EmYFn74/Bg4+frMOWGi822if6sIzh0thT3ym8sHkAo1U+Oavvac9f/INabOwl6xbbwKBgQCa0FsrSZtI+4ISm0WIbHfJcGGcE4GJVhMhOFhjVoq5G6mNYRvnj7hYvQwQYiJgVUcwBJDQwFRJbxr8T+L4KA85PcqLUhjpBTr4Tz1tbclIcCyTsVWxmRmk88HOT3cWhYYNKIOm21aNkSXr5K3cGPjbgeA+YP7uijllAu0vC1ox4wKBgQDu1Jz/Vpe30H6cLUqT97YEu72lC/4SevSD+QZhzgzcZ5gc1iMBA+TZO5oOjqhkaq477q5to41AYEx2dJ7kmK0DitQ2RyQ/HzTYfrH/c21lzxjJEYsUHc4oW2ZziBZ+EKZKR7qGXi46S1smcBSTNxNbawcVKYG4CDLZCyVMaGBpYQKBgQCH6n7wHRpA09aZgUplgF0WNBzuCs4CBdibpL0s0XDPHPMZlXULMkl1Vtu9knp9usDZ7lg5fXFCW1IEzBoHJhxfc9lbwYLvKVFhaSgT53v8pcbtD5adaj1ybTLsbyWtVyKecMBMgGqXtSPm2wisoBvzky2Ndli6kg3bmdskH0JbYwKBgGbbctrWNmm2yt5CdZIDtRU+IppkKf40HG6TOmlTgRfR9TOi/83KoNZR41yEPjc1WjpQploc3bpWWPe0KdgF7btRCDEFuOQKaa2/y/RekRIplYIAbW0ARbaE2ZGGyT1Ox5mobjKtbklcfKcoxU1ueLskfLwYqOn2l73HFkGV3Vi+");
		sb.append("-----END PRIVATE KEY-----");
		
		return "";
	}
	
	private static String readJWSWithBase64() {
		String jwsString = "eyJraWQiOiJteUtleUlkIiwiYWxnIjoiSFMyNTYifQ.eyJpc3MiOiJtZXRvbyIsInN1YiI6IkJvYiIsImF1ZCI6IjEwNDY2ODg5MzgifQ.aCYToFRDPhStjbUU38nO35CAWpL9rgBeXgeWh4QrMtY";
		
		Jws<Claims> jws;
		String secretString = "MTIzNDU2Nzg5MTIzNDU2Nzg5MTIzNDU2Nzg5MTIzNDU2Nzg5MTIzNDU2Nzg5"; //base64(123456789123456789123456789123456789123456789)
		//SecretKey key = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
		try {
			
			jws = Jwts.parserBuilder()  // (1)
				    .setSigningKey(key)         // (2)
				    .build()                    // (3)
				    .parseClaimsJws(jwsString); // (4)
			
			jws.getBody();
			System.out.println("jws.getBody().getAudience(): " + jws.getBody().getAudience());
			System.out.println("jws.getBody().getSubject(): " + jws.getBody().getSubject());
			System.out.println("jws.getBody().getIssuer(): " + jws.getBody().getIssuer());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "";
	}
	
	
	private static String validateToken(String token) {
		String val = "";
		try {
			System.out.println("begin validateToken");
			String secretString = "123456789123456789123456789123456789123456789";
			SecretKey key = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
			
		    Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

		    //OK, we can trust this JWT
		    val = "validation ok";
		    System.out.println("fin validateToken");
		} catch (JwtException e) {
			System.out.println("secret incorrecto validateToken");	
			val = e.getMessage();
		}
		
		return val;
	}

}

