<深入理解java虚拟机>
《自己动手写Java虚拟机》

JVM调优专栏
https://mp.weixin.qq.com/s/01vNcW2Ubsvkp1OULKpPkg


简书
OOM异常 https://www.jianshu.com/p/2fdee831ed03


java的四种引用
强引用(Strong Reference):对象是强引用的时候,即使jvm内存空间不足,GC也不会回收该对象,当满时,报OutOfMemoryError异常
软引用(Soft Reference):JVM内存不足时,会回收软引用,其引用可以关联一个引用队列(需要在一个对象的可达性(是否已被GC回收)发生变化时得到通知,
引用队列就是用于收集这些信息的队列)
弱引用(weak Reference):只被弱引用所指向的对象的生命周期是两次GC之间,而只被软引用所指向的对象可以经历多次GC,直到出现内存紧张的情况才会被回收,如weakHashMap
幽灵引用(Phantom Reference):又叫虚引用,创建虚引用则必须指定一个引用队列,当GC准备回收一个对象时如果发现还有虚引用,则会在回收对象的内存之前,
把虚引用加入到关联的引用队列中.之后码农可做一个跟踪,用于比较精细的内存使用控制 



常用性能监控

当应用大量使用内存时，容易造成内存溢出错误，甚至程序崩溃，这种情况下，可以使用软引用来避免OutOfMemoryError，以实现自我保护的目的。