package mx.com.ids.tes2tcrud.repository;

import mx.com.ids.tes2tcrud.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
