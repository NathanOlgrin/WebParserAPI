package ru.olgrin.domain.loader;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class JsoupPageLoader implements PageLoader{
    @Override
    public String load(String url) throws Exception {
        Connection.Response response = Jsoup.connect("https://mid.ru/")
                .userAgent("Mozilla/5.0 (Windows; U; Windows NT 6.1; rv:2.2) Gecko/20110201")
                .referrer("https://www.google.com/")
                .execute();
        byte[] bytes = response.bodyAsBytes();
        String html = new String(bytes, "windows-1251");
        return html;
    }
}
