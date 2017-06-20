package com.model.enums;

public enum SectionType {
    PERSONAL("Персональные данные"),
    OBJECTIVE("О себе"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    WORK_EXPERIENCE("Опыт работы"),
    LIFE_POSITION("Жизненная позиция"),
    HOBBY("Хобби"),
    EDUCATION("Образование"),
    ;
    private final String title;
    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
