package by.htp.jd2.maksimkosmachev.test;

import by.htp.jd2.maksimkosmachev.test.dao.DAOFactory;
import by.htp.jd2.maksimkosmachev.test.dao.SQLTestDAO;
import by.htp.jd2.maksimkosmachev.test.dao.SQLUserDAO;
import by.htp.jd2.maksimkosmachev.test.dao.TestDAO;
import by.htp.jd2.maksimkosmachev.test.dao.exception.ConnectionPoolException;
import by.htp.jd2.maksimkosmachev.test.dao.exception.SuchUserExistException;
import by.htp.jd2.maksimkosmachev.test.dao.exception.SuchUserNotExistException;
import by.htp.jd2.maksimkosmachev.test.entity.Entity;
import by.htp.jd2.maksimkosmachev.test.entity.Test;
import by.htp.jd2.maksimkosmachev.test.entity.User;
import by.htp.jd2.maksimkosmachev.test.entity.enumpackage.Role;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args) {

        SQLTestDAO sqlTestDAO = new SQLTestDAO();
        Test test = new Test();
        test.setTestName("Threads");
        test.setTestDuration(30);
        HashMap<String, Boolean> answers = new HashMap<>();
        HashMap<String, Boolean> answers1 = new HashMap<>();
        answers.put("Answer 11",true);
        answers.put("Answer 21",false);
        answers.put("Answer 31",false);
        answers1.put("Answer 41",true);
        answers1.put("Answer 51",false);
        answers1.put("Answer 61",false);

        System.out.println(answers.get("Answer 1"));

        test.getTest().put("Question 11-31",answers );
        test.getTest().put("Question 41-61",answers1);


        /*for(Map.Entry entry:test.getTest().entrySet()){
            HashMap<String,Boolean> hashMap=( HashMap<String,Boolean>)entry.getValue();
                for(Map.Entry entry1:hashMap.entrySet())
            System.out.println(entry1);
           *//* for(Map.Entry entry1:test.getTest().get(entry).entrySet()){
                System.out.println(entry1);
            }*//*
        }*/




        try {
            sqlTestDAO.addTest(test);
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        ResourceBundle resourceBundle=ResourceBundle.getBundle("by.htp.jd2.maksimkosmachev.test.resources.local",new Locale("by","by"));
//        System.out.println(resourceBundle.getString("local.registration"));

       /* User user;
        String login="Ivan";
        String password="123456";
        ResultSet resultSet;
        int id=1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jd2_test_system?verifyServerCertificate=false &useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC",
                    "root", "123456");
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setUserDetailsId(resultSet.getInt(5));
                logger.info("getting information from user table "+user.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


      /*  try {
            SQLTestDAO sqlTestDAO=new SQLTestDAO();
            Test test=new Test();
            test.setTestName("Exceptions");
            test.setTestDuration(30);
            test.setQuestionText("Which class on the top of hierarchy of exceptions?");
            test.setAnswer("Throwable");
            test.setRightAnswer(true);
            sqlTestDAO.addTest(test);*/

           /* SQLUserDAO sqlUserDAO = new SQLUserDAO();
           // User user = sqlUserDAO.signIn("Ivan", "123456");
            User user=new User();
            user.setLogin("Vlad");
            user.setPassword("77777");
            user.setEmail("reaart@gmail.com");
            user.setName("Vlad");
            user.setSurname("Petrov");
            user.setRole(Role.ADMINISTRATOR);
            boolean status=sqlUserDAO.registration(user);
            System.out.println(user);
            System.out.println(status);
        } catch (ConnectionPoolException e) {
            logger.info("Error in Connection pool");
        } catch (SQLException e) {
            logger.info("Error in SQL" +e);
        } catch (SuchUserExistException e) {
            e.printStackTrace();*/



      /*  } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
     /*   DAOFactory daoFactory = DAOFactory.getInstance();
        TestDAO testDAO = daoFactory.getTestDAO();
        List<Test> tests;
        try {
            tests = testDAO.getAllTest();
            System.out.println(tests.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
*/
    }

    public void method(int x) {
        System.out.println("meth x " + x++);
        ;
    }

}
