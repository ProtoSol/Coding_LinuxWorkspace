public class StudentMarkSheet {
    // Initializing variables in the function
    private int rollNo;
    private String name;
    private int[] subjectMarks;
    private int totalMarks;
    private double percentage;
    private char grade;

    // Setting the values of the variables.
    public StudentMarkSheet(int rollNo, String name, int[] subjectMarks) {
        this.rollNo = rollNo;
        this.name = name;
        this.subjectMarks = subjectMarks;
        calculateTotalMarks();
        calculatePercentage();
        calculateGrade();
    }

    // Functions to calculate other parameters
    private void calculateTotalMarks() {
        int sum = 0;
        for (int mark : subjectMarks) {
            sum += mark;
        }
        totalMarks = sum;
    }

    private void calculatePercentage() {
        int maxMarks = subjectMarks.length * 100;
        percentage = (double) totalMarks / maxMarks * 100;
    }

    private void calculateGrade() {
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }
    
    // Getter functions
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int[] getSubjectMarks() {
        return subjectMarks;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public double getPercentage() {
        return percentage;
    }

    public char getGrade() {
        return grade;
    }

    // Last function to print the Output.
    public void printReportCard() {
        System.out.println("Class: Student");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.print("Subject Marks: ");
        for (int mark : subjectMarks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        int[] marks1 = {85, 92, 78};
        StudentMarkSheet student1 = new StudentMarkSheet(101, "John Doe", marks1);
        student1.printReportCard();
        System.out.println();

        int[] marks2 = {90, 88, 95};
        StudentMarkSheet student2 = new StudentMarkSheet(102, "Jane Smith", marks2);
        student2.printReportCard();
    }
}