import validator.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import park.Park;
import storage.Storage;

// the main controller for the program
@RestController
@EnableAutoConfiguration
public class App {

    private Gson gson;
    private Storage storagehelper = new Storage();

    // Hello World
    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    public String getGreeting() {
        return "Hello World...";
    }

    // Create Park /parkpay/parks/ POST JSON
    @RequestMapping(value = "/parks", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String createPark(@RequestBody String parkJSON) throws Exception {
        gson = new Gson();
        JsonObject successfulReturn = new JsonObject();
        ParkValidator validator = new ParkValidator();
        Park validatedPark = validator.parkValidation(parkJSON); // maybe add a exception
        storagehelper.savePark(validatedPark);
        successfulReturn.addProperty("pid", validatedPark.getPid());
        return gson.toJson(successfulReturn);
    }

    // Update Park /parkpay/021312 PUT JSON
    @RequestMapping(value = "/parks/{PID}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void updatePark(@PathVariable(value = "PID") String pid, @RequestBody String parkJSON) {
        ParkValidator validator = new ParkValidator();
        Park validatedPark = validator.parkValidation(parkJSON);
        storagehelper.updatePark(validatedPark, pid);
    }

    // Delete Park /parkpay/021312 DELETE - void
    @RequestMapping(value = "/parks/{PID}", method = RequestMethod.DELETE)
    public void deletePark(@PathVariable(value = "PID") String pid) {
        storagehelper.deletePark(pid);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
