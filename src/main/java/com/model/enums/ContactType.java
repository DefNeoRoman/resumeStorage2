package com.model.enums;

public enum ContactType {
    PHONE("телефон"),
    HOMEPHONE("домашний телефон"),
    MOBILEPHONE("мобильный телефон"),
    MY_SITE("ссылка на мой сайт"),
    GITHUB_ACCOUNT("аккаунт на гитхабе"),
    STACKOVERFLOW_ACCOUNT("аккаунт на StackOverFlow"),
    LINKEDIN("Профиль Linkedin"),
    SKYPE("аккаунт на Skype"),
    EMAIL("Электронная почта"),;
    private final String title;
   ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public String toHtml0(String value) {
        return title + ": " + value;
    }

    public String toHtml(String value) {
        return (value == null) ? "" : toHtml0(value);

    }
}
