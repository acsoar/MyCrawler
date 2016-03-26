package crawler.example;

import org.jsoup.Jsoup;

/**
 * Jsoup 碰到壓縮格式就投降了
 * 
 * @author Abola Lee
 *
 */
public class JsoupProb {
	public static void main(String[] args) throws Exception{
		// no compressed file support
		System.out.println(
			// Jsoup.connect("http://en.wikipedia.org/").get()
			Jsoup.connect("http://tisvcloud.freeway.gov.tw/roadlevel_info.xml.gz").get()
	    );
	}
}
