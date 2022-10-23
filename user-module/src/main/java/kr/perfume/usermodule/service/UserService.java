package kr.perfume.usermodule.service;

import kr.perfume.commonmodule.dto.UserDto;
import kr.perfume.commonmodule.entity.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.perfume.usermodule.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(User::toDto).orElse(null);
    }

    public Long join(UserDto user) {
        User userEntity = user.toEntity();
        User savedUser = userRepository.saveAndFlush(userEntity);
        return savedUser.getUserSeq();
    }
}
