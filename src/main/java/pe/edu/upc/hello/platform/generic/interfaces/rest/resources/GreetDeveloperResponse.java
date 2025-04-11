package pe.edu.upc.hello.platform.generic.interfaces.rest.resources;

import java.util.UUID;

public record GreetDeveloperResponse(UUID id, String fullName, String message) {
    public GreetDeveloperResponse(String message) {
        this(null, null, message);
    }
}
