package project.b.hexaAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import project.b.hexaAPI.dao.ProductDAO;

@Service
public class ProductService {
	
	private List<ProductDAO> products = new ArrayList<>();
	
	public ProductService() {
		products.add(new ProductDAO(1L, "NIKE AIRFORCE1", 2000000, "", "", false, false, true));
		products.add(new ProductDAO(2L, "NIKE DUNKSLAM9", 1990000,  "", "", false, false, true));
		products.add(new ProductDAO(3L, "NIKE JORDAN23", 28800000,  "", "", false, false, true));
		products.add(new ProductDAO(4L, "ThreeLine by 모란시장에디션", 9999.99,  "", "", false, false, true));
		products.add(new ProductDAO(5L, "non-slip 슬리퍼 by 이젠아카데미 3호관 ver", 19900.00,  "", "", false, false, true));
	}
	
	/*
	 * 전체 상품 조회
	 * id로 상품 조회
	 * 상품이름으로 상품 조회
	 * 상품 등록
	 * id로 상품 업데이트
	 * id로 상품 삭제 (미지원)
	 */
	
	public List<ProductDAO> getAllProducts() {
        return products;
    }
	
	public Optional<ProductDAO> getProductById(Long id){
		return products.stream()
				.filter(product -> product.getId().equals(id))
				.findFirst();
	}
	
	public Optional<ProductDAO> getProductByName(String name) {
		return products.stream()
				.filter(product -> product.getName().contains(name))
				.findAny();
	}
	
	public ProductDAO addProduct(ProductDAO product) {
		products.add(product);
		return product;
	}
	
	public Optional<ProductDAO> updateProduct(Long id, ProductDAO productForm) {
        Optional<ProductDAO> productInfo = getProductById(id);
        if (productInfo.isPresent()) {
            ProductDAO product = productInfo.get(); // source
            product.setId(id);
            product.setName(productForm.getName());
            product.setPrice(productForm.getPrice());
            product.setImgSrc(productForm.getImgSrc());
            product.setProductLink(productForm.getProductLink());
            product.setAddCart(productForm.isAddCart());
            product.setAddLike(productForm.isAddLike());
            product.setView(productForm.isView());
            return products.stream()
    				.filter(save -> save.getId().equals(id))
    				.findFirst();
        }
        return Optional.empty();
    }
	
//	public boolean deleteProduct(Long id) {
//        Optional<ProductDAO> optionalProduct = getProductById(id);
//        if (optionalProduct.isPresent()) {
//            products.remove(optionalProduct.get());
//            return true;
//        }
//        return false;
//    }

}
