package Desarrollador.services;

import Desarrollador.entities.GrasaSolidoEntity;
import Desarrollador.repositories.GrasaSolidoRepository;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
@Service
public class GrasaSolidoService {

    public ArrayList<GrasaSolidoEntity> obtenerGrasaSolido;
    @Autowired
    private GrasaSolidoRepository grasaSolidoRepository;

    private final Logger logg = LoggerFactory.getLogger(GrasaSolidoService.class);

    public ArrayList<GrasaSolidoEntity> obtenerGrasaSolido(){
        return (ArrayList<GrasaSolidoEntity>) grasaSolidoRepository.findAll();
    }

    @Generated
    public String guardarGrasaSolido(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if(!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path  = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo de grasas y solidos guardado");
                }
                catch (IOException e){
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito!";
        }
        else{
            return "No se pudo guardar el archivo";
        }
    }

    @Generated
    public void leerCsvGrasaSolido(String direccion){
        String texto = "";
        BufferedReader bf = null;
        grasaSolidoRepository.deleteAll();
        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else{
                    guardarGrasaSolidoDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }finally{
            if(bf != null){
                try{
                    bf.close();
                }catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }
    }

    public void guardarGrasaSolido(GrasaSolidoEntity data){grasaSolidoRepository.save(data);
    }

    public void guardarGrasaSolidoDB(String proveedor, String grasa, String solidoTotal){
        GrasaSolidoEntity newDataValores = new GrasaSolidoEntity();
        newDataValores.setProveedor(proveedor);
        newDataValores.setGrasa(grasa);
        newDataValores.setSolidoTotal(solidoTotal);
        guardarGrasaSolido(newDataValores);
    }
    public void eliminarGrasaSolido(ArrayList<GrasaSolidoEntity> datas){
        grasaSolidoRepository.deleteAll(datas);
    }
}
