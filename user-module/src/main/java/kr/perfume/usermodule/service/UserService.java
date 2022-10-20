package kr.perfume.usermodule.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.perfume.commonmodule.dto.response.UserResponseDto;
import kr.perfume.usermodule.entity.User;
import kr.perfume.usermodule.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	public UserResponseDto getUser(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("No user"))
			.toDto();
	}
}
