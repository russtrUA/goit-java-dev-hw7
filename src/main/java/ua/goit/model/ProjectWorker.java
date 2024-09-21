package ua.goit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectWorker {
    private Integer projectId;
    private Integer workerId;
}
