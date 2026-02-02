package Services;

import com.example.movie_rate.models.Streaming_history;
import com.example.movie_rate.repositories.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamingService {

    @Autowired
    private StreamingRepository streamingHistoryRepository;

    public List<Streaming_history> getAllPlatforms() {
        return streamingHistoryRepository.findAll();
    }
}