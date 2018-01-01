package com.cit.productsocial;

import com.cit.productsocial.utils.social.facebook.FacebookClient;
import com.cit.productsocial.utils.social.object.PostDataObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProductSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSocialApplication.class, args);

		String accessToken = "EAACx7xEGZBokBACOFWzhTDxGfRtIVctDNx5444qZCAYtMBDOGb4fvSZByjtcNx0zPaWY9g1tyOIulukiNgJlocgZBxevZAIBZB4ZAqRW3LnB0abS3RurjvdTw97hTUv1oG5zrdeIrecSiYRQchkl9rtmwanthGDLu3FZA5ws37Jcdmf0M0nrzBLjgDs6OLQTCGZCRZBK5fWxKBpG0Qm8qkVBFYIRR4Y7Bgnv8wOpxeCpGIBgZDZD";
		Demo demo = new Demo(accessToken);

		String pageId = "me";
		demo.postProductToUserFeed(pageId);

//		demo.getFriendTags();
//		demo.getUserLikes();

//		pageId = "161711811121480";
//		demo.postProductToGroupFeed(pageId);

//		demo.getComments("");
//		demo.deletePost("");
	}
}
