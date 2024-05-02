package com.apipizzaria.repistories;
import com.apipizzaria.models.PizzaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaModel, Long> {
}
