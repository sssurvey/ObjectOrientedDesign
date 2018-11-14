import jsonUtil.*;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import park.Park;
import responseCode.NotFoundResponseCode;
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
        // System.out.println("POST - > " + storagehelper.getTotalParkCount());
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
    @RequestMapping(value = "/parks/{PID}", method = RequestMethod.DELETE, produces = { "application/json" })
    public ResponseEntity<String> deletePark(@PathVariable(value = "PID") String pid, HttpServletRequest request) {
        if (storagehelper.deletePark(pid)) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Park Pid Not Found", "NOT FOUND", request,
                            "The Park that related to this PID is not found, thus no delete action has been done")));
        }
    }

    // Get All park /parkpay/parks GET -- return list of all parks, with location
    // info
    @RequestMapping(value = "/parks", method = RequestMethod.GET, produces = { "application/json" })
    public String getAllParks() {
        return ParkToJsonConvertor.allParkToJsonLoactionInfoAndPidToJson();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
