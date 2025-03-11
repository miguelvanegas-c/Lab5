package edu.eci.cvds.Labtools;

public class LabToolsException extends Exception {

    public static String Email_Not_Found = "The text entered is not an email.";
    public static String Email_Domain_Not_Found = "The domain of the email is incorrect.";
    public static String Void_Email = "Enter a email.";
    public static String User_Not_Exist = "User with that email does not exist.";
    public static String Incorrect_Password = "The password is incorrect.";

    public LabToolsException(String message) {
        super(message);
    }
}
