package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // Tests for countExcellentStudents

    // Normal Cases
    @Test
    void countExcellentStudents_mixedValidAndInvalidScores_returnsCorrectCount() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 6.0, 10.0, 7.9); // 9.0, 8.5, 10.0 are excellent
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    @Test
    void countExcellentStudents_onlyExcellentValidScores_returnsCorrectCount() {
        List<Double> scores = Arrays.asList(8.0, 9.5, 10.0);
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    @Test
    void countExcellentStudents_noExcellentValidScores_returnsZero() {
        List<Double> scores = Arrays.asList(5.0, 6.5, 7.9, 0.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    // Edge Cases
    @Test
    void countExcellentStudents_emptyList_returnsZero() {
        List<Double> scores = Collections.emptyList();
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    void countExcellentStudents_listWithOnlyZeros_returnsZero() {
        List<Double> scores = Arrays.asList(0.0, 0.0, 0.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    void countExcellentStudents_listWithOnlyTens_returnsCorrectCount() {
        List<Double> scores = Arrays.asList(10.0, 10.0, 10.0);
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    @Test
    void countExcellentStudents_singleExcellentScore_returnsOne() {
        List<Double> scores = Arrays.asList(8.0);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }

    @Test
    void countExcellentStudents_singleNonExcellentScore_returnsZero() {
        List<Double> scores = Arrays.asList(7.9);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    // Exception/Invalid Data Cases
    @Test
    void countExcellentStudents_withScoresLessThanZero_ignoresInvalidScores() {
        List<Double> scores = Arrays.asList(8.0, -1.0, 9.5, 7.0);
        assertEquals(2, analyzer.countExcellentStudents(scores)); // 8.0 and 9.5 are excellent
    }

    @Test
    void countExcellentStudents_withScoresGreaterThanTen_ignoresInvalidScores() {
        List<Double> scores = Arrays.asList(8.0, 11.0, 9.5, 7.0);
        assertEquals(2, analyzer.countExcellentStudents(scores)); // 8.0 and 9.5 are excellent
    }

    @Test
    void countExcellentStudents_onlyInvalidScores_returnsZero() {
        List<Double> scores = Arrays.asList(-1.0, 10.1, -5.0, 15.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    void countExcellentStudents_withNullScores_ignoresNullScores() {
        List<Double> scores = Arrays.asList(8.0, null, 9.5, 7.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    void countExcellentStudents_nullList_returnsZero() {
        List<Double> scores = null;
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    // Tests for calculateValidAverage

    // Normal Cases
    @Test
    void calculateValidAverage_mixedValidAndInvalidScores_returnsCorrectAverage() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0, 6.5);
        // Valid scores: 9.0, 8.5, 7.0, 6.5 -> Sum = 31.0, Count = 4, Average = 7.75
        assertEquals(7.75, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void calculateValidAverage_onlyValidScores_returnsCorrectAverage() {
        List<Double> scores = Arrays.asList(7.0, 8.0, 9.0);
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    // Edge Cases
    @Test
    void calculateValidAverage_emptyList_returnsZero() {
        List<Double> scores = Collections.emptyList();
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void calculateValidAverage_listWithOnlyZeros_returnsZero() {
        List<Double> scores = Arrays.asList(0.0, 0.0, 0.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void calculateValidAverage_listWithOnlyTens_returnsTen() {
        List<Double> scores = Arrays.asList(10.0, 10.0, 10.0);
        assertEquals(10.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void calculateValidAverage_singleValidScore_returnsScore() {
        List<Double> scores = Arrays.asList(7.5);
        assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.001);
    }

    // Exception/Invalid Data Cases
    @Test
    void calculateValidAverage_withScoresLessThanZero_ignoresInvalidScores() {
        List<Double> scores = Arrays.asList(7.0, -1.0, 8.0, 9.0);
        // Valid scores: 7.0, 8.0, 9.0 -> Sum = 24.0, Count = 3, Average = 8.0
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void calculateValidAverage_withScoresGreaterThanTen_ignoresInvalidScores() {
        List<Double> scores = Arrays.asList(7.0, 11.0, 8.0, 9.0);
        // Valid scores: 7.0, 8.0, 9.0 -> Sum = 24.0, Count = 3, Average = 8.0
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void calculateValidAverage_onlyInvalidScores_returnsZero() {
        List<Double> scores = Arrays.asList(-1.0, 11.0, null, 15.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void calculateValidAverage_withNullScores_ignoresNullScores() {
        List<Double> scores = Arrays.asList(7.0, null, 8.0, 9.0);
        // Valid scores: 7.0, 8.0, 9.0 -> Sum = 24.0, Count = 3, Average = 8.0
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void calculateValidAverage_nullList_returnsZero() {
        List<Double> scores = null;
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void calculateValidAverage_specificDecimalAverage() {
        List<Double> scores = Arrays.asList(8.2, 7.3, 9.1);
        // Sum = 24.6, Count = 3, Average = 8.2
        assertEquals(8.2, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    void countExcellentStudents_withMixedComprehensiveInvalidScores_returnsCorrectCount() {
        List<Double> scores = Arrays.asList(9.0, -2.0, 8.5, 11.0, 7.0, null, 10.0);
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    @Test
    void calculateValidAverage_withMixedComprehensiveInvalidScores_returnsCorrectAverage() {
        List<Double> scores = Arrays.asList(9.0, -2.0, 8.5, 11.0, 7.0, null, 10.0);
        // Valid scores: 9.0, 8.5, 7.0, 10.0 -> Sum = 34.5, Count = 4, Average = 8.625
        assertEquals(8.625, analyzer.calculateValidAverage(scores), 0.001);
    }
}
