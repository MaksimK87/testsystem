package by.htp.jd2.maksimkosmachev.test.dao;

public final class DAOFactory {

    private final static DAOFactory instance = new DAOFactory();
    private final UserDAO sqlUserImpl = new SQLUserDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {

        return instance;
    }

    public UserDAO getUserDAO() {
        return sqlUserImpl;
    }


}



