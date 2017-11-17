//----------------------------/
/*TreeMapExpend.java���н����
---------------------------
�γ���������,  �γ�������ѧ,  �γ�����Ӣ��,
�÷֣�81.0,  �÷֣�91.0,  �÷֣�71.0,
---------------------------
�γ���������,  �γ�������ѧ,  �γ�����Ӣ��,
�÷֣�81.5,  �÷֣�91.5,  �÷֣�71.5,
---------------------------
�γ���������,  �γ�������ѧ,  �γ�����Ӣ��,
�÷֣�89.0,  �÷֣�99.0,  �÷֣�79.0,
---------------------------
�γ���������,  �γ�������ѧ,  �γ�����Ӣ��,
�÷֣�89.9,  �÷֣�99.9,  �÷֣�79.9,
---------------------------
---------------------------
                        >>>>>>>>�廪��ѧ<<<<<<<<
        ��<1>�����ң�AB
                ��[1]��ѧ��|--A
                        ��(1)�ſγ̣�-->��ѧ���γ̳ɼ���-->81.0
                        ��(2)�ſγ̣�-->���ģ��γ̳ɼ���-->91.0
                        ��(3)�ſγ̣�-->Ӣ��γ̳ɼ���-->71.0
                ��[2]��ѧ��|--B
                        ��(1)�ſγ̣�-->��ѧ���γ̳ɼ���-->81.5
                        ��(2)�ſγ̣�-->���ģ��γ̳ɼ���-->91.5
                        ��(3)�ſγ̣�-->Ӣ��γ̳ɼ���-->71.5
        ��<2>�����ң�CD
                ��[1]��ѧ��|--D
                        ��(1)�ſγ̣�-->��ѧ���γ̳ɼ���-->89.9
                        ��(2)�ſγ̣�-->���ģ��γ̳ɼ���-->99.9
                        ��(3)�ſγ̣�-->Ӣ��γ̳ɼ���-->79.9
                ��[2]��ѧ��|--C
                        ��(1)�ſγ̣�-->��ѧ���γ̳ɼ���-->89.0
                        ��(2)�ſγ̣�-->���ģ��γ̳ɼ���-->99.0
                        ��(3)�ſγ̣�-->Ӣ��γ̳ɼ���-->79.0
---------------------------
�밴���������. . .
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

class HashMapExpend {
    public static void main(String[] args) {
        /* HashMapExpend.java�ļ�������⣺
		 * Map����һ�Զ࣬��ϵǶ��ʾ��
		 * ѧУBAT��2�����ң�RoomA��RoomB
		 *					 ����RoomAB��2��ѧ����ÿ��ѧ����3�ſγ̳ɼ�
		 *					 ����RoomCD��2��ѧ����ÿ��ѧ����3�ſγ̳ɼ�
		 * ����Map����<����, String>�Ĺ�ϵ�ܹ����£�
		 *			Map<course, score>-->Course����
		 *									|
		 *						Map<Course����, studentName>-->Student����
		 *											  |
		 *								 Map<Student����, roomName>-->Room����
		 *										           |
		 *									  Map<Room����, schoolName>-->School����
		 */

        /**
         * ����HashSet��HashMap���洢����ʱ��һ��Ҫȷ������߱��ɱ��ԣ�
         *						 ����д.hashCode()��.equals(Object obj)������
         *						 ע�⣺ƽ��ʹ��String��Integer�ȱ����Ѿ�ʵ���˿ɱ��ԣ���
         * ����TreeSet��TreeMap���洢����ʱ��һ��Ҫȷ������߱�����(�ɱȽ�)�Ĺ���
         *						 ��ʵ��Comparable�ӿڻ�Comparator�ӿڣ�
         *						 ע�⣺ƽ��ʹ��String��Integer�ȱ����Ѿ�ʵ��������Ƚ��ԣ���
         * �����ֻҪ���漰�洢����M�ģ���M.class�и�д.hashCode()��.equals(Object obj)����
         *								��M.class��ʵ��Coparable<T>�ӿڣ���дcompareTo(<T> t)����
         * ��֤����һʧ��Ҳ�����趨����������ıȽ���Comparator<T>
         */
        mapExpendTest();
    }

    public static void mapExpendTest() {
        lineSplit();
        String[] courses = {"����", "��ѧ", "Ӣ��"};
        float[] scoreA = {(float) 81.0, (float) 91.0, (float) 71.0};
        float[] scoreB = {(float) 81.5, (float) 91.5, (float) 71.5};
        float[] scoreC = {(float) 89.0, (float) 99.0, (float) 79.0};
        float[] scoreD = {(float) 89.9, (float) 99.9, (float) 79.9};
        Course courseA = new Course(courses, scoreA);
        Course courseB = new Course(courses, scoreB);
        Course courseC = new Course(courses, scoreC);
        Course courseD = new Course(courses, scoreD);
        StudentHashMap studentB = new StudentHashMap("B", 2013);
        StudentHashMap studentA = new StudentHashMap("A", 2012);
        StudentHashMap studentD = new StudentHashMap("D", 2016);
        StudentHashMap studentC = new StudentHashMap("C", 2011);
        studentB.addCourse(courseB);
        studentA.addCourse(courseA);
        studentD.addCourse(courseD);
        studentC.addCourse(courseC);
        RoomHashMap roomAB = new RoomHashMap("AB");
        RoomHashMap roomCD = new RoomHashMap("CD");
        roomAB.addStudent(studentA);
        roomAB.addStudent(studentB);
        roomCD.addStudent(studentD);
        roomCD.addStudent(studentC);
        SchoolHashMap school = new SchoolHashMap("�廪��ѧ");
        school.addRoom(roomAB);
        school.addRoom(roomCD);
        schoolMapOut(school);
        lineSplit();
    }

    public static void schoolMapOut(SchoolHashMap sch) {
        lineSplit();
        sop("\t\t\t>>>>>>>>" + sch.getSchoolName() + "<<<<<<<<");
        int i = 1;
        for (Iterator<Map.Entry<RoomHashMap, String>> sit = sch.getTm().entrySet().iterator(); sit.hasNext(); i++) {
            Map.Entry<RoomHashMap, String> sme = sit.next();
            RoomHashMap rKey = sme.getKey();
            sop("\t��<" + i + ">�����ң�" + rKey.getRoomName());
            int j = 1;
            for (Iterator<Map.Entry<StudentHashMap, String>> rit = rKey.getTm().entrySet().iterator(); rit.hasNext(); j++) {
                Map.Entry<StudentHashMap, String> rme = rit.next();
                StudentHashMap sKey = rme.getKey();
                sop("\t\t��[" + j + "]��ѧ��|--" + sKey.getStudentName());
                for (Iterator<Map.Entry<Course, String>> stit = sKey.getTm().entrySet().iterator(); stit.hasNext(); ) {
                    Map.Entry<Course, String> stme = stit.next();
                    Course cKey = stme.getKey();
                    int k = 1;
                    for (Iterator<Map.Entry<String, Float>> cit = cKey.getTm().entrySet().iterator(); cit.hasNext(); k++) {
                        Map.Entry<String, Float> cme = cit.next();
                        //String sKey = cme.getKey();
                        sop("\t\t\t��(" + k + ")�ſγ̣�-->" + cme.getKey()
                                + "���γ̳ɼ���-->" + cme.getValue());
                    }
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
 * Course<Courses, scores>������γ̺Ͷ�Ӧ�÷ֵ�Map����
 * ���У��γ̡��÷��ɹ��캯������������������ϸ�ļ���
 */

class Course implements Comparable<Course> {
    private String[] courses;
    private float[] scores;
    //private courseId;
    private HashSet<String> courseTs = new HashSet<String>();

    public Course(String[] courses, float[] scores) {
        for (int i = 0; i < courses.length; i++) {
            sopt("�γ�����" + courses[i] + ",  ");
        }
        sopt("\n");
        for (int i = 0; i < scores.length; i++) {
            sopt("�÷֣�" + scores[i] + ",  ");
        }
        sopt("\n---------------------------\n");
        if (courses.length != scores.length) {
            throw new RuntimeException("�γ̻�ɼ�����ȱʧ�����");
        }
        this.courses = courses;
        this.scores = scores;
        for (int i = 0; i < courses.length; i++) {
            this.courseTs.add(courses[i]);
        }
        if (this.courseTs.size() != scores.length) {
            throw new RuntimeException("�γ����ظ�������");
        }
    }

    public HashMap<String, Float> getTm() {
        HashMap<String, Float> tm = new HashMap<String, Float>();
        int i = 0;
        for (Iterator<String> it = this.getTs().iterator(); it.hasNext(); i++) {
            tm.put(it.next(), this.scores[i]);
        }
        return tm;
    }

    public String[] getCourses() {
        return this.courses;
    }

    public float[] getScores() {
        return this.scores;
    }

    public HashSet<String> getTs() {
        return this.courseTs;
    }

    public void sopt(Object obj) {
        System.out.print(obj);
    }

    public int compareTo(Course c) {
        /**
         * Ĭ��ȫ��������
         */
        return 1;
    }

    public int hashCode() {
        return this.courses.hashCode() + this.scores.hashCode();
    }

    public boolean equals(Object obj) {
        //Course courseTm = (Course) obj;
        return true;
    }
}

/**
 * StudentHashMap�洢<course, studentName>���γ̶�����Ϊ��ҪΨһ
 * ʹ��TreeMap���ϴ洢����
 * ����ʵ��Comparable<T>�ӿڣ���дpublic int compareTo(T t)
 * ʵ��Comparator<T>�ӿڣ���дpublic int compare(T t1, T t2)
 * ʵ��HashMap���ϴ洢����
 * ���븴дpublic int hashCode()��public boolean equals(Object obj)����
 */
class StudentHashMap implements Comparable<StudentHashMap> {
    private String studentName;
    private int studentId;
    private HashSet<Course> studentTs = new HashSet<Course>();

    public StudentHashMap(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public HashSet<Course> getTs() {
        return this.studentTs;
    }

    public HashMap<Course, String> getTm() {
        HashMap<Course, String> tm = new HashMap<Course, String>();
        for (Iterator<Course> it = this.getTs().iterator(); it.hasNext(); ) {
            tm.put(it.next(), this.getStudentName());
        }
        return tm;
    }

    public int compareTo(StudentHashMap stuTm) {
        /**
         * ����studentName����ͬ����Ƚ�studentId
         */
        int temp = this.getStudentName().compareTo(stuTm.getStudentName());
        if (0 != temp) {
            return temp;
        } else {
            return this.getStudentId() - stuTm.getStudentId();
        }
    }

    public int hashCode() {
        return this.getStudentName().hashCode() + this.getStudentId();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StudentHashMap)) {
            throw new RuntimeException("������StudentHashMap���Ƚ�������");
        }
        StudentHashMap stutm = (StudentHashMap) obj;
        return this.getStudentId() == stutm.getStudentId();
    }

    public void addCourse(Course c) {
        this.getTs().add(c);
    }
}

/**
 * RoomHashMap<StudentHashMap, roomName>������HashMap���ϴ洢<ѧ�����󣬽�������>��ѧ��������Ϊ��ҪΨһ
 */
class RoomHashMap implements Comparable<RoomHashMap> {
    private HashSet<StudentHashMap> tsRoom = new HashSet<StudentHashMap>();
    private String roomName;

    public RoomHashMap(String name) {
        this.init(name);
    }

    public void init(String name) {
        this.roomName = name;
    }

    public HashMap<StudentHashMap, String> getTm() {
        HashMap<StudentHashMap, String> tm = new HashMap<StudentHashMap, String>();
        for (Iterator<StudentHashMap> it = this.getTs().iterator(); it.hasNext(); ) {
            tm.put(it.next(), this.getRoomName());
        }
        return tm;
    }

    public HashSet<StudentHashMap> getTs() {
        return this.tsRoom;
    }

    public String getRoomName() {
        return this.roomName;
    }

    /**
     * ���Ұ���roomName����
     */
    public int compareTo(RoomHashMap roomTm) {
        return this.getRoomName().compareTo(roomTm.getRoomName());
    }

    public int hashCode() {
        return this.getRoomName().hashCode();
    }

    public boolean equals(Object obj) {
        RoomHashMap roomTm = (RoomHashMap) obj;
        return this.getRoomName() == roomTm.getRoomName();
    }

    public void addStudent(StudentHashMap studentTs) {
        this.getTs().add(studentTs);
    }

}

/**
 * SchoolHashMap<RoomHashMap, schoolName>��ѧУHashMap���ϴ洢<���Ҷ���ѧУ����>�����Ҷ�����Ϊ��ҪΨһ
 */
class SchoolHashMap implements Comparable<SchoolHashMap> {
    private HashSet<RoomHashMap> tsSchool = new HashSet<RoomHashMap>();
    private String schoolName;

    public SchoolHashMap(String name) {
        this.schoolName = name;
    }

    public HashMap<RoomHashMap, String> getTm() {
        HashMap<RoomHashMap, String> tm = new HashMap<RoomHashMap, String>();
        for (Iterator<RoomHashMap> it = this.getTs().iterator(); it.hasNext(); ) {
            tm.put(it.next(), this.getSchoolName());
        }
        return tm;
    }

    public HashSet<RoomHashMap> getTs() {
        return this.tsSchool;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    /**
     * ѧУ����schoolName����
     */
    public int compareTo(SchoolHashMap schoolTm) {
        return this.getSchoolName().compareTo(schoolTm.getSchoolName());
    }

    public int hashCode() {
        return this.getSchoolName().hashCode();
    }

    public boolean equals(Object obj) {
        SchoolHashMap schoolTm = (SchoolHashMap) obj;
        return this.getSchoolName() == schoolTm.getSchoolName();
    }

    //��Ϊ���͵Ĳ���ֻ��ʹ��һ�������ϲ����޶�Ԫ�����ͣ����߷������޶���Ҫ������Ԫ������
    //���������ķ���Ҫ���������ϻ��߷�����
    //������ֻ��ʹ��һ��������
    public void addRoom(RoomHashMap roomTs) {
        this.getTs().add(roomTs);
    }
}
