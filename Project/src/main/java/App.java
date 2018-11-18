import jsonUtil.*;

import java.io.EOFException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import responseCode.BadRequestResponseCode;
import responseCode.NotFoundResponseCode;

// the main controller for the program /parkpay base
@RestController
@EnableAutoConfiguration
public class App {

    private AppContract presenter = new AppPresenter();

    // Hello World
    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    public String getGreeting() {
        return "Hello World...";
    }

    // Create Park /parkpay/parks/ POST JSON
    @RequestMapping(value = "/parks", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createPark(@RequestBody String parkJSON, HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenter.createPark(parkJSON));
        } catch (Exception didNotPassValidationException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode(
                            "http://cs.iit.edu/~virgil/cs445/project/api/problems/data-validation",
                            "Your request data didn't pass validation", "Something is missing in your request",
                            request)));
        }
    }

    // Update Park /parks/{PID} PUT JSON
    @RequestMapping(value = "/parks/{PID}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updatePark(@PathVariable(value = "PID") String pid, @RequestBody String parkJSON,
            HttpServletRequest request) {
        try {
            presenter.updatePark(pid, parkJSON);
        } catch (Exception pidNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Park Pid Not Found", "NOT FOUND",
                            "The Park that related to this PID is not found, thus no delete action has been done",
                            request)));
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    // Delete Park /parks/{PID}} DELETE - void
    @RequestMapping(value = "/parks/{PID}", method = RequestMethod.DELETE, produces = { "application/json" })
    public ResponseEntity<String> deletePark(@PathVariable(value = "PID") String pid, HttpServletRequest request) {
        try {
            presenter.deletePark(pid);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception pidNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Park Pid Not Found", "NOT FOUND",
                            "The Park that related to this PID is not found, thus no delete action has been done",
                            request)));
        }
    }

    // Get All park /parks GET -- return list of all parks, with location
    // info
    @RequestMapping(value = "/parks", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<String> getAllParks() {
        return ResponseEntity.status(HttpStatus.OK).body(presenter.getAllParks());
    }

    // Get park detail /park/{pid} GET -- return everything about the park
    @RequestMapping(value = "/parks/{PID}", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<String> getParkDetail(@PathVariable(value = "PID") String pid, HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenter.getParkDetail(pid));
        } catch (Exception pidNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Park Pid Not Found", "NOT FOUND",
                            "The Park that related to this PID is not found, thus no delete action has been done",
                            request)));
        }
    }

    // TODO Search parks /parks?key=south GET -- returns array of json of parks that
    // has this key word

    // POST /parks/[pid]/notes -- create note associate with the park
    @RequestMapping(value = "/parks/{PID}/notes", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createNoteAssociateToPark(@PathVariable(value = "PID") String pid,
            @RequestBody String noteJSON, HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenter.createNoteAssociateToPark(pid, noteJSON));
        } catch (EOFException pidNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Park Pid Not Found", "NOT FOUND",
                            "The Park that related to this PID is not found, thus no delete action has been done",
                            request)));
        } catch (Exception notValidJSOException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseJsonParser.toJson(new BadRequestResponseCode(
                            "http://cs.iit.edu/~virgil/cs445/project/api/problems/data-validation",
                            "Your request data didn't pass validation", "Something is missing in your request",
                            request)));
        }
    }

    // GET /parks/[pid]/notes View all notes associated with park
    @RequestMapping(value = "/parks/{PID}/notes", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getAllNoteAssociteToPark(@PathVariable(value = "PID") String pid,
            HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenter.getAllNoteAssociateToPark(pid));
        } catch (Exception pidNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Park Pid Not Found", "NOT FOUND",
                            "The Park that related to this PID is not found, thus no delete action has been done",
                            request)));
        }
    }

    // GET http://localhost:8080/parkpay/parks/124/notes/583
    @RequestMapping(value = "/parks/{PID}/notes/{NID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getNoteEntryViaNidAndPid(@PathVariable(value = "PID") String pid,
            @PathVariable(value = "NID") String nid, HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenter.getNoteEntryViaNidAndPid(pid, nid));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Park Pid Not Found", "NOT FOUND",
                            "The Park that related to this PID is not found", request)));
        }
    }

    // GET /notes Get an array of summary information for all notes.
    @RequestMapping(value = "/notes", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getAllNotes() {
        return ResponseEntity.status(HttpStatus.OK).body(presenter.getAllNotes());
    }

    // GET /notes/[nid] Get note [nid].
    @RequestMapping(value = "/notes/{NID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getNoteByNid(@PathVariable(value = "NID") String nid, HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenter.getNoteViaNid(nid));
        } catch (Exception nidNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Note ID Not Found", "NOT FOUND",
                            "The note that related to this NID is not found", request)));
        }
    }

    // Put /notes/[nid] update that note
    @RequestMapping(value = "/notes/{NID}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateNoteByPid(@PathVariable(value = "NID") String nid, @RequestBody String noteJSON,
            HttpServletRequest request) {
        try {
            String returnNoteJson = presenter.updateNoteByPid(nid, noteJSON);
            if (returnNoteJson != null) {
                return ResponseEntity.status(HttpStatus.CREATED) // Created makes more sense
                        .body(returnNoteJson);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Park Pid Not Found", "NOT FOUND",
                                "The Park that related to this PID is not found", request)));
            }
        } catch (Exception didNotPassValidationException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseJsonParser.toJson(new BadRequestResponseCode(
                            "http://cs.iit.edu/~virgil/cs445/project/api/problems/data-validation",
                            "Your request data didn't pass validation", "Something is missing in your request",
                            request)));
        }
    }

    // TODO: search note

    // POST /orders - create order
    @RequestMapping(value = "/orders", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createOrder(@RequestBody String orderJSON, HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenter.createOrder(orderJSON));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode(
                            "http://cs.iit.edu/~virgil/cs445/project/api/problems/data-validation",
                            "Your request data didn't pass validation", "Something is missing in your request",
                            request)));
        }
    }

    // GET /orders - get all orders
    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getAllNotes(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(presenter.getAllOrder());
    }

    // GET /orders/{PID} - get 1 order
    @RequestMapping(value = "/orders/{OID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getOrderByOid(@PathVariable(value = "OID") String oid, HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenter.getOrderByOid(oid));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Note ID Not Found", "NOT FOUND",
                            "The order that related to this OID is not found", request)));
        }
    }

    // Get /visitors - get All visitors
    @RequestMapping(value = "/visitors", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getAllVisitors(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(presenter.getAllVisitor());
    }

    // Get /visitors/{VID} - get visitor details via vid
    @RequestMapping(value = "/visitors/{VID}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getVisitorDetailsViaVid(@PathVariable(value = "VID") String vid,
            HttpServletRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenter.getVisitorDetailByVid(vid));
            // TODO: clear the JSON date to match the format
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ResponseJsonParser.toJson(new NotFoundResponseCode("Visitor ID Not Found", "NOT FOUND",
                            "The order that related to this VID is not found", request)));
        }
    }

    @RequestMapping(value = "/parks", params = { "key" }, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> searchPark(@RequestParam(value = "key") String key, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(presenter.searchParks(key));
    }

    @RequestMapping(value = "/notes", params = { "key" }, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> searchNotes(@RequestParam(value = "key") String key, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(presenter.searchNotes(key));
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
