/**
 * װ�����ģʽ��
 * ����Ҫ�����еĶ�����й�����ǿʱ�������Զ�����
 * �����ж����룬�������ж�������й��ܣ��ṩ��ǿ����
 * ��ô���Զ����Ϊװ����
 * <p>
 * �ַ�����Reader��Writer������������
 * |--FileReader��FileWriter
 * |--BufferedReader��BufferedWriter
 * |--InputStreamReader��OutputStreamWriter    ת�������ֽ������ַ�����
 * ������¼�롢��������ֽ���ת��Ϊ�ַ�������
 * <p>
 * �ֽ�����InputStream��OutputStream������������
 * |--FileInputStream��FileOutputStream
 * <p>
 * ���ѡȡ����ϵ��������ȷ
 * 1.��ȷԴ��Ŀ��
 * Դ����������   InputStream        Reader
 * Ŀ�ģ�������� OutputStream       Writer
 * 2.��ȷҪ�����������Ƿ�Ϊ���ı�
 * �Ǵ��ı���ʹ���ַ�������Reader          Writer          ��ϵ
 * �Ǵ��ı���ʹ���ֽ�������InputStream     OutputStream    ��ϵ
 * 3.��ȷʹ���ĸ��������
 * ͨ���豸�����֣�
 * Դ�豸  ������¼��    ���ڴ�    дӲ��(д���ļ�)
 * Ŀ���豸������̨���  ���ڴ�    ��Ӳ��(��ȡ�ļ�)
 * ע�⣺����FileReader��FileWriter��Ĭ�ϱ���ΪGBK(WINDOS��ƽ̨���)
 * ע�⣺ʹ��System.setIn(new FileInputStream("�ļ�·�����ļ���"));
 * ʹ��System.setOut(new PrintStream("�ļ�·�����ļ���"));
 * ͨ�����ַ����ı�Ĭ��"����������"��Ĭ�Ͽ���̨�����
 * ʵ��������������Ϊ������Զ����ļ�source��source�ļ����ֶ�д��Ҫ���Ե�����
 * �ٶ����ļ�destination��destination�ļ����Զ�д�뷭��Ľ��
 * �Ż������ֶ�д��Ĳ�������+������һ��д��destination�ļ�
 */

/**
 * �ַ�����Reader��Writer������������
 *		|--FileReader��FileWriter
 *		|--BufferedReader��BufferedWriter
 *		|--InputStreamReader��OutputStreamWriter    ת�������ֽ������ַ�����
 *													������¼�롢��������ֽ���ת��Ϊ�ַ�������
 *
 * �ֽ�����InputStream��OutputStream������������
 *		|--FileInputStream��FileOutputStream
 */

/**
 * ���ѡȡ����ϵ��������ȷ
 * 1.��ȷԴ��Ŀ��
 *		Դ����������   InputStream        Reader
 *		Ŀ�ģ�������� OutputStream       Writer
 * 2.��ȷҪ�����������Ƿ�Ϊ���ı�
 *		�Ǵ��ı���ʹ���ַ�������Reader          Writer          ��ϵ
 *		�Ǵ��ı���ʹ���ֽ�������InputStream     OutputStream    ��ϵ
 * 3.��ȷʹ���ĸ��������
 *		ͨ���豸�����֣�
 *			Դ�豸  ������¼��    ���ڴ�    дӲ��(д���ļ�)
 *			Ŀ���豸������̨���  ���ڴ�    ��Ӳ��(��ȡ�ļ�)
 * ע�⣺����FileReader��FileWriter��Ĭ�ϱ���ΪGBK(WINDOS��ƽ̨���)
 * ע�⣺ʹ��System.setIn(new FileInputStream("�ļ�·�����ļ���"));
 *		 ʹ��System.setOut(new PrintStream("�ļ�·�����ļ���"));
 *       ͨ�����ַ����ı�Ĭ��"����������"��Ĭ�Ͽ���̨�����
 *       ʵ��������������Ϊ������Զ����ļ�source��source�ļ����ֶ�д��Ҫ���Ե�����
 *                             �ٶ����ļ�destination��destination�ļ����Զ�д�뷭��Ľ��
 *             �Ż������ֶ�д��Ĳ�������+������һ��д��destination�ļ�
 */

import java.io.*;

class StreamDemo {
    public static void main(String[] args) {
        /**
         * StreamDemo.java�ļ�������⣺
         * ��ʾFileInputStream��ȡ�ļ���FileOutputStreamд���ļ�
         * ��ʾ�������ֽ���������mp3��������Ƶ
         *
         * ��ʾ����̨����¼���ַ�������̨������д�������ַ�Ϊover
         */
        /**
         outputStream();
         inputStream();*/
        /**
         * ����MP3�������㿽��ʱ��
         long start = System.currentTimeMillis();
         bufferedCopyMP3();
         long end = System.currentTimeMillis();
         sop("������ʱ��" + (end - start) + "����");*/
        /**
         * ����VDO�������㿽��ʱ��
         long start2 = System.currentTimeMillis();
         bufferedCopyVDO();
         long end2 = System.currentTimeMillis();
         sop("����ʱ��" + (end2 - start2) +  "����");
         */
        tranStream();
    }

    public static void outputStream() {
        FileOutputStream fos = null;
        /**
         * �ֽ�������Ҫˢ�£���������Ҫ�ر�
         */
        try {
            fos = new FileOutputStream("Fos.txt");
            //�ֽ���ֻ��Ҫд������Ҫˢ��
            fos.write("�һ�Ŭ��������һ��".getBytes());
        } catch (IOException ioe) {
            //������
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != fos) {
                    fos.close();
                }
            } catch (IOException ioe) {
                //������
                sop("Catch:����ֽ����ر�ʧ�ܣ�" + ioe.toString());
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
                //String��Ĺ��캯�����ȿ��Խ��ַ�������ַ���
                //�ֿ��Խ��ֽ��������ַ���
                sop(new String(buf, 0, len));
            }
        } catch (IOException ioe) {
            //������
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }
            } catch (IOException ioe) {
                //������
                sop("Catch:��ȡ�������ر�ʧ�ܣ�" + ioe.toString());
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
                //�ֽ�������Ҫˢ�£�������Ҫ�ر�
                bufos.write(by);
            }
        } catch (IOException ioe) {
            //������
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != bufis) {
                    bufis.close();
                }
            } catch (IOException ioe) {
                //������
                sop("Catch:�ļ���ȡ�������ر�ʧ�ܣ�" + ioe.toString());
            }

            try {
                if (null != bufos) {
                    bufos.close();
                }
            } catch (IOException ioe) {
                //������
                sop("Catch:�ļ�д��������ر�ʧ�ܣ�" + ioe.toString());
            }
        }
    }

    public static void bufferedCopyVDO() {
        BufferedInputStream bufis = null;
        BufferedOutputStream bufos = null;
        try {
            bufis = new BufferedInputStream(new FileInputStream("C:/Users\\CY_XYZ/Desktop/D_PDD/����.mkv"));
            bufos = new BufferedOutputStream(new FileOutputStream("JavaCopy_����.mkv"));
            int by = 0;
            while (-1 != (by = bufis.read())) {
                //�ֽ�������Ҫˢ�£�������Ҫ�ر�
                bufos.write(by);
            }
        } catch (IOException ioe) {
            //������
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != bufis) {
                    bufis.close();
                }
            } catch (IOException ioe) {
                //������
                sop("Catch:�ļ���ȡ�������ر�ʧ�ܣ�" + ioe.toString());
            }

            try {
                if (null != bufos) {
                    bufos.close();
                }
            } catch (IOException ioe) {
                //������
                sop("Catch:�ļ�д��������ر�ʧ�ܣ�" + ioe.toString());
            }
        }
    }

    public static void tranStream() {
        /**
         * ����̨����¼���ַ�������̨������д��ʽ��ר�ý������over
         * InputStream in = System.in;		//������ָ��������󣬶�̬��
         * InputStreamReader isr = new InputStreamReader(in);
         * BufferedReader bufr = new BufferedReader(isr);
         * //==>BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in))
         *
         * OutputStream out = System.out;
         * OutputStreamWriter osw = new OutputStreamWriter(out);
         * BufferedWriter bufw = new BufferedWriter(osw);
         * //==>BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
         *
         * ��ϵ�������ַ���-->(�ַ���-->ת���ֽ���)-->�ֽ���
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
            //������
            sop("Catch:" + ioe.toString());
        } finally {
            try {
                if (null != bufr) {
                    bufr.close();
                }
            } catch (IOException ioe) {
                //������
                sop("Catch:���̶�ȡ�ر�ʧ��" + ioe.toString());
            }
            try {
                if (null != bufw) {
                    bufw.close();
                }
            } catch (IOException ioe) {
                //������
                sop("Catch:����̨д��ر�ʧ��" + ioe.toString());
            }
        }
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
