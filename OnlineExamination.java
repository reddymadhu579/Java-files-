import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    void displayQuestion(int number) {
        System.out.println("\n" + number + ". " + question);

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}

class Exam {
    String studentName;
    Question[] questions;
    int score;

    Exam(String studentName, Question[] questions) {
        this.studentName = studentName;
        this.questions = questions;
        this.score = 0;
    }

    void startExam(Scanner sc) {
        score = 0;

        for (int i = 0; i < questions.length; i++) {
            questions[i].displayQuestion(i + 1);

            System.out.print("Enter Answer (1-4): ");
            int answer = sc.nextInt();

            if (questions[i].checkAnswer(answer)) {
                score++;
            }
        }
    }

    void displayResult() {
        System.out.println("\n--- Examination Result ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (questions.length - score));
        System.out.println("Marks: " + score + "/" + questions.length);

        if (score >= questions.length * 0.4) {
            System.out.println("Result: Pass");
        } else {
            System.out.println("Result: Fail");
        }
    }
}

public class OnlineExamination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Question[] questions = {
            new Question("Which language is used for Java applications?",
                    new String[]{"Java", "HTML", "CSS", "SQL"}, 1),

            new Question("Which keyword creates an object?",
                    new String[]{"class", "new", "static", "void"}, 2),

            new Question("Which method is the entry point of a Java program?",
                    new String[]{"start()", "run()", "main()", "print()"}, 3),

            new Question("Which package contains the Scanner class?",
                    new String[]{"java.io", "java.net", "java.util", "java.time"}, 3),

            new Question("Which data type stores true or false?",
                    new String[]{"int", "char", "boolean", "double"}, 3)
        };

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        Exam exam = new Exam(name, questions);

        exam.startExam(sc);
        exam.displayResult();

        sc.close();
    }
}