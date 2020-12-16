package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ProductDao;
import pl.coderslab.model.Cart;
import pl.coderslab.model.CartItem;
import pl.coderslab.model.Product;

@Controller
public class CartController {
    @Autowired
    private Cart cart;
    @Autowired
    private ProductDao productDao;

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart(@RequestParam Long id, @RequestParam int quantity) {
        Product product = null;
        for (Product element : productDao.getList()) {
            if (id == element.getId()) {
                product = element;
                break;
            }
        }

        if (product == null) {
            return "Nie ma produktu o podanym id";
        } else {
            boolean exist = false;
            for (CartItem cartItem : cart.getCartItems()) {
                if (cartItem.getProduct().getId() == product.getId()) {
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                    exist = true;
                }
            }

            if (!exist) {
                cart.addToCart(new CartItem(quantity, product));
            }
            return "addtocart";
        }
    }

    @RequestMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("cart", cart);
        model.addAttribute("cartItemsCount", cart.getCartItems().size());

        int productCount = 0;
        Double sum = 0d;
        for (CartItem cartItem : cart.getCartItems()) {
            productCount += cartItem.getQuantity();
            sum += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        model.addAttribute("productCount", productCount);
        model.addAttribute("sum", sum);
        return "cart";
    }
}