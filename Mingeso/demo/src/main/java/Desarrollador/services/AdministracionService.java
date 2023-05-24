package Desarrollador.services;


import Desarrollador.entities.AcopioLecheEntity;
import Desarrollador.entities.AdministracionEntity;
import Desarrollador.entities.ProveedorEntity;
import Desarrollador.repositories.AdministracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdministracionService {

    @Autowired
    AdministracionRepository administracionRepository;
    public void guardarAdministracion(String quincena, String codigo_proveedor, String nombre_proveedor, String total_kls_leche,
                                      String nro_dias_envio_leche, String promedio_kls_leche, String variacion_leche, String grasa,
                                      String variacion_grasa, String solidos_totales, String variacion_solidos_totales,
                                      String pago_leche, String pago_grasa, String pago_solidos_totales, String bonificacion_frecuencia,
                                      String descuento_variacion_leche, String descuento_variacion_grasa, String descuento_variacion_solidos,
                                      String pago_total, String monto_retencion, String monto_final) {
        AdministracionEntity administracion = new AdministracionEntity();
        administracion.setQuincena(quincena);
        administracion.setCodigo_proveedor(codigo_proveedor);
        administracion.setNombre_proveedor(nombre_proveedor);
        administracion.setTotal_kls_leche(total_kls_leche);
        administracion.setNro_dias_envio_leche(nro_dias_envio_leche);
        administracion.setPromedio_kls_leche(promedio_kls_leche);
        administracion.setVariacion_leche(variacion_leche);
        administracion.setGrasa(grasa);
        administracion.setVariacion_grasa(variacion_grasa);
        administracion.setSolidos_totales(solidos_totales);
        administracion.setVariacion_solidos_totales(variacion_solidos_totales);
        administracion.setPago_leche(pago_leche);
        administracion.setPago_grasa(pago_grasa);
        administracion.setPago_solidos_totales(pago_solidos_totales);
        administracion.setBonificacion_frecuencia(bonificacion_frecuencia);
        administracion.setDescuento_variacion_leche(descuento_variacion_leche);
        administracion.setDescuento_variacion_grasa(descuento_variacion_grasa);
        administracion.setDescuento_variacion_solidos(descuento_variacion_solidos);
        administracion.setPago_total(pago_total);
        administracion.setMonto_retencion(monto_retencion);
        administracion.setMonto_final(monto_final);
        administracionRepository.save(administracion);
    }

    public ArrayList<AdministracionEntity> obtenerReporte(){
        return (ArrayList<AdministracionEntity>) administracionRepository.findAll();
    }

    public int sueldoCategoria(ProveedorEntity categoria, AcopioLecheEntity kls_leche){
        if (categoria.equals("A")) {
            return (700 * Integer.parseInt(String.valueOf(kls_leche)));
        } else if (categoria.equals("B")) {
            return (550 * Integer.parseInt(String.valueOf(kls_leche)));
        } else if (categoria.equals("C")) {
            return (450 * Integer.parseInt(String.valueOf(kls_leche)));
        } else if (categoria.equals("D")) {
            return (250 * Integer.parseInt(String.valueOf(kls_leche)));
        }
        return 0;
    }

    public int sueldoGrasa(Integer grasa,Integer kls_leche) {
        if (0 <= grasa && grasa <= 20) {
            return kls_leche*30;
        }
        if (21 <= grasa && grasa <= 45) {
            return kls_leche*80;
        }
        if (46 <= grasa && grasa < 101) {
            return kls_leche*120;
        }
        return 0;
    }

    public int sueldoSolido(Integer solido,Integer kls_leche) {
        if (0 <= solido && solido <= 7) {
            return kls_leche*-130;
        }
        if (8 <= solido && solido <= 18) {
            return kls_leche*-90;
        }
        if (19 <= solido && solido <= 35) {
            return kls_leche*95;
        }
        if (46 <= solido && solido < 101) {
            return kls_leche*150;
        }
        return 0;
    }

}
