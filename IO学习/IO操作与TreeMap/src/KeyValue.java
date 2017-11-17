import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 * KeyValue.java，对键值规范文本文件，每一行内容模式：<键，值>进行TreeMap排序存储
 * 由于键、值均为String对象，而String对象默认实现了比较及排序
 */

class KeyValue {
    private File sourceFile = null;
    private TreeMap<String, String> tm = new TreeMap<String, String>();

    public KeyValue() {
    }

    public KeyValue(File file) {
        /**
         * 此处，假设传入的文件引用，已经是按照指定规则存储的键值内容
         * 如果不是，可采取的方案就是，对于不满足的行，丢弃
         * 最好反复校验FileAnalysis类的analysis()方法，对于使用的正则表达式进行多次实验
         * 确保此处拿到的是键值规范文件
         */
        this.sourceFile = file;
        this.createTreeMap();
    }

    public void createTreeMap() {
        BufferedReader bufr = null;
        try {
            bufr = new BufferedReader(new FileReader(this.sourceFile));
            String line = null;
            String[] keyValueStr = null;
            while (null != (line = bufr.readLine())) {
                //中文'，'的Unicode编码为\uFF0C
                keyValueStr = line.split("\uFF0C");
                //为测试方便，以ID数字串作为ID，姓名字符串作为值
                //这样方便查看排序结果
                if (2 != keyValueStr.length) {
                    //为安全起见，对于文件每行分割结果不是2个子串的，丢弃
                    //尤其是只有一个字串，影响后续运行
                    continue;
                }
                //tm.put(keyValueStr[0], keyValueStr[1]);
                tm.put(keyValueStr[1], keyValueStr[0]);
            }
        } catch (IOException ioe) {
            throw new RuntimeException("源文件：" + this.sourceFile.getAbsolutePath()
                    + "读取失败！");
        } finally {
            try {
                if (null != bufr) {
                    bufr.close();
                }
            } catch (IOException ioe) {
                throw new RuntimeException("源文件：" + this.sourceFile.getAbsolutePath()
                        + "写入关闭失败！");
            }
        }
        sop("Successful!--源文件：\"" + this.sourceFile.getAbsolutePath()
                + "\"\n使用TreeMap存储成功！");
    }

    public TreeMap<String, String> getTreeMap() {
        return this.tm;
    }

    public void sop(Object obj) {
        System.out.println(obj);
    }
}
