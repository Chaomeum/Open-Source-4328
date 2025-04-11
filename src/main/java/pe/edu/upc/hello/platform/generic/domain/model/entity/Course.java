package pe.edu.upc.hello.platform.generic.domain.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

@Builder
@Getter
public class Course {
    private final UUID id = UUID.randomUUID();
    private final String name;
    private final Double hours;

    private Course(String name, Double hours) {
        this.name = StringUtils.trimToEmpty(name);
        this.hours = hours;
    }

    public String getCourseName(){
        return name;
    }

    public boolean isNameEmpty(){
        return StringUtils.isEmpty(name);
    }

    public boolean isNameBlank(){
        return StringUtils.isBlank(name);
    }

    public Double getCourseHours(){
        return hours;
    }
}
