package pe.edu.upc.hello.platform.generic.interfaces.rest.assemblers;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import pe.edu.upc.hello.platform.generic.domain.model.entity.Developer;
import pe.edu.upc.hello.platform.generic.interfaces.rest.resources.GreetDeveloperRequest;

public class DeveloperAssembler {
    public static Developer toEntityFromRequest(GreetDeveloperRequest request) {
        if(ObjectUtils.isEmpty(request) || StringUtils.isAnyBlank(request.firstName(), request.lastName())){
            return null;
        }
        return Developer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();
    }
}
