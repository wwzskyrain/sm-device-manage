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

3.  下载到一个demo代码，挺全的，已经fork了。
4.  还下载到一篇英文文章，写的挺完毕的，把它拷贝在doc中
5.  明天下午或者后天开工写代码咯！
6.  

## 2.2 打印文件
1.  https://blog.csdn.net/u012854263/article/details/51137097
2.  https://blog.csdn.net/vatxiongxiaohui/article/details/83985896
3.  将要使用的是'得力'打印机，京东链接：https://item.jd.com/5663596.html
4.  看了一篇内存生成pdf文档的： https://www.baeldung.com/java-pdf-creation
    很简单，就是读写图片和文字——关键是找到相关的jar包
    那么打印条形码呢？我们要试一下
   
5.  今天就看到这里吧。关于打印条形码
    1.  打印条形码需要一个zebra_printer,然后需要一个用到zpl命令与它交流
    2.  下载了一个zebra printer simulator ，是谷歌的，监听在9100端口，不过还没有调试通过。
    3.  zpl的命令还不熟悉，就像这样
    
    
### 2.2.1 实践
1.  下载了虚拟打印机 LisanetPdfWrite，安装教程如帖子: https://www.cnblogs.com/chan7/p/7720663.html
2.  

## 2.3 java窗口应用程序
1.  https://www3.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html
2.  http://freesourcecode.net/javaprojects/12768/A-lot-of-Java-GUI-programming-examples#.XoPmV9MzZTY
