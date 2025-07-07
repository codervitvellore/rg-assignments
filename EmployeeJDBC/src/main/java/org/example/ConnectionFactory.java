package org.example;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public final class ConnectionFactory {

    private static final String PROPS_FILE = "db.properties";
    private static String url;
    private static String user;
    private static String pass;

    static {
        try (InputStream in = ConnectionFactory.class
                .getClassLoader()
                .getResourceAsStream(PROPS_FILE)) {

            Properties p = new Properties();
            p.load(in);

            url  = p.getProperty("jdbc.url");
            user = p.getProperty("jdbc.user");
            pass = p.getProperty("jdbc.password");

            /* load driver explicitly only if running on JDK ≤ 8 */
            Class.forName(p.getProperty("jdbc.driver"));
        } catch (Exception ex) {
            throw new ExceptionInInitializerError("DB config error: " + ex);
        }
    }

    private ConnectionFactory() { }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, pass);
    }
}
