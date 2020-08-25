package zcrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex1 {

	public static void main(String[] args)throws Exception {
		
		Document doc = Jsoup.connect("https://movie.daum.net/boxoffice/weekly").get();
		
		//System.out.println(doc);
		
		Elements lis = doc.select(".list_movie li");
		
		for (Element li : lis) {
			
			String title = li.select(".wrap_movie .name_movie").get(0).text();
			
			System.out.println(title);
			
			String src = li.select(".thumb_movie img").attr("src");
			
			System.out.println(src);
			
			String movieId = li.select(".wrap_desc a").get(0).attr("data-tiara-id");
			
			System.out.println(movieId);
			
		}
		
	}
}
