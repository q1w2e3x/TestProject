package com.main.authentification;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

// Модель для пользователя, требующего подтерждения
@Component
public class UserCandidate {

    @NotNull(message = "Поле не может быть пустым")
    @Length(min = 3, max = 45, message = "Длина от 3 до 45 символов")
    @Pattern(regexp = "[\\p{L}\\p{Digit}_]+", message = "Введены недопустимые символы")
    private String login;

    @NotNull(message = "Поле не может быть пустым")
    @Length(min = 8, max = 30, message = "Длина от 8 до 30 симоволов")
    @ValidPassword
    private String password;

    //Случайно генерируемая строка для создания ссылки для подтерждения регистрации, пока пусто
    private String confirmCode;

    @NotNull(message = "Поле не может быть пустым")
    @Length(max = 45, message = "Длина до 45 символов")
    @Email
    private String email;

    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Введите номер без лишних символов или пробелов")
    private String phone;

    private LocalDate registrationDate;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
