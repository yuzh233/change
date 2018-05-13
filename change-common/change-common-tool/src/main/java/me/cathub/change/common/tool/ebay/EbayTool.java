//package me.cathub.change.common.tool.ebay;
//
//import com.ebay.sdk.ApiContext;
//import com.ebay.sdk.ApiCredential;
//import com.ebay.sdk.call.AddItemCall;
//import com.ebay.sdk.util.eBayUtil;
//import com.ebay.soap.eBLBaseComponents.*;
//
//import java.io.IOException;
//
//public class EbayTool {
//    /**
//     * 返回
//     * @return ApiContext 对象
//     * @throws IOException
//     */
//    private static ApiContext getApiContext() throws Exception {
//        ApiContext apiContext = new ApiContext();
//
//        // 设置API Token 访问 eBay API服务器
//        ApiCredential cred = apiContext.getApiCredential();
//        cred.seteBayToken(Constant.EBAY_TOKEN);
//
//        // 设置API服务器URL
//        apiContext.setApiServerUrl("https://api.sandbox.ebay.com/wsapi");
//
//        // 设置EPS图片服务器URL
//        apiContext.setEpsServerUrl("https://api.sandbox.ebay.com/ws/api.dll");
//
//        return apiContext;
//    }
//
//    /**
//     *  构建ItemType类
//     * @return ItemType  对象
//     * @throws IOException
//     */
//    private static ItemType builItem() throws IOException {
//        String input;
//        ItemType item = new ItemType();
//
//        // 项目标题
//        item.setTitle("change_product_test_2");
//
//        // 画廊图片
//        String[] paths = {"http://www.dilianidc.com/templets/twang/images/tw_11.jpg","http://www.dilianidc.com/templets/twang/images/tw_20.jpg"};
//        PictureDetailsType pic = new PictureDetailsType();
//        pic.setPictureURL(paths);
//        //指定画廊图片
//        pic.setGalleryType(GalleryTypeCodeType.GALLERY);
//        item.setPictureDetails(pic);
//
//        // 项目SKU
//        item.setSKU("10");
//
//        // 项目描述
//        item.setDescription("info");
//
//        // 类型
//        item.setListingType(ListingTypeCodeType.CHINESE);
//
//        // 货币
//        item.setCurrency(CurrencyCodeType.USD);
//        AmountType amount = new AmountType();
//        amount.setValue(Double.valueOf(998));
//        item.setStartPrice(amount);
//
//        //上市时间
//        item.setListingDuration(ListingDurationCodeType.DAYS_3.value());
//
//        //  项目地点和国家
//        item.setCountry(CountryCodeType.US);
//        item.setLocation("SJC");
//
//        //  分类
//        CategoryType cat = new CategoryType();
//        cat.setCategoryID("357");
//        item.setPrimaryCategory(cat);
//
//        // 库存数量
//        item.setQuantity(new Integer(1));
//
//        // 付款方式
//        item.setPaymentMethods(new BuyerPaymentMethodCodeType[]{BuyerPaymentMethodCodeType.PAY_PAL});
//        //设置 setPayPal 付款方式
//        item.setPayPalEmailAddress("888@yirose.com");
//
//        //  item 状态, 全新(1000)
//        item.setConditionID(1000);
//
//        // 需要处理时间
//        item.setDispatchTimeMax(Integer.valueOf(1));
//
//        // 运输细节
//        item.setShippingDetails(buildShippingDetails());
//
//        // 退货政策
//        ReturnPolicyType returnPolicy = new ReturnPolicyType();
//        returnPolicy.setReturnsAcceptedOption("ReturnsAccepted");
//        item.setReturnPolicy(returnPolicy);
//
//        return item;
//    }
//
//    /**
//     * 构建产品运输细节
//     * @return ShippingDetailsType 对象
//     */
//    private static ShippingDetailsType buildShippingDetails() {
//
//        // 运输细节
//        ShippingDetailsType sd =new ShippingDetailsType();
//
//        sd.setApplyShippingDiscount(new Boolean(true));
//        AmountType amount =new AmountType();
//        amount.setValue(2.8);
//        sd.setPaymentInstructions("eBay Java SDK 测试指令.");
//
//        // 选择航运类型和航运服务
//        sd.setShippingType(ShippingTypeCodeType.FLAT);
//        ShippingServiceOptionsType shippingOptions  = new ShippingServiceOptionsType();
//        shippingOptions.setShippingService(ShippingServiceCodeType.SHIPPING_METHOD_STANDARD.value());
//
//        //amount = new AmountType();
//        amount.setValue(2.0);
//        shippingOptions.setShippingServiceAdditionalCost(amount);
//
//        //amount  = new AmountType();
//        amount.setValue(10);
//        shippingOptions.setShippingServiceCost(amount);
//        shippingOptions.setShippingServicePriority(new Integer(1));
//
//        //amount  = new AmountType();
//        amount.setValue(1);
//        shippingOptions.setShippingInsuranceCost(amount);
//
//        sd.setShippingServiceOptions(new ShippingServiceOptionsType[]{shippingOptions});
//
//        return sd;
//    }
//
//    public static void main(String[] args) {
//        try {
//
//            System.out.println(" ");
//            System.out.println("+++++++++++++++++++++++++++++++++++++++ ");
//            System.out.println("+ 欢迎使用eBay API  JAVA实例 + ");
//            System.out.println("+  - ConsoleAddItem   + ");
//            System.out.println("+++++++++++++++++++++++++++++++++++++++ ");
//            System.out.println(" ");
//
//            // [Step 1] eBay ApiContext 对象初始化
//            System.out.println("==== [1] 帐户信息  ====");
//            ApiContext apiContext = getApiContext();
//
//            // [Step 2] 创建新的 item 对象
//            System.out.println("==== [2] Item信息  ====");
//            ItemType item = builItem();
//
//            // [Step 3] 创建调用对象并执行调用
//            System.out.println("==== [3] 执行API调用  ====");
//            System.out.println("开始调用eBay API，请稍候…  ");
//            AddItemCall api = new AddItemCall(apiContext);
//            api.setItem(item);
//            FeesType fees = api.addItem();
//            System.out.println("调用eBay API结束，显示调用结果…");
//            System.out.println();
//
//            // [Step 4] 显示结果
//            System.out.println("Listing已成功发布！");
//
//            double listingFee = eBayUtil.findFeeByName(fees.getFee(), "ListingFee").getFee().getValue();
//            System.out.println("Listing 费用是:" + new Double(listingFee).toString());
//            System.out.println("Listed Item ID:" + item.getItemID());
//
//        } catch (Exception e) {
//            System.out.println("错误！没有发布Listing");
//            e.printStackTrace();
//        }
//    }
//}
