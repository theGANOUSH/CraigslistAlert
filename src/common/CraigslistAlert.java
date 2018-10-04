/**
 * 
 */
package common;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @author alowe01
 *
 */
public class CraigslistAlert{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String searchQuery = "Mazda 3";
		String baseURL = "https://orlando.craigslist.org/";
		
		WebClient client = new WebClient();
		
		client.getOptions().setCssEnabled(false);
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
					HtmlElement spanPrice = ((HtmlElement) htmlItem.getFirstByXPath(".//a/span[@class='result-price']")) ;
					
					String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText();
					
					Item item = new Item();
					item.setTitle(itemAnchor.asText());
					item.setUrl(baseURL + itemAnchor.getHrefAttribute());
					item.setPrice(new BigDecimal(itemPrice.replace("$", "")));
					
					ObjectMapper mapper = new ObjectMapper();
					String jsonString = mapper.writeValueAsString(item);
					
					System.out.println(jsonString);
					
				}
			}
		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		client.close();
		views.MainWindow mW = new views.MainWindow();
		mW.setVisible(true);
		//Email.sendEmail();
		
	}
}
