package net.code.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        // Kategorileri oluştur
        Category technologyCategory = new Category("Technology");
        Category cosmeticsCategory = new Category("Cosmetics");
        Category clothesCategory = new Category("Clothes");

        // Kategorileri kaydet
        categoryRepository.save(technologyCategory);
        categoryRepository.save(cosmeticsCategory);
        categoryRepository.save(clothesCategory);

        // Ürünleri oluştur ve kategorileri ata
        Product laptop = new Product("Laptop", "Lenovo laptop.", new BigDecimal("1000"), technologyCategory);
        Product airpods = new Product("Airpods", "Apple airpods.", new BigDecimal("120"), technologyCategory);
        Product macbookAir = new Product("Macbook Air", "Computer laptop.", new BigDecimal("1500"), technologyCategory);
        Product samsungS3 = new Product("Samsung S3", "Telephone.", new BigDecimal("1000"), technologyCategory);
        Product ipad = new Product("Ipad", "Apple IPAD.", new BigDecimal("500"), technologyCategory);
        Product mouse = new Product("Mouse", "Computer mouse.", new BigDecimal("10"), technologyCategory);

        Product chanelNo5 = new Product("Chanel No.5", "Elegant perfume from Chanel.", new BigDecimal("150"), cosmeticsCategory);
        Product macLipstick = new Product("MAC Lipstick", "High-quality lipstick from MAC.", new BigDecimal("25"), cosmeticsCategory);
        Product esteeLauderFoundation = new Product("Estée Lauder Foundation", "Long-lasting foundation from Estée Lauder.", new BigDecimal("50"), cosmeticsCategory);
        Product lorealMascara = new Product("L'Oréal Mascara", "Volumizing mascara from L'Oréal.", new BigDecimal("10"), cosmeticsCategory);
        Product maybellineEyeshadow = new Product("Maybelline Eyeshadow Palette", "Eyeshadow palette from Maybelline.", new BigDecimal("20"), cosmeticsCategory);
        Product revlonBlush = new Product("Revlon Blush", "Blush from Revlon.", new BigDecimal("15"), cosmeticsCategory);

        Product tShirt = new Product("T-Shirt", "Cotton t-shirt.", new BigDecimal("20"), clothesCategory);
        Product jeans = new Product("Jeans", "Blue jeans.", new BigDecimal("50"), clothesCategory);
        Product sweater = new Product("Sweater", "Warm sweater.", new BigDecimal("30"), clothesCategory);
        Product dress = new Product("Dress", "Evening dress.", new BigDecimal("100"), clothesCategory);
        Product jacket = new Product("Jacket", "Leather jacket.", new BigDecimal("80"), clothesCategory);
        Product shoes = new Product("Shoes", "Running shoes.", new BigDecimal("70"), clothesCategory);

        // Ürünleri kaydet
        productRepository.save(laptop);
        productRepository.save(airpods);
        productRepository.save(macbookAir);
        productRepository.save(samsungS3);
        productRepository.save(ipad);
        productRepository.save(mouse);
        productRepository.save(chanelNo5);
        productRepository.save(macLipstick);
        productRepository.save(esteeLauderFoundation);
        productRepository.save(lorealMascara);
        productRepository.save(maybellineEyeshadow);
        productRepository.save(revlonBlush);
        productRepository.save(tShirt);
        productRepository.save(jeans);
        productRepository.save(sweater);
        productRepository.save(dress);
        productRepository.save(jacket);
        productRepository.save(shoes);

        // Ekleme işlemi tamamlandıktan sonra bilgi yazdır
        System.out.println("Ürünler başarıyla eklendi!");
    }
}
