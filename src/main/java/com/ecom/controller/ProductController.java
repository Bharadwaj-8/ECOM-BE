package com.ecom.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.payload.ApiResponse;
import com.ecom.payload.ProductDto;
import com.ecom.service.FileService;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
    @Autowired
    private ProductService productService;
    
    
    
    @Autowired
    private FileService fileService;

    @Value("${product.images}")
    private String productPath;

    

    //    createProduct
    @PostMapping("/category/{catId}/products")
    public ResponseEntity<ProductDto> create(
            @RequestBody ProductDto productDto,
            @PathVariable Integer catId
    ) {
        ProductDto productDto1 = this.productService.create(productDto, catId);
        return new ResponseEntity<>(productDto1, HttpStatus.CREATED);
    }


    //get all products

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/not-live")
    public ResponseEntity<List<ProductDto>> getAllProductsNotLive() {
        return new ResponseEntity<>(this.productService.getProductNotLive(), HttpStatus.OK);
    }

    //update
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> update(
            @RequestBody ProductDto product,
            @PathVariable Integer productId)
    {
    	ProductDto update=this.productService.update(product, productId);
    	return new ResponseEntity<ProductDto>(update,HttpStatus.OK);
    }
    //delete

    @DeleteMapping("/{productId}")
    public ApiResponse delete(@PathVariable Integer productId)
    {
    	this.productService.delete(productId);
    	return new ApiResponse("product successfully deleted",true, HttpStatus.OK);
    }

    
    
    @PostMapping("/products/image/{productId}")
    public ResponseEntity<ApiResponse> uploadFile(
            @RequestParam("image") MultipartFile file,
            @PathVariable Integer productId
    ) throws Exception {
        ProductDto product = this.productService.getById(productId);
        String fileName = this.fileService.uploadFile(productPath, file);
        product.setImageName(fileName);
        this.productService.update(product, productId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setMessage(fileName);
        apiResponse.setSuccess(true);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    //serve product images

    @GetMapping(value = "/products/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void serveProductImage(
            @PathVariable String imageName,
            HttpServletResponse response
    ) throws IOException {

        InputStream data = this.fileService.getData(productPath, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(data, response.getOutputStream());

    }

    
    
    

}
