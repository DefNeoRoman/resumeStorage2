package dataStoragetest;

import abstractClasses.AbstractStorageTest;
import com.storage.PathStorage;
import com.storage.serializer.JSONStreamSerializer;

public class JsonPathStorageTest extends AbstractStorageTest {
    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JSONStreamSerializer()));
    }
}
