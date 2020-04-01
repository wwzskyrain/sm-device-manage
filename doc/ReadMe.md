# 1.项目开编
## 1.1  规划
架构：项目分两部分，client和server，client是一个桌面程序，server就是一个server了。典型的cs架构。
功能：client完成用户的操作，编辑、读取、保存设备数据。client还要提供打印、读写串口设备的功能。
技术栈：项目决定采用java-swing来做client；用netty来与server端交互；server端就用简单Spring和mysql
    来完成。
    
## 1.2 技术调研和进度安排
1.  网上寻找读写串口和打印的程序，先把这两块做好。
2.  java窗口程序很多，在百度搜索'java课程设计'会有很多眼熟的书，下载来看下哪些合适。
3.  难点：难点应该在netty的使用上


# 2.项目启动和代码编写
## 2.1 串口设备的读取和写入
1.  相关原理介绍
    1.  https://blog.csdn.net/qq_28775437/article/details/73826276
    2.  https://blog.csdn.net/huwei2003/article/details/36418471
2.  rxtx的wiki地址，有源码的
    1.  http://rxtx.qbang.org/wiki/index.php/Two_way_communcation_with_the_serial_port

## 2.2 打印文件
1.  https://blog.csdn.net/u012854263/article/details/51137097
2.  https://blog.csdn.net/vatxiongxiaohui/article/details/83985896

## 2.3 java窗口应用程序
1.  https://www3.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html
2.  http://freesourcecode.net/javaprojects/12768/A-lot-of-Java-GUI-programming-examples#.XoPmV9MzZTY
