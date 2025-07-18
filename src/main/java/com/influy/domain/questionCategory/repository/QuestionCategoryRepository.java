package com.influy.domain.questionCategory.repository;

import com.influy.domain.item.entity.Item;
import com.influy.domain.questionCategory.entity.QuestionCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory, Long> {
    boolean existsByItemIdAndCategory(Long itemId, String category);
    boolean existsByCategory(String category);
    @Query("""
    SELECT qc
    FROM QuestionCategory qc
    LEFT JOIN QuestionTag qt ON qt.questionCategory = qc
    LEFT JOIN Question q ON q.questionTag = qt
    WHERE qc.item.id = :itemId
    GROUP BY qc
    ORDER BY COUNT(q.id) DESC
    """)
    List<QuestionCategory> findQuestionCategories(@Param("itemId") Long itemId);

    @Query("""
    SELECT COUNT(q)
    FROM QuestionTag qt
    LEFT JOIN Question q ON q.questionTag = qt
    WHERE qt.questionCategory.id = :questionCategoryId
    """)
    int countQuestionsByCategoryId(@Param("questionCategoryId") Long questionCategoryId);

    List<QuestionCategory> findAllByItem(Item item);
}
