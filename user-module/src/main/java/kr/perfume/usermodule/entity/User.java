package kr.perfume.usermodule.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import kr.perfume.commonmodule.dto.response.UserResponseDto;
import kr.perfume.commonmodule.enums.ProviderType;
import kr.perfume.commonmodule.enums.RoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user_table")
@ToString
public class User {

	@JsonIgnore
	@Id
	@Column(name = "user_seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userSeq;

	@Column(name = "user_id", length = 64, unique = true)
	@NotNull
	@Size(max = 64)
	private String userId;

	@Column(name = "username", length = 100)
	@NotNull
	@Size(max = 100)
	private String username;

	@JsonIgnore
	@Column(name = "password", length = 128)
	@NotNull
	@Size(max = 128)
	private String password;

	@Column(name = "email", length = 512, unique = true)
	@NotNull
	@Size(max = 512)
	private String email;

	@Column(name = "email_verified_yn", length = 1)
	@NotNull
	@Size(min = 1, max = 1)
	private String emailVerifiedYn;

	@Column(name = "profile_image_url", length = 512)
	@Size(max = 512)
	private String profileImageUrl;

	@Column(name = "provider_type", length = 20)
	@Enumerated(EnumType.STRING)
	private ProviderType providerType;

	@Column(name = "role_type", length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull
	private RoleType roleType;

	@Builder
	public User(Long userSeq, String userId, String username, String password, String email, String emailVerifiedYn,
		String profileImageUrl, ProviderType providerType, RoleType roleType) {
		this.userSeq = userSeq;
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.emailVerifiedYn = emailVerifiedYn;
		this.profileImageUrl = profileImageUrl;
		this.providerType = providerType;
		this.roleType = roleType;
	}

	public UserResponseDto toDto() {
		return UserResponseDto.builder()
			.userSeq(this.getUserSeq())
			.email(this.getEmail())
			.name(this.getUsername())
			.build();
	}
}
