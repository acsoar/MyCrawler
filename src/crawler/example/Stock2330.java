package crawler.example;

import com.github.abola.crawler.CrawlerPack;

/**
 * 練習擷取證交所提供的盤後資訊
 * 
 * 重點
 * 1. 如何使用 Regular Expression 取出表格中的數值資料
 * 
 * @author Abola Lee
 *
 */
public class Stock2330 {
	
	public static void main(String[] args) {
		// 2330 
		String uri = "http://www.twse.com.tw"
				+ "/ch/trading/exchange/STOCK_DAY/genpage"
				+ "/Report201602/201602_F3_1_8_2330.php"
				+ "?STK_NO=2330&myear=2016&mmon=03";
		
		System.out.println( 
			CrawlerPack.start()
				.setRemoteEncoding("big5")
				.getFromHtml(uri)
				.select("") // 如何取得證交取的數字格式 >>>Fill here<<< 
		);
		
		
	}
}
