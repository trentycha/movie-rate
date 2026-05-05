package Services;

import com.example.movie_rate.models.*;
import com.example.movie_rate.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private NotationRepository notationRepository;

    @Autowired
    private StreamingRepository streamingHistoryRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Integer id) {
        return filmRepository.findById(id);
    }

    public Film createFilm(String title, String director, String mainActors, Integer duration,
                           Integer year, String comment, String anecdote, Integer userId, List<Integer> countryIds) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        Film film = new Film();
        film.setTitle(title);
        film.setDirector(director);
        film.setMainActors(mainActors);
        film.setDuration(duration);
        film.setYear(year);
        film.setComment(comment);
        film.setAnecdote(anecdote);
        film.setUser(user);
        film.setCreatedAt(LocalDate.now());
        film.setUpdatedAt(LocalDate.now());

        if (countryIds != null) {
            Set<Country> countries = new HashSet<>();
            for (Integer countryId : countryIds) {
                Country country = countryRepository.findById(countryId).orElseThrow(() -> new RuntimeException("Pays non trouvé"));
                countries.add(country);
            }
            film.setSet_at(countries);
        }

        return filmRepository.save(film);
    }

    public Film updateFilm(Integer id, String title, String director, String mainActors, Integer duration, Integer year, String comment, String anecdote, Integer userId, List<Integer> countryIds) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film non trouvé"));

        if (!film.getUser().getId().equals(userId)) {
            throw new RuntimeException("Vous n'êtes pas autorisé à modifier ce film");
        }

        if (!film.getTitle().equals(title)) {
            throw new RuntimeException("Un film avec ce titre existe déjà");
        }

        film.setTitle(title);
        film.setDirector(director);
        film.setMainActors(mainActors);
        film.setDuration(duration);
        film.setYear(year);
        film.setComment(comment);
        film.setAnecdote(anecdote);
        film.setUpdatedAt(LocalDate.now());

        if (countryIds != null) {
            Set<Country> countries = new HashSet<>();
            for (Integer countryId : countryIds) {
                Country country = countryRepository.findById(countryId).orElseThrow(() -> new RuntimeException("Pays non trouvé"));
                countries.add(country);
            }
            film.setSet_at(countries);
        }

        return filmRepository.save(film);
    }

    public void deleteFilm(Integer id, Integer userId) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film non trouvé"));

        if (!film.getUser().getId().equals(userId)) {
            throw new RuntimeException("Vous n'êtes pas autorisé à supprimer ce film");
        }

        filmRepository.deleteById(id);
    }

    public List<Film> getFilmsByCountryId(Integer countryId) {
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new RuntimeException("Pays non trouvé"));

        return filmRepository.findBySet_at(country);
    }

    public List<Film> getFilmsByNotationId(Integer notationId) {
        Notation notation = notationRepository.findById(notationId)
                .orElseThrow(() -> new RuntimeException("Notation non trouvée"));

        return filmRepository.findByNotation(notation);
    }

    public List<Film> getFilmsByPlatformId(Integer platformId) {
        Streaming_history platform = streamingHistoryRepository.findById(platformId)
                .orElseThrow(() -> new RuntimeException("Plateforme non trouvée"));

        return filmRepository.findByPlatforms(platform);
    }
}