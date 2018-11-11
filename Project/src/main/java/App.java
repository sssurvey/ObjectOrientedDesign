import validator.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import util.NumberFormatter;

// the main controller for the program
@RestController
@EnableAutoConfiguration
public class App {

    // Hello World
    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    public String getGreeting() {
        return "Hello World...";
    }

    // Create Park
    @RequestMapping(value = "/parks", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String createPark(@RequestBody String parkJSON) throws Exception {
        ParkValidator validator = new ParkValidator();
        return validator.parkValidation(parkJSON);
    }

    // Update Park
    @RequestMapping(value = "/parks/{PID}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public String updatePark(@PathVariable(value = "PID") int pid) {
        return NumberFormatter.formatToTenDigitStringPid(pid);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
