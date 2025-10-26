import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString

public class Empleado {
    private String nombre;
    private String departamento;
    private float salario;
    private int edad;
}
