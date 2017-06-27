package dataStoragetest;

import abstractClasses.AbstractStorageTest;
import com.Config;

public class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
       super(Config.getInstance().getStorage());
    }
}
