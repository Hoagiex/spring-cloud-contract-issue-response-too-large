package issue;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/whocares")
public class DummyEndpoint {

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public String get() {
        return "{\"message\": \"Hello\"}";
    }
}
