package com.apipizzaria.repistories;
import com.apipizzaria.models.PizzaPedidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaPedidaRepository extends JpaRepository<PizzaPedidaModel, Long> {
}
