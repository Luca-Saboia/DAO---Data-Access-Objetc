package br.mackenzie.lab_7.dao;

import br.mackenzie.lab_7.model.Proprietario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioDAO extends AbstractDAO<Proprietario> {

    @Override
    public Proprietario create(Proprietario p) throws SQLException {
        String sql = "INSERT INTO proprietario (nome, cpf) VALUES (?, ?)";

        Connection con = openConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getCpf());

        stmt.executeUpdate();
        con.close();

        return p;
    }

    @Override
    public Proprietario read(int id) throws SQLException {
        String sql = "SELECT * FROM proprietario WHERE id = ?";

        Connection con = openConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Proprietario p = new Proprietario();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cpf"));
            con.close();
            return p;
        }

        con.close();
        return null;
    }

    @Override
    public List<Proprietario> readAll() throws SQLException {
        List<Proprietario> lista = new ArrayList<>();

        String sql = "SELECT * FROM proprietario";

        Connection con = openConnection();
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Proprietario p = new Proprietario();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cpf"));
            lista.add(p);
        }

        con.close();
        return lista;
    }

    @Override
    public Proprietario update(Proprietario p) throws SQLException {
        String sql = "UPDATE proprietario SET nome=?, cpf=? WHERE id=?";

        Connection con = openConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getCpf());
        stmt.setInt(3, p.getId());

        stmt.executeUpdate();
        con.close();

        return p;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM proprietario WHERE id=?";

        Connection con = openConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();
        con.close();
    }
}