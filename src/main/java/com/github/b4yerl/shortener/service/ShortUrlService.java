package com.github.b4yerl.shortener.service;

import com.github.b4yerl.shortener.mapper.BytesToHex;
import com.github.b4yerl.shortener.model.ShortUrl;
import com.github.b4yerl.shortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.RedirectView;

import java.security.SecureRandom;
import java.util.Optional;

@Component
public class ShortUrlService {
    @Autowired
    ShortUrlRepository repository;
    public ShortUrl shortIt(String originalUrl) {
        String shortUrl = "";
        boolean isOriginalSequence = false;

        while(!isOriginalSequence) {
            byte[] rawRandomBytes = new byte[4];
            new SecureRandom().nextBytes(rawRandomBytes);
            shortUrl = BytesToHex.convert(rawRandomBytes);
            if (!repository.existsById(shortUrl)) break;
        }

        ShortUrl newEntry = new ShortUrl();
        newEntry.setOriginalUrl(originalUrl);
        newEntry.setShortUrl(shortUrl);

        System.out.println("NEW ENTRY: " + newEntry);
        repository.save(newEntry);

        return newEntry;
    }

    public RedirectView redirect(String shortUrl) {
        Optional<ShortUrl> queryResult = repository.findById(shortUrl);
        if(!queryResult.isPresent()) return new RedirectView("/error");
        String originalUrl = queryResult.get().getOriginalUrl();
        return new RedirectView(originalUrl);
    }
}
