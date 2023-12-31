package com.github.b4yerl.shortener.controller;

import com.github.b4yerl.shortener.dto.UrlRequest;
import com.github.b4yerl.shortener.dto.UrlResponse;
import com.github.b4yerl.shortener.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/url")
public class ShortUrlController {
    private ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService service) {
        this.shortUrlService = service;
    }

    @GetMapping("/{shortUrl}")
    public RedirectView getOriginalUrl(@PathVariable("shortUrl") String shortUrl) {
        return shortUrlService.redirect(shortUrl);
    }

    @PostMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public UrlResponse shortenUrl(@RequestBody UrlRequest request) {
        String originalUrl = request.getOriginalUrl();
        return shortUrlService.shortIt(originalUrl);
    }
}
