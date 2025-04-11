package pe.edu.upc.hello.platform.generic.interfaces.rest.assemblers;

import pe.edu.upc.hello.platform.generic.domain.model.entity.Developer;
import pe.edu.upc.hello.platform.generic.interfaces.rest.resources.GreetDeveloperResponse;
import org.apache.commons.lang3.ObjectUtils;

public class GreetDeveloperAssembler {
    public static GreetDeveloperResponse toResourceFromEntity(Developer developer) {
        if (isDeveloperNullOrEmptyNamed(developer)) {
            return new GreetDeveloperResponse("Welcome Anonymous Spring Boot Developer :D");
        }
        return new GreetDeveloperResponse(
                developer.getId(),
                developer.getFullName(),
                "Congrats " + developer.getFullName() + "! You are a Spring Boot Developer :D"
        );
    }
    private static boolean isDeveloperNullOrEmptyNamed(Developer developer) {
        return ObjectUtils.isEmpty(developer) || developer.isAnyNameBlank() || developer.isAnyNameEmpty();
    }
}
