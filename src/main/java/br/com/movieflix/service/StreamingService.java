package br.com.movieflix.service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    public List<Streaming> findAll() {
        return repository.findAll();
    }

    public Streaming save(Streaming streaming) {
        return repository.save(streaming);
    }

    public Optional<Streaming> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Streaming> update(Long streamingId, Streaming updateStreaming) {
        Optional<Streaming> optStreaming = repository.findById(streamingId);
        if (optStreaming.isPresent()) {

            Streaming stream = optStreaming.get();
            //stream.setId(updateStreaming.getId());
            stream.setName(updateStreaming.getName());


            repository.save(stream);

            return Optional.of(stream);
        }
        return Optional.empty();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
