package Assessment.AutoRABIT_indiaJavaTalentHunt.Problem1;

import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        //test cases

    }

}
class Product{
    String prodectName;
    String coupon;
    double price;
    public Product(String productName,String coupon,double price){
        this.prodectName = productName;
        this.coupon = coupon;
        this.price = price;
    }

}

class Validator{
    public String validateCoupon(Product p) throws InvalidCouponException{
        if(!this.validateCouponFormat(p,p.coupon)) throw new InvalidCouponException("Invalid Coupon");
        else return "Valid Coupon";

    }
    private boolean validateCouponFormat(Product p,String coupon){
        if(coupon == null || !coupon.contains("-")) return false;
        String[] parts = coupon.split("-");
        if(!p.prodectName.equals(parts[0])) return false;
        int discount = Integer.valueOf(parts[1]);
        if(!(discount >= 10 && discount <= 25)) return false;
        return true;


    }

    public double netPrice(Product p){
        double discountedPrice = 0.0;
        try{
            String methodResponse = validateCoupon(p);
            String[] parts = p.coupon.split("-");
            double discount = Integer.valueOf(parts[1]);
            double productPrice = p.price;
            discountedPrice =productPrice - (discount/100*productPrice);

        }catch(InvalidCouponException e){
            System.out.println(e.getMessage());
            return p.price;
        }return discountedPrice;
    }


}

class InvalidCouponException extends Exception{
        public InvalidCouponException(String message){
            super(message);
        }
}
