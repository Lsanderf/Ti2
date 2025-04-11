package com.lucca.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.lucca.model.Usuario;

public class UsuarioDAO {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "00junior"; 

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setIdade(rs.getInt("idade"));
                usuarios.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void inserir(Usuario u) {
        String sql = "INSERT INTO usuario (nome, idade) VALUES (?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getNome());
            stmt.setInt(2, u.getIdade());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
