package com.example.giftsertifikate.service.tag;

import com.example.giftsertifikate.entity.GiftSertificate;
import com.example.giftsertifikate.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagService {
    Tag add(Tag tag);
    void changes(List<Tag> tags, GiftSertificate giftSertificate);

}
