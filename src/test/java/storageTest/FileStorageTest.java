package storageTest;

import abstractClasses.AbstractStorageTest;
import com.storage.dataImpl.FileStorage;
import com.storage.serializer.ObjectStreamSerializer;

public class FileStorageTest extends AbstractStorageTest {
    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR,new ObjectStreamSerializer()));
    }
}
