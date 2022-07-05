package mx.com.ids.tes2tcrud.service;

import mx.com.ids.tes2tcrud.model.Airport;
import java.util.List;

public interface AirportService {

    Airport createAirport(Airport airport);

    Airport updateAirport(Airport airport);

    List<Airport> getAllAirports();

    Airport getAirportById(long airportId);

    void deleteAirport(long id);

}
