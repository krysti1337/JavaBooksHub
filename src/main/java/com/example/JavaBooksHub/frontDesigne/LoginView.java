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

        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(new H1("JavaBooks Hub"), login);

        login.addLoginListener(e -> {
            String username = e.getUsername();
            String password = e.getPassword();

            boolean authenticated = userService.authenticateUser(username, password);

            if (authenticated) {
                UI.getCurrent().navigate("home");
            } else {
                login.setError(true);
            }
        });
    }


    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // infromeaza user-ul despre erroarea aparuta la autentificare
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }


}
