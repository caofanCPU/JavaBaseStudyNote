import java.io.*;

class BufferedDemo {
    public static void main(String[] args) {
        /**
         * BufferedDemo.java文件解决问题：
         * 通过缓冲区写入文本内容
         * 通过缓冲区将本代码文件复制到另外一个文件中，带上行号
         * 通过缓冲区将本代码文件打印到控制台上，带上行号
         */
        //bufferedWriterMain();
        bufferedReaderMain();
    }

    public static void bufferedWriterMain() {
        BufferedWriter bufw = null;
        try {
            /**
             * BufferedWriter、BufferedReader需要关联读操作流、写操作流
             * 常见均使用：BufferedWriter bufw = new BufferedWriter(new FileWriter("文件名"));
             *			   BufferedReader bufr = new BufferedReader(new FileReader("文件名"))
             * 原因在于：Buffered读写，封装了File读写的方法，关闭Buffered读写实质上就是关闭File读写
             */
            bufw = new BufferedWriter(new FileWriter("Buf.txt"));
            bufw.write("abcde");
            bufw.newLine();
            bufw.write("ABCDE");
            //刷新写缓冲区，相当于"开"！
            bufw.flush();
        } catch (IOException ioe) {
            //待处理
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != bufw) {
                    bufw.close();
                }
            } catch (IOException ioe) {
                //待处理
                sop("Catch:文件写入关闭失败！" + ioe.toString());
            }
        }
    }

    public static void bufferedReaderMain() {
        BufferedReader bufr = null;
        BufferedWriter bufw = null;
        try {
            bufr = new BufferedReader(new FileReader("BufferedDemo.java"));
            bufw = new BufferedWriter(new FileWriter("BUfferedDemo.txt"));
            String line = null;
            int i = 1;
            while (null != (line = bufr.readLine())) {
                bufw.write("[" + i + "]    " + line);
                bufw.newLine();
                bufw.flush();
                sop("[" + i + "]    " + line);
                i++;
            }
        } catch (IOException ioe) {
            //待处理
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != bufr) {
                    bufr.close();
                }
            } catch (IOException ioe) {
                //待处理
                sop("Catch:文件读取关闭失败！" + ioe.toString());
            }

            try {
                if (null != bufw) {
                    bufw.close();
                }
            } catch (IOException ioe) {
                //待处理
                sop("Catch文件写入关闭失败！" + ioe.toString());
            }
        }
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
