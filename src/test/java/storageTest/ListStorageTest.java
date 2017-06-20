package storageTest;

import abstractClasses.AbstractStorageTest;
import com.storage.collectionImpl.ListStorage;

public class ListStorageTest extends AbstractStorageTest {
    public ListStorageTest(){
        super(new ListStorage());
    }
}
