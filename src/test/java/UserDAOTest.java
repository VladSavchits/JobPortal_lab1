import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.User;
import by.bsuir.jobproject.service.impl.UserServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

public class UserDAOTest {

    @Test
    public void getAllUsersTest() throws ServiceException, DAOException {
        UserServiceImpl userService = new UserServiceImpl();
        ArrayList<User> users = userService.getAllEntities();
        assertNotNull(users);
    }

    @Test(timeout = 10000)
    public void getAllUsersCheckTimeoutTest() throws ServiceException, DAOException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.getAllEntities();
    }

    @Test(expected = NullPointerException.class)
    public void tryAddNullUserTest() throws ServiceException, DAOException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.addEntity(null);
    }

    @Test
    public void addUserTest() throws ServiceException, DAOException {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setUser_login("test");
        user.setUser_password("test");
        user.setUser_email("test@example.com");
        user.setUser_status("test");
        userService.addEntity(user);
    }

    @Test(expected = ServiceException.class)
    public void tryAddDuplicateUserTest() throws ServiceException, DAOException {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setUser_login("test");
        user.setUser_password("test");
        user.setUser_email("test@example.com");
        user.setUser_status("test");
        userService.addEntity(user);
        userService.addEntity(user);
    }

    @Test
    public void tryFindUserByIdTest() throws ServiceException, DAOException {
        UserServiceImpl userService = new UserServiceImpl();
        Integer userId = userService.getUserIdByLogin("test2");
        assertNull(userId);
    }

    @Test
    public void findUserByIdTest() throws ServiceException, DAOException {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setUser_login("test");
        user.setUser_password("test");
        user.setUser_email("test@example.com");
        user.setUser_status("test");
        int userId = userService.getUserIdByLogin("test");
        User foundUser = userService.getEntityById(userId);
        assertEquals(foundUser.getUser_email(), user.getUser_email());
    }

    @Test
    public void updateUserTest() throws ServiceException, DAOException {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setUser_login("test");
        user.setUser_password("test");
        user.setUser_email("test@example.com");
        user.setUser_status("test");
        String newStatus = "test_status";
        user.setUser_status(newStatus);
        userService.updateEntity(user);
        assertEquals(user.getUser_status(), newStatus);
    }

    @Test(expected = NullPointerException.class)
    public void updateNullUserTest() throws ServiceException, DAOException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.updateEntity(null);
    }

    @Test
    public void deleteUserTest() throws ServiceException, DAOException {
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setUser_login("test");
        user.setUser_password("test");
        user.setUser_email("test@example.com");
        user.setUser_status("test");
        userService.deleteEntity(userService.getUserIdByLogin("test"));
        Integer userId = userService.getUserIdByLogin("test");
        assertNull(userId);
    }


}
