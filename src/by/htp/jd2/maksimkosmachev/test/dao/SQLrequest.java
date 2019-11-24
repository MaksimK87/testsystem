package by.htp.jd2.maksimkosmachev.test.dao;

public class SQLrequest {

    public static final String FIND_ALL_USERS = "SELECT * FROM jd2_test_system.user";
    public static final String FIND_BY_LOGIN_PASSWORD = "SELECT * FROM jd2_test_system.user WHERE user.login=? AND user.password=?";
    public static final String FIND_BY_LOGIN = "SELECT * FROM jd2_test_system.user WHERE user.login=?";
    public static final String REGISTER_USER_DATA = "INSERT INTO jd2_test_system.user(login,password,email,user_details_id) VALUES (?,?,?,?)";
    public static final String REGISTER_USER_DETAILS = "INSERT INTO jd2_test_system.user_details(name,surname) VALUES (?,?)";
    public static final String GET_USER_DETAILS = "SELECT * FROM jd2_test_system.user_details WHERE id_userdetails=?";

}
