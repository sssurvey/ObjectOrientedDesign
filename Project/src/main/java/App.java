import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// the main controller for the program
@RestController
@EnableAutoConfiguration
public class App {

    @RequestMapping("/hello-world")
    public String getGreeting() {
        return "Hello World...";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
