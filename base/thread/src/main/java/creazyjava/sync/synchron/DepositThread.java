package creazyjava.sync.synchron;

/**
 * Description: <br/>???: <a href="http://www.crazyit.org">???Java????</a> <br/>Copyright (C),
 * 2001-2016, Yeeku.H.Lee <br/>This program is protected by copyright laws. <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class DepositThread extends Thread {

  private Account account;
  private double depositAmount;

  public DepositThread(String name, Account account
      , double depositAmount) {
    super(name);
    this.account = account;
    this.depositAmount = depositAmount;
  }

  public void run() {
    for (int i = 0; i < 100; i++) {
      account.deposit(depositAmount);
    }
  }
}
