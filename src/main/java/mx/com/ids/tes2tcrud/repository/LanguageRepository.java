package mx.com.ids.tes2tcrud.repository;

import mx.com.ids.tes2tcrud.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
