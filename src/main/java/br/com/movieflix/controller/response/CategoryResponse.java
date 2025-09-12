package br.com.movieflix.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public record CategoryResponse(long id, String name) {
}
