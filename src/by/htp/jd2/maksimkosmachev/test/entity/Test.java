package by.htp.jd2.maksimkosmachev.test.entity;

import java.util.Objects;

public class Test extends Entity {
    private String testName;
    private int testDuration;
    private String questionText;
    private String answer;
    private boolean isRightAnswer;
    private int idTestQuestion;
    private int idTestAnswer;

    public Test() {
    }

    public Test(String testName, int testDuration, String questionText, String answer, boolean isRightAnswer) {
        this.testName = testName;
        this.testDuration = testDuration;
        this.questionText = questionText;
        this.answer = answer;
        this.isRightAnswer = isRightAnswer;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(int testDuration) {
        this.testDuration = testDuration;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isRightAnswer() {
        return isRightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        isRightAnswer = rightAnswer;
    }

    public int getIdTestQuestion() {
        return idTestQuestion;
    }

    public void setIdTestQuestion(int idTestQuestion) {
        this.idTestQuestion = idTestQuestion;
    }

    public int getIdTestAnswer() {
        return idTestAnswer;
    }

    public void setIdTestAnswer(int idTestAnswer) {
        this.idTestAnswer = idTestAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Test test = (Test) o;
        return testDuration == test.testDuration &&
                isRightAnswer == test.isRightAnswer &&
                idTestQuestion == test.idTestQuestion &&
                idTestAnswer == test.idTestAnswer &&
                testName.equals(test.testName) &&
                questionText.equals(test.questionText) &&
                answer.equals(test.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), testName, testDuration, questionText, answer, isRightAnswer, idTestQuestion, idTestAnswer);
    }

    @Override
    public String toString() {
        return super.toString() +"Test{" +
                "testName='" + testName + '\'' +
                ", testDuration=" + testDuration +
                ", questionText='" + questionText + '\'' +
                ", answer='" + answer + '\'' +
                ", isRightAnswer=" + isRightAnswer +
                ", idTestQuestion=" + idTestQuestion +
                ", idTestAnswer=" + idTestAnswer +
                '}';
    }
}
