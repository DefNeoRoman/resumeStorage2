package dataStoragetest;

import abstractClasses.AbstractStorageTest;
import com.storage.dataImpl.PathStorage;
import com.storage.serializer.XMLStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XMLStreamSerializer()));
    }
}
