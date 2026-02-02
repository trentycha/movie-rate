package Services;

import com.example.movie_rate.models.Notation;
import com.example.movie_rate.repositories.NotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotationService {

    @Autowired
    private NotationRepository notationRepository;

    public List<Notation> getAllNotations() {
        return notationRepository.findAll();
    }
}