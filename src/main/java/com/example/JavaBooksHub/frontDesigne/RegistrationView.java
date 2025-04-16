package com.example.JavaBooksHub.frontDesigne;

import com.example.JavaBooksHub.security.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

import javax.swing.*;
import java.awt.*;

@Route("register")
public class RegistrationView extends VerticalLayout {

    public RegistrationView(UserService userService) {

        // Creăm componentele
        TextField username = new TextField("Username");
        EmailField email = new EmailField("Email");
        PasswordField password = new PasswordField("Password");
        PasswordField confirmPassword = new PasswordField("Confirm Password");

        // Setăm componentele ca fiind obligatorii
        username.setRequiredIndicatorVisible(true);
        email.setRequiredIndicatorVisible(true);
        password.setRequiredIndicatorVisible(true);
        confirmPassword.setRequiredIndicatorVisible(true);

        // Buton de înregistrare
        Button registerButton = new Button("Register", event -> {
            if (!password.getValue().equals(confirmPassword.getValue())) {
                Notification.show("Passwords do not match.");
                return;
            }

            // TODO: adaugă logica reală de înregistrare aici
            userService.registerUser(username.getValue(), email.getValue(), password.getValue());


        });

        // Layout styling
        setAlignItems(FlexComponent.Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        setHeight("100vh");

        // Adăugăm toate componentele în layout
        add(username, email, password, confirmPassword, registerButton);
    }
}
