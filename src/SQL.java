import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class SQL {
    private static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[])throws SQLException, IOException {
        System.out.println("введите логин");
        String login = br.readLine();
        System.out.println("введите пароль");
        String password = br.readLine();

        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/prison", "postgres", "password");
        Statement st = con.createStatement();
        ResultSet result= st.executeQuery("SELECT * FROM users "+"WHERE login=\'"+ login+"\' AND password=\'"+password+"\'");
        while (result.next()){
            System.out.println(String.format("Name : %s   Login : %s", result.getString("mail"),result.getString("login")));
        }
    }
    }
