package kr.perfume.usermodule.service;

import kr.perfume.commonmodule.exception.PerfumeApplicationException;
import kr.perfume.usermodule.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.perfume.commonmodule.dto.response.UserResponseDto;
import kr.perfume.usermodule.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(User::toDto).orElse(null);
    }

}
