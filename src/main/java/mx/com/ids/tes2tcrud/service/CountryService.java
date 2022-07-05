package mx.com.ids.tes2tcrud.service;



import mx.com.ids.tes2tcrud.model.Country;

import java.util.List;

public interface CountryService {
    Country createCountry(Country country);
    Country updateCountry(Country country);
    List<Country> getAllCountry();
    Country getCountryById(long countryId);
    void deleteCountry(long id);
}
