package crawler.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.abola.crawler.CrawlerPack;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * 整合練習：Yahoo Stock 個股成交明細
 * 
 * 目標取回 Yahoo Stock指定個股的交易明細資料
 * 但網頁只會保留最後50筆交易明細，所以必需排程
 * 在交易日的 AM 09:00 - PM 13:25不斷擷取
 * 並在14:45再補上最後盤後交易記錄
 * 
 * 重點
 * 1. 自動排程
 * 2. 復習 mongodb
 * 
 * @author Abola Lee
 *
 */
public class YahooStock {

	static Logger log = LoggerFactory.getLogger(YahooStock.class);
	// >>>Fill here<<< 
	final static String mongodbServer = ""; // your host name
	final static String mongodbDB = "";		// your db name
	
	static String stockNumber;
	
	// 每次取得最後50筆交易的內容
	static String uri_format = "https://tw.stock.yahoo.com/q/ts?s=%s&t=50";
	
	public static void main(String[] args) {
		
		// 要有輸入參數															
		if ( args.length >= 1){
			stockNumber = args[0];
		}else{
			// 沒輸入參數
			log.error("未輸入股號");
			
			// 技巧：NullPointerException 才能正確中止 Jenkins 的 job
			String forkException=null; 
			forkException.toString();
		}
		
		crawlerStockByNumber(stockNumber);
	}
	
	
	/**
	 * 依輸入的股號取得資料
	 * @param stockNumber
	 */
	static void crawlerStockByNumber(String stockNumber){

		// 遠端資料路徑
		String uri = String.format(uri_format, stockNumber);
		
		log.debug("Call remote uri: {}", uri);
		
		// 取得交易明細資料		
		Elements transDetail = 
			CrawlerPack.start()
				.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				.getFromHtml(uri)
				// 目標含有  成 交 明 細  的table
				// <td align="center" width="240">2330 台積電 成 交 明 細</td>
				// >>>Fill here<<
				.select("") ;

		// 分解明細資料表格
		List<DBObject> parsedTransDetail = parseTransDetail(transDetail);
		
		// 儲存明細
		saveTransDetail(parsedTransDetail);
	}
	
	/**
	 * 將明細資料表格，分解成 Mongodb物件的集合 
	 * 
	 * @param transDetail
	 * @return
	 */
	static List<DBObject> parseTransDetail(Elements transDetail){

		List<DBObject> result = new ArrayList<>();
		
		// 將以下分解出資料日期中的 105/03/25
		// <td width="180">資料日期：105/03/25</td>
		// >>>Fill here<<< 
		String day = "";  // day 要是 105/03/25 如何寫
		
		// 取出 header 以外的所有交易資料
		// >>>Fill here<<< 
		for(Element detail: transDetail.select("") ){
			
			Map<String, String> data = new HashMap<>();
			
/*			資料格式範例
  			<tr align="center" bgcolor="#ffffff" height="25">
			 <td>09:45:46</td>
			 <td class="low">158.00</td>
			 <td>158.50</td>
			 <td>158.50</td>
			 <td>－</td>
			 <td>1</td>
			</tr>
*/			
			data.put("stock", stockNumber);
			data.put("day", day);
			
			data.put("time", detail.select("td:eq(0)").text());
			data.put("buy", detail.select("td:eq(1)").text());
			data.put("sell", detail.select("td:eq(2)").text());
			data.put("strike", detail.select("td:eq(3)").text());
			data.put("volume", detail.select("td:eq(5)").text());
			
			result.add( new BasicDBObject(data) );
		}
		return result;
	} 
	
	/**
	 * 將分解完的明細資料全部存回mongodb
	 * 
	 * @param parsedTransDetail
	 */
	static void saveTransDetail(List<DBObject> parsedTransDetail){

		MongoClient mongoClient ;
		try {
			
			// 如何將資料寫回 mongodb ?
			// >>>Fill here<<< 
			
		} catch (Exception e) {
			log.warn(e.getMessage());
		}
	}
}
