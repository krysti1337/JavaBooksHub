package com.example.JavaBooksHub.frontDesigne;

import com.example.JavaBooksHub.security.UserService;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;


@CssImport("./registration.css")
@Route("register")
public class RegistrationView extends VerticalLayout {

    public RegistrationView(UserService userService) {

        // Stil general
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        getStyle().set("background-color", "#1E1E1E");

        // Titlu
        H1 title = new H1("Create Account");
        title.getStyle().set("color", "#FFA500");

        // Campuri
        TextField username = new TextField("Username");
        EmailField email = new EmailField("Email");
        PasswordField password = new PasswordField("Password");
        PasswordField confirmPassword = new PasswordField("Confirm Password");

        // Aplica stil
        username.addClassName("custom-input-field");
        email.addClassName("custom-input-field");
        password.addClassName("custom-input-field");
        confirmPassword.addClassName("custom-input-field");


        // Buton inregistrare
        Button registerButton = new Button("Register", event -> {
            if (!password.getValue().equals(confirmPassword.getValue())) {
                Notification.show("Passwords do not match.");
                return;
            }
            userService.registerUser(username.getValue(), email.getValue(), password.getValue());
            Notification.show("Registration successful!");
            UI.getCurrent().navigate("login");
        });

        registerButton.getStyle().set("background-color", "#FFA500");
        registerButton.getStyle().set("color", "white");
        registerButton.getStyle().set("margin-top", "1rem");
        registerButton.getStyle().set("border-radius", "8px");

        // Adauga componente
        add(title, username, email, password, confirmPassword, registerButton);
    }
}
