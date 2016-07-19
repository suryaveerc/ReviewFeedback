package com.conneckto.reviewfeedback;

import java.util.HashMap;

public class ApplicationContextProvider {

    private static HashMap<Integer, String> subjectTeacherMap = new HashMap<>();

    static {
        subjectTeacherMap.put(1, "Ramesh");
        subjectTeacherMap.put(2, "Suresh");
    }

    public static HashMap<Integer, String> getSubjectTeacherMap() {
        return subjectTeacherMap;
    }

    public static void setSubjectTeacherMap(HashMap<Integer, String> subjectTeacherMap) {
        ApplicationContextProvider.subjectTeacherMap = subjectTeacherMap;
    }
}

