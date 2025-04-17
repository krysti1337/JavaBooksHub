package com.example.JavaBooksHub.frontDesigne;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.JavaBooksHub.security.*;
import com.vaadin.flow.component.button.Button;

import java.awt.*;

@Route("login")
@PageTitle("Login | JavaBooks Hub")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
    private final LoginForm login = new LoginForm();
    UserService userService = new UserService();


    public LoginView(UserService userService) {

         /*Punem un nume de clasa ca sa putem stiliza mai ușor pagina de login cu CSS
        Facem ca pagina sa ocupe tot ecranul, să arate „plin”
        Centram tot ce adaugam in mijloc, pe verticala
        Si pe orizontala – vrem ca totul sa fie exact in mijlocul paginii
        Spunem componentei de login unde sa trimita datele cand cineva apasa „Login”
        Adaugam un titlu mare si formularul de login in pagina
         */

        this.userService = userService;

        // Layout setup
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        getStyle().set("background-color", "#1E1E1E");

        login.setAction("/login");
        login.getElement().getStyle().set("background-color", "#2C2C2C");
        login.getElement().getStyle().set("padding", "2rem");
        login.getElement().getStyle().set("border-radius", "10px");
        login.getElement().getStyle().set("box-shadow", "0 0 10px rgba(0,0,0,0.5)");
        login.getElement().getStyle().set("color", "#F0F0F0");

        H1 title = new H1("JavaBooks Hub");
        title.getStyle().set("color", "#FFA500");

        Button registerRedirect = new Button("Register", event -> UI.getCurrent().navigate("register"));
        registerRedirect.getStyle().set("background-color", "#FFA500");
        registerRedirect.getStyle().set("color", "white");
        registerRedirect.getStyle().set("margin-top", "1rem");
        registerRedirect.getStyle().set("border-radius", "8px");

        add(title, login, registerRedirect);

        login.addLoginListener(e -> {
            boolean authenticated = userService.authenticateUser(e.getUsername(), e.getPassword());
            if (authenticated) {
                UI.getCurrent().navigate("home");
            } else {
                login.setError(true);
            }
        });
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (event.getLocation().getQueryParameters().getParameters().containsKey("error")) {
            login.setError(true);
        }
    }


}
