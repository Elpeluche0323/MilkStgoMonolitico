package Desarrollador.services;


import Desarrollador.entities.AcopioLecheEntity;
import Desarrollador.entities.AdministracionEntity;
import Desarrollador.repositories.AcopioLecheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdministracionService {

    /**
    @Autowired
    private AdministracionEntity administracionRepository;
    public ArrayList<AdministracionEntity> obtenerReporte(){
        return (ArrayList<AdministracionEntity>) administracionRepository.findAll();
    }
**/

    public int sueldoCategoria(String categoria,Integer kls_leche){
        switch(categoria){
            case "A":
                return (700*kls_leche);
            case "B":
                return (550*kls_leche);
            case "C":
                return (450*kls_leche);
            case "D":
                return (250*kls_leche);
            default:
                return 0;
        }
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
