//----------------------------/
/*TreeMapExpend.java运行结果：
---------------------------
课程名：语文,  课程名：数学,  课程名：英语,
得分：81.0,  得分：91.0,  得分：71.0,
---------------------------
课程名：语文,  课程名：数学,  课程名：英语,
得分：81.5,  得分：91.5,  得分：71.5,
---------------------------
课程名：语文,  课程名：数学,  课程名：英语,
得分：89.0,  得分：99.0,  得分：79.0,
---------------------------
课程名：语文,  课程名：数学,  课程名：英语,
得分：89.9,  得分：99.9,  得分：79.9,
---------------------------
---------------------------
                        >>>>>>>>清华大学<<<<<<<<
        第<1>个教室：AB
                第[1]个学生|--A
                        第(1)门课程：-->数学，课程成绩：-->81.0
                        第(2)门课程：-->英语，课程成绩：-->91.0
                        第(3)门课程：-->语文，课程成绩：-->71.0
                第[2]个学生|--B
                        第(1)门课程：-->数学，课程成绩：-->81.5
                        第(2)门课程：-->英语，课程成绩：-->91.5
                        第(3)门课程：-->语文，课程成绩：-->71.5
        第<2>个教室：CD
                第[1]个学生|--C
                        第(1)门课程：-->数学，课程成绩：-->89.0
                        第(2)门课程：-->英语，课程成绩：-->99.0
                        第(3)门课程：-->语文，课程成绩：-->79.0
                第[2]个学生|--D
                        第(1)门课程：-->数学，课程成绩：-->89.9
                        第(2)门课程：-->英语，课程成绩：-->99.9
                        第(3)门课程：-->语文，课程成绩：-->79.9
---------------------------
请按任意键继续. . .
*/

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class TreeMapExpend {
    public static void main(String[] args) {
        /* TreeMapExpend.java文件解决问题：
		 * Map集合一对多，关系嵌套示例，使用TreeMap存储对象元素，并排序输出
		 * 学校BAT有2个教室：RoomA，RoomB
		 *					 教室RoomAB有2个学生，每个学生有3门课程成绩
		 *					 教室RoomCD有2个学生，每个学生有3门课程成绩
		 * 采用Map集合<对象, String>的关系架构如下：
		 *			Map<course, score>-->Course对象
		 *									|
		 *						Map<Course对象, studentName>-->Student对象
		 *											  |
		 *								 Map<Student对象, roomName>-->Room对象
		 *										           |
		 *									  Map<Room对象, schoolName>-->School对象
		 */

        /**
         * 对于HashSet、HashMap，存储对象时，一定要确保对象具备可比性：
         *						 即复写.hashCode()和.equals(Object obj)方法，
         *						 注意：平常使用String、Integer等本身已经实现了可比性！！
         * 对于TreeSet、TreeMap，存储对象时，一定要确保对象具备排序(可比较)的规则
         *						 即实现Comparable接口或Comparator接口，
         *						 注意：平常使用String、Integer等本身已经实现了排序比较性！！
         * 因而：只要是涉及存储对象M的，在M.class中复写.hashCode()和.equals(Object obj)方法
         *								在M.class中实现Coparable<T>接口，复写compareTo(<T> t)方法
         * 保证万无一失！也可以设定多个排序规则的比较器Comparator<T>
         */
        mapExpendTest();
    }

    public static void mapExpendTest() {
        lineSplit();
        String[] courses = {"语文", "数学", "英语"};
        float[] scoreA = {(float) 81.0, (float) 91.0, (float) 71.0};
        float[] scoreB = {(float) 81.5, (float) 91.5, (float) 71.5};
        float[] scoreC = {(float) 89.0, (float) 99.0, (float) 79.0};
        float[] scoreD = {(float) 89.9, (float) 99.9, (float) 79.9};
        Course courseA = new Course(courses, scoreA);
        Course courseB = new Course(courses, scoreB);
        Course courseC = new Course(courses, scoreC);
        Course courseD = new Course(courses, scoreD);
        StudentTreeMap studentB = new StudentTreeMap("B", 2013);
        StudentTreeMap studentA = new StudentTreeMap("A", 2012);
        StudentTreeMap studentD = new StudentTreeMap("D", 2016);
        StudentTreeMap studentC = new StudentTreeMap("C", 2011);
        studentB.addCourse(courseB);
        studentA.addCourse(courseA);
        studentD.addCourse(courseD);
        studentC.addCourse(courseC);
        RoomTreeMap roomAB = new RoomTreeMap("AB");
        RoomTreeMap roomCD = new RoomTreeMap("CD");
        roomAB.addStudent(studentA);
        roomAB.addStudent(studentB);
        roomCD.addStudent(studentD);
        roomCD.addStudent(studentC);
        SchoolTreeMap school = new SchoolTreeMap("清华大学");
        school.addRoom(roomAB);
        school.addRoom(roomCD);
        schoolMapOut(school);
        lineSplit();
    }

    public static void schoolMapOut(SchoolTreeMap sch) {
        lineSplit();
        sop("\t\t\t>>>>>>>>" + sch.getSchoolName() + "<<<<<<<<");
        int i = 1;
        for (Iterator<Map.Entry<RoomTreeMap, String>> sit = sch.getTm().entrySet().iterator(); sit.hasNext(); i++) {
            Map.Entry<RoomTreeMap, String> sme = sit.next();
            RoomTreeMap rKey = sme.getKey();
            sop("\t第<" + i + ">个教室：" + rKey.getRoomName());
            int j = 1;
            for (Iterator<Map.Entry<StudentTreeMap, String>> rit = rKey.getTm().entrySet().iterator(); rit.hasNext(); j++) {
                Map.Entry<StudentTreeMap, String> rme = rit.next();
                StudentTreeMap sKey = rme.getKey();
                sop("\t\t第[" + j + "]个学生|--" + sKey.getStudentName());
                for (Iterator<Map.Entry<Course, String>> stit = sKey.getTm().entrySet().iterator(); stit.hasNext(); ) {
                    Map.Entry<Course, String> stme = stit.next();
                    Course cKey = stme.getKey();
                    int k = 1;
                    for (Iterator<Map.Entry<String, Float>> cit = cKey.getTm().entrySet().iterator(); cit.hasNext(); k++) {
                        Map.Entry<String, Float> cme = cit.next();
                        //String sKey = cme.getKey();
                        sop("\t\t\t第(" + k + ")门课程：-->" + cme.getKey()
                                + "，课程成绩：-->" + cme.getValue());
                    }
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
 * Course<Courses, scores>，保存课程和对应得分的Map集合
 * 其中，课程、得分由构造函数决定，对其进行了严格的检验
 */

class Course implements Comparable<Course> {
    private String[] courses;
    private float[] scores;
    //private courseId;
    private TreeSet<String> courseTs = new TreeSet<String>();

    public Course(String[] courses, float[] scores) {
        for (int i = 0; i < courses.length; i++) {
            sopt("课程名：" + courses[i] + ",  ");
        }
        sopt("\n");
        for (int i = 0; i < scores.length; i++) {
            sopt("得分：" + scores[i] + ",  ");
        }
        sopt("\n---------------------------\n");
        if (courses.length != scores.length) {
            throw new RuntimeException("课程或成绩存在缺失项，请检查");
        }
        this.courses = courses;
        this.scores = scores;
        for (int i = 0; i < courses.length; i++) {
            this.courseTs.add(courses[i]);
        }
        if (this.courseTs.size() != scores.length) {
            throw new RuntimeException("课程名重复，请检查");
        }
    }

    public TreeMap<String, Float> getTm() {
        TreeMap<String, Float> tm = new TreeMap<String, Float>();
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

    public TreeSet<String> getTs() {
        return this.courseTs;
    }

    public void sopt(Object obj) {
        System.out.print(obj);
    }

    public int compareTo(Course c) {
        /**
         * 默认全增序排列
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
 * StudentTreeMap存储<course, studentName>，课程对象作为键要唯一
 * 使用TreeMap集合存储对象：
 * 必须实现Comparable<T>接口，复写public int compareTo(T t)
 * 实现Comparator<T>接口，复写public int compare(T t1, T t2)
 * 实用HashMap集合存储对象：
 * 必须复写public int hashCode()和public boolean equals(Object obj)方法
 */
class StudentTreeMap implements Comparable<StudentTreeMap> {
    private String studentName;
    private int studentId;
    private TreeSet<Course> studentTs = new TreeSet<Course>();

    public StudentTreeMap(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public TreeSet<Course> getTs() {
        return this.studentTs;
    }

    public TreeMap<Course, String> getTm() {
        TreeMap<Course, String> tm = new TreeMap<Course, String>();
        for (Iterator<Course> it = this.getTs().iterator(); it.hasNext(); ) {
            tm.put(it.next(), this.getStudentName());
        }
        return tm;
    }

    public int compareTo(StudentTreeMap stuTm) {
        /**
         * 按照studentName排序，同名则比较studentId
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
        if (!(obj instanceof StudentTreeMap)) {
            throw new RuntimeException("对象不是StudentTreeMap，比较无意义");
        }
        StudentTreeMap stutm = (StudentTreeMap) obj;
        return this.getStudentId() == stutm.getStudentId();
    }

    public void addCourse(Course c) {
        this.getTs().add(c);
    }
}

/**
 * RoomTreeMap<StudentTreeMap, roomName>，教室TreeMap集合存储<学生对象，教室名称>，学生对象作为键要唯一
 */
class RoomTreeMap implements Comparable<RoomTreeMap> {
    private TreeSet<StudentTreeMap> tsRoom = new TreeSet<StudentTreeMap>();
    private String roomName;

    public RoomTreeMap(String name) {
        this.init(name);
    }

    public void init(String name) {
        this.roomName = name;
    }

    public TreeMap<StudentTreeMap, String> getTm() {
        TreeMap<StudentTreeMap, String> tm = new TreeMap<StudentTreeMap, String>();
        for (Iterator<StudentTreeMap> it = this.getTs().iterator(); it.hasNext(); ) {
            tm.put(it.next(), this.getRoomName());
        }
        return tm;
    }

    public TreeSet<StudentTreeMap> getTs() {
        return this.tsRoom;
    }

    public String getRoomName() {
        return this.roomName;
    }

    /**
     * 教室按照roomName排序
     */
    public int compareTo(RoomTreeMap roomTm) {
        return this.getRoomName().compareTo(roomTm.getRoomName());
    }

    public int hashCode() {
        return this.getRoomName().hashCode();
    }

    public boolean equals(Object obj) {
        RoomTreeMap roomTm = (RoomTreeMap) obj;
        return this.getRoomName() == roomTm.getRoomName();
    }

    public void addStudent(StudentTreeMap studentTs) {
        this.getTs().add(studentTs);
    }

}

/**
 * SchoolTreeMap<RoomTreeMap, schoolName>，学校TreeMap集合存储<教室对象，学校名称>，教室对象作为键要唯一
 */
class SchoolTreeMap implements Comparable<SchoolTreeMap> {
    private TreeSet<RoomTreeMap> tsSchool = new TreeSet<RoomTreeMap>();
    private String schoolName;

    public SchoolTreeMap(String name) {
        this.schoolName = name;
    }

    public TreeMap<RoomTreeMap, String> getTm() {
        TreeMap<RoomTreeMap, String> tm = new TreeMap<RoomTreeMap, String>();
        for (Iterator<RoomTreeMap> it = this.getTs().iterator(); it.hasNext(); ) {
            tm.put(it.next(), this.getSchoolName());
        }
        return tm;
    }

    public TreeSet<RoomTreeMap> getTs() {
        return this.tsSchool;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    /**
     * 学校按照schoolName排序
     */
    public int compareTo(SchoolTreeMap schoolTm) {
        return this.getSchoolName().compareTo(schoolTm.getSchoolName());
    }

    public int hashCode() {
        return this.getSchoolName().hashCode();
    }

    public boolean equals(Object obj) {
        SchoolTreeMap schoolTm = (SchoolTreeMap) obj;
        return this.getSchoolName() == schoolTm.getSchoolName();
    }

    //作为泛型的参数只能使用一个，集合才能限定元素类型，或者泛型类限定所要操作的元素类型
    //方法操作的泛型要定义在类上或者方法上
    //泛型类只能使用一个尖括号
    public void addRoom(RoomTreeMap roomTs) {
        this.getTs().add(roomTs);
    }
}
