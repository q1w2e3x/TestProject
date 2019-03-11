import com.main.authentification.User;
import com.main.shop.entities.Order;
import com.main.shop.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.time.LocalDate;

public class TestingUsersAndOrders {

    public static void main(String[] args) {
        createUser(new User("abcdefg", "12345678aA", "email@mail.ru", "+77777777777", LocalDate.now(), (short) 1));
        addOrderToUser(new Order(123.123, "first", "second", "address", "+77777777777", LocalDate.now(), "That is comment"), 1);
        addOrderFromNonUser(new Order(543543.43232, "first2", "second2", "address2", "+77777777777", LocalDate.now(), "That is comment"));
    }

    public static void addOrderFromNonUser(Order order) {
        System.out.println("Saving order: " + order);
        try (SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
        System.out.println("Order saved successfully");
    }

    public static void createUser(User user) {
        System.out.println("Saving user: " + user);
        try (SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
        System.out.println("User saved successfully");
    }

    public static void addOrderToUser(Order order, int userId) {
        System.out.println("Saving order for user: " + order);
        try (SessionFactory factory = new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
             Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, userId);
            user.addOrder(order);
            session.save(order);
            session.close();
        }
        System.out.println("Order added to user successfully");
    }


}
