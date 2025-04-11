package pe.edu.upc.hello.platform.generic.domain.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

@Builder
@Getter
public class Developer {
    private final UUID id = UUID.randomUUID();
    private final String firstName;
    private final String lastName;

    private Developer(String firstName, String lastName) {
        this.firstName = StringUtils.trimToEmpty(firstName);
        this.lastName = StringUtils.trimToEmpty(lastName);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean isAnyNameBlank() {
        return StringUtils.isAnyBlank(firstName, lastName);
    }

    public boolean isAnyNameEmpty() {
        return StringUtils.isAnyEmpty(firstName, lastName);
    }

}
