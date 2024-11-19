// LoginHandler 클래스 (백엔드 로그인 로직)
public class LoginHandler {
    private static final String CORRECT_ID = "user123";
    private static final String CORRECT_PASSWORD = "password123";

    public boolean authenticate(String id, String password) {
        return CORRECT_ID.equals(id) && CORRECT_PASSWORD.equals(password);
    }
}
