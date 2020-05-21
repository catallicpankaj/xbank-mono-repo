package com.ms2.ms2Assignment.security;

// src/main/java/com/auth0/example/security/SecurityConfig.java

//@EnableWebSecurity
public class SecurityConfig /* extends WebSecurityConfigurerAdapter */ {

	/*
	 * @Value("${auth0.audience}") private String audience;
	 * 
	 * @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}") private
	 * String issuer;
	 * 
	 * @Bean JwtDecoder jwtDecoder() { NimbusJwtDecoder jwtDecoder =
	 * (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);
	 * 
	 * OAuth2TokenValidator<Jwt> audienceValidator = new
	 * AudienceValidator(audience); OAuth2TokenValidator<Jwt> withIssuer =
	 * JwtValidators.createDefaultWithIssuer(issuer); OAuth2TokenValidator<Jwt>
	 * withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer,
	 * audienceValidator);
	 * 
	 * jwtDecoder.setJwtValidator(withAudience);
	 * 
	 * return jwtDecoder; }
	 * 
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .mvcMatchers("/api/public").permitAll()
	 * .mvcMatchers("/api/private").authenticated()
	 * .mvcMatchers("/api/private-scoped").hasAuthority("SCOPE_read") .and()
	 * .oauth2ResourceServer().jwt(); }
	 */
}