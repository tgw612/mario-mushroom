package com.mario.transaciton;

import javax.transaction.*;
import java.sql.SQLException;
import java.sql.Statement;

public class JtaTransfer {

  public void JtaTransfer() {
    javax.transaction.UserTransaction tx = null;
    java.sql.Connection conn = null;
    Statement stmt = null;
    javax.sql.DataSource ds = null;
    try {
      // tx = (javax.transaction.UserTransaction) context.lookup("java:comp/UserTransaction");  //取得JTA事务，本例中是由Jboss容器管理
      //javax.sql.DataSource ds = (javax.sql.DataSource) context.lookup("java:/XAOracleDS");  //取得数据库连接池，必须有支持XA的数据库、驱动程序
      tx.begin();
      conn = ds.getConnection();

      // 将自动提交设置为 false，
      //若设置为 true 则数据库将会把每一次数据更新认定为一个事务并自动提交
      conn.setAutoCommit(false);
      stmt = conn.createStatement();
      // 将 A 账户中的金额减少 500
      stmt.execute("update t_account set amount = amount - 500 where account_id = 'A'");
      // 将 B 账户中的金额增加 500
      stmt.execute("update t_account set amount = amount + 500 where account_id = 'B'");
      // 提交事务
      tx.commit();
      // 事务提交：转账的两步操作同时成功
    } catch (SQLException sqle) {
      try {
        // 发生异常，回滚在本事务中的操做
        tx.rollback();
        // 事务回滚：转账的两步操作完全撤销
        stmt.close();
        conn.close();
      } catch (Exception ignore) {

      }
      sqle.printStackTrace();
    } catch (NotSupportedException e) {
      e.printStackTrace();
    } catch (SystemException e) {
      e.printStackTrace();
    } catch (RollbackException e) {
      e.printStackTrace();
    } catch (HeuristicMixedException e) {
      e.printStackTrace();
    } catch (HeuristicRollbackException e) {
      e.printStackTrace();
    }
  }
}
