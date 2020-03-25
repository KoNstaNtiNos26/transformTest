package first;

import java.sql.SQLException;

public interface AccessDataBase {

    void insert() throws SQLException;
    EntryObject getAllRows() throws SQLException;
    void deleteAllRows() throws SQLException;
}
