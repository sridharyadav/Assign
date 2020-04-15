package com.cg.crud.CRUD;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	private static Map<String,Product> product=new HashMap<String,Product>();
	static
	{
		Product honey =new Product();
		honey.setPid("1");
		honey.setPname("Honey");
		product.put(honey.getPid(),honey);
		
		Product almonds=new Product();
		almonds.setPid("2");
		almonds.setPname("u");
		product.put(almonds.getPid(), almonds);
	}
	@RequestMapping(value="/products")
	public ResponseEntity<Object> getProducts()
	{
		return new ResponseEntity<>(product.values(),HttpStatus.OK);
	}
	@RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id)
	{
		product.remove(id);
		return new ResponseEntity<>("Product Deleted SucessFully",HttpStatus.OK);
		
	}
	@RequestMapping(value="/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object>updateProduct(@PathVariable("id") String id,@RequestBody Product pro)
	{
		product.remove(id);
		pro.setPid(id);
		product.put(id, pro);
		return new ResponseEntity<>("Product Updated SucessFully",HttpStatus.OK);
		
	}
	 @RequestMapping(value="/products", method = RequestMethod.POST)
	   public ResponseEntity<Object> createProduct(@RequestBody Product pro) {
	      product.put(pro.getPid(),pro);
	      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	   }
	

}

