package com.util;

import com.exception.StorageException;
import com.storage.interfaces.ConnectionFactory;
import com.storage.interfaces.SQLTransaction;
import com.storage.interfaces.SqlExecutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlHelper {
    public final ConnectionFactory connectionFactory;

    public SqlHelper(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void execute(String sql){
       execute(sql,PreparedStatement::execute);
    }
    public <T>T execute(String sql, SqlExecutor<T> executor) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = connectionFactory.getConnection()){

            PreparedStatement ps = connection.prepareStatement(sql);
            return executor.execute(ps);
        } catch (SQLException e) {
            throw new StorageException(e.toString(),null);
        }
    }
    public <T> T transactionalExecute(SQLTransaction<T> executor) {
        try (Connection conn = connectionFactory.getConnection()) {
            try {
                conn.setAutoCommit(false);
                T res = executor.execute(conn);
                conn.commit();
                return res;
            } catch (SQLException e) {
                conn.rollback();
                throw ExceptionUtil.convertException(e);
            }
        } catch (SQLException e) {
            throw new StorageException(e.getMessage());
        }

    }
}
