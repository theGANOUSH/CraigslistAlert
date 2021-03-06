/**
 * 
 */
package common;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTime;

import views.MainWindow;

/**
 * @author alowe01
 *
 */
public class CraigslistSearch implements Runnable{
	
	private String baseURL = "https://orlando.craigslist.org/";

	private void search(String searchQuery) throws ParseException 
	{
		List<Item> postings = new LinkedList<Item>();
		WebClient client = new WebClient();
	
		client.getOptions().setCssEnabled(false);
		//Need to try and resolve the SSL issue
		client.getOptions().setUseInsecureSSL(true);
		client.getOptions().setJavaScriptEnabled(false);
		
		try {
			String searchUrl = baseURL + "search/sss?sort=rel&query=" + URLEncoder.encode(searchQuery, "UTF-8");
			
			HtmlPage page = client.getPage(searchUrl);
			List<HtmlElement> items = page.getByXPath("//li[@class='result-row']");
			if(items.isEmpty())
			{
				System.out.println("No Items Found!");
			}
			else
			{
				for(HtmlElement htmlItem : items)
				{
					HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem.getFirstByXPath(".//p[@class='result-info']/a"));
					HtmlTime postDate = htmlItem.getFirstByXPath(".//time[@class='result-date']");
					HtmlElement spanPrice = ((HtmlElement) htmlItem.getFirstByXPath(".//a/span[@class='result-price']")) ;
					
					String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText();
					
					Item item = new Item();
					item.setTitle(itemAnchor.asText());
					item.setUrl(itemAnchor.getHrefAttribute());
					item.setPrice(new BigDecimal(itemPrice.replace("$", "")));
					item.setPostDate(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(postDate.getAttribute("datetime")));
					
					postings.add(item);
					
				}
			}
		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Email.sendEmail();
		
		client.close();
		Action.listings = postings;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			search(MainWindow.getText());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
