package by.htp.jd2.maksimkosmachev.test.dao;

public class SQLrequest {

    public static final String FIND_ALL_USERS = "SELECT * FROM jd2_test_system.user";
    public static final String FIND_BY_LOGIN_PASSWORD = "SELECT * FROM jd2_test_system.user WHERE user.login=? AND user.password=?";
    public static final String FIND_BY_LOGIN = "SELECT * FROM jd2_test_system.user WHERE user.login=?";
    public static final String REGISTER_USER_DATA = "INSERT INTO jd2_test_system.user(login,password,email,user_details_id) VALUES (?,?,?,?)";
    public static final String REGISTER_USER_DETAILS = "INSERT INTO jd2_test_system.user_details(name,surname,role) VALUES (?,?,?)";
    public static final String GET_USER_DETAILS = "SELECT * FROM jd2_test_system.user_details WHERE id_userdetails=?";
    public static final String ADD_NEW_TEST="INSERT INTO tests(test_name,duration_time) VALUES (?,?)";
    public static final String ADD_TEST_QUESTION="INSERT INTO test_questions(question_text,test_id)VALUES(?,?)";
    public static final String ADD_TEST_ANSWER="INSERT INTO test_answers(answers,isRight,test_questions_id) VALUES (?,?,?)";
    public static final String SHOW_ALL_TESTS="SELECT * FROM tests";


}
