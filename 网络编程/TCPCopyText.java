import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class TCPCopyText {
    public static void main(String[] args) {
        /**
         * TCPCopyText.java�ļ�������⣺
         * ʹ��TCP���ͻ��˵��ı��ļ��ϴ���������
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

class TCPCopyTextServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(12121);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        sop("�ͻ���" + ip + "��������...");
        File textFile = new File("TCPCopyText.txt");
        BufferedWriter bufw = new BufferedWriter(new FileWriter(textFile));
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line = null;
        int i = 1;
        //bufrIn.readLine()���ҽ�������ȡ����ĩβʱ���ŷ���null
        while (null != (line = bufrIn.readLine())) {
            bufw.write("[" + i + "]    " + line);
            bufw.newLine();
            bufw.flush();
            i++;
        }
        /**
         * BufferedWriter.write()����������ʹ��3����
         * ��һ����д��Ŀ���ַ���
         * �ڶ����������н������
         * �������������������ˢ�������������
         * ����������������ͻ��˵�������������н���������δ�رտͻ��˾���ҲΪ�رշ���������
         * �ڿͻ���ִ��.readLine()ʱ����Ϊ��ȡ�����н�����ǣ��Ӷ�һֱ������ֱ��java.net.SocketException: Connection reset
         */
        bufwOut.write("�ļ��ϴ��ɹ���");
        bufwOut.newLine();
        bufwOut.flush();

        bufw.close();
        s.close();        //�رտͻ��˾��񣬹رպ�ͻ�����������������Ӳ�������ֹ
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

class TCPCopyTextClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 12121);
        File textFile = new File("TCPCopyText.java");
        BufferedReader bufr = new BufferedReader(new FileReader(textFile));
        BufferedWriter bufwOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //���ж�ȡ��ʽ��ȡ�ı��ļ�
        String line = null;
        /**
         * whileѭ�����һ�Σ�bufr.readLine()�����ļ�β�����δ���������
         * ��ȱ�ٽ�����ǣ��������ܿ�������
         * �����ʹ��Socket.shotDownOutput()��������������������������ĩβ
         */
        while (null != (line = bufr.readLine())) {
            //���ı��ļ���ÿ��(δ�����н������)д�������������
            bufwOut.write(line);
            //�����н������
            bufwOut.newLine();
            //�����������������ˢ������������Դ�ͨ���������͸�������
            bufwOut.flush();
        }
        //�ͻ����ϴ��ļ����ݽ����󣬸�����������"�����ĩβ"���
        s.shutdownOutput();
        line = bufrIn.readLine();
        sop(line);
        //�ر���
        bufr.close();
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