package Desarrollador.repositories;

import Desarrollador.entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, String>{

    @Query(value = "select e from ProveedorEntity e where e.nombre = :nombre", nativeQuery = true)
    ProveedorEntity findByNameCustomQuery(@Param("nombre") String nombre);

    @Query(value = "select e.categoria from ProveedorEntity e where e.codigo = :codigo", nativeQuery = true)
    String findCategory(@Param("codigo") String codigo);

    @Query(value = "select e from ProveedorEntity e where e.codigo = :codigo", nativeQuery = true)
    ProveedorEntity findByCodigo(@Param("codigo")String codigo);
}
