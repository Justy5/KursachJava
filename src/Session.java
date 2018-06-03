class Session {
    static int sessionId = 1;
    static String name = "Самий крутий менеджер";
    static String status = "Самий крутий менеджер";
    static void setSession(int id, String Name, String Status){
        sessionId = id;
        name = Name;
        status = Status;
    }
}
