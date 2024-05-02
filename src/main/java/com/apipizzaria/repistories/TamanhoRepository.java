package com.apipizzaria.repistories;
import com.apipizzaria.models.TamanhoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TamanhoRepository extends JpaRepository<TamanhoModel, Long> {
    TamanhoModel findByNome(String nome);
}


