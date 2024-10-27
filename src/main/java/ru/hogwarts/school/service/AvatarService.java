package ru.hogwarts.school.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;

public interface AvatarService {
   Avatar uploadAvatar(Long studentId, MultipartFile avatar) throws IOException;
   Avatar findAvatar(Long avatarId);

}
