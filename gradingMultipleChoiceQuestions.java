public class gradingMultipleChoiceQuestions {

    public String grade(int m[],int passMark,int subjectID) {

        for (int i = 0; i < m.length; i++) {

            if (m[i] <= passMark) {
                System.out.println("The student scored  F in Subject "+subjectID+"("+m[i]+" Points)");
            } else {
                System.out.println("The student scored  P in Subject "+subjectID+"("+m[i]+" Points)");
            }
        }

        return null;
    }

}