package crawler.example;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.abola.crawler.CrawlerPack;


/**
 * 資料探索練習 Facebook Graph Api Search 
 * 
 * 重點
 * 1. 利用Graph Api調整出需要的資料
 * 2. 取得一組Access Token (long term token)
 * 3. 試著用你會的方式，先行探索資料
 * 
 * @author Abola Lee
 *
 */
public class FBInsights {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑
		// >>>Fill here<<< 
		String uri = 
				"https://graph.facebook.com/v2.5/"
				+ "search?q=%E7%94%9C%E9%BB%9E&type=page&limit1000&fields=name,id,likes,talking_about_count"  // 補完
				+ "&access_token=EAAQoukrttYsBACMW4Wug7bmQJZC3ilW0hAytYExz9Lp5dFBe4Yyf9alDNFiYMFu1lvkChy3fzSUzeb5D0Re6jtbbOJF4iGjqQ6T9Ep9KAyCgZBZCnFZAXPmhkM9ICiZCjKjVmNG9379dH8saB368OQTLsZBHZCru1oZD";  
		   //curl -i -X GET \
		   //"https://graph.facebook.com/v2.0/search?q=%E7%94%9C%E9%BB%9E&type=page&limit100&fields=name%2Cid%2Clikes%2Ctalking_about_count&access_token=EAACEdEose0cBAJunojH0atioCt9c7k3KZBZAtfJZCUunIFgl8H0gUPMepz3nvhBaMRztPH2cKPlkumSl1094CnX97AeHjQvo3mhpZAQwZCBW8uc7F0MM0KaZCiMrygrS8DJxZBhUMFZAG0YcigcPvuGzdZBKx5ANt9TisrdRTelG8RAZDZD"
		// Jsoup select 後回傳的是  Elements 物件
		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,按讚數,名稱,討論人數\n";
		
		// 遂筆處理
		for( Element data: elems ){
			
			// 如何取出資料??
			// >>>Fill here<<< 
			String id =  data.select("id").text();
			String likes = data.select("likes").text();
			String name = data.select("name").text();
			String talking_about_count = data.select("talking_about_count").text();
			
			output += id+","+likes+",\""+name+"\","+talking_about_count+"\n";
		}
		
		System.out.println( output );
	} 
}
