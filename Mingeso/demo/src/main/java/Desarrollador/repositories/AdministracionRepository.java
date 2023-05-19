package Desarrollador.repositories;

import Desarrollador.entities.AdministracionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministracionRepository extends JpaRepository <AdministracionEntity, Integer> {
}


