package cn.edu.teacraftsmanship.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Track {
    @Id
    private Long id;
    private String name;
    private String city;
    private String content;
    private double x;
    private double y;
    private String img;
}
