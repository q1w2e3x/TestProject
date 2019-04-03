import com.main.authentication.UserCandidate;
import com.main.configs.ClientWebConfig;
import com.main.dao.GenericDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.web.context.WebApplicationContext;
import providers.DaoBasicTestsProvider;

import java.util.List;

@SpringJUnitWebConfig(ClientWebConfig.class)
public class DaoBasicTesting {

    @Autowired
    private WebApplicationContext wac;


    @ParameterizedTest
    @ArgumentsSource(DaoBasicTestsProvider.class)
    void testDaoCreate(String DaoBeanId, List<Object> input) {
        GenericDAO dao = (GenericDAO) wac.getBean(DaoBeanId);
        input.forEach(inputElem -> dao.create(inputElem));
    }


}
