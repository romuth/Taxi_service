package mate.service;

import mate.exception.AuthenticationException;
import mate.lib.Inject;
import mate.lib.Service;
import mate.model.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Inject
    private DriverService driverService;

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        logger.info("Method login was called with login: {}", login);
        Driver driver = driverService.findByLogin(login);
        if (driver.getPassword() == null || !driver.getPassword().equals(password)) {
            throw new AuthenticationException("login or password was incorrect");
        }
        return driver;
    }
}
