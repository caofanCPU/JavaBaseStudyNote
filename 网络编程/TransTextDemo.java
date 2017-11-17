import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TransTextDemo {
    public static void main(String[] args) {
        /**
         * TransTextDemo.java�ļ�������⣺
         * �ͻ��������������һ���ַ����������������ַ����Ĵ�д��ʽ
         * �ͻ��˷��ͽ�����ǣ�overʱ���ͻ��ˣ�����˶�����
         */
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

/**
 * ���󣺽���һ���ı�ת��������
 * �ͻ��˸�����������һ���ı������������ı�ת��Ϊ��д�����ظ��ͻ���
 * ��������Ҫһֱ���������ı�ת�������ͻ�������overʱ��ת������
 * <p>
 * ������
 * �ͻ��ˣ���Ȼ�ǲ����豸�ϵ����ݣ��Ϳ���ʹ��IO����������IO����������˼��
 * Դ������¼�룻Ŀ�ģ����������
 * �����������ı����ݣ����ѡ���ַ���
 * ����ˣ�
 */
/**
 * ������
 *		�ͻ��ˣ���Ȼ�ǲ����豸�ϵ����ݣ��Ϳ���ʹ��IO����������IO����������˼��
 *				Դ������¼�룻Ŀ�ģ����������
 *				�����������ı����ݣ����ѡ���ַ���
 *		����ˣ�
 */

/**
 * �ܽ᣺
 *		���ֵ����⼰ԭ�������
 *		���󣺿ͻ��˺ͷ���˶���Ī���صȴ���
 *		������Ϊ���ͻ��ˡ���������ʹ���� ����ʽ��������Щ����û�ж����������
 *				  ���磺BufferedReader.readLine()������Ĭ����'����'Ϊ�������
 *					    ��ô��.readLine()�������صĲ���'����'������Ҫ.newLine()
 */
class TransTextClient {
    /**
     * �������裺
     * 1.��������
     * 2.����¼���ַ������������棬����¼�뻺��д���������׼����ȡ������������ص�������
     * 3.�رռ��̶������������ر�socket�ͻ��ˣ����ر��˿ͻ�������������+�����
     */
    public static void main(String[] args) throws Exception {
        //�����ͻ��˷���ָ��Ҫ���ӵķ�������IP��ַ���Լ�����˿ں�
        Socket s = new Socket("127.0.0.1", 13140);
        /**
         * �Ӽ��̶�ȡ�ַ���
         * System.inΪ������������ʹ����������ָ��ָ��new InputStreamReader(System.in)
         * ָ����������ָ��Ļ�������new BufferedReader(������ָ��)
         */
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        /**
         * ��������ڱ�����socket�����--д����
         * ��������ڱ�����socket������--������
         */
        BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        /**
         * Ŀ������PrintWriter printOut = new PrintWriter(s.getOutputStream(), true);
         * ���ܲ����ַ��������ܲ����ֽ������Դ����У��Դ�ˢ��
         */

        //���ж�ȡ��ʽ��ȡ������������������line�У����͸������
        String line = null;
        while (null != (line = bufr.readLine())) {
            //�����ж�Ҫ��ִ�У�������� Software caused connection abort: recv failed�쳣
            if ("over".equals(line)) {
                break;
            }
            //�����̶�����ַ���д�뻺�棬ע��BufferedReader.readLine()���ؽ��ȱ���н������
            bufwOut.write(line);
            //����BufferedWriter.newLine()�����н������
            bufwOut.newLine();
            //�ͻ��˷�������������Ϣ���ڻ��棬��ҪBufferedWriter.flush()ˢ�����������
            bufwOut.flush();
            //��ȡ���������ص���Ϣ
            line = bufrIn.readLine();
            sop("��������Ӧ��" + line);
        }
        ;
        //�رռ���������
        bufr.close();
        //�ر�socket����(�ͻ���������)
        s.close();
    }

    public static void sop(Object obj) {
        /**
         * ��ӡ�ַ���
         *
         */
        System.out.println(obj);
    }
}

class TransTextServer {
    /**
     *
     */
    public static void main(String[] args) throws Exception {
        //�������������񣬲�ָ�������˿�new ServerSocket(int port)
        ServerSocket ss = new ServerSocket(13140);
        //��ȡ���ӷ������Ŀͻ��˶���.accept()���ö��󱻷�������ȡ���൱�ڷ������˵Ŀͻ��˾���
        Socket s = ss.accept();
        //����Socket.getInetAddress().getHostAddress()��ȡ�ͻ���IP��ַ
        String ip = s.getInetAddress().getHostAddress();
        //��������ʾ��������Ϸ������Ŀͻ���IP
        sop("�ͻ���" + ip + "��������...");
        /**
         * s.getInputStream()����ȡ�������Ŀͻ���������(�ͻ��˷����������ģ��ο�Ϊ������)
         * ������������ָ��new InputStreamReader(����������)
         * Ϊ������ָ�봴��������ָ��BufferedReader(������ָ��)
         * ����������new BufferedReader(new InputStreamReader(����������))
         *			 new BufferedWriter(new OutputStreamWriter(���������))
         */
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line = null;
        //ע�⣺������.readLine()�����������н������Ϊ�ص���У����Ƿ��ؽ��ʡȥ���н������
        while (null != (line = bufrIn.readLine())) {
            sop("�ͻ���" + ip + "��������ԭʼ����Ϊ��" + line);
            //���ͻ��˷�����ԭʼ���ݽ��д�дת��������ȱ���н������
            bufwOut.write(line.toUpperCase());
            //���û�����д����BufferedWriter.newLine()�������н������
            bufwOut.newLine();
            //BufferedWriter.write()������ֻ�ǽ�����д�뻺��������Ҫʹ��BufferedWriter.flush()����д�������
            bufwOut.flush();
        }
        //�رտͻ��˶���
        sop("�رտͻ���" + ip + "...");
        s.close();
        //�رշ���˶��󣬿�ѡ
        sop("�رշ�����" + ss.getInetAddress().getHostAddress() + "�����˿�" + ss.getLocalPort());
        ss.close();
    }

    public static void sop(Object obj) {
        /**
         * ��ӡ�ַ���
         *
         */
        System.out.println(obj);
    }
}

