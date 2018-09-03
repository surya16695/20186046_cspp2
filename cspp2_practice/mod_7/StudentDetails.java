/**
 * { item_description }.
 */
public final class StudentDetails {
    /**
     * { item_description }.
     */
    private StudentDetails() {
    }
    /**
     * { item_description }.
     */
    private static final double A = 7.5;
    /**
     * { item_description }.
     */
    private static final double B = 7.0;
    /**
     * { item_description }.
     */
    private static final double C = 8.0;
    /**
     * { item_description }.
     */
    private static final double D = 8.5;
    /**
     * { item_description }.
     */
    private static final double E = 6.0;
    /**
     * { item_description }.
     */
    private static final double F = 9.0;
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Student sangay = new Student("Sangay", "IT201985001", A, B, C);
        System.out.println(sangay.calculateGPA());
        Student bidhya = new Student("Bidhya", "IT201985003", D, E, A);
        System.out.println(bidhya.calculateGPA());
        Student kelzang = new Student("Kelzang", "IT201985065", A, C, F);
        System.out.println(kelzang.calculateGPA());
    }
}
/**
 * Class for student.
 */
class Student {
    /**
     * { var_description }.
     */
    private static final int THREE = 3;
    /**
     * { var_description }.
     */
    private String name;
    /**
     * { var_description }.
     */
    private String rollno;
    /**
     * { var_description }.
     */
    private double sub1;
    /**
     * { var_description }.
     */
    private double sub2;
    /**
     * { var_description }.
     */
    private double sub3;
    /**
     * Constructs the object.
     *
     * @param      namee    The name
     * @param      rollnoo  The rollnoo
     * @param      m1       The m 1
     * @param      m2       The m 2
     * @param      m3       The m 3
     */
    Student(final String namee,
                    final String rollnoo,
                    final double m1,
                    final double m2,
                    final double m3) {
        this.name = namee;
        this.rollno = rollnoo;
        this.sub1 = m1;
        this.sub2 = m2;
        this.sub3 = m3;
    }
    /**
     * Calculates the gpa.
     *
     * @return     The gpa.
     */
    double calculateGPA() {
        return (sub1 + sub2 + sub3) / THREE;
    }
}
