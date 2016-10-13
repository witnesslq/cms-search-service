package demo.api.v1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zyhao.openec.OpenecApplication;
import com.zyhao.openec.api.v1.DemoServiceV1;
import com.zyhao.openec.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OpenecApplication.class)
@ActiveProfiles(profiles = "test")
@WebIntegrationTest
public class DemoServiceTest {

    @Autowired
    private DemoServiceV1 demoService;

    @Test
    public void testGetShoppingCart() throws Exception {
        User user = demoService.getDemo();
        //Catalog catalog = new Catalog();
        //Assert.notNull();
        //Assert.notEmpty();
    }
}