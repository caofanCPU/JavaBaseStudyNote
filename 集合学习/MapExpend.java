//----------------------------/
/*MapExpend.java运行结果：
---------------------------
>>>>>>>>清华大学<<<<<<<<
        第<1>个教室：RoomCD
                第[1]个学生|--studentC
                        第(1)门课程：-->数学，课程成绩：-->92.0
                        第(2)门课程：-->语文，课程成绩：-->98.2
                        第(3)门课程：-->英语，课程成绩：-->75.5
                第[2]个学生|--studentD
                        第(1)门课程：-->数学，课程成绩：-->99.0
                        第(2)门课程：-->语文，课程成绩：-->65.2
                        第(3)门课程：-->英语，课程成绩：-->95.5
        第<2>个教室：RoomAB
                第[1]个学生|--studentA
                        第(1)门课程：-->数学，课程成绩：-->100.0
                        第(2)门课程：-->语文，课程成绩：-->90.2
                        第(3)门课程：-->英语，课程成绩：-->90.5
                第[2]个学生|--studentB
                        第(1)门课程：-->数学，课程成绩：-->85.0
                        第(2)门课程：-->语文，课程成绩：-->85.2
                        第(3)门课程：-->英语，课程成绩：-->75.5
---------------------------
请按任意键继续. . .
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class MapExpend {
    public static void main(String[] args) {
        /* MapExpend.java文件解决问题：
		 * Map集合一对多，关系嵌套示例
		 * 学校BAT有2个教室：RoomA，RoomB
		 *					 教室RoomAB有2个学生，每个学生有3门课程成绩
		 *					 教室RoomCD有2个学生，每个学生有3门课程成绩
		 */
        //创建4个学生，学生为TreeMap集合，保存元素<"课程", (float)得分>
        StudentMapQT studentATm = new StudentMapQT("studentA");
        studentATm.stuCreate((float) 90.20, (float) 100.00, (float) 90.50);
        StudentMapQT studentBTm = new StudentMapQT("studentB");
        studentBTm.stuCreate((float) 85.20, (float) 85.00, (float) 75.50);
        StudentMapQT studentCTm = new StudentMapQT("studentC");
        studentCTm.stuCreate((float) 98.20, (float) 92.00, (float) 75.50);
        StudentMapQT studentDTm = new StudentMapQT("studentD");
        studentDTm.stuCreate((float) 65.20, (float) 99.00, (float) 95.50);
        //创建2个班级，班级为TreeMap集合，保存元素为<"班级名称", 学生对象<TreeMap<String, Float>>>
        RoomMapQT<StudentMapQT> roomABTm = new RoomMapQT<StudentMapQT>("RoomAB");
        roomABTm.addStudent(studentATm);
        roomABTm.addStudent(studentBTm);
        RoomMapQT<StudentMapQT> roomCDTm = new RoomMapQT<StudentMapQT>("RoomCD");
        roomCDTm.addStudent(studentCTm);
        roomCDTm.addStudent(studentDTm);
        //创建1个学校，学校为TreeMap集合，保存元素为<"学校名称", 班级对象<"班级名称", 学生对象<TreeMap<String, Float>>>>
        SchoolMapQT<RoomMapQT> schoolTm = new SchoolMapQT<RoomMapQT>("清华大学");
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
            sop("\t第<" + i + ">个教室：" + rKey.getRoomName());
            int j = 1;
            for (Iterator<Map.Entry<StudentMapQT, String>> rit = rKey.getTm().entrySet().iterator(); rit.hasNext(); j++) {
                Map.Entry<StudentMapQT, String> rme = rit.next();
                StudentMapQT sKey = rme.getKey();
                sop("\t\t第[" + j + "]个学生|--" + sKey.getStudentName());
                int k = 1;
                for (Iterator<Map.Entry<String, Float>> stit = sKey.getTm().entrySet().iterator(); stit.hasNext(); k++) {
                    Map.Entry<String, Float> stme = stit.next();
                    sop("\t\t\t第(" + k + ")门课程：-->" + stme.getKey()
                            + "，课程成绩：-->" + stme.getValue());
                }
            }
        }
    }

    public static void sop(Object obj) {
		/* 打印字符串
		*  
		*/
        System.out.println(obj);
    }

    public static void lineSplit() {
		/* 打印分隔符
		*  
		*/
        sop("---------------------------");
    }
}

/**
 * StudentMapQT存储<课程对象, 得分>，课程对象作为键要唯一
 * 使用TreeMap集合存储对象，必须实现Comparable或加比较器
 * 实用HashMap集合存储对象，必须复写.hashCode()和.equals()方法
 */
class StudentMapQT /*implements Comparable*/ {
    private HashMap<String, Float> tmSource = new HashMap<String, Float>();
    private String studentName;

    public StudentMapQT(String name) {
        tmSource.put("语文", (float) 0);
        tmSource.put("数学", (float) 0);
        tmSource.put("英语", (float) 0);
        studentName = name;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public HashMap<String, Float> getTm() {
        return tmSource;
    }

    /**
     * 为学生初始化各科成绩，此处主要是练习Map.Eentry().iterator().next().setValue(value)方法，替换键的值
     */

    public void stuCreate(float f1, float f2, float f3) {
        this.getTm().putAll(tmSource);
        for (Iterator<Map.Entry<String, Float>> entry = this.getTm().entrySet().iterator(); entry.hasNext(); ) {
            Map.Entry<String, Float> me = entry.next();
            if ("语文" == me.getKey()) {
                me.setValue(f1);
            }
            if ("数学" == me.getKey()) {
                me.setValue(f2);
            }
            if ("英语" == me.getKey()) {
                me.setValue(f3);
            }
        }
    }
}

/**
 * RoomMapQT<StudentMapQT>，教室TreeMap集合存储<学生对象，教室名称>，学生对象作为键要唯一
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
 * SchoolMapQT<RoomMapQT>，学校TreeMap集合存储<教室对象，学校名称>，教室对象作为键要唯一
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

    //作为泛型的参数只能使用一个，集合才能限定元素类型，或者泛型类限定所要操作的元素类型
    //方法操作的泛型要定义在类上或者方法上
    public void addRoom(RoomMapQT roomTm) {
        this.getTm().put(roomTm, this.getSchoolName());
    }
}