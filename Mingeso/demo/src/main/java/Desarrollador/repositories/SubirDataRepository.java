package Desarrollador.repositories;

import Desarrollador.entities.SubirDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubirDataRepository extends JpaRepository <SubirDataEntity, Integer>{
}
