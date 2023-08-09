package it.yourfirstjob.Leman.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column(nullable = false)
    private String name;
    private String email;
    private String password;
    private String phone;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonManagedReference(value="JobApplication-user")
    private List<JobApplication> jobApplications;


}
