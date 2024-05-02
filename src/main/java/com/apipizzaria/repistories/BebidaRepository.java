package com.apipizzaria.repistories;
import com.apipizzaria.models.BebidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<BebidaModel, Long> {
}
