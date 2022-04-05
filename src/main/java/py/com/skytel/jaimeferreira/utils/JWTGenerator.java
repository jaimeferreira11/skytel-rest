package py.com.skytel.jaimeferreira.utils;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import py.com.skytel.jaimeferreira.dtos.UserDTO;

public class JWTGenerator {

	private static String SECRET_KEY = "35t3.35.e1.533d.5ecr3t0!";

	public static String createJWT(UserDTO user) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	
		String subject = user.getName().replaceAll("(?i)[^aeiou]", "")
				+ user.getLastName().charAt(user.getLastName().length() - 1) + getEvenNumbers(user.getPhoneNumber());

	
		JwtBuilder builder = Jwts.builder().setId(user.getId().toString()).setSubject(subject)
				.signWith(signatureAlgorithm, signingKey);

		long expMillis = System.currentTimeMillis() + 800000;
		Date exp = new Date(expMillis);
		builder.setExpiration(exp);

		return builder.compact();
	}

	public static Claims decodeJWT(String jwt) {

		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).parseClaimsJws(jwt)
				.getBody();
		return claims;
	}

	private static String getEvenNumbers(String number) {

		String result = "";
		for (String str : number.split("")) {
			try {
				int n = Integer.parseInt(str);

				if (n % 2 == 0)
					result += str;
				
			} catch (NumberFormatException e) {
				System.out.println(str + " no es un numero");
			}
			
		}

		return result;

	}

}
