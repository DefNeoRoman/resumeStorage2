package dataStoragetest;

import abstractClasses.AbstractStorageTest;
import config.Config;

public class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
       super(Config.getInstance().getStorage());
    }
}
