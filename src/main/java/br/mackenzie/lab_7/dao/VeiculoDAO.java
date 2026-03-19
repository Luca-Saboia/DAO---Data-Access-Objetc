package br.mackenzie.lab_7.dao;

import br.mackenzie.lab_7.model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO extends AbstractDAO<Veiculo> {

    @Override
    public Veiculo create(Veiculo v) throws SQLException {
        String sql = "INSERT INTO veiculo (proprietario_id, placa) VALUES (?, ?)";

        Connection con = openConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, v.getProprietarioId());
        stmt.setString(2, v.getPlaca());

        stmt.executeUpdate();
        con.close();

        return v;
    }

    @Override
    public Veiculo read(int id) throws SQLException {
        String sql = "SELECT * FROM veiculo WHERE id = ?";

        Connection con = openConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Veiculo v = new Veiculo();
            v.setId(rs.getInt("id"));
            v.setProprietarioId(rs.getInt("proprietario_id"));
            v.setPlaca(rs.getString("placa"));
            con.close();
            return v;
        }

        con.close();
        return null;
    }

    @Override
    public List<Veiculo> readAll() throws SQLException {
        List<Veiculo> lista = new ArrayList<>();

        String sql = "SELECT * FROM veiculo";

        Connection con = openConnection();
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Veiculo v = new Veiculo();
            v.setId(rs.getInt("id"));
            v.setProprietarioId(rs.getInt("proprietario_id"));
            v.setPlaca(rs.getString("placa"));
            lista.add(v);
        }

        con.close();
        return lista;
    }

    @Override
    public Veiculo update(Veiculo v) throws SQLException {
        String sql = "UPDATE veiculo SET proprietario_id=?, placa=? WHERE id=?";

        Connection con = openConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, v.getProprietarioId());
        stmt.setString(2, v.getPlaca());
        stmt.setInt(3, v.getId());

        stmt.executeUpdate();
        con.close();

        return v;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM veiculo WHERE id=?";

        Connection con = openConnection();
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.executeUpdate();
        con.close();
    }
}