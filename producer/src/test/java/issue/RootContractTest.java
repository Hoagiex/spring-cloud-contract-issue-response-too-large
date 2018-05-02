package issue;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = RANDOM_PORT)
public abstract class RootContractTest {

    @LocalServerPort
    @SuppressWarnings("unused")
    private int port;

    @Before
    @SuppressWarnings("squid:S2696")
    public void before() {
        RestAssured.port = port;
    }
}
