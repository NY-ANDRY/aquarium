package com.aquarium.controllers.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aquarium.models.tables.Area;
import com.aquarium.models.tables.Cart;
import com.aquarium.models.tables.CartDetail;
import com.aquarium.models.tables.DiscountCart;
import com.aquarium.models.tables.User;
import com.aquarium.services.AreaService;
import com.aquarium.services.CartDetailService;
import com.aquarium.services.CartService;
import com.aquarium.services.DiscountCartService;
import com.aquarium.services.ProductService;
import com.aquarium.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/client/cart")
public class CartController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartDetailService cartDetailService;
    @Autowired
    private DiscountCartService discountCartService;
    @Autowired
    private AreaService areaService;

    public CartController() {
    }

    @GetMapping("")
    public String viewProducts(Model model, HttpSession session) {

        Long idCart = (Long) session.getAttribute("idCart");

        if (idCart != null) {
            model.addAttribute("cart", cartService.makeCart(idCart));
        } else {
            model.addAttribute("cart", new Cart());
        }
        model.addAttribute("areas", areaService.getAllAreas());

        return "client/cart/index";
    }

    @GetMapping("/param")
    public String viewP(Model model, HttpSession session) {
        DiscountCart dc = discountCartService.getAllDiscountCart().get(0);
        model.addAttribute("paramm", dc);
        model.addAttribute("parammm", productService.getAllProducts().get(0));
        return "client/cart/param";
    }

    @PostMapping("/area")
    public String addArea(@RequestParam("idArea") Long idArea, @RequestParam("idCartDetail") Long idCartDetail,
            HttpSession session) {

        Area a = areaService.getarea(idArea);
        CartDetail cd = cartDetailService.findById(idCartDetail);
        cd.setArea(a);
        cartDetailService.save(cd);

        return "redirect:/client/cart";
    }

    @PostMapping("")
    public String viewModel(@RequestParam("idProduct") Long idProduct,
            @RequestParam("qtt") Integer qtt, Model model,
            HttpSession session) {

        Long idCart = (Long) session.getAttribute("idCart");
        Long idUser = (Long) session.getAttribute("idUser");
        User u = userService.getUser(idUser);

        if (idCart == null) {
            Cart c = cartService.createCart(u, idProduct, qtt);
            session.setAttribute("idCart", c.getId());
        } else {
            Cart c = cartService.findById(idCart);
            c = cartService.addDetails(c, idProduct, qtt);
        }
        return "redirect:/client/cart";
    }

}
