import dataStoragetest.DataPathStorageTest;
import dataStoragetest.JsonPathStorageTest;
import dataStoragetest.SqlStorageTest;
import dataStoragetest.XmlPathStorageTest;
import mapsTest.MapResumeStorageTest;
import mapsTest.MapUuidStorageTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import storageTest.*;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                SortedArrayStorageTest.class,
                ListStorageTest.class,
                MapUuidStorageTest.class,
                MapResumeStorageTest.class,
                FileStorageTest.class,
                PathStorageTest.class,
                XmlPathStorageTest.class,
                JsonPathStorageTest.class,
                DataPathStorageTest.class,
                SqlStorageTest.class
        }
)
public class AllStorageTest {
}