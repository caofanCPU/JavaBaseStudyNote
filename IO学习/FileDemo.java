/**
 * File f = new File(·��)������f�������ļ�Ҳ������Ŀ¼
 * f��·��һ�������㲻���޸ģ�f���ܲ�����
 * 0.File����Ĵ�����ʽ
 * File paDir = new File("D:" + File.separator + "paDir�ļ���");
 * File file = new File(paDir, "���ļ�file.txt");
 * �ȼ��ڣ�File file = new File("D:\\paDir�ļ���\\���ļ�file.txt");
 * �ȼ��ڣ�File file = new File("D:\\paDir�ļ���", "���ļ�file.txt");
 * 1.����
 * ��boolean��.createNewFile(�ղ�)����ָ��·�������ļ�(��Ŀ¼)��������ļ�(��Ŀ¼�Ѵ���)���򲻴���������false
 * �����������һ�������ļ����ļ��Ѿ����ڣ�Ҳ�ᱻ����
 * ��boolean��.mkdir()��������������ļ���
 * ��boolean��.mkdirs()����������ļ���
 * 2.ɾ��
 * ��boolean��.delete()��ɾ���ļ���Ŀ¼�������ļ����ڱ�ʹ�ã�ɾ��ʧ�ܣ�����false
 * ��void��	.deleteOnExit()����JVM����ʱɾ���ļ������ļ�һ���ᱻɾ��
 * .delete()��ʱʹ��try-catch-finally�ṹ���ļ���Ȼ����ɾ��ʧ��
 * ���ԣ���deleteOnExit()ȥɾ���ļ���һ����ɾ���ɹ�
 * 3.�ж�
 * ��boolean��.exists()���ж�f�ļ�(��Ŀ¼)�Ƿ���ڣ���һ���Ǳ���Ҫ���е�
 * ��boolean��.isFile()���ж�f�Ƿ�Ϊ�ļ�
 * ��boolean��.isDirectory()���ж�f�Ƿ�ΪĿ¼
 * ��boolean��.isHidden()���ж��ļ��Ƿ�Ϊ�����ļ�
 * ��boolean��.isAbsolute()���ж�����������fʱ������"·��"�ǲ��Ǿ���·��
 * 4.��ȡ
 * ��String��.getName()�����ظ��ļ���Ŀ¼�������ַ���
 * ��String��.getPath()�����ظ��ļ���������ʱָ����·���ַ���(��д��ɶ���ҷ���ɶ)
 * ��String��.getParent()�����ظ��ļ���������ʱ����ָ���˸�Ŀ¼���򷵻ظø�Ŀ¼�ַ�������û��ָ��������null
 * ��File��  .getParentFile()�����ظ��ļ���������ʱ����ָ���˸�Ŀ¼���򷵻ظ�Ŀ¼File������û���򷵻�null
 * ��String��.getAbsolutePath()�����ظ��ļ�����ľ���·���ַ�������ʱ���ļ���Ŀ¼�����ڣ�������ʱ���Ǿ���·��
 * ��Long��.length()�����ظ��ļ���Ŀ¼ռ�õĴ洢�ռ�Ĵ�С(�ֽڳ���)��������
 * ��Long��.lastModified()�����ظ��ļ���Ŀ¼���һ���޸�ʱ��
 * ��String[]��.list()�����ظ�Ŀ¼�е��ļ�����һ����Ŀ¼��
 * ��File[]��.listFiles()�����ظ�Ŀ¼�������ļ���һ����Ŀ¼����
 */

import java.io.File;

class FileDemo {
    public static void main(String[] args) {
        /**
         * FileDemo.java�ļ�������⣺
         * ��ϰFile�ೣ��API
         * �ص�����"����ѧϰ"Ŀ¼�£�DirNamePrintDG.java���ݹ���ã����ĳ���ļ����������ļ���
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
         * ��ӡ�ַ���
         *
         */
        System.out.println(obj);
    }

    public static void lineSplit() {
        /**
         * ��ӡ�ָ���
         *
         */
        sop("---------------------------");
    }
}
