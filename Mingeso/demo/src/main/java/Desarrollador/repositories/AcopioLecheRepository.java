package Desarrollador.repositories;

import Desarrollador.entities.AcopioLecheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AcopioLecheRepository extends JpaRepository <AcopioLecheEntity, Integer>{


    @Query("select a from AcopioLecheEntity a join ProveedorEntity p on a.proveedor = p.codigo " +
            "where p.nombre = :nombre")
    AcopioLecheEntity findByName(@Param("nombre")String codigo);

    @Query("select e.proveedor from AcopioLecheEntity e where e.proveedor = :codigo")
    String findCategory(@Param("codigo") String codigo);



}
