package com.example.JavaBooksHub;

import com.example.JavaBooksHub.frontDesigne.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
public class JavaBooksHubApplication{

    public static void main(String[] args) {

        SpringApplication.run(JavaBooksHubApplication.class, args);
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        super.configure(http);
//        setLoginView(http, LoginView.class);
//    }

}
