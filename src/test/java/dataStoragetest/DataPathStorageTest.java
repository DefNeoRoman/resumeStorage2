package dataStoragetest;

import abstractClasses.AbstractStorageTest;
import com.storage.dataImpl.PathStorage;
import com.storage.serializer.DataStreamSerializer;

public class DataPathStorageTest extends AbstractStorageTest {
    public DataPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(),new DataStreamSerializer()));
    }
}
