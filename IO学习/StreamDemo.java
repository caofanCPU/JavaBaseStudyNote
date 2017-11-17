/**
 * 装饰设计模式：
 * 当想要对已有的对象进行功能增强时，可以自定义类
 * 将已有对象传入，基于已有对象的已有功能，提供加强功能
 * 那么该自定义称为装饰类
 * <p>
 * 字符流：Reader、Writer，两个抽象类
 * |--FileReader、FileWriter
 * |--BufferedReader、BufferedWriter
 * |--InputStreamReader、OutputStreamWriter    转换流：字节流的字符对象
 * 将键盘录入、键盘输出字节流转换为字符流对象
 * <p>
 * 字节流：InputStream、OutputStream，两个抽象类
 * |--FileInputStream、FileOutputStream
 * <p>
 * 如何选取流体系？三个明确
 * 1.明确源和目的
 * 源：输入流，   InputStream        Reader
 * 目的：输出流， OutputStream       Writer
 * 2.明确要操作的数据是否为纯文本
 * 是纯文本：使用字符流，即Reader          Writer          体系
 * 非纯文本：使用字节流，即InputStream     OutputStream    体系
 * 3.明确使用哪个具体对象
 * 通过设备来区分：
 * 源设备  ：键盘录入    入内存    写硬盘(写入文件)
 * 目的设备：控制台输出  出内存    读硬盘(读取文件)
 * 注意：对于FileReader、FileWriter，默认编码为GBK(WINDOS，平台相关)
 * 注意：使用System.setIn(new FileInputStream("文件路径及文件名"));
 * 使用System.setOut(new PrintStream("文件路径及文件名"));
 * 通过这种方法改变默认"键盘输入流"，默认控制台输出流
 * 实例：将整数翻译为汉语，可以定义文件source，source文件中手动写入要测试的整数
 * 再定义文件destination，destination文件中自动写入翻译的结果
 * 优化：将手动写入的测试整数+翻译结果一并写入destination文件
 */

/**
 * 字符流：Reader、Writer，两个抽象类
 *		|--FileReader、FileWriter
 *		|--BufferedReader、BufferedWriter
 *		|--InputStreamReader、OutputStreamWriter    转换流：字节流的字符对象
 *													将键盘录入、键盘输出字节流转换为字符流对象
 *
 * 字节流：InputStream、OutputStream，两个抽象类
 *		|--FileInputStream、FileOutputStream
 */

/**
 * 如何选取流体系？三个明确
 * 1.明确源和目的
 *		源：输入流，   InputStream        Reader
 *		目的：输出流， OutputStream       Writer
 * 2.明确要操作的数据是否为纯文本
 *		是纯文本：使用字符流，即Reader          Writer          体系
 *		非纯文本：使用字节流，即InputStream     OutputStream    体系
 * 3.明确使用哪个具体对象
 *		通过设备来区分：
 *			源设备  ：键盘录入    入内存    写硬盘(写入文件)
 *			目的设备：控制台输出  出内存    读硬盘(读取文件)
 * 注意：对于FileReader、FileWriter，默认编码为GBK(WINDOS，平台相关)
 * 注意：使用System.setIn(new FileInputStream("文件路径及文件名"));
 *		 使用System.setOut(new PrintStream("文件路径及文件名"));
 *       通过这种方法改变默认"键盘输入流"，默认控制台输出流
 *       实例：将整数翻译为汉语，可以定义文件source，source文件中手动写入要测试的整数
 *                             再定义文件destination，destination文件中自动写入翻译的结果
 *             优化：将手动写入的测试整数+翻译结果一并写入destination文件
 */

import java.io.*;

class StreamDemo {
    public static void main(String[] args) {
        /**
         * StreamDemo.java文件解决问题：
         * 演示FileInputStream读取文件，FileOutputStream写入文件
         * 演示缓冲区字节流，复制mp3，复制视频
         *
         * 演示控制台键盘录入字符，控制台输出其大写，结束字符为over
         */
        /**
         outputStream();
         inputStream();*/
        /**
         * 拷贝MP3，并计算拷贝时长
         long start = System.currentTimeMillis();
         bufferedCopyMP3();
         long end = System.currentTimeMillis();
         sop("拷贝耗时：" + (end - start) + "毫秒");*/
        /**
         * 拷贝VDO，并计算拷贝时长
         long start2 = System.currentTimeMillis();
         bufferedCopyVDO();
         long end2 = System.currentTimeMillis();
         sop("拷贝时长" + (end2 - start2) +  "毫秒");
         */
        tranStream();
    }

    public static void outputStream() {
        FileOutputStream fos = null;
        /**
         * 字节流不需要刷新，但是仍需要关闭
         */
        try {
            fos = new FileOutputStream("Fos.txt");
            //字节流只需要写，不需要刷新
            fos.write("我会努力过好这一生".getBytes());
        } catch (IOException ioe) {
            //待处理
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != fos) {
                    fos.close();
                }
            } catch (IOException ioe) {
                //待处理
                sop("Catch:输出字节流关闭失败！" + ioe.toString());
            }
        }

    }

    public static void inputStream() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("Fos.txt");
            byte[] buf = new byte[1024];
            int len = 0;
            while (-1 != (len = fis.read(buf))) {
                //String类的构造函数，既可以将字符数组变字符串
                //又可以将字节数组变成字符串
                sop(new String(buf, 0, len));
            }
        } catch (IOException ioe) {
            //待处理
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException ioe) {
                //待处理
                sop("Catch:读取输入流关闭失败！" + ioe.toString());
            }
        }
    }

    public static void bufferedCopyMP3() {
        BufferedInputStream bufis = null;
        BufferedOutputStream bufos = null;
        try {
            bufis = new BufferedInputStream(new FileInputStream("C:/Users\\CY_XYZ/Desktop/D_PDD/Darkhaast.mp3"));
            bufos = new BufferedOutputStream(new FileOutputStream("JavaCopy_Darkhaast.mp3"));
            int by = 0;
            while (-1 != (by = bufis.read())) {
                //字节流不需要刷新，但是需要关闭
                bufos.write(by);
            }
        } catch (IOException ioe) {
            //待处理
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != bufis) {
                    bufis.close();
                }
            } catch (IOException ioe) {
                //待处理
                sop("Catch:文件读取输入流关闭失败！" + ioe.toString());
            }

            try {
                if (null != bufos) {
                    bufos.close();
                }
            } catch (IOException ioe) {
                //待处理
                sop("Catch:文件写入输出流关闭失败！" + ioe.toString());
            }
        }
    }

    public static void bufferedCopyVDO() {
        BufferedInputStream bufis = null;
        BufferedOutputStream bufos = null;
        try {
            bufis = new BufferedInputStream(new FileInputStream("C:/Users\\CY_XYZ/Desktop/D_PDD/很美.mkv"));
            bufos = new BufferedOutputStream(new FileOutputStream("JavaCopy_很美.mkv"));
            int by = 0;
            while (-1 != (by = bufis.read())) {
                //字节流不需要刷新，但是需要关闭
                bufos.write(by);
            }
        } catch (IOException ioe) {
            //待处理
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != bufis) {
                    bufis.close();
                }
            } catch (IOException ioe) {
                //待处理
                sop("Catch:文件读取输入流关闭失败！" + ioe.toString());
            }

            try {
                if (null != bufos) {
                    bufos.close();
                }
            } catch (IOException ioe) {
                //待处理
                sop("Catch:文件写入输出流关闭失败！" + ioe.toString());
            }
        }
    }

    public static void tranStream() {
        /**
         * 控制台键盘录入字符，控制台输出其大写形式，专用结束标记over
         * InputStream in = System.in;		//抽象父类指向子类对象，多态性
         * InputStreamReader isr = new InputStreamReader(in);
         * BufferedReader bufr = new BufferedReader(isr);
         * //==>BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in))
         *
         * OutputStream out = System.out;
         * OutputStreamWriter osw = new OutputStreamWriter(out);
         * BufferedWriter bufw = new BufferedWriter(osw);
         * //==>BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
         *
         * 关系：缓存字符流-->(字符流-->转换字节流)-->字节流
         */
        BufferedReader bufr = null;
        BufferedWriter bufw = null;
        try {
            bufr = new BufferedReader(new InputStreamReader(System.in));
            bufw = new BufferedWriter(new OutputStreamWriter(System.out));
            String line = null;
            int i = 1;
            while (null != (line = bufr.readLine())) {
                if ("over".equals(line)) {
                    break;
                }
                bufw.write("[" + i + "]    " + line.toUpperCase());
                bufw.newLine();
                bufw.flush();
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
                sop("Catch:键盘读取关闭失败" + ioe.toString());
            }
            try {
                if (null != bufw) {
                    bufw.close();
                }
            } catch (IOException ioe) {
                //待处理
                sop("Catch:控制台写入关闭失败" + ioe.toString());
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
