package com.github.b4yerl.shortener.service;

import com.github.b4yerl.shortener.dto.UrlResponse;
import com.github.b4yerl.shortener.mapper.BytesToHex;
import com.github.b4yerl.shortener.model.ShortUrl;
import com.github.b4yerl.shortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.RedirectView;

import java.security.SecureRandom;
import java.util.Optional;

@Component
public class ShortUrlService {
    @Autowired
    ShortUrlRepository repository;

    public UrlResponse shortIt(String originalUrl) {
        String shortUrl = "";
        boolean isOriginalSequence = false;

        while(!isOriginalSequence) {
            byte[] rawRandomBytes = new byte[4];
            new SecureRandom().nextBytes(rawRandomBytes);
            shortUrl = BytesToHex.convert(rawRandomBytes);
            if (!repository.existsById(shortUrl)) break;
        }

        UrlResponse newEntry = new UrlResponse();
        newEntry.setSuccess(true);
        newEntry.setStatus(HttpStatus.CREATED.value());
        newEntry.setOriginalUrl(originalUrl);
        newEntry.setShortUrl(shortUrl);

        System.out.println("NEW ENTRY: " + newEntry);
        repository.save(new ShortUrl(shortUrl, originalUrl));

        return newEntry;
    }

    public RedirectView redirect(String shortUrl) {
        RedirectView redirector = new RedirectView();
        Optional<ShortUrl> queryResult = repository.findById(shortUrl);
        if(!queryResult.isPresent()){
            redirector.setUrl("/error");
            redirector.setStatusCode(HttpStatus.NOT_FOUND);
            return redirector;
        }
        String originalUrl = queryResult.get().getOriginalUrl();
        redirector.setUrl(originalUrl);
        redirector.setStatusCode(HttpStatus.FOUND);
        return redirector;
    }
}
