package ua.goit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Worker {
    private String name;
    private String birthDay;
    private Level level;
    private Integer salary;
}
