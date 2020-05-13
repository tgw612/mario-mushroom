package com.mario.jvm;

import com.google.common.collect.Lists;
import org.apache.ibatis.exceptions.TooManyResultsException;

import java.lang.ref.SoftReference;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class SoftRefObject {

  public void m() {
    System.out.println("I'm Soft Reference Object");
  }
}

public class SoftRefObjectExample {

  public static void main(String[] args) {
    // 强引用
    SoftRefObject obj = new SoftRefObject();
    obj.m();

    // 创建一个软引用指向SoftRefObject类型的实例对象'obj'
    SoftReference<SoftRefObject> softRef = new SoftReference<>(obj);

    // 去掉 SoftRefObject 对象上面的强引用，这时，对象可以被回收
    obj = null;

    // 返回弱引用指向的对象，对象的可达性状态发生改变
    obj = softRef.get();
    if (obj != null) {
      obj.m();
    }
  }


  /**
   * 这段代码在大部分情况下，都能很好的运行，但它有一个小的缺陷：如果查询返回一百万行而你没有可用内存来存储它们会发生什么？
   *
   * @param rs
   * @return
   */
  // 去掉资源关闭，异常处理等细节
  public static List<Map<String, Object>> processResults(ResultSet rs) throws SQLException {
    List<Map<String, Object>> list = Lists.newArrayList();
    ResultSetMetaData meta = rs.getMetaData();
    int colCount = meta.getColumnCount();
    while (rs.next()) {
      Map<String, Object> map = new HashMap<String, Object>();
      // 每行数据放入一个map中
      for (int i = 0; i < colCount; i++) {
        map.put(meta.getColumnName(i), rs.getObject(i));
      }
      list.add(map);
    }
    return list;
  }

  // 去掉资源关闭，异常处理等细节
  public static List<Map<String, Object>> processResultsBetter(ResultSet rs) throws SQLException {
    ResultSetMetaData meta = rs.getMetaData();
    int colCount = meta.getColumnCount();
    // 软引用指向最终返回的List
    SoftReference<List<Map<String, Object>>> ref = new SoftReference<>(new LinkedList<>());
    while (rs.next()) {
      Map<String, Object> map = new HashMap<>();
      for (int i = 0; i < colCount; i++) {
        map.put(meta.getColumnName(i), rs.getObject(i));
      }
      // 如果List已经被回收，那么说明内存不足，直接返回自定义的异常通知上层服务
      List<Map<String, Object>> result = ref.get();
      if (result == null) {
        throw new TooManyResultsException();
      } else {
        result.add(map);
      }
    }
    return ref.get();
  }

}

