public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String birthDate; // формат: YYYY-MM-DD
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    public Student(int id, String lastName, String firstName, String patronymic,
                   String birthDate, String address, String phone,
                   String faculty, int course, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public void setValue(String field, Object value) {
        switch (field.toLowerCase()) {
            case "id": this.id = (int) value; break;
            case "lastname": this.lastName = (String) value; break;
            case "firstname": this.firstName = (String) value; break;
            case "patronymic": this.patronymic = (String) value; break;
            case "birthdate": this.birthDate = (String) value; break;
            case "address": this.address = (String) value; break;
            case "phone": this.phone = (String) value; break;
            case "faculty": this.faculty = (String) value; break;
            case "course": this.course = (int) value; break;
            case "group": this.group = (String) value; break;
            default: System.out.println("Невірне поле: " + field);
        }
    }

    public Object getValue(String field) {
        switch (field.toLowerCase()) {
            case "id": return id;
            case "lastname": return lastName;
            case "firstname": return firstName;
            case "patronymic": return patronymic;
            case "birthdate": return birthDate;
            case "address": return address;
            case "phone": return phone;
            case "faculty": return faculty;
            case "course": return course;
            case "group": return group;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return id + ". " + lastName + " " + firstName + " " + patronymic +
                ", нар. " + birthDate +
                ", факультет: " + faculty +
                ", курс: " + course +
                ", група: " + group;
    }

    public String getFaculty() { return faculty; }
    public String getBirthDate() { return birthDate; }
    public String getGroup() { return group; }

    public static Student[] getDefaultStudents() {
        return new Student[] {
                new Student(1, "Шевченко", "Ірина", "Павлівна", "2002-05-14",
                        "Київ", "380111111", "ІАДР", 2, "АП-21"),
                new Student(2, "Литвиненко", "Олег", "Вікторович", "2000-09-23",
                        "Львів", "380222222", "ІКТА", 3, "ЕОМ-31"),
                new Student(3, "Сидоренко", "Марія", "Петрівна", "2003-01-10",
                        "Одеса", "380333333", "ІКТА", 1, "ЕОМ-11"),
                new Student(4, "Коваль", "Анна", "Сергіївна", "2001-12-01",
                        "Харків", "380444444", "ІКНІ", 4, "ОС-41")
        };
    }
}
