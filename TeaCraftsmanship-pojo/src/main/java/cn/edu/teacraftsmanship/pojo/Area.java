package cn.edu.teacraftsmanship.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Area {
    @Id
    private Long id;
    private String name;
    private double x;
    private double y;
}
