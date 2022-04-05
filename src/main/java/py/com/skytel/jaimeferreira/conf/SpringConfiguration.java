package py.com.skytel.jaimeferreira.conf;

import java.time.Duration;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SpringConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration cc = new CorsConfiguration();
		cc.setAllowedHeaders(Arrays.asList("Origin,Accept", "X-Requested-With", "Content-Type",
				"Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization"));
		cc.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		cc.setAllowedOrigins(Arrays.asList("/*"));
		cc.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT", "PATCH"));
		cc.addAllowedOrigin("*");
		cc.setMaxAge(Duration.ZERO);
		cc.setAllowCredentials(Boolean.TRUE);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", cc);
		return source;
	}

}
