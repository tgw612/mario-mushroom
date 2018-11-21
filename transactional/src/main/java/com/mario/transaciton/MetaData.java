package com.mario.transaciton;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MetaData {
    @Test
    public void testJdbc2() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("");
            conn.setAutoCommit(false);//关闭自动提交机制
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);//设置事务隔离级别
            Statement stme = conn.createStatement();

            int rows = stme.executeUpdate("delete from tb");
            rows = stme.executeUpdate("update tb set row =1");
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {

        }
    }

    /**
     * jdbc2.0 事务职能提交和回滚
     * jdbc3.0 引入了保存点的特性,Savepoint 允许用户将事务分割为多个阶段,用户可以指定回滚到事务的特定保存点(但并非所有数据库都支持保存点)
     */

    @Test
    public void testJdbc3() {
        Connection conn = null;
        try {
            Statement stmt = conn.createStatement();
            int rows =stmt.executeUpdate("insert into tb_topic values(1,'toms')");
            Savepoint svpt =conn.setSavepoint("svpt1");
            rows =stmt.executeUpdate("insert into tb_topic values(2,'toms')");
            conn.rollback(svpt);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
