package TestData;

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
    //public static final String UUID_1 = "111111y";
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String FULL_NAME_1 = "First Man";

    public static Resume RESUME_1;

    //public static final String UUID_2 = "222222y";
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String FULL_NAME_2 = "Second Man";
    public static Resume RESUME_2;

    //public static final String UUID_3 = "33333y";
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String FULL_NAME_3 = "Third Man";
    public static Resume RESUME_3;

    public static final String UUID_X = "444444y";
    //public static final String UUID_X =UUID.randomUUID().toString();
    public static final String FULL_NAME_X = "X Man";

    public static Resume RESUME_X;
    public static Resume FULL_RESUME;
    public static final String FULL_NAME_FULL_RESUME = "Роман Гапонов";
    public static final String FULL_RESUME_UUID = UUID.randomUUID().toString();

    static {
//        setup Full resume
        FULL_RESUME = new Resume(FULL_RESUME_UUID, FULL_NAME_FULL_RESUME);
        FULL_RESUME.setContact(ContactType.EMAIL, "d89056411060@yandex.ru");
        FULL_RESUME.setContact(ContactType.SKYPE, "d89056411060@yandex.ru");
        FULL_RESUME.setContact(ContactType.GITHUB_ACCOUNT, "https://github.com/DefNeoRoman");
        FULL_RESUME.setContact(ContactType.MOBILEPHONE, "89056411060");
        FULL_RESUME.setContact(ContactType.STACKOVERFLOW_ACCOUNT, "https://stackoverflow.com/users/6771398/defneo");
        FULL_RESUME.setSection(SectionType.PERSONAL, new TextSection("Инициативный, целеусремленный"));
        FULL_RESUME.setSection(SectionType.ACHIEVEMENT, new ListSection("Приложение ResumeStorage доступно по ссылке"));
        FULL_RESUME.setSection(SectionType.OBJECTIVE, new TextSection("Активная жизненная позиция"));
        FULL_RESUME.setSection(SectionType.QUALIFICATIONS,
                new ListSection(
                        ("JBoss, Tomcat, Maven, Spring, Hibernate, Java Core"),
                        ("Version control: Git"),
                        ("DataBases:PostgreSQL, MySQL,HSQLDB)")
                )
        );
        FULL_RESUME.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("МГТУ им. Баумана", "http://www.bmstu.ru/",
                              new Organization.Position(DateUtil.of(2010, Month.SEPTEMBER), DateUtil.of(2015, Month.JULY), "Инженер", "Газотурбиннные двигатели")
                        )
                )
        );
        FULL_RESUME.setSection(SectionType.WORK_EXPERIENCE,
                new OrganizationSection(
                        new Organization("JavaRush", "https://javarush.ru/",
                                new Organization.Position(DateUtil.of(2016, Month.MAY),DateUtil.of(2016, Month.DECEMBER), "Обучение", "Программист Java - стажер"),
                                new Organization.Position(DateUtil.of(2017, Month.JANUARY), "Интернатура", "Программист Java")
                        ),
                        new Organization("U-Rise", "http://u-rise.com/",
                                new Organization.Position(DateUtil.of(2017, Month.JANUARY), "Интернатура", "Программист Java")
                        )
                )
        );

        RESUME_1 = new Resume(UUID_1, FULL_NAME_1);
        RESUME_2 = new Resume(UUID_2, FULL_NAME_2);
        RESUME_3 = new Resume(UUID_3, FULL_NAME_3);
        RESUME_X = new Resume(UUID_X, FULL_NAME_X);

        RESUME_1.setContact(ContactType.EMAIL, "java@u-rise.com");
        RESUME_1.setContact(ContactType.SKYPE, "grigory.kislin");
        RESUME_2.setContact(ContactType.EMAIL, "email2@mail.ru");
        RESUME_2.setContact(ContactType.SKYPE, "skype_us2");
        RESUME_3.setContact(ContactType.EMAIL, "email3@mail.ru");
        RESUME_3.setContact(ContactType.SKYPE, "us_skype3");
        RESUME_1.setSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        RESUME_1.setSection(SectionType.OBJECTIVE, new TextSection("OBJECTIVE TEXT"));
        RESUME_2.setSection(SectionType.PERSONAL, new TextSection("Personal data 2"));
        RESUME_3.setSection(SectionType.PERSONAL, new TextSection("Personal data 3"));
        RESUME_1.setSection(SectionType.QUALIFICATIONS,
                new ListSection(
                        ("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2"),
                        ("Version control: Subversion, Git, Mercury, ClearCase, Perforce"),
                        ("DB:PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB)")
                )
        );
        RESUME_1.setSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://URL1.com",
                                new Organization.Position(DateUtil.of(1993, Month.AUGUST), DateUtil.of(1996, Month.JULY), "Аспирантура", "Прогрммист C/C++"),
                                new Organization.Position(DateUtil.of(1987, Month.APRIL), DateUtil.of(1993, Month.DECEMBER), "Инженер", "Fortran, C")
                        )
                )
        );
        RESUME_3.setSection(SectionType.WORK_EXPERIENCE,
                new OrganizationSection(
                        new Organization("Place work number 1", "http://URL3.com",
                                new Organization.Position(DateUtil.of(2015, Month.DECEMBER), "Аспирантура", "Прогрммист C/C++")
                        )
                )
        );
    }
}
