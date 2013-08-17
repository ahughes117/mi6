package util;

import gui.GUI;
import javax.swing.JOptionPane;

/**
 * The Message Dialogues for the app
 *
 * @author Alex Hughes
 */
public class MesDial {

    private static String conError = "Error while attempting to connect with database. "
            + "Check your connection status and try again.";
    private static String conSuccess = "Connection Success!";
    private static String saveSuccess = "Database updated succesfully";
    private static String noRowSelected = "You have to choose a line.";
    private static String multipleRowsSelected = "You cannot edit/delete more than one line simultaneously.";
    private static String programError = "Severe Programme Error. Please restart programme.";
    private static String selectGroupError = "You have to select a group in order to proceed.";
    private static String validGroupError = "Select or type in a valid group name.";
    private static String validDatabaseError = "You have to type in a valid database schema name";
    private static String dbSchemaError = "The database version is not compatible with the application version";
    private static String rowSelectionError = "You have to pick exactly one row.";
    private static String syncError = "There was a sync error. Sorry, try again.";
    private static String validIpError = "Please enter a valid IP address.";
    private static String validIntError = "Please enter a valid integer.";
    //
    private static String deleteQuestion = "Delete?";
    private static String exitQuestion = "Exit Minifeed Updater? Any unsaved changes will be lost.";
    //
    private static String fileSuccess = "File Saved Succesfully";
    private static String fileError = "Error while opening file";

    public static void conSuccess(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, conSuccess, "Success!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void saveSuccess(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, saveSuccess, "Success!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void conError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, conError, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void noRowSelected(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, noRowSelected, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void multipleRowsSelected(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, multipleRowsSelected, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void programError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, programError, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static int deleteQuestion(GUI aFrame) {
        Object[] options = {"ΟΚ", "Cancel"};

        return JOptionPane.showOptionDialog(null, deleteQuestion, "Confirmation Needed", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    public static int exitQuestion(GUI aFrame) {
        Object[] options = {"Yes", "No"};

        return JOptionPane.showOptionDialog(null, exitQuestion, "Confirmation Needed", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    public static void selectGroupError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, selectGroupError, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void validGroupError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, validGroupError, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void validDatabaseError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, validDatabaseError, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void fileSuccess(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, fileSuccess, "Success!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void fileError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, fileError, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void dbSchemaError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, dbSchemaError, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void rowSelectionError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, rowSelectionError, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void syncError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, syncError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void validIpError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, validIpError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void validIntError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, validIntError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
}
