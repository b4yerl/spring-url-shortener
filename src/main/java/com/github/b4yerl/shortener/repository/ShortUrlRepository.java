package com.github.b4yerl.shortener.repository;

import com.github.b4yerl.shortener.model.ShortUrl;
import org.springframework.data.repository.CrudRepository;

public interface ShortUrlRepository extends CrudRepository<ShortUrl, String> {
}
