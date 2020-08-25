package zcrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex2 {
	public static void main(String[] args) throws Exception{
		
		Document doc = Jsoup.connect("https://movie.daum.net/moviedb/grade?movieId=127897").get();
		
		//System.out.println(doc);
		
		Elements lis = doc.select(".list_review li");
		
		//System.out.println(lis);
		for(Element li : lis) {
			
			//1. 닉네임
			String nickname = li.select(".review_info .link_review .link_profile").get(0).text();
			System.out.println(nickname);
			
			//2. 평점
			String score = li.select(".review_info .raking_grade .emph_grade").get(0).text();
			String total = li.select(".review_info .raking_grade .txt_grade").get(0).text();
			
			System.out.println(score + total);
			
			//3. 리뷰
			String review = li.select(".review_info .desc_review").get(0).text();
			System.out.println(review);
			
			//4. 날짜
			String append_reviewDate = li.select(".review_info .append_review .info_append").get(0).text();
			System.out.println(append_reviewDate);
			System.out.println("-------------------------------------------------------------------------");
		}
	}
}
