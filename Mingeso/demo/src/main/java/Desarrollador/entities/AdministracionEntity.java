package Desarrollador.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "administracion")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdministracionEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String quincena;
    private String codigo_proveedor;
    private String nombre_proveedor;
    private String total_kls_leche;
    private String nro_dias_envio_leche;
    private String promedio_kls_leche;
    private String variacion_leche;
    private String grasa;
    private String solidos_totales;
    private String variacion_solidos_totales;
    private String pago_leche;
    private String pago_grasa;
    private String pago_solidos_totales;
    private String bonificacion_frecuencia;
    private String descuento_variacion_leche;
    private String descuento_variacion_grasa;
    private String descuento_variacion_solidos;
    private String pago_total;
    private String monto_retencion;
    private String monto_final;
}
