package me.itsglobally.circlecore;

public class api {
    private static Boolean chatFormatHandleByCore;
    public static void setChatFormat(Boolean s) {
        chatFormatHandleByCore = s;
    }

    public static Boolean getChatFormatHandleByCore() {
        return chatFormatHandleByCore;
    }
}
