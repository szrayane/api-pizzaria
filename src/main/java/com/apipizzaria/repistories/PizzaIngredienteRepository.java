package com.apipizzaria.repistories;
import com.apipizzaria.models.PizzaIngredienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaIngredienteRepository extends JpaRepository<PizzaIngredienteModel, Long> {
}
