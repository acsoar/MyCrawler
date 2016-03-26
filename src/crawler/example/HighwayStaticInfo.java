package crawler.example;

import com.github.abola.crawler.CrawlerPack;

/**
 * 練習 高公局即時路況資料
 * 
 * @author Abola Lee
 *
 */
public class HighwayStaticInfo {

	public static void main(String[] args) {
		
		// 遠端資料路徑
		// 要如何將  cms_value.xml.gz 解開變成 cms_value.xml?
		// >>>Fill here<<< 
		String uri = ""
					+"http://tisvcloud.freeway.gov.tw/cms_value.xml.gz";
		

		System.out.println(
				CrawlerPack.start()
			    .getFromXml(uri)
		);
	}
}
