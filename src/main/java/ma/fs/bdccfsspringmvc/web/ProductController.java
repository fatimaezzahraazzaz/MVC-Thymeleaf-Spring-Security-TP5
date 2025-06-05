package ma.fs.bdccfsspringmvc.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import ma.fs.bdccfsspringmvc.entities.Product;
import ma.fs.bdccfsspringmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/products") // (optionnel) si tu veux regrouper toutes les routes sous un préfixe
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Affichage de la liste des produits
    @GetMapping("/user/index")
    @PreAuthorize("hasRole('USER')")
    public String index(Model model) {
        List<Product> productsList = productRepository.findAll();
        model.addAttribute("productsList", productsList);
        return "products";
    }

    // Suppression d’un produit par ID (admin uniquement)
    @PostMapping("/admin/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }

    // Redirection de la racine vers /user/index
    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }

    // Formulaire pour ajouter un nouveau produit
    @GetMapping("/admin/newProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";
    }

    // Sauvegarde du produit (validation incluse)
    @PostMapping("/admin/saveProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "new-product";
        }
        productRepository.save(product);
        return "redirect:/admin/newProduct";
    }
    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }


    @GetMapping("/admin/editProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public String editProduct(@RequestParam Long id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("product", product);
        return "edit-product"; // ce fichier HTML
    }


}
