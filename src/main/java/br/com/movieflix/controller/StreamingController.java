package br.com.movieflix.controller;

import br.com.movieflix.controller.request.StreamingRequest;
import br.com.movieflix.controller.response.StreamingResponse;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.mapper.StreamingMapper;
import br.com.movieflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService categoryService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAllCategories() {
        List<StreamingResponse> categories = categoryService.findAll()
                .stream()
//                .map(category -> CategoryMapper.toCategoryResponse(category))
                .map(StreamingMapper::toCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveCategory(@RequestBody StreamingRequest request) {
        Streaming newCategory = StreamingMapper.toCategory(request);
        Streaming savedCategory = categoryService.save(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toCategoryResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getByCategoryId(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(StreamingMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByCategoryId(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
