package com.apipizzaria.repistories;
import com.apipizzaria.models.FornadaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornadaRepository extends JpaRepository<FornadaModel, Long> {
}
