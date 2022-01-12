package com.ems.employeemanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userServiceDetails;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userServiceDetails,
                             JwtTokenProvider jwtTokenProvider){
        this.userServiceDetails = userServiceDetails;
        this.jwtTokenProvider = jwtTokenProvider;
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

        @Override
        public void configure(WebSecurity web) throws Exception {

            web.ignoring()
                    .antMatchers("/", "/favicon.ico", "/**/*.png", "/**/*.gif",
                                "/**/*.svg",  "/**/*.jpg", "/**/*.html", "/**/*.css", "/**/*.js")
                    .antMatchers("/user/create")
                    .antMatchers("/user/login")
                    .antMatchers("/user/activate/{id}")
                    .antMatchers("/swagger-ui.html")
//                    .antMatchers("/v3/api-docs/**")
                    .antMatchers("/swagger-ui/**")
            .antMatchers("/swagger-resources/**", "/v2/api-docs/**" ,"/api-doc","/webjars/**")
            ;
        }

//         http.csrf().disable();
//    // No session will be created or used by spring security
//        http.cors().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable CSRF (cross site request forgery)
        // enabled by default
        http.csrf();
        // No session will be created or used by spring security
        http.cors();
        // set authentication policies for each routes
        http.authorizeRequests().anyRequest().authenticated();
        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userServiceDetails);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
