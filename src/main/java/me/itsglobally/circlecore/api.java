package me.itsglobally.circlecore;

import java.util.Objects;

public class api {
    private static Boolean chatFormatHandleByCore;

    public static void setChatFormat(Boolean s) {
        chatFormatHandleByCore = s;
    }

    public static Boolean getChatFormatHandleByCore() {
        return Objects.requireNonNullElse(chatFormatHandleByCore, false);
    }
}
