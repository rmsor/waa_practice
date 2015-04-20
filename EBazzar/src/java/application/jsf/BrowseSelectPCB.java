    /*
 * This is a Presentation Control Bean for the browse and select use case.  It
 * is intended to hold JSF action methods for the Browse and 
 * Select use case.
 * 
 * It will also hold fields accessed by the JSF pages.
 * 
 * @since 8/4/08 -- had to add the imports
 * @author levi
 */

package application.jsf;

import application.BrowseSelectController;
import business.productSubsystem.MPTestProductSubsystemFacade;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ProductSubsystem;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named("bsControllerPCB")
@SessionScoped
public class BrowseSelectPCB implements Serializable{
    ProductSubsystem stubProdSS = new MPTestProductSubsystemFacade();

    BrowseSelectController bsController = new BrowseSelectController(stubProdSS);
    
    List<String> catalogNames;
    List<Product> products;
    List<String[]> cart;
    
    private String selectedCatalog = "";
    private String selectedProductStr;
    private Product selectedProduct;
    private int quantity;
    
    public String viewCatalogs(){
        catalogNames = bsController.getCatalogNames();
        return "catalog";
    }
    
    public String viewProducts(){
        products = bsController.getProducts(selectedCatalog);
        return "product";
    }

    public String viewProductDetails(){
        selectedProduct = bsController.getProduct(selectedProductStr);
        return "productDetails";
    }
    
    public String addToCart(){
        bsController.validateQuantity();
        bsController.add2Cart(selectedProduct.getProdName(), quantity);
        cart = bsController.getCartDisplayList();
        return "cart";
    }
    
    public String checkout(){
        
        return "checkout";
    }

    public List<String> getCatalogNames() {
        return catalogNames;
    }

    public void setCatalogNames(List<String> catalogNames) {
        this.catalogNames = catalogNames;
    }

    public String getSelectedCatalog() {
        return selectedCatalog;
    }

    public void setSelectedCatalog(String selectedCatalog) {
        this.selectedCatalog = selectedCatalog;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getSelectedProductStr() {
        return selectedProductStr;
    }

    public void setSelectedProductStr(String selectedProductStr) {
        this.selectedProductStr = selectedProductStr;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String[]> getCart() {
        return cart;
    }

    public void setCart(List<String[]> cart) {
        this.cart = cart;
    }

}

