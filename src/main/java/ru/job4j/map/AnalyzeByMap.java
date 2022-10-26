package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        int counter = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
                counter++;
            }
        }
        return rsl / counter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            double averageScore = 0;
            int counter = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                counter++;
                averageScore = sum / counter;
            }
            rsl.add(new Label(pupil.name(), averageScore));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int sum = temp.getOrDefault(subject.name(), 0);
                sum += subject.score();
                temp.put(subject.name(), sum);
            }
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            rsl.add(new Label(pupil.name(), sum));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int sum = temp.getOrDefault(subject.name(), 0);
                sum += subject.score();
                temp.put(subject.name(), sum);
            }
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue()));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}
