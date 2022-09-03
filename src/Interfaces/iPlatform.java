package Interfaces;

import java.sql.SQLException;

public interface iPlatform {
    public void start();
    public boolean register() throws SQLException;
    public boolean login();
    public void stop();
}
