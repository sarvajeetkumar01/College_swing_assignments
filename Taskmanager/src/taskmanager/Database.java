/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanager;

/**
 *
 * @author gk789
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Database {
    public static Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:tasks.db");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return conn;
        }
    public static void createTable(){
        try{
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS tasks ("+
                         "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                         "task TEXT,"+
                         "description TEXT,"+
                         "priority TEXT,"+
                         "status TEXT,"+
                         "duedate TEXT)";
            stmt.execute(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }
