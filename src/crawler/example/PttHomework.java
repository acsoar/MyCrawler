package crawler.example;

import com.github.abola.crawler.CrawlerPack;


/**
 * 簡易練習
 * 
 * 找出所有文章中按推的id
 * 
 * @author Abola Lee
 *
 */
public class PttHomework {
	
	public static void main(String[] args) {
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1459039136.A.8E7.html";
		

		System.out.println( 
			CrawlerPack.start()
			    .addCookie("over18", "1")
				.getFromHtml(uri)
				//.select("span.f1:containsOwn(噓)+ .push-userid") // 如何取得按推的id ? >>>Fill here<<< 
				//.select("span.f3.push-content") //抓全部推文內容
				//.select("span.f1:contains(噓)+ .push-userid + .push-content")
				//.select("span.f1:contains(噓) ~ .push-content")
				//.select("span.f1:containsOwn(噓)~ span")
				
				
				
				.toString()
		);
	}
}
