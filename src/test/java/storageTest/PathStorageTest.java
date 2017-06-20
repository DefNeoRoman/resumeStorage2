package storageTest;

import abstractClasses.AbstractStorageTest;
import com.storage.PathStorage;
import com.storage.serializer.ObjectStreamSerializer;


public class PathStorageTest extends AbstractStorageTest {
    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()));
    }
}
