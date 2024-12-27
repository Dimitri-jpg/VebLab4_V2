package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.User;

public interface AuthService {

    User login(String username, String password);

    User register(String username, String password, String repeatPassword, String name, String surname);
}
