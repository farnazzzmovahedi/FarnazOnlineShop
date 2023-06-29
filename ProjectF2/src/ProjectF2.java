import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

public class ProjectF2 implements Serializable{
    public static void main(String[] args) throws IOException , FileNotFoundException
    {
        Menu menu = new Menu();
        Buyer buyer = new Buyer("mahya1" , "mahya" , "jafari" , "mahyaj" , "454" , "123" , "12000");
        //Buyer buyer2 = new Buyer("parsa2" , "parsa" , "neshat" , "parsan" , "789" , "456" , "10000");
        Seller seller = new Seller("yalda1" , "yalda" , "zand" , "yaldaz" , "762" , "789" , "kaleh" , "2/7/1400" , "this is the.." ,"10000");
        Seller seller2 = new Seller("sepehr2" , "sepehr" , "jamshidi" , "sepehrj" , "123" , "159" , "wourld" , "4/11/1400" , "the wourld.." ,"15000");
        Laptop l1 = new Laptop("lb" , "l12" , 1200 , "yalda1" , true , "kaks" , 2 , 4 , 5 , "dw" , 44 , 65 , "srdf" , true);
        Laptop l2 = new Laptop("la" , "l22" , 1400 , "yalda1" , true , "kaks" , 3 , 4 , 5 , "dw" , 44 , 65 , "srdf" , true);
        MobilePhone m1 = new MobilePhone("ma" , "m12" , 500 , "yalda1" , true , "sfak" , 4 , 12 , 4 , "asd" , 4 , 2 , 2 , 12);
        MobilePhone m2 = new MobilePhone("mb" , "m22" , 1000 , "yalda1" , true , "sfak" , 5 , 12 , 4 , "asd" , 4 , 2 , 2 , 12);
        MobilePhone m3 = new MobilePhone("mb" , "m22" , 1000 , "yalda1" , true , "sfak" , 5 , 12 , 4 , "asd" , 4 , 2 , 2 , 12);
        MobilePhone m4 = new MobilePhone("mb" , "m22" , 1000, "yalda1" , true , "sfak" , 4 , 12 , 4 , "asd" , 4 , 2 , 2 , 12);
        MobilePhone m5 = new MobilePhone("mb" , "m22" , 1000, "yalda1" , true , "sfak" , 4 , 12 , 3 , "asd" , 4 , 2 , 2 , 12);
        Clothes c1 = new Clothes("ca" , "200" , 150 , "yalda1" , true , "dhs" , 3 , "hj" , "xkd" , "fdf" , Clothes.ClothesKind.HAT);
        Shoes s1 = new Shoes("sa" , "fha" , 23 , "yalda1" , true , "kdfm" , 3 , "rgg" , "gd" , "few" ,Shoes.ShoesKind.BOOTS);
        Television t1 = new Television("ta" , "jad" , 2000 , "yalda1" , true , "sda" ,2 , "a" , true , "fd" , 12);
        Refrigerator r1 = new Refrigerator("ra" , "df" , 1500 , "yalda1" , true , "ds" , 3 , "a" , true , 15 , "dag" , false);
        Stove st1 = new Stove("sta" , "dlfsd" , 1200 , "yalda1" , true , "ffs" , 5 , "a" ,true , 4 ,"fa" , true);
        EatingProducts e1 = new EatingProducts("ea" , "da" , 700 ,"yalda1" ,true , "dsfd" ,3 ,"efes" , "dfds");
        Lists.getProductsList().add(l1);
        Lists.getProductsList().add(m1);
        Lists.getProductsList().add(l2);
        Lists.getProductsList().add(c1);
        Lists.getProductsList().add(m3);
        Lists.getProductsList().add(m2);
        Lists.getProductsList().add(s1);
        Lists.getProductsList().add(t1);
        Lists.getProductsList().add(st1);
        Lists.getProductsList().add(r1);
        Lists.getProductsList().add(e1);
        Lists.getLaptopList().add(l1);
        Lists.getLaptopList().add(l2);
        Lists.getProductsList().add(m4);
        Lists.getProductsList().add(m5);

        Menu.showAllProductsForEveryone();



        Lists.getCostumersList().add(buyer);
        //Lists.getCostumersList().add(buyer2);
        Lists.getSellersList().add(seller);
        Lists.getSellersList().add(seller2);
        //Files.createFiles();
        //menu.mainMenu();
        System.out.println("GOOD LOCK!");
    }
}
//--------------------EXCEPTIONS-------------------//
class BuyValidationException extends Exception
{
    BuyValidationException()
    {
        super("BuyValidationException!");
    }
    BuyValidationException(String massage)
    {
        super(massage);
    }
}
class InputValidationException extends Exception
{
    InputValidationException()
    {
        super("InputValidationException!");
    }
    InputValidationException(String massage)
    {
        super(massage);
    }
}
class InventoryException extends BuyValidationException
{
    InventoryException()
    {
        super("The product that you want to buy does not exist in the online shop!");
    }
}
class PropertyException extends BuyValidationException
{
    PropertyException()
    {
        super("Your money property is not enough for the thing(s) you wanna buy!");
    }
}
class EmailValidationException extends InputValidationException
{
    EmailValidationException()
    {
        super("The form of your email is not valid!");
    }
}
class PhoneNumberValidationException extends InputValidationException
{
    PhoneNumberValidationException()
    {
        super("The form of your phone number is not valid!");
    }
}
class DiscountCodeValidationException extends InputValidationException
{
    DiscountCodeValidationException()
    {
        super("The form of your discount code is not valid!");
    }
}
//------------------------------------//
//-----------LISTS AND REQUESTS------------//
class Lists implements Serializable
{
    private static ArrayList<Buyer> costumersList = null;
    private static ArrayList<Seller> sellersList = null;
    private static ArrayList<Product> productsList = null;
    private static ArrayList<Laptop> laptopList = null;
    private static ArrayList<MobilePhone> mobilePhoneList = null;
    private static ArrayList<Clothes> clothesList = null;
    private static ArrayList<Shoes> shoesList = null;
    private static ArrayList<Television> televisionList = null;
    private static ArrayList<Refrigerator> refrigeratorList = null;
    private static ArrayList<Stove> stoveList = null;
    private static ArrayList<EatingProducts> eatingProductsList = null;
    private static ArrayList<Buyer> didScoreCostumersList = null;
    private static ArrayList<Comment> commentsList = null;

    //-------------setters and getters------------//

    public static ArrayList<Buyer> getCostumersList()
    {
        if (costumersList == null)
            costumersList = new ArrayList<Buyer>();
        return costumersList;
    }
    public static ArrayList<Seller> getSellersList()
    {
        if (sellersList == null)
            sellersList = new ArrayList<Seller>();
        return sellersList;
    }
    public static ArrayList<Product> getProductsList()
    {
        if (productsList == null)
            productsList = new ArrayList<Product>();
        return productsList;
    }
    public static ArrayList<Laptop> getLaptopList()
    {
        if (laptopList == null)
            laptopList = new ArrayList<Laptop>();
        return laptopList;
    }
    public static ArrayList<MobilePhone> getMobilePhoneList()
    {
        if (mobilePhoneList == null)
            mobilePhoneList = new ArrayList<MobilePhone>();
        return mobilePhoneList;
    }
    public static ArrayList<Clothes> getClothesList()
    {
        if (clothesList == null)
            clothesList = new ArrayList<Clothes>();
        return clothesList;
    }
    public static ArrayList<Shoes> getShoesList()
    {
        if (shoesList == null)
            shoesList = new ArrayList<Shoes>();
        return shoesList;
    }
    public static ArrayList<Television> getTelevisionList()
    {
        if (televisionList == null)
            televisionList = new ArrayList<Television>();
        return televisionList;
    }
    public static ArrayList<Refrigerator> getRefrigeratorList()
    {
        if (refrigeratorList == null)
            refrigeratorList = new ArrayList<Refrigerator>();
        return refrigeratorList;
    }
    public static ArrayList<Stove> getStoveList()
    {
        if (stoveList == null)
            stoveList = new ArrayList<Stove>();
        return stoveList;
    }
    public static ArrayList<EatingProducts> getEatingProductsList()
    {
        if (eatingProductsList == null)
            eatingProductsList = new ArrayList<EatingProducts>();
        return eatingProductsList;
    }
    public static ArrayList<Buyer> getDidScoreCostumersList()
    {
        if (didScoreCostumersList == null)
            didScoreCostumersList = new ArrayList<Buyer>();
        return didScoreCostumersList;
    }
    public static ArrayList<Comment> getCommentsList()
    {
        if (commentsList == null)
            commentsList = new ArrayList<Comment>();
        return commentsList;
    }
}
class Requests implements Serializable
{
    private static ArrayList<Seller> sellersRequestsList = null;
    //private static ArrayList<Product> productsRequestsList = null;
    private static ArrayList<Product> productsRequestsList = new ArrayList<Product>();

    //private static ArrayList<Product> addProductRequestsList = null;
    //private static ArrayList<Laptop> addLaptopRequestsList = null;
    private static ArrayList<Product> addProductRequestsList = new ArrayList<Product>();
    private static ArrayList<Laptop> addLaptopRequestsList = new ArrayList<Laptop>();

    private static ArrayList<MobilePhone> addMobilePhoneRequestsList = null;
    private static ArrayList<Clothes> addClothesRequestsList = null;
    private static ArrayList<Shoes> addShoesRequestsList = null;
    private static ArrayList<Television> addTelevisionRequestsList = null;
    private static ArrayList<Refrigerator> addRefrigeratorRequestsList = null;
    private static ArrayList<Stove> addStoveRequestsList = null;
    private static ArrayList<EatingProducts> addEatingProductRequestsList = null;

    private static ArrayList<Product> editProductRequestsList = null;
    private static ArrayList<Laptop> editLaptopRequestsList = null;
    private static ArrayList<MobilePhone> editMobilePhoneRequestsList = null;
    private static ArrayList<Clothes> editClothesRequestsList = null;
    private static ArrayList<Shoes> editShoesRequestsList = null;
    private static ArrayList<Television> editTelevisionRequestsList = null;
    private static ArrayList<Refrigerator> editRefrigeratorRequestsList = null;
    private static ArrayList<Stove> editStoveRequestsList = null;
    private static ArrayList<EatingProducts> editEatingProductRequestsList = null;

    private static ArrayList<Comment> commentsRequestsList = null;

    //-------------constructor------------//
    //public Requests()
    //{
    //productsRequestsList = new ArrayList<Product>();
    //addProductRequestsList = new ArrayList<Product>();
    //addLaptopRequestsList = new ArrayList<Laptop>();
    //}


    //-------------setters and getters------------//

    public static ArrayList<Seller> getSellersRequestsList()
    {
        if (sellersRequestsList == null)
            sellersRequestsList = new ArrayList<Seller>();
        return sellersRequestsList;
    }
    public static ArrayList<Product> getProductsRequestsList()
    {
        if (productsRequestsList == null)
            productsRequestsList = new ArrayList<Product>();
        return productsRequestsList;
    }
    //----------------------------ADD---------------------------------------//
    //public static ArrayList<Product> getAddProductRequestsList()
    //{
    //if (addProductRequestsList == null)
    //addProductRequestsList = new ArrayList<Product>();
    //return addProductRequestsList;
    //}
    //public static ArrayList<Laptop> getAddLaptopRequestsList()
    //{
    //if (addLaptopRequestsList == null)
    //addLaptopRequestsList = new ArrayList<Laptop>();
    //return addLaptopRequestsList;
    //}
    public static ArrayList<Product> getAddProductRequestsList() { return addProductRequestsList; }
    public static ArrayList<Laptop> getAddLaptopRequestsList() { return addLaptopRequestsList; }

    public static ArrayList<MobilePhone> getAddMobilePhoneRequestsList()
    {
        if (addMobilePhoneRequestsList == null)
            addMobilePhoneRequestsList = new ArrayList<MobilePhone>();
        return addMobilePhoneRequestsList;
    }
    public static ArrayList<Clothes> getAddClothesRequestsList()
    {
        if (addClothesRequestsList == null)
            addClothesRequestsList = new ArrayList<Clothes>();
        return addClothesRequestsList;
    }
    public static ArrayList<Shoes> getAddShoesRequestsList()
    {
        if (addShoesRequestsList == null)
            addShoesRequestsList = new ArrayList<Shoes>();
        return addShoesRequestsList;
    }
    public static ArrayList<Television> getAddTelevisionRequestsList()
    {
        if (addTelevisionRequestsList == null)
            addTelevisionRequestsList = new ArrayList<Television>();
        return addTelevisionRequestsList;
    }
    public static ArrayList<Refrigerator> getAddRefrigeratorRequestsList()
    {
        if (addRefrigeratorRequestsList == null)
            addRefrigeratorRequestsList = new ArrayList<Refrigerator>();
        return addRefrigeratorRequestsList;
    }
    public static ArrayList<Stove> getAddStoveRequestsList()
    {
        if (addStoveRequestsList == null)
            addStoveRequestsList = new ArrayList<Stove>();
        return addStoveRequestsList;
    }
    public static ArrayList<EatingProducts> getAddEatingProductRequestsList()
    {
        if (addEatingProductRequestsList == null)
            addEatingProductRequestsList = new ArrayList<EatingProducts>();
        return addEatingProductRequestsList;
    }
    //----------------------------EDIT---------------------------------------//
    public static ArrayList<Product> getEditProductRequestsList()
    {
        if (editProductRequestsList == null)
            editProductRequestsList = new ArrayList<Product>();
        return editProductRequestsList;
    }
    public static ArrayList<Laptop> getEditLaptopRequestsList()
    {
        if (editLaptopRequestsList == null)
            editLaptopRequestsList = new ArrayList<Laptop>();
        return editLaptopRequestsList;
    }
    public static ArrayList<MobilePhone> getEditMobilePhoneRequestsList()
    {
        if (editMobilePhoneRequestsList == null)
            editMobilePhoneRequestsList = new ArrayList<MobilePhone>();
        return editMobilePhoneRequestsList;
    }
    public static ArrayList<Clothes> getEditClothesRequestsList()
    {
        if (editClothesRequestsList == null)
            editClothesRequestsList = new ArrayList<Clothes>();
        return editClothesRequestsList;
    }
    public static ArrayList<Shoes> getEditShoesRequestsList()
    {
        if (editShoesRequestsList == null)
            editShoesRequestsList = new ArrayList<Shoes>();
        return editShoesRequestsList;
    }
    public static ArrayList<Television> getEditTelevisionRequestsList()
    {
        if (editTelevisionRequestsList == null)
            editTelevisionRequestsList = new ArrayList<Television>();
        return editTelevisionRequestsList;
    }
    public static ArrayList<Refrigerator> getEditRefrigeratorRequestsList()
    {
        if (editRefrigeratorRequestsList == null)
            editRefrigeratorRequestsList = new ArrayList<Refrigerator>();
        return editRefrigeratorRequestsList;
    }
    public static ArrayList<Stove> getEditStoveRequestsList()
    {
        if (editStoveRequestsList == null)
            editStoveRequestsList = new ArrayList<Stove>();
        return editStoveRequestsList;
    }
    public static ArrayList<EatingProducts> getEditEatingProductRequestsList()
    {
        if (editEatingProductRequestsList == null)
            editEatingProductRequestsList = new ArrayList<EatingProducts>();
        return editEatingProductRequestsList;
    }

    //----------------------------COMMENT-------------------------------------//

    public static ArrayList<Comment> getCommentsRequestsList()
    {
        if (commentsRequestsList == null)
            commentsRequestsList = new ArrayList<Comment>();
        return commentsRequestsList;
    }
}
//----------------------------------------//
//--------------IN CONNECTION WITH USER-------------//
class Menu implements Serializable
{
    public static void mainMenu() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("** WELCOME TO FARNAZ ONLINE SHOP **");
        System.out.println("-----------------------------------");
        System.out.println("Please enter the number of each process that you want");
        System.out.println("Enter 1 for {CONTROL PANEL}");
        System.out.println("Enter 2 for {PRODUCTS LIST}");
        System.out.print("Enter 3 for {EXIT}");
        System.out.println();
        int request = sc.nextInt();
        switch (request)
        {
            case 1:
                controlPanel();
                break;
            case 2:
                showAllProductsForEveryone();
                break;
            case 3:
                return;
            default:
                System.out.println("Please enter the correct number!");
                mainMenu();
        }
    }
    public static void controlPanel() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE CONTROL PANEL");
        System.out.println("----------------------------");
        System.out.println("Did you sign up before?");
        System.out.println("Enter 1 for {YES}");
        System.out.println("Enter 2 for {NO}");
        System.out.println("Enter 3 for {BACK TO MAIN MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        switch (request)
        {
            case 1:
                loginPanel();
                break;
            case 2:
                signupPanel();
                break;
            case 3:
                mainMenu();
                break;
            default:
                System.out.println("Please enter the correct number!");
                controlPanel();
        }

    }
    public static void loginPanel() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE LOGIN PANEL");
        System.out.println("--------------------------");
        System.out.println("Are you a costumer? are you a seller or admin?");
        System.out.println("Enter 1 for {COSTUMER}");
        System.out.println("Enter 2 for {SELLER}");
        System.out.println("Enter 3 for {ADMIN}");
        System.out.println("Enter 4 for {BACK TO CONTROL PANEL}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        switch (request)
        {
            case 1:
                costumerLoginPanel();
                break;
            case 2:
                sellerLoginPanel();
                break;
            case 3:
                adminLoginPanel();
                break;
            case 4:
                controlPanel();
                break;
            default:
                System.out.println("Please enter the correct number!");
                loginPanel();
        }
    }
    public static void costumerLoginPanel() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        int buyerIndex;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE COSTUMER LOG IN PANEL");
        System.out.println("------------------------------------");
        System.out.println("Please enter the wanted information");
        System.out.println("Enter your account name");
        String accountName = sc1.next();
        System.out.println("Enter your password");
        String password = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getCostumersList().size(); i++)
        {
            if(accountName.equals(Lists.getCostumersList().get(i).getAccountName()) && password.equals(Lists.getCostumersList().get(i).getPassword()))
            {
                check = true;
                buyerIndex = i;
                System.out.println("You have logged in to your costumer account successfully");
                System.out.println("The information of your costumer account: ");
                System.out.println(Lists.getCostumersList().get(buyerIndex).toString());
                System.out.println("What do you want to do here?");
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Enter 1 for {CHANGE ACCOUNT INFORMATION}");
                System.out.println("Enter 2 for {SHOW PRODUCTS}");
                System.out.println("Enter 3 for {SCORE A PRODUCT THAT YOU BOUGHT}");
                System.out.println("Enter 4 for {COMMENT ON A PRODUCT}");
                System.out.println("Enter 5 for {BACK TO LOGIN PANEL}");
                System.out.println("Please enter the number of each process that you want");
                int request = sc2.nextInt();
                switch (request)
                {
                    case 1:
                        try
                        {
                            CostumerPanel.changeCostumerAccountInfo(buyerIndex);
                        }
                        catch(EmailValidationException E)
                        {
                            System.out.println(E.getMessage());
                        }
                        catch(PhoneNumberValidationException P)
                        {
                            System.out.println(P.getMessage());
                        }
                        finally
                        {
                            System.out.println("GOOD LOCK!");
                        }
                        break;
                    case 2:
                        CostumerPanel.productsList(buyerIndex);
                        break;
                    case 3:
                        CostumerPanel.score(buyerIndex);
                        break;
                    case 4:
                        CostumerPanel.comment(buyerIndex);
                        break;
                    case 5:
                        loginPanel();
                        break;
                    default:
                        System.out.println("Please enter the correct number!");
                        costumerLoginPanel();
                }
            }
        }
        if (check)
        {
            System.out.println("There is no account with these information! Please try again");
            loginPanel();
        }

    }
    public static void sellerLoginPanel() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        int sellerIndex;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE SELLER LOG IN PANEL");
        System.out.println("----------------------------------");
        System.out.println("Please enter the wanted information");
        System.out.println("Enter your account name");
        String accountName = sc1.next();
        System.out.println("Enter your password");
        String password = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getSellersList().size(); i++)
        {
            if(accountName.equals(Lists.getSellersList().get(i).getAccountName()) && password.equals(Lists.getSellersList().get(i).getPassword()))
            {
                check = true;
                sellerIndex = i;
                System.out.println("You have logged in to your seller account successfully");
                System.out.println("The information of your seller account: ");
                System.out.println(Lists.getSellersList().get(sellerIndex).toString());
                System.out.println("What do you want to do here?");
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Enter 1 for {CHANGE ACCOUNT INFORMATION}");
                System.out.println("Enter 2 for {EDIT PRODUCTS}");
                System.out.println("Enter 3 for {REMOVE PRODUCTS}");
                System.out.println("Enter 4 for {ADD PRODUCTS}");
                System.out.println("Enter 5 for {SHOW ALL REQUESTS}");
                System.out.println("Enter 6 for {BACK TO LOGIN PANEL}");
                System.out.println("Please enter the number of each process that you want");
                int request = sc2.nextInt();
                switch (request)
                {
                    case 1:
                        try
                        {
                            SellerPanel.changeSellerAccountInfo(sellerIndex);
                        }
                        catch(EmailValidationException E)
                        {
                            System.out.println(E.getMessage());
                        }
                        catch(PhoneNumberValidationException P)
                        {
                            System.out.println(P.getMessage());
                        }
                        finally
                        {
                            System.out.println("GOOD LOCK!");
                        }
                        break;
                    case 2:
                        SellerPanel.editProducts(sellerIndex);
                        break;
                    case 3:
                        SellerPanel.removeProducts(sellerIndex);
                        break;
                    case 4:
                        SellerPanel.addProducts(sellerIndex);
                        break;
                    case 5:
                        SellerPanel.showAllRequests(sellerIndex);
                        break;
                    case 6:
                        loginPanel();
                        break;
                    default:
                        System.out.println("Please enter the correct number!");
                        sellerLoginPanel();
                }
            }
        }
        if (check)
        {
            System.out.println("There is no account with these information! Please try again");
            loginPanel();
        }

    }
    public static void adminLoginPanel() throws FileNotFoundException ,UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADMIN LOG IN PANEL");
        System.out.println("---------------------------------");
        System.out.println("Please enter the wanted information");
        System.out.println("Enter your account name");
        String accountName = sc1.next();
        System.out.println("Enter your password");
        String password = sc1.next();
        if (accountName.equals("admin") && password.equals("admin"))
        {
            System.out.println("You have logged in to your admin account successfully");
            System.out.println("What do you want to do here?");
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Enter 1 for {CHANGE ACCOUNT INFORMATION}");
            System.out.println("Enter 2 for {SHOW COMMENTS REQUESTS}");
            System.out.println("Enter 3 for {SHOW SELLERS SIGN UP REQUESTS}");
            System.out.println("Enter 4 for {SHOW ADD PRODUCTS REQUESTS}");
            System.out.println("Enter 5 for {SHOW EDIT PRODUCTS REQUESTS}");
            System.out.println("Enter 6 for {SHOW ALL ACCOUNTS LIST}");
            System.out.println("Enter 7 for {REMOVE AN ACCOUNT}");
            System.out.println("Enter 8 for {SHOW CATEGORY LIST}");
            System.out.println("Enter 9 for {BACK TO LOGIN PANEL}");
            System.out.println("Please enter the number of each process that you want");
            int request = sc2.nextInt();
            switch (request)
            {
                case 1:
                    AdminPanel.changeAdminAccountInfo();
                    break;
                case 2:
                    AdminPanel.showCommentsRequests();
                    break;
                case 3:
                    AdminPanel.showBeingSellerRequests();
                    break;
                case 4:
                    AdminPanel.showAddProductRequests();
                    break;
                case 5:
                    AdminPanel.showEditProductRequests();
                    break;
                case 6:
                    AdminPanel.showAccountsList();
                    break;
                case 7:
                    AdminPanel.removeAnAccount();
                    break;
                case 8:
                    AdminPanel.showCategoryList();
                    break;
                case 9:
                    loginPanel();
                    break;
                default:
                    System.out.println("Please enter the correct number!");
                    adminLoginPanel();
            }
        }
        else
        {
            System.out.println("There is no account with these information! Please try again");
            loginPanel();
        }

    }
    public static void signupPanel() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE SIGN UP PANEL");
        System.out.println("----------------------------");
        System.out.println("Are you a costumer or a seller?");
        System.out.println("Enter 1 for {COSTUMER}");
        System.out.println("Enter 2 for {SELLER}");
        System.out.println("Enter 3 for {BACK TO CONTROL PANEL}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        switch (request)
        {
            case 1:
                try
                {
                    costumerSignupPanel();
                }
                catch(EmailValidationException E)
                {
                    System.out.println(E.getMessage());
                }
                catch(PhoneNumberValidationException P)
                {
                    System.out.println(P.getMessage());
                }
                break;
            case 2:
                try
                {
                    sellerSignupPanel();
                }
                catch (EmailValidationException E)
                {
                    System.out.println(E.getMessage());
                }
                catch (PhoneNumberValidationException P)
                {
                    System.out.println(P.getMessage());
                }
                break;
            case 3:
                controlPanel();
                break;
            default:
                System.out.println("Please enter the correct number!");
                signupPanel();
        }
    }
    public static void costumerSignupPanel() throws EmailValidationException , PhoneNumberValidationException , FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE COSTUMER SIGN UP PANEL");
        System.out.println("-------------------------------------");
        System.out.println("Please enter the wanted information");
        System.out.print("Account name: ");
        String accountName = sc1.next();
        System.out.print("Name: ");
        String name = sc1.next();
        System.out.print("Last Name: ");
        String lastName = sc1.next();
        System.out.print("Email: ");
        String email = sc1.next();
        String emailRegex = "[A-Za-z0-9+_.-]+@(.+)$";
        Pattern patternEmail = Pattern.compile(emailRegex);
        Matcher matcher = patternEmail.matcher(email);
        if (!(matcher.matches()))
        {
            throw new EmailValidationException();
        }
        System.out.print("Phone Number: ");
        String phoneNumber = sc1.next();
        if (phoneNumber.length() != 11)
        {
            throw new PhoneNumberValidationException();
        }
        System.out.print("Password: ");
        String password = sc1.next();
        System.out.print("Property: ");
        String property = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getCostumersList().size(); i++)
        {
            if(accountName.compareTo(Lists.getCostumersList().get(i).getAccountName()) != 0)
            {
                check = true;
                Buyer obj = new Buyer(accountName, name, lastName, email, phoneNumber, password , property);
                File fOut = new File("F:/ProjectF2/savedData/users/costumers" , "costumer" + Lists.getCostumersList().get(i).getBuyerID());
                if (!(fOut.exists()))
                    fOut.mkdirs();
                File fOut2 = new File(fOut , "information.txt");
                fOut2.createNewFile();
                Formatter f = new Formatter(fOut2);
                f.format("%d\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n" , Lists.getCostumersList().get(i).getBuyerID() , Lists.getCostumersList().get(i).getAccountName() , Lists.getCostumersList().get(i).getName() , Lists.getCostumersList().get(i).getLastName() , Lists.getCostumersList().get(i).getEmail()
                        , Lists.getCostumersList().get(i).getPhoneNumber() , Lists.getCostumersList().get(i).getPassword() , Lists.getCostumersList().get(i).getProperty());
                f.flush();
                f.close();
                Lists.getCostumersList().add(obj);
                System.out.println("You have signed up to your costumer account successfully");
                System.out.println("The information of your new costumer account: ");
                System.out.println(obj.toString());
                costumerLoginPanel();
            }
        }
        if (!check)
        {
            System.out.println("Your chosen account name or password can not be accepted! Please try again");
            signupPanel();
        }

    }
    public static void sellerSignupPanel() throws EmailValidationException , PhoneNumberValidationException , FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE SELLER SIGN UP PANEL");
        System.out.println("-----------------------------------");
        System.out.println("Please enter the wanted information");
        System.out.print("Account name: ");
        String accountName = sc1.next();
        System.out.print("Name: ");
        String name = sc1.next();
        System.out.print("Last Name: ");
        String lastName = sc1.next();
        System.out.print("Email: ");
        String email = sc1.next();
        String emailRegex = "[A-Za-z0-9+_.-]+@(.+)$";
        Pattern patternEmail = Pattern.compile(emailRegex);
        Matcher matcher = patternEmail.matcher(email);
        if (!(matcher.matches()))
        {
            throw new EmailValidationException();
        }
        System.out.print("Phone Number: ");
        String phoneNumber = sc1.next();
        if (phoneNumber.length() != 11)
        {
            throw new PhoneNumberValidationException();
        }
        System.out.print("Password: ");
        String password = sc1.next();
        System.out.print("Property: ");
        String property = sc1.next();
        System.out.print("Company Name: ");
        String companyName = sc1.next();
        System.out.print("Company Establishment Date: ");
        String companyEstablishmentDate = sc1.next();
        System.out.print("Company Preamble: ");
        String companyPreamble = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getSellersList().size(); i++)
        {
            if(accountName.compareTo(Lists.getSellersList().get(i).getAccountName()) != 0)
            {
                check = true;
                Seller obj = new Seller(accountName, name, lastName, email, phoneNumber, password ,companyName ,companyEstablishmentDate ,companyPreamble , property);
                //Lists.getSellersList().add(obj);
                Requests.getSellersRequestsList().add(obj);
                System.out.println("Your request for being a seller in Farnaz online shop have sent to the admin successfully.");
                System.out.println("Please wait for the answer 3 days and try to log in after that.");
                System.out.println("If you could not log in after that, you can try your luck later =)");
                mainMenu();
            }
        }
        if (!check)
        {
            System.out.println("Your chosen account name or password can not be accepted! Please try again");
            signupPanel();
        }
    }
    public static void showAllProductsForEveryone()  throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Lists.getProductsList().size()-1; i++)
            for (int j = 0; j < Lists.getProductsList().size()-i-1; j++)
                if (Lists.getProductsList().get(j).compareTo(Lists.getProductsList().get(j+1)) < 0)
                {
                    Product tempProduct = Lists.getProductsList().get(j);
                    Lists.getProductsList().set(j , Lists.getProductsList().get(j+1));
                    Lists.getProductsList().set(j+1 , tempProduct);
                }
        for (int i = 0; i<Lists.getProductsList().size(); i++)
        {
            System.out.println(Lists.getProductsList().get(i).toString());
            System.out.println("-------------------------------------------------------------");
        }

        System.out.println("If you want to see all the properties of the products, You can go back to the categories lists");
        System.out.println("But for that part you have to log in or sign up!");
        System.out.println("Type {finished} when you saw the list.");
        String request = sc.next();
        if (request.equals("finished"))
            mainMenu();
    }

}
class CostumerPanel implements Serializable
{
    public static void changeCostumerAccountInfo(int index) throws EmailValidationException , PhoneNumberValidationException , FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHANGE ACCOUNT INFORMATION PANEL");
        System.out.println("-----------------------------------------------");
        System.out.println("The information of your costumer account: ");
        System.out.println(Lists.getCostumersList().get(index).toString());
        System.out.println("Please update your information one by one");
        System.out.println("If you do not want to change something, just enter the previous thing again");
        System.out.print("Name: ");
        String name = sc1.next();
        System.out.print("Last Name: ");
        String lastName = sc1.next();
        System.out.print("Email: ");
        String email = sc1.next();
        String emailRegex = "[A-Za-z0-9+_.-]+@(.+)$";
        Pattern patternEmail = Pattern.compile(emailRegex);
        Matcher matcher = patternEmail.matcher(email);
        if (!(matcher.matches()))
        {
            throw new EmailValidationException();
        }
        System.out.print("Phone Number: ");
        String phoneNumber = sc1.next();
        if (phoneNumber.length() != 11)
        {
            throw new PhoneNumberValidationException();
        }
        System.out.print("Password: ");
        String password = sc1.next();
        System.out.print("Property: ");
        String property = sc1.next();
        BuyerManager.getBuyerManager().changeAccountInfo(index,name,lastName,email,phoneNumber,password, property);
    }
    public static void comment(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE COMMENT PANEL");
        System.out.println("----------------------------");
        System.out.println("This is the list of all products: ");
        for (int i = 0; i<Lists.getProductsList().size(); i++)
        {
            System.out.println(Lists.getProductsList().get(i).toString());
            System.out.println("-------------------------------------------------------------");
        }
        System.out.println("Enter the ID of the product that you want to comment on");
        int productID = sc1.nextInt();
        System.out.println("Enter your comment");
        String newComment = sc1.next();
        int productIndex = 0;
        for (int i = 0; i < Lists.getProductsList().size(); i++)
            if (productID == Lists.getProductsList().get(i).getProductID())
                productIndex = i;
        boolean didBuyProduct = false;
        for (int i = 0; i < Lists.getCostumersList().get(buyerIndex).buyBillHistory.size(); i++)
            for (int j = 0; j < Lists.getCostumersList().get(buyerIndex).buyBillHistory.get(i).getBoughtProductsList().size(); j++)
                if (productID == Lists.getCostumersList().get(buyerIndex).buyBillHistory.get(i).getBoughtProductsList().get(j).getProductID())
                {
                    didBuyProduct = true;
                }
        Comment comment = new Comment(buyerIndex , Lists.getProductsList().get(productIndex) , newComment , "pending for confirm" , didBuyProduct);
        if (Lists.getProductsList().get(productIndex) instanceof DigitalProducts)
        {
            if (Lists.getProductsList().get(productIndex) instanceof Laptop)
            {
                FileOutputStream fOut = new FileOutputStream("F:/ProjectF2/savedData/categories/digitalProducts/laptops/laptopsList/laptop" + Lists.getProductsList().get(productIndex).getProductID() + "/commentsList.txt" , true);
                ObjectOutputStream oOut = new ObjectOutputStream(fOut);
                oOut.writeObject(comment);
            }
            if (Lists.getProductsList().get(productIndex) instanceof MobilePhone)
            {
                FileOutputStream fOut = new FileOutputStream("F:/ProjectF2/savedData/categories/digitalProducts/mobilePhones/mobilePhonesList/mobilePhone" + Lists.getProductsList().get(productIndex).getProductID() + "/commentsList.txt" , true);
                ObjectOutputStream oOut = new ObjectOutputStream(fOut);
                oOut.writeObject(comment);
            }
        }
        if (Lists.getProductsList().get(productIndex) instanceof WearingProducts)
        {
            if (Lists.getProductsList().get(productIndex) instanceof Clothes)
            {
                FileOutputStream fOut = new FileOutputStream("F:/ProjectF2/savedData/categories/wearingProducts/clothes/clothesList/cloth" + Lists.getProductsList().get(productIndex).getProductID() + "/commentsList.txt" , true);
                ObjectOutputStream oOut = new ObjectOutputStream(fOut);
                oOut.writeObject(comment);
            }
            if (Lists.getProductsList().get(productIndex) instanceof Shoes)
            {
                FileOutputStream fOut = new FileOutputStream("F:/ProjectF2/savedData/categories/wearingProducts/shoes/shoesList/shoes" + Lists.getProductsList().get(productIndex).getProductID() + "/commentsList.txt" , true);
                ObjectOutputStream oOut = new ObjectOutputStream(fOut);
                oOut.writeObject(comment);
            }
        }
        if (Lists.getProductsList().get(productIndex) instanceof DomesticProducts)
        {
            if (Lists.getProductsList().get(productIndex) instanceof Television)
            {
                FileOutputStream fOut = new FileOutputStream("F:/ProjectF2/savedData/categories/domesticProducts/televisions/televisionsList/television" + Lists.getProductsList().get(productIndex).getProductID() + "/commentsList.txt" , true);
                ObjectOutputStream oOut = new ObjectOutputStream(fOut);
                oOut.writeObject(comment);
            }
            if (Lists.getProductsList().get(productIndex) instanceof Refrigerator)
            {
                FileOutputStream fOut = new FileOutputStream("F:/ProjectF2/savedData/categories/domesticProducts/refrigerator/refrigeratorsList/refrigerator" + Lists.getProductsList().get(productIndex).getProductID() + "/commentsList.txt" , true);
                ObjectOutputStream oOut = new ObjectOutputStream(fOut);
                oOut.writeObject(comment);
            }
            if (Lists.getProductsList().get(productIndex) instanceof Stove)
            {
                FileOutputStream fOut = new FileOutputStream("F:/ProjectF2/savedData/categories/domesticProducts/stoves/stovesList/stove" + Lists.getProductsList().get(productIndex).getProductID() + "/commentsList.txt" , true);
                ObjectOutputStream oOut = new ObjectOutputStream(fOut);
                oOut.writeObject(comment);
            }
        }
        if (Lists.getProductsList().get(productIndex) instanceof EatingProducts)
        {
            FileOutputStream fOut = new FileOutputStream("F:/ProjectF2/savedData/categories/eatingProducts/eatingProductsList/eatingProduct" + Lists.getProductsList().get(productIndex).getProductID() + "/commentsList.txt" , true);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(comment);
        }
        Requests.getCommentsRequestsList().add(comment);
        System.out.println("Your comment has sent to the admin");
        System.out.println("if they confirm it will be shown to the costumers next to the product");
        System.out.println("Type {finished} when you did your work");
        String request = sc1.next();
        if (request.equals("finished"))
        {
            Menu.mainMenu();
        }

    }
    public static void score(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE SCORE PANEL");
        System.out.println("--------------------------");
        for (int i = 0; i < Lists.getCostumersList().get(buyerIndex).buyBillHistory.size(); i++)
        {
            System.out.println(Lists.getCostumersList().get(buyerIndex).buyBillHistory.get(i).getBoughtProductsList().toString());
            System.out.println("-----------------------------------------------------------------------");
        }
        System.out.println("Enter the ID of the product that you want to grade");
        int productID = sc1.nextInt();
        System.out.println("Enter your score (between 1 - 5)");
        double score = sc1.nextDouble();
        if (score < 1 || score > 5)
        {
            System.out.println("Enter the right number please!");
            score(buyerIndex);
        }

        int productIndex = 0;
        for (int i = 0; i < Lists.getProductsList().size(); i++)
            if (productID == Lists.getProductsList().get(i).getProductID())
                productIndex = i;
        Lists.getDidScoreCostumersList().add(Lists.getCostumersList().get(buyerIndex));
        for (int i = 0; i < Lists.getCostumersList().get(buyerIndex).buyBillHistory.size(); i++)
            for (int j = 0; j < Lists.getCostumersList().get(buyerIndex).buyBillHistory.get(i).getBoughtProductsList().size(); j++)
                if (productID == Lists.getCostumersList().get(buyerIndex).buyBillHistory.get(i).getBoughtProductsList().get(j).getProductID())
                {
                    double newScore = (((Lists.getDidScoreCostumersList().size()-1) * Lists.getProductsList().get(productIndex).getBuyersAverageScore()) + score)/Lists.getDidScoreCostumersList().size();
                    Lists.getProductsList().get(productIndex).setBuyersAverageScore(newScore);
                }
        System.out.println("Type {finished} when you did your work");
        String request = sc1.next();
        if (request.equals("finished"))
        {
            Menu.mainMenu();
        }
    }
    public static void productsList(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE PRODUCTS LIST PANEL");
        System.out.println("----------------------------------");
        System.out.println("What category do you want to search for?");
        System.out.println("Enter 1 for {DIGITAL PRODUCTS}");
        System.out.println("Enter 2 for {WEARING PRODUCTS}");
        System.out.println("Enter 3 for {DOMESTIC PRODUCTS}");
        System.out.println("Enter 4 for {EATING PRODUCTS}");
        System.out.println("Enter 5 for {NO CATEGORY! ALL PRODUCTS}");
        System.out.println("Enter 6 for {BACK TO LOG IN MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                digitalProducts(buyerIndex);
                break;
            case 2:
                wearingProducts(buyerIndex);
                break;
            case 3:
                domesticProducts(buyerIndex);
                break;
            case 4:
                eatingProducts(buyerIndex);
                break;
            case 5:
                showAllProducts(buyerIndex);
                break;
            case 6:
                Menu.costumerLoginPanel();
                break;
            default:
                System.out.println("Please enter the correct number!");
                productsList(buyerIndex);
        }

    }
    public static void digitalProducts(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE DIGITAL PRODUCTS LIST PANEL");
        System.out.println("------------------------------------------");
        System.out.println("What product do you want to search for?");
        System.out.println("Enter 1 for {LAPTOP}");
        System.out.println("Enter 2 for {MOBILE PHONE}");
        System.out.println("Enter 3 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                laptopMenu(buyerIndex);
                break;
            case 2:
                mobilePhoneMenu(buyerIndex);
                break;
            case 3:
                productsList(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                digitalProducts(buyerIndex);
        }
    }
    public static void laptopMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE LAPTOP LIST PANEL");
        System.out.println("--------------------------------");
        System.out.println("Do you know what you want? or want to use filters?");
        System.out.println("Enter 1 for {I KNOW}");
        System.out.println("Enter 2 for {USE FILTERS}");
        System.out.println("Enter 3 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                laptopChooseMenu(buyerIndex);
                break;
            case 2:
                laptopFilterMenu(buyerIndex);
                break;
            case 3:
                digitalProducts(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                laptopMenu(buyerIndex);
        }
    }
    public static void laptopFilterMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of filtering do you want?");
        System.out.println("Enter 1 for {BASED OF PRICE}");
        System.out.println("Enter 2 for {BASED OF BUYERS AVERAGE SCORE}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        if (request == 1)
        {
            for (int i = 0; i < Lists.getLaptopList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getLaptopList().size()-i-1; j++)
                {
                    if (Lists.getLaptopList().get(j).getProductPrice() > Lists.getLaptopList().get(j+1).getProductPrice())
                    {
                        Laptop temp = Lists.getLaptopList().get(j);
                        Lists.getLaptopList().remove(j);
                        Lists.getLaptopList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of price of the products: ");
            for (int i = 0; i < Lists.getLaptopList().size(); i++)
            {
                System.out.println(Lists.getLaptopList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request == 2)
        {
            for (int i = 0; i < Lists.getLaptopList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getLaptopList().size()-i-1; j++)
                {
                    if (Lists.getLaptopList().get(j).getProductPrice() > Lists.getLaptopList().get(j+1).getProductPrice())
                    {
                        Laptop temp = Lists.getLaptopList().get(j);
                        Lists.getLaptopList().remove(j);
                        Lists.getLaptopList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of price of the products: ");
            for (int i = 0; i < Lists.getLaptopList().size(); i++)
            {
                System.out.println(Lists.getLaptopList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request != 1 && request != 2)
        {
            System.out.println("The number is not correct!");
            laptopFilterMenu(buyerIndex);
        }
        System.out.println("Type {finished} when you saw the list");
        System.out.println("You will be able to choose the product you want after that");
        String request2 = sc.next();
        if (request2.equals("finished"))
        {
            laptopChooseMenu(buyerIndex);
        }
    }
    public static void laptopChooseMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        int laptopIndex;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHOOSING LAPTOP PANEL");
        System.out.println("------------------------------------");
        System.out.println("Enter the wanted information of your chosen product");
        System.out.print("Product Name: ");
        String productName = sc1.next();
        System.out.print("Product Company: ");
        String productCompany = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getLaptopList().size(); i++)
        {
            if((productName.equals(Lists.getLaptopList().get(i).getProductName())) &&
                    (productCompany.equals(Lists.getLaptopList().get(i).getProductCompany())))
            {
                check = true;
                laptopIndex = i;
                try
                {
                    buying(laptopIndex , buyerIndex);
                }
                catch (InventoryException I)
                {
                    System.out.println(I.getMessage());
                }
            }
        }
        if (check)
        {
            System.out.println("Your chosen product dose not exist in our online shop!");
            laptopMenu(buyerIndex);
        }
    }
    public static void mobilePhoneMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE MOBILE PHONE LIST PANEL");
        System.out.println("--------------------------------------");
        System.out.println("Do you know what you want? or want to use filters?");
        System.out.println("Enter 1 for {I KNOW}");
        System.out.println("Enter 2 for {USE FILTERS}");
        System.out.println("Enter 3 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                mobilePhoneChooseMenu(buyerIndex);
                break;
            case 2:
                mobilePhoneFilterMenu(buyerIndex);
                break;
            case 3:
                digitalProducts(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                mobilePhoneMenu(buyerIndex);
        }
    }
    public static void mobilePhoneFilterMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of filtering do you want?");
        System.out.println("Enter 1 for {BASED OF PRICE}");
        System.out.println("Enter 2 for {BASED OF BUYERS AVERAGE SCORE}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        if (request == 1)
        {
            for (int i = 0; i < Lists.getMobilePhoneList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getMobilePhoneList().size()-i-1; j++)
                {
                    if (Lists.getMobilePhoneList().get(j).getProductPrice() > Lists.getMobilePhoneList().get(j+1).getProductPrice())
                    {
                        MobilePhone temp = Lists.getMobilePhoneList().get(j);
                        Lists.getMobilePhoneList().remove(j);
                        Lists.getMobilePhoneList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of price of the products: ");
            for (int i = 0; i < Lists.getMobilePhoneList().size(); i++)
            {
                System.out.println(Lists.getMobilePhoneList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request == 2)
        {
            for (int i = 0; i < Lists.getMobilePhoneList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getMobilePhoneList().size()-i-1; j++)
                {
                    if (Lists.getMobilePhoneList().get(j).getBuyersAverageScore() > Lists.getMobilePhoneList().get(j+1).getBuyersAverageScore());
                    {
                        MobilePhone temp = Lists.getMobilePhoneList().get(j);
                        Lists.getMobilePhoneList().remove(j);
                        Lists.getMobilePhoneList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of buyers average score of the products: ");
            for (int i = 0; i < Lists.getMobilePhoneList().size(); i++)
            {
                System.out.println(Lists.getMobilePhoneList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request != 1 && request != 2)
        {
            System.out.println("The number is not correct!");
            mobilePhoneFilterMenu(buyerIndex);
        }
        System.out.println("Type {finished} when you saw the list");
        System.out.println("You will be able to choose the product you want after that");
        String request2 = sc.next();
        if (request2.equals("finished"))
        {
            mobilePhoneChooseMenu(buyerIndex);
        }
    }
    public static void mobilePhoneChooseMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        int mobilePhoneIndex;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHOOSING MOBILE PHONE PANEL");
        System.out.println("------------------------------------------");
        System.out.println("Enter the wanted information of your chosen product");
        System.out.print("Product Name: ");
        String productName = sc1.next();
        System.out.print("Product Company: ");
        String productCompany = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getMobilePhoneList().size(); i++)
        {
            if((productName.equals(Lists.getMobilePhoneList().get(i).getProductName())) &&
                    (productCompany.equals(Lists.getMobilePhoneList().get(i).getProductCompany())))
            {
                check = true;
                mobilePhoneIndex = i;
                try
                {
                    buying(mobilePhoneIndex , buyerIndex);
                }
                catch (InventoryException I)
                {
                    System.out.println(I.getMessage());
                }
            }
        }
        if (check)
        {
            System.out.println("Your chosen product dose not exist in our online shop!");
            mobilePhoneMenu(buyerIndex);
        }
    }
    public static void wearingProducts(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE WEARING PRODUCTS LIST PANEL");
        System.out.println("------------------------------------------");
        System.out.println("What product do you want to search for?");
        System.out.println("Enter 1 for {CLOTHES}");
        System.out.println("Enter 2 for {SHOES}");
        System.out.println("Enter 3 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                clothesMenu(buyerIndex);
                break;
            case 2:
                shoesMenu(buyerIndex);
                break;
            case 3:
                productsList(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                wearingProducts(buyerIndex);
        }
    }
    public static void clothesMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CLOTHES LIST PANEL");
        System.out.println("---------------------------------");
        System.out.println("Do you know what you want? or want to use filters?");
        System.out.println("Enter 1 for {I KNOW}");
        System.out.println("Enter 2 for {USE FILTERS}");
        System.out.println("Enter 3 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                clothesChooseMenu(buyerIndex);
                break;
            case 2:
                clothesFilterMenu(buyerIndex);
                break;
            case 3:
                wearingProducts(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                clothesMenu(buyerIndex);
        }
    }
    public static void clothesFilterMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of filtering do you want?");
        System.out.println("Enter 1 for {BASED OF PRICE}");
        System.out.println("Enter 2 for {BASED OF BUYERS AVERAGE SCORE}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        if (request == 1)
        {
            for (int i = 0; i < Lists.getClothesList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getClothesList().size()-i-1; j++)
                {
                    if (Lists.getClothesList().get(j).getProductPrice() > Lists.getClothesList().get(j+1).getProductPrice())
                    {
                        Clothes temp = Lists.getClothesList().get(j);
                        Lists.getClothesList().remove(j);
                        Lists.getClothesList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of price of the products: ");
            for (int i = 0; i < Lists.getClothesList().size(); i++)
            {
                System.out.println(Lists.getClothesList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request == 2)
        {
            for (int i = 0; i < Lists.getClothesList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getClothesList().size()-i-1; j++)
                {
                    if (Lists.getClothesList().get(j).getBuyersAverageScore() > Lists.getClothesList().get(j+1).getBuyersAverageScore())
                    {
                        Clothes temp = Lists.getClothesList().get(j);
                        Lists.getClothesList().remove(j);
                        Lists.getClothesList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of buyers average score of the products: ");
            for (int i = 0; i < Lists.getClothesList().size(); i++)
            {
                System.out.println(Lists.getClothesList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request != 1 && request != 2)
        {
            System.out.println("The number is not correct!");
            clothesFilterMenu(buyerIndex);
        }
        System.out.println("Type {finished} when you saw the list");
        System.out.println("You will be able to choose the product you want after that");
        String request2 = sc.next();
        if (request2.equals("finished"))
        {
            clothesChooseMenu(buyerIndex);
        }
    }
    public static void clothesChooseMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        int clothesIndex;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHOOSING CLOTHES PANEL");
        System.out.println("-------------------------------------");
        System.out.println("Enter the wanted information of your chosen product");
        System.out.print("Product Name: ");
        String productName = sc1.next();
        System.out.print("Product Company: ");
        String productCompany = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getClothesList().size(); i++)
        {
            if((productName.equals(Lists.getClothesList().get(i).getProductName())) &&
                    (productCompany.equals(Lists.getClothesList().get(i).getProductCompany())))
            {
                check = true;
                clothesIndex = i;
                try
                {
                    buying(clothesIndex , buyerIndex);
                }
                catch (InventoryException I)
                {
                    System.out.println(I.getMessage());
                }
            }
        }
        if (check)
        {
            System.out.println("Your chosen product dose not exist in our online shop!");
            clothesMenu(buyerIndex);
        }
    }
    public static void shoesMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE SHOES LIST PANEL");
        System.out.println("-------------------------------");
        System.out.println("Do you know what you want? or want to use filters?");
        System.out.println("Enter 1 for {I KNOW}");
        System.out.println("Enter 2 for {USE FILTERS}");
        System.out.println("Enter 3 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                shoesChooseMenu(buyerIndex);
                break;
            case 2:
                shoesFilterMenu(buyerIndex);
                break;
            case 3:
                wearingProducts(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                shoesMenu(buyerIndex);
        }
    }
    public static void shoesFilterMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of filtering do you want?");
        System.out.println("Enter 1 for {BASED OF PRICE}");
        System.out.println("Enter 2 for {BASED OF BUYERS AVERAGE SCORE}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        if (request == 1)
        {
            for (int i = 0; i < Lists.getShoesList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getShoesList().size()-i-1; j++)
                {
                    if (Lists.getShoesList().get(j).getProductPrice() > Lists.getShoesList().get(j+1).getProductPrice())
                    {
                        Shoes temp = Lists.getShoesList().get(j);
                        Lists.getShoesList().remove(j);
                        Lists.getShoesList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of price of the products: ");
            for (int i = 0; i < Lists.getShoesList().size(); i++)
            {
                System.out.println(Lists.getShoesList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request == 2)
        {
            for (int i = 0; i < Lists.getShoesList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getShoesList().size()-i-1; j++)
                {
                    if (Lists.getShoesList().get(j).getBuyersAverageScore() > Lists.getShoesList().get(j+1).getBuyersAverageScore())
                    {
                        Shoes temp = Lists.getShoesList().get(j);
                        Lists.getShoesList().remove(j);
                        Lists.getShoesList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of buyers average score of the products: ");
            for (int i = 0; i < Lists.getShoesList().size(); i++)
            {
                System.out.println(Lists.getShoesList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request != 1 && request != 2)
        {
            System.out.println("The number is not correct!");
            shoesFilterMenu(buyerIndex);
        }
        System.out.println("Type {finished} when you saw the list");
        System.out.println("You will be able to choose the product you want after that");
        String request2 = sc.next();
        if (request2.equals("finished"))
        {
            shoesChooseMenu(buyerIndex);
        }
    }
    public static void shoesChooseMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        int shoesIndex;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHOOSING SHOES PANEL");
        System.out.println("-----------------------------------");
        System.out.println("Enter the wanted information of your chosen product");
        System.out.print("Product Name: ");
        String productName = sc1.next();
        System.out.print("Product Company: ");
        String productCompany = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getShoesList().size(); i++)
        {
            if((productName.equals(Lists.getShoesList().get(i).getProductName())) &&
                    (productCompany.equals(Lists.getShoesList().get(i).getProductCompany())))
            {
                check = true;
                shoesIndex = i;
                try
                {
                    buying(shoesIndex , buyerIndex);
                }
                catch (InventoryException I)
                {
                    System.out.println(I.getMessage());
                }
            }
        }
        if (check)
        {
            System.out.println("Your chosen product dose not exist in our online shop!");
            shoesMenu(buyerIndex);
        }
    }
    public static void domesticProducts(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE DOMESTIC PRODUCTS LIST PANEL");
        System.out.println("-------------------------------------------");
        System.out.println("What product do you want to search for?");
        System.out.println("Enter 1 for {TELEVISION}");
        System.out.println("Enter 2 for {REFRIGERATOR}");
        System.out.println("Enter 3 for {STOVE}");
        System.out.println("Enter 4 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                televisionMenu(buyerIndex);
                break;
            case 2:
                refrigeratorMenu(buyerIndex);
                break;
            case 3:
                stoveMenu(buyerIndex);
                break;
            case 4:
                productsList(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                domesticProducts(buyerIndex);
        }
    }
    public static void televisionMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE TELEVISION LIST PANEL");
        System.out.println("------------------------------------");
        System.out.println("Do you know what you want? or want to use filters?");
        System.out.println("Enter 1 for {I KNOW}");
        System.out.println("Enter 2 for {USE FILTERS}");
        System.out.println("Enter 3 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                televisionChooseMenu(buyerIndex);
                break;
            case 2:
                televisionFilterMenu(buyerIndex);
                break;
            case 3:
                domesticProducts(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                televisionMenu(buyerIndex);
        }
    }
    public static void televisionFilterMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of filtering do you want?");
        System.out.println("Enter 1 for {BASED OF PRICE}");
        System.out.println("Enter 2 for {BASED OF BUYERS AVERAGE SCORE}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        if (request == 1)
        {
            for (int i = 0; i < Lists.getTelevisionList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getTelevisionList().size()-i-1; j++)
                {
                    if (Lists.getTelevisionList().get(j).getProductPrice() > Lists.getTelevisionList().get(j+1).getProductPrice())
                    {
                        Television temp = Lists.getTelevisionList().get(j);
                        Lists.getTelevisionList().remove(j);
                        Lists.getTelevisionList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of price of the products: ");
            for (int i = 0; i < Lists.getTelevisionList().size(); i++)
            {
                System.out.println(Lists.getTelevisionList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request == 2)
        {
            for (int i = 0; i < Lists.getTelevisionList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getTelevisionList().size()-i-1; j++)
                {
                    if (Lists.getTelevisionList().get(j).getBuyersAverageScore() > Lists.getTelevisionList().get(j+1).getBuyersAverageScore())
                    {
                        Television temp = Lists.getTelevisionList().get(j);
                        Lists.getTelevisionList().remove(j);
                        Lists.getTelevisionList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of buyers average score of the products: ");
            for (int i = 0; i < Lists.getTelevisionList().size(); i++)
            {
                System.out.println(Lists.getTelevisionList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request != 1 && request != 2)
        {
            System.out.println("The number is not correct!");
            televisionFilterMenu(buyerIndex);
        }
        System.out.println("Type {finished} when you saw the list");
        System.out.println("You will be able to choose the product you want after that");
        String request2 = sc.next();
        if (request2.equals("finished"))
        {
            televisionChooseMenu(buyerIndex);
        }
    }
    public static void televisionChooseMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        int televisionIndex;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHOOSING TELEVISION PANEL");
        System.out.println("----------------------------------------");
        System.out.println("Enter the wanted information of your chosen product");
        System.out.print("Product Name: ");
        String productName = sc1.next();
        System.out.print("Product Company: ");
        String productCompany = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getTelevisionList().size(); i++)
        {
            if((productName.equals(Lists.getTelevisionList().get(i).getProductName())) &&
                    (productCompany.equals(Lists.getTelevisionList().get(i).getProductCompany())))
            {
                check = true;
                televisionIndex = i;
                try
                {
                    buying(televisionIndex , buyerIndex);
                }
                catch (InventoryException I)
                {
                    System.out.println(I.getMessage());
                }
            }
        }
        if (check)
        {
            System.out.println("Your chosen product dose not exist in our online shop!");
            televisionMenu(buyerIndex);
        }
    }
    public static void refrigeratorMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE REFRIGERATOR LIST PANEL");
        System.out.println("--------------------------------------");
        System.out.println("Do you know what you want? or want to use filters?");
        System.out.println("Enter 1 for {I KNOW}");
        System.out.println("Enter 2 for {USE FILTERS}");
        System.out.println("Enter 3 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                refrigeratorChooseMenu(buyerIndex);
                break;
            case 2:
                refrigeratorFilterMenu(buyerIndex);
                break;
            case 3:
                domesticProducts(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                refrigeratorMenu(buyerIndex);
        }
    }
    public static void refrigeratorFilterMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of filtering do you want?");
        System.out.println("Enter 1 for {BASED OF PRICE}");
        System.out.println("Enter 2 for {BASED OF BUYERS AVERAGE SCORE}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        if (request == 1)
        {
            for (int i = 0; i < Lists.getRefrigeratorList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getRefrigeratorList().size()-i-1; j++)
                {
                    if (Lists.getRefrigeratorList().get(j).getProductPrice() > Lists.getRefrigeratorList().get(j+1).getProductPrice())
                    {
                        Refrigerator temp = Lists.getRefrigeratorList().get(j);
                        Lists.getRefrigeratorList().remove(j);
                        Lists.getRefrigeratorList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of price of the products: ");
            for (int i = 0; i < Lists.getRefrigeratorList().size(); i++)
            {
                System.out.println(Lists.getRefrigeratorList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request == 2)
        {
            for (int i = 0; i < Lists.getRefrigeratorList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getRefrigeratorList().size()-i-1; j++)
                {
                    if (Lists.getRefrigeratorList().get(j).getBuyersAverageScore() > Lists.getRefrigeratorList().get(j+1).getBuyersAverageScore())
                    {
                        Refrigerator temp = Lists.getRefrigeratorList().get(j);
                        Lists.getRefrigeratorList().remove(j);
                        Lists.getRefrigeratorList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of buyers average score of the products: ");
            for (int i = 0; i < Lists.getRefrigeratorList().size(); i++)
            {
                System.out.println(Lists.getRefrigeratorList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request != 1 && request != 2)
        {
            System.out.println("The number is not correct!");
            refrigeratorFilterMenu(buyerIndex);
        }
        System.out.println("Type {finished} when you saw the list");
        System.out.println("You will be able to choose the product you want after that");
        String request2 = sc.next();
        if (request2.equals("finished"))
        {
            refrigeratorChooseMenu(buyerIndex);
        }
    }
    public static void refrigeratorChooseMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        int refrigeratorIndex;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHOOSING REFRIGERATOR PANEL");
        System.out.println("------------------------------------------");
        System.out.println("Enter the wanted information of your chosen product");
        System.out.print("Product Name: ");
        String productName = sc1.next();
        System.out.print("Product Company: ");
        String productCompany = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getRefrigeratorList().size(); i++)
        {
            if((productName.equals(Lists.getRefrigeratorList().get(i).getProductName())) &&
                    (productCompany.equals(Lists.getRefrigeratorList().get(i).getProductCompany())))
            {
                check = true;
                refrigeratorIndex = i;
                try
                {
                    buying(refrigeratorIndex , buyerIndex);
                }
                catch (InventoryException I)
                {
                    System.out.println(I.getMessage());
                }
            }
        }
        if (check)
        {
            System.out.println("Your chosen product dose not exist in our online shop!");
            refrigeratorMenu(buyerIndex);
        }
    }
    public static void stoveMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE STOVE LIST PANEL");
        System.out.println("-------------------------------");
        System.out.println("Do you know what you want? or want to use filters?");
        System.out.println("Enter 1 for {I KNOW}");
        System.out.println("Enter 2 for {USE FILTERS}");
        System.out.println("Enter 3 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                stoveChooseMenu(buyerIndex);
                break;
            case 2:
                stoveFilterMenu(buyerIndex);
                break;
            case 3:
                domesticProducts(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                stoveMenu(buyerIndex);
        }
    }
    public static void stoveFilterMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of filtering do you want?");
        System.out.println("Enter 1 for {BASED OF PRICE}");
        System.out.println("Enter 2 for {BASED OF BUYERS AVERAGE SCORE}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        if (request == 1)
        {
            for (int i = 0; i < Lists.getStoveList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getStoveList().size()-i-1; j++)
                {
                    if (Lists.getStoveList().get(j).getProductPrice() > Lists.getStoveList().get(j+1).getProductPrice())
                    {
                        Stove temp = Lists.getStoveList().get(j);
                        Lists.getStoveList().remove(j);
                        Lists.getStoveList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of price of the products: ");
            for (int i = 0; i < Lists.getStoveList().size(); i++)
            {
                System.out.println(Lists.getStoveList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request == 2)
        {
            for (int i = 0; i < Lists.getStoveList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getStoveList().size()-i-1; j++)
                {
                    if (Lists.getStoveList().get(j).getBuyersAverageScore() > Lists.getStoveList().get(j+1).getBuyersAverageScore())
                    {
                        Stove temp = Lists.getStoveList().get(j);
                        Lists.getStoveList().remove(j);
                        Lists.getStoveList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of buyers average score of the products: ");
            for (int i = 0; i < Lists.getStoveList().size(); i++)
            {
                System.out.println(Lists.getStoveList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request != 1 && request != 2)
        {
            System.out.println("The number is not correct!");
            stoveFilterMenu(buyerIndex);
        }
        System.out.println("Type {finished} when you saw the list");
        System.out.println("You will be able to choose the product you want after that");
        String request2 = sc.next();
        if (request2.equals("finished"))
        {
            stoveChooseMenu(buyerIndex);
        }
    }
    public static void stoveChooseMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        int stoveIndex;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHOOSING STOVE PANEL");
        System.out.println("-----------------------------------");
        System.out.println("Enter the wanted information of your chosen product");
        System.out.print("Product Name: ");
        String productName = sc1.next();
        System.out.print("Product Company: ");
        String productCompany = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getStoveList().size(); i++)
        {
            if((productName.equals(Lists.getStoveList().get(i).getProductName())) &&
                    (productCompany.equals(Lists.getStoveList().get(i).getProductCompany())))
            {
                check = true;
                stoveIndex = i;
                try
                {
                    buying(stoveIndex , buyerIndex);
                }
                catch (InventoryException I)
                {
                    System.out.println(I.getMessage());
                }
            }
        }
        if (check)
        {
            System.out.println("Your chosen product dose not exist in our online shop!");
            stoveMenu(buyerIndex);
        }
    }
    public static void eatingProducts(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE EATING PRODUCTS LIST PANEL");
        System.out.println("-----------------------------------------");
        System.out.println("Do you know what you want? or want to use filters?");
        System.out.println("Enter 1 for {I KNOW}");
        System.out.println("Enter 2 for {USE FILTERS}");
        System.out.println("Enter 3 for {BACK TO PREVIOUS MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                eatingProductsChooseMenu(buyerIndex);
                break;
            case 2:
                eatingProductsFilterMenu(buyerIndex);
                break;
            case 3:
                productsList(buyerIndex);
                break;
            default:
                System.out.println("Please enter the correct number!");
                eatingProducts(buyerIndex);
        }
    }
    public static void eatingProductsFilterMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What kind of filtering do you want?");
        System.out.println("Enter 1 for {BASED OF PRICE}");
        System.out.println("Enter 2 for {BASED OF BUYERS AVERAGE SCORE}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc.nextInt();
        if (request == 1)
        {
            for (int i = 0; i < Lists.getEatingProductsList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getEatingProductsList().size()-i-1; j++)
                {
                    if (Lists.getEatingProductsList().get(j).getProductPrice() > Lists.getEatingProductsList().get(j+1).getProductPrice())
                    {
                        EatingProducts temp = Lists.getEatingProductsList().get(j);
                        Lists.getEatingProductsList().remove(j);
                        Lists.getEatingProductsList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of price of the products: ");
            for (int i = 0; i < Lists.getEatingProductsList().size(); i++)
            {
                System.out.println(Lists.getEatingProductsList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request == 2)
        {
            for (int i = 0; i < Lists.getEatingProductsList().size()-1; i++)
            {
                for (int j = 0; j < Lists.getEatingProductsList().size()-i-1; j++)
                {
                    if (Lists.getEatingProductsList().get(j).getBuyersAverageScore() > Lists.getEatingProductsList().get(j+1).getBuyersAverageScore())
                    {
                        EatingProducts temp = Lists.getEatingProductsList().get(j);
                        Lists.getEatingProductsList().remove(j);
                        Lists.getEatingProductsList().add(j + 1, temp);
                    }
                }
            }
            System.out.println("This is the sorted list based of buyers average score of the products: ");
            for (int i = 0; i < Lists.getEatingProductsList().size(); i++)
            {
                System.out.println(Lists.getEatingProductsList().get(i).toString());
                System.out.println("------------------------------------------------------------------------------");
            }
        }
        else if (request != 1 && request != 2)
        {
            System.out.println("The number is not correct!");
            eatingProductsFilterMenu(buyerIndex);
        }
        System.out.println("Type {finished} when you saw the list");
        System.out.println("You will be able to choose the product you want after that");
        String request2 = sc.next();
        if (request2.equals("finished"))
        {
            eatingProductsChooseMenu(buyerIndex);
        }
    }
    public static void eatingProductsChooseMenu(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        int eatingProductsIndex;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHOOSING EATING PRODUCTS PANEL");
        System.out.println("---------------------------------------------");
        System.out.println("Enter the wanted information of your chosen product");
        System.out.print("Product Name: ");
        String productName = sc1.next();
        System.out.print("Product Company: ");
        String productCompany = sc1.next();
        boolean check = false;
        for (int i = 0; i < Lists.getEatingProductsList().size(); i++)
        {
            if((productName.equals(Lists.getEatingProductsList().get(i).getProductName())) &&
                    (productCompany.equals(Lists.getEatingProductsList().get(i).getProductCompany())))
            {
                check = true;
                eatingProductsIndex = i;
                try
                {
                    buying(eatingProductsIndex , buyerIndex);
                }
                catch (InventoryException I)
                {
                    System.out.println(I.getMessage());
                }
            }
        }
        if (check)
        {
            System.out.println("Your chosen product dose not exist in our online shop!");
            productsList(buyerIndex);
        }
    }
    public static void showAllProducts(int buyerIndex) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Lists.getProductsList().size()-1; i++)
            for (int j = 0; j < Lists.getProductsList().size()-i-1; j++)
                if (Lists.getProductsList().get(j).compareTo(Lists.getProductsList().get(j+1)) < 0)
                {
                    Product tempProduct = Lists.getProductsList().get(j);
                    Lists.getProductsList().set(j , Lists.getProductsList().get(j+1));
                    Lists.getProductsList().set(j+1 , tempProduct);
                }
        for (int i = 0; i<Lists.getProductsList().size(); i++)
        {
            System.out.println(Lists.getProductsList().get(i).toString());
            System.out.println("-------------------------------------------------------------");
        }
        System.out.println("If you want to see all the properties of the products, You can go back to the categories lists.");
        System.out.println("Type {finished} when you saw the list.");
        String request = sc.next();
        if (request.equals("finished"))
            productsList(buyerIndex);
    }
    public static void buying(int specialProductIndex,int buyerIndex) throws InventoryException , FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        for (int i = 0; i < Lists.getProductsList().size(); i++)
        {
            if (Lists.getProductsList().get(i) instanceof DigitalProducts)
            {
                if (Lists.getProductsList().get(i) instanceof Laptop)
                    if (Lists.getProductsList().get(i).getProductID() == Lists.getLaptopList().get(specialProductIndex).getProductID()) {
                        int mainIndex = 0;
                        mainIndex = i;
                        if (Lists.getProductsList().get(mainIndex).getInventory())
                        {
                            Lists.getCostumersList().get(buyerIndex).cart.add(Lists.getProductsList().get(mainIndex));
                            System.out.println("What do you want to do? Purchase registration? or Back and buy another product?");
                            System.out.println("Enter 1 for {PURCHASE REGISTRATION}");
                            System.out.println("Enter 2 for {BACK AND BUY ANOTHER PRODUCT}");
                            System.out.println("Please enter the number of each process that you want");
                            int request = sc1.nextInt();
                            switch (request) {
                                case 1:
                                    try
                                    {
                                        shipping(mainIndex,specialProductIndex,buyerIndex);
                                    }
                                    catch (PropertyException P)
                                    {
                                        System.out.println(P.getMessage());
                                    }
                                    break;
                                case 2:
                                    productsList(buyerIndex);
                                    break;
                                default:
                                    System.out.println("Please enter the correct number!");
                                    buying(specialProductIndex,buyerIndex);
                            }
                        }
                        else
                            throw new InventoryException();

                    }
                    else if (Lists.getProductsList().get(i) instanceof MobilePhone)
                        if (Lists.getProductsList().get(i).getProductID() == Lists.getMobilePhoneList().get(specialProductIndex).getProductID()) {
                            int mainIndex = 0;
                            mainIndex = i;
                            if (Lists.getProductsList().get(mainIndex).getInventory())
                            {
                                Lists.getCostumersList().get(buyerIndex).cart.add(Lists.getProductsList().get(mainIndex));
                                System.out.println("What do you want to do? Purchase registration? or Back and buy another product?");
                                System.out.println("Enter 1 for {PURCHASE REGISTRATION}");
                                System.out.println("Enter 2 for {BACK AND BUY ANOTHER PRODUCT}");
                                System.out.println("Please enter the number of each process that you want");
                                int request = sc1.nextInt();
                                switch (request) {
                                    case 1:
                                        try
                                        {
                                            shipping(mainIndex,specialProductIndex,buyerIndex);
                                        }
                                        catch (PropertyException P)
                                        {
                                            System.out.println(P.getMessage());
                                        }
                                        break;
                                    case 2:
                                        productsList(buyerIndex);
                                        break;
                                    default:
                                        System.out.println("Please enter the correct number!");
                                        buying(specialProductIndex,buyerIndex);
                                }
                            }
                            else
                                throw new InventoryException();
                        }
            }
            else if (Lists.getProductsList().get(i) instanceof WearingProducts)
            {
                if (Lists.getProductsList().get(i) instanceof Clothes)
                    if (Lists.getProductsList().get(i).getProductID() == Lists.getClothesList().get(specialProductIndex).getProductID()) {
                        int mainIndex = 0;
                        mainIndex = i;
                        if (Lists.getProductsList().get(mainIndex).getInventory())
                        {
                            Lists.getCostumersList().get(buyerIndex).cart.add(Lists.getProductsList().get(mainIndex));
                            System.out.println("What do you want to do? Purchase registration? or Back and buy another product?");
                            System.out.println("Enter 1 for {PURCHASE REGISTRATION}");
                            System.out.println("Enter 2 for {BACK AND BUY ANOTHER PRODUCT}");
                            System.out.println("Please enter the number of each process that you want");
                            int request = sc1.nextInt();
                            switch (request) {
                                case 1:
                                    try
                                    {
                                        shipping(mainIndex,specialProductIndex,buyerIndex);
                                    }
                                    catch (PropertyException P)
                                    {
                                        System.out.println(P.getMessage());
                                    }
                                    break;
                                case 2:
                                    productsList(buyerIndex);
                                    break;
                                default:
                                    System.out.println("Please enter the correct number!");
                                    buying(specialProductIndex,buyerIndex);
                            }
                        }
                        else new InventoryException();

                    }
                    else if (Lists.getProductsList().get(i) instanceof Shoes)
                        if (Lists.getProductsList().get(i).getProductID() == Lists.getShoesList().get(specialProductIndex).getProductID()) {
                            int mainIndex = 0;
                            mainIndex = i;
                            if (Lists.getProductsList().get(mainIndex).getInventory())
                            {
                                Lists.getCostumersList().get(buyerIndex).cart.add(Lists.getProductsList().get(mainIndex));
                                System.out.println("What do you want to do? Purchase registration? or Back and buy another product?");
                                System.out.println("Enter 1 for {PURCHASE REGISTRATION}");
                                System.out.println("Enter 2 for {BACK AND BUY ANOTHER PRODUCT}");
                                System.out.println("Please enter the number of each process that you want");
                                int request = sc1.nextInt();
                                switch (request) {
                                    case 1:
                                        try
                                        {
                                            shipping(mainIndex,specialProductIndex,buyerIndex);
                                        }
                                        catch (PropertyException P)
                                        {
                                            System.out.println(P.getMessage());
                                        }
                                        break;
                                    case 2:
                                        productsList(buyerIndex);
                                        break;
                                    default:
                                        System.out.println("Please enter the correct number!");
                                        buying(specialProductIndex,buyerIndex);
                                }
                            }
                            else
                                throw new InventoryException();

                        }
            }
            else if (Lists.getProductsList().get(i) instanceof DomesticProducts)
            {
                if (Lists.getProductsList().get(i) instanceof Television)
                    if (Lists.getProductsList().get(i).getProductID() == Lists.getTelevisionList().get(specialProductIndex).getProductID()) {
                        int mainIndex = 0;
                        mainIndex = i;
                        if (Lists.getProductsList().get(mainIndex).getInventory())
                        {
                            Lists.getCostumersList().get(buyerIndex).cart.add(Lists.getProductsList().get(mainIndex));
                            System.out.println("What do you want to do? Purchase registration? or Back and buy another product?");
                            System.out.println("Enter 1 for {PURCHASE REGISTRATION}");
                            System.out.println("Enter 2 for {BACK AND BUY ANOTHER PRODUCT}");
                            System.out.println("Please enter the number of each process that you want");
                            int request = sc1.nextInt();
                            switch (request) {
                                case 1:
                                    try
                                    {
                                        shipping(mainIndex,specialProductIndex,buyerIndex);
                                    }
                                    catch (PropertyException P)
                                    {
                                        System.out.println(P.getMessage());
                                    }
                                    break;
                                case 2:
                                    productsList(buyerIndex);
                                    break;
                                default:
                                    System.out.println("Please enter the correct number!");
                                    buying(specialProductIndex,buyerIndex);
                            }
                        }
                        else
                            throw new InventoryException();

                    }
                    else if (Lists.getProductsList().get(i) instanceof Refrigerator)
                        if (Lists.getProductsList().get(i).getProductID() == Lists.getRefrigeratorList().get(specialProductIndex).getProductID()) {
                            int mainIndex = 0;
                            mainIndex = i;
                            if (Lists.getProductsList().get(mainIndex).getInventory())
                            {
                                Lists.getCostumersList().get(buyerIndex).cart.add(Lists.getProductsList().get(mainIndex));
                                System.out.println("What do you want to do? Purchase registration? or Back and buy another product?");
                                System.out.println("Enter 1 for {PURCHASE REGISTRATION}");
                                System.out.println("Enter 2 for {BACK AND BUY ANOTHER PRODUCT}");
                                System.out.println("Please enter the number of each process that you want");
                                int request = sc1.nextInt();
                                switch (request) {
                                    case 1:
                                        try
                                        {
                                            shipping(mainIndex,specialProductIndex,buyerIndex);
                                        }
                                        catch (PropertyException P)
                                        {
                                            System.out.println(P.getMessage());
                                        }
                                        break;
                                    case 2:
                                        productsList(buyerIndex);
                                        break;
                                    default:
                                        System.out.println("Please enter the correct number!");
                                        buying(specialProductIndex,buyerIndex);
                                }
                            }
                            else
                                throw new InventoryException();

                        }
                        else if (Lists.getProductsList().get(i) instanceof Stove)
                            if (Lists.getProductsList().get(i).getProductID() == Lists.getStoveList().get(specialProductIndex).getProductID()) {
                                int mainIndex = 0;
                                mainIndex = i;
                                if (Lists.getProductsList().get(mainIndex).getInventory())
                                {
                                    Lists.getCostumersList().get(buyerIndex).cart.add(Lists.getProductsList().get(mainIndex));
                                    System.out.println("What do you want to do? Purchase registration? or Back and buy another product?");
                                    System.out.println("Enter 1 for {PURCHASE REGISTRATION}");
                                    System.out.println("Enter 2 for {BACK AND BUY ANOTHER PRODUCT}");
                                    System.out.println("Please enter the number of each process that you want");
                                    int request = sc1.nextInt();
                                    switch (request) {
                                        case 1:
                                            try
                                            {
                                                shipping(mainIndex,specialProductIndex,buyerIndex);
                                            }
                                            catch (PropertyException P)
                                            {
                                                System.out.println(P.getMessage());
                                            }
                                            break;
                                        case 2:
                                            productsList(buyerIndex);
                                            break;
                                        default:
                                            System.out.println("Please enter the correct number!");
                                            buying(specialProductIndex,buyerIndex);
                                    }
                                }
                                else
                                    throw new InventoryException();

                            }
            }
            else if (Lists.getProductsList().get(i) instanceof EatingProducts)
                if (Lists.getProductsList().get(i).getProductID() == Lists.getEatingProductsList().get(specialProductIndex).getProductID())
                {
                    int mainIndex = 0;
                    mainIndex = i;
                    if (Lists.getProductsList().get(mainIndex).getInventory())
                    {
                        Lists.getCostumersList().get(buyerIndex).cart.add(Lists.getProductsList().get(mainIndex));
                        System.out.println("What do you want to do? Purchase registration? or Back and buy another product?");
                        System.out.println("Enter 1 for {PURCHASE REGISTRATION}");
                        System.out.println("Enter 2 for {BACK AND BUY ANOTHER PRODUCT}");
                        System.out.println("Please enter the number of each process that you want");
                        int request = sc1.nextInt();
                        switch (request)
                        {
                            case 1:
                                try
                                {
                                    shipping(mainIndex,specialProductIndex,buyerIndex);
                                }
                                catch (PropertyException P)
                                {
                                    System.out.println(P.getMessage());
                                }
                                break;
                            case 2:
                                productsList(buyerIndex);
                                break;
                            default:
                                System.out.println("Please enter the correct number!");
                                buying(specialProductIndex,buyerIndex);
                        }
                    }
                    else
                        throw new InventoryException();

                }
        }
    }
    public static void shipping(int mainIndex, int specialProductIndex , int buyerIndex) throws PropertyException , FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE SHIPPING PANEL");
        System.out.println("-----------------------------");
        System.out.println("Your cart: ");
        for (int i = 0; i < Lists.getCostumersList().get(buyerIndex).cart.size(); i++)
        {
            System.out.println(Lists.getCostumersList().get(buyerIndex).cart.get(i).toString());
            System.out.println("--------------------------------------------------------------");
        }
        System.out.println("Are you sure you want to buy them?");
        System.out.println("*WARNING* if you say no, your cart will be cleaned and empty");
        System.out.println("Type {Yes} to buy");
        System.out.println("Type {No} to go back to the products list");
        String request = sc1.next();
        if (request.equals("Yes"))
        {
            FileOutputStream fOut0 = new FileOutputStream("F:/ProjectF2/savedData/users/costumers/costumer" + Lists.getCostumersList().get(buyerIndex).getBuyerID() + "/carts.txt", true);
            ObjectOutputStream oOut0 = new ObjectOutputStream(fOut0);
            oOut0.writeObject(Lists.getCostumersList().get(buyerIndex).cart);
            System.out.println("Enter your address: ");
            String address = sc1.next();
            double priceSum = 0;
            for (int i = 0; i < Lists.getCostumersList().get(buyerIndex).cart.size(); i++)
            {
                System.out.println("Do you have discount code for this product?");
                System.out.println("Type {Yes} or {No}");
                String request2 = sc1.next();
                if (request2.equals("Yes"))
                {
                    System.out.println("Enter your discount code");
                    String str = sc1.next();
                    if (Lists.getCostumersList().get(buyerIndex).cart.get(i) instanceof DigitalProducts)
                    {
                        if (str.equals(Discount.digitalDiscountCode))
                        {
                            DigitalDiscountStrategy discountStrategy= new DigitalDiscountStrategy();
                            priceSum += discountStrategy.priceByDiscount(Lists.getCostumersList().get(buyerIndex).cart.get(i));
                        }
                    }
                    if (Lists.getCostumersList().get(buyerIndex).cart.get(i) instanceof WearingProducts)
                    {
                        if (str.equals(Discount.wearingDiscountCode))
                        {
                            WearingDiscountStrategy discountStrategy = new WearingDiscountStrategy();
                            priceSum += discountStrategy.priceByDiscount(Lists.getCostumersList().get(buyerIndex).cart.get(i));
                        }
                    }
                    if (Lists.getCostumersList().get(buyerIndex).cart.get(i) instanceof DomesticProducts)
                    {
                        if (str.equals(Discount.domesticDiscountCode))
                        {
                            DomesticDiscountStrategy discountStrategy = new DomesticDiscountStrategy();
                            priceSum += discountStrategy.priceByDiscount(Lists.getCostumersList().get(buyerIndex).cart.get(i));
                        }
                    }
                    if (Lists.getCostumersList().get(buyerIndex).cart.get(i) instanceof EatingProducts)
                    {
                        if (str.equals(Discount.eatingDiscountCode))
                        {
                            EatingDiscountStrategy discountStrategy = new EatingDiscountStrategy();
                            priceSum += discountStrategy.priceByDiscount(Lists.getCostumersList().get(buyerIndex).cart.get(i));
                        }
                    }
                }
                if (request2.equals("No"))
                {
                    priceSum += Lists.getCostumersList().get(buyerIndex).cart.get(i).getProductPrice();
                }

            }
            if (priceSum < Double.parseDouble(Lists.getCostumersList().get(buyerIndex).getProperty()))
            {
                Date date = new Date();
                //Date deliveryStatus = new Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15));
                double newBuyerProperty = Double.parseDouble(Lists.getCostumersList().get(buyerIndex).getProperty()) - priceSum;
                Lists.getCostumersList().get(buyerIndex).setProperty(Double.toString(newBuyerProperty));
                BuyBill buyBill = new BuyBill(date , priceSum , Lists.getCostumersList().get(buyerIndex).cart, true);
                FileOutputStream fOut = new FileOutputStream("F:/ProjectF2/savedData/users/costumers/costumer" + Lists.getCostumersList().get(buyerIndex).getBuyerID() + "/buyBillHistoryList.txt", true);
                ObjectOutputStream oOut = new ObjectOutputStream(fOut);
                oOut.writeObject(buyBill);
                Lists.getCostumersList().get(buyerIndex).buyBillHistory.add(buyBill);
                for (int i = 0; i < Lists.getCostumersList().get(buyerIndex).cart.size(); i++)
                {
                    for (int j = 0; j < Lists.getSellersList().size(); j++)
                    {
                        if (Lists.getCostumersList().get(buyerIndex).cart.get(i).getProductSellerName().equals(Lists.getSellersList().get(j).getName()))
                        {
                            int sellerIndex = 0;
                            sellerIndex = j;
                            double newSellerProperty = Double.parseDouble(Lists.getSellersList().get(sellerIndex).getProperty()) - Lists.getCostumersList().get(buyerIndex).cart.get(i).getProductPrice();
                            Lists.getSellersList().get(sellerIndex).setProperty(Double.toString(newSellerProperty));
                            SellBill sellBill = new SellBill(date , priceSum , Lists.getCostumersList().get(buyerIndex).cart , Lists.getCostumersList().get(buyerIndex).getName() , true);
                            FileOutputStream fOut2 = new FileOutputStream("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(sellerIndex).getSellerID() + "/sellBillHistoryList.txt", true);
                            ObjectOutputStream oOut2 = new ObjectOutputStream(fOut2);
                            oOut2.writeObject(sellBill);
                            Lists.getSellersList().get(sellerIndex).sellBillHistory.add(sellBill);
                        }
                    }
                }
                System.out.println(buyBill.toString());
                System.out.println(address);
                Menu.mainMenu();
            }
            else
            {
                throw new PropertyException();
                //System.out.println("You do not have enough money in your costumer account!");
                //for (int i = 0; i < Lists.getCostumersList().get(buyerIndex).cart.size(); i++)
                //{
                    //Lists.getCostumersList().get(buyerIndex).cart.remove(i);
                //}
                //productsList(buyerIndex);
            }
        }
        else if (request.equals("No"))
        {
            for (int i = 0; i < Lists.getCostumersList().get(buyerIndex).cart.size(); i++)
            {
                Lists.getCostumersList().get(buyerIndex).cart.remove(i);
            }
            productsList(buyerIndex);
        }
    }

}
class SellerPanel implements Serializable
{
    public static void changeSellerAccountInfo(int index) throws EmailValidationException , PhoneNumberValidationException , FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHANGE ACCOUNT INFORMATION PANEL");
        System.out.println("-----------------------------------------------");
        System.out.println("The information of your seller account: ");
        System.out.println(Lists.getSellersList().get(index).toString());
        System.out.println("Please update your information one by one");
        System.out.println("If you do not want to change something, just enter the previous thing again");
        System.out.print("Name: ");
        String name = sc1.next();
        System.out.print("Last Name: ");
        String lastName = sc1.next();
        System.out.print("Email: ");
        String email = sc1.next();
        String emailRegex = "[A-Za-z0-9+_.-]+@(.+)$";
        Pattern patternEmail = Pattern.compile(emailRegex);
        Matcher matcher = patternEmail.matcher(email);
        if (!(matcher.matches()))
        {
            throw new EmailValidationException();
        }
        System.out.print("Phone Number: ");
        String phoneNumber = sc1.next();
        if (phoneNumber.length() != 11)
        {
            throw new PhoneNumberValidationException();
        }
        System.out.print("Password: ");
        String password = sc1.next();
        System.out.print("Property: ");
        String property = sc1.next();
        System.out.print("Company Name: ");
        String companyName = sc1.next();
        System.out.print("Company Establishment Date: ");
        String companyEstablishmentDate = sc1.next();
        System.out.print("Company Preamble: ");
        String companyPreamble = sc1.next();
        SellerManager.getSellerManager().changeAccountInfo(index,name,lastName,email,phoneNumber,
                password ,companyName,companyEstablishmentDate,companyPreamble,property);
    }
    public static void editProducts(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE EDIT PRODUCT PANEL");
        System.out.println("---------------------------------");
        boolean check = false;
        for (int i = 0; i < Lists.getProductsList().size(); i++)
        {
            if(Lists.getProductsList().get(i).getProductSellerName().equals(Lists.getSellersList().get(index).getName()))
            {
                check = true;
                System.out.println(Lists.getProductsList().get(i).toString());
                System.out.println("------------------------------------------------------------");
            }
        }
        if (!check)
        {
            System.out.println("You have no product to edit!");
            Menu.mainMenu();
        }
        System.out.println("What is the ID of the product that you want to edit?");
        int productID = sc1.nextInt();
        System.out.println("Enter the new properties of the products");
        System.out.print("Product name: ");
        String productName = sc1.next();
        System.out.print("Product Company: ");
        String productCompany = sc1.next();
        System.out.print("Product Price: ");
        double productPrice = 0;
        try
        {
            productPrice = sc1.nextDouble();
        }
        catch (InputMismatchException I)
        {
            System.out.println(I.toString());
        }
        finally
        {
            System.out.println("GOOD LOCK!");
        }
        System.out.print("Product Seller Name: ");
        String productSellerName = sc1.next();
        System.out.print("Inventory: ");
        boolean inventory = true;
        try
        {
            inventory = sc1.nextBoolean();
        }
        catch (InputMismatchException I)
        {
            System.out.println(I.toString());
        }
        finally
        {
            System.out.println("GOOD LOCK!");
        }
        System.out.print("Preamble: ");
        String preamble = sc1.next();
        int productIndex = 0;
        //for (int i = 0; i < Lists.getProductsList().size(); i++)
        //{
        //if (productID == Lists.getProductsList().get(i).getProductID())
        //{
        //productIndex = i;
        //}
        //}
        SellerManager.getSellerManager().editProducts(productID,productName,productCompany,productPrice,productSellerName,inventory,preamble);
    }
    public static void removeProducts(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE REMOVE PRODUCT PANEL");
        System.out.println("-----------------------------------");
        for (int i = 0; i < Lists.getProductsList().size(); i++)
        {
            if(Lists.getProductsList().get(i).getProductSellerName().equals(Lists.getSellersList().get(index).getName()))
            {
                System.out.println(Lists.getProductsList().get(i).toString());
                System.out.println("------------------------------------------------------------");
            }
        }
        System.out.println("What is the ID of the product that you want to edit?");
        int productID = sc1.nextInt();
        for (int i = 0; i < Lists.getProductsList().size(); i++)
        {
            if (Lists.getProductsList().get(i).getProductID() == productID)
            {
                if (Lists.getProductsList().get(i) instanceof DigitalProducts)
                {
                    Lists.getProductsList().remove(i);
                    if (Lists.getProductsList().get(i) instanceof Laptop)
                    {
                        int laptopIndex = 0;
                        for (int j = 0; j < Lists.getLaptopList().size(); j++)
                            if (productID == Lists.getLaptopList().get(j).getProductID())
                                laptopIndex = j;
                        Lists.getLaptopList().remove(laptopIndex);
                    }
                    else if (Lists.getProductsList().get(i) instanceof MobilePhone)
                    {
                        int mobilePhoneIndex = 0;
                        for (int j = 0; j < Lists.getMobilePhoneList().size(); j++)
                            if (productID == Lists.getMobilePhoneList().get(j).getProductID())
                                mobilePhoneIndex = j;
                        Lists.getMobilePhoneList().remove(mobilePhoneIndex);
                    }
                }
                else if (Lists.getProductsList().get(i) instanceof WearingProducts)
                {
                    Lists.getProductsList().remove(i);
                    if (Lists.getProductsList().get(i) instanceof Clothes)
                    {
                        int clothesIndex = 0;
                        for (int j = 0; j < Lists.getClothesList().size(); j++)
                            if (productID == Lists.getClothesList().get(j).getProductID())
                                clothesIndex = j;
                        Lists.getClothesList().remove(clothesIndex);
                    }
                    else if (Lists.getProductsList().get(i) instanceof Shoes)
                    {
                        int shoesIndex = 0;
                        for (int j = 0; j < Lists.getShoesList().size(); j++)
                            if (productID == Lists.getShoesList().get(j).getProductID())
                                shoesIndex = j;
                        Lists.getShoesList().remove(shoesIndex);
                    }
                }
                else if (Lists.getProductsList().get(i) instanceof DomesticProducts)
                {
                    Lists.getProductsList().remove(i);
                    if (Lists.getProductsList().get(i) instanceof Television)
                    {
                        int televisionIndex = 0;
                        for (int j = 0; j < Lists.getTelevisionList().size(); j++)
                            if (productID == Lists.getTelevisionList().get(j).getProductID())
                                televisionIndex = j;
                        Lists.getTelevisionList().remove(televisionIndex);
                    }
                    else if (Lists.getProductsList().get(i) instanceof Refrigerator)
                    {
                        int refrigeratorIndex = 0;
                        for (int j = 0; j < Lists.getRefrigeratorList().size(); j++)
                            if (productID == Lists.getRefrigeratorList().get(j).getProductID())
                                refrigeratorIndex = j;
                        Lists.getRefrigeratorList().remove(refrigeratorIndex);
                    }
                    else if (Lists.getProductsList().get(i) instanceof Stove)
                    {
                        int stoveIndex = 0;
                        for (int j = 0; j < Lists.getStoveList().size(); j++)
                            if (productID == Lists.getStoveList().get(j).getProductID())
                                stoveIndex = j;
                        Lists.getStoveList().remove(stoveIndex);
                    }
                }
                else if (Lists.getProductsList().get(i) instanceof EatingProducts)
                {
                    Lists.getProductsList().remove(i);
                    int eatingProductIndex = 0;
                    for (int j = 0; j < Lists.getEatingProductsList().size(); j++)
                        if (productID == Lists.getEatingProductsList().get(j).getProductID())
                            eatingProductIndex = j;
                    Lists.getEatingProductsList().remove(eatingProductIndex);
                }

            }
        }
        Menu.mainMenu();
    }
    public static void addProducts(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD PRODUCT PANEL");
        System.out.println("--------------------------------");
        System.out.println("Enter 1 for {ADD DIGITAL PRODUCT}");
        System.out.println("Enter 2 for {ADD WEARING PRODUCT}");
        System.out.println("Enter 3 for {ADD DOMESTIC PRODUCT}");
        System.out.println("Enter 4 for {ADD EATING PRODUCT}");
        System.out.println("Enter 5 for {BACK TO MAIN MENU}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                addDigitalProducts(index);
                break;
            case 2:
                addWearingProducts(index);
                break;
            case 3:
                addDomesticProducts(index);
                break;
            case 4:
                addEatingProducts(index);
                break;
            case 5:
                Menu.mainMenu();
                break;
            default:
                System.out.println("Please enter the correct number!");
                addProducts(index);
        }

    }
    public static void addDigitalProducts(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD DIGITAL PRODUCT PANEL");
        System.out.println("----------------------------------------");
        System.out.println("Enter 1 for {ADD LAPTOP}");
        System.out.println("Enter 2 for {ADD MOBILE PHONE}");
        System.out.println("Enter 3 for {BACK TO ADD PRODUCTS PANEL}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                addLaptop(index);
                break;
            case 2:
                addMobilePhone(index);
                break;
            case 3:
                addProducts(index);
                break;
            default:
                System.out.println("Please enter the correct number!");
                addDigitalProducts(index);
        }
    }
    public static void addLaptop(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD LAPTOP PANEL");
        System.out.println("-------------------------------");
        System.out.println("Do you wanna add a laptop?");
        System.out.println("Enter 1 for {YES} or 2 for {NO}");
        int request = sc1.nextInt();
        if (request == 1)
        {
            System.out.println("Enter the wanted information");
            System.out.println("*NOTICE* You can only edit the general information of the products later");
            System.out.print("Product name: ");
            String productName = sc1.next();
            System.out.print("Product Company: ");
            String productCompany = sc1.next();
            System.out.print("Product Price: ");
            double productPrice = 0;
            try
            {
                productPrice = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            System.out.print("Product Seller Name: ");
            String productSellerName = sc1.next();
            System.out.print("Inventory:  enter true or false");
            boolean inventory = true;
            try
            {
                inventory = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            System.out.print("Preamble: ");
            String preamble = sc1.next();
            System.out.print("Memory Capacity: ");
            int memoryCapacity = 0;
            try
            {
                memoryCapacity = sc1.nextInt();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            System.out.print("RAM Memory Capacity: ");
            int RAMMemoryCapacity = 0;
            try
            {
                RAMMemoryCapacity = sc1.nextInt();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            System.out.print("Operating System: ");
            String operatingSystem = sc1.next();
            System.out.print("Weight: ");
            double weight = 0;
            try
            {
                weight = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            System.out.print("Dimensions: ");
            double dimensions = 0;
            try
            {
                dimensions = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            System.out.println("CPU: ");
            String CPU = sc1.next();
            System.out.println("Is gaming? enter true or false");
            boolean isGaming = true;
            try
            {
                isGaming = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            SellerManager.getSellerManager().addLaptop(index,productName,productCompany,productPrice,productSellerName,
                    inventory,preamble,memoryCapacity,RAMMemoryCapacity,operatingSystem,weight,dimensions,CPU,isGaming);
        }
        if (request == 2)
        {
            addProducts(index);
        }
        else
        {
            System.out.println("Please enter the correct number!");
            addLaptop(index);
        }
    }
    public static void addMobilePhone(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD MOBILE PHONE PANEL");
        System.out.println("-------------------------------------");
        System.out.println("Do you wanna add a mobile phone?");
        System.out.println("Enter 1 for {YES} or 2 for {NO}");
        int request = sc1.nextInt();
        if (request == 1)
        {
            System.out.println("Enter the wanted information");
            System.out.println("*NOTICE* You can only edit the general information of the products later");
            System.out.print("Product name: ");
            String productName = sc1.next();
            System.out.print("Product Company: ");
            String productCompany = sc1.next();
            System.out.print("Product Price: ");
            double productPrice = 0;
            try
            {
                productPrice = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Product Seller Name: ");
            String productSellerName = sc1.next();
            System.out.print("Inventory:  enter true or false");
            boolean inventory = false;
            try
            {
                inventory = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Preamble: ");
            String preamble = sc1.next();
            System.out.print("Memory Capacity: ");
            int memoryCapacity = 0;
            try
            {
                memoryCapacity = sc1.nextInt();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("RAM Memory Capacity: ");
            int RAMMemoryCapacity = 0;
            try
            {
                RAMMemoryCapacity = sc1.nextInt();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Operating System: ");
            String operatingSystem = sc1.next();
            System.out.print("Weight: ");
            double weight = 0;
            try
            {
                weight = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Dimensions: ");
            double dimensions = 0;
            try
            {
                dimensions = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.println("Sim Card Number: ");
            int simCardNumber = 0;
            try
            {
                simCardNumber = sc1.nextInt();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.println("Camera Quality: ");
            int cameraQuality = 0;
            try
            {
                cameraQuality = sc1.nextInt();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            SellerManager.getSellerManager().addMobilePhone(index,productName,productCompany,productPrice,productSellerName,
                    inventory,preamble,memoryCapacity,RAMMemoryCapacity,operatingSystem,weight,dimensions,simCardNumber,cameraQuality);
        }
        if (request == 2)
        {
            addProducts(index);
        }
        else
        {
            System.out.println("Please enter the correct number!");
            addMobilePhone(index);
        }
    }
    public static void addWearingProducts(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD WEARING PRODUCT PANEL");
        System.out.println("----------------------------------------");
        System.out.println("Enter 1 for {ADD CLOTHES}");
        System.out.println("Enter 2 for {ADD SHOES}");
        System.out.println("Enter 3 for {BACK TO ADD PRODUCTS PANEL}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                addClothes(index);
                break;
            case 2:
                addShoes(index);
                break;
            case 3:
                addProducts(index);
                break;
            default:
                System.out.println("Please enter the correct number!");
                addWearingProducts(index);
        }
    }
    public static void addClothes(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD CLOTHES PANEL");
        System.out.println("--------------------------------");
        System.out.println("Do you wanna add a cloth?");
        System.out.println("Enter 1 for {YES} or 2 for {NO}");
        int request = sc1.nextInt();
        if (request == 1)
        {
            System.out.println("Enter the wanted information");
            System.out.println("*NOTICE* You can only edit the general information of the products later");
            System.out.print("Product name: ");
            String productName = sc1.next();
            System.out.print("Product Company: ");
            String productCompany = sc1.next();
            System.out.print("Product Price: ");
            double productPrice = 0;
            try
            {
                productPrice = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Product Seller Name: ");
            String productSellerName = sc1.next();
            System.out.print("Inventory:  enter true or false");
            boolean inventory = false;
            try
            {
                inventory = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Preamble: ");
            String preamble = sc1.next();
            System.out.print("ProducerCountry: ");
            String producerCountry = sc1.next();
            System.out.print("Material: ");
            String material = sc1.next();
            System.out.print("Size: ");
            String size = sc1.next();
            System.out.println("Kind: T_SHIRT , PANTS , DRESS , HAT , GLOVES");
            String kind = sc1.next();
            //Clothes.ClothesKind.valueOf(kind);
            SellerManager.getSellerManager().addClothes(index,productName,productCompany,productPrice,productSellerName,
                    inventory,preamble,producerCountry,material,size,kind);
        }
        if (request == 2)
        {
            addProducts(index);
        }
        else
        {
            System.out.println("Please enter the correct number!");
            addClothes(index);
        }
    }
    public static void addShoes(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD SHOES PANEL");
        System.out.println("------------------------------");
        System.out.println("Do you wanna add a pair of shoes?");
        System.out.println("Enter 1 for {YES} or 2 for {NO}");
        int request = sc1.nextInt();
        if (request == 1)
        {
            System.out.println("Enter the wanted information");
            System.out.println("*NOTICE* You can only edit the general information of the products later");
            System.out.print("Product name: ");
            String productName = sc1.next();
            System.out.print("Product Company: ");
            String productCompany = sc1.next();
            System.out.print("Product Price: ");
            double productPrice = 0;
            try
            {
                productPrice = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Product Seller Name: ");
            String productSellerName = sc1.next();
            System.out.print("Inventory:  enter true or false");
            boolean inventory = false;
            try
            {
                inventory = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Preamble: ");
            String preamble = sc1.next();
            System.out.print("ProducerCountry: ");
            String producerCountry = sc1.next();
            System.out.print("Material: ");
            String material = sc1.next();
            System.out.print("Size: ");
            String size = sc1.next();
            System.out.println("Kind: BOOTS , SNEAKERS , FLAT , HIGH_HEELED , SANDALS");
            String kind = sc1.next();
            //Shoes.ShoesKind.valueOf(kind);
            SellerManager.getSellerManager().addShoes(index,productName,productCompany,productPrice,productSellerName,
                    inventory,preamble,producerCountry,material,size, kind);
        }
        if (request == 2)
        {
            addProducts(index);
        }
        else
        {
            System.out.println("Please enter the correct number!");
            addShoes(index);
        }
    }
    public static void addDomesticProducts(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD DOMESTIC PRODUCT PANEL");
        System.out.println("-----------------------------------------");
        System.out.println("Enter 1 for {ADD TELEVISION}");
        System.out.println("Enter 2 for {ADD REFRIGERATOR}");
        System.out.println("Enter 3 for {ADD STOVE}");
        System.out.println("Enter 4 for {BACK TO ADD PRODUCTS PANEL}");
        System.out.println("Please enter the number of each process that you want");
        int request = sc1.nextInt();
        switch (request)
        {
            case 1:
                addTelevision(index);
                break;
            case 2:
                addRefrigerator(index);
                break;
            case 3:
                addStove(index);
                break;
            case 4:
                addProducts(index);
            default:
                System.out.println("Please enter the correct number!");
                addDomesticProducts(index);
        }
    }
    public static void addTelevision(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD TELEVISION PANEL");
        System.out.println("-----------------------------------");
        System.out.println("Do you wanna add a television?");
        System.out.println("Enter 1 for {YES} or 2 for {NO}");
        int request = sc1.nextInt();
        if (request == 1)
        {
            System.out.println("Enter the wanted information");
            System.out.println("*NOTICE* You can only edit the general information of the products later");
            System.out.print("Product name: ");
            String productName = sc1.next();
            System.out.print("Product Company: ");
            String productCompany = sc1.next();
            System.out.print("Product Price: ");
            double productPrice = 0;
            try
            {
                productPrice = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Product Seller Name: ");
            String productSellerName = sc1.next();
            System.out.print("Inventory:  enter true or false");
            boolean inventory = false;
            try
            {
                inventory = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Preamble: ");
            String preamble = sc1.next();
            System.out.print("Energy Label: ");
            String energyLabel = sc1.next();
            System.out.print("Warranty:  enter true or false");
            boolean warranty = true;
            try
            {
                warranty = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Image Quality: ");
            String imageQuality = sc1.next();
            System.out.print("Screen Size: ");
            double screenSize = 0;
            try
            {
                screenSize = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            SellerManager.getSellerManager().addTelevision(index,productName,productCompany,productPrice,productSellerName,inventory,
                    preamble,energyLabel,warranty,imageQuality,screenSize);
        }
        if (request == 2)
        {
            addProducts(index);
        }
        else
        {
            System.out.println("Please enter the correct number!");
            addTelevision(index);
        }
    }
    public static void addRefrigerator(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD REFRIGERATOR PANEL");
        System.out.println("-------------------------------------");
        System.out.println("Do you wanna add a refrigerator?");
        System.out.println("Enter 1 for {YES} or 2 for {NO}");
        int request = sc1.nextInt();
        if (request == 1)
        {
            System.out.println("Enter the wanted information");
            System.out.println("*NOTICE* You can only edit the general information of the products later");
            System.out.print("Product name: ");
            String productName = sc1.next();
            System.out.print("Product Company: ");
            String productCompany = sc1.next();
            System.out.print("Product Price: ");
            double productPrice = 0;
            try
            {
                productPrice = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Product Seller Name: ");
            String productSellerName = sc1.next();
            System.out.print("Inventory:  enter true or false");
            boolean inventory = true;
            try
            {
                inventory = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Preamble: ");
            String preamble = sc1.next();
            System.out.print("Energy Label: ");
            String energyLabel = sc1.next();
            System.out.print("Warranty:  enter true or false");
            boolean warranty = true;
            try
            {
                warranty = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Capacity: ");
            double capacity = 0;
            try
            {
                capacity = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Kind: ");
            String kind = sc1.next();
            System.out.print("Have Freezer:  enter true or false");
            boolean haveFreezer = true;
            try
            {
                haveFreezer = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            SellerManager.getSellerManager().addRefrigerator(index,productName,productCompany,productPrice
                    ,productSellerName,inventory,preamble,energyLabel,warranty,capacity,kind,haveFreezer);
        }
        if (request == 2)
        {
            addProducts(index);
        }
        else
        {
            System.out.println("Please enter the correct number!");
            addRefrigerator(index);
        }
    }
    public static void addStove(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD STOVE PANEL");
        System.out.println("------------------------------");
        System.out.println("Do you wanna add a stove?");
        System.out.println("Enter 1 for {YES} or 2 for {NO}");
        int request = sc1.nextInt();
        if (request == 1)
        {
            System.out.println("Enter the wanted information");
            System.out.println("*NOTICE* You can only edit the general information of the products later");
            System.out.print("Product name: ");
            String productName = sc1.next();
            System.out.print("Product Company: ");
            String productCompany = sc1.next();
            System.out.print("Product Price: ");
            double productPrice = 0;
            try
            {
                productPrice = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Product Seller Name: ");
            String productSellerName = sc1.next();
            System.out.print("Inventory:  enter true or false");
            boolean inventory = false;
            try
            {
                inventory = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Preamble: ");
            String preamble = sc1.next();
            System.out.print("Energy Label: ");
            String energyLabel = sc1.next();
            System.out.print("Warranty:  enter true or false");
            boolean warranty = true;
            try
            {
                warranty = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.println("Flame Number: ");
            int flameNumber = 0;
            try
            {
                flameNumber = sc1.nextInt();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Kind: ");
            String kind = sc1.next();
            System.out.print("Have Oven:  enter true or false");
            boolean haveOven = true;
            try
            {
                haveOven = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            SellerManager.getSellerManager().addStove(index,productName,productCompany,productPrice,productSellerName,inventory,
                    preamble,energyLabel,warranty,flameNumber,kind,haveOven);
        }
        if (request == 2)
        {
            addProducts(index);
        }
        else
        {
            System.out.println("Please enter the correct number!");
            addStove(index);
        }
    }
    public static void addEatingProducts(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD EATING PRODUCT PANEL");
        System.out.println("---------------------------------------");
        System.out.println("Do you wanna add a eating product?");
        System.out.println("Enter 1 for {YES} or 2 for {NO}");
        int request = sc1.nextInt();
        if (request == 1)
        {
            System.out.println("Enter the wanted information");
            System.out.println("*NOTICE* You can only edit the general information of the products later");
            System.out.print("Product name: ");
            String productName = sc1.next();
            System.out.print("Product Company: ");
            String productCompany = sc1.next();
            System.out.print("Product Price: ");
            double productPrice = 0;
            try
            {
                productPrice = sc1.nextDouble();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Product Seller Name: ");
            String productSellerName = sc1.next();
            System.out.print("Inventory:  enter true or false");
            boolean inventory = sc1.nextBoolean();
            try
            {
                inventory = sc1.nextBoolean();
            }
            catch (InputMismatchException I)
            {
                System.out.println(I.toString());
            }
            finally
            {
                System.out.println("GOOD LOCK!");
            }
            System.out.print("Preamble: ");
            String preamble = sc1.next();
            System.out.print("Production Date: ");
            String productionDate = sc1.next();
            System.out.print("Expiry Date: ");
            String expiryDate = sc1.next();
            SellerManager.getSellerManager().addEatingProducts(index,productName,productCompany,productPrice
                    ,productSellerName, inventory,preamble,productionDate,expiryDate);
        }
        if (request == 2)
        {
            addProducts(index);
        }
        else
        {
            System.out.println("Please enter the correct number!");
            addEatingProducts(index);
        }
    }
    public static void showAllRequests(int index) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE SHOW ALL REQUESTS PANEL");
        System.out.println("--------------------------------------");
        System.out.println("Requests that the admin still does not confirm or reject: ");
        System.out.println("NOTICE: if the request does not exist here, go and check the thing that you did requested for.");
        System.out.println("Add products requests: ");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < Requests.getAddProductRequestsList().size(); i++)
        {
            if (Requests.getAddProductRequestsList().get(i).getProductSellerName().equals(Lists.getSellersList().get(index).getName()))
                System.out.println(Requests.getAddProductRequestsList().get(i).toString());
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("Edit products requests: ");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < Requests.getEditProductRequestsList().size(); i++)
        {
            if (Requests.getEditProductRequestsList().get(i).getProductSellerName().equals(Lists.getSellersList().get(index).getName()))
                System.out.println(Requests.getEditProductRequestsList().get(i).toString());
        }
        System.out.println("------------------------------------------------------------");
        Menu.mainMenu();
    }
}
class AdminPanel implements Serializable
{
    public static void changeAdminAccountInfo() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE CHANGE ACCOUNT INFORMATION PANEL");
        System.out.println("-----------------------------------------------");
        System.out.println("The information of your admin account: ");
        System.out.println(Admin.getAdmin().toString());
        System.out.println("Please update your information one by one");
        System.out.println("If you do not want to change something, just enter the previous thing again");
        System.out.println("Name: ");
        String name = sc1.next();
        System.out.println("Last Name: ");
        String lastName = sc1.next();
        System.out.println("Email: ");
        String email = sc1.next();
        System.out.println("Phone Number: ");
        String phoneNumber = sc1.next();
        Admin.getAdmin().setName(name);
        Admin.getAdmin().setLastName(lastName);
        Admin.getAdmin().setEmail(email);
        Admin.getAdmin().setPhoneNumber(phoneNumber);
        System.out.println("Your information has updated!");
        System.out.println("Type {finished} when you did your work");
        String request = sc1.next();
        if (request.equals("finished"))
        {
            Menu.adminLoginPanel();
        }
    }
    public static void showAccountsList() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE SHOW ACCOUNTS LIST PANEL");
        System.out.println("---------------------------------------");
        System.out.println("Costumers List: ");
        for (int i = 0; i < Lists.getCostumersList().size(); i++)
        {
            System.out.println(Lists.getCostumersList().get(i).toString());
            System.out.println("---------------------------------------------------------------");
        }
        System.out.println("Sellers List: ");
        for (int i = 0; i < Lists.getSellersList().size(); i++)
        {
            System.out.println(Lists.getSellersList().get(i).toString());
            System.out.println("---------------------------------------------------------------");
        }
        System.out.println("Type {finished} when you saw the list");
        String request = sc.next();
        if (request.equals("finished"))
        {
            Menu.adminLoginPanel();
        }
    }
    public static void removeAnAccount() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE REMOVE AN ACCOUNT PANEL");
        System.out.println("--------------------------------------");
        System.out.println("Costumers List: ");
        for (int i = 0; i < Lists.getCostumersList().size(); i++)
        {
            System.out.println(Lists.getCostumersList().get(i).toString());
            System.out.println("---------------------------------------------------------------");
        }
        System.out.println("Sellers List: ");
        for (int i = 0; i < Lists.getSellersList().size(); i++)
        {
            System.out.println(Lists.getSellersList().get(i).toString());
            System.out.println("---------------------------------------------------------------");
        }
        System.out.println("What is the position of the account you want to remove? Type {costumer} or {seller}");
        String request = sc.next();
        if (request.equals("costumer"))
        {
            System.out.println("Enter the accountName of the costumer you want to remove");
            String accountName = sc.next();
            for (int i = 0; i < Lists.getCostumersList().size(); i++)
                if (accountName.equals(Lists.getCostumersList().get(i).getAccountName()))
                    Lists.getCostumersList().remove(i);
            System.out.println("The costumer have removed successfully!");
        }
        else if (request.equals("seller"))
        {
            System.out.println("Enter the accountName of the seller you want to remove");
            String accountName = sc.next();
            for (int i = 0; i < Lists.getSellersList().size(); i++)
                if (accountName.equals(Lists.getSellersList().get(i).getAccountName()))
                    Lists.getSellersList().remove(i);
            System.out.println("The seller have removed successfully!");
        }
        System.out.println("Type {finished} when you did your work");
        String request2 = sc.next();
        if (request2.equals("finished"))
        {
            Menu.adminLoginPanel();
        }
    }
    public static void showCategoryList() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO SHOW CATEGORY LIST PANEL");
        System.out.println("-----------------------------------");
        System.out.println("DIGITAL PRODUCTS: ");
        System.out.println("-------------------------------LAPTOP---------------------------------");
        for (int i = 0; i < Lists.getLaptopList().size(); i++)
        {
            System.out.println(Lists.getLaptopList().get(i).toString());
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println("-------------------------------MOBILE PHONE---------------------------------");
        for (int i = 0; i < Lists.getMobilePhoneList().size(); i++)
        {
            System.out.println(Lists.getMobilePhoneList().get(i).toString());
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println("WEARING PRODUCTS: ");
        System.out.println("-------------------------------CLOTHES---------------------------------");
        for (int i = 0; i < Lists.getClothesList().size(); i++)
        {
            System.out.println(Lists.getClothesList().get(i).toString());
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println("-------------------------------SHOES---------------------------------");
        for (int i = 0; i < Lists.getShoesList().size(); i++)
        {
            System.out.println(Lists.getShoesList().get(i).toString());
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println("DOMESTIC PRODUCTS: ");
        System.out.println("-------------------------------TELEVISION---------------------------------");
        for (int i = 0; i < Lists.getTelevisionList().size(); i++)
        {
            System.out.println(Lists.getTelevisionList().get(i).toString());
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println("-------------------------------REFRIGERATOR---------------------------------");
        for (int i = 0; i < Lists.getRefrigeratorList().size(); i++)
        {
            System.out.println(Lists.getRefrigeratorList().get(i).toString());
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println("-------------------------------STOVE---------------------------------");
        for (int i = 0; i < Lists.getStoveList().size(); i++)
        {
            System.out.println(Lists.getStoveList().get(i).toString());
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println("EATING PRODUCTS: ");
        for (int i = 0; i < Lists.getEatingProductsList().size(); i++)
        {
            System.out.println(Lists.getEatingProductsList().get(i).toString());
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println("Type {finished} when you did your work");
        String request2 = sc.next();
        if (request2.equals("finished"))
        {
            Menu.adminLoginPanel();
        }
    }
    public static void showBeingSellerRequests() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE BEING SELLER REQUESTS PANEL");
        System.out.println("------------------------------------------");
        FileOutputStream fOut0 = new FileOutputStream("F:/ProjectF2/savedData/users/admin/beingSellerRequests.txt", true);
        ObjectOutputStream oOut0 = new ObjectOutputStream(fOut0);
        oOut0.writeObject(Requests.getSellersRequestsList());
        System.out.println("The requests are: ");
        for (int i = 0; i < Requests.getSellersRequestsList().size(); i++)
        {
            System.out.println(Requests.getSellersRequestsList().get(i).toString());
            System.out.println("------------------------------------------------------------------");
            System.out.println("Enter {confirm} to have the seller");
            System.out.println("Enter {ignore} to ignore the seller");
            String request = sc1.next();
            if (request.equals("confirm"))
            {
                File fOut = new File("F:/ProjectF2/savedData/users/sellers" , "seller" + Requests.getSellersRequestsList().get(i).getSellerID());
                if (!(fOut.exists()))
                    fOut.mkdirs();
                File fOut2 = new File(fOut , "information.txt");
                fOut2.createNewFile();
                Formatter f = new Formatter(fOut2);
                f.format("%d %s %s %s %s %s %s %s %s %s %s" , Requests.getSellersRequestsList().get(i).getSellerID() , Requests.getSellersRequestsList().get(i).getAccountName() , Requests.getSellersRequestsList().get(i).getName() , Requests.getSellersRequestsList().get(i).getLastName() , Requests.getSellersRequestsList().get(i).getEmail()
                        , Requests.getSellersRequestsList().get(i).getPhoneNumber() , Requests.getSellersRequestsList().get(i).getPassword() , Requests.getSellersRequestsList().get(i).getCompanyName() , Requests.getSellersRequestsList().get(i).getCompanyEstablishmentDate() , Requests.getSellersRequestsList().get(i).getCompanyPreamble() , Requests.getSellersRequestsList().get(i).getProperty());
                f.flush();
                f.close();
                Lists.getSellersList().add(Requests.getSellersRequestsList().get(i));
                Requests.getSellersRequestsList().remove(i);
                System.out.println("Accepted.");
            }
            else if (request.equals("ignore"))
            {
                Requests.getSellersRequestsList().remove(i);
                System.out.println("Not Accepted.");
            }
        }
        Menu.adminLoginPanel();
    }
    public static void showAddProductRequests() throws FileNotFoundException , UnsupportedEncodingException , IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE ADD PRODUCT REQUESTS PANEL");
        System.out.println("-----------------------------------------");
        FileOutputStream fOut0 = new FileOutputStream("F:/ProjectF2/savedData/users/admin/addProductsRequests.txt", true);
        ObjectOutputStream oOut0 = new ObjectOutputStream(fOut0);
        oOut0.writeObject(Requests.getAddProductRequestsList());
        System.out.println("The requests are: ");
        for (int i = 0; i < Requests.getAddProductRequestsList().size(); i++)
        {
            System.out.println(Requests.getAddProductRequestsList().get(i).toString());
            System.out.println("------------------------------------------------------------------");
            System.out.println("Enter {confirm} to add the product");
            System.out.println("Enter {ignore} to do not add the product");
            String request = sc1.next();
            if (request.equals("confirm"))
            {
                Lists.getProductsList().add(Requests.getAddProductRequestsList().get(i));
                //Requests.getAddProductRequestsList().remove(i);
                if (Requests.getAddProductRequestsList().get(i) instanceof DigitalProducts)
                {
                    if (Requests.getAddProductRequestsList().get(i) instanceof Laptop)
                    {
                        int laptopIndex = 0;
                        for (int j = 0; j < Requests.getAddLaptopRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddLaptopRequestsList().get(j).getProductID())
                                laptopIndex = j;
                        File fOut = new File("F:/ProjectF2/savedData/categories/digitalProducts/laptops/laptopsList" , "laptop" + Requests.getAddLaptopRequestsList().get(laptopIndex).getProductID());
                        if (!(fOut.exists()))
                            fOut.mkdirs();
                        File fOut2 = new File(fOut , "information.txt");
                        fOut2.createNewFile();
                        Formatter f = new Formatter(fOut2);
                        f.format("%d %s %s %f %s %b %s %d %d %s %f %f %s %b" , Requests.getAddLaptopRequestsList().get(laptopIndex).getProductID() , Requests.getAddLaptopRequestsList().get(laptopIndex).getProductName() , Requests.getAddLaptopRequestsList().get(laptopIndex).getProductCompany(), Requests.getAddLaptopRequestsList().get(laptopIndex).getProductPrice() , Requests.getAddLaptopRequestsList().get(laptopIndex).getProductSellerName() , Requests.getAddLaptopRequestsList().get(laptopIndex).getInventory() ,
                                Requests.getAddLaptopRequestsList().get(laptopIndex).getPreamble() , Requests.getAddLaptopRequestsList().get(laptopIndex).getMemoryCapacity(), Requests.getAddLaptopRequestsList().get(laptopIndex).getRAMMemoryCapacity() , Requests.getAddLaptopRequestsList().get(laptopIndex).getOperatingSystem() , Requests.getAddLaptopRequestsList().get(laptopIndex).getWeight() , Requests.getAddLaptopRequestsList().get(laptopIndex).getDimensions() , Requests.getAddLaptopRequestsList().get(laptopIndex).getCPU() , Requests.getAddLaptopRequestsList().get(laptopIndex).isGaming());
                        f.flush();
                        f.close();
                        for (int j = 0; j < Lists.getSellersList().size(); j++)
                        {
                            if (Lists.getSellersList().get(j).getName().equals(Requests.getAddLaptopRequestsList().get(laptopIndex).getProductSellerName()))
                            {
                                Lists.getSellersList().get(j).productsList.add(Requests.getAddLaptopRequestsList().get(laptopIndex));
                                File productsList = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID() , "productsList");
                                if (!(productsList.exists()))
                                    productsList.mkdirs();

                                File fOut3 = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID() + "/productsList" , "laptop" + Requests.getAddLaptopRequestsList().get(laptopIndex).getProductID());
                                if (!(fOut3.exists()))
                                    fOut3.mkdirs();
                                File fOut4 = new File(fOut3 , "information.txt");
                                fOut4.createNewFile();
                                Formatter f2 = new Formatter(fOut4);
                                f2.format("%d %s %s %f %s %b %s %d %d %s %f %f %s %b" , Requests.getAddLaptopRequestsList().get(laptopIndex).getProductID() , Requests.getAddLaptopRequestsList().get(laptopIndex).getProductName() , Requests.getAddLaptopRequestsList().get(laptopIndex).getProductCompany(), Requests.getAddLaptopRequestsList().get(laptopIndex).getProductPrice() , Requests.getAddLaptopRequestsList().get(laptopIndex).getProductSellerName() , Requests.getAddLaptopRequestsList().get(laptopIndex).getInventory() ,
                                        Requests.getAddLaptopRequestsList().get(laptopIndex).getPreamble() , Requests.getAddLaptopRequestsList().get(laptopIndex).getMemoryCapacity(), Requests.getAddLaptopRequestsList().get(laptopIndex).getRAMMemoryCapacity() , Requests.getAddLaptopRequestsList().get(laptopIndex).getOperatingSystem() , Requests.getAddLaptopRequestsList().get(laptopIndex).getWeight() , Requests.getAddLaptopRequestsList().get(laptopIndex).getDimensions() , Requests.getAddLaptopRequestsList().get(laptopIndex).getCPU() , Requests.getAddLaptopRequestsList().get(laptopIndex).isGaming());
                                f2.flush();
                                f2.close();
                            }

                        }
                        Lists.getLaptopList().add(Requests.getAddLaptopRequestsList().get(laptopIndex));
                        Requests.getAddLaptopRequestsList().remove(laptopIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                    else if (Requests.getAddProductRequestsList().get(i) instanceof MobilePhone)
                    {
                        int mobilePhoneIndex = 0;
                        for (int j = 0; j < Requests.getAddMobilePhoneRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddMobilePhoneRequestsList().get(j).getProductID())
                                mobilePhoneIndex = j;
                        File fOut = new File("F:/ProjectF2/savedData/categories/digitalProducts/mobilePhones/mobilePhonesList" , "mobilePhone" + Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductID());
                        if (!(fOut.exists()))
                            fOut.mkdirs();
                        File fOut2 = new File(fOut , "information.txt");
                        fOut2.createNewFile();
                        Formatter f = new Formatter(fOut2);
                        f.format("%d %s %s %f %s %b %s %d %d %s %f %f %s %b" , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductID() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductName() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductCompany(), Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductPrice() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductSellerName() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getInventory() ,
                                Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getPreamble(), Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getMemoryCapacity(), Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getRAMMemoryCapacity() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getOperatingSystem() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getWeight() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getDimensions() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getSimCardNumber() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getCameraQuality());
                        f.flush();
                        f.close();
                        for (int j = 0; j < Lists.getSellersList().size(); j++)
                        {
                            if (Lists.getSellersList().get(j).getName().equals(Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductSellerName()))
                            {
                                Lists.getSellersList().get(j).productsList.add(Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex));
                                File productsList = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID(), "productsList");
                                if (!(productsList.exists()))
                                    productsList.mkdirs();

                                File fOut3 = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID() + "/productsList" , "mobilePhone" + Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductID());
                                if (!(fOut3.exists()))
                                    fOut3.mkdirs();
                                File fOut4 = new File(fOut3 , "information.txt");
                                fOut4.createNewFile();
                                Formatter f2 = new Formatter(fOut4);
                                f2.format("%d %s %s %f %s %b %s %d %d %s %f %f %s %b" , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductID() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductName() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductCompany(), Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductPrice() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getProductSellerName() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getInventory() ,
                                        Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getPreamble(), Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getMemoryCapacity(), Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getRAMMemoryCapacity() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getOperatingSystem() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getWeight() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getDimensions() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getSimCardNumber() , Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex).getCameraQuality());
                                f2.flush();
                                f2.close();
                            }
                        }
                        Lists.getMobilePhoneList().add(Requests.getAddMobilePhoneRequestsList().get(mobilePhoneIndex));
                        Requests.getAddMobilePhoneRequestsList().remove(mobilePhoneIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                }
                else if (Requests.getAddProductRequestsList().get(i) instanceof WearingProducts)
                {
                    if (Requests.getAddProductRequestsList().get(i) instanceof Clothes)
                    {
                        int clothesIndex = 0;
                        for (int j = 0; j < Requests.getAddClothesRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddClothesRequestsList().get(j).getProductID())
                                clothesIndex = j;
                        File fOut = new File("F:/ProjectF2/savedData/categories/wearingProducts/clothes/clothesList" , "cloth" + Requests.getAddClothesRequestsList().get(clothesIndex).getProductID());
                        if (!(fOut.exists()))
                            fOut.mkdirs();
                        File fOut2 = new File(fOut , "information.txt");
                        fOut2.createNewFile();
                        Formatter f = new Formatter(fOut2);
                        f.format("%d %s %s %f %s %b %s %s %s %s %s" , Requests.getAddClothesRequestsList().get(clothesIndex).getProductID() , Requests.getAddClothesRequestsList().get(clothesIndex).getProductName() , Requests.getAddClothesRequestsList().get(clothesIndex).getProductCompany(), Requests.getAddClothesRequestsList().get(clothesIndex).getProductPrice() , Requests.getAddClothesRequestsList().get(clothesIndex).getProductSellerName() , Requests.getAddClothesRequestsList().get(clothesIndex).getInventory() ,
                                Requests.getAddClothesRequestsList().get(clothesIndex).getPreamble() , Requests.getAddClothesRequestsList().get(clothesIndex).getProducerCountry() , Requests.getAddClothesRequestsList().get(clothesIndex).getMaterial() , Requests.getAddClothesRequestsList().get(clothesIndex).getSize() , Requests.getAddClothesRequestsList().get(clothesIndex).getKind());
                        f.flush();
                        f.close();
                        for (int j = 0; j < Lists.getSellersList().size(); j++)
                        {
                            if (Lists.getSellersList().get(j).getName().equals(Requests.getAddClothesRequestsList().get(clothesIndex).getProductSellerName()))
                            {
                                Lists.getSellersList().get(j).productsList.add(Requests.getAddClothesRequestsList().get(clothesIndex));
                                File productsList = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID(), "productsList");
                                if (!(productsList.exists()))
                                    productsList.mkdirs();

                                File fOut3 = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID() + "/productsList" , "cloth" + Requests.getAddClothesRequestsList().get(clothesIndex).getProductID());
                                if (!(fOut3.exists()))
                                    fOut3.mkdirs();
                                File fOut4 = new File(fOut3 , "information.txt");
                                fOut4.createNewFile();
                                Formatter f2 = new Formatter(fOut4);
                                f2.format("%d %s %s %f %s %b %s %s %s %s %s" , Requests.getAddClothesRequestsList().get(clothesIndex).getProductID() , Requests.getAddClothesRequestsList().get(clothesIndex).getProductName() , Requests.getAddClothesRequestsList().get(clothesIndex).getProductCompany(), Requests.getAddClothesRequestsList().get(clothesIndex).getProductPrice() , Requests.getAddClothesRequestsList().get(clothesIndex).getProductSellerName() , Requests.getAddClothesRequestsList().get(clothesIndex).getInventory() ,
                                        Requests.getAddClothesRequestsList().get(clothesIndex).getPreamble() , Requests.getAddClothesRequestsList().get(clothesIndex).getProducerCountry() , Requests.getAddClothesRequestsList().get(clothesIndex).getMaterial() , Requests.getAddClothesRequestsList().get(clothesIndex).getSize() , Requests.getAddClothesRequestsList().get(clothesIndex).getKind());
                                f2.flush();
                                f2.close();
                            }
                        }
                        Lists.getClothesList().add(Requests.getAddClothesRequestsList().get(clothesIndex));
                        Requests.getAddClothesRequestsList().remove(clothesIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                    else if (Requests.getAddProductRequestsList().get(i) instanceof Shoes)
                    {
                        int shoesIndex = 0;
                        for (int j = 0; j < Requests.getAddShoesRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddShoesRequestsList().get(j).getProductID())
                                shoesIndex = j;
                        File fOut = new File("F:/ProjectF2/savedData/categories/wearingProducts/shoes/shoesList" , "shoes" + Requests.getAddShoesRequestsList().get(shoesIndex).getProductID());
                        if (!(fOut.exists()))
                            fOut.mkdirs();
                        File fOut2 = new File(fOut , "information.txt");
                        fOut2.createNewFile();
                        Formatter f = new Formatter(fOut2);
                        f.format("%d %s %s %f %s %b %s %s %s %s %s" , Requests.getAddShoesRequestsList().get(shoesIndex).getProductID() , Requests.getAddShoesRequestsList().get(shoesIndex).getProductName() , Requests.getAddShoesRequestsList().get(shoesIndex).getProductCompany(), Requests.getAddShoesRequestsList().get(shoesIndex).getProductPrice() , Requests.getAddShoesRequestsList().get(shoesIndex).getProductSellerName() , Requests.getAddShoesRequestsList().get(shoesIndex).getInventory() ,
                                Requests.getAddShoesRequestsList().get(shoesIndex).getPreamble() , Requests.getAddShoesRequestsList().get(shoesIndex).getProducerCountry() , Requests.getAddShoesRequestsList().get(shoesIndex).getMaterial() , Requests.getAddShoesRequestsList().get(shoesIndex).getSize() , Requests.getAddShoesRequestsList().get(shoesIndex).getKind());
                        f.flush();
                        f.close();
                        for (int j = 0; j < Lists.getSellersList().size(); j++)
                        {
                            if (Lists.getSellersList().get(j).getName().equals(Requests.getAddShoesRequestsList().get(shoesIndex).getProductSellerName()))
                            {
                                Lists.getSellersList().get(j).productsList.add(Requests.getAddShoesRequestsList().get(shoesIndex));
                                File productsList = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID(), "productsList");
                                if (!(productsList.exists()))
                                    productsList.mkdirs();

                                File fOut3 = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID() + "/productsList" , "shoes" + Requests.getAddShoesRequestsList().get(shoesIndex).getProductID());
                                if (!(fOut3.exists()))
                                    fOut3.mkdirs();
                                File fOut4 = new File(fOut3 , "information.txt");
                                fOut4.createNewFile();
                                Formatter f2 = new Formatter(fOut4);
                                f2.format("%d %s %s %f %s %b %s %s %s %s %s" , Requests.getAddShoesRequestsList().get(shoesIndex).getProductID() , Requests.getAddShoesRequestsList().get(shoesIndex).getProductName() , Requests.getAddShoesRequestsList().get(shoesIndex).getProductCompany(), Requests.getAddShoesRequestsList().get(shoesIndex).getProductPrice() , Requests.getAddShoesRequestsList().get(shoesIndex).getProductSellerName() , Requests.getAddShoesRequestsList().get(shoesIndex).getInventory() ,
                                        Requests.getAddShoesRequestsList().get(shoesIndex).getPreamble() , Requests.getAddShoesRequestsList().get(shoesIndex).getProducerCountry() , Requests.getAddShoesRequestsList().get(shoesIndex).getMaterial() , Requests.getAddShoesRequestsList().get(shoesIndex).getSize() , Requests.getAddShoesRequestsList().get(shoesIndex).getKind());
                                f2.flush();
                                f2.close();
                            }
                        }
                        Lists.getShoesList().add(Requests.getAddShoesRequestsList().get(shoesIndex));
                        Requests.getAddShoesRequestsList().remove(shoesIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }

                }
                else if (Requests.getAddProductRequestsList().get(i) instanceof DomesticProducts)
                {
                    if (Requests.getAddProductRequestsList().get(i) instanceof Television)
                    {
                        int televisionIndex = 0;
                        for (int j = 0; j < Requests.getAddTelevisionRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddTelevisionRequestsList().get(j).getProductID())
                                televisionIndex = j;
                        File fOut = new File("F:/ProjectF2/savedData/categories/domesticProducts/televisions/televisionsList" , "television" + Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductID());
                        if (!(fOut.exists()))
                            fOut.mkdirs();
                        File fOut2 = new File(fOut , "information.txt");
                        fOut2.createNewFile();
                        Formatter f = new Formatter(fOut2);
                        f.format("%d %s %s %f %s %b %s %s %b %s %f" , Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductID() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductName() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductCompany(), Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductPrice() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductSellerName() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getInventory() ,
                                Requests.getAddTelevisionRequestsList().get(televisionIndex).getPreamble() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getEnergyLabel() , Requests.getAddTelevisionRequestsList().get(televisionIndex).isWarranty() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getImageQuality() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getScreenSize());
                        f.flush();
                        f.close();
                        for (int j = 0; j < Lists.getSellersList().size(); j++)
                        {
                            if (Lists.getSellersList().get(j).getName().equals(Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductSellerName()))
                            {
                                Lists.getSellersList().get(j).productsList.add(Requests.getAddTelevisionRequestsList().get(televisionIndex));
                                File productsList = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID(), "productsList");
                                if (!(productsList.exists()))
                                    productsList.mkdirs();

                                File fOut3 = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID() + "/productsList" , "television" + Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductID());
                                if (!(fOut3.exists()))
                                    fOut3.mkdirs();
                                File fOut4 = new File(fOut3 , "information.txt");
                                fOut4.createNewFile();
                                Formatter f2 = new Formatter(fOut4);
                                f2.format("%d %s %s %f %s %b %s %s %b %s %f" , Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductID() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductName() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductCompany(), Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductPrice() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getProductSellerName() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getInventory() ,
                                        Requests.getAddTelevisionRequestsList().get(televisionIndex).getPreamble() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getEnergyLabel() , Requests.getAddTelevisionRequestsList().get(televisionIndex).isWarranty() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getImageQuality() , Requests.getAddTelevisionRequestsList().get(televisionIndex).getScreenSize());
                                f2.flush();
                                f2.close();
                            }
                        }

                        Lists.getTelevisionList().add(Requests.getAddTelevisionRequestsList().get(televisionIndex));
                        Requests.getAddTelevisionRequestsList().remove(televisionIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                    else if (Requests.getAddProductRequestsList().get(i) instanceof Refrigerator)
                    {
                        int refrigeratorIndex = 0;
                        for (int j = 0; j < Requests.getAddRefrigeratorRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddRefrigeratorRequestsList().get(j).getProductID())
                                refrigeratorIndex = j;
                        File fOut = new File("F:/ProjectF2/savedData/categories/domesticProducts/refrigerator/refrigeratorsList" , "refrigerator" + Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductID());
                        if (!(fOut.exists()))
                            fOut.mkdirs();
                        File fOut2 = new File(fOut , "information.txt");
                        fOut2.createNewFile();
                        Formatter f = new Formatter(fOut2);
                        f.format("%d %s %s %f %s %b %s %s %b %f %s %b" , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductID() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductName() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductCompany(), Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductPrice() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductSellerName() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getInventory() ,
                                Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getPreamble() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getEnergyLabel() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).isWarranty() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getCapacity() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getKind() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).isHaveFreezer());
                        f.flush();
                        f.close();
                        for (int j = 0; j < Lists.getSellersList().size(); j++)
                        {
                            if (Lists.getSellersList().get(j).getName().equals(Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductSellerName()))
                            {
                                Lists.getSellersList().get(j).productsList.add(Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex));
                                File productsList = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID(), "productsList");
                                if (!(productsList.exists()))
                                    productsList.mkdirs();

                                File fOut3 = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID() + "/productsList" , "refrigerator" + Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductID());
                                if (!(fOut3.exists()))
                                    fOut3.mkdirs();
                                File fOut4 = new File(fOut3 , "information.txt");
                                fOut4.createNewFile();
                                Formatter f2 = new Formatter(fOut4);
                                f2.format("%d %s %s %f %s %b %s %s %b %f %s %b" , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductID() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductName() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductCompany(), Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductPrice() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getProductSellerName() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getInventory() ,
                                        Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getPreamble() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getEnergyLabel() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).isWarranty() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getCapacity() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).getKind() , Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex).isHaveFreezer());
                                f2.flush();
                                f2.close();
                            }
                        }
                        Lists.getRefrigeratorList().add(Requests.getAddRefrigeratorRequestsList().get(refrigeratorIndex));
                        Requests.getAddRefrigeratorRequestsList().remove(refrigeratorIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                    else if (Requests.getAddProductRequestsList().get(i) instanceof Stove)
                    {
                        int stoveIndex = 0;
                        for (int j = 0; j < Requests.getAddStoveRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddStoveRequestsList().get(j).getProductID())
                                stoveIndex = j;
                        File fOut = new File("F:/ProjectF2/savedData/categories/domesticProducts/stoves/stovesList" , "stove" + Requests.getAddStoveRequestsList().get(stoveIndex).getProductID());
                        if (!(fOut.exists()))
                            fOut.mkdirs();
                        File fOut2 = new File(fOut , "information.txt");
                        fOut2.createNewFile();
                        Formatter f = new Formatter(fOut2);
                        f.format("%d %s %s %f %s %b %s %s %b %d %s %b" , Requests.getAddStoveRequestsList().get(stoveIndex).getProductID() , Requests.getAddStoveRequestsList().get(stoveIndex).getProductName() , Requests.getAddStoveRequestsList().get(stoveIndex).getProductCompany(), Requests.getAddStoveRequestsList().get(stoveIndex).getProductPrice() , Requests.getAddStoveRequestsList().get(stoveIndex).getProductSellerName() , Requests.getAddStoveRequestsList().get(stoveIndex).getInventory() ,
                                Requests.getAddStoveRequestsList().get(stoveIndex).getPreamble() , Requests.getAddStoveRequestsList().get(stoveIndex).getEnergyLabel() , Requests.getAddStoveRequestsList().get(stoveIndex).isWarranty() , Requests.getAddStoveRequestsList().get(stoveIndex).getFlameNumber() , Requests.getAddStoveRequestsList().get(stoveIndex).getKind() , Requests.getAddStoveRequestsList().get(stoveIndex).isHaveOven());
                        f.flush();
                        f.close();
                        for (int j = 0; j < Lists.getSellersList().size(); j++)
                        {
                            if (Lists.getSellersList().get(j).getName().equals(Requests.getAddStoveRequestsList().get(stoveIndex).getProductSellerName()))
                            {
                                Lists.getSellersList().get(j).productsList.add(Requests.getAddStoveRequestsList().get(stoveIndex));
                                File productsList = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID(), "productsList");
                                if (!(productsList.exists()))
                                    productsList.mkdirs();

                                File fOut3 = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID() + "/productsList" , "stove" + Requests.getAddStoveRequestsList().get(stoveIndex).getProductID());
                                if (!(fOut3.exists()))
                                    fOut3.mkdirs();
                                File fOut4 = new File(fOut3 , "information.txt");
                                fOut4.createNewFile();
                                Formatter f2 = new Formatter(fOut2);
                                f2.format("%d %s %s %f %s %b %s %s %b %d %s %b" , Requests.getAddStoveRequestsList().get(stoveIndex).getProductID() , Requests.getAddStoveRequestsList().get(stoveIndex).getProductName() , Requests.getAddStoveRequestsList().get(stoveIndex).getProductCompany(), Requests.getAddStoveRequestsList().get(stoveIndex).getProductPrice() , Requests.getAddStoveRequestsList().get(stoveIndex).getProductSellerName() , Requests.getAddStoveRequestsList().get(stoveIndex).getInventory() ,
                                        Requests.getAddStoveRequestsList().get(stoveIndex).getPreamble() , Requests.getAddStoveRequestsList().get(stoveIndex).getEnergyLabel() , Requests.getAddStoveRequestsList().get(stoveIndex).isWarranty() , Requests.getAddStoveRequestsList().get(stoveIndex).getFlameNumber() , Requests.getAddStoveRequestsList().get(stoveIndex).getKind() , Requests.getAddStoveRequestsList().get(stoveIndex).isHaveOven());
                                f2.flush();
                                f2.close();
                            }
                        }
                        Lists.getStoveList().add(Requests.getAddStoveRequestsList().get(stoveIndex));
                        Requests.getAddStoveRequestsList().remove(stoveIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                }
                else if (Requests.getAddProductRequestsList().get(i) instanceof EatingProducts)
                {
                    int eatingProductIndex = 0;
                    for (int j = 0; j < Requests.getAddEatingProductRequestsList().size(); j++)
                        if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddEatingProductRequestsList().get(j).getProductID())
                            eatingProductIndex = j;
                    File fOut = new File("F/ProjectF2/savedData/categories/eatingProducts/eatingProductsList" , "eatingProduct" + Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductID());
                    if (!(fOut.exists()))
                        fOut.mkdirs();
                    File fOut2 = new File(fOut , "information.txt");
                    fOut2.createNewFile();
                    Formatter f = new Formatter(fOut2);
                    f.format("%d %s %s %f %s %b %s %s %s" , Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductID() , Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductName() , Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductCompany(), Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductPrice() , Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductSellerName() , Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getInventory() ,
                            Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getPreamble() ,  Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductionDate() ,  Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getExpiryDate());
                    f.flush();
                    f.close();
                    for (int j = 0; j < Lists.getSellersList().size(); j++)
                    {
                        if (Lists.getSellersList().get(j).getName().equals(Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductSellerName()))
                        {
                            Lists.getSellersList().get(j).productsList.add(Requests.getAddEatingProductRequestsList().get(eatingProductIndex));
                            File productsList = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID(), "productsList");
                            if (!(productsList.exists()))
                                productsList.mkdirs();

                            File fOut3 = new File("F:/ProjectF2/savedData/users/sellers/seller" + Lists.getSellersList().get(j).getSellerID() + "/productsList" , "eatingProduct" + Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductID());
                            if (!(fOut3.exists()))
                                fOut3.mkdirs();
                            File fOut4 = new File(fOut3 , "information.txt");
                            fOut4.createNewFile();
                            Formatter f2 = new Formatter(fOut4);
                            f2.format("%d %s %s %f %s %b %s %s %s" , Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductID() , Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductName() , Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductCompany(), Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductPrice() , Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductSellerName() , Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getInventory() ,
                                    Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getPreamble() ,  Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getProductionDate() ,  Requests.getAddEatingProductRequestsList().get(eatingProductIndex).getExpiryDate());
                            f2.flush();
                            f2.close();
                        }
                    }
                    Lists.getEatingProductsList().add(Requests.getAddEatingProductRequestsList().get(eatingProductIndex));
                    Requests.getAddEatingProductRequestsList().remove(eatingProductIndex);
                    Requests.getAddProductRequestsList().remove(i);
                }
                System.out.println("Accepted.");
            }
            else if (request.equals("ignore"))
            {
                if (Requests.getAddProductRequestsList().get(i) instanceof DigitalProducts)
                {
                    if (Requests.getAddProductRequestsList().get(i) instanceof Laptop)
                    {
                        int laptopIndex = 0;
                        for (int j = 0; j < Requests.getAddLaptopRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddLaptopRequestsList().get(j).getProductID())
                                laptopIndex = j;
                        Requests.getAddLaptopRequestsList().remove(laptopIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                    else if (Requests.getAddProductRequestsList().get(i) instanceof MobilePhone)
                    {
                        int mobilePhoneIndex = 0;
                        for (int j = 0; j < Requests.getAddMobilePhoneRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddMobilePhoneRequestsList().get(j).getProductID())
                                mobilePhoneIndex = j;
                        Requests.getAddMobilePhoneRequestsList().remove(mobilePhoneIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                }
                else if (Requests.getAddProductRequestsList().get(i) instanceof WearingProducts)
                {
                    if (Requests.getAddProductRequestsList().get(i) instanceof Clothes)
                    {
                        int clothesIndex = 0;
                        for (int j = 0; j < Requests.getAddClothesRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddClothesRequestsList().get(j).getProductID())
                                clothesIndex = j;
                        Requests.getAddClothesRequestsList().remove(clothesIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                    else if (Requests.getAddProductRequestsList().get(i) instanceof Shoes)
                    {
                        int shoesIndex = 0;
                        for (int j = 0; j < Requests.getAddShoesRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddShoesRequestsList().get(j).getProductID())
                                shoesIndex = j;
                        Requests.getAddShoesRequestsList().remove(shoesIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }

                }
                else if (Requests.getAddProductRequestsList().get(i) instanceof DomesticProducts)
                {
                    if (Requests.getAddProductRequestsList().get(i) instanceof Television)
                    {
                        int televisionIndex = 0;
                        for (int j = 0; j < Requests.getAddTelevisionRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddTelevisionRequestsList().get(j).getProductID())
                                televisionIndex = j;
                        Requests.getAddTelevisionRequestsList().remove(televisionIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                    else if (Requests.getAddProductRequestsList().get(i) instanceof Refrigerator)
                    {
                        int refrigeratorIndex = 0;
                        for (int j = 0; j < Requests.getAddRefrigeratorRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddRefrigeratorRequestsList().get(j).getProductID())
                                refrigeratorIndex = j;
                        Requests.getAddRefrigeratorRequestsList().remove(refrigeratorIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                    else if (Requests.getAddProductRequestsList().get(i) instanceof Stove)
                    {
                        int stoveIndex = 0;
                        for (int j = 0; j < Requests.getAddStoveRequestsList().size(); j++)
                            if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddStoveRequestsList().get(j).getProductID())
                                stoveIndex = j;
                        Requests.getAddStoveRequestsList().remove(stoveIndex);
                        Requests.getAddProductRequestsList().remove(i);
                    }
                }
                else if (Requests.getAddProductRequestsList().get(i) instanceof EatingProducts)
                {
                    int eatingProductIndex = 0;
                    for (int j = 0; j < Requests.getAddEatingProductRequestsList().size(); j++)
                        if (Requests.getAddProductRequestsList().get(i).getProductID() == Requests.getAddEatingProductRequestsList().get(j).getProductID())
                            eatingProductIndex = j;
                    Requests.getAddEatingProductRequestsList().remove(eatingProductIndex);
                    Requests.getAddProductRequestsList().remove(i);
                }
                System.out.println("Not Accepted.");
            }
        }
        Menu.adminLoginPanel();
    }
    public static void showEditProductRequests() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE EDIT PRODUCT REQUESTS PANEL");
        System.out.println("------------------------------------------");
        FileOutputStream fOut0 = new FileOutputStream("F:/ProjectF2/savedData/users/admin/editProductsRequests.txt", true);
        ObjectOutputStream oOut0 = new ObjectOutputStream(fOut0);
        oOut0.writeObject(Requests.getEditProductRequestsList());
        System.out.println("The requests are: ");
        for (int i = 0; i < Requests.getEditProductRequestsList().size(); i++)
        {
            System.out.println(Requests.getEditProductRequestsList().get(i).toString());
            System.out.println("------------------------------------------------------------------");
            System.out.println("Enter {confirm} to edit the product");
            System.out.println("Enter {ignore} to do not edit the product");
            String request = sc1.next();
            if (request.equals("confirm"))
            {
                int mainListProductIndex = 0;
                for (int j = 0; j < Lists.getProductsList().size(); j++)
                    if (Requests.getEditProductRequestsList().get(i).getProductID() == Lists.getProductsList().get(j).getProductID())
                        mainListProductIndex = j;
                Lists.getProductsList().get(mainListProductIndex).setProductName(Requests.getEditProductRequestsList().get(i).getProductName());
                Lists.getProductsList().get(mainListProductIndex).setProductCompany(Requests.getEditProductRequestsList().get(i).getProductCompany());
                Lists.getProductsList().get(mainListProductIndex).setProductPrice(Requests.getEditProductRequestsList().get(i).getProductPrice());
                Lists.getProductsList().get(mainListProductIndex).setProductSellerName(Requests.getEditProductRequestsList().get(i).getProductSellerName());
                Lists.getProductsList().get(mainListProductIndex).setInventory(Requests.getEditProductRequestsList().get(i).getInventory());
                Lists.getProductsList().get(mainListProductIndex).setPreamble(Requests.getEditProductRequestsList().get(i).getPreamble());
                Requests.getEditProductRequestsList().remove(i);
                System.out.println("Accepted.");
            }
            else if (request.equals("ignore"))
            {
                Requests.getEditProductRequestsList().remove(i);
                System.out.println("Not Accepted.");
            }
        }
        Menu.adminLoginPanel();
    }
    public static void showCommentsRequests() throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("WELCOME TO THE COMMENTS REQUESTS PANEL");
        System.out.println("--------------------------------------");
        FileOutputStream fOut0 = new FileOutputStream("F:/ProjectF2/savedData/users/admin/commentsRequests.txt", true);
        ObjectOutputStream oOut0 = new ObjectOutputStream(fOut0);
        oOut0.writeObject(Requests.getCommentsRequestsList());
        System.out.println("The requests are: ");
        for (int i = 0; i < Requests.getCommentsRequestsList().size(); i++)
        {
            System.out.println(Requests.getCommentsRequestsList().get(i).toString());
            System.out.println("------------------------------------------------------------------");
            System.out.println("Enter {confirm} to edit the product");
            System.out.println("Enter {ignore} to do not edit the product");
            String request = sc1.next();
            if (request.equals("confirm"))
            {
                int mainProductIndex = 0;
                for (int j = 0; j < Lists.getProductsList().size(); j++)
                {
                    if (Requests.getCommentsRequestsList().get(i).getProduct().getProductID() == Lists.getProductsList().get(j).getProductID())
                        mainProductIndex = j;
                }
                Requests.getCommentsRequestsList().get(i).setCommentStatus("have confirmed");
                Lists.getProductsList().get(mainProductIndex).getCommentsList().add(Requests.getCommentsRequestsList().get(i));
                Requests.getCommentsRequestsList().remove(i);
                System.out.println("Accepted.");
            }
            else if (request.equals("ignore"))
            {
                Requests.getCommentsRequestsList().remove(i);
                System.out.println("Not Accepted.");
            }
        }
        Menu.adminLoginPanel();
    }
}
//---------------------------------------------------//
//---------------------PERSONS CLASSES-------------------//
class Account implements Serializable
{
    private String accountName;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

    //private int validity; //etebar: باید بره توی کلاس خریدار و فروشنده
    //private int buyOrSellHistory;//باید بره توی کلاسهای عین بالا
    //list factor kharid va foroosh

    //----------------constructor-------------------//

    public Account(String accountName, String name, String lastName, String email, String phoneNumber, String password)
    {
        this.setAccountName(accountName);
        this.setName(name);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setPassword(password);
    }

    //-------------setters and getters------------//

    public String getAccountName() {
        return accountName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //-------------to string------------//

    @Override
    public String toString() {
        return "{" +
                "accountName='" + accountName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
class Buyer extends Account
{
    ArrayList<Product> cart; //sabad kharid
    ArrayList<BuyBill> buyBillHistory;
    private String property;
    public static int last_buyer_id = 0;
    private final int buyerID;

    //----------------constructor-------------------//

    public Buyer(String accountName, String name, String lastName, String email, String phoneNumber, String password, String property) {
        super(accountName, name, lastName, email, phoneNumber, password);
        this.buyerID = ++last_buyer_id;
        cart = new ArrayList<Product>();
        buyBillHistory = new ArrayList<BuyBill>();
        this.setProperty(property);
    }

    //-------------setters and getters------------//

    public int getBuyerID() { return buyerID; }
    public String getProperty() { return property; }
    public ArrayList<BuyBill> getBuyBillHistory() { return buyBillHistory; }

    public void setProperty(String property) { this.property = property; }
    public void setBuyBillHistory(ArrayList<BuyBill> buyBillHistory) { this.buyBillHistory = buyBillHistory; }
    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "property=" + property +
                '}';
    }
}
class BuyerManager implements Serializable
{
    Menu menu = new Menu();
    private static BuyerManager buyerManager = null;
    public static BuyerManager getBuyerManager()
    {
        if (buyerManager == null)
            buyerManager = new BuyerManager();
        return buyerManager;
    }
    //------------------methods----------------------//
    void changeAccountInfo(int index, String name, String lastName, String email, String phoneNumber, String password, String property) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Lists.getCostumersList().get(index).setName(name);
        Lists.getCostumersList().get(index).setLastName(lastName);
        Lists.getCostumersList().get(index).setEmail(email);
        Lists.getCostumersList().get(index).setPhoneNumber(phoneNumber);
        Lists.getCostumersList().get(index).setPassword(password);
        Lists.getCostumersList().get(index).setProperty(property);
        menu.mainMenu();
    }
}
class Seller extends Account implements Serializable
{
    ArrayList<Product> productsList;
    ArrayList<SellBill> sellBillHistory;
    //etelaat company forooshande
    private String companyName;
    private String companyEstablishmentDate;
    private String companyPreamble; //tozihat sherkat
    private String property;
    public static int last_seller_id = 0;
    private final int sellerID;

    //----------------constructor-------------------//

    public Seller(String accountName, String name, String lastName, String email, String phoneNumber, String password, String companyName , String companyEstablishmentDate , String companyPreamble , String property)
    {
        super(accountName, name, lastName, email, phoneNumber, password);
        this.sellerID = ++last_seller_id;
        productsList = new ArrayList<Product>();
        sellBillHistory = new ArrayList<SellBill>();
        this.setCompanyName(companyName);
        this.setCompanyEstablishmentDate(companyEstablishmentDate);
        this.setCompanyPreamble(companyPreamble);
        this.setProperty(property);
    }

    //-------------setters and getters------------//

    public int getSellerID() { return sellerID; }
    public ArrayList<SellBill> getSellBillHistory() { return sellBillHistory; }
    public String getCompanyName() { return companyName; }
    public String getCompanyEstablishmentDate() { return companyEstablishmentDate; }
    public String getCompanyPreamble() { return companyPreamble; }
    public String getProperty() { return property; }

    public void setSellBillHistory(ArrayList<SellBill> sellBillHistory) { this.sellBillHistory = sellBillHistory; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public void setCompanyEstablishmentDate(String companyEstablishmentDate) { this.companyEstablishmentDate = companyEstablishmentDate; }
    public void setCompanyPreamble(String companyPreamble) { this.companyPreamble = companyPreamble; }
    public void setProperty(String property) { this.property = property; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "companyName='" + companyName + '\'' +
                ", companyEstablishmentDate='" + companyEstablishmentDate + '\'' +
                ", companyPreamble='" + companyPreamble + '\'' +
                ", property='" + property + '\'' +
                '}';
    }
}
class SellerManager implements Serializable
{
    Menu menu = new Menu();
    private static SellerManager sellerManager = null;
    public static SellerManager getSellerManager()
    {
        if (sellerManager == null)
            sellerManager = new SellerManager();
        return sellerManager;
    }
    //------------------methods----------------------//

    void changeAccountInfo(int index, String name, String lastName, String email, String phoneNumber, String password, String companyName , String companyEstablishmentDate , String companyPreamble , String property) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Lists.getSellersList().get(index).setName(name);
        Lists.getSellersList().get(index).setLastName(lastName);
        Lists.getSellersList().get(index).setEmail(email);
        Lists.getSellersList().get(index).setPhoneNumber(phoneNumber);
        Lists.getSellersList().get(index).setPassword(password);
        Lists.getSellersList().get(index).setCompanyName(companyName);
        Lists.getSellersList().get(index).setCompanyEstablishmentDate(companyEstablishmentDate);
        Lists.getSellersList().get(index).setCompanyPreamble(companyPreamble);
        Lists.getSellersList().get(index).setProperty(property);
        System.out.println("Your information has been changed successfully!");
        System.out.println("The information of your new seller account: ");
        System.out.println(Lists.getSellersList().get(index).toString());
        menu.mainMenu();
    }

    void editProducts(int productID, String productName , String productCompany ,
                      double productPrice , String productSellerName , boolean inventory , String preamble) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Product product = new Product(productName,productCompany,productPrice,productSellerName,inventory,preamble,0);
        Requests.getEditProductRequestsList().add(product);
        System.out.println("Your edit product request has been sent to admin successfully!");
        //Requests.getEditProductRequestsList().get(productIndex).setProductName(productName);
        //Requests.getEditProductRequestsList().get(productIndex).setProductCompany(productCompany);
        //Requests.getEditProductRequestsList().get(productIndex).setProductPrice(productPrice);
        //Requests.getEditProductRequestsList().get(productIndex).setProductSellerName(productSellerName);
        //Requests.getEditProductRequestsList().get(productIndex).setInventory(inventory);
        //Requests.getEditProductRequestsList().get(productIndex).setPreamble(preamble);
        menu.mainMenu();
    }

    void addLaptop(int index, String productName, String productCompany, double productPrice, String productSellerName, boolean inventory, String preamble,
                   int memoryCapacity, int RAMMemoryCapacity, String operatingSystem, double weight, double dimensions, String CPU, boolean isGaming) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Laptop laptop = new Laptop(productName,productCompany,productPrice,productSellerName,inventory,preamble
                ,0,memoryCapacity,RAMMemoryCapacity,operatingSystem,weight,dimensions,CPU,isGaming);
        Requests.getAddProductRequestsList().add(laptop);
        Requests.getAddLaptopRequestsList().add(laptop);

        System.out.println("Your add product request has been sent to admin successfully!");
        //Lists.getProductsList().add(laptop);
        //Lists.getLaptopList().add(laptop);
        SellerPanel.addLaptop(index);
    }
    void addMobilePhone(int index, String productName, String productCompany, double productPrice, String productSellerName, boolean inventory, String preamble,
                        int memoryCapacity, int RAMMemoryCapacity, String operatingSystem, double weight, double dimensions, int simCardNumber, int cameraQuality) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        MobilePhone mobilePhone = new MobilePhone(productName,productCompany,productPrice,productSellerName,inventory,preamble
                ,0,memoryCapacity,RAMMemoryCapacity,operatingSystem,weight,dimensions,simCardNumber,cameraQuality);
        Requests.getAddProductRequestsList().add(mobilePhone);
        Requests.getAddMobilePhoneRequestsList().add(mobilePhone);
        System.out.println("Your add product request has been sent to admin successfully!");
        SellerPanel.addMobilePhone(index);
    }
    void addClothes(int index, String productName, String productCompany, double productPrice, String productSellerName,
                    boolean inventory, String preamble, String producerCountry, String material, String size, String kind) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Clothes clothes = new Clothes(productName,productCompany,productPrice,productSellerName,
                inventory,preamble,0,producerCountry,material,size, Clothes.ClothesKind.valueOf(kind));
        Requests.getAddProductRequestsList().add(clothes);
        Requests.getAddClothesRequestsList().add(clothes);
        System.out.println("Your add product request has been sent to admin successfully!");
        SellerPanel.addClothes(index);
    }
    void addShoes(int index, String productName, String productCompany, double productPrice, String productSellerName,
                  boolean inventory, String preamble, String producerCountry, String material, String size, String kind) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Shoes shoes = new Shoes(productName,productCompany,productPrice,productSellerName,
                inventory,preamble,0,producerCountry,material,size, Shoes.ShoesKind.valueOf(kind));
        Requests.getAddProductRequestsList().add(shoes);
        Requests.getAddShoesRequestsList().add(shoes);
        System.out.println("Your add product request has been sent to admin successfully!");
        SellerPanel.addShoes(index);
    }
    void addTelevision(int index, String productName, String productCompany, double productPrice, String productSellerName, boolean inventory,
                       String preamble, String energyLabel, boolean warranty, String imageQuality, double screenSize) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Television television = new Television(productName,productCompany,productPrice,productSellerName,inventory,
                preamble,0,energyLabel,warranty,imageQuality,screenSize);
        Requests.getAddProductRequestsList().add(television);
        Requests.getAddTelevisionRequestsList().add(television);
        System.out.println("Your add product request has been sent to admin successfully!");
        SellerPanel.addTelevision(index);
    }
    void addRefrigerator(int index, String productName, String productCompany, double productPrice, String productSellerName, boolean inventory, String preamble,
                         String energyLabel, boolean warranty, double capacity, String kind, boolean haveFreezer) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Refrigerator refrigerator = new Refrigerator(productName,productCompany,productPrice
                ,productSellerName,inventory,preamble,0,energyLabel,warranty,capacity,kind,haveFreezer);
        Requests.getAddProductRequestsList().add(refrigerator);
        Requests.getAddRefrigeratorRequestsList().add(refrigerator);
        System.out.println("Your add product request has been sent to admin successfully!");
        SellerPanel.addRefrigerator(index);
    }
    void addStove(int index, String productName, String productCompany, double productPrice, String productSellerName, boolean inventory,
                  String preamble, String energyLabel, boolean warranty, int flameNumber, String kind, boolean haveOven) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        Stove stove = new Stove(productName,productCompany,productPrice,productSellerName,inventory,
                preamble,0,energyLabel,warranty,flameNumber,kind,haveOven);
        Requests.getAddProductRequestsList().add(stove);
        Requests.getAddStoveRequestsList().add(stove);
        System.out.println("Your add product request has been sent to admin successfully!");
        SellerPanel.addStove(index);
    }
    void addEatingProducts(int index, String productName, String productCompany, double productPrice, String productSellerName,
                           boolean inventory, String preamble, String productionDate, String expiryDate) throws FileNotFoundException , UnsupportedEncodingException, IOException
    {
        EatingProducts eatingProduct = new EatingProducts(productName,productCompany,productPrice
                ,productSellerName, inventory,preamble,0,productionDate,expiryDate);
        Requests.getAddProductRequestsList().add(eatingProduct);
        Requests.getAddEatingProductRequestsList().add(eatingProduct);
        System.out.println("Your add product request has been sent to admin successfully!");
        SellerPanel.addEatingProducts(index);
    }
}
class Admin extends Account implements Serializable
{
    private static Admin admin = null;

    //----------------constructor-------------------//

    private Admin()
    {
        super("admin", "farnaz", "movahedi", "farnazmovahedi97@gmail.com", "0990...", "admin");
    }
    public static Admin getAdmin() {
        if (admin == null)
            admin = new Admin();
        return admin;
    }
    //------------------methods----------------------//
    //ALL OF THE METHODS ARE IN MENU!
}
//--------------------------------------------//
class BuyBill implements Serializable
{
    private static int lastBuyBillID = 0;
    private int billID;
    private Date date;
    private double paidAmount;
    private ArrayList<Product> boughtProductsList;
    private boolean deliveryStatus;

    //----------------constructor-------------------//

    public BuyBill(Date date, double paidAmount, ArrayList<Product> boughtProductsList,boolean deliveryStatus)
    {
        this.setBillID();
        this.setDate(date);
        this.setPaidAmount(paidAmount);
        this.setBoughtProductsList(boughtProductsList);
        this.setDeliveryStatus(deliveryStatus);
    }

    //-------------setters and getters-----------//

    public int getBillID() {
        return billID;
    }
    public Date getDate() {
        return date;
    }
    public double getPaidAmount() {
        return paidAmount;
    }
    public ArrayList<Product> getBoughtProductsList() { return boughtProductsList; }
    public boolean getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setBillID() { this.billID = lastBuyBillID++; }
    public void setDate(Date date) { this.date = date; }
    public void setPaidAmount(double paidAmount) { this.paidAmount = paidAmount; }
    public void setBoughtProductsList(ArrayList<Product> boughtProductsList) { this.boughtProductsList = boughtProductsList; }
    public void setDeliveryStatus(boolean deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    //-------------to string-----------//

    @Override
    public String toString() {
        return "BuyBill{" +
                "billID=" + billID +
                ", date='" + date + '\'' +
                ", paidAmount=" + paidAmount +
                ", boughtProductsList=" + boughtProductsList +
                ", deliveryStatus=" + deliveryStatus +
                '}';
    }
}
class SellBill implements Serializable
{
    private static int lastSellBill = 0;
    private int billID;
    private Date date;
    private double receivedAmount;
    private ArrayList<Product> soldProductsList;
    private String buyerName;
    private boolean deliveryStatus;

    //----------------constructor-------------------//

    public SellBill(Date date, double receivedAmount,ArrayList<Product> soldProductsList , String buyerName, boolean deliveryStatus) {
        this.setBillID();
        this.setDate(date);
        this.setReceivedAmount(receivedAmount);
        this.setSoldProductsList(soldProductsList);
        this.setBuyerName(buyerName);
        this.setDeliveryStatus(deliveryStatus);
    }

    //-------------getter and setter----------------//

    public int getBillID() { return billID; }
    public Date getDate() { return date; }
    public double getReceivedAmount() { return receivedAmount; }
    public ArrayList<Product> getSoldProductsList() { return soldProductsList; }
    public String getBuyerName() { return buyerName; }
    public boolean getDeliveryStatus() { return deliveryStatus; }

    public void setBillID() { this.billID = lastSellBill++; }
    public void setDate(Date date) { this.date = date; }
    public void setReceivedAmount(double receivedAmount) { this.receivedAmount = receivedAmount; }
    public void setSoldProductsList(ArrayList<Product> soldProductsList) { this.soldProductsList = soldProductsList; }
    public void setBuyerName(String buyerName) { this.buyerName = buyerName; }
    public void setDeliveryStatus(boolean deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    //-------------to string-----------//

    @Override
    public String toString() {
        return "SellBill{" +
                "billID=" + billID +
                ", date='" + date + '\'' +
                ", receivedAmount=" + receivedAmount +
                ", soldProductsList=" + soldProductsList +
                ", buyerName='" + buyerName + '\'' +
                ", deliveryStatus=" + deliveryStatus +
                '}';
    }
}
class Category
{
    //ALL OF THE CATEGORIES ARE IN LISTS!
}
class Product implements Comparable
{
    public static int last_product_id = 0;
    private final int productID;
    private String productName;
    private String productCompany;
    private double productPrice;
    private String productSellerName;
    private boolean inventory;
    private String preamble; //tozihat
    private double buyersAverageScore;
    private ArrayList<Comment> commentsList = null;

    //----------------constructor-------------------//

    public Product(String productName, String productCompany, double productPrice, String productSellerName, boolean inventory, String preamble, double buyersAverageScore)
    {
        this.productID = ++last_product_id;
        this.setProductName(productName);
        this.setProductCompany(productCompany);
        this.setProductPrice(productPrice);
        this.setProductSellerName(productSellerName);
        this.setInventory(inventory);
        this.setPreamble(preamble);
        this.setBuyersAverageScore(buyersAverageScore);
        commentsList = new ArrayList<Comment>();
    }

    //-------------discount-----------------//
    public double getPriceByDiscount(DiscountStrategy discountStrategy)
    {
        return discountStrategy.priceByDiscount(this);
    }

    // ----------------compare to method-----------//
    public int compareTo(Object product)
    {
        Product product2 = (Product) product;

        if((this instanceof DigitalProducts) && (product2 instanceof DigitalProducts))
        {
            if (((this instanceof Laptop) && (product2 instanceof Laptop)) || ((this instanceof MobilePhone) && (product2 instanceof MobilePhone)))
            {
                if (this.productName.compareTo(product2.productName) < 0)
                {
                    return 1;
                }
                else if (this.productName.compareTo(product2.productName) == 0)
                {
                    if (((DigitalProducts) this).getRAMMemoryCapacity() > ((DigitalProducts) product2).getRAMMemoryCapacity())
                    {
                        return 1;
                    }
                    else if (((DigitalProducts) this).getRAMMemoryCapacity() == ((DigitalProducts) product2).getRAMMemoryCapacity())
                    {
                        if (this.buyersAverageScore > product2.buyersAverageScore)
                            return 1;
                        else if (this.buyersAverageScore == product2.buyersAverageScore)
                        {
                            if (this.productPrice < product2.productPrice)
                                return 1;
                            else if (this.productPrice == product2.productPrice)
                            {
                                if (this.inventory && !product2.inventory)
                                    return 1;
                                else
                                    return -1;
                            }
                            else
                                return -1;
                        }
                        else
                            return -1;
                    }
                    else
                    {
                        return -1;
                    }

                }
                else
                    return -1;
            }
            else if ((this instanceof Laptop) && (product2 instanceof MobilePhone))
            {
                return 1;
            }
            else if ((this instanceof MobilePhone) && (product2 instanceof Laptop))
            {
                return -1;
            }
        }
        else if ((this instanceof DigitalProducts) && (product2 instanceof WearingProducts))
        {
            return 1;
        }
        else if ((this instanceof DigitalProducts) && (product2 instanceof DomesticProducts))
        {
            return 1;
        }
        else if ((this instanceof DigitalProducts) && (product2 instanceof EatingProducts))
        {
            return 1;
        }


        else if ((this instanceof WearingProducts) && (product2 instanceof WearingProducts))
        {
            if (((this instanceof Clothes) && (product2 instanceof Clothes)) || (this instanceof Shoes) && (product2 instanceof Shoes))
            {
                if (this.productName.compareTo(product2.productName) < 0)
                    return 1;
                else if (this.productName.compareTo(product2.productName) == 0)
                {
                    if (((WearingProducts) this).getMaterial().compareTo(((WearingProducts) product2).getMaterial()) < 0)
                    {
                        return 1;
                    }
                    else if (((WearingProducts) this).getMaterial().compareTo(((WearingProducts) product2).getMaterial()) == 0)
                    {
                        if (this.buyersAverageScore < product2.buyersAverageScore)
                            return 1;
                        else if (this.buyersAverageScore == product2.buyersAverageScore)
                        {
                            if (this.productPrice < product2.productPrice)
                                return 1;
                            else if (this.productPrice == product2.productPrice)
                            {
                                if (this.inventory && !product2.inventory)
                                    return 1;
                                else
                                    return -1;
                            }
                            else
                                return -1;
                        }
                        else
                            return -1;
                    }
                    else
                    {
                        return -1;
                    }

                }
                else
                    return -1;
            }
            else if ((this instanceof Clothes) && (product2 instanceof Shoes))
            {
                return 1;
            }
            else if ((this instanceof Shoes) && (product2 instanceof Clothes))
            {
                return -1;
            }
        }
        else if ((this instanceof WearingProducts) && (product2 instanceof DigitalProducts))
        {
            return -1;
        }
        else if ((this instanceof WearingProducts) && (product2 instanceof DomesticProducts))
        {
            return 1;
        }
        else if ((this instanceof WearingProducts) && (product2 instanceof EatingProducts))
        {
            return 1;
        }

        else if ((this instanceof DomesticProducts) && (product2 instanceof DomesticProducts))
        {
            if (((this instanceof Television) && (product2 instanceof Television)) || (this instanceof Refrigerator) && (product2 instanceof Refrigerator) || (this instanceof Stove) && (product2 instanceof Stove))
            {
                if (this.productName.compareTo(product2.productName) > 0)
                    return 1;
                else if (this.productName.compareTo(product2.productName) == 0)
                {
                    if (((DomesticProducts) this).getEnergyLabel().compareTo(((DomesticProducts) product2).getEnergyLabel()) < 0)
                    {
                        return 1;
                    }
                    if (((DomesticProducts) this).getEnergyLabel().compareTo(((DomesticProducts) product2).getEnergyLabel()) == 0)
                    {
                        if (this.buyersAverageScore < product2.buyersAverageScore)
                            return 1;
                        else if (this.buyersAverageScore == product2.buyersAverageScore)
                        {
                            if (this.productPrice < product2.productPrice)
                                return 1;
                            else if (this.productPrice == product2.productPrice)
                            {
                                if (this.inventory && !product2.inventory)
                                    return 1;
                                else
                                    return -1;
                            }
                            else
                                return -1;
                        }
                        else
                            return -1;
                    }
                    else
                    {
                        return -1;
                    }
                }
                else
                    return -1;
            }
            else if ((this instanceof Television) && (product2 instanceof Refrigerator))
            {
                return 1;
            }
            else if ((this instanceof Television) && (product2 instanceof Stove))
            {
                return 1;
            }

            else if ((this instanceof Refrigerator) && (product2 instanceof Television))
            {
                return -1;
            }
            else if ((this instanceof Refrigerator) && (product2 instanceof Stove))
            {
                return 1;
            }

            else if ((this instanceof Stove) && (product2 instanceof Television))
            {
                return -1;
            }
            else if ((this instanceof Stove) && (product2 instanceof Refrigerator))
            {
                return -1;
            }
        }
        else if ((this instanceof DomesticProducts) && (product2 instanceof DigitalProducts))
        {
            return -1;
        }
        else if ((this instanceof DomesticProducts) && (product2 instanceof WearingProducts))
        {
            return -1;
        }
        else if ((this instanceof DomesticProducts) && (product2 instanceof EatingProducts))
        {
            return 1;
        }


        else if ((this instanceof EatingProducts) && (product2 instanceof EatingProducts))
        {
            if (this.productName.compareTo(product2.productName) > 0)
                return 1;
            else if (this.productName.compareTo(product2.productName) == 0)
            {
                if (((EatingProducts) this).getExpiryDate().compareTo(((EatingProducts) product2).getExpiryDate()) < 0)
                {
                    return 1;
                }
                if (((EatingProducts) this).getExpiryDate().compareTo(((EatingProducts) product2).getExpiryDate()) == 0)
                {
                    if (this.buyersAverageScore < product2.buyersAverageScore)
                        return 1;
                    else if (this.buyersAverageScore == product2.buyersAverageScore)
                    {
                        if (this.productPrice < product2.productPrice)
                            return 1;
                        else if (this.productPrice == product2.productPrice)
                        {
                            if (this.inventory && !product2.inventory)
                                return 1;
                            else
                                return -1;
                        }
                        else
                            return -1;
                    }
                    else
                        return -1;
                }
                else
                    return -1;
            }
            else
                return -1;
        }
        else if ((this instanceof EatingProducts) && (product2 instanceof DigitalProducts))
        {
            return -1;
        }
        else if ((this instanceof EatingProducts) && (product2 instanceof WearingProducts))
        {
            return -1;
        }
        else if ((this instanceof EatingProducts) && (product2 instanceof DomesticProducts))
        {
            return -1;
        }
        return 1000;
    }
    // ----------------getter and setter-----------//

    public int getProductID() { return productID; }
    public String getProductName() { return productName; }
    public String getProductCompany() { return productCompany; }
    public double getProductPrice() { return productPrice; }
    public String getProductSellerName() { return productSellerName; }
    public boolean getInventory() { return inventory; }
    public String getPreamble() { return preamble; }
    public double getBuyersAverageScore() { return buyersAverageScore; }
    public ArrayList<Comment> getCommentsList() { return commentsList; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setProductCompany(String productCompany) { this.productCompany = productCompany; }
    public void setProductPrice(double productPrice) { this.productPrice = productPrice; }
    public void setProductSellerName(String productSellerName) { this.productSellerName = productSellerName; }
    public void setInventory(boolean inventory) { this.inventory = inventory; }
    public void setPreamble(String preamble) { this.preamble = preamble; }
    public void setBuyersAverageScore(double buyersAverageScore) { this.buyersAverageScore = buyersAverageScore; }
    public void setCommentsList(ArrayList<Comment> commentsList) { this.commentsList = commentsList; }

    //-------------to string------------//

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productCompany='" + productCompany + '\'' +
                ", productPrice=" + productPrice +
                ", productSellerName='" + productSellerName + '\'' +
                ", inventory=" + inventory +
                ", preamble='" + preamble + '\'' +
                ", buyersAverageScore=" + buyersAverageScore +
                ", commentsList=" + commentsList +
                '}';
    }
}
class DigitalProducts extends Product implements Serializable
{
    private int memoryCapacity;
    private int RAMMemoryCapacity;
    private String operatingSystem;
    private double weight;
    private double dimensions;

    //----------------constructor-------------------//

    public DigitalProducts(String productName, String productCompany, double productPrice, String productSellerName, boolean inventory,
                           String preamble, double buyersAverageScore, int memoryCapacity, int RAMMemoryCapacity, String operatingSystem, double weight, double dimensions)
    {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore);
        this.setMemoryCapacity(memoryCapacity);
        this.setRAMMemoryCapacity(RAMMemoryCapacity);
        this.setOperatingSystem(operatingSystem);
        this.setWeight(weight);
        this.setDimensions(dimensions);
    }


    //---------------getters and setters--------------//

    public int getMemoryCapacity() { return memoryCapacity; }
    public int getRAMMemoryCapacity() { return RAMMemoryCapacity; }
    public String getOperatingSystem() { return operatingSystem; }
    public double getWeight() { return weight; }
    public double getDimensions() { return dimensions; }

    public void setMemoryCapacity(int memoryCapacity) { this.memoryCapacity = memoryCapacity; }
    public void setRAMMemoryCapacity(int RAMMemoryCapacity) { this.RAMMemoryCapacity = RAMMemoryCapacity; }
    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setDimensions(double dimensions) { this.dimensions = dimensions; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "memoryCapacity=" + memoryCapacity +
                ", RAMMemoryCapacity=" + RAMMemoryCapacity +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", weight=" + weight +
                ", dimensions=" + dimensions +
                '}';
    }
}
class WearingProducts extends Product implements Serializable
{
    private String producerCountry;
    private String material;

    //----------------constructor-------------------//

    public WearingProducts(String productName, String productCompany, double productPrice, String productSellerName, boolean inventory, String preamble,
                           double buyersAverageScore, String producerCountry, String material) {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore);
        this.setProducerCountry(producerCountry);
        this.setMaterial(material);
    }

    //---------------getters and setters-------------//

    public String getProducerCountry() { return producerCountry; }
    public String getMaterial() { return material; }

    public void setProducerCountry(String producerCountry) { this.producerCountry = producerCountry; }
    public void setMaterial(String material) { this.material = material; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "producerCountry='" + producerCountry + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
class DomesticProducts extends Product implements Serializable
{
    private String energyLabel;
    private boolean warranty;

    //----------------constructor-------------------//

    public DomesticProducts(String productName, String productCompany, double productPrice, String productSellerName, boolean inventory,
                            String preamble, double buyersAverageScore, String energyLabel, boolean warranty)
    {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore);
        this.setEnergyLabel(energyLabel);
        this.setWarranty(warranty);
    }

    //---------------getters and setters-------------//

    public String getEnergyLabel() { return energyLabel; }
    public boolean isWarranty() { return warranty; }

    public void setEnergyLabel(String energyLabel) { this.energyLabel = energyLabel; }
    public void setWarranty(boolean warranty) { this.warranty = warranty; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "energyLabel='" + energyLabel + '\'' +
                ", warranty=" + warranty +
                '}';
    }
}
class EatingProducts extends Product implements Serializable
{
    private String productionDate;
    private String expiryDate;

    //----------------constructor-------------------//

    public EatingProducts(String productName, String productCompany, double productPrice, String productSellerName,
                          boolean inventory, String preamble, double buyersAverageScore, String productionDate, String expiryDate)
    {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore);
        this.setProductionDate(productionDate);
        this.setExpiryDate(expiryDate);
    }

    //---------------getters and setters-------------//

    public String getProductionDate() { return productionDate; }
    public String getExpiryDate() { return expiryDate; }

    public void setProductionDate(String productionDate) { this.productionDate = productionDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "productionDate='" + productionDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
}
class MobilePhone extends DigitalProducts implements Serializable
{
    private int simCardNumber;
    private int cameraQuality;

    //----------------constructor-------------------//

    public MobilePhone(String productName, String productCompany, double productPrice, String productSellerName, boolean inventory, String preamble, double buyersAverageScore,
                       int memoryCapacity, int RAMMemoryCapacity, String operatingSystem, double weight, double dimensions, int simCardNumber, int cameraQuality)
    {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore, memoryCapacity, RAMMemoryCapacity, operatingSystem, weight, dimensions);
        this.setSimCardNumber(simCardNumber);
        this.setCameraQuality(cameraQuality);
    }

    //---------------getters and setters-------------//

    public int getSimCardNumber() { return simCardNumber; }
    public int getCameraQuality() { return cameraQuality; }

    public void setSimCardNumber(int simCardNumber) { this.simCardNumber = simCardNumber; }
    public void setCameraQuality(int cameraQuality) { this.cameraQuality = cameraQuality; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "simCardNumber=" + simCardNumber +
                ", cameraQuality=" + cameraQuality +
                '}';
    }
}
class Laptop extends DigitalProducts implements Serializable
{
    private String CPU;
    private boolean isGaming;

    //----------------constructor-------------------//

    public Laptop(String productName, String productCompany, double productPrice, String productSellerName, boolean inventory,
                  String preamble, double buyersAverageScore, int memoryCapacity, int RAMMemoryCapacity, String operatingSystem, double weight, double dimensions, String CPU, boolean isGaming)
    {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore, memoryCapacity, RAMMemoryCapacity, operatingSystem, weight, dimensions);
        this.setCPU(CPU);
        this.setGaming(isGaming);
    }

    //---------------getters and setters-------------//

    public String getCPU() { return CPU; }
    public boolean isGaming() { return isGaming; }

    public void setCPU(String CPU) { this.CPU = CPU; }
    public void setGaming(boolean gaming) { isGaming = gaming; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "CPU='" + CPU + '\'' +
                ", isGaming=" + isGaming +
                '}';
    }
}
class Clothes extends WearingProducts implements Serializable
{
    private String size;
    enum ClothesKind
    {
        T_SHIRT , PANTS , DRESS , HAT , GLOVES;
    }
    private ClothesKind kind;

    //----------------constructor-------------------//

    public Clothes(String productName, String productCompany, double productPrice, String productSellerName,
                   boolean inventory, String preamble, double buyersAverageScore, String producerCountry, String material, String size, ClothesKind kind)
    {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore, producerCountry, material);
        this.setSize(size);
        this.setKind(kind);
    }

    //---------------getters and setters-------------//

    public String getSize() { return size; }
    public ClothesKind getKind() { return kind; }

    public void setSize(String size) { this.size = size; }
    public void setKind(ClothesKind kind) { this.kind = kind; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "size='" + size + '\'' +
                ", kind=" + kind +
                '}';
    }
}
class Shoes extends WearingProducts implements Serializable
{
    private String size;
    enum ShoesKind
    {
        BOOTS , SNEAKERS , FLAT , HIGH_HEELED , SANDALS;
    }
    private ShoesKind kind;

    //----------------constructor-------------------//

    public Shoes(String productName, String productCompany, double productPrice, String productSellerName,
                 boolean inventory, String preamble, double buyersAverageScore, String producerCountry, String material, String size, ShoesKind kind)
    {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore, producerCountry, material);
        this.setSize(size);
        this.setKind(kind);
    }

    //---------------getters and setters-------------//

    public String getSize() { return size; }
    public ShoesKind getKind() { return kind; }

    public void setSize(String size) { this.size = size; }
    public void setKind(ShoesKind kind) { this.kind = kind; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "size='" + size + '\'' +
                ", kind=" + kind +
                '}';
    }
}
class Television extends DomesticProducts implements Serializable
{
    private String imageQuality;
    private double screenSize;

    //----------------constructor-------------------//

    public Television(String productName, String productCompany, double productPrice, String productSellerName, boolean inventory,
                      String preamble, double buyersAverageScore, String energyLabel, boolean warranty, String imageQuality, double screenSize)
    {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore, energyLabel, warranty);
        this.setImageQuality(imageQuality);
        this.setScreenSize(screenSize);
    }

    //---------------getters and setters-------------//

    public String getImageQuality() { return imageQuality; }
    public double getScreenSize() { return screenSize; }

    public void setImageQuality(String imageQuality) { this.imageQuality = imageQuality; }
    public void setScreenSize(double screenSize) { this.screenSize = screenSize; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "imageQuality='" + imageQuality + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}
class Refrigerator extends DomesticProducts implements Serializable
{
    private double capacity;
    private String kind;
    private boolean haveFreezer;

    //----------------constructor-------------------//

    public Refrigerator(String productName, String productCompany, double productPrice, String productSellerName, boolean inventory, String preamble,
                        double buyersAverageScore, String energyLabel, boolean warranty, double capacity, String kind, boolean haveFreezer)
    {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore, energyLabel, warranty);
        this.setCapacity(capacity);
        this.setKind(kind);
        this.setHaveFreezer(haveFreezer);
    }

    //---------------getters and setters-------------//

    public double getCapacity() { return capacity; }
    public String getKind() { return kind; }
    public boolean isHaveFreezer() { return haveFreezer; }

    public void setCapacity(double capacity) { this.capacity = capacity; }
    public void setKind(String kind) { this.kind = kind; }
    public void setHaveFreezer(boolean haveFreezer) { this.haveFreezer = haveFreezer; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "capacity=" + capacity +
                ", kind='" + kind + '\'' +
                ", haveFreezer=" + haveFreezer +
                '}';
    }
}
class Stove extends DomesticProducts implements Serializable
{
    private int flameNumber;
    private String kind;
    private boolean haveOven;

    //----------------constructor-------------------//

    public Stove(String productName, String productCompany, double productPrice, String productSellerName, boolean inventory,
                 String preamble, double buyersAverageScore, String energyLabel, boolean warranty, int flameNumber, String kind, boolean haveOven)
    {
        super(productName, productCompany, productPrice, productSellerName, inventory, preamble, buyersAverageScore, energyLabel, warranty);
        this.setFlameNumber(flameNumber);
        this.setKind(kind);
        this.setHaveOven(haveOven);
    }

    //---------------getters and setters-------------//

    public int getFlameNumber() { return flameNumber; }
    public String getKind() { return kind; }
    public boolean isHaveOven() { return haveOven; }

    public void setFlameNumber(int flameNumber) { this.flameNumber = flameNumber; }
    public void setKind(String kind) { this.kind = kind; }
    public void setHaveOven(boolean haveOven) { this.haveOven = haveOven; }

    //-------------to string------------//

    @Override
    public String toString() {
        return super.toString() + "{" +
                "flameNumber=" + flameNumber +
                ", kind='" + kind + '\'' +
                ", haveOven=" + haveOven +
                '}';
    }
}
class Comment implements Serializable
{
    private int didCommentedCostumerIndex;// index kharidar nazar dahande
    private Product product;
    private String comment;
    private String commentStatus;
    private boolean didBuyProduct;

    //----------------constructor-------------------//

    public Comment(int didCommentedCostumerIndex, Product product, String comment, String commentStatus, boolean didBuyProduct)
    {
        setDidCommentedCostumer(didCommentedCostumerIndex);
        setProduct(product);
        setComment(comment);
        setCommentStatus(commentStatus);
        setDidBuyProduct(didBuyProduct);
    }

    //---------------getters and setters-------------//

    public int getDidCommentedCostumer() { return didCommentedCostumerIndex; }
    public Product getProduct() { return product; }
    public String getComment() { return comment; }
    public String getCommentStatus() { return commentStatus; }
    public boolean isDidBuyProduct() { return didBuyProduct; }

    public void setDidCommentedCostumer(int didCommentedCostumer) { this.didCommentedCostumerIndex = didCommentedCostumer; }
    public void setProduct(Product product) { this.product = product; }
    public void setComment(String comment) { this.comment = comment; }
    public void setCommentStatus(String commentStatus) { this.commentStatus = commentStatus; }
    public void setDidBuyProduct(boolean didBuyProduct) { this.didBuyProduct = didBuyProduct; }

    //-------------to string------------//

    @Override
    public String toString() {
        return "Comment{" +
                ", product=" + product +
                ", comment='" + comment + '\'' +
                ", commentStatus='" + commentStatus + '\'' +
                ", didBuyProduct=" + didBuyProduct +
                '}';
    }
}
class Score
{
    //kharidari ke mahsool ro kharide
    enum Point
    {
        YEK , DO , SE , CHAHAR , PANJ
    }
    private Point point;
    private Product product;

    //---------------getters and setters-------------//

    public Point getPoint() { return point; }
    public Object getProduct() { return product; }

    public void setPoint(Point point) { this.point = point; }
    public void setProduct(Product product) { this.product = product; }
}
interface DiscountStrategy
{
    double priceByDiscount(Product product);
}
class Discount
{
    static String digitalDiscountCode = "gidiatl";
    static String wearingDiscountCode = "aewinrg";
    static String domesticDiscountCode = "iomsetdc";
    static String eatingDiscountCode = "egtien";
}
class DigitalDiscountStrategy implements DiscountStrategy
{
    public double priceByDiscount(Product product)
    {
        double price = 0;
        price = product.getProductPrice() - (product.getProductPrice() * 0.4);
        return price;
    }
}
class WearingDiscountStrategy implements DiscountStrategy
{
    public double priceByDiscount(Product product)
    {
        double price = 0;
        price = product.getProductPrice() - (product.getProductPrice() * 0.2);
        return price;
    }
}
class DomesticDiscountStrategy implements DiscountStrategy
{
    public double priceByDiscount(Product product)
    {
        double price = 0;
        price = product.getProductPrice() - (product.getProductPrice() * 0.3);
        return price;
    }
}
class EatingDiscountStrategy implements DiscountStrategy
{
    public double priceByDiscount(Product product)
    {
        double price = 0;
        price = product.getProductPrice() - (product.getProductPrice() * 0.1);
        return price;
    }
}
class Files implements Serializable
{
    public static void createFiles() throws IOException , FileNotFoundException
    {
        //-------------------father file--------------------//
        File savedData = new File("savedData");
        if (!(savedData.exists()))
            savedData.mkdirs();

        //-----------------first child and his children---------------//
        File users = new File(savedData , "users");
        if (!(users.exists()))
            users.mkdirs();
        File admin = new File(users , "admin");
        if (!(admin.exists()))
            admin.mkdirs();
        File costumers = new File(users, "costumers");
        if (!(costumers.exists()))
            costumers.mkdirs();
        File sellers = new File(users , "sellers");
        if (!(sellers.exists()))
            sellers.mkdirs();

        //-----------------admin information---------------//
        File fOut = new File(admin , "information.txt");
        fOut.createNewFile();
        Formatter f = new Formatter(fOut);
        f.format("%s %s %s %s %s %s" , Admin.getAdmin().getAccountName() , Admin.getAdmin().getName() , Admin.getAdmin().getLastName() , Admin.getAdmin().getEmail()
                , Admin.getAdmin().getPhoneNumber() , Admin.getAdmin().getPassword());
        f.flush();
        f.close();

        //----------------second child and his children--------------//
        File categories = new File(savedData , "categories");
        if (!(categories.exists()))
            categories.mkdirs();
        File digitalProducts = new File(categories , "digitalProducts");
        if (!(digitalProducts.exists()))
            digitalProducts.mkdirs();
        File wearingProducts = new File(categories , "wearingProducts");
        if (!(wearingProducts.exists()))
            wearingProducts.mkdirs();
        File domesticProducts = new File(categories , "domesticProducts");
        if (!(domesticProducts.exists()))
            domesticProducts.mkdirs();
        File eatingProducts = new File(categories , "eatingProducts");
        if (!(eatingProducts.exists()))
            eatingProducts.mkdirs();

        //----------------the children of the 1th child of the second child of the father--------------//
        File laptops = new File(digitalProducts , "laptops");
        if (!(laptops.exists()))
            laptops.mkdirs();
        File mobilePhones = new File(digitalProducts , "mobilePhones");
        if (!(mobilePhones.exists()))
            mobilePhones.mkdirs();

        //----------------the children of the 2th child of the second child of the father--------------//
        File clothes = new File(wearingProducts , "clothes");
        if (!(clothes.exists()))
            clothes.mkdirs();
        File shoes = new File(wearingProducts , "shoes");
        if (!(shoes.exists()))
            shoes.mkdirs();

        //----------------the children of the 3th child of the second child of the father--------------//
        File televisions = new File(domesticProducts , "televisions");
        if (!(televisions.exists()))
            televisions.mkdirs();
        File refrigerators = new File(domesticProducts , "refrigerator");
        if (!(refrigerators.exists()))
            refrigerators.mkdirs();
        File stoves = new File(domesticProducts , "stoves");
        if (!(stoves.exists()))
            stoves.mkdirs();

        //-------------------------create txt files-----------------------------//
        File laptopSpecialInfo = new File(laptops , "laptopSpecialInfo.txt");
        laptopSpecialInfo.createNewFile();
        Formatter l = new Formatter(laptopSpecialInfo);
        l.format("%s" , "laptops special information:");
        l.flush();
        l.close();

        File mobilePhoneSpecialInfo = new File(mobilePhones , "mobilePhoneSpecialInfo.txt");
        mobilePhoneSpecialInfo.createNewFile();
        Formatter m = new Formatter(mobilePhoneSpecialInfo);
        m.format("%s" , "mobile phones special information:");
        m.flush();
        m.close();

        File clothesSpecialInfo = new File(clothes , "clothesSpecialInfo.txt");
        clothesSpecialInfo.createNewFile();
        Formatter c = new Formatter(clothesSpecialInfo);
        c.format("%s" , "clothes special information:");
        c.flush();
        c.close();

        File shoesSpecialInfo = new File(shoes , "shoesSpecialInfo.txt");
        shoesSpecialInfo.createNewFile();
        Formatter s = new Formatter(shoesSpecialInfo);
        s.format("%s" , "shoes special information:");
        s.flush();
        s.close();

        File televisionSpecialInfo = new File(televisions , "televisionSpecialInfo.txt");
        televisionSpecialInfo.createNewFile();
        Formatter t = new Formatter(televisionSpecialInfo);
        t.format("%s" , "televisions special information:");
        t.flush();
        t.close();

        File refrigeratorSpecialInfo = new File(refrigerators , "refrigeratorSpecialInfo.txt");
        refrigeratorSpecialInfo.createNewFile();
        Formatter r = new Formatter(refrigeratorSpecialInfo);
        r.format("%s" , "refrigerators special information:");
        r.flush();
        r.close();

        File stoveSpecialInfo = new File(stoves , "stoveSpecialInfo.txt");
        stoveSpecialInfo.createNewFile();
        Formatter st = new Formatter(stoveSpecialInfo);
        st.format("%s" , "stoves special information:");
        st.flush();
        st.close();

        File eatingProductSpecialInfo = new File(eatingProducts , "eatingProductSpecialInfo.txt");
        eatingProductSpecialInfo.createNewFile();
        Formatter e = new Formatter(eatingProductSpecialInfo);
        e.format("%s" , "eating Products special information:");
        e.flush();
        e.close();

        //-------------------------create folder files for lists of the products-----------------------------//
        File laptopsList = new File(laptops , "laptopsList");
        if (!(laptopsList.exists()))
            laptopsList.mkdirs();

        File mobilePhonesList = new File(mobilePhones , "mobilePhonesList");
        if (!(mobilePhonesList.exists()))
            mobilePhonesList.mkdirs();

        File clothesList = new File(clothes , "clothesList");
        if (!(clothesList.exists()))
            clothesList.mkdirs();

        File shoesList = new File(shoes , "shoesList");
        if (!(shoesList.exists()))
            shoesList.mkdirs();

        File televisionsList = new File(televisions , "televisionsList");
        if (!(televisionsList.exists()))
            televisionsList.mkdirs();

        File refrigeratorsList = new File(refrigerators , "refrigeratorsList");
        if (!(refrigeratorsList.exists()))
            refrigeratorsList.mkdirs();

        File stovesList = new File(stoves , "stovesList");
        if (!(stovesList.exists()))
            stovesList.mkdirs();

        File eatingProductsList = new File(eatingProducts , "eatingProductsList");
        if (!(eatingProductsList.exists()))
            eatingProductsList.mkdirs();
    }
}