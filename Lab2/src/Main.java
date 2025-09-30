import java.util.*;

public class Main {


    public static void printByFaculty(Student[] students, String faculty) {
        boolean found = false;
        System.out.println("\nСтуденти факультету " + faculty + ":");
        for (Student s : students) {
            if (s.getFaculty().equalsIgnoreCase(faculty)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("За таким факультетом нічого не знайдено.");
        }
    }

    public static void printBornAfter(Student[] students, int year) {
        boolean found = false;
        System.out.println("\nСтуденти, народжені після " + year + " року:");
        for (Student s : students) {
            int birthYear = Integer.parseInt(s.getBirthDate().substring(0, 4));
            if (birthYear > year) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Студентів народжених після " + year + " у списку не знайдено!");
        }
    }

    public static void printByGroup(Student[] students, String group) {
        boolean found = false;
        System.out.println("\nСтуденти групи (пошук за \"" + group + "\"):");
        for (Student s : students) {
            if (s.getGroup().toLowerCase().startsWith(group.toLowerCase())) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("За такою групою нічого не знайдено.");
        }
    }

    public static Set<String> getFaculties(Student[] students) {
        Set<String> faculties = new HashSet<>();
        for (Student s : students) {
            faculties.add(s.getFaculty());
        }
        return faculties;
    }

    public static Set<String> getGroups(Student[] students) {
        Set<String> groups = new HashSet<>();
        for (Student s : students) {
            groups.add(s.getGroup());
        }
        return groups;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = Student.getDefaultStudents();

        while (true) {
            System.out.println("\n===== МЕНЮ =====");
            System.out.println("1. Вивести студентів за факультетом");
            System.out.println("2. Вивести студентів, народжених після року");
            System.out.println("3. Вивести студентів за групою");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Невірний ввід! Спробуйте ще раз.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Доступні факультети:");
                    for (String f : getFaculties(students)) {
                        System.out.println(" - " + f);
                    }
                    System.out.print("Введіть факультет: ");
                    String faculty = sc.nextLine();
                    printByFaculty(students, faculty);
                    break;

                case 2:
                    System.out.print("Введіть рік: ");
                    try {
                        int year = Integer.parseInt(sc.nextLine());
                        printBornAfter(students, year);
                    } catch (Exception e) {
                        System.out.println("Невірний рік!");
                    }
                    break;

                case 3:
                    System.out.println("Доступні групи:");
                    for (String g : getGroups(students)) {
                        System.out.println(" - " + g);
                    }
                    System.out.print("Введіть групу: ");
                    String group = sc.nextLine();
                    printByGroup(students, group);
                    break;

                case 0:
                    System.out.println("Вихід з програми...");
                    sc.close();
                    return;

                default:
                    System.out.println("Невірний вибір!");
            }
        }
    }
}
