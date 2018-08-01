package by.bsuir.jobproject.dao;


import by.bsuir.jobproject.model.User;


public interface UserDAO extends CrudDAO<User> {
    User findUser(String login, String password);
}
