package mapsTest;

import abstractClasses.AbstractStorageTest;
import com.storage.collectionImpl.MapStorage;

public class MapStorageTest extends AbstractStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }
}
