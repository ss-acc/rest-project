package com.rest.card.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;

@EnableWebSecurity
public class OauthSecurityConfig extends WebSecurityConfigurerAdapter {
  @Value("${auth0.audience}")
  private String audience;

  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
  private String issuer;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
//        .mvcMatchers(HttpMethod.POST, "/card/**").permitAll()
//       .mvcMatchers(HttpMethod.GET, "/cards").authenticated() 
      .antMatchers("/**").permitAll().anyRequest().anonymous();
    http.cors().and().csrf().disable();
/*      .anyRequest()
      .permitAll()
      .and()
      .oauth2ResourceServer()
      .jwt()
      .decoder(jwtDecoder());
*/
  }

  JwtDecoder jwtDecoder() {
    OAuth2TokenValidator<Jwt> withAudience = new OauthAudienceValidator(audience);
    OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
    OAuth2TokenValidator<Jwt> validator = new DelegatingOAuth2TokenValidator<>(withAudience, withIssuer);

    NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromOidcIssuerLocation(issuer);
    jwtDecoder.setJwtValidator(validator);
    return jwtDecoder;
  }
}