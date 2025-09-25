package br.com.movieflix.controller;

import br.com.movieflix.controller.request.MovieRequest;
import br.com.movieflix.controller.request.StreamingRequest;
import br.com.movieflix.controller.response.MovieResponse;
import br.com.movieflix.controller.response.StreamingResponse;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.mapper.MovieMapper;
import br.com.movieflix.mapper.StreamingMapper;
import br.com.movieflix.service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingServiceService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAllCategories() {
        List<StreamingResponse> categories = streamingServiceService.findAll()
                .stream()
//                .map(category -> CategoryMapper.toCategoryResponse(category))
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveCategory(@Valid @RequestBody StreamingRequest request) {

        Streaming newCategory = StreamingMapper.toStreaming(request);
        Streaming savedCategory = streamingServiceService.save(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getByCategoryId(@PathVariable Long id) {
        return streamingServiceService.findById(id)
                .map(category -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamingResponse> finById(@PathVariable Long id, @Valid @RequestBody StreamingRequest request) {
        return streamingServiceService.update(id, StreamingMapper.toStreaming(request))
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByCategoryId(@PathVariable Long id) {
        streamingServiceService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
