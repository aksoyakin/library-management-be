package com.aksoyakin.librarymanagementbe.dto;

import com.aksoyakin.librarymanagementbe.model.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    private Long id;
    private String name;
    private String authorName;
    private Category category;
}
