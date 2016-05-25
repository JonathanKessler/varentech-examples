import com.varentech.daoimpl.MusicDaoImpl;
import com.varentech.entities.Music;
import com.varentech.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ParksW on 5/25/2016.
 */
public class App {
    public static void main(String[] args){
        MusicDaoImpl mdi = new MusicDaoImpl();
        mdi.createMusicTable();
        Music music = new Music();
        mdi.insert(music);
    }
}
