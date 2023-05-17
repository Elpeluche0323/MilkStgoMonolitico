package Desarrollador.entities;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "data_grasaysolidos")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class GrasaSolidoEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String proveedor;
    private String grasa;
    private String solidoTotal;
}
