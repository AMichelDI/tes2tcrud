package mx.com.ids.tes2tcrud.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "codigo")
    private String countryCode;

    @Column(name = "nombre")
    private String name;

    @OneToMany
    @JoinColumn(name = "airport_id")
    private List<Airport> airports;

    @OneToOne(mappedBy = "country")
    private Employee employee;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
