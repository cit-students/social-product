package com.cit.productsocial.utils.social.facebook.object;

import com.cit.productsocial.utils.social.data.UserObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FriendTag extends UserObject {
    private String tagId;
    private String avatarSmallUrl;

    public FriendTag() {
        super();
    }

    public FriendTag(String tagId, String name, String avatarSmallUrl) {
        this.tagId = tagId;
        this.setName(name);
        this.avatarSmallUrl = avatarSmallUrl;
    }

    public FriendTag(String tagId, String avatarSmallUrl) {
        this.tagId = tagId;
        this.avatarSmallUrl = avatarSmallUrl;
    }
}
