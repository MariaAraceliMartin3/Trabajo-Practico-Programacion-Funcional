import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString

public class Producto {
    private String nombre;
    private String categoria;
    private float precio;
    private int stock;
}
