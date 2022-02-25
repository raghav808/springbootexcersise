package com.raghavrs.jwt_example.config;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.raghavrs.jwt_example.model.User;

import static com.raghavrs.jwt_example.model.Constants.ACCESS_TOKEN_VALIDITY_SECONDS;
import static com.raghavrs.jwt_example.model.Constants.SIGNING_KEY;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable{

	private static final long serialVersionUID = 1L;

	public String getUsernameFromToken(String authToken) {
		return getClaimFromToken(authToken, Claims :: getSubject);
	}

	private <T> T getClaimFromToken(String authToken, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(authToken);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String authToken) {
		return Jwts.parser()
				.setSigningKey(SIGNING_KEY)
				.parseClaimsJws(authToken)
				.getBody();
	}

	public boolean validateToken(String authToken, UserDetails userDetails) {
		final String userName = getUsernameFromToken(authToken);
		return(userName.equals(userDetails.getUsername())
				&& !isTokenExpired(authToken)
				);
	}

	private boolean isTokenExpired(String authToken) {
		final Date expiration = getExpirationDateFromToken(authToken);
		return expiration.before(new Date());
	}

	private Date getExpirationDateFromToken(String authToken) {
		return getClaimFromToken(authToken, Claims :: getExpiration);
	}
	
	public String generateToken(User user) {
        return doGenerateToken(user.getUsername());
    }

	private String doGenerateToken(String subject) {
		Claims claims = Jwts.claims().setSubject(subject);
		claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuer("raghavrs")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS*1000))
				.signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
				.compact();
		
	}

}
