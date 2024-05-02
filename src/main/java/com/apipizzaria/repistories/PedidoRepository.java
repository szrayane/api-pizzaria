package com.apipizzaria.repistories;
import com.apipizzaria.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {
    @Override
    Optional<PedidoModel> findById(UUID id);

    void deleteById(UUID id);
}
