package com.example.JavaBooksHub.frontDesigne;

import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;

import java.util.stream.Stream;
import java.awt.*;

public class RegistrationForm extends FormLayout {

    private H3 title;

    private TextField username;
    private EmailField email;
    private PasswordField password;
    private PasswordField passwordConfirm;

    private Checkbox allowMarketing;
    private Span errorMessageField;
    private Button submitButton;

    public RegistrationForm() {

        title = new H3("Signup");
        username = new TextField("First name");
        email = new EmailField("Email");



        setRequiredIndicatorVisible(username, email, password, passwordConfirm);

        errorMessageField = new Span();

        submitButton = new Button("Join the JavaBooks Hub!");
        submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        add(title, username, email, password, passwordConfirm, errorMessageField, submitButton);

        setMaxWidth("500px");

        // Allow the form layout to be responsive.
        // On device widths 0-490px we have one column.
        // Otherwise, we have two columns.
        setResponsiveSteps(
                new ResponsiveStep("0", 1, ResponsiveStep.LabelsPosition.TOP),
                new ResponsiveStep("490px", 2, ResponsiveStep.LabelsPosition.TOP));

        // These components always take full width
        setColspan(title, 2);
        setColspan(email, 2);
        setColspan(errorMessageField, 2);
        setColspan(submitButton, 2);
    }

    public PasswordField getPasswordField() {
        return password;
    }

    public PasswordField getPasswordConfirmField() {
        return passwordConfirm;
    }

    public Span getErrorMessageField() {
        return errorMessageField;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    private void setRequiredIndicatorVisible(HasValueAndElement<?, ?>... components) {
        Stream.of(components).forEach(comp -> comp.setRequiredIndicatorVisible(true));
    }
}
