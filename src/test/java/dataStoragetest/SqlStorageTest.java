package dataStoragetest;

import abstractClasses.AbstractStorageTest;
import com.storage.SqlStorage;
import com.storage.interfaces.Storage;
import config.Config;

public class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
       super(Config.getInstance().getStorage());
    }
}
