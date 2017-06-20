package config;

import com.storage.SqlStorage;
import com.storage.interfaces.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    protected static final File PROPS = new File(".\\src\\main\\java\\config\\resume.properties");
    private static final Config INSTANCE = new Config();
    private Properties props = new Properties();
    private File storageDir;
    private Storage storage;
    private String dbUrl,dbUser, dbPassword;
    private Config() {

        try (InputStream is = new FileInputStream(PROPS)) {
            props.load(is);
            storageDir = new File(props.getProperty("storage.dir"));
            dbUrl=props.getProperty("db.url");
            dbUser=props.getProperty("db.user");
            dbPassword=props.getProperty("db.password");
            storage = new SqlStorage(dbUrl,dbUser,dbPassword);
        } catch (IOException e) {

        }
    }

    public static Config getInstance() {
        return INSTANCE;
    }

    public File getStorageDir() {
        return storageDir;
    }
    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public Storage getStorage() {
        return storage;
    }

    public Properties getProps() {
        return props;
    }
}
