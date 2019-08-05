package com.ityongman.springcache.service;

import java.util.List;

public interface MusicService {
	List<String> findAll();

    String findByIndex(int index);

    void save(String instrument);

    void delete(String instrument);

    void deleteAll();

    String play( final String instrument );
}
