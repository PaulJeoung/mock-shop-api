package project.b.hexaAPI.dao;

public class ProductDAO {
	
	private Long id;
	private String name;
	private double price;
	private String imgSrc;
	private String productLink;
	private boolean addCart;
	private boolean addLike;
	private boolean view;
	
	public ProductDAO(Long id, String name, double price, String imgSrc, String productLink, boolean addCart,
			boolean addLike, boolean view) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgSrc = imgSrc;
		this.productLink = productLink;
		this.addCart = addCart;
		this.addLike = addLike;
		this.view = view;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getProductLink() {
		return productLink;
	}
	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}
	public boolean isAddCart() {
		return addCart;
	}
	public void setAddCart(boolean addCart) {
		this.addCart = addCart;
	}
	public boolean isAddLike() {
		return addLike;
	}
	public void setAddLike(boolean addLike) {
		this.addLike = addLike;
	}
	public boolean isView() {
		return view;
	}
	public void setView(boolean view) {
		this.view = view;
	}

}
