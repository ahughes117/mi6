/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import gui.GUI;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Hughes
 */
public class MesDial {

    private static String conError = "Error while attempting to connect with database. "
            + "Check your connection status and try again.";
    private static String conSuccess = "Connection Success!";
    private static String draftSuccess = "Microfeed draft saved succesfully!";
    private static String postSuccess = "Microfeed was published!";
    
    private static String saveSuccess = "Database updated succesfully";
    private static String noRowSelected = "You have to choose a line.";
    private static String multipleRowsSelected = "You cannot edit/delete more than one line simultaneously.";
    private static String programError = "Severe Programme Error. Please restart programme.";
    private static String stringError = "Error while parsing your input. Check it's length and try again.";
    private static String correlationError = "Correlation Already Exists.";
    private static String duplicateError = "Name already exists. Choose another one.";
    private static String selectGroupError = "You have to select a group in order to proceed.";
    private static String validGroupError = "Select or type in a valid group name.";
    private static String validDatabaseError = "You have to type in a valid database schema name";
    private static String dbSchemaError = "The database version is not compatible with the application version";
    private static String rowSelectionError = "You have to pick exactly one row.";
    private static String browserError = "URL could not be sent to the browser. Something is probably wrong with the permissions of your system :-(";
    private static String uriError = "The URL you have set is invalid. Go to Twitter setup and enter the correct one.";
    private static String nullMicroError = "There is not microID in cache. Try saving a draft first and try again.";
    private static String browseNotSupportedError = "The BROWSE operation is not supported on your system";
    private static String awtNotSupportedError = "AWT desktop is not supported on this machine";
    
    //
    private static String deleteQuestion = "Delete?";
    private static String tweetQuestion = "Tweet microfeed?";
    private static String exitQuestion = "Exit Minifeed Updater? Any unsaved changes will be lost.";
    private static String newGroupDialog = "Insert the name of the new Group: ";
    private static String newDatabaseDialog = "Insert the name of the database schema: ";
    private static String scriptFileError = "Error while parsing sql script file. Make sure file contents are ok, "
            + "file is at correct location and try again.";
    //
    private static String addressError = "Insert a correct From Address...";
    private static String fileSuccess = "File Saved Succesfully";
    private static String fileError = "Error while opening file";
    private static String structError = "You have entered invalid database tables and field names.";
    private static String dbAddressError = "There are invalid email addresses contained into database.";
    
    public static void conSuccess(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, conSuccess, "Success!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void saveSuccess(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, saveSuccess, "Success!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void draftSuccess(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, draftSuccess, "Success!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void postSuccess(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, postSuccess, "Success!", JOptionPane.INFORMATION_MESSAGE);
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
    
    public static int tweetQuestion(GUI aFrame, String aTweet) {
        Object[] options = {"ΟΚ", "Cancel"};

        return JOptionPane.showOptionDialog(null, tweetQuestion + "\n'" + aTweet + "'", "Confirmation Needed", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }
    
    public static int exitQuestion(GUI aFrame) {
        Object[] options = {"Yes", "No"};

        return JOptionPane.showOptionDialog(null, exitQuestion, "Confirmation Needed", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }
    
    public static void stringError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, stringError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void correlationError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, correlationError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static String addGroupDialog(GUI aFrame) {
        return JOptionPane.showInputDialog(aFrame, newGroupDialog);
    }
    
    public static String addDatabaseDialog(GUI aFrame){
        return JOptionPane.showInputDialog(aFrame, newDatabaseDialog);
    }
    
    public static void duplicateError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, duplicateError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void selectGroupError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, selectGroupError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void browserError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, browserError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void uriError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, uriError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void nullMicroError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, nullMicroError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void browseNotSupportedError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, browseNotSupportedError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void awtNotSupportedError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, awtNotSupportedError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void validGroupError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, validGroupError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void validDatabaseError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, validDatabaseError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void scriptFileError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, scriptFileError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void addressError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, addressError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void fileSuccess(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, fileSuccess, "Success!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void fileError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, fileError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void structError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, structError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void dbAddressError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, dbAddressError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void dbSchemaError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, dbSchemaError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void rowSelectionError(GUI aFrame) {
        JOptionPane.showMessageDialog(aFrame, rowSelectionError, "Error!", JOptionPane.ERROR_MESSAGE);
    }
}
