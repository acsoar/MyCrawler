package crawler.example;

import com.github.abola.crawler.CrawlerPack;

/**
 * 練習： 實價登錄資料取得
 * 
 * 重點
 * 1. 練習找出實價登錄公開資料源
 * 2. zip 格式資料如何取出指定檔案
 * 
 * @author Abola Lee
 *
 */
public class RealPrice {
	public static void main(String[] args) {
		// >>>Fill here<<< 
		String uri = "";
		
		// 印出整份 XML 資料
		System.out.println( 
			CrawlerPack.start()
				.getFromXml(uri)
				.toString()
		);
		
		
	}	
	
}
