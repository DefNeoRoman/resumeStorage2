package abstractClasses;

import TestData.*;
import com.exception.ExistStorageException;
import com.exception.NotExistStorageException;
import com.exception.StorageException;
import com.model.*;
import com.storage.interfaces.Storage;
import config.Config;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static java.util.Objects.requireNonNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public abstract class AbstractStorageTest {

    protected final Storage storage;
    protected static final File STORAGE_DIR = Config.getInstance().getStorageDir();



    public AbstractStorageTest(Storage storage) {
        requireNonNull(storage, "Storage must not be null");
        this.storage = storage;
    }
    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(TestData.RESUME_1);
        storage.save(TestData.RESUME_2);
        storage.save(TestData.RESUME_3);
     }
    @Test
    public void clear()throws Exception{
        storage.clear();
        assertSize(0);
    }
    @Test
    public void get() throws Exception{
        assertGet(TestData.RESUME_1);
        assertGet(TestData.RESUME_2);
        assertGet(TestData.RESUME_3);
    }

     @Test(expected = NotExistStorageException.class)
     public void assertNotExist(){
         storage.get("dfdfdf");
      }
     @Test(expected = ExistStorageException.class)
      public void saveAlreadyExist() throws Exception{
//        List <Resume> lr =  storage.getAllSorted();
//        Resume resume = lr.get(0);
          storage.save(TestData.RESUME_X);
          storage.save(TestData.RESUME_X);

      }
      @Test
      public void save() throws Exception{
          int sz = storage.size();
          storage.save(new Resume(TestData.UUID_X, TestData.FULL_NAME_X));
          assertSize(sz + 1);
          Assert.assertEquals(TestData.RESUME_X, storage.get(TestData.UUID_X));
      }
    @Test
    public void getAll(){
        List<Resume> r = storage.getAllSorted();
        Assert.assertEquals(3, r.size());
        List<Resume> list= Arrays.asList(TestData.RESUME_1,TestData.RESUME_2, TestData.RESUME_3);
        Collections.sort(list);
        Assert.assertEquals(r, list);
    }
    @Test
    public void delete()throws Exception{
        int sz = storage.size();
        List<Resume> copyStorage = storage.getAllSorted();
        storage.delete(copyStorage.get(sz - 1).getUuid());
//        copyStorage.remove(sz - 1);
        assertSize(sz - 1);

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