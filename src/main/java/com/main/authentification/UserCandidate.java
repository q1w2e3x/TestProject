package com.main.authentification;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

// Model for storing user info before account confirmation
@Entity
@Table(name = "user_candidate")
@Component
public class UserCandidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "login", unique = true)
    @NotNull(message = "Поле не может быть пустым")
    @Length(min = 3, max = 45, message = "Длина от 3 до 45 символов")
    @Pattern(regexp = "\\w+", message = "Введены недопустимые символы")
    @UniqueUser
    private String login;

    @Column(name = "password")
    @NotNull(message = "Поле не может быть пустым")
    @Length(min = 8, max = 30, message = "Длина от 8 до 30 симоволов")
    @ValidPassword
    private String password;

    // Random generated string for user account confirmation
    @Column(name = "confirm_code")
    private String confirmCode;

    @Column(name = "email")
    @NotNull(message = "Поле не может быть пустым")
    @Length(max = 45, message = "Длина до 45 символов")
    @Email
    private String email;

    @Column(name = "phone")
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Введите номер без лишних символов или пробелов")
    private String phone;

    @Column(name = "registration_date")
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
