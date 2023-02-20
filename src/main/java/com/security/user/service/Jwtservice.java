package com.security.user.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class Jwtservice {
	
	
	private static final String SECRET = "3677397A24432646294A404E635266556A586E5A7234753778214125442A472D"; //randomkey form kwygenerator.com

	
	
	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
		
	}
	private <T> T extractClaim(String token,Function<Claims,T> claims) {
		// TODO Auto-generated method stub
		final Claims clai = extractAllClaims(token);
		
		return claims.apply(clai);
	}
	
	private Claims extractAllClaims(String token) {
		// TODO Auto-generated method stub
		return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
	}
	public String getToken(String username){
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims,username);
		
	}

	private String  createToken(Map<String, Object> claims, String username) {

		return Jwts.builder()
		    .setClaims(claims)
		    .setSubject(username)
		    .setIssuedAt(new Date(System.currentTimeMillis()))
		    .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*30))
		    .signWith(getKey(),SignatureAlgorithm.HS256).compact();
	}
//	public String extractUsername(String token) {
//		return extractClaim(token, Claims::getSubject);
//	}
	
	private Boolean isTokenExpired(String token) {
		return extractExDate(token).before(new Date());
	}
	
	public Boolean validateToken(String token,UserDetails userDetails) {
		if(extractClaim(token, Claims::getSubject).equals(userDetails.getUsername()) && !isTokenExpired(token) ) {
			return true;
		}
		return false;
	}
	
	public Date extractExDate(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private Key getKey() {
		// TODO Auto-generated method stub
		
		byte[]keybytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keybytes);
	}

}
