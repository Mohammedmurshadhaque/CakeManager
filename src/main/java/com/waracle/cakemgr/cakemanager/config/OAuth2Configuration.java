package com.waracle.cakemgr.cakemanager.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@RequiredArgsConstructor
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter{
	
	   private String clientId = "client";
	   private String clientSecret = "secret";
	   private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
			   "MIIEpAIBAAKCAQEA9G9nk6jMgW3cHxmxdnQ6tLAvd86nVtax14XXZWEW5fwSe5lC\n" +
			   "KImnfXqiMvOU0jw+bIwnPIghA/zpJcWBbfcA7efzun4iBWgW2Q/EhAzOhj0kbZvF\n" +
			   "LXY8jy3ouSG6RZV/twIjWmQ57tu5R5iihX0cdBGWiZg+qLV4AxNZYEhNHSIpYkt5\n" +
			   "dSZ/2TychBMaGc62UHceZ1jzOxG8pUZymFicqAUnlcAhDBGkZpBw/5PXIURoKgPj\n" +
			   "dG/vBY0TUMQ1nK5uFa31GQVTxQKSqL6AOJpen7HGt5BRDv3i687h0tSXdeK2rYfT\n" +
			   "/uo25xLBEaMZUp0RDSjuzl3m6vHOe/gQ0oBLXQIDAQABAoIBAAtiFMS/m6Z7Y0Df\n" +
			   "hXAqwYEgo1VE/m4A2Y9b4EgMWXCkaIfw/y+8GVyylVMiHNAdlhqf/EPJYyA4avMj\n" +
			   "W3+vfQ+XObZ5oUP3MPkyzsgHgKanukaQdoJDe1Z/oNLeSzpqV+RB6TuQZ1JEUUCQ\n" +
			   "TyFATk7pcsU9nc1lhg0+nW7qbwzoLxBrj5o2ky2FxRkKQ8FjifVF/2vK8SODyi1I\n" +
			   "grlJ2uVK3npWsRLU4jtpmIO2t+kbJg/9f9T8Vsprf98beICtnOLwBBJI0vB21KeD\n" +
			   "vj90zljui3bodJ1/cvYdnEtGISq1RmBNr1jJSEfZ/At4l1vTsjVSAKEQu5u4cJRr\n" +
			   "8nTQklECgYEA/GVxls5LlbG3pj5P+5SMQXIGVOPPEnmWUYloWvh/EZYMw1XMALsc\n" +
			   "TDgctlcxFk/bozzUjGnMbpyCsq6r/GZKNOIJLwEc9PdretFOrJEiNUybp7BD+hki\n" +
			   "1dKrmH4H0r/STeDGLsz6xDBb0l+qiTYahXtzIAUfQ5gs7fOeglyZndMCgYEA9+zc\n" +
			   "kU7EUXxTa82zSH1EMFrr3SjAJ1gNOgiEgisKg2y/X3OGdhS8jYEA/Pr8yY5idtK3\n" +
			   "PVVx3R4HKmVrzNPoSUKqj4vr9VesztZlnQgthnPkbmyhmeZqnT1TZhyQrHvQke+l\n" +
			   "J9b1D/n2sICYs/oH6RfmS1dj0u3GMafYJAmcRA8CgYEArCAqhOQPW/kk+3THaxT1\n" +
			   "SbSPaNkrYLgWsWh6CIAreDzSW2xpgZ4ZQEmMGzX/Pe4cJYjYkyGbz1thLqY8mBbS\n" +
			   "SJpWFP43V0Bcxhd0Be+8WojyJjvpP+hgf136tDZO84Tp0T6XKVeVNLKeDCw9yvFg\n" +
			   "yONVseKMXbar/WMFGHY6NQ0CgYB0Xkf1KDx7ZtidDBLvnmRoMfTtfJgcn3at25ue\n" +
			   "oWcw4tU8jzP4rqkF3hxBoekPDfbngOYjMrzcJaEFZE9h98DayiDWeb2KDdn9x6Iw\n" +
			   "P8tmhXUd431CiGVYYpWHozbAzujJ5urlNT8XfaMtm16Rc3VNEju091LSiWpymi6Y\n" +
			   "U652PwKBgQC5Tx0QXBdljMf0QQ2JCHpsKnDasnrPNO5u6CWXYGSLnrBIVnULMTjY\n" +
			   "xjzQX7WI0b+aEOGVJjGpQPZTQsWYXMY84SU9pmJQNelqiQJersvMiTvI7fDRdrrw\n" +
			   "YGUhvkoPR8sJvsdrAa6hRvsKc3ZGfEbKLd8IegaB03LCUpaWFTG3gQ==\n" +
			   "-----END RSA PRIVATE KEY-----";
	   private String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
			   "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA9G9nk6jMgW3cHxmxdnQ6\n" +
			   "tLAvd86nVtax14XXZWEW5fwSe5lCKImnfXqiMvOU0jw+bIwnPIghA/zpJcWBbfcA\n" +
			   "7efzun4iBWgW2Q/EhAzOhj0kbZvFLXY8jy3ouSG6RZV/twIjWmQ57tu5R5iihX0c\n" +
			   "dBGWiZg+qLV4AxNZYEhNHSIpYkt5dSZ/2TychBMaGc62UHceZ1jzOxG8pUZymFic\n" +
			   "qAUnlcAhDBGkZpBw/5PXIURoKgPjdG/vBY0TUMQ1nK5uFa31GQVTxQKSqL6AOJpe\n" +
			   "n7HGt5BRDv3i687h0tSXdeK2rYfT/uo25xLBEaMZUp0RDSjuzl3m6vHOe/gQ0oBL\n" +
			   "XQIDAQAB\n" +
			   "-----END PUBLIC KEY-----";

	   @Qualifier("authenticationManagerBean")
	   private final AuthenticationManager authenticationManager;
	   
	   @Autowired
	   PasswordEncoder passwordEncoder;
	   
	   @Bean
	   public JwtAccessTokenConverter tokenEnhancer() {
	      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	      converter.setSigningKey(privateKey);
	      converter.setVerifierKey(publicKey);
	      return converter;
	   }
	   
	   @Bean
	   public JwtTokenStore tokenStore() {
	      return new JwtTokenStore(tokenEnhancer());
	   }
	   
	   @Override
	   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	      endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
	      .accessTokenConverter(tokenEnhancer());
	   }
	   @Override
	   public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
	      security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	   }
	   @Override
	   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	      clients.inMemory().withClient(clientId).secret(passwordEncoder.encode(clientSecret)).scopes("read", "write")
	         .authorizedGrantTypes("password", "refresh_token", "client_credentials").accessTokenValiditySeconds(300)
	         .refreshTokenValiditySeconds(300);

	   }

}
