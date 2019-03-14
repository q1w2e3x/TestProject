package com.main.authentication;


import com.main.shop.entities.Order;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user")
public class User {

    // Left all validation rules just in case, might be useful for account info editing
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    @NotNull(message = "Поле не может быть пустым")
    @Length(min = 3, max = 45, message = "Длина от 3 до 45 символов")
    @Pattern(regexp = "\\w+", message = "Введены недопустимые символы")
    @UniqueUser()
    private String login;

    @Column(name = "password")
    @NotNull(message = "Поле не может быть пустым")
    @Length(min = 8, max = 30, message = "Длина от 8 до 30 симоволов")
    @ValidPassword
    private String password;

    @Column(name = "email")
    @NotNull(message = "Поле не может быть пустым")
    @Length(max = 45, message = "Длина до 45 символов")
    @Email
    private String email;

    @Column(name = "phone")
    @NotNull(message = "Поле не может быть пустым")
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Введите номер без лишних символов или пробелов")
    private String phone;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    // 1 for normal, 2 for banned
    @Column(name = "status")
    private short status;

    @OneToMany(mappedBy = "user",
               cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    private List<Order> orders;

    // Constructors

    public User() {
    }

    public User(String login, String password, String email, String phone, LocalDate registrationDate, short status) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    // Getter and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = (id != 1 && id != 2) ? 1 : id;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    // Other methods

    public void addOrder(Order order) {
        if (orders == null) orders = new ArrayList<>();
        orders.add(order);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registrationDate=" + registrationDate +
                ", status=" + status +
                '}';
    }
}
