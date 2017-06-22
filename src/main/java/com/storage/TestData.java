package com.storage;

import com.model.*;
import com.model.enums.ContactType;
import com.model.enums.SectionType;
import com.util.DateUtil;

import java.time.Month;
import java.util.UUID;

/**
 * Created by Пользователь on 22.06.2017.
 */
public class TestData {
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String FULL_NAME_1 = "First Man";

    public static Resume RESUME_1;

    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String FULL_NAME_2 = "Second Man";
    public static Resume RESUME_2;

    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String FULL_NAME_3 = "Third Man";
    public static Resume RESUME_3;

    public static final String UUID_X = UUID.randomUUID().toString();
    public static final String FULL_NAME_X = "X Man";
    public static Resume RESUME_X;

    static {

        RESUME_1 = new Resume(UUID_1, FULL_NAME_1);
        RESUME_2 = new Resume(UUID_2, FULL_NAME_2);
        RESUME_3 = new Resume(UUID_3, FULL_NAME_3);
        RESUME_X = new Resume(UUID_X, FULL_NAME_X);

        RESUME_1.addContact(ContactType.EMAIL, "java@u-rise.com");
        RESUME_1.addContact(ContactType.SKYPE, "grigory.kislin");
        RESUME_2.addContact(ContactType.EMAIL, "email2@mail.ru");
        RESUME_2.addContact(ContactType.SKYPE, "skype_us2");
        RESUME_3.addContact(ContactType.EMAIL, "email3@mail.ru");
        RESUME_3.addContact(ContactType.SKYPE, "us_skype3");

        RESUME_1.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        RESUME_1.addSection(SectionType.OBJECTIVE, new TextSection("OBJECTIVE TEXT"));
        RESUME_2.addSection(SectionType.PERSONAL, new TextSection("Personal data 2"));
        RESUME_3.addSection(SectionType.PERSONAL, new TextSection("Personal data 3"));
        RESUME_1.addSection(SectionType.QUALIFICATIONS,
                new ListSection(
                        ("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2"),
                        ("Version control: Subversion, Git, Mercury, ClearCase, Perforce"),
                        ("DB:PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB)")
                )
        );

        RESUME_1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://URL1.com",
                                new Organization.Position(DateUtil.of(1993, Month.AUGUST), DateUtil.of(1996, Month.JULY), "Аспирантура", "Прогрммист C/C++"),
                                new Organization.Position(DateUtil.of(1987, Month.APRIL), DateUtil.of(1993, Month.DECEMBER), "Инженер", "Fortran, C")
                        )
                )
        );


        RESUME_3.addSection(SectionType.WORK_EXPERIENCE,
                new OrganizationSection(
                        new Organization("Place work number 1", "http://URL3.com",
                                new Organization.Position(DateUtil.of(2015, Month.DECEMBER), "Аспирантура", "Прогрммист C/C++")
                        )
                )
        );

    }
}
