package com.varentech.daoimpl;

import com.varentech.dao.MusicDao;
import com.varentech.entities.Music;
import com.varentech.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by ParksW on 5/25/2016.
 */
public class MusicDaoImpl implements MusicDao {

    public void createMusicTable() {
        Connection connection = null;
        Statement statement = null;
        try{
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS MUSIC " +
                                "(ID INT PRIMARY KEY      NOT NULL," +
                                "ARTIST_NAME     TEXT      NOT NULL," +
                                "ALBUM_NAME      TEXT       NOT NULL," +
                                "YEAR            INT        NOT NULL)"
            );

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(statement != null){
                try{
                    statement.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try{
                    connection.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void insert(Music music) {
        //TODO: Add a few insert SQL statements.
        Connection connection = null;
        Statement statement = null;

        try{
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            //TODO: Add Insert statements here.
            statement.execute("INSERT INTO MUSIC(ID, ARTIST_NAME, ALBUM_NAME, YEAR) " +
                            "VALUES (1, 'Drake', 'Take Care', 2011)"
            );
            statement.execute("INSERT INTO MUSIC(ID, ARTIST_NAME, ALBUM_NAME, YEAR)" +
                            "VALUES (2, 'Sonic Youth', 'Daydream Nation', 1989)"
            );

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Music selectById(int id) {
        return null;
    }

    public List<Music> selectAll() {
        return null;
    }

    public void delete(int id) {
    }

    public void update(Music music, int id) {

    }
}
