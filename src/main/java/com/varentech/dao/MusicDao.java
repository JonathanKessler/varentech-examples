package com.varentech.dao;

import com.varentech.entities.Music;

import java.util.List;

/**
 * Created by ParksW on 5/25/2016.
 */
public interface MusicDao {
    void createMusicTable();
    void insert(Music music);
    Music selectById(int id);

    List<Music> selectAll();
    void delete(int id);
    void update(Music music, int id);
}
