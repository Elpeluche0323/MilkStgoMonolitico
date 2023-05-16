package Desarrollador.repositories;

import Desarrollador.entities.AcopioLecheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcopioLecheRepository extends JpaRepository <AcopioLecheEntity, Integer>{
}
