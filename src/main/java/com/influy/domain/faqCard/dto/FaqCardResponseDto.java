package com.influy.domain.faqCard.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class FaqCardResponseDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionCardDto {
        @Schema(description = "질문 카드 id", example = "1")
        private Long id;

        @Schema(description = "질문 내용", example = "구성이 어떻게 되나요?")
        private String questionContent;

        @Schema(description = "고정 여부", example = "true")
        private boolean pinned;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PageDto {
        @Schema(description = "질문 카드 리스트")
        private List<FaqCardResponseDto.QuestionCardDto> questionCardList;

        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResultDto {
        @Schema(description = "FAQ 카드 id", example = "1")
        private Long id;

        @Schema(description = "FAQ 질문 내용", example = "모야요??")
        private String questionContent;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnswerCardDto {
        @Schema(description = "FAQ 카드 id", example = "1")
        private Long id;

        @Schema(description = "고정 여부", example = "true")
        private boolean pinned;

        @Schema(description = "FAQ 질문 내용", example = "모야요??")
        private String questionContent;

        @Schema(description = "FAQ 답변 내용", example = "이건 이거입니당")
        private String answerContent;

        @Schema(description = "배경 이미지 링크", example = "xxxxx.png")
        private String backgroundImgLink;

        @Schema(description = "FAQ 카테고리", example = "색상")
        private String faqCategory;

        @Schema(description = "생성일", example = "2021-01-01T00:00")
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateResultDto {
        @Schema(description = "FAQ 카드 id", example = "1")
        private Long id;

        @Schema(description = "FAQ 질문 내용", example = "모야요")
        private String questionContent;

        @Schema(description = "FAQ 답변 내용", example = "이건 이거입니당")
        private String answerContent;

        @Schema(description = "배경 이미지 링크", example = "xxxxx.png")
        private String backgroundImgLink;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeleteResultDto {
        @Schema(description = "FAQ 카드 id", example = "1")
        private Long id;
    }
}
