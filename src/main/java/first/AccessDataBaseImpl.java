package first;

import org.apache.commons.dbcp.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessDataBaseImpl implements AccessDataBase {


    private MainClassField field;
    private BasicDataSource dataSource;

    public AccessDataBaseImpl(MainClassField field) {
        this.field = field;
        if(field != null) {
            this.dataSource = new BasicDataSource();
            this.dataSource.setDriverClassName(field.getDriver());
            this.dataSource.setUrl(field.getUrl());
            this.dataSource.setPassword(field.getPassword());
            this.dataSource.setUsername(field.getLogin());
        }
    }

    public void insert() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.dataSource.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("insert into test (field) values(?)");
            if(field.getField() > 0) {
                for (int i = 1; i < field.getField(); i++) {
                    preparedStatement.setInt(1, i);
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
                connection.commit();
            }
        } catch(Exception e) {
            if(connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }

    public EntryObject getAllRows() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        EntryObject obj = new EntryObject();
        try {
            connection = this.dataSource.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("select * from test");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                EntryElement entryElement = new EntryElement();
                entryElement.setField(resultSet.getInt(2));
                obj.addEntry(entryElement);
            }
        } catch(Exception e) {
            if(connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(resultSet != null) {
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
        return obj;
    }

    public void deleteAllRows() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.dataSource.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("delete from test");
            preparedStatement.execute();
            connection.commit();
        } catch(Exception e) {
            if(connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }
}
