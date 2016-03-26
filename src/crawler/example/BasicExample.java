package crawler.example;

import com.github.abola.crawler.CrawlerPack;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class BasicExample {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑
		String uri = "http://.../";

		System.out.println(
				CrawlerPack.start()
				
				// 參數設定
			    //.addCookie("key","value")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				
				// 選擇資料格式 (三選一)
				.getFromJson(uri)
			    //.getFromHtml(uri)
			    //.getFromXml(uri)
			    
			    // 這兒開始是 Jsoup Document 物件操作
			    .select(".css .selector ")
			    
		);
	}
}
