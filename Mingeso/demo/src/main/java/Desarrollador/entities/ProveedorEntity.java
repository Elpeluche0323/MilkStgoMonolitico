package Desarrollador.entities;

import org.jetbrains.annotations.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.NotFound;
/**
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
**/

@Entity
@Table(name = "proveedores")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProveedorEntity {
    @Id
    @NotNull
    private String codigo;
    private String nombre;
    private String categoria;
    private String retencion;
}