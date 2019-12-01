package by.htp.jd2.maksimkosmachev.test.service;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService = new ClientServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {

        return instance;
    }

    public ClientService getClientService() {
        return clientService;
    }

}
