//Import the Scanner Class that enables us to get user imput
import java.util.Scanner;

public class PassFailTest {
    int studentsTakingSubject = 0; // Initialize number of students taking each subject
    int noOfQuestionsPerSubject = 0; // Initialize number of questions in each subject
    int marksPerQuestion = 5;// Initialize Number of marks that each question carries
    int correctAnswers = 0;//Initialize Number of correct answers 

    //The doTest method runs individual tests and takes in the subject id,number of studenst taking the test,no of questions taking the subject,an array of the keys to the test,and the individual passmark of the test
    public void doTest(int subjectID, int studentsTakingSubject, int noOfQuestionsPerSubject, char[] subject1Answer,
            int passmark) {

                
        Scanner sc = new Scanner(System.in);//Create scanner object to use in getting user input
        System.out.println("Start with test for Subject " + subjectID + ".This test has " + noOfQuestionsPerSubject
                + " Questions");
        char Array1[][] = new char[studentsTakingSubject][noOfQuestionsPerSubject];
        //LOOP through number of students taking each individual test
        for (int i = 0; i < studentsTakingSubject; i++) {
            System.out.println("Student" + (i + 1) + " Taking the Test for Subject " + subjectID);
            //Loop through the number of question per subject
            for (int j = 0; j < noOfQuestionsPerSubject; j++) {
                System.out.println("Please Enter Answer for Question " + (j + 1));
                Array1[i][j] = sc.next().charAt(0);
            }
        }
        int correctAnswers = 0;
        int studentMarks[] = new int[studentsTakingSubject];
        //Loop through submissions for individual students
        for (int k = 0; k < studentsTakingSubject; k++) {
            correctAnswers = 0;
            //LOOP throught user input and match the answers to the key
            for (int j = 0; j < noOfQuestionsPerSubject; j++) {
                if (Array1[k][j] == subject1Answer[j]) {
                    correctAnswers++;
                }
            }
            System.out.println("Student " + (k + 1) + " has " + correctAnswers + " correct answers in Subject 1");
            System.out.println("Student " + (k + 1) + " has " + (noOfQuestionsPerSubject - correctAnswers)
                    + "wrong answers in Subject 1");

       

            studentMarks[k] = correctAnswers * marksPerQuestion;
        }
        gradingMultipleChoiceQuestions abc = new gradingMultipleChoiceQuestions();//Create new object to access the gradingMultipleChoiceQuestions class that gives P or F
        abc.grade(studentMarks, passmark,subjectID);//Pass the student marks,passmark and subject ID to the grade method to determine whether its a pass or a fail

    }

    public static void main(String[] args) {

        PassFailTest p = new PassFailTest();

        // SUBJECT 1
        // KEYS FOR SUBJECT 1
        char subject1Answer[] = { 'C', 'A', 'D', 'B' };
        // Subject 1 has id=1,number of students taking the test=4,the test has 4
        // questions and the passmark is 13

        // SUBJECT 2
        char subject2Answer[] = { 'D', 'B', 'B', 'E', 'C','C','C' };
        // SUBJECT 2
        // Subject 2 has id=2,number of students taking the test=3,the test has 7
        // questions and the passmark is 18

        // SUBJECT 3
        // KEYS FOR SUBJECT 3
        char subject3Answer[] = { 'A', 'D', 'B' };
        // Subject 3 has id=3,number of students taking the test=2,the test has 3
        // questions and the passmark is 26

        // CALL TEST METHOD TO DO THE TEST FOR SUBJECT 1 and pass the subject id,number of studenst taking the test,no of questions taking the subject,an array of the keys to the test,and the individual passmark of the test
        p.doTest(1, 4, 4, subject1Answer, 13);

        // CALL TEST METHOD TO DO TEST FOR SUBJECT 2 and pass the subject id,number of studenst taking the test,no of questions taking the subject,an array of the keys to the test,and the individual passmark of the test
        p.doTest(2, 3, 7, subject2Answer, 18);

        // CALL TEST METHOD TO DO TEST FOR SUBJECT 3 and pass the subject id,number of studenst taking the test,no of questions taking the subject,an array of the keys to the test,and the individual passmark of the test
        p.doTest(3,2 , 3, subject3Answer, 26);

    }
}
