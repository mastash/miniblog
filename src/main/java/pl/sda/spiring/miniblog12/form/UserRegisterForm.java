package pl.sda.spiring.miniblog12.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Constraint;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString(exclude = {"password"}) //nie wyswietla hasla w konsoli
public class UserRegisterForm {

    @NotNull(message = "Pole imie musi być podane")
    private String firstName;
    @NotBlank(message = "Nazwisko nie może być puste")
    private String lastName;
    @Email
    @Pattern(regexp = "[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-z]{2,3}", message = "pole email jest niepoprawne")
    private String email;
    @Size(min = 5, max = 20, message = "haslo musi miec pomiedzy {min} a {max} znakow")
    private String password;
}
