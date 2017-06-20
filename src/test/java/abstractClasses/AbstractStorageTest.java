package abstractClasses;

import com.exception.NotExistStorageException;
import com.exception.StorageException;
import com.model.*;
import com.model.enums.ContactType;
import com.model.enums.SectionType;
import com.storage.interfaces.Storage;
import com.util.DateUtil;
import config.Config;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public abstract class AbstractStorageTest {
    protected final Storage storage;
    protected static final File STORAGE_DIR = Config.getInstance().getStorageDir();
    private static final int CAPACITY = 10000;
    protected static final String UUID_1 = "uuid1";
    protected static final String FULL_NAME_1 = "First Man";
    protected Resume RESUME_1;

    protected static final String UUID_2 = "uuid2";
    protected static final String FULL_NAME_2 = "Second Man";
    protected Resume RESUME_2;

    protected static final String UUID_3 = "uuid3";
    protected static final String FULL_NAME_3 = "Third Man";
    protected Resume RESUME_3;

    protected static final String UUID_4 = "uuid4";
    protected static final String FULL_NAME_X = "X Man";
    protected Resume RESUME_4;


    public AbstractStorageTest(Storage storage) {
        requireNonNull(storage, "Storage must not be null");
        this.storage = storage;
    }
    @Before
    public void setUp() throws Exception {
        storage.clear();

        RESUME_1 = new Resume(UUID_1.trim(), FULL_NAME_1);
        RESUME_2 = new Resume(UUID_2.trim(), FULL_NAME_2);
        RESUME_3 = new Resume(UUID_3.trim(), FULL_NAME_3);
        RESUME_4 = new Resume(UUID_4.trim(), FULL_NAME_X);

        RESUME_1.addContact(ContactType.EMAIL, "java@u-rise.com");
        RESUME_1.addContact(ContactType.SKYPE, "grigory.kislin");
        RESUME_1.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        RESUME_1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://URL1.com",
                                new Organization.Position(DateUtil.of(1993, Month.AUGUST), DateUtil.of(1996, Month.JULY), "Аспирантура", "Прогрммист C/C++"),
                                new Organization.Position(DateUtil.of(1987, Month.APRIL), DateUtil.of(1993, Month.DECEMBER), "Инженер", "Fortran, C")
                        )
                )
        );

        RESUME_1.addSection(SectionType.QUALIFICATIONS,
                new ListSection(
                        ("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2"),
                        ("Version control: Subversion, Git, Mercury, ClearCase, Perforce"),
                        ("DB:PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB)")
                )
        );

        RESUME_2.addContact(ContactType.EMAIL, "email2@mail.ru");
        RESUME_2.addContact(ContactType.SKYPE, "skype_us2");
        RESUME_2.addSection(SectionType.PERSONAL, new TextSection("Personal data 2"));

        RESUME_3.addContact(ContactType.EMAIL, "email3@mail.ru");
        RESUME_3.addContact(ContactType.SKYPE, "us_skype3");
        RESUME_3.addSection(SectionType.PERSONAL, new TextSection("Personal data 3"));
        RESUME_3.addSection(SectionType.WORK_EXPERIENCE,
                new OrganizationSection(
                        new Organization("Place work number 1", "http://URL3.com",
                                new Organization.Position(DateUtil.of(2015, Month.DECEMBER), "Аспирантура", "Прогрммист C/C++")
                        )
                )
        );
        RESUME_4.addContact(ContactType.EMAIL, "4email3@mail.ru");
        RESUME_4.addContact(ContactType.SKYPE, "4us_skype3");
        RESUME_4.addSection(SectionType.PERSONAL, new TextSection("4Personal data 3"));
        RESUME_4.addSection(SectionType.WORK_EXPERIENCE,
                new OrganizationSection(
                        new Organization("4Place work number 1", "http://URL3.com",
                                new Organization.Position(DateUtil.of(2015, Month.DECEMBER), "4Аспирантура", "Прогрммист C/C++")
                        )
                ));
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
     }
    @Test
    public void clear()throws Exception{
        storage.clear();
        assertSize(0);
    }
    @Test
    public void get() throws Exception{
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

     @Test(expected = NotExistStorageException.class)
     public void assertNotExist(){
         storage.get("dfdfdf");
      }
     @Test(expected = StorageException.class)
      public void saveAlreadyExist() throws Exception{

          storage.save(RESUME_1);
      }
      @Test
      public void save() throws Exception{
          int sz = storage.size();
          storage.save(RESUME_4);
          assertSize(sz + 1);
          Assert.assertEquals(RESUME_4, storage.get(UUID_4));
      }
    @Test
    public void getAll(){

        List<Resume> resumes = new ArrayList<>();
        resumes.add(RESUME_1);
        resumes.add(RESUME_2);
        resumes.add(RESUME_3);
        assertEquals(resumes,storage.getAllSorted());
    }
    @Test
    public void delete()throws Exception{
        storage.delete(RESUME_1.getUuid());
        assertArrayWithSort(RESUME_2,RESUME_3);
    }

    private void assertArrayWithSort(Resume... resumes){
        List<Resume> arr = Arrays.asList(resumes);
        assertTrue(arr.containsAll(storage.getAllSorted()));
    }
     private void assertGet(Resume resume){
         assertEquals(resume, storage.get(resume.getUuid()));
     }
     private void assertSize(int size){
         assertEquals(size, storage.size());
     }
}