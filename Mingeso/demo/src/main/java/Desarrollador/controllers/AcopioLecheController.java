package Desarrollador.controllers;

import Desarrollador.entities.AcopioLecheEntity;
import Desarrollador.services.AcopioLecheService;
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
public class AcopioLecheController {

    @Autowired
    private AcopioLecheService subirData;

    @GetMapping("/fileUploadAcopioLeche")
    public String main() {
        return "/fileUploadAcopioLeche";
    }

    @PostMapping("/fileUploadAcopioLeche")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        subirData.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        subirData.leerCsv("Acopio.csv");
        return "redirect:/fileUploadAcopioLeche";
    }

    @GetMapping("/fileInformation")
    public String listar(Model model) {
        ArrayList<AcopioLecheEntity> data_acopio_leche = subirData.obtenerData();
        model.addAttribute("data_acopio_leche", data_acopio_leche);
        return "/fileInformation";
    }

    @GetMapping("/planillaPagos")
    public String listaPagos(Model model, String nombre){
        AcopioLecheEntity data_acopio_leche = subirData.findByName(nombre);
        model.addAttribute("data_acopio_leche", data_acopio_leche);
        return "/planillaPagos";
    }
}
