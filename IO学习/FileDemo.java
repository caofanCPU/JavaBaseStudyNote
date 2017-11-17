/**
 * File f = new File(路径)，声明f可能是文件也可能是目录
 * f的路径一旦声明便不可修改，f可能不存在
 * 0.File对象的创建方式
 * File paDir = new File("D:" + File.separator + "paDir文件夹");
 * File file = new File(paDir, "子文件file.txt");
 * 等价于：File file = new File("D:\\paDir文件夹\\子文件file.txt");
 * 等价于：File file = new File("D:\\paDir文件夹", "子文件file.txt");
 * 1.创建
 * 【boolean】.createNewFile(空参)：在指定路径创建文件(或目录)，如果该文件(或目录已存在)，则不创建，返回false
 * 而输出流对象一旦创建文件，文件已经存在，也会被覆盖
 * 【boolean】.mkdir()：创建最多两层文件夹
 * 【boolean】.mkdirs()：创建多层文件夹
 * 2.删除
 * 【boolean】.delete()：删除文件或目录，若该文件正在被使用，删除失败，返回false
 * 【void】	.deleteOnExit()：在JVM结束时删除文件，即文件一定会被删除
 * .delete()即时使用try-catch-finally结构，文件依然可能删除失败
 * 所以，用deleteOnExit()去删除文件，一定会删除成功
 * 3.判断
 * 【boolean】.exists()：判断f文件(或目录)是否存在，这一步是必须要进行的
 * 【boolean】.isFile()：判断f是否为文件
 * 【boolean】.isDirectory()：判断f是否为目录
 * 【boolean】.isHidden()：判断文件是否为隐藏文件
 * 【boolean】.isAbsolute()：判断声明并定义f时给定的"路径"是不是绝对路劲
 * 4.获取
 * 【String】.getName()：返回该文件或目录的名称字符串
 * 【String】.getPath()：返回该文件对象声明时指定的路径字符串(你写的啥，我返回啥)
 * 【String】.getParent()：返回该文件对象声明时，若指定了父目录，则返回该父目录字符串，若没有指定，返回null
 * 【File】  .getParentFile()：返回该文件对象声明时，若指定了父目录，则返回父目录File对象，若没有则返回null
 * 【String】.getAbsolutePath()：返回该文件对象的绝对路径字符串，即时该文件或目录不存在，在声明时并非绝对路径
 * 【Long】.length()：返回该文件或目录占用的存储空间的大小(字节长度)，长整型
 * 【Long】.lastModified()：返回该文件或目录最后一次修改时间
 * 【String[]】.list()：返回该目录中的文件名或一级子目录名
 * 【File[]】.listFiles()：返回该目录下所有文件、一级子目录对象
 */

import java.io.File;

class FileDemo {
    public static void main(String[] args) {
        /**
         * FileDemo.java文件解决问题：
         * 练习File类常用API
         * 重点掌握"集合学习"目录下：DirNamePrintDG.java，递归调用，输出某个文件夹下所有文件名
         */
        lineSplit();
        File f = new File("D:" + File.separator);
        String[] strf = f.list();
        for (int i = 0; i < strf.length; i++) {
            sop(strf[i]);
        }
        lineSplit();

    }

    public static void sop(Object obj) {
        /**
         * 打印字符串
         *
         */
        System.out.println(obj);
    }

    public static void lineSplit() {
        /**
         * 打印分隔符
         *
         */
        sop("---------------------------");
    }
}
