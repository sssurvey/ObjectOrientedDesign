import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ControllerTryingOut {
    @RequestMapping(value = "/hello-new-world", method = RequestMethod.GET)
    public String getGreeting() {
        return "Hello World.God.damn.it!";
    }
}