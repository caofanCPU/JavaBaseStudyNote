//----------------------------/
/*MapExpend.java���н����
---------------------------
>>>>>>>>�廪��ѧ<<<<<<<<
        ��<1>�����ң�RoomCD
                ��[1]��ѧ��|--studentC
                        ��(1)�ſγ̣�-->��ѧ���γ̳ɼ���-->92.0
                        ��(2)�ſγ̣�-->���ģ��γ̳ɼ���-->98.2
                        ��(3)�ſγ̣�-->Ӣ��γ̳ɼ���-->75.5
                ��[2]��ѧ��|--studentD
                        ��(1)�ſγ̣�-->��ѧ���γ̳ɼ���-->99.0
                        ��(2)�ſγ̣�-->���ģ��γ̳ɼ���-->65.2
                        ��(3)�ſγ̣�-->Ӣ��γ̳ɼ���-->95.5
        ��<2>�����ң�RoomAB
                ��[1]��ѧ��|--studentA
                        ��(1)�ſγ̣�-->��ѧ���γ̳ɼ���-->100.0
                        ��(2)�ſγ̣�-->���ģ��γ̳ɼ���-->90.2
                        ��(3)�ſγ̣�-->Ӣ��γ̳ɼ���-->90.5
                ��[2]��ѧ��|--studentB
                        ��(1)�ſγ̣�-->��ѧ���γ̳ɼ���-->85.0
                        ��(2)�ſγ̣�-->���ģ��γ̳ɼ���-->85.2
                        ��(3)�ſγ̣�-->Ӣ��γ̳ɼ���-->75.5
---------------------------
�밴���������. . .
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MapExpend {
    public static void main(String[] args) {
        /* MapExpend.java�ļ�������⣺
		 * Map����һ�Զ࣬��ϵǶ��ʾ��
		 * ѧУBAT��2�����ң�RoomA��RoomB
		 *					 ����RoomAB��2��ѧ����ÿ��ѧ����3�ſγ̳ɼ�
		 *					 ����RoomCD��2��ѧ����ÿ��ѧ����3�ſγ̳ɼ�
		 */
        //����4��ѧ����ѧ��ΪTreeMap���ϣ�����Ԫ��<"�γ�", (float)�÷�>
        StudentMapQT studentATm = new StudentMapQT("studentA");
        studentATm.stuCreate((float) 90.20, (float) 100.00, (float) 90.50);
        StudentMapQT studentBTm = new StudentMapQT("studentB");
        studentBTm.stuCreate((float) 85.20, (float) 85.00, (float) 75.50);
        StudentMapQT studentCTm = new StudentMapQT("studentC");
        studentCTm.stuCreate((float) 98.20, (float) 92.00, (float) 75.50);
        StudentMapQT studentDTm = new StudentMapQT("studentD");
        studentDTm.stuCreate((float) 65.20, (float) 99.00, (float) 95.50);
        //����2���༶���༶ΪTreeMap���ϣ�����Ԫ��Ϊ<"�༶����", ѧ������<TreeMap<String, Float>>>
        RoomMapQT<StudentMapQT> roomABTm = new RoomMapQT<StudentMapQT>("RoomAB");
        roomABTm.addStudent(studentATm);
        roomABTm.addStudent(studentBTm);
        RoomMapQT<StudentMapQT> roomCDTm = new RoomMapQT<StudentMapQT>("RoomCD");
        roomCDTm.addStudent(studentCTm);
        roomCDTm.addStudent(studentDTm);
        //����1��ѧУ��ѧУΪTreeMap���ϣ�����Ԫ��Ϊ<"ѧУ����", �༶����<"�༶����", ѧ������<TreeMap<String, Float>>>>
        SchoolMapQT<RoomMapQT> schoolTm = new SchoolMapQT<RoomMapQT>("�廪��ѧ");
        schoolTm.addRoom(roomABTm);
        schoolTm.addRoom(roomCDTm);
        //
        schoolHashMap(schoolTm);
        lineSplit();
    }

    public static void schoolHashMap(SchoolMapQT<RoomMapQT> sch) {
        lineSplit();
        sop(">>>>>>>>" + sch.getSchoolName() + "<<<<<<<<");
        int i = 1;
        for (Iterator<Map.Entry<RoomMapQT, String>> sit = sch.getTm().entrySet().iterator(); sit.hasNext(); i++) {
            Map.Entry<RoomMapQT, String> sme = sit.next();
            RoomMapQT rKey = sme.getKey();
            sop("\t��<" + i + ">�����ң�" + rKey.getRoomName());
            int j = 1;
            for (Iterator<Map.Entry<StudentMapQT, String>> rit = rKey.getTm().entrySet().iterator(); rit.hasNext(); j++) {
                Map.Entry<StudentMapQT, String> rme = rit.next();
                StudentMapQT sKey = rme.getKey();
                sop("\t\t��[" + j + "]��ѧ��|--" + sKey.getStudentName());
                int k = 1;
                for (Iterator<Map.Entry<String, Float>> stit = sKey.getTm().entrySet().iterator(); stit.hasNext(); k++) {
                    Map.Entry<String, Float> stme = stit.next();
                    sop("\t\t\t��(" + k + ")�ſγ̣�-->" + stme.getKey()
                            + "���γ̳ɼ���-->" + stme.getValue());
                }
            }
        }
    }

    public static void sop(Object obj) {
		/* ��ӡ�ַ���
		*  
		*/
        System.out.println(obj);
    }

    public static void lineSplit() {
		/* ��ӡ�ָ���
		*  
		*/
        sop("---------------------------");
    }
}

/**
 * StudentMapQT�洢<�γ̶���, �÷�>���γ̶�����Ϊ��ҪΨһ
 * ʹ��TreeMap���ϴ洢���󣬱���ʵ��Comparable��ӱȽ���
 * ʵ��HashMap���ϴ洢���󣬱��븴д.hashCode()��.equals()����
 */
class StudentMapQT /*implements Comparable*/ {
    private HashMap<String, Float> tmSource = new HashMap<String, Float>();
    private String studentName;

    public StudentMapQT(String name) {
        tmSource.put("����", (float) 0);
        tmSource.put("��ѧ", (float) 0);
        tmSource.put("Ӣ��", (float) 0);
        studentName = name;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public HashMap<String, Float> getTm() {
        return tmSource;
    }

    /**
     * Ϊѧ����ʼ�����Ƴɼ����˴���Ҫ����ϰMap.Eentry().iterator().next().setValue(value)�������滻����ֵ
     */

    public void stuCreate(float f1, float f2, float f3) {
        this.getTm().putAll(tmSource);
        for (Iterator<Map.Entry<String, Float>> entry = this.getTm().entrySet().iterator(); entry.hasNext(); ) {
            Map.Entry<String, Float> me = entry.next();
            if ("����" == me.getKey()) {
                me.setValue(f1);
            }
            if ("��ѧ" == me.getKey()) {
                me.setValue(f2);
            }
            if ("Ӣ��" == me.getKey()) {
                me.setValue(f3);
            }
        }
    }
}

/**
 * RoomMapQT<StudentMapQT>������TreeMap���ϴ洢<ѧ�����󣬽�������>��ѧ��������Ϊ��ҪΨһ
 */
class RoomMapQT<StudentMapQT> {
    private HashMap<StudentMapQT, String> tmSource = new HashMap<StudentMapQT, String>();
    private String roomName;

    public RoomMapQT(String name) {
        this.init(name);
    }

    public void init(String name) {
        this.roomName = name;
    }

    public HashMap<StudentMapQT, String> getTm() {
        return this.tmSource;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void addStudent(StudentMapQT stuTm) {
        this.getTm().put(stuTm, this.getRoomName());
    }
}

/**
 * SchoolMapQT<RoomMapQT>��ѧУTreeMap���ϴ洢<���Ҷ���ѧУ����>�����Ҷ�����Ϊ��ҪΨһ
 */
class SchoolMapQT<RoomMapQT> {
    private HashMap<RoomMapQT, String> tmSource = new HashMap<RoomMapQT, String>();
    private String schoolName;

    public SchoolMapQT(String name) {
        this.schoolName = name;
    }

    public HashMap<RoomMapQT, String> getTm() {
        return this.tmSource;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    //��Ϊ���͵Ĳ���ֻ��ʹ��һ�������ϲ����޶�Ԫ�����ͣ����߷������޶���Ҫ������Ԫ������
    //���������ķ���Ҫ���������ϻ��߷�����
    public void addRoom(RoomMapQT roomTm) {
        this.getTm().put(roomTm, this.getSchoolName());
    }
}