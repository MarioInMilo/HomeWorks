import java.util.Objects;

public record LoginAndPass(String login, String password) {
    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {

        return "(Login: " + login + " | Password: " + password +")";
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginAndPass that = (LoginAndPass) o;
        return Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
