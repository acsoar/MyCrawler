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
				"https://graph.facebook.com/v2.5"
				+ "/search?"  // 補完
				+ "&access_token=";  

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
			String id =  data.select("").text();
			String likes = data.select("").text();
			String name = data.select("").text();
			String talking_about_count = data.select("").text();
			
			output += id+","+likes+",\""+name+"\","+talking_about_count+"\n";
		}
		
		System.out.println( output );
	} 
}
