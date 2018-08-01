package by.bsuir.jobproject.service;


import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.User;


public interface UserService extends Service<User>{
    User findUser(String login, String password) throws ServiceException;


}
