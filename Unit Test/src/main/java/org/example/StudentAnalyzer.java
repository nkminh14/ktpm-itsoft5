package org.example;

import java.util.List;

public class StudentAnalyzer {
    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int excellentStudents = 0;
        for (Double score : scores) {
            if (score != null && score >= 0.0 && score <= 10.0) { // Check for valid scores
                if (score >= 8.0) {
                    excellentStudents++;
                }
            }
        }
        return excellentStudents;
    }
    public double calculateValidAverage(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        return scores.stream()
                .filter(score -> score != null && score >= 0.0 && score <= 10.0)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
}
