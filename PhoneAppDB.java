import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.time.format.*;

public class PhoneAppDB extends AppDefaultDB {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E, MMM d yyyy");
    LocalDateTime now = LocalDateTime.now();
    LocalDate prevDay = (LocalDate.now()).minusDays(1);
    String today = dateFormat.format(now);
    String yesterday = dateFormat.format(prevDay);

    public final String OUTGOING = "outgoing";
    public final String MISSED = "missed";
    public final String RECEIVED = "received";

    public PhoneAppDB() {
    }

    public ResultSet getLogsData() throws SQLException {
        ResultSet rs;
        String query = "SELECT * FROM calllogs";
        try (Connection conn = getConnection(); Statement stmnt = conn.createStatement()) {

            rs = stmnt.executeQuery(query);
            System.out.println(rs.getRow());
            while (rs.next()) {
                System.out.println(rs.getString("phonenumber"));
            }
        }
        return rs;
    }

    public ResultSet getContactsData() throws SQLException {
        ResultSet rs;
        String query = "SELECT * FROM CONTACTS";
        try (Connection conn = getConnection(); Statement stmnt = conn.createStatement()) {
            rs = stmnt.executeQuery(query);
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String fullname = firstname + ' ' + lastname;
                String phonenumber = rs.getString("phonenumber");

                System.out.printf("%s\t%s", fullname, phonenumber);
            }
        }

        return rs;
    }

    public ArrayList<WidgetCallCard> getFullLogsDetails() {
        ResultSet rs = null;
        ArrayList<WidgetCallCard> logs = new ArrayList<WidgetCallCard>();
        String firstname = null;
        String lastname = null;
        String callType = "";
        String query = "SELECT * FROM calllogs LEFT JOIN contacts on calllogs.phonenumber=contacts.phonenumber ORDER BY id DESC";
        try (Connection conn = getConnection(); Statement stmnt = conn.createStatement()) {
            rs = stmnt.executeQuery(query);
            while (rs.next()) {
                firstname = rs.getString("firstname");
                lastname = rs.getString("lastname");
                String fullname = firstname + ' ' + lastname;
                if (fullname.contains("null"))
                    fullname = null;
                String phonenumber = rs.getString("phonenumber");
                String timestamp = rs.getString("date") + ' ' + rs.getString("time");
                if (rs.getInt(RECEIVED) != 0)
                    callType = RECEIVED;
                else if (rs.getInt(OUTGOING) != 0)
                    callType = OUTGOING;
                else if (rs.getInt(MISSED) != 0)
                    callType = MISSED;
                // Photo also comes here
                logs.add(new WidgetCallCard(fullname, phonenumber, timestamp, callType, null));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return logs;
    }

    public ArrayList<String> getLogData(String phonenumber) {
        System.out.println(phonenumber);
        ArrayList<String> callDetail = new ArrayList<String>();
        ResultSet rs = null;
        String query = "SELECT firstname, lastname, photo FROM Contacts WHERE phonenumber=?";
        try (Connection conn = getConnection(); PreparedStatement stmnt = conn.prepareStatement(query)) {
            stmnt.setString(1, phonenumber);
            rs = stmnt.executeQuery();
            if (rs.next()) {
                callDetail.add(rs.getString("firstname"));
                callDetail.add(rs.getString("lastname"));
                byte[] photo = rs.getBytes("photo");
                // new String(rs.getBytes("photo"), "UTF-8");
                // callDetail.add(new String(rs.getBytes("photo"), "UTF-8"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return callDetail;
    }

    public void addLogData(String phonenumber, String desc) {
        String update;
        int descState = desc != null ? 1 : 0;
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date date;
        try (Connection conn = getConnection(); Statement stmnt = conn.createStatement()) {
            date = new Date();
            update = "INSERT INTO calllogs(phonenumber, date, time, " + desc + ") VALUES ";
            String vals = "('" + phonenumber + "','" + today + "','" + timeFormat.format(date) + "'," + descState + ')';
            update += vals;
            stmnt.executeUpdate(update);
            System.out.println(timeFormat.format(date));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Messaging
    // Add new message to database
    public void addMessageToDatabase(String phone, String msg, String time){
        PreparedStatement prepStmnt;
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date date;

        try (Connection conn = getConnection()) {
            date = new Date();
            String sql = "INSERT INTO messages(phonenumber, message, date, time, by_self) VALUES(?,?,?,?,?)";
            prepStmnt = conn.prepareStatement(sql);
            prepStmnt.setString(1, phone);
            prepStmnt.setString(2, msg);
            prepStmnt.setString(3, timeFormat.format(date));
            prepStmnt.setString(4, time);
            prepStmnt.setInt(5, 1);

            prepStmnt.execute();
            System.out.println(timeFormat.format(date));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve all messages from messages table
    public ResultSet retrieveAllMessages(){
        Connection conn;
        try{
            conn = getConnection();
        }catch(Exception excep){
            System.out.println(excep.getMessage());
            conn = null;
        }
        Statement stmnt;
        try{
            String sql = "SELECT DISTINCT * FROM messages LEFT JOIN contacts ON messages.phonenumber=contacts.phonenumber ORDER BY id DESC LIMIT 7";
            stmnt = conn.createStatement();
            ResultSet res = stmnt.executeQuery(sql);
            return res;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}