package com;

import com.storage.dataImpl.SqlStorage;
import com.storage.interfaces.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String DEFAULT_DRIVER = "org.postgresql.Driver";
   private static final File PROPS = new File("/resume.properties");
    private static final String PROPERTIES_PATH = "/resume.properties";
    private static final Config INSTANCE = new Config();
    private Properties props = new Properties();
    private File storageDir;
    private  Storage storage;
    private String dbUrl,dbUser, dbPassword;
    private Config() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (InputStream is = new FileInputStream(PROPS)) {
       // try (InputStream is = Config.class.getResourceAsStream(PROPERTIES_PATH)) {
            props.load(is);
            storageDir = new File(props.getProperty("storage.dir"));
//            dbUrl=props.getProperty("db.url");
//            dbUser=props.getProperty("db.user");
//            dbPassword=props.getProperty("db.password");
            dbUrl=System.getenv("DB_URL");
            dbUser=System.getenv("DB_USER");
            dbPassword=System.getenv("DB_PASSWORD");
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

    public  Storage getStorage() {
        return storage;
    }


    public Properties getProps() {
        return props;
    }
    private static File getHomeDir(){
        String prop = System.getProperty("homeDir");
        File homeDir = new File(prop==null?".":prop);
        if(!homeDir.isDirectory()){
            throw new IllegalStateException(homeDir+" is not directory");
        }
        return homeDir;
    }

    public static void main(String[] args) {
       System.out.println(getInstance().getStorageDir().toString());
    }
}
