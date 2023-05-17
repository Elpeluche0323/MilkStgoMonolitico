package Desarrollador.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "data_acopio_leche")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcopioLecheEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String fecha;
    private String turno;
    private String proveedor;
    private String kls_leche;

}
