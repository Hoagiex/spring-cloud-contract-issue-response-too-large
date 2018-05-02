package consumer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = { "issue-spring-cloud-contract:producer:+:stubs:8080" }, workOffline = true)
public class StubTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testLargeResponse() {
        final String result = time(() -> restTemplate.getForObject("http://localhost:8080/api/whocares", String.class));

        assertThat(result).isNotNull();
    }

    private <R> R time(final Supplier<R> supplier) {
        final long startTime = System.nanoTime();

        final R result = supplier.get();

        final long endTime = System.nanoTime();

        assertThat((endTime - startTime) / 1000000).isLessThan(3000);

        return result;
    }
}
