package project.b.hexaAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.b.hexaAPI.dao.ProductDAO;
import project.b.hexaAPI.service.ProductService;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;

@RestController
@RequestMapping("/api/hexa-products")
public class ProductController {
	
	/*
	 * 전체 상품 조회
	 * id로 상품 조회
	 * 상품이름으로 상품 조회
	 * 상품 등록
	 * id로 상품 업데이트
	 * id로 상품 삭제 (미지원)
	 */
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public List<ProductDAO> getAllProducts() {
		return productService.getAllProducts();
	}
	
    @GetMapping("/{id}")
    public ProductDAO getProductById(@PathVariable Long id) {
        Optional<ProductDAO> product = productService.getProductById(id);
        return product.orElse(null);
    }
    
    @GetMapping("/list/{name}")
    public ProductDAO getProductByName(@PathVariable String name) {
    	Optional<ProductDAO> product = productService.getProductByName(name);
    	return product.orElse(null);
    }

    @PostMapping("/")
    public ProductDAO addProduct(@RequestBody ProductDAO product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Optional<ProductDAO> updateProduct(@PathVariable Long id, @RequestBody ProductDAO productForm) {
        return productService.updateProduct(id, productForm);
    }

//    @DeleteMapping("/{id}")
//    public boolean deleteProduct(@PathVariable Long id) {
//        return productService.deleteProduct(id);
//    }
}
