package mx.com.ids.tes2tcrud.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "codigo")
    private String language_code;

    @Column(name = "nombre")
    private String name;

    @ManyToMany(mappedBy = "spokenLanguages")
    private  List<Employee> speaks;

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getSpeaks() {
        return speaks;
    }

    public void setSpeaks(List<Employee> speaks) {
        this.speaks = speaks;
    }
}
