package Services;

import com.example.movie_rate.models.Film;
import com.example.movie_rate.models.User;
import com.example.movie_rate.repositories.FilmRepository;
import com.example.movie_rate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Integer id) {
        return filmRepository.findById(id);
    }

    public Film createFilm(String title, String director, String mainActors, Integer duration, Integer year, String comment, String anecdote, Integer userId) {
        if (filmRepository.existsByTitle(title)) {
            throw new RuntimeException("Un film avec ce titre existe déjà");
        }

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

        return filmRepository.save(film);
    }

    public Film updateFilm(Integer id, String title, String director, String mainActors, Integer duration, Integer year, String comment, String anecdote, Integer userId) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film non trouvé"));

        if (!film.getUser().getId().equals(userId)) {
            throw new RuntimeException("Vous n'êtes pas autorisé à modifier ce film");
        }

        if (!film.getTitle().equals(title) && filmRepository.existsByTitle(title)) {
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
}