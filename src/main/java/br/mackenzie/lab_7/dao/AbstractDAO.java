package br.mackenzie.lab_7.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T> {

    private static final String URL ="jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?sslmode=require";
    private static final String USER ="postgres.bxobbruddunwjtzotnqi";
    private static final String PASSWORD ="umceuazulado";

    protected Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public abstract T create(T obj) throws SQLException;

    public abstract T read(int id) throws SQLException;

    public abstract List<T> readAll() throws SQLException;

    public abstract T update(T obj) throws SQLException;

    public abstract void delete(int id) throws SQLException;
}