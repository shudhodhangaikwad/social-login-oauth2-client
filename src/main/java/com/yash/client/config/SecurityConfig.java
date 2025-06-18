package com.yash.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(request ->
                request
                        .requestMatchers("/secure")
                        .authenticated()
                        .anyRequest()
                        .permitAll()
        );

        http.formLogin(Customizer.withDefaults());
        http.oauth2Login(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration github=githubClientRegistration();
        return new InMemoryClientRegistrationRepository(github);

    }

    private ClientRegistration githubClientRegistration(){
       return CommonOAuth2Provider.GITHUB
               .getBuilder("github")
               .clientId("add_client_id_from_github")
               .clientSecret("add_secret_from_github")
               .build();
    }


}
