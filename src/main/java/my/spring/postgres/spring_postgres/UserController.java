package my.spring.postgres.spring_postgres;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import my.spring.postgres.spring_postgres.AppUser;
import my.spring.postgres.spring_postgres.AppRepo;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    AppRepo appRepo;

    @GetMapping (path="/timeclock")
    public ResponseEntity<String> timeclock() {

        return new ResponseEntity<>("2025-03-05", HttpStatus.OK);
    }

    @PostMapping (path="/timeclock")
    public ResponseEntity<String> timeclockP() {

        return new ResponseEntity<>("2025-03-05", HttpStatus.OK);
    }

    //@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, path = "/user", produces = "application/json")
    @PostMapping(path = "/user", produces = "application/json")
    public ResponseEntity<String> createTutorial(@RequestBody AppUser appUser) {
    try {
            appRepo.createUser(new AppUser(appUser.getUserName(), appUser.getUserPassword(), appUser.getUserRoleId()));
            return new ResponseEntity<>("User created succefully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    @GetMapping("/userlist")
    public ResponseEntity<List<AppUser>> getAllUsers(@RequestParam(required = false) String userName) {

        try {
            List<AppUser> userList = new ArrayList<AppUser>();
            if (userName == null) {
                appRepo.showAllUsers().forEach(userList::add);
            } else {
                appRepo.findUser(userName).forEach(userList::add);
            }

            if (userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(userList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */

    @GetMapping("/userlist")
    public ResponseEntity<List<AppUser>> getAllUsers(@RequestParam(required = false) String userName) {

        try {
            List<AppUser> userList = new ArrayList<AppUser>();
            appRepo.showAllUsers().forEach(userList::add);
            return new ResponseEntity<>(userList, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
