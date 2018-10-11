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
		
		
		views.MainWindow mW = new views.MainWindow();
		mW.setVisible(true);
		//Email.sendEmail();
		
	}
}
