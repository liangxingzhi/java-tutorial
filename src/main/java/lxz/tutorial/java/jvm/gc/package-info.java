/**
 * 
 */

/**
 * -XX:+UseSerialGC ：在新生代和老年代使用串行收集器，使用Serial + Serial Old的收集器组合
 * 
 * -XX:SurvivorRatio：设置eden区大小和survivior区大小的比例
 * 
 * -XX:NewRatio:新生代和老年代的比
 * 
 * -XX:+UseParNewGC：在新生代使用并行收集器，使用ParNew + Serial Old的收集器组合 
 * 
 * -XX:+UseParallelGC ：新生代使用并行回收收集器，使用Parallel Scanvenge + Parallel Old的收集器组合
 * 
 * -XX:+UseParallelOldGC：老年代使用并行回收收集器，使用Parallel Scanvenge + Parallel Old的收集器组合
 * 
 * -XX:ParallelGCThreads：设置用于垃圾回收的线程数，
 * 
 * -XX:+UseConcMarkSweepGC：新生代使用并行收集器，老年代使用CMS+串行收集器，使用ParNew + CMS + Serial Old收集器，Serial Old作为CMS出现Concurrent Mode Failure失败后的后备收集器使用
 * 
 * -XX:ParallelCMSThreads：设定CMS的线程数量
 * 
 * -XX:CMSInitiatingOccupancyFraction：设置CMS收集器在老年代空间被使用多少后触发
 * 
 * -XX:+UseCMSCompactAtFullCollection：设置CMS收集器在完成垃圾收集后是否要进行一次内存碎片的整理
 * 
 * -XX:CMSFullGCsBeforeCompaction：设定进行多少次CMS垃圾回收后，进行一次内存压缩
 * 
 * -XX:+CMSClassUnloadingEnabled：允许对类元数据进行回收
 * 
 * -XX:CMSInitiatingPermOccupancyFraction：当永久区占用率达到这一百分比时，启动CMS回收
 * 
 * -XX:UseCMSInitiatingOccupancyOnly：表示只在到达阀值的时候，才进行CMS回收
 * 
 * 
 */
package lxz.tutorial.java.jvm.gc;
