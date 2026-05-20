package Common;

import java.security.SecureRandom;

public class Random {
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String ALPHANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int MAIL_NAME_LENGTH = 10;

    public static String generateText(int min, int max) {
        int length = RANDOM.nextInt(max - min + 1) + min;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(ALPHANUM.charAt(RANDOM.nextInt(ALPHANUM.length())));
        }

        return sb.toString();
    }

    public static String generateText(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(ALPHANUM.charAt(RANDOM.nextInt(ALPHANUM.length())));
        }

        return sb.toString();
    }

    public static int generateNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static int generateNumber(int max) {
        return RANDOM.nextInt(max);
    }

    public static String generateEmail(String domain) {
        return generateText(MAIL_NAME_LENGTH) + "@" + domain;
    }
}
