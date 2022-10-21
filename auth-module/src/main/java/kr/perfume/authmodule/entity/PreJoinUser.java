package kr.perfume.authmodule.entity;


import kr.perfume.authmodule.auth.userInfo.OAuth2UserInfo;
import kr.perfume.commonmodule.enums.ProviderType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "pre_join_user")
public class PreJoinUser {

    @Id
    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "user_id", length = 64, unique = true)
    @NotNull
    @Size(max = 64)
    private String userId;

    @Column(name = "username", length = 100)
    @NotNull
    @Size(max = 100)
    private String username;

    @Column(name = "email", length = 512, unique = true)
    @NotNull
    @Size(max = 512)
    private String email;

    @Column(name = "provider_type", length = 20)
    @Enumerated(EnumType.STRING)
    private ProviderType providerType;

    @Column(name = "profile_image_url", length = 512)
    @Size(max = 512)
    private String profileImageUrl;

    @Builder
    public PreJoinUser(String userUuid, String userId, String username, String email, ProviderType providerType, String profileImageUrl) {
        this.userUuid = userUuid;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.providerType = providerType;
        this.profileImageUrl = profileImageUrl;
    }

    public PreJoinUser(OAuth2UserInfo info, ProviderType provider, String uuid) {
        this.userUuid = uuid;
        this.userId = info.getId();
        this.username = info.getName();
        this.email = info.getEmail();
        this.providerType = provider;
        this.profileImageUrl = info.getImageUrl();
    }
}