package com.cit.productsocial;

import com.cit.productsocial.utils.social.facebook.FacebookClient;
import com.cit.productsocial.utils.social.object.CommentObject;
import com.cit.productsocial.utils.social.object.PostDataObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    FacebookClient fbClient;
    PostDataObject productData;

    public Demo(String accessToken) {
        fbClient = new FacebookClient(accessToken);
        fakeData();
    }

    public void postProductToUserFeed(String pageId) {
        /* New data */
        System.out.println("Start post to user feed...");
        System.out.println(">>> Result Id of post: " + fbClient.postProducts(pageId, productData));
        System.out.println("End post");
    }

    public void postProductToGroupFeed(String pageId) {
        System.out.println("Start post to group...");
        System.out.println(">>> Result Id of post: " + fbClient.postProducts(pageId, productData));
        System.out.println("End post");
    }

    void getComments(String postId) {
        /* Get list comment of the post */
        System.out.println("------------- Get Comments ---------------");
        for (CommentObject comment : fbClient.getListComments(postId)) {
            System.out.println("Create At: " + comment.getCreateAt());
            System.out.println("ID: " + comment.getId());
            System.out.println("From: " + comment.getUserName() + " - id: " + comment.getUserId());
            System.out.println("Message: " + comment.getMessage());
        }
    }

    void checkToken() {
        System.out.println("Start checking access_token....");
        if (fbClient.isTokenValid()) {
            System.out.println("Access_token valid");
            return;
        }
        System.out.println("Invalid access_token\n");
    }

    void deletePost(String postId) {
        fbClient.deleteProducts(postId);
    }

    void getFriendTags() {
        System.out.println("\nFriends Tag: " + Arrays.toString(fbClient.getListFriendsTag().toArray()));
        System.out.println();
    }

    void getUserLikes() {
        System.out.println("User liked: " + Arrays.toString(fbClient.getLikes().toArray()));
    }

    void fakeData() {
        /* Data to post*/
        productData = new PostDataObject();
        String pageId = "me"; // id of page want to post - me -> current user
        String caption = "\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25 [ CẤP BÁO]";
        String name = "BÙNG NỔ BỘ SIÊU TẬP #ÁOPHAO ";
        BigDecimal price = new BigDecimal("399000");
        String url = "http://www.elle.vn/tin-lam-dep/top-hang-my-pham-han-quoc-dinh-dam-nhat";

        String description = "\uD83C\uDD7E️ Bắt đầu tư năm nay #Stylefactory sẽ chuyên sản xuất áo phao.Tất cả các mẫu áo phao bên mình đều được đặt may trực tiếp từ xưởng sản xuất theo thiết kế hàn quốc nên form dáng trẻ trung và hottrend,để phục vụ cho việc này bên mình đã phải lên kế hoạch SX từ hè\n" +
                "\uD83C\uDD7E️ Về chất lượng SP chắc ko cần phải PR nữa,vì nói nhiều lại thành thừa\uD83E\uDD23\uD83E\uDD23 hàng nghìn bạn mua dòng M-Z1 và M-Z2 bên shop rùi sẽ biết ( tham khảo album feeback áo phao và các bài post trên tường shop)\n" +
                "\uD83C\uDD7E️ về chất liệu ko thay đổi chất phao trần bông cực dày,mặc đi mưa nhỏ và đi tuyết ko bị ướt.Nơi mà các bạn đi #Nhật,#Hàn,#Nga,#SaPa ...tin tưởng đặt hàng\n" +
                "\uD83C\uDD7E️ Dòng M-Z3 shop lên kế hoạch SX cho dịp noen sẽ rất đặc biệt đây là dòng áo đôi,cả nam và nữ đều mặc được vì thế hãy tag Crush vào để cùng mặc đẹp mà ấm các mem nha\uD83D\uDE18 ( áo vẫn bán lẻ các bạn nha ) \n" +
                "Áo có 4 màu: vàng nghệ,đen,trắng,xám (ghi) là các màu hotrend năm nay và dễ mix đồ\n" +
                "\uD83C\uDD7E️ Độc quyền đặt may trực tiếp tại nơi SX,hình ảnh thật 100% ko photoshop,mỗi 01 sản phẩm shop đều up video quay cận cảnh và chụp trực tiếp SX\n" +
                "( video nợ các bạn ít hôm nữa nha:((\n" +
                "\uD83C\uDD7E️ style factory\n" +
                "Add: Đối diện tiệm giặt khô số 79 Đặng Văn Ngữ ( đầu ngõ 4C)-Đống Đa-Hà Nội\n" +
                "\uD83C\uDD7E️ ship hàng toàn quốc,nhận #SHIPCOD và hỗ trợ phí ship cho khách\n" +
                "☎️ hotline:0985004432\n" +
                "\uD83C\uDD7E️ Do lượng cmt nhiều nên để tư vấn và mua hàng nhanh các bạn inbox trực tiếp nha\n" +
                "------- Cảm ơn các bạn đã ủng hộ các dòng áo phao bên shop \uD83D\uDE18\uD83D\uDE18\uD83D\uDE18-------";

        String saleInfo = "";


        List<String> imgUrls = new ArrayList<>(); // List photos of product
        imgUrls.add("https://scontent.fdad1-1.fna.fbcdn.net/v/t1.0-9/23794967_1762447647384682_5163596779407494646_n.jpg?oh=99dcde63ac045ba4d8505531d1fabb7e&oe=5AC9FCE2");
        imgUrls.add("https://scontent.fdad1-1.fna.fbcdn.net/v/t1.0-9/23915945_1762447657384681_7183138333461060215_n.jpg?oh=b72eb8daf3a39282a45df0c62859ef0b&oe=5AB30192");
        imgUrls.add("https://scontent.fdad1-1.fna.fbcdn.net/v/t1.0-9/23795391_1762447654051348_6541236208092621469_n.jpg?oh=32b55a90515ebf09271129a12c2606ce&oe=5AC5367D");
        imgUrls.add("https://scontent.fdad1-1.fna.fbcdn.net/v/t1.0-9/23844391_1762447640718016_2120756872840372035_n.jpg?oh=cde388c3b63605360a1c14f7b2d8c1a1&oe=5AB47346");
        imgUrls.add("https://scontent.fdad1-1.fna.fbcdn.net/v/t1.0-9/23755627_1763016383994475_6427778528735994910_n.jpg?oh=6fa631530082965f4831f21f5de754fe&oe=5AC42698");
        imgUrls.add("https://scontent.fdad1-1.fna.fbcdn.net/v/t1.0-9/23905296_1763016390661141_3305795520330930910_n.jpg?oh=c1efea19c0a704332cd3e729ba019d1c&oe=5AF90B0F");
        imgUrls.add("https://scontent.fdad1-1.fna.fbcdn.net/v/t1.0-9/24293868_1765292713766842_5137256135263068559_n.jpg?oh=e21a990dca33bd84cf96a8d842b6b3ae&oe=5AC55089");
        imgUrls.add("https://scontent.fdad1-1.fna.fbcdn.net/v/t1.0-9/23755537_1762447687384678_8184268448291539274_n.jpg?oh=1ec60b5f62d55ff4cd20eb7c93b4e7c1&oe=5AB9EB50");
        imgUrls.add("https://scontent.fdad1-1.fna.fbcdn.net/v/t1.0-9/24058774_1763016423994471_3931881764636117025_n.jpg?oh=5a49787aa2d5924358316a1161c31aa6&oe=5AC75775");
        imgUrls.add("https://scontent.fdad1-1.fna.fbcdn.net/v/t1.0-9/24058774_1763016423994471_3931881764636117025_n.jpg?oh=5a49787aa2d5924358316a1161c31aa6&oe=5AC75775");

        /* Tags friends */
        String[] idTags = new String[]{"AaLdFFwp3TbqHl9laO4qyT7KNyB_GJ7LUM5MEWAJQnbYOxMUWLfmJFfpl3V9uOpgUiyMdekAe5yC3AynimrEU0ScF0GRuphv9MQHjLQFLnGCGg"};
        productData.product(caption, name, url, price, description, saleInfo, imgUrls)
                .setIdFriendTags(idTags);
    }

}
