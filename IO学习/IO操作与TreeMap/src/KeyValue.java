import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 * KeyValue.java���Լ�ֵ�淶�ı��ļ���ÿһ������ģʽ��<����ֵ>����TreeMap����洢
 * ���ڼ���ֵ��ΪString���󣬶�String����Ĭ��ʵ���˱Ƚϼ�����
 */

class KeyValue {
    private File sourceFile = null;
    private TreeMap<String, String> tm = new TreeMap<String, String>();

    public KeyValue() {
    }

    public KeyValue(File file) {
        /**
         * �˴������贫����ļ����ã��Ѿ��ǰ���ָ������洢�ļ�ֵ����
         * ������ǣ��ɲ�ȡ�ķ������ǣ����ڲ�������У�����
         * ��÷���У��FileAnalysis���analysis()����������ʹ�õ�������ʽ���ж��ʵ��
         * ȷ���˴��õ����Ǽ�ֵ�淶�ļ�
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
                //����'��'��Unicode����Ϊ\uFF0C
                keyValueStr = line.split("\uFF0C");
                //Ϊ���Է��㣬��ID���ִ���ΪID�������ַ�����Ϊֵ
                //��������鿴������
                if (2 != keyValueStr.length) {
                    //Ϊ��ȫ����������ļ�ÿ�зָ�������2���Ӵ��ģ�����
                    //������ֻ��һ���ִ���Ӱ���������
                    continue;
                }
                //tm.put(keyValueStr[0], keyValueStr[1]);
                tm.put(keyValueStr[1], keyValueStr[0]);
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Դ�ļ���" + this.sourceFile.getAbsolutePath()
                    + "��ȡʧ�ܣ�");
        } finally {
            try {
                if (null != bufr) {
                    bufr.close();
                }
            } catch (IOException ioe) {
                throw new RuntimeException("Դ�ļ���" + this.sourceFile.getAbsolutePath()
                        + "д��ر�ʧ�ܣ�");
            }
        }
        sop("Successful!--Դ�ļ���\"" + this.sourceFile.getAbsolutePath()
                + "\"\nʹ��TreeMap�洢�ɹ���");
    }

    public TreeMap<String, String> getTreeMap() {
        return this.tm;
    }

    public void sop(Object obj) {
        System.out.println(obj);
    }
}
