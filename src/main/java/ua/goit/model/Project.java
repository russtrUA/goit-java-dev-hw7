package ua.goit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    private Integer clientId;
    private String name;
    private String startDate;
    private String finishDate;
}
