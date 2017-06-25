package com.model.enums;

public enum SectionType {
    OBJECTIVE("Позиция"),
    PERSONAL("Личные качества"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    WORK_EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private final String title;
    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public String toHtml0(String value) {
        return title + ": " + value;
    }
}
