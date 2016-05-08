import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * ��ڳ���
 * 
 * @author ChenFeng
 * @version [�汾��, 2009-12-21]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
 */
public class XMLParseUtilTest {

	/**
	 * ��ں���
	 * 
	 * @param args
	 * @see [�ࡢ��#��������#��Ա]
	 */
	public static void main(String[] args) {
		String path = XMLParseUtilTest.class.getResource("NewFile.xml")
				.getPath();

		XMLParseUtil xmlParse = null;
		try {
			xmlParse = new XMLParseUtil();
		} catch (ParserConfigurationException e) {
			System.out.println("�쳣������XML��������������һ�����ص����ô���");
			e.printStackTrace();
		}
		if (null != xmlParse) {
			Document doc = null;
			try {
				doc = xmlParse.parseDocument(path);
			} catch (MalformedURLException e) {
				System.out.println("�쳣�������ļ�·�������Ҳ���Ҫ�������ļ���");
				e.printStackTrace();
			} catch (SAXParseException e) {
				System.out.println("�쳣���ļ���ʽ�����޷�������");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}

			if (null != doc) {
				NodeList bookNodeList = null;
				try {
					/**
					 * [title/@lang='en']��ʾѡȡ��book�ڵ㣬���������ӽڵ�title��lang����Ϊen
					 */
					bookNodeList = (NodeList) xmlParse.selectNodes(doc,
							"//div[contains(@class,'j_d_post_content')]");
				} catch (XPathExpressionException e) {
					System.out.println("�쳣��XPath���ʽ����");
					e.printStackTrace();
				}
				
				
				if (null != bookNodeList) {
					List<Book> bookList = new ArrayList<Book>();
					System.out.println(bookNodeList.getLength());
					for (int i = 0; i < bookNodeList.getLength(); i++) {
						Node node = bookNodeList.item(i);
						NodeList chNodes = node.getChildNodes();
						for(int j = 0; j < chNodes.getLength(); j++){
							Node chnode = chNodes.item(j);
							System.out.println("j+"+j+"_"+chnode.getTextContent()+chnode.getNodeValue());
						}
							
						System.out.println("i"+i+"_"+node.getTextContent()+node.getNodeValue());
						//Book book = parseBookNode(xmlParse, node);
						//bookList.add(book);
					}

//					for (Book book : bookList) {
//						System.out.println(book.toString());
//					}
				}
			}
		}
	}

	/**
	 * ��������book�ڵ�
	 * 
	 * @param util
	 * @param node
	 * @return
	 * @throws XPathExpressionException
	 * @see [�ࡢ��#��������#��Ա]
	 */
	public static Book parseBookNode(XMLParseUtil util, Node node) {
		String lang = "";
		String title = "";
		String author = "";
		String year = "";
		String price = "";

		try {
			title = util.getNodeStringValue(node, "./title");
		} catch (XPathExpressionException e) {
			System.out.println("�쳣��XPath���ʽ����");
			e.printStackTrace();
		}
		try {
			lang = util.getNodeStringValue(node, "./title/@lang");
		} catch (XPathExpressionException e) {
			System.out.println("�쳣��XPath���ʽ����");
			e.printStackTrace();
		}
		try {
			author = util.getNodeStringValue(node, "./author");
		} catch (XPathExpressionException e) {
			System.out.println("�쳣��XPath���ʽ����");
			e.printStackTrace();
		}
		try {
			year = util.getNodeStringValue(node, "./year");
		} catch (XPathExpressionException e) {
			System.out.println("�쳣��XPath���ʽ����");
			e.printStackTrace();
		}
		try {
			price = util.getNodeStringValue(node, "./price");
		} catch (XPathExpressionException e) {
			System.out.println("�쳣��XPath���ʽ����");
			e.printStackTrace();
		}

		Book book = new Book(lang, title, author, year, price);
		return book;
	}

}