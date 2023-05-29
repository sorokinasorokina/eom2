package eom_logical;

public enum UserCredentials {
    TEACHER_MALYUTIN("15145652956", "pR6vs9eG");
    String login;
    String password;

    UserCredentials (String login, String password) { // конструктор
        this.login = login;
        this.password = password;
    }
}
