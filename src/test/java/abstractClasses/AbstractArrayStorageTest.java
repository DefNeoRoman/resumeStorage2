package abstractClasses;

import com.exception.StorageException;
import com.model.Resume;
import com.storage.abstractClasses.AbstractArrayStorage;
import com.storage.interfaces.Storage;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{
    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void testSaveOverflow() throws Exception {
        for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT+1; i++){

            storage.save(new Resume("dummy"));
        }
    }
}
