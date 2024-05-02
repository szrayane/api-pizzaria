package com.apipizzaria.repistories;
import com.apipizzaria.models.BebidaPedidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaPedidaRepository extends JpaRepository<BebidaPedidaModel, Long> {
}
