package com.influy.domain.faqCategory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class FaqCategoryRequestDto {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddDto {
        @Schema(description = "faq 카테고리", example = "진행일정")
        private String category;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeleteDto {
        @Schema(description = "faq 카테고리 id", example = "1")
        private Long id;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateDto {
        @Schema(description = "faq 카테고리 id", example = "1")
        private Long id;

        @Schema(description = "faq 카테고리", example = "진행일정")
        private String category;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateOrderDto {
        @Schema(description = "faq 카테고리 id", example = "[5, 3, 2, 0, 1, 4]")
        private List<Long> ids;
    }
}
