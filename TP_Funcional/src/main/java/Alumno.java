import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString

public class Alumno {
    private String nombre;
    private float nota;
    private String curso;
}
