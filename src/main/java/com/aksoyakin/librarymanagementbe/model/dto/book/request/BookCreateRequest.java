package com.aksoyakin.librarymanagementbe.model.dto.book.request;

import com.aksoyakin.librarymanagementbe.model.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private Long authorId;

    private Category category;
}
