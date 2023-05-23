
package Desarrollador.controllers;

import Desarrollador.entities.AcopioLecheEntity;
import Desarrollador.entities.ProveedorEntity;
import Desarrollador.services.AdministracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping
public class AdministracionController {

    @Autowired
    private AdministracionService administracionService;
/**
    @GetMapping("/reporte")
    public String listar(Model model) {
        ArrayList<AdministracionEntity> datas = calcularPlanilla.obtenerReporte();
        model.addAttribute("administracion", datas);
        return "fileInformation";
    }
**/
    @PostMapping("/reporte") public int sueldoCategoria(@RequestParam("categoria") ProveedorEntity categoria,
                                                    @RequestParam("kls_leche") AcopioLecheEntity kls_leche){
        int pagoxleche = administracionService.sueldoCategoria(categoria, kls_leche);
        return pagoxleche;
    }

/**

    @PostMapping("/reporte") String crearReporte(@RequestParam("quincena") String quincena,
                                        @RequestParam("codigo_proveedor") String codigo_proveedor,
                                        @RequestParam("nombre_proveedor") String nombre_proveedor,
                                        @RequestParam("total_kls_leche") String total_kls_leche,
                                        @RequestParam("nro_dias_envio_leche") String nro_dias_envio_leche,
                                        @RequestParam("promedio_kls_leche") String promedio_kls_leche,
                                        @RequestParam("variacion_leche") String variacion_leche,
                                        @RequestParam("grasa") String grasa,
                                        @RequestParam("variacion_grasa") String variacion_grasa,
                                        @RequestParam("solidos_totales") String solidos_totales,
                                        @RequestParam("variacion_solidos_totales") String variacion_solidos_totales,
                                        @RequestParam("pago_leche") String pago_leche,
                                        @RequestParam("pago_grasa") String pago_grasa,
                                        @RequestParam("pago_solidos_totales") String pago_solidos_totales,
                                        @RequestParam("bonificacion_frecuencia") String bonificacion_frecuencia,
                                        @RequestParam("descuento_variacion_leche") String descuento_variacion_leche,
                                        @RequestParam("descuento_variacion_grasa") String descuento_variacion_grasa,
                                        @RequestParam("descuento_variacion_solidos") String descuento_variacion_solidos,
                                        @RequestParam("pago_total") String pago_total,
                                        @RequestParam("monto_retencion") String monto_retencion,
                                        @RequestParam("monto_final") String monto_final){
                                        administracionService.guardarAdministracion(
                                                quincena,
                                                codigo_proveedor,
                                                nombre_proveedor,
                                                total_kls_leche,
                                                nro_dias_envio_leche,
                                                promedio_kls_leche,
                                                variacion_leche,
                                                grasa,
                                                variacion_grasa,
                                                solidos_totales,
                                                variacion_solidos_totales,
                                                pago_leche,
                                                pago_grasa,
                                                pago_solidos_totales,
                                                bonificacion_frecuencia,
                                                descuento_variacion_leche,
                                                descuento_variacion_grasa,
                                                descuento_variacion_solidos,
                                                pago_total,
                                                monto_retencion,
                                                monto_final);
                                        return "redirect:/reporte";
                                        }

    */
}
