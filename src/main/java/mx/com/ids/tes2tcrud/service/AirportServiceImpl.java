package mx.com.ids.tes2tcrud.service;


import mx.com.ids.tes2tcrud.exception.ResourceNotFoundException;
import mx.com.ids.tes2tcrud.model.Airport;
import mx.com.ids.tes2tcrud.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        Optional<Airport> airportDb = this.airportRepository.findById(airport.getAirportId());

        if (airportDb.isPresent()){
            Airport airportUpdate = airportDb.get();
            airportUpdate.setAirportId(airport.getAirportId());
            airportUpdate.setName(airport.getName());
            airportRepository.save(airportUpdate);
            return airportUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + airport.getAirportId());
        }
    }

    @Override
    public List<Airport> getAllAirports() {
        return this.airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(long airportId) {
        Optional<Airport> airportDb = this.airportRepository.findById(airportId);

        if (airportDb.isPresent()) {
            return airportDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + airportId);
        }
    }

    @Override
    public void deleteAirport(long airportId) {
        Optional<Airport> airportDb = this.airportRepository.findById(airportId);

        if (airportDb.isPresent()) {
            this.airportRepository.delete(airportDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + airportId);
        }
    }
}
