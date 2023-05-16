package Desarrollador.controllers;

import Desarrollador.entities.CargarDataEntity;
import Desarrollador.services.CargarDataService;
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
public class CargarDataController {

    @Autowired
    private CargarDataService cargarData;

    @GetMapping("/fileUploadValores")
    public String main() {
        return "fileUploadValores";
    }

    @PostMapping("/fileUploadValores")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        cargarData.guardarValores(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        cargarData.leerCsvValores("valoresGrasaYSolidos.csv");
        return "redirect:/fileUploadValores";
    }

    @GetMapping("/fileUploadValores")
    public String listar(Model model) {
        ArrayList<CargarDataEntity> dataGrasasYSolidos = cargarData.obtenerDataValores;
        model.addAttribute("dataGrasasYSolidos", dataGrasasYSolidos);
        return "fileUploadValores";
    }
}
