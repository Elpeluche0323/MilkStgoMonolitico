
package Desarrollador.controllers;

import Desarrollador.entities.AcopioLecheEntity;
import Desarrollador.entities.AdministracionEntity;
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
    private AdministracionService calcularPlanilla;
/**
    @GetMapping("/reporte")
    public String listar(Model model) {
        ArrayList<AdministracionEntity> datas = calcularPlanilla.obtenerReporte();
        model.addAttribute("administracion", datas);
        return "fileInformation";
    }
**/
}
