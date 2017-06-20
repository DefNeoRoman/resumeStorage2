package storageTest;

import abstractClasses.AbstractArrayStorageTest;
import com.storage.arrayImpl.SortedArrayStorage;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {
    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }
}
