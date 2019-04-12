package StudentManager;

public class Student {
    private String name;
    private String stdId;
    private String birth;
    private String gender;
    public Student() {
 
    }
    public Student(String stdId, String name, String birth, String gender) {
        super();
        this.name = name;
        this.stdId = stdId;
        this.birth = birth;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStdId() {
        return stdId;
    }
    public void setStdId(String stdId) {
        this.stdId = stdId;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
}

