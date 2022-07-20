package lk.codelabs.rentcloud.rentui.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class UiController extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http.authorizeHttpRequests()
               .antMatchers("/")
               .permitAll()
               .anyRequest()
               .authenticated();
    }

    @RequestMapping(value = "/")
    public String loadUI(){
        return "Home";
    }

    @RequestMapping(value = "/secure")
    public String loadSecureUI(){
        return "secure";
    }
}
