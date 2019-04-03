package providers;

import com.main.authentication.UserCandidate;
import com.main.configs.ClientWebConfig;
import com.main.dao.UserCandidateDAO;
import com.main.shop.entities.Product;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DaoBasicTestsProvider implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("userCandidateDAO", getUserCandidateInput()),
                Arguments.of("productDAO", getProductInput())

        );
    }

    private List<Object> getProductInput() {
        List<Object> result = new ArrayList<>();
        Product product1 = new Product("MyProduct", "MyDesciprtion", 10);
        result.add(product1);
        return result;
    }

    private List<Object> getUserCandidateInput() {
        List<Object> result = new ArrayList<>();

        // First UserCandidate
        UserCandidate uc1 = new UserCandidate();
        uc1.setLogin("CREATEDINPROVIDERuc1");
        uc1.setEmail("fdsfd@mafds.ru");
        uc1.setPassword("123445678aA");
        uc1.setPhone("+77777777777");
        uc1.setRegistrationDate(LocalDate.now());
        uc1.setConfirmCode("fdsfdsfd");

        // Second UserCandidate
        UserCandidate uc2 = new UserCandidate();
        uc2.setLogin("CREATEDINPROVIDERuc2");
        uc2.setEmail("fdsfd@mafds.ru");
        uc2.setPassword("123445678aA");
        uc2.setPhone("+77777777777");
        uc2.setRegistrationDate(LocalDate.now());
        uc2.setConfirmCode("fdsfdsfd");

        // Add all UserCandidates
        result.add(uc1);
        result.add(uc2);

        return result;
    }
}
