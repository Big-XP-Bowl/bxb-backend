package dat3.bxb.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private int id;
    private String empType; // Represent empType as a String
    private String name;
    private String initials;
    private String imageUrl;
}
