

/**
 * Book��
 * 
 * @author ChenFeng
 * @version [�汾��, 2009-12-21]
 * @see [�����/����]
 * @since [��Ʒ/ģ��汾]
 */
public class Book {
	private String lang;

	private String title;

	private String author;

	private int year;

	private double price;

	public Book() {
	}

	public Book(String lang, String title, String author, String year,
			String price) {
		this.lang = lang;
		this.title = title;
		this.author = author;
		this.year = (int) Integer.valueOf(year);
		this.price = (double) Double.valueOf(price);
	}

	public Book(String lang, String title, String author, int year, double price) {
		this.lang = lang;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = (int) Integer.valueOf(year);
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = (double) Double.valueOf(price);
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean equals(Object object) {
		Book b = (Book) object;
		if (this.lang.equals(b.getLang()) && this.title.equals(b.getTitle())
				&& this.author.equals(b.getAuthor())
				&& this.year == b.getYear() && this.price == b.price) {
			return true;
		}
		return false;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer("");
		buf.append("Book{\n").append("  lang=").append(lang)
				.append("\n  title=").append(title).append("\n  author=")
				.append(author).append("\n  year=").append(year)
				.append("\n  price=").append(price).append("\n}");
		return buf.toString();
	}
}