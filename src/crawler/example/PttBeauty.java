package crawler.example;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.abola.crawler.CrawlerPack;
 
/**
 * 範例: 正妹牆程式
 * 輸出圖片的 List<網址>
 * 
 */
public class PttBeauty {
 
    final static String beautyMainPage = "https://www.ptt.cc/bbs/Beauty/index.html";
    final static String beautyIndexPage = "https://www.ptt.cc/bbs/Beauty/index%s.html";
    // 取得最後幾篇的文章數量
    static Integer loadLastPosts = 10; 

    public static List<String> getBeauty(){

        String prevPage =
            CrawlerPack.start()
                .getFromHtml(beautyMainPage)            // 遠端資料格式為 HTML
                .select(".action-bar .pull-right > a")  // 取得右上角『前一頁』的內容
                .get(1).attr("href")
                .replaceAll("/bbs/Beauty/index([0-9]+).html", "$1");
        
        // 目前最末頁 index 編號
        Integer lastPage = Integer.valueOf(prevPage)+1;

        List<String> lastPostsLink = new ArrayList<String>();

        // 不斷往前翻頁，直到文章數量取得完整為止
        while ( loadLastPosts > lastPostsLink.size() ){
            String currPage = String.format(beautyIndexPage, lastPage--);

            Elements links =
                CrawlerPack.start()
                    .getFromHtml(currPage)
                    .select(".title > a");

            for( Element link: links) lastPostsLink.add( link.attr("href") );
        }

        List<String> imgs = new ArrayList<>();
        // 檢視結果
        for(String url : lastPostsLink){
        	
        	// 取得文章中的圖片
        	Elements posts = CrawlerPack.start()
        		.getFromHtml("https://www.ptt.cc" + url)
        		// >>>Fill here<<< 
        		.select("");
        	
        	// 請將取得圖片的 url 轉成 List
        	// 並 add 到 imgs 變數中
        	// imgs.add( ... )
        	// >>>Fill here<<< 
        	
        	// 還記得為什麼要加這行嗎？
        	try { Thread.sleep(150); } catch (InterruptedException e) {/*do nothing*/}
        }
        
        return imgs;
    }
}