package lk.ijse.aad_assignment01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class StudentDto implements Serializable {
    private String name;
    private String age;
    private String email;
    private String mobile;
}
