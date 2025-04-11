package pe.edu.upc.hello.platform.generic.interfaces.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hello.platform.generic.domain.model.entity.Developer;
import pe.edu.upc.hello.platform.generic.interfaces.rest.assemblers.DeveloperAssembler;
import pe.edu.upc.hello.platform.generic.interfaces.rest.assemblers.GreetDeveloperAssembler;
import pe.edu.upc.hello.platform.generic.interfaces.rest.resources.GreetDeveloperRequest;
import pe.edu.upc.hello.platform.generic.interfaces.rest.resources.GreetDeveloperResponse;

/**
 * REST controller for handling greeting-related requests.
 * Provides endpoints to retrieve and create greetings for developers
 */
@RestController
@RequestMapping("/greetings")
public class GreetingsController {
    /**
     * Handles GET requests to retrieve a greeting for a developer based on query parameters
     *
     * @param firstName the optional first name of the developer
     * @param lastName the optional last name of the developer
     * @return a ResponseEntity containing a GreetDeveloperResponse with a 200 OK status
     */
    @GetMapping
    public ResponseEntity<GreetDeveloperResponse> greetDeveloper(
            @RequestParam( required = false ) String firstName,
            @RequestParam( required = false ) String lastName
    ) {
        Developer developer = ( firstName != null && lastName != null )
                ? Developer.builder().firstName(firstName).lastName(lastName).build()
                : null;

        GreetDeveloperResponse response = GreetDeveloperAssembler.toResourceFromEntity(developer);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles POST requests to create a greeting for a developer based on the request body
     *
     * @param request the GreetDeveloperRequest containing first and last names
     * @return a ResponseEntity containing a GreetDeveloperResponse with a 201 Created Status
     */
    @PostMapping
    public ResponseEntity<GreetDeveloperResponse> createGreeting(
            @RequestBody GreetDeveloperRequest request
    ) {
      Developer developer = DeveloperAssembler.toEntityFromRequest(request);
      GreetDeveloperResponse response = GreetDeveloperAssembler.toResourceFromEntity(developer);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
