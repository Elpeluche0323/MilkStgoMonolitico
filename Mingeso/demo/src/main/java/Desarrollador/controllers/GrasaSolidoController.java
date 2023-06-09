package Desarrollador.controllers;

import Desarrollador.entities.GrasaSolidoEntity;
import Desarrollador.services.GrasaSolidoService;
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
public class GrasaSolidoController {

    @Autowired
    private GrasaSolidoService cargarData;

    @GetMapping("/fileUploadGrasaSolido")
    public String main() {
        return "/fileUploadGrasaSolido";
    }

    @PostMapping("/fileUploadGrasaSolido")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        cargarData.guardarGrasaSolido(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        cargarData.leerCsvGrasaSolido("valoresGrasaYSolidos.csv");
        return "redirect:/fileUploadGrasaSolido";
    }

    @GetMapping("/fileInformationGS")
    public String listarGrasaSolido(Model model) {
        ArrayList<GrasaSolidoEntity> data_grasaysolidos = cargarData.obtenerGrasaSolido();
        model.addAttribute("data_grasaysolidos", data_grasaysolidos);
        return "/fileInformationGS";
    }
}
