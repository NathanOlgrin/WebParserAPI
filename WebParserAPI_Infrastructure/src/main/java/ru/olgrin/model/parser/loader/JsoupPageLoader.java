package ru.olgrin.model.parser.loader;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class JsoupPageLoader implements PageLoader {
    @Override
    public String load(String url) throws Exception {
//        Connection.Response response = Jsoup.connect("https://mid.ru/")
//                .userAgent("Mozilla/5.0 (Windows; U; Windows NT 6.1; rv:2.2) Gecko/20110201")
//                .referrer("https://www.google.com/")
//                .execute();
//        byte[] bytes = response.bodyAsBytes();
//        String html = new String(bytes, "windows-1251");
//        return html;

        String html = org.jsoup.Jsoup.connect(url)
                .userAgent("Chrome/139.0.7258.155 Safari/537.36")
                .referrer("https://www.google.com/")
                .get()
                .html();

        System.out.println(html);
        return html;
    }
}
