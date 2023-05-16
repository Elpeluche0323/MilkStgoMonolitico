package Desarrollador.repositories;

import Desarrollador.entities.GrasaSolidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GrasaSolidoRepository extends JpaRepository <GrasaSolidoEntity, Integer>{
}
