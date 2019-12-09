package arsw.tetriscombat.mappers;
import arsw.tetriscombat.entities.Stats;
import arsw.tetriscombat.entities.User;
import java.sql.*;
import java.util.ArrayList;

public class Bridge{
    private String username = "vtwxlbqlglihsp";
    private String password = "c7417adea0612f8a11250304210e2857de3b29535b5b0b9532b6319e963bc7c6";
    private String url = "jdbc:postgresql://ec2-23-21-115-109.compute-1.amazonaws.com:5432/d68j9ui4h73s36";


    private Connection connection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }


    public User authentication(String username, String password){
        String SQL = "SELECT nombre, apellido, username, correo, contraseña, rol, nivel FROM usuario WHERE username = ? AND contraseña = ?";

        User user = new User();
        try {
            Connection conn = connection();
            PreparedStatement pstmt = conn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            if(rs.absolute(1)){
                user.setName(rs.getString("nombre"));
                user.setLastname(rs.getString("apellido"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("correo"));
                user.setPassword(rs.getString("contraseña"));
                user.setRole(rs.getString("rol"));
                user.setLevel(rs.getInt("nivel"));
                conn.close();
                pstmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean checkForDuplicatedUsername(String username){
        String SQL = "SELECT COUNT(*) AS total FROM usuario WHERE username = ?";
        try {
            Connection conn = connection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            boolean retorno = rs.getInt("total") >= 1;
            conn.close();
            pstmt.close();
            rs.close();
            return retorno;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkForUsedEmail(String email){
        String SQL = "SELECT COUNT(*) AS total FROM usuario WHERE correo = ?";
        try {
            Connection conn = connection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            System.out.println("conteo: " + rs.getInt("total"));
            boolean retorno = rs.getInt("total") >= 1;
            conn.close();
            pstmt.close();
            rs.close();
            return retorno;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public User getUserByEmail(String username){
        String SQL = "SELECT nombre, apellido, username, correo, contraseña, rol, nivel FROM usuario WHERE username = ?";
        User user = new User();
        try {
            Connection conn = connection();
            PreparedStatement pstmt = conn.prepareStatement(SQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, username);           
            ResultSet rs = pstmt.executeQuery();            
            rs.next();
            if(rs.absolute(1)){      
                user.setName(rs.getString("nombre"));
                user.setLastname(rs.getString("apellido"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("correo"));
                user.setPassword(rs.getString("contraseña"));
                user.setRole(rs.getString("rol"));
                user.setLevel(rs.getInt("nivel"));
                conn.close();
                pstmt.close();
                rs.close();
                //return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    


    public boolean addUser(String nombre, String apellido, String username, String correo, String contraseña){
        String SQL = "INSERT INTO usuario (nombre, apellido, username, correo, contraseña,rol,nivel) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection conn = connection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,nombre);
            pstmt.setString(2,apellido);
            pstmt.setString(3,username);
            pstmt.setString(4,correo);
            pstmt.setString(5,contraseña);
            pstmt.setString(6,"jugador");
            pstmt.setFloat(7,0);
            if(pstmt.executeUpdate() == 1){
                conn.close();
                pstmt.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Stats> getUserStatistics( String username){
        String SQL = "SELECT fecha, experiencia,\"user\",  puntaje, tipo FROM estadisticas WHERE \"user\" = ?";
        ArrayList<Stats> statslist = new ArrayList<>();
        try {
            Connection conn = connection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Stats stats = new Stats();
                stats.setDate(rs.getString("fecha"));
                stats.setExp(rs.getString("experiencia"));
                stats.setUsername(rs.getString("user"));
                stats.setScore(rs.getInt("puntaje"));
                stats.setType(rs.getString("tipo"));
                statslist.add(stats);
            }
            conn.close();
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statslist;
    }

    public boolean addStat(Stats stat){
        String SQL = "INSERT INTO estadisticas (fecha, experiencia, \"user\", puntaje, tipo,statsid) VALUES (?,?,?,?,?,?)";
        String rows = "SELECT statsid AS total FROM estadisticas ORDER BY statsid DESC LIMIT 1";
        try {
            Connection conn = connection();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            PreparedStatement pstmt2 = conn.prepareStatement(rows);
            ResultSet rs = pstmt2.executeQuery();
            pstmt.setString(1,stat.getDate());
            pstmt.setString(2,stat.getExp());
            pstmt.setString(3,stat.getUsername());
            pstmt.setFloat(4,stat.getScore());
            pstmt.setString(5,stat.getType());
            rs.next();
            pstmt.setFloat(6,rs.getInt("total")+1);
            if(pstmt.executeUpdate() == 1){
                conn.close();
                pstmt.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}

        /*HOST:
        ec2-23-21-115-109.compute-1.amazonaws.com
        USER:
        vtwxlbqlglihsp
        PASSWORD:
        c7417adea0612f8a11250304210e2857de3b29535b5b0b9532b6319e963bc7c6
        DATABASE:
        d68j9ui4h73s36
        URL:
        jdbc:postgresql://ec2-23-21-115-109.compute-1.amazonaws.com:5432/d68j9ui4h73s36*/
