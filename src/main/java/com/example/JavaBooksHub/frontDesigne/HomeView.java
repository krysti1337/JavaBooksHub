package com.example.JavaBooksHub.frontDesigne;


import com.example.JavaBooksHub.model.User;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;

@Route("home")
@AnonymousAllowed
public class HomeView extends VerticalLayout {

    public HomeView() {
        add(
              new H1("Home view")
        );

    }
    GridContextMenu<User> menu = new GridContextMenu<>();


}
