package in.tp.wfd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tp.wfd.entity.Product;
import in.tp.wfd.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public Flux<?> getAll() {
		return productService.getAll();
	}

	@GetMapping("{id}")
	public Mono<Product> getById(@PathVariable("id") final String id) {
		return productService.getById(id);
	}

	@PutMapping("{id}")
	public Mono<?> updateById(@PathVariable("id") final String id, @RequestBody final Product product) {
		return productService.update(id, product);
	}

	@PostMapping
	public Mono<?> save(@RequestBody final Product product) {
		return productService.save(product);
	}

	@DeleteMapping("{id}")
	public Mono<?> delete(@PathVariable final String id) {
		return productService.delete(id);
	}

}
