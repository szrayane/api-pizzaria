package com.apipizzaria.repistories;
import com.apipizzaria.models.IngredienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<IngredienteModel, Long> {
}
