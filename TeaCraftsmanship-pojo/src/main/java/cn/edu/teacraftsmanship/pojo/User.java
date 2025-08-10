package cn.edu.teacraftsmanship.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String personalProfile;
    private String password;
    private String email;
    private char sex;
    private String salt;
    private String avatarUrl;
}
